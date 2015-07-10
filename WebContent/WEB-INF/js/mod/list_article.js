/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('index',['jquery','handlebars','jquery/jquery-pagebar','jquery/jquery-pop','config'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	require("jquery/jquery-pagebar");//分页插件
	require("jquery/jquery-pop");//弹出框插件
	var Handlebars = require("handlebars");//handlebars模板引擎
	var c = require("config");
	var USE_LOCAL_DATA = 0;//本地数据
	var USE_TEST_DATA = 0;//测试数据

	//var getFollowUrl = "http://u.mofang.com/home/area/follow"; //关注/取消关注
	var getFollowUrl = c.config.userInfoUrl + "/home/area/follow"; //关注/取消关注
	var getSignUrl = "addSignIn";//签到
	var ajaxMethod="jsonp";
	if(USE_LOCAL_DATA){
		getFollowUrl='/bbs_html/statics/test/follow.json';
		getSignUrl='/bbs_html/statics/test/follow.json';
		var ajaxMethod="json";
	}
	if(USE_TEST_DATA){
		getFollowUrl = c.config.userInfoUrl + "/home/area/follow"; //关注/取消关注
	}

	getPlateInfo();
	function getPlateInfo(){
		$("body").on("click",".follow",function(){
			if(!loginStatus){
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
			var _this = this;
			var msgSuc = '',
				msgErr = '';
			if($(_this).hasClass('followed')){
				msgSuc = '取消关注成功';
				msgErr = '取消关注失败'
			}else{
				msgSuc = '关注成功';
				msgErr = '关注失败';

			}

			$.ajax({
			    url:getFollowUrl,
			    type:"GET",
			    dataType:ajaxMethod,
			    data:{
			    	area_id:$(_this).attr('data-areaid'),
			    	dofollow:$(_this).attr('data-dofollow')
			    },
			    success: function(res) {
			    	if(res && !res.code){
			    		if($(_this).attr('data-dofollow')==0){
			    			$(_this).attr('data-dofollow',1);
			    		}else{
			    			$(_this).attr('data-dofollow',0);
			    		}
			    		$(".pop-post-ok").pop({
			    			msg : msgSuc
			    		});
			    		var num = parseInt($(".follow-num").html());
			    		if($(_this).hasClass('followed')){
			    			$(_this).removeClass('followed');
			    			$(_this).html("+ 关注");
			    			num--;
			    			$(".follow-num").html(num);
			    		}else{
			    			$(_this).addClass('followed');
			    			$(_this).html("已关注");
			    			num++;
			    			$(".follow-num").html(num);
			    		}
			    	}else if(res && res.code==969){
			    		$(".pop-warn").pop({
							type:"confirm",
							title:"关注过多",
							msg:"您目前关注的游戏版块已经超过100，为了给您提供更好的服务，请取消部分历史关注之后，重新关注此版块",
							fnCallback: function(isTrue,msg){
								if(isTrue){
									window.location.href="http://u.mofang.com/home/footprints/follow";
								}
							}
						});
			    	}else{
			    		$(".pop-top-fail").pop({
			    			msg : msgErr
			    		});
			    	}
			    },
			    error: function() {
			    	$(".pop-top-fail").pop({
		    			msg : msgErr
		    		});
			    },
			    complete: function(){
			    	
			    }
			});
		});
		
	}

	//下拉框
	$("#quan").hover(function(){
		$(this).find(".list").show();
	},function(){
		$(this).find(".list").hide();
	});

	$("#time").hover(function(){
		$(this).find(".list").show();
	},function(){
		$(this).find(".list").hide();
	});
	
	//页面标签处理
	var tagId = $('#tag_id').val();
	if (tagId != '' && tagId > 0) {
		$("#tag_" + tagId).addClass('active');
	} else {
		$("#tag_all").addClass('active');
	}
	//发帖按钮处理
	postUrl();
	function postUrl(){
		$(".get-post").click(function(){
			var _this = this;
			
			var url = $(_this).attr("data-href");
			if(!loginStatus){
				
				$(".pop-login").pop({
					type:"confirm",
					msg:"请登录后继续操作",
					fnCallback: function(isTrue,msg,obj){
						if(isTrue){
							window.location.href=$(obj).loginUserUrl(url);
						}
					}
				});
				return false;
			}
			
		});
		$(".apply-mod").click(function(){
			var _this = this;
			
			if(!loginStatus){
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
			
		});
		
		
	}
	
	//签到
	fnSign();
	function fnSign(){
		$(".sign-btn").click(function(){
			
			$.ajax({
			    url:getSignUrl,
			    type:"GET",
			    dataType:'json',
			    data:{},
			    success: function(res) {
			    	
			    	if(null != res && 0 == res.code){
			    		$(".pop-post-ok").pop({
			    			msg : "签到成功"
			    		});
			    		$(".sign-off").removeClass("hide").addClass("show");
			    		$(".sign-btn").removeClass("show").addClass("hide");
			    		$(".sign-off span").html("连续"+res.data.days+"天");
			    		$(".sign-rank span").html(res.data.rank);
			    		$(".sign-off-num").html("已签"+res.data.totalMember+"人");
			    	}else{
			    		$(".pop-top-fail").pop({
			    			msg : res.message
			    		});
			    	}
			    },
			    error: function() {
			    	$(".pop-top-fail").pop({
		    			msg : "签到失败"
		    		});
			    },
			    complete: function(){
			    	
			    }
			});
		});
	}
	
		
});

seajs.use('index');
