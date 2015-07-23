/**
 * bbs demo
 * @author xukuikui
 * @date 2015-05-15
 */
define('apply_lord',['jquery','jquery/jquery-pop'],function(require, exports, module) {

	var $ = jQuery = require("jquery");//jquery库
	require("jquery/jquery-pop");//弹出框

	var USE_LOCAL_DATA = 0;//本地数据
	var USE_TEST_DATA = 0;//测试数据

		
	var getApplyUrl = "apply" //申请吧主
	var ajaxMethod="json";
	if(USE_LOCAL_DATA){
		getApplyUrl='';
	}
	if(USE_TEST_DATA){
		getApplyUrl='apply';
	}

	$('#applyBtn').click(function() {
		var forumId = $('#forum_id').val();
		var qq = $.trim($('#qq').val());
		var phone = $.trim( $('#phone').val());
		var gameExp = $.trim( $('#game_exp').val());
		if(qq==""){
			$(".pop-top-fail").pop({
                msg: "请填写qq",
                autoTime:500
            });
			return false;
		}
		if(phone==""){
			$(".pop-top-fail").pop({
                msg: "请填写phone",
                autoTime:500
            });
			return false;
		}
		if(gameExp==""){
			$(".pop-top-fail").pop({
                msg: "请填写申请原因",
                autoTime:500
            });
			return false;
		}
		$.ajax({
			url:getApplyUrl,
			type:'POST',
			dataType:'json',
			data:{'forum_id':forumId, 'qq':qq, 'phone':phone, 'game_exp':gameExp},
			success:function(res){
				if(res && res.code==0){
                    $(".pop-post-ok").pop({
                        msg: "申请成功",
                        autoTime:500
                    }); 
                    setTimeout(function(){
                    	location.href="forum_content/" + forumId + "/0/0/1/0.html";  
                    },600); 
                }else{
                	$(".pop-top-fail").pop({
                        msg: "申请失败",
                        autoTime:500
                    });
				}
			}
		});
	});


	

});

seajs.use('apply_lord');
