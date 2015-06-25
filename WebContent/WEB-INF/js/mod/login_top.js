/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('login_top',['jquery','config'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	var c = require("config");//配置文件

	window.loginStatus=false;//检查登录状态
	var USE_LOCAL_DATA = 0;//本地数据
	var USE_TEST_DATA = 0;//测试数据

	var getUrl = "";//url路径示范
	var getUserLoginStatus = c.config.userInfoUrl+"/account/status"; //获取用户的登录状态
	var getUserInfo = c.config.userInfoUrl+"/home/api/get_login_userinfo"; //获取用户信息
	var getUserLogout = c.config.userInfoUrl+"/account/logout"; //用户退出接口
	var getUserNotice = "getUserNotice";
	var ajaxMethod="jsonp"; 
	if(USE_LOCAL_DATA){
		getUserLoginStatus = "/bbs_html/statics/test/get_user.json"; //获取用户的登录状态
		getUserInfo = "/bbs_html/statics/test/get_user.json"; //获取用户信息
		getUserLogout = "/bbs_html/statics/test/get_user.json"; //用户退出接口
		getUserNotice = "/bbs_html/statics/test/get_user_notice.json"
		ajaxMethod="json";
	}
	if(USE_TEST_DATA){
		getUserLoginStatus = c.config.userInfoUrl+"m/account/status"; //获取用户的登录状态
		getUserInfo = c.config.userInfoUrl+"/home/api/get_login_userinfo"; //获取用户信息
		getUserLogout = c.config.userInfoUrl+"/account/logout"; //用户退出接口
	}

	var cLoginDom={
		showDom:".head",//显示用户名div
		hideDom:".load",//隐藏用户名div
		userInfo:"user-info"//用户信息
	}


	
	//显示登录状态
	function showUserStart(){
		$.ajax({
		    url:getUserLoginStatus,
		    type:"GET",
		    dataType:ajaxMethod,
		    data:{
		    },
		    success: function(res) {
		    	if(res && res.code==0){
		    		window.loginStatus=true;
		    		showHeader(!res.code);


		    	}else{
		    		window.loginStatus=false;
		    		showHeader(!res.code);
		    	}
		    },
		    error: function() {
		    	
		    },
		    complete: function(){

		    }
		});
	}

	//显示登录样式
	function showHeader(isLogin){//isLogin->登录状态(true,false),data->个人信息
		if(isLogin){
			$(cLoginDom.hideDom).hide();
			$.ajax({
			    url:getUserInfo,
			    type:"GET",
			    dataType:ajaxMethod,
			    data:{
			    },
			    success: function(res) {
			    	if(res && res.code==0){
			    		$(cLoginDom.showDom).show();
			    		//头像
			    		$("#userImg").attr("src",res.data.avatar);
			    		//昵称
			    		$("#userName").append(res.data.nickname);
			    		//魔币
			    		$("#userMoney").append(res.data.coin);
		    			$("#topUserInfo").hover(function(){
		    				$(".header .user-info").stop().slideDown(200);
		    				
		    			}, function() {
		    				$(".header .user-info").stop().slideUp(200);
		    			});		
			    	}
			    },
			    error: function() {
			    	
			    },
			    complete: function(){

			    }
			});
			


		}else{
			$(cLoginDom.showDom).hide();
			$(cLoginDom.hideDom).show();
		}
	}

	//退出
	function logout(){
		$.ajax({
		    url:getUserLogout,
		    type:"GET",
		    dataType:ajaxMethod,
		    data:{
		    },
		    success: function(res) {
		    	if(res && res.code==0){

		    		window.location.reload();		
		    	}
		    },
		    error: function() {
		    	
		    },
		    complete: function(){

		    }
		});
	}

	//消息通知
	function getNotice(){
		$.ajax({
		    url:getUserNotice,
		    type:"GET",
		    dataType:'json',
		    data:{
		    },
		    success: function(res) {
		    	if(res && res.code==0){

		    		if(res.data.sys_message.unread_count>0 || res.data.reply.unread_count>0 || res.data.recommend.unread_count>0){
		    			
		    			$("#userName").find(".icon-red").show();
		    				

		    			if(res.data.reply.unread_count>0){
		    				$(".header .zj").find(".icon-red").show();
		    			}
		    			if(res.data.sys_message.unread_count>0 || res.data.recommend.unread_count>0){
		    				$(".header .msg").find(".icon-red").show();
		    			}
		    			
		    		}else{
		    			$("#userName").find(".icon-red").hide();
		    			$(".header .zuji").find(".icon-red").hide();
		    		}

		    	}
		    },
		    error: function() {
		    	
		    },
		    complete: function(){

		    }
		});
	}
	//启动函数
	function init(){
		showUserStart();//开始进行登录检查
		getNotice();//消息通知
		setInterval(function(){
			getNotice();
		},60*1000);
	}
	init();
	if (typeof module != "undefined" && module.exports) {
        module.exports.logout = logout;
        // module.exports.getLoginStatus = getLoginStatus;
    }

});
