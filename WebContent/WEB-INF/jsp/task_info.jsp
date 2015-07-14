<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.mofang.feedweb.global.UserCenter"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
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
    <title>魔方论坛-手机游戏玩家分享讨论基地</title>
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/task_level.css">
    <script src="./js/sea.js"></script>
    <script src="./js/sea-config.js"></script>
    <script src="./js/bbs-config.js"></script>
    <script src="js/mod/common.js"></script>
    <!--{* IE6 png 图像处理 *}-->
    <!--[if IE 6]>
        <script src="./js/loader/dd_belatedpng.js"></script>
        <script>
            DD_belatedPNG.fix('.pngfix');
        </script>
    <![endif]-->


    <!--{* ie8 以下浏览器html5兼容层 *}-->
    <!--[if lt IE 9]>
        <script src="./js/loader/html5shiv.js"></script>
    <![endif]-->

</head>
<body>
    <div class="page">
        <!-- 头部开始 -->
        <!-- 头部开始 -->
        <div class="header clearfix">
            <jsp:include page="user_info.jsp" flush='true'/>
            <div class="nav-wap clearfix">
                <div class="nav-wap-left">
                  <a href="javascript:;" class="nav-wap-list"><img src="./img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a href="<%=CommonUrl.bbsHomeUrl %>" class="nav-info-home">论坛首页</a>
                    <a href="<%=CommonUrl.mofangHomeUrl %>">魔方首页</a>
                  </p>
                </div>
                <div class="wap-logo">
                    <img src="./img/icon/bbs_icon_wap.png"alt="">
                </div>
                <div class="nav-wap-right">
                  <a href="<%=UserCenter.baseUrl %>/home/account/index" class="wap-load" ><img src="./img/icon/load.png"></a>
                  <a href="<%=UserCenter.baseUrl %>/home/person/index" class="wap-head"><img src="./img/icon/load.png" /></a>
                </div>
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
        <jsp:include page="commonSearch.jsp" flush='true'/>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
        	<div class="con-nav"><a href="task_info">经验等级</a><a href="level_info" class="active">魔币</a></div>
            <div class="con-bottom">
            	<h2 class="get-mobi">什么是魔币</h2>
            	<div class="h2-con get-mobi">
            		魔币是由魔方社区发放一种虚拟货币，可在游戏社区中获得并使用，可通过游戏宝和礼包发号中心兑换相应的实物奖品。
            	</div>
            	<h2 class="">怎样获取魔币</h2>
            	<div class="h2-con">
            		<h3>1.首次任务</h3>
	            		<table class="table table-bordered">
			              <tbody>
			                <tr>
			                  <td>任务</td>
			                  <td>奖励魔币</td>
			                  <td>完成进度</td>
			                </tr>
			                <tr>
			                  <td class="grey">上传发帖</td>
			                  <td class="orange">+2</td>
			                  <td class="grey">已完成</td>
			                  
			                </tr>
			                 <tr>
			                  <td class="grey">首次发帖</td>
			                  <td class="orange">+3</td>
			                  <td class="orange">未完成</td>
			                </tr>
			                 <tr>
			                  <td class="grey">首次回应</td>
			                  <td class="orange">+1</td>
			                  <td class="orange">未完成</td>
			                </tr>
			                 <tr>
			                  <td class="grey">首次点赞</td>
			                  <td class="orange">+1</td>
			                  <td class="orange">未完成</td>
			                </tr>
			                 <tr>
			                  <td class="grey">首次关注</td>
			                  <td class="orange">+2</td>
			                  <td class="orange">未完成</td>
			                </tr>
			              </tbody>
		            </table>
		           <p><!-- 注：连续签到，每日累计增加获赠1魔币，最多10魔币封顶； 出现断签，每日累计获赠魔币数失效，重新累计。 --></p>
		           <h3>2.日常任务</h3>
	            		<table class="table table-bordered">
			               <tbody>
			                <tr>
			                  <td></td>
			                  <td>方法</td>
			                  <td>奖励经验</td>
			                  <td>奖励魔币</td>
			                </tr>
			                <tr>
			                  <td>点赞</td>
			                  <td class="grey">累计发出32个赞</td>
			                  <td class="orange">+10</td>
			                  <td class="orange">+5</td>
			                </tr>
			                <tr>
			                  <td>集赞</td>
			                  <td class="grey">累计收集11个赞</td>
			                  <td class="orange">+5</td>
			                  <td class="orange">+5</td>
			                </tr>
			                <tr>
			                  <td>发帖</td>
			                  <td class="grey">发布一篇文章</td>
			                  <td class="orange">+2</td>
			                  <td class="orange">+2</td>
			                </tr>
			                <tr>
			                  <td>回复</td>
			                  <td class="grey">累计评论5次</td>
			                  <td class="orange">+5</td>
			                  <td class="orange">+5</td>
			                </tr>
			                <tr>
			                  <td>分享</td>
			                  <td class="grey">分享1次</td>
			                  <td class="orange">+5</td>
			                  <td class="orange">+5</td>
			                </tr>
			              </tbody>
		            </table>
		           <p><span>注：</span>日常任务每日可完成一次，多次完成不会累加奖励。</p>
		           <h3>3.精华奖励</h3>
		           <p>如果你发的帖子被版主或管理员设置为精华，将获得20甚至更多的魔币奖励。</p>
            	</div>
            </div>
     
        </div>
        <!-- 内容结束 -->
        <!-- footer开始 -->
		<jsp:include page="footer.jsp" flush='true'/>
		<!-- footer结束 -->
    </div>	
    
   <!-- <script src="./js/mod/task_level.js"></script> -->
   
   
</body>

</html>