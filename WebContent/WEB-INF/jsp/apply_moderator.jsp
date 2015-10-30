<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
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
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/apply.css">
    <link rel="stylesheet" href="css/add_list_article.css">
    <script src="./js/sea.js"></script>
    <script src="./js/sea-config.js"></script>
    <script src="./js/bbs-config.js"></script>
    <script src="js/mod/common.js"></script>
    
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
                  <a href="javascript:;" class="nav-wap-list"><img src="./img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a href="<%=CommonUrl.bbsHomeUrl %>" class="nav-info-home">首页</a>
                    <a href="<%=UserCenter.baseUrl %>">个人中心</a>
                  </p>
                </div>
                 <div class="wap-logo">
                    <img src="./img/icon/bbs_icon_wap.png"alt="">
                  </div>
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
            <div class="feed-box clearfix">
                <div class="feed-user-apply">
                    <!--header-->
                   
                    <!--header end -->
                    <!--bd-->
                    <div class="feed-user-apply-bd">
                        <dl>
                            <dt>听说你想申请版主是吗？请联系QQ：54800674！</dt>
                            <dt>那就仔细阅读一下应聘者须知吧。</dt>
                            <dt>应聘者须知</dt>
                            <dd>
                                <p>1.有稳定的时间，能够经常去到所负责的游戏版面巡视。</p>
                                <p>2.有一定的游戏知识与游戏见解，能帮助玩家解答疑难的并能够与玩家进行良性讨论 。</p>
                                <p>3.有较大的责任心，能够带动起良好的版面舆论气氛，有足够的耐心与版面玩家互相讨论。</p>
                                <p>4.如会使用office办公软件，有一定的文字功底，会写游戏攻略者将会优先考虑。</p>
                                <p>5.思维活跃，服从管理安排，服从团队制度。（我行我素，不团结、不服从上级者请勿报名）</p>
                                <p>6.论坛等级5级，论坛发帖量超过100贴，近2个月内无任何论坛处分 。</p>
                                <p>7.论坛核心版友，发表过帖子较多，帖子排版好的优先考虑</p>
                            </dd>
                            <dt> 已经看完了吗？觉得怎么样。如果可以的话就继续往下看吧！ </dt>
                            <dt> 实习版主的职责 </dt>
                            <dd>
                                <p>1.参与：每天都要在论坛里发布一些相关的内容主题帖哦！</p>
                                <p>2.管理：对一些不符合版规的帖子根据版规进行操作，要保持论坛简洁美观。</p>
                                <p>　　　　要对大部分帖子进行回复，符合要求的给予“加分、加亮、置顶、精华”等操作。</p>
                                <p>3.互动：在负责区域论坛内与玩家进行互动，第一时间服务于玩家！</p>
                                <p>3.分享：如果你是游戏高手，那么你要在相关的论坛发表你的游戏看法。</p>
                                <p>　　　　如果你喜欢被抱大腿的感觉，可以把自己负责论坛分享给更多的玩家。</p>
                            </dd>
                            <dt> 如果你觉得以上你都符合的话，那么恭喜你了你成为我们的实习版主了。 </dt>
                            <dt> 实习版主的福利待遇 </dt>
                            <dd>
                                <p>1.版主工资：实习版主实习期每月30Q币。</p>
                                <p>2.版主荣耀：你的身份、你的帖子和回复都将是其他玩家关注的焦点。“哇，你就是版主SAMA吧，求大腿啊！</p>
                                <p>3.版主福利：可以更快地获得手机网游资讯，更快拿到激活码比其他人更快体验游戏。对于表现出众的你，我们偶尔还会有一点点的小惊喜在等着你哟！</p>
                            </dd>
                            <dt> 看完是不是奇怪呢，为什么会是实习的呢。这个自然就是需要对你考核转正的！ </dt>
                            <dt> 实习版主转正考核： </dt>
                            <dd>
                                <p>1.必须满足在任时间一个月以上。</p>
                                <p>2.必须通过见习版主培训所有内容。</p>
                                <p>3.见习期间不得被会员投诉。</p>
                                <p>4.见习期间发帖量必须满足总版主发布的工作任务数。</p>
                                <p>5.见习期间无重大过失。</p>
                                <p>6.申请转正前需完成见习工作期间心得。</p>
                            </dd>
                            <dt> 偷偷的告诉你，实习期转正待遇从优哦！ </dt>
                            <dt> 这下你都了解了吧，那么就加油了哦！ </dt>
                        </dl>
                    </div>
                    <!--bd end-->
                </div>
            </div>
        </div>
        <!-- 内容结束 -->
         <!-- footer开始 -->
		<jsp:include page="footer.jsp" flush='true'/>
		<!-- footer结束 -->
		<!-- 弹出框插件开始 -->
        <!-- 遮罩层开始 -->
        <div class="mask-bg">
            
        </div>
        <!-- 遮罩层结束 -->
        <!-- 成功 -->
        <div class="pop pop-post-ok">   
            <img src="img/icon/pop_ok.png"><span class="pop-msg">成功</span>
        </div>
        <!-- 失败 -->
        <div class="pop pop-top-fail">
            <img src="img/icon/pop_fail.png"><span class="pop-msg">失败</span>
        </div>
        <!-- 弹出框插件结束 -->
		<script src="./js/mod/apply_lord.js"></script>
    </div>
</body>
</html>



