
define('jquery/jquery-pop', ['jquery'], function(require, exports, module) {
	var $ = jQuery = require("jquery");
	/*
	*	type:'alert', 【alert,confirm,prompt】//弹出框类型
		title:'我是标题,只有有标题的框再用',//标题
		msg:'',//提示信息
		autoTime: 2000,//消失时间
		fnCallback: function(isTrue,msg){//回调函数
			
		}
	*
	*
	*/
(function($) {
	//组件化
	$.fn.pop=function(data){
		var defaults={
			type:'alert', //alert,confirm,prompt
			title:'我是标题,只有有标题的框才用',
			msg:'',
			dropSel:[],
			autoTime: 3000,
			fnCallback: function(isTrue,msg){

			}
		}
		var options = $.extend(true, defaults, data);
		var _this = this;

		switch(options.type){
			case 'alert':
				$(".mask-bg").fadeIn(200);
				$(".pop").fadeOut(200);
				$(_this).fadeIn(200);
				$(_this).find('.pop-msg').html(options.msg);
				setTimeout(function(){
					$(_this).fadeOut(200);
					$(".mask-bg").fadeOut(200);
					options.fnCallback(options.msg);
				},options.autoTime);
			break;
			case 'confirm':
				$(".mask-bg").fadeIn(200);
				$(".pop").fadeOut(200);
				$(_this).fadeIn(200);
				$(_this).find('.pop-msg').html(options.msg);

			break;
			case 'prompt':
				$(".mask-bg").fadeIn(200);
				$(".pop").fadeOut(200);
				$(_this).fadeIn(200);
				$(_this).find('.pop-msg').val(options.msg);
				$(_this).find('.pop-title').html(options.title);

				var arrData = options.dropSel;
				if(arrData.length>0){
					$(_this).find('.delete-choose-title').html(arrData[0]);
					var arrData1= arrData.slice(1);
					var str = '';
					for(var i=0;i<arrData1.length;i++){
						str+='<span>'+arrData1[i]+'</span>';
					}
					$(_this).find(".delete-choose-sort").html(str);
				}
				

		}
		//右上角关闭
		$(_this).off('click','.close').on('click','.close',function(){
			domCallBack(false);	
		});
		//取消
		$(_this).off('click','.pop-cancel').on('click','.pop-cancel',function(){
			domCallBack(false);
		});
		//确定
		$(_this).off('click','.pop-ok').on('click','.pop-ok',function(){
			
			domCallBack(true);
		});
		//点击背景
		$("body").off('click','.mask-bg').on('click','.mask-bg',function(){
			$(_this).fadeOut(200);
			$(".mask-bg").fadeOut(200);
			options.fnCallback(false);
		});

		function domCallBack(isTrue){
			if(options.type=='confirm'){
				options.fnCallback(isTrue);
			}else if(options.type=='prompt'){

				if(options.dropSel.length>0){
					var msg = $(_this).find(".delete-choose-title").html()+$(_this).find(".pop-msg").val();
				}else{
					
					var msg = $(_this).find(".pop-msg").val();
				}
				
				options.fnCallback(isTrue,msg);
			}
			$(_this).fadeOut(200);
			$(".mask-bg").fadeOut(200);
		}
		//prompt,下拉列表
		$("body").off('click','.delete-choose-title').on('click','.delete-choose-title',function(){
			if($(this).hasClass('active')){
				$(this).removeClass('active');
				$(".delete-choose-sort").hide();
			}else{
				$(this).addClass('active');
				$(".delete-choose-sort").show();
			}
		});
		$("body").off('click','.delete-choose-sort span').on('click','.delete-choose-sort span',function(){
			var _v = $(this).html();
			var show_v = $(".delete-choose-title").html();

			$(".delete-choose-title").html(_v);
			$(this).html(show_v);
			$(".delete-choose-title").removeClass('active');
			$(this).parent().hide();
			
			
		});
		
	};
})(jQuery);

	if(typeof module!="undefined" && module.exports){
        module.exports = $;
    }

});
/*<!-- 确定不玩？弹出框开始 -->
    <div class="pop pop-play">
        <p class="pop-play-close"><img src="statics/img/icon/pop_close.png" class="close"></p>
        <p class="pop-play-word pop-msg">突破经典的飞行射击类精品手机游戏。继承了经典飞机大战简单爽快的操作体验，玩法更多样。这么好玩的游戏，确定不玩吗？</p>
        <p class="clearfix">
            <input type="button" class="pop-play-cancel pop-cancel" value="取消">
            <input type="button" class="pop-play-ok pop-ok" value="确定">
        </p>
    </div>
    <div class="pop pop-post-delete">
        <h2 class="clearfix">
            <span>
                <img src="statics/img/icon/pop_close.png" class="close">
            </span>删除帖子
        </h2>
        <div class="post-delete-reason">
            <p  class="post-delete-sure pop-title">确定要删除帖子？</p>
            <form action="">
                <div class="delete-reason-choose pop-msg-title">选择原因</div>

                <textarea name="" class="pop-msg"></textarea>
                <p class="delete-reason-but clearfix">
                    <input type="button" class="delete-reason-cancel pop-cancel" value="取消">
                    <input type="button" class="delete-reason-ok pop-ok" value="确定">
                </p>
            </form>
        </div>
    </div>
    <!-- 成功 -->
    <div class="pop pop-post-ok">   
        <img src="statics/img/icon/pop_ok.png"><span class="suc-msg">成功</span>
    </div>
    <!-- 失败 -->
    <div class="pop pop-top-fail">
        <img src="statics/img/icon/pop_fail.png"><span class="err-msg">失败</span>
    </div>
    <!-- 弹出框结束 -->
</div>*/