/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('demo',['jquery','jquery/jquery-validate'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库

	var USE_LOCAL_DATA = 1;//本地数据
	var USE_TEST_DATA = 0;//测试数据

	var getUrl = "";//url路径示范
	var ajaxMethod="json";
	if(USE_LOCAL_DATA){
		getUrl='';
	}
	if(USE_TEST_DATA){
		getUrl='';
	}

	$(function(){
		alert();
	});
	/*$.ajax({
	    url:getUrl,
	    type:"GET",
	    dataType:ajaxMethod,
	    data:{
	    },
	    success: function(res) {
	    	
	    },
	    error: function() {
	    	
	    },
	    complete: function(){

	    }
	});*/
	   
});

seajs.use('demo');
