
/**
 * @file editor-main.js
 * @brief   editor upload mod
 * @author xukuikui
 * @version
 * @date 2015-6-1
 */

define("loginUserUrl",["jquery",'config'],function(require, exports, module) {

   
    var $ = require("jquery");
    var c = require("config");
    //登录跳转插件
	$.fn.loginUserUrl=function(){
		var _this = this;

		var urlcur = $(_this).attr('href') || '';
		var jumpUrl = '';
		if(urlcur.indexOf('mofang.com')<0){
			urlcur=c.config.userInfoUrl;
		}
		urlcur = urlcur.indexOf("?") < 0 ? urlcur + "?ref=" + encodeURIComponent(window.location.href) : urlcur + "&ref=" + encodeURIComponent(window.location.href);
		$(_this).attr('href',urlcur);
		return urlcur;
	};
    
  

});

seajs.use("loginUserUrl");
