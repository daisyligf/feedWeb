/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('task_level',['jquery','swiper'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	var Swiper = require('swiper');//引入box切换插件
	
	var swiper = new Swiper('.swiper-container', {
        scrollbar: '.swiper-scrollbar',
        mousewheelControl: true,
        freeMode: true,
        slidesPerView:"auto",
        direction:'horizontal',
        scrollbarHide:false
    });
});

seajs.use('task_level');
