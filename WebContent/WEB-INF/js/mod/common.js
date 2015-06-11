/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('common',['jquery','login_top','loginUserUrl'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	var login_top = require("login_top");
	require("loginUserUrl");//跳转登录路径
	

	//移动端顶部效果
	$(".header .nav-wap-left a").on("touchstart",function(){

		if($(this).hasClass('active')){
			$(this).removeClass('active');
			$(".header .nav-info").fadeOut(200);
		}else{
			$(this).addClass('active');
			$(".header .nav-info").fadeIn(200);
		}
	});
	//消息

	//退出
	$(document).on("click","#logout",function(){
		
		login_top.logout();

	});
	
	//search 头部搜索
	search();
	function search(){
		$(document).keydown(function(ev) {
			if(ev.which == 13){
				searchJumpUrl();
			}
		});
		$("#submit").click(function(ev) {
			searchJumpUrl();
			
		});
	}

	function searchJumpUrl(){

		var keyword = $.trim($("#keyword").val());
		$("#keyword").css({
			border:'1px solid #eee'
		});
		if(keyword==''){
			return false;
		}

		window.location.href = "search?keyword="+encodeURIComponent(keyword);
	}

	//头部登录跳转
	if($(".header .load").length>0){
		$(".header .load").loginUserUrl();
	}
	
	//编辑框登录跳转
	if($(".maskLogin").length>0){
		$(".maskLogin").loginUserUrl();
		$(".maskReg").loginUserUrl();
	}
	
		
});


seajs.use('common');