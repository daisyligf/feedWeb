<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="com.mofang.feedweb.entity.ModeratorApplyCondition"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <!--{* 使用IE最高版本渲染,如果有chrome frome插件,则使用chrome frame *}-->

    <!--[if !IE]><!-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--<![endif]-->

    <!--{* 让360浏览器默认以chrome内核显示 *}-->
    <meta name="renderer" content="webkit">

    <!-- 移动端处理 -->
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <!--  phone numer select -->
    <meta name="format-detection" content="telephone=no" />
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>申请吧主</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/apply.css">
    <link rel="stylesheet" href="css/add_list_article.css">
    <script src="js/sea.js"></script>
    <script src="js/sea-config.js"></script>
    
    <!--{* IE6 png 图像处理 *}-->
    <!--[if IE 6]>
        <script src="./statics/js/loader/dd_belatedpng.js"></script>
        <script>
            DD_belatedPNG.fix('.pngfix');
        </script>
    <![endif]-->


    <!--{* ie8 以下浏览器html5兼容层 *}-->
    <!--[if lt IE 9]>
        <script src="./statics/js/loader/html5shiv.js"></script>
    <![endif]-->

</head>
<body>
    <div class="page">
    	<!-- 头部开始 -->
        <div class="header clearfix">
            <jsp:include page="user_info.jsp" flush='true'/>
            <div class="nav-wap clearfix">
                <div class="nav-wap-left">
                  <a href="#" class="nav-wap-back"></a>
                  <a href="javascript:;" class="nav-wap-list"><img src="./img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a href="http://bbs.mofang.com" class="nav-info-home">首页</a>
                    <a href="<%=UserCenter.baseUrl %>">个人中心</a>
                  </p>
                </div>
                  <div class="wap-nav-text">
                  	申请吧主
                  </div>
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
            <div class="feed-box clearfix">
                <div class="feed-user-apply">
                    <!--header-->
                    <div class="feed-user-apply-hd clearfix">
                        <!-- {if $noApplyReason == null} -->
                        <!--申请-->
                        <c:choose>
	                        <c:when test="${moderatorApplyCondition.isPass}">
	                        <div class="apply-hd-main">
	                            <h3 class="apply-hd-title">立即申请 <span class="apply-title-item">您在在申请 <a href="forum_content?fid=${feedForum.forum_id}" class="apply-link" target="_blank">${feedForum.forum_name }</a> 吧主</span></h3>
	                            <div class="feed-user-apply-form">
	                            <div class="feed-user-infos"></div>
	                                <form action="" class="user-apply-form">
	                                    <input type="hidden" name="fid" id="forum_id" value="${feedForum.forum_id}"/>
	                                    <input class="J_focus apply-text apply-user-qq" type="text" data-type="qq" id="qq" name="qq" value="" placeholder="请输入您的QQ号">
	                                    <input  class="J_focus apply-text apply-user-phone" type="text" data-type="phone" id="phone" name="phone" value="" placeholder="请输入您的手机号">
	                                    <textarea  class="J_focus apply-text apply-user-text" id="game_exp" name="game_exp" data-type="text" placeholder="描述一下游戏经历，让我们更了解你！"></textarea>
	                                    <input class="apply-user-btn" type="button" id="applyBtn" value="立即申请">
	                                </form>
	                            </div>
	                        </div>
	                        </c:when>
	                        <c:otherwise>
	                        <div class="apply-hd-main-error clearfix">
	                            <div class="apply-hd-main">
	                                <h3 class="apply-hd-error-title"> 对不起，你还不满足吧主申请条件!  </h3>
	                                <p class="apply-line"></p>
	                                <div class="apply-status-list">
	                                    <ul>
	                                        <li class="no-meet">您还没有登录,请登录后再试!</li>
	                                    </ul>
	                                    
	                                </div>
	                            </div>
	                           
	                            <div class="apply-hd-show">
	                                <img src="img/apply.jpg" alt="">
	                            </div>
	                        </div>
	                        </c:otherwise>
                        </c:choose>

                    </div>
                    <!--header end -->
                    <!--bd-->
                    <div class="feed-user-apply-bd">
                        <dl>
                            <dt>做吧主有什么好处？</dt>
                            <dd>
                                <p><span>1.吧主工资：</span>见习吧主实习一个月，工资150魔钻，转正后300魔钻。</p>
                                <p><span>2.吧主荣耀：</span>你的身份、你的帖子和回复都将是其他玩家关注的焦点。“哇，你就是吧主SAMA吧，求大腿啊</p>
                                <p><span>3.吧主福利：</span>可以更快地获得手机网游资讯，更快拿到激活码比其他人更快体验游戏。对于表现出众的你，我们偶尔还会有一点点的小惊喜在等着你哟！</p>
                            </dd>
                            <dt> 主要工作 </dt>
                            <dd>
                                <p>1.参与：每天都要在说吧发布一些相关的内容主题帖哦！</p>
                                <p>2.管理：对一些不符合吧规的帖子根据吧规进行操作，要保持论坛说吧简洁美观。</p>
                                <p>　　　　要对大部分帖子进行回复，符合要求的给予“加分、加亮、置顶、精华”等操作。</p>
                                <p>3.互动：在负责区域说吧内与玩家进行互动，第一时间服务于玩家！</p>
                                <p>3.分享：如果你是游戏高手，那么你要在相关的说吧发表你的游戏看法。</p>
                                <p>　　　　如果你喜欢被抱大腿的感觉，可以把自己负责说吧分享给更多的玩家。</p>
                            </dd>
                            <dt> 魔币和魔钻的用途 </dt>
                            <dd>
                                <p>1.在发号中心兑换独家礼包。</p>
                                <p>2.论坛功能消费</p>
                                <p>3.魔钻可以在特定活动中兑换点卡、Q币等。</p>
                            </dd>
                        </dl>
                    </div>
                    <!--bd end-->
                </div>
            </div>
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
    </div>
</body>
<script src="js/jquery-2.1.4.js"></script>
<script type="text/javascript">
$('#applyBtn').click(function() {
	var forumId = $('#forum_id').val();
	var qq = $('#qq').val();
	var phone = $('#phone').val();
	var gameExp = $('#game_exp').val();
	
	$.ajax({
		url:'apply',
		type:'POST',
		dataType:'json',
		data:{'forum_id':forumId, 'qq':qq, 'phone':phone, 'game_exp':gameExp},
		success:function(data){
			if (data != null && data.code == 0) {
				alert('申请成功！');
				location.href="forum_content?fid="+forumId;
			} else {
				alert('申请失败！');
				return;
			}
		}
	});
});
</script>
</html>



