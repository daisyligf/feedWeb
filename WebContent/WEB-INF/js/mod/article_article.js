/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('article_article',['jquery','handlebars','jquery/jquery-pagebar','jquery/jquery-pop'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	require("jquery/jquery-pagebar");//分页插件
	require("jquery/jquery-pop");//弹出框插件
	var Handlebars = require("handlebars");//handlebars模板引擎获取登录状态

	var USE_LOCAL_DATA = 0;//本地数据
	var USE_TEST_DATA = 1;//测试数据

	
	var getFloorComUrl = ""; //获取楼层评论数据
	var setAddPostUrl = "";//回复帖子接口
	var setReplyPostUrl = ""; //回复楼层数据
	var setDelFloorUrl = ""; //删除楼层接口
	var setPraThreadUrl = ""; // 点赞帖子接口
	var setPraFloorUrl = ""; //点赞楼层接口
	var setLockPostUrl = ""; //锁帖
	var setOffLockPostUrl = ""; //取消锁帖
	var setTopPostUrl = ""; //置顶帖子
	var setOffTopPostUrl = ""; //取消置顶
	var setAddDigestUrl = ""; //加精
	var setOffAddDigestUrl = "";//取消加精
	var setdeletePostUrl = ""; //删除帖子
	var setAddDigestUrl = ""; //奖励
	var deleteHrefUrl = "forum_content?fid"+$("#getPostData").attr("data-fid");//删除帖子跳转的路径

	var ajaxMethod="json";
	if(USE_LOCAL_DATA){
		getFloorComUrl='/bbs_html/statics/test/get_floor_comment.json';//楼层评论列表
		setReplyPostUrl='/bbs_html/statics/test/setReplyPost.json';//回复帖子接口
		setDelFloorUrl='/bbs_html/statics/test/follow.json';//删除楼层接口
		setPraFloorUrl = "/bbs_html/statics/test/follow.json"; //点赞楼层接口
		setLockPostUrl = "/bbs_html/statics/test/follow.json"; //锁帖
		setOffLockPostUrl = "/bbs_html/statics/test/follow.json"; //取消锁帖
		setTopPostUrl = "/bbs_html/statics/test/follow.json"; //置顶帖子
		setOffTopPostUrl = "/bbs_html/statics/test/follow.json"; //取消置顶
		setAddDigestUrl = "/bbs_html/statics/test/follow.json"; //加精
		setOffAddPostUrl = "/bbs_html/statics/test/follow.json";//取消加精
		setdeletePostUrl = "/bbs_html/statics/test/follow.json"; //删除帖子
		setAddDigestUrl = "/bbs_html/statics/test/follow.json"; //奖励
		//deleteHrefUrl = "http://www.baidu.com";//删除帖子跳转的路径
	}
	if(USE_TEST_DATA){
		getFloorComUrl='comment_list.json';
		setReplyPostUrl='reply_post.json';
		setDelFloorUrl='del_floor.json';
		setPraThreadUrl = "recommend_thread.json";
		setPraFloorUrl = "recommend_floor.json"; //点赞楼层接口
		setLockPostUrl = "close_thread.json"; //锁帖
		setOffLockPostUrl = "open_thread.json"; //取消锁帖
		setTopPostUrl = "top_thread.json"; //置顶帖子
		setOffTopPostUrl = "cancel_top_thread.json"; //取消置顶
		setAddDigestUrl = "elite_thread.json"; //加精
		setOffAddPostUrl = "cancel_elite_thread.json";//取消加精
		setdeletePostUrl = "del_thread.json"; //删除帖子
		setAddDigestUrl = "award.json"; //奖励
		//deleteHrefUrl = "forum_content";//删除帖子跳转的路径
	}

	//注册一个handlebarsjs方法
	Handlebars.registerHelper("timeformat",function(value){
		//console.log(typeof value);

		var time = new Date(value*1000);

		var year = time.getFullYear();
		var month = time.getMonth()+1;
		var date = time.getDate();

		var hours = time.getHours();
		var minutes = time.getMinutes();
		var seconds = time.getSeconds();

		var str = to2(year)+'-'+to2(month)+'-'+to2(date)+' '+to2(hours)+':'+to2(minutes)+':'+to2(seconds);
		
		return str;

		function to2(n){
			return n<10 ? '0'+n : n;
		}
		
    });
    

	//帖子管理
	postManage();
	function postManage(){
		//帖子管理效果
		$(".manage").hover(function(ev){

			console.log($(this).html());
			$(".manage-more").stop().slideDown(200);
		},function(){
			$(".manage-more").stop().slideUp(200);
		});
		//锁帖/取消锁帖
		$("body").on("click",".manage-lock",function(){
			var _this =this;
			var isReturn = true;
			var url = '';
			if($(_this).hasClass('off-manege-lock')){
				url=setOffLockPostUrl;
			}else{
				url=setLockPostUrl;
			}
			var tids = $("#getPostData").attr("data-tid");
			var uid = $("#getPostData").attr("data-uid");

			
			var reason = "";

			$(".pop-post-delete").pop({
				type : 'prompt',
				title : $(_this).html()+'原因',
				fnCallback : function(isTrue,msg){
					if(isTrue){
						reason=msg;
						//发送数据
						lockFnAjax();
						
					}
				}
			});

			function lockFnAjax(){
				fnAjax(url,{
					tids : tids,
					uid : uid,
					reason : reason
				},function(res){
					if(res && res.code==0){
						if($(_this).hasClass('off-manege-lock')){
							$(".pop-post-ok").pop({
								msg:$(_this).html()+"成功"
							});

							$(_this).removeClass('off-manege-lock');
							$(_this).html("锁帖");
						}else{
							
							$(".pop-post-ok").pop({
								msg:$(_this).html()+"成功"
							});
							$(_this).addClass('off-manege-lock');
							$(_this).html("取消锁帖");
						}
					}else{
						$(".pop-top-fail").pop({
							msg:$(_this).html()+'失败'
						});
					}
				},function(res){
					$(".pop-top-fail").pop({
						msg:$(_this).html()+'失败'
					});
				});
			}
			
		});
		//置顶/取消置顶
		$("body").on("click",".manege-top",function(){
			var _this =this;

			var url = '';
			if($(_this).hasClass('off-manege-top')){
				url=setOffTopPostUrl;
			}else{
				url=setTopPostUrl;
			}
			var tids = $("#getPostData").attr("data-tid");
			var uid = $("#getPostData").attr("data-uid");
			var reason = "";


			$(".pop-post-delete").pop({
				type : 'prompt',
				title : $(_this).html()+'原因',
				fnCallback : function(isTrue,msg){
					if(isTrue){
						reason=msg;
						//发送数据
						topFnAjax();
						
					}
				}
			});



			function topFnAjax(){
				fnAjax(url,{
					tids : tids,
					uid : uid,
					reason : reason
				},function(res){
					if(res && res.code==0){
						if($(_this).hasClass('off-manege-top')){
							$(".pop-post-ok").pop({
								msg:$(_this).html()+"成功"
							});
							$(_this).removeClass('off-manege-top');
							$(_this).html("置顶");
						}else{
							$(".pop-post-ok").pop({
								msg:$(_this).html()+"成功"
							});
							$(_this).addClass('off-manege-top');
							$(_this).html("取消置顶");
						}
					}else{
						$(".pop-top-fail").pop({
							msg:$(_this).html()+"失败"
						});
					}
				},function(res){
					$(".pop-top-fail").pop({
						msg:$(_this).html()+'失败'
					});
				});

			}
			
		});
		//加精/取消加精
		$("body").on("click",".manege-great",function(){
			var _this =this;
			var url = '';
			if($(_this).hasClass('off-manege-great')){
				url=setOffAddDigestUrl;
				
			}else{
				url=setAddDigestUrl;
			}
			var tids = $("#getPostData").attr("data-tid");
			var uid = $("#getPostData").attr("data-uid");
			var reason = "";

			$(".pop-post-delete").pop({
				type : 'prompt',
				title : $(_this).html()+'原因',
				fnCallback : function(isTrue,msg){
					if(isTrue){
						reason=msg;
						//发送数据
						greatFnAjax();
						
					}
				}
			});

			function greatFnAjax(){
				fnAjax(url,{
					tids : tids,
					uid : uid,
					reason : reason
				},function(res){
					if(res && res.code==0){
						
						if($(_this).hasClass('off-manege-great')){
							$(".pop-post-ok").pop({
								msg:$(_this).html()+"成功"
							});
							$(_this).removeClass('off-manege-great');
							$(_this).html("加精");
							
						}else{
							$(".pop-post-ok").pop({
								msg:$(_this).html()+"成功"
							});
							$(_this).addClass('off-manege-great');
							$(_this).html("取消加精");
							
						}
					}else{
						$(".pop-top-fail").pop({
							msg:$(_this).html()+"失败"
						});
					}
				},function(res){
					$(".pop-top-fail").pop({
						msg:$(_this).html()+"失败"
					});
				});
			}
			
			// 帖子点赞
			$("body").on("click",".thread-zan",function(){
				var _this =this;
				var tid = $(_this).parents(".con-list").attr("data-postid");
				var uid = $(_this).parents(".con-list").attr("data-uid");

				var reason = "点赞";
				fnAjax(setPraThreadUrl,{
					tid : tid,
					uid : uid
				},function(res){
					if(res && res.code==0){
						var val = parseInt($(_this).find("a").html());
						var v = $(_this).find("a").html(val+1);
						$(".pop-post-ok").pop({
							msg:"点赞成功",
							autoTime:1000
						});
					}else{
						$(".pop-top-fail").pop({
						msg:"点赞失败",
						autoTime:1000
					});
					}
				},function(res){
					$(".pop-top-fail").pop({
						msg:"点赞失败",
						autoTime:1000
					});
				});

			});
			
		});

		//回复楼层
		$(".con-right3 .reply-textarea").click(function(){
			var tid = $("#getPostData").attr("data-tid");
			var uid = $("#getPostData").attr("data-uid");
			var fid = $("#getPostData").attr("data-fid");
			var con = $("#reply-con").val();
			var pic = [];
			fnAjax("setAddPostUrl",{
				fid : fid,
				tid : tid,
				uid : uid,
				content : con,
				pic : pic
			},function(res){
				if(res && res.code==0){
					window.reload();
				}
			},function(){

			});
		});
	}

	FloorManage();//楼层管理
	
	function FloorManage(){
		var countNum = 0;
		//点击获取评论数据
		$("body").on("click",".floor-rec",function(){
			var _this  = this;
			$(_this).hide();
			$(_this).siblings(".floor-stop").show();
			$(_this).parents(".con-list-right").find(".con-list-reply").show();
			_this.pagecur=0;
			getFloorCommentData(_this,{
				p : 1
			},function(){
				$(_this).parents(".con-list").attr("data-page",2);
			});
		});
		//点击收起
		$("body").on("click",".floor-stop",function(){
			var _this  = this;
			$(_this).hide();
			$(_this).siblings(".floor-rec").show();
			;
			$(_this).parents(".con-list-right").find(".con-list-reply").hide();
		});
		//
		//加载更多
		$("body").on("click",".floor-reply-more",function(){
			var _this  = this;
			
			getFloorCommentData(_this,{
				p : $(_this).parents(".con-list").attr("data-page")
			},function(){
				//处理pagecurrent
				var pagecur = $(_this).parents(".con-list").attr("data-page");
				$(_this).parents(".con-list").attr("data-page",pagecur++);
			})
		});

		//回复楼层效果js
		placeholder(".dianping-textarea","回复");

		/***点击回复楼层***/
		$("body").on("click",".dianping",function(){
			var _this  = this;
			var name = $(_this).attr("data-name");
	        var uid = $(_this).attr("data-uid");
	        var tid = $(_this).attr("data-tid");
	        
			var text = $(_this).parents(".con-list-right").find(".dianping-textarea");
			text.focus().val("@" + name + "：");
			$(_this).parents(".con-list-right").find(".uid").val(uid);
			$(_this).parents(".con-list-right").find(".tid").val(tid);
			$(_this).parents(".con-list-right").find(".postname").val("@" + name + "：");
			
		});

		//回复楼层ajax请求数据
		$("body").on("click",".reply-btn",function(){
			
			if(!loginStatus){
				$(".pop-top-fail").pop({
					msg:"未登录"
				});
				return false;
			}
			var _this = this;
			var tid = $(_this).parents(".reply-textarea").find(".tid").val();
			var uid = $(_this).parents(".reply-textarea").find(".uid").val();
			var postid = $(_this).parents(".con-list").attr("data-postid");
			var content = $(_this).parents(".reply-textarea").find(".dianping-textarea").val();
			var postname = $(_this).parents(".reply-textarea").find(".postname").val();
			if($.trim(content) == "回复" || $.trim(content)==postname){
				
				$(".pop-top-fail").pop({
					msg:"回复不能为空",
					autoTime:500
				});
				return false;
			}
			if(countNum<0){
				$(".pop-top-fail").pop({
					msg:"超出限制字数",
					autoTime:500
				});
				return false;
			}
			replyFloorPost(_this,{
				tid : tid,
				uid : uid,
				pid : postid,
				content : content
			});
		});

		//楼层删除
		$("body").on("click",".list-del",function(){
			var _this =this;
			var pid = $(_this).parents(".con-list").attr("data-postid");
			var uid = $(_this).parents(".con-list").attr("data-uid");

			var reason = "我想删除";
			fnAjax(setDelFloorUrl,{
				pid : pid,
				uid : uid,
				reason : reason
			},function(res){
				if(res && res.code==0){
					$(_this).parents(".con-list").slideUp(400,function(){
						$(this).remove();
					});
					
					$(".pop-post-ok").pop({
						msg:"删除成功",
						autoTime:1000
					});

				}else{
					$(".pop-top-fail").pop({
						msg:"删除失败",
					autoTime:1000
					});
				}
			},function(res){
				$(".pop-top-fail").pop({
					msg:"删除失败",
					autoTime:1000
				});
			});

		});
		//楼层点赞
		$("body").on("click",".zan",function(){
			var _this =this;
			var pid = $(_this).parents(".con-list").attr("data-postid");
			var uid = $(_this).parents(".con-list").attr("data-uid");

			var reason = "点赞";
			fnAjax(setPraFloorUrl,{
				pid : pid,
				uid : uid
			},function(res){
				if(res && res.code==0){
					var val = parseInt($(_this).find("a").html());
					var v = $(_this).find("a").html(val+1);
					$(".pop-post-ok").pop({
						msg:"点赞成功",
						autoTime:1000
					});
				}else{
					$(".pop-top-fail").pop({
					msg:"点赞失败",
					autoTime:1000
				});
				}
			},function(res){
				$(".pop-top-fail").pop({
					msg:"点赞失败",
					autoTime:1000
				});
			});

		});
		
		//检测回复楼层文本框变化

		$("body").on("input propertychange click keyup",".dianping-textarea",function(){
			var _this = this;
			countNum = 140-$(_this).val().length;
			if(countNum<0){
				$(".replay-count").html("已超出"+Math.abs(countNum)+"字");
			}else{
				$(".replay-count").html("还可以输入"+countNum+"字");
			}
			

		});

	}

	//获取楼层评论数据
	function getFloorCommentData(obj,options,fnCallback){

		var defaults = {
			postid : $(obj).parents(".con-list").attr("data-postid"),
			p : 1,
			pagesize : 10
		};
		options = $.extend(true, defaults, options);

		$.ajax({
		    url:getFloorComUrl,
		    type:"POST",
		    dataType:ajaxMethod,
		    data:options,
		    success: function(res) {
		    	if(res && !res.code){
		    		var floorCommentTemplate = Handlebars.compile($("#floorCommentTemplate").html());
		    			
		    		if(res.data.comments.total<=0){
		    			$(obj).parents(".con-list-right").find(".floor-reply-more").html("");
		    		}else{
		    			$(obj).parents(".con-list-right").find(".floor-reply-more").html("更多"+res.data.comments.total+"条回复    <a href='javascript:;''>点击加载</a>");
		    		}
		    		
		    		$(obj).parents(".con-list-right").find(".con-list-replycon").append(floorCommentTemplate(res.data.commentlist));
		    	}
		    	fnCallback && fnCallback();
		    },
		    error: function() {
		    	$(".pop-top-fail").pop({
					msg:"加载失败",
					autoTime:1000
				});
		    },
		    complete: function(){
		    	
		    }
		});
	}

	//回复楼层
	function replyFloorPost(obj,options){
		$.ajax({
		    url:setReplyPostUrl,
		    type:"POST",
		    dataType:ajaxMethod,
		    data:options,
		    success: function(res) {
		    	if(res && !res.code){
		    		var floorCommentTemplate = Handlebars.compile($("#floorCommentTemplate2").html());

		    		console.log(floorCommentTemplate(res.data));
		    		$(obj).parents(".con-list-right").find(".con-list-replycon").append(floorCommentTemplate(res.data));
		    		$(obj).parents(".con-list-right").find(".dianping-textarea").val('回复');
		    		$(".pop-post-ok").pop({
						msg:"回复成功"
					});

		    	}else{
		    		$(".pop-top-fail").pop({
						msg:"回复失败"
					});
		    	}

		    },
		    error: function() {
		    	$(".pop-top-fail").pop({
					msg:"回复失败"
				});
		    },
		    complete: function(){
		    	
		    }
		});
	}

	//ajax公用(点赞...)
	function fnAjax(url,options,sucFn,errFn){
		$.ajax({
		    url:url,
		    type:"POST",
		    dataType:ajaxMethod,
		    data:options,
		    success: function(res) {
		    	sucFn && sucFn(res);
		    },
		    error: function() {
		    	errFn && errFn();
		    },
		    complete: function(){
		    	
		    }
		});
	}
	
	function placeholder(dom,txt) {//{{{
        $("body").on('focus',dom, function() {
            $(this).css("color","#000")
            if(txt) {
                 $(this).data('defaultText', txt);
            }
           if (!$(this).data('defaultText')) {
                 $(this).data('defaultText', $(this).val());
            }
            if ($(this).val()==$(this).data('defaultText')) {
                $(this).val('');
            }

        });
        $("body").on('blur',dom, function() {
             $(this).css("color","#ccc")
            if ($(this).val()=='') {
                $(this).val($(this).data('defaultText')); 
            }
        });
    }


});

seajs.use('article_article');
