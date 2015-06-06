/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('index',['jquery','handlebars','jquery/jquery-pagebar','jquery/jquery-pop'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	require("jquery/jquery-pagebar");//分页插件
	require("jquery/jquery-pop");//弹出框插件
	var Handlebars = require("handlebars");//handlebars模板引擎

	var USE_LOCAL_DATA = 0;//本地数据
	var USE_TEST_DATA = 1;//测试数据

	var loginUrl = "http://u.mofang.com/";//登录跳转路径
	var getFollowUrl = "http://u.mofang.com/home/area/follow"; //关注/取消关注
	var ajaxMethod="jsonp";
	if(USE_LOCAL_DATA){
		getFollowUrl='/bbs_html/statics/test/follow.json';
		loginUrl='/';
		var ajaxMethod="json";
	}
	if(USE_TEST_DATA){
		loginUrl = "http://u.test.mofang.com/";
		//var getFollowUrl = "http://u.test.mofang.com/home/area/follow?area_id=54"; //关注/取消关注
		getFollowUrl = "http://u.test.mofang.com/home/area/follow"; //关注/取消关注
	}

	getPlateInfo();
	function getPlateInfo(){
		$("body").on("click",".follow",function(){
			if(!loginStatus){
				$(".pop-login").pop({
					type:"confirm",
					msg:"请登录后继续操作",
					fnCallback: function(isTrue,msg){
						if(isTrue){
							window.location.href=loginUrl;
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
			    	console.log(res.code);
			    	if(res && !res.code){
			    		if($(_this).attr('data-dofollow')==0){
			    			$(_this).attr('data-dofollow',1);
			    		}else{
			    			$(_this).attr('data-dofollow',0);
			    		}
			    		$(".pop-post-ok").pop({
			    			msg : msgSuc
			    		});

			    		if($(_this).hasClass('followed')){
			    			$(_this).removeClass('followed');
			    			$(_this).html("+ 关注");
			    		}else{
			    			$(_this).addClass('followed');
			    			$(_this).html("已关注");
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
	$("#quan").click(function(){
		var _this = this;
		showList(_this);
		return false;
	});
	$("#time").click(function(){
		var _this = this;
		showList(_this);
		return false;
	});

	function showList(_this){
		$("#quan").removeClass('active');
		$("#time").removeClass('active');
		$(".con-nav .list").hide();
		
		if($(_this).hasClass('active')){
			$(_this).removeClass('active');
			$(_this).next(".list").hide();
		}else{
			$(_this).addClass('active');
			$(_this).next(".list").show();
		}
	}
	$(document).click(function(){
		$("#quan").removeClass('active');
		$("#time").removeClass('active');
		$(".con-nav .list").hide();
	});
});

seajs.use('index');
