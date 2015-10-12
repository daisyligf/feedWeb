/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('common',['jquery','login_top','loginUserUrl','jquery/moveTop','ad','config'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	var login_top = require("login_top");
	var c = require("config");
	
	require("loginUserUrl");//跳转登录路径
	require("jquery/moveTop");//回到顶部
	require("ad");//广告展示
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
	
	
	function search(){
		$("#keyword").keydown(function(ev) {
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
		var defKeyword = $.trim($("#keyword").attr("data-default"));
		$("#keyword").css({
			border:'1px solid #eee'
		});
		if(keyword==''){
			keyword = defKeyword;
		}

		window.location.href = c.config.baseUrl + "/search?keyword="+encodeURIComponent(keyword);
	}

	
	
	//编辑框登录跳转
	$(function(){
		$(".maskLogin").loginUserUrl();
		$(".maskReg").loginUserUrl();
		//头部登录跳转
		$(".header .load").loginUserUrl();
		$(".header .no-login-login").loginUserUrl();
		$(".header .no-login-reg").loginUserUrl();
		$(".header .wap-load").loginUserUrl();
		//search 头部搜索
		search();
		//侧边栏回到顶部
		fnRightNav();
		//M版a标签的替换
		replaceA()
	});
	
	
	//侧边栏回到顶部
	function fnRightNav(){
		$(document).scroll(function(){
			showHide();
		});
		$(document).resize(function(){
			showHide();
		});
		$(document).load(function(){
			showHide();
		});
		$(".scroll-top").click(function(){
			$(".go-top").moveTop();
		});
		
		function showHide(){
			if($(document).width()<1024){
				$(".go-top").hide();
				return;
			}
			var bodyH = $(document).height()/4;
			var scrollTop = $(document).scrollTop();
			if(scrollTop>=bodyH){
				$(".go-top").show();
			}else{
				$(".go-top").hide();
			}
			$(".go-top").css({
				"margin-left":$(".con").width()/2+'px'
			});
		}
		
	}
	//M版a标签的替换
	function replaceA(){
		var winW = $(window).width();
		
		if(winW<=1080){
			$("a").attr("target","_self");
		}
	}
	
	
	//后台分页处理
	bbsPage();
	 function bbsPage(){
		 $(".page-mobile").on("focus",".wap-page-text",function(){
			 var oldV = $(this).val();
			 $(this).val('');
			 $(this).attr("data-value",oldV);
			 $(this).css({
         		"border":"1px solid #eee"
         	});
		 });
		 //移动
		 $(".page-mobile").on("blur",".wap-page-text",function(){
			 	jumpPage(this,$(this).val());
			
		 });
		 $(".page-mobile").on("keydown",".wap-page-text",function(e){
			 	if(e.which==13){
			 		jumpPage(this,$(this).val());
			 	}
		 });
		 //pc
		 $("body").on("click",".jump-page-btn",function(){
			var toPage = $(".jump-text input").val() || 1;
			jumpPage(this,toPage);
		 });
		 $('.jump-text').bind('keydown',function(e){
			 console.log(e.which);
			if(e.which==13){
				var toPage = $(".jump-text input").val() || 1;
				jumpPage(this,toPage);
		 	}
		 });
		 function jumpPage(_this,jumpP){
			 $(_this).css({
		 		"border":"0px solid #eee"
			});
			var v = $.trim(jumpP);
				v = parseInt(v);
			var reg = /^\d*$/;
			
			if(!reg.test(v)){
				$(_this).val($(_this).attr("data-value"));
				return;
			}
			var url = $(".page-mobile").find('.prev a').attr("href") || $(".page-mobile").find('.next a').attr("href");
			var reg = /(\d+\/)+\d+\.html$/gi;
			url = url.replace(reg,function(str){
				var arrUrl = str.split('/');
				if(arrUrl.length==4){
					arrUrl[1]=v;
					return arrUrl.join('/');
				}else if(arrUrl.length==5){
					arrUrl[3]=v;
					return arrUrl.join('/');
				}
			});
			window.location.href=url;  
		 }
	 }
	
		
});


seajs.use('common');