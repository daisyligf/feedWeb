/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('index',['jquery','handlebars','jquery/jquery-pagebar'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	require("jquery/jquery-pagebar");//分页插件
	var Handlebars = require("handlebars");//handlebars模板引擎

	var USE_LOCAL_DATA = 1;//本地数据
	var USE_TEST_DATA = 1;//测试数据

	
	var getFollowUrl = "" //关注
	var getNoFollowUrl = "" //取消关注
	var ajaxMethod="json";
	if(USE_LOCAL_DATA){
		getFollowUrl='/bbs_html/statics/test/follow.json';
		getNoFollowUrl='/bbs_html/statics/test/follow.json';
	}
	if(USE_TEST_DATA){
		getFollowUrl='';
		getNoFollowUrl='';
	}

	getPlateInfo();
	function getPlateInfo(){

		

		$("body").on("click",".follow",function(){
			var _this = this;
			var url = '';
			var msg = '';
			if($(_this).hasClass('followed')){
				url = getNoFollowUrl;
				msg = '取消成功';
			}else{
				url = getFollowUrl;
				msg = '关注成功';

			}

			$.ajax({
			    url:url,
			    type:"POST",
			    dataType:ajaxMethod,
			    data:{
			    	fid:$(_this).attr('data-fid'),
			    	uid:$(_this).attr('data-id')
			    },
			    success: function(res) {
			    	if(res && !res.code){
			    		alert(msg);
			    		if($(_this).hasClass('followed')){
			    			$(_this).removeClass('followed');
			    			$(_this).html("+ 关注");
			    		}else{
			    			$(_this).addClass('followed');
			    			$(_this).html("已关注");
			    		}
			    	}else{
			    		alert(res.message);
			    	}
			    },
			    error: function() {
			    	
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

