/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('index',['jquery','swipe','swiper'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	var Swipe = require('swipe');//引入box切换插件
	var Swiper = require('swiper');//引入box切换插件
	var USE_LOCAL_DATA = 0;//本地数据
	var USE_TEST_DATA = 1;//测试数据

	var getUrl = "";//url路径示范
	var ajaxMethod="json";
	if(USE_LOCAL_DATA){
		getUrl='';
	}
	if(USE_TEST_DATA){
		getUrl='';
	}
	fnImgSlider();
	function fnImgSlider(){
		//图片切换

		var oBox = $("#imgBox");//一组图片的外面的边框
		var aBtn = $("#imgBox ol li");
		// var aSlide = document.get
		//这个插件用的是原生的对象
		var ImgTabs = new Swiper(oBox,{
			autoplay:5000,
			loop:true,
			pagination: '.swiper-pagination-index',
			updateOnImagesReady:false,
        	paginationClickable: true,
        	grabCursor: true,
	        paginationBulletRender: function (index, className) {
	            return '<li class="' + className + '"></li>';
	        },
			prevButton:'.swiper-button-prev',
			nextButton:'.swiper-button-next'
		});
	}

	//热门新游切换
	fnHotNewyou();
	function fnHotNewyou(){
		var oBox = $("#hotNewTab")[0];//一组图片的外面的边框
		var aBtn = $(".hot-nav a");//按钮
		/*var aBtn = $("#hotNewTab ol li");*/
		//这个插件用的是原生的对象
		var ImgTabs = new Swipe(oBox,{
			callback: function(index) {
				setTab(index%2);
			}
		});
		function setTab(index){
			aBtn.removeClass('active');
			aBtn.eq(index).addClass('active');
		}
		aBtn.click(function(){
			var _this = this;
			aBtn.removeClass('active');
			$(this).addClass('active');
			var n=0;

			aBtn.each(function(index){
				if(aBtn[index]==_this){
					ImgTabs.slide(index,300);
				}
			});
		});
	}
	
	//友情链接
//	getLink();
//	function getLink(){
//		$.ajax({
//			url:"http://www.mofang.com/api_v2.php?op=mofang&file=friends&action=friend&page=1&typeid=716",
//			type:"get",
//			dataType:"jsonp",
//			success:function(res){
//				if(res && !res.code){
//					for(var i = 0; i < res.data.length; i++){
//						$(".link-list-a").append('<a target="_blank" href="'+res.data[i].url+'">'+res.data[i].name+'</a>');
//					}
//				}
//			}
//		});
//	}
	   
});

seajs.use('index');
