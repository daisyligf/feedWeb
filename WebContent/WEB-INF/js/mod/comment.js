
/**
 * @file editor-main.js
 * @brief   editor upload mod
 * @author xukuikui
 * @version
 * @date 2015-6-1
 */

define("comment",["jquery",'handlebars','jquery/jquery-pop','jquery/jquery-form','config'],function(require, exports, module) {

    //var login = require("mf/login");
    var $ = require("jquery"),
        _h = require("handlebars");  
    require("jquery/jquery-pop");//弹出框插件
    require("jquery/jquery-form");//jquery表单ajax提交插件
    var c = require("config");
    var USE_LOCAL_DATA = 0;//本地数据
    var USE_TEST_DATA = 0;//测试数据

    //var getUrl = "";//url路径示范
    var getUserLoginStatus = c.config.userInfoUrl+"/account/status"; //获取用户的登录状态
    var getCheckCode = c.config.baseUrl + "/checkCode";//验证码校验
    var codeUrl = c.config.baseUrl + "/generageCode";//验证码url
    //var postUrl = "";//发帖
    //var relayPostUrl = "";//回复帖子

    if($("#editor-form .editor-fid").length>0){
        var localPlateUrl = c.config.baseUrl + "/forum/"+$("#editor-form .editor-fid").val() + ".html";//发帖成功，跳转的路径
        var localPostUrl = c.config.baseUrl + "/thread/"+$("#editor-form .editor-tid").val() + ".html";//编辑帖子成功，跳转的路径
    }
    
    var ajaxMethod="jsonp"; 
    if(USE_LOCAL_DATA){
        getUserLoginStatus = c.config.userInfoUrl+"/account/status"; //获取用户的登录状态
    	//getUserLoginStatus = "loginStatus";
        getCheckCode = "checkCode";
        postUrl = "newThread";//发帖
        relayPostUrl = "/bbs_html/statics/test/follow.json";//回复帖子
        
        if($("#editor-form .editor-fid").length>0){
            localPostUrl = c.config.baseUrl + "/thread/"+$("#editor-form .editor-tid").val() + ".html";//发帖成功，跳转的路径
            localPlateUrl = c.config.baseUrl + "/forum/"+$("#editor-form .editor-fid").val() + ".html";//编辑帖子成功，跳转的路径
        }

        ajaxMethod="json";
    }
    if(USE_TEST_DATA){
        getUserLoginStatus = c.config.userInfoUrl+"/account/status"; //获取用户的登录状态
    }
    var uploader, um, wordCount=5000, isCode=false;
    var isLock=false;//防止多次点击
    var loginBtn = $("#login"),
        reply = $(".reply-submit"),
        editorTit = $(".editor-title"),
        codeText = $(".code-text");

    /** FORM **/
    var editorForm = $("#editor-form"),
        tid = $(".editor-tid"),
        fid = $(".editor-fid"),
        pid = $(".editor-pid"),
        cont = $(".editor-cont"),
        tags = $(".editor-tags"),
        posttit = $(".editor-title");


    var arrData = [],
        editorCont = "",
        feedFlag = 0;

    
    /**实例化编辑器**/
    function editorInit () {//{{{
    	
        um = UM.getEditor('myEditor',{
            toolbar:[
                ' bold italic underline |',
                'forecolor fontsize' ,
                'link unlink | image feed-emotion | video',
            ],
           imageUrl: c.config.baseUrl + "/upload",
           imageScaleEnabled:false
        });

        //登录判断 | video
         var textMask = $(".textmask");

        if(loginStatus) {
            textMask.hide();
            um.setEnabled()
            
        } else {
            textMask.show();
            um.setDisabled();
        }
        um.addListener( 'selectionchange', function( editor ) {
             
             wordCount = 5000-um.getContentLength(true);
             if(wordCount<0){
                $(".word-count").html("已超出"+Math.abs(wordCount)+"字");
             }else{
                $(".word-count").html("还可以输入"+wordCount+"字");
             }
             

        });
    }
    
    reply.on("click",function (){
    	subForm();
     });
    
    var keydownTimer=false;
    $(document).on("keydown",function(ev){
    	if(ev.which==13 && ev.ctrlKey){
    		
    		clearTimeout(keydownTimer);
    		keydownTimer = setTimeout(function(){
    			subForm();	
    		},200);
    		return false;
    		
    	}
    });
    function subForm(){
    	if(loginStatus){
            checkEditor();
	      } else {
	   	   $(".pop-login").pop({
					type:"confirm",
					msg:"请登录后继续操作",
					fnCallback: function(isTrue,msg,obj){
						if(isTrue){
							window.location.href=$(obj).loginUserUrl();
						}
					}
				});
	           return false;
	      }
    }
    /* 
     * @param tpl 模板字符串
     * @param data 数据对象
     * @param rendhelp 渲染块
     */
    function render (o) {//{{{
        var temp = _h.compile(o.tpl),
        html = temp(o.data);

        o.rendhelp.html(html);
        o.rendhelp.show();
    }//}}}
    //表情除理
    function replaceEm_ (str) {//{{{
        str = str.replace(/\[(.*)]/g, function(match,key){
            var src = mofang_face_map[key];
            if(src){
                return '<img style="width:24px;height:24px" src="'+src+'" border="0" />';
            }else{
                return match;
            }
        });
        return str;
    }//}}}
    
    //重新赋值
    function replaceArr (arr,val) {//{{{
        var empty =[];
        for(var i=0;i<arr.length;i++) {
            if(arr[i] != val) {
                empty.push(arr[i]);
            }
        }
        return empty;
    }//}}}
    
    function formSubmit (data) {//{{{

        //内容赋值
        cont.val(editorCont);


       //发帖回调
        var optionsPost = {
            beforeSubmit:function(){
            	isLock=true;
            },
            error:function(){
            	
                $(".pop-top-fail").pop({
                    type:"confirm",
                    msg:"网络出错，请重新发送。",
                    fnCallback: function(isTrue,msg){
                        if(isTrue){
                            editorForm.submit();
                        }
                    }
                });
                //变换验证码
                fnChangeCode();
                isLock=false;
            },
            success: function(res) {
                if(typeof res=='string'){
                    res=$.parseJSON(res);
                }
                
                if(res && res.code==0){
                	
                    $(".pop-post-ok").pop({
                        msg: "发帖成功",
                        autoTime:500,
                        fnCallback: function(isTrue,msg){
                        	isLock=true;
                        	if(editorForm.attr("data-tid")==0){
                                window.location.href=localPlateUrl;
                            }else{
                                window.location.href=localPostUrl;  
                            }
            			}
                    }); 
                    setTimeout(function(){
                        if(editorForm.attr("data-tid")==0){
                            window.location.href=localPlateUrl;
                        }else{
                            window.location.href=localPostUrl;  
                        }
                        
                    },500); 
                }else{
                    $(".pop-top-fail").pop({
                        type:"confirm",
                        msg:res.message,
                        fnCallback: function(isTrue,msg){
                            if(isTrue){
                                editorForm.submit();
                                
                            }
                        }
                    });
                    //变换验证码
                    fnChangeCode(); 
                }
                isLock=false;
                  
            }
        };
        //回复帖子回调
        var optionsReplayPost = {
            beforeSubmit:function(){
            	isLock=true;
            },
            error:function(){
               $(".pop-top-fail").pop({
                    msg: "回复失败",
                    autoTime:500
                }); 
               
               isLock=false;
            },
            success:function(res) {
                if(typeof res=='string'){
                    res=$.parseJSON(res);
                }
               
            	
                if(res && res.code==0){
                	var maxUrl = $(".editer").attr("data-maxurl");
                 	var reUrl = maxUrl.replace(/currentPage\=[0-9]*/ig,function(word){
                 		return "currentPage="+res.totalPages;
                 	});
                 	
                    $(".pop-post-ok").pop({
                        msg: "回复成功",
                        autoTime:500,
                        fnCallback: function(isTrue,msg){
                        	isLock=true;
                        	
                        	if($(".editer").length != 0){
                        		location.href=reUrl;
                        	}else{
                        		window.location.reload();
                        	}
            			}
                    });
                    setTimeout(function(){
                    	if($(".editer").length != 0){
                    		location.href=reUrl;
                    	}else{
                    		window.location.reload();
                    	}
                    },600);
                }else{
                    $(".pop-top-fail").pop({
                        msg: "回复失败",
                        autoTime:500
                    });
                }
                isLock=false;
            }
        };
        //回复帖子
        if(editorForm.attr('data-form')=='replayPost'){
            // 将options传给ajaxForm
            editorForm.ajaxForm(optionsReplayPost);
            editorForm.submit();
            return false;
        }

        //发帖
        if(editorForm.attr('data-form')=='post'){
            // 将options传给ajaxForm
            editorForm.ajaxForm(optionsPost);
            //标签
            if(tags.length){
                tags.val($(".sel-one").attr("data-tagsId"));
            }
            
            //标题
            if(posttit.length) {
                posttit.val($.trim(editorTit.val()));
            }
            //验证码
            if(codeText.length){
            	var codeVal = $.trim($(".code-text").val());
                $.ajax({
                    url:getCheckCode,
                    type:"GET",
                    data:{
                    	code: codeVal
                    },
                    dataType:'json',
                    success: function(res) {
                        if(res && !res.code){
                            editorForm.submit();
                        }else{
                            $(".pop-top-fail").pop({
                                msg: res.message,
                                autoTime:500
                            });

                            //变换验证码
                            fnChangeCode(); 
                        }
                        isLock=false;
                    },
                    error: function() {
                        $(".pop-top-fail").pop({
                            msg: "验证码错误",
                            autoTime:500
                        });
                        //变换验证码
                        fnChangeCode();
                        isLock=false;
                    }
                });
                return false;
            }
           
            // 将options传给ajaxForm
            editorForm.submit();
            return false;
        }
        
        
    }

    function rgb2hex(rgb) {//{{{
        rgb = rgb.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
        function hex(x) {
            return ("0" + parseInt(x).toString(16)).slice(-2);
        }
        return "#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]);
    }//}}}
    /**内容检查**/
    function checkEditor (status) {
    	
         if(editorTit.length) {
            if($.trim(editorTit.val()) == "" || editorTit.val() == "请填写标题，限30字以内") {
                $(".pop-top-fail").pop({
                    msg: "标题不能空",
                    autoTime:500
                });
                editorTit.focus();
                return false;
            }else if($.trim(editorTit.val()).length > 30) {
                
                $(".pop-top-fail").pop({
                    msg: "标题过长",
                    autoTime:500
                });
                return false;
            }

        }
        wordCount = 5000-um.getContentLength(true);
        if(wordCount<0){
            $(".pop-top-fail").pop({
                msg: "内容超出字数",
                autoTime:500
            });
            return false;
        }else if(wordCount>4990){
            $(".pop-top-fail").pop({
                msg: "内容少于10个字",
                autoTime:500
            });
            return false;
        }
        var umContText =  $.trim(um.getContent());//获取内容
        editorCont = filterSpan(umContText);
        if(isLock){
    		return false;
    	}
        formSubmit();
        
    }

    function filterSpan (editorCont) {
        var node = $('<div></div>').html(editorCont);
        node.find('span').each(function(){
            var span = $(this);
            if(span.attr('color')||span.css("font-size")||span.css("color")){

                if(span.css("color")) {
                    if(span.css("color").indexOf("rgb") > -1) {
                        span.attr('color',rgb2hex(span.css("color")));
                    } else {
                        span.attr('color',span.css("color"));
                    }
                    span.css("color","");
                }

                if(span.css("font-size")){
                    var duiying = {"10px":1, "12px":2, "16px":3, "18px":4, "24px":5, "32px":6, "48px":7};
                    span.attr('size',duiying[span.css("font-size")]);
                    span.css("font-size","");

                }
                span.removeAttr("style")
            }

        });
        var totalSpan = $("<div></div>").append(node).html();
        totalSpan = replaceSpan(totalSpan);
        totalSpan = replaceP2Br(totalSpan);

        function replaceSpan (html) {
            html = html.replace(/undefined/gi,'');
            html = html.replace(/<span/gi,'<font');
            html = html.replace(/<\/span>/gi,'<\/font>');
            html = html.replace(/<strong/gi,'<b');
            html = html.replace(/<\/strong>/gi,'<\/b>');
            html = html.replace(/<em>/gi,'<i>');
            html = html.replace(/<\/em>/gi,'<\/i>');
            return html;
        }
        function replaceP2Br (html) {
            var reg = /<p><br><\/p>/ig;
            html = html.replace(reg,function($1,$2){
                return '<br />';
            });
            var reg2 = /<br[ \/]*><\/p>/ig;
            html = html.replace(reg2,function($1,$2){
                return '</p>';
            });
            html = html.replace(/<\/p>/gi,'<br><\/p>');
            html = html.replace('<br>','<br />');
            return html;
        }
        return totalSpan;

    }
   
    //点击变换验证码
    $(".code").click(function(){
        fnChangeCode();
    });
    //变换验证码
    function fnChangeCode(){
        var  rand_num = Math.random();
        $('.code').attr("src",codeUrl+'?time='+rand_num);
    }

    //下拉框
    $(".sel-one").click(function(){
        var _this = this;
        showList(_this);
        choice(_this);
        $(".con .title-type").css({
        	'z-index':"1100"
        });
        return false;
    });
    function showList(_this){

        $(".sel-one").next(".sel-more").hide();
        if($(_this).hasClass('active')){
            $(_this).removeClass('active');
            $(_this).next(".sel-more").hide();
        }else{
            $(_this).addClass('active');
            $(_this).next(".sel-more").show();
        }
        
    }
    function choice(_this){
        $(_this).next(".sel-more").find("a").unbind("click").bind("click",function(){
            var _v = $(this).html();
            var _vtagsId = $(this).attr("data-tagsid");
            var _vshow = $(_this).html();
            var _vshowTagsId = $(_this).attr("data-tagsid");
            $(_this).html(_v);
            $(this).html(_vshow);
            $(_this).attr("data-tagsid",_vtagsId);
            $(this).attr("data-tagsid",_vshowTagsId);
            $(".sel-one").removeClass('active');
            $(".sel-one").next(".sel-more").hide();
            $(".con .title-type").css({
            	'z-index':"1000"
            });
            return false;
        });
    }
    $(document).click(function(){
        $(".sel-one").removeClass('active');
        $(".sel-one").next(".sel-more").hide();
        $(".con .title-type").css({
        	'z-index':"1000"
        });
    });
   
    $(function () {
        $.ajax({
            url:getUserLoginStatus,
            type:"GET",
            dataType:ajaxMethod,
            data:{
            },
            success: function(res) {
                if(res && res.code==0){
                    window.loginStatus=true;
                }else{
                    window.loginStatus=false;
                }
                editorInit();
            },
            error: function() {
            	editorInit();
            }
        });
        // 初始化表情盒子
        //$('.emotion').qqFace({
            //id: 'facebox',
            //assign: 'saytext',
            //path: '/assets/chat/img/face/'
            ////callback: function (face) {
                //////um.setContent(um.getContent()+face);
            ////}
        //});
    });

});

seajs.use("comment");
