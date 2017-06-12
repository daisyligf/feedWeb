/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('ad',['jquery'],function(require, exports, module) {
	var $ = jQuery = require("jquery");//jquery库
	//展示百度广告
    function A(id,eid){
        if($("#"+eid).length){
            //window.BAIDU_CLB_preloadSlots(id);
            window.BAIDU_CLB_fillSlotAsync(id,eid);
            
            $("#"+eid).find("iframe").css("width","100%");
        }
    }
    //多久显示出来
    function after(n,fn){
        window.setTimeout(fn,n*1000);
    } 
    function bd_ad_0(){
        // 帖子详情页
        //A("1002022","BD_AD_ad1");
    }
    function bootstrap(){
        
        after(0.2,function(){
            bd_ad_0();
        });
    }
    // 加载初始化脚本
    function init(){
        $.getScript("http://cbjs.baidu.com/js/m.js", function() { 
            bootstrap();
        });
    }

    init();
    
});
