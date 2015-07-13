<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
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
    <title>新游推荐-魔方论坛</title>
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/error.css">
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
        <div class="header clearfix">
            <jsp:include page="user_info.jsp" flush='true'/>
            <div class="nav-wap clearfix">
                <div class="nav-wap-left">
                  <a href="<%=request.getHeader("Referer") %>" class="nav-wap-back"></a>
                  <p class="nav-info">
                    <a href="<%=CommonUrl.bbsHomeUrl %>" class="nav-info-home">论坛首页</a>
                    <a href="<%=CommonUrl.mofangHomeUrl %>">魔方首页</a>
                  </p>
                </div>
                  <div class="wap-nav-text">
                  	热门游戏
                  </div>
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
         <jsp:include page="commonSearch.jsp" flush='true'/>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
        	<div class="err-msg clearfix">
        		<dl>
        			<dt><img src="./img/icon/err_warn.png"/></dt>
        			<dd class="title">页面已经被删除</dd>
        			<dd>对不起，您访问的页面已经被删除，<span id="countDown">5</span>秒后将自动跳转到 <a href="/">论坛首页</a></dd>
        		</dl>
        	</div>
           	<!--  热门游戏社区开始 -->
           <div class="h2">热门游戏社区</div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <a target="_blank" href="forum_content?fid=10">
	                       <dt><img src="http://pic1.mofang.com/304/993/c672375d0069c0b46ae80a343de4f6a17c985dee.png" alt=""></dt>
	                       <dd><span>社区活动</span></dd>
	                       		<dd>今日  <b class="update">722</b></dd>
	                       <dd>帖子  270</dd>
                       </a>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <a target="_blank" href="forum_content?fid=11">
	                       <dt><img src="http://pic0.mofang.com/214/289/d105a231148375e0e99e209be5655816108fc400.png" alt=""></dt>
	                       <dd><span>魔方推游</span></dd>
	                       		<dd>今日  <b class="update">37</b></dd>
	                       <dd>帖子  10492</dd>
                       </a>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                   	   <a target="_blank" href="forum_content?fid=12">
	                       <dt><img src="http://pic2.mofang.com/340/444/989655c70d58047d1c77543cabc15e5311a03110.png" alt=""></dt>
	                       <dd><span>灌水闲聊</span></dd>
	                       		<dd>今日  <b class="update">35</b></dd>
	                       <dd>帖子  3303</dd>
                       </a>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                   	   <a target="_blank" href="forum_content?fid=13">
	                       <dt><img src="http://pic1.mofang.com/275/938/e80462efabaa7f8dc85760c304ee77b2d5f71ff5.png" alt=""></dt>
	                       <dd><span>问题反馈</span></dd>
	                       		<dd>今日  <b>0</b></dd>
	                       <dd>帖子  67</dd>
                       </a>
                   </dl>
               </div>
               
           </div>
           <!-- 热门游戏社区结束 -->
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <!-- footer开始 -->
		<jsp:include page="footer.jsp" flush='true'/>
		<!-- footer结束 -->
        <!-- 底部结束 -->
    </div>
    <script>
    	(function(){
    		window.onload=function(){
        		var oCountDown = document.getElementById("countDown");
        		var n=5;
        		var timer=null;
        		
        		timer=setInterval(function(){
        			
        			oCountDown.innerHTML=n;
        			n--;
        			if(n<0){
        				clearInterval(timer);	
        				window.location.href="/";
        			}
        		},1000);
        	};
    	})();
    	
    </script>
</body>

</html>