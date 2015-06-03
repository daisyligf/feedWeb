/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('search',['jquery','handlebars','jquery/jquery-pagebar'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	require("jquery/jquery-pagebar");//分页插件
	var Handlebars = require("handlebars");//handlebars模板引擎

	var USE_LOCAL_DATA = 1;//本地数据
	var USE_TEST_DATA = 0;//测试数据

	
	var getPlateUrl = "" //获取搜索板块数据
	var getPostUrl = "" //获取搜索帖子数据
	var ajaxMethod="json";
	if(USE_LOCAL_DATA){
		getPlateUrl='/bbs_html/statics/test/ser_plate.json';
		getPostUrl='/bbs_html/statics/test/ser_post.json';
	}
	if(USE_TEST_DATA){
		getPlateUrl='';
		getPostUrl='';
	}

	Handlebars.registerHelper("isshowimg",function(v1,v2,options){
		if(v1.length>v2){
			return options.fn(this);
		}else{
			return options.inverse(this);
		}
		
    });
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
	getPlate();//板块
	
	function getPlate(){
		var isLoad = false;
		$("#plateMore").on("click",function(){
			var _this = this;

			if($(_this).hasClass('plate-more')){
				if(isLoad){
					$("#plate .col-xs-3").show();
					$(_this).html("收起").addClass("stop").removeClass('plate-more');
				}else{
					getPlateData({
						p:2,
						pagesize:''
					},function(){
						isLoad = true;
						$(_this).html("收起").addClass("stop").removeClass('plate-more');
					});
				}
				
			}else{
				$("#plate .col-xs-3:gt(7)").hide();
				$(_this).html("更多").addClass("plate-more").removeClass('stop');;
			}
			
			
		});
		getPlateData();//获取板块第一页
	}

	//获取板块数据
	function getPlateData(options,fnCallback){

		var defaults = {
			keyword : $("#keyword").val(),
			p : 1,
			pagesize : 8
		};
		options = $.extend(true, defaults, options);

		$.ajax({
		    url:getPlateUrl,
		    type:"POST",
		    dataType:ajaxMethod,
		    data:options,
		    success: function(res) {
		    	if(res && !res.code){
		    		var plateTemplate = Handlebars.compile($("#plateTemplate").html());

		    		$(".plate-num span").html(res.data.total);
		    		$("#plate").append(plateTemplate(res.data));
		    	}
		    	fnCallback && fnCallback();
		    },
		    error: function() {
		    	
		    },
		    complete: function(){
		    	
		    }
		});
	}

	//帖子
	getPost();
	function getPost(){
		getPostData({},function(total,page,pageNum){

			$.fn.jpagebar({ 
	            renderTo: $("#pagePc"),
	            //总数
	            totalNum: total,
	            //总页码
	            totalpage: Math.ceil(total/pageNum),
	            //当前页码
	            currentPage:page,
	            //分页条样式
	            pagebarCssName:'page-pc',
	            //当前选中页码样式
	            currentPageNumberCssName: 'active',
	            //点击页码action
	            onClickPage: function(pageIndex){

	           	   $.fn.setCurrentPage(this, pageIndex);
	                getPostData({
	                	p: pageIndex
	                });
	                $(".page-mobile .text").html(pageIndex+'/'+total);
	            }
	      });
		});//获取帖子第一页
	}
	
	//获取帖子数据
	function getPostData(options,fnCallback){
		var defaults = {
			keyword : $("#keyword").val(),
			p : 1,
			pagesize : 20
		};

		options = $.extend(true, defaults, options);
		$.ajax({
		    url:getPostUrl,
		    type:"POST",
		    dataType:ajaxMethod,
		    data:options,
		    success: function(res) {

		    	if(res && !res.code){
		    		var postTemplate = Handlebars.compile($("#postTemplate").html());



		    		$(".post-num span").html(res.data.total);
					
		    	
		    		$("#post").html(postTemplate(res.data));	
		    	}
		    	$(".page-mobile .text").html(options.p+'/'+res.data.total);
		    	fnCallback && fnCallback(res.data.total,options.p,options.pagesize);


		    },
		    error: function(err) {
		    	console.log(err);
		    },
		    complete: function(){
		    	
		    }
		});
	}


	

});

seajs.use('search');
