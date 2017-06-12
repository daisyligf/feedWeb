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
    <!-- 不让百度处理转码 -->
    <meta name="applicable-device" content="pc,mobile" />
    <meta http-equiv="Cache-Control" content="no-siteapp" /> 
    <!-- 移动端处理 -->
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <!-- iphone app  -->
    <meta name="apple-itunes-app" content="app-id=1059683792">
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <!--  phone numer select -->
    <meta name="format-detection" content="telephone=no" />
    <title>魔方论坛-手机游戏玩家分享讨论基地</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="/static/feedweb/img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/feedweb/css/base.css">
    <link rel="stylesheet" href="/static/feedweb/css/common.css">
    <link rel="stylesheet" href="/static/feedweb/css/swiper.min.css">
    <link rel="stylesheet" href="/static/feedweb/css/task_level.css">
    <script src="/static/feedweb/js/sea.js"></script>
    <script src="/static/feedweb/js/sea-config.js"></script>
    <script src="/static/feedweb/js/bbs-config.js"></script>
    <script src="/static/feedweb/js/mod/common.js"></script>
    
    <!--{* IE6 png 图像处理 *}-->
    <!--[if IE 6]>
        <script src="/static/feedweb/js/loader/dd_belatedpng.js"></script>
        <script>
            DD_belatedPNG.fix('.pngfix');
        </script>
    <![endif]-->


    <!--{* ie8 以下浏览器html5兼容层 *}-->
    <!--[if lt IE 9]>
        <script src="/static/feedweb/js/loader/html5shiv.js"></script>
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
                  <a href="javascript:;" class="nav-wap-list"><img src="/static/feedweb/img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a href="<%=CommonUrl.bbsHomeUrl %>" class="nav-info-home">论坛首页</a>
                    <a href="<%=CommonUrl.mofangHomeUrl %>">魔方首页</a>
                  </p>
                </div>
                <div class="wap-logo">
                    <img src="/static/feedweb/img/icon/bbs_icon_wap.png"alt="">
                </div>
                <div class="nav-wap-right">
                  <a href="<%=UserCenter.baseUrl %>/home/account/index" class="wap-load" ><img src="/static/feedweb/img/icon/load.png"></a>
                  <a href="<%=UserCenter.baseUrl %>/home/person/index" class="wap-head"><img src="/static/feedweb/img/icon/load.png" /></a>
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
        	<div class="con-nav"><a href="level_info" class="active">经验等级</a><a href="task_info">魔币</a></div>
            <div class="con-bottom">
            	<h2>等级</h2>
            	<div class="level-pic clearfix">
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.1</dt>
            				<dd>1经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.2</dt>
            				<dd>10经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.3</dt>
            				<dd>30经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.4</dt>
            				<dd>50经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.5</dt>
            				<dd>100经验</dd>
            			</dl>
            		</div>
            		<div class="level-line level-line-right">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.10</dt>
            				<dd>4000经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.9</dt>
            				<dd>2000经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.8</dt>
            				<dd>1000经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.7</dt>
            				<dd>500经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.6</dt>
            				<dd>200经验</dd>
            			</dl>
            		</div>
            		<div class="level-line level-line-left">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.11</dt>
            				<dd>8000经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.12</dt>
            				<dd>14000经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.13</dt>
            				<dd>26000经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.14</dt>
            				<dd>50000经验</dd>
            			</dl>
            		</div>
            		<div class="level-line">
            			<div class="level-line-con"></div>
            		</div>
            		<div class="level-list">
            			<dl>
            				<dt class="circle">LV.15</dt>
            				<dd>100000经验</dd>
            			</dl>
            		</div>
            		
            	</div>
            	<div class="level-pic level-wap swiper-container clearfix">
            		<div class="swiper-wrapper">
           				<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.1</dt>
	            				<dd>1经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.2</dt>
	            				<dd>10经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.3</dt>
	            				<dd>30经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.4</dt>
	            				<dd>50经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.5</dt>
	            				<dd>100经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.6</dt>
	            				<dd>200经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.7</dt>
	            				<dd>500经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.8</dt>
	            				<dd>1000经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.9</dt>
	            				<dd>2000经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.10</dt>
	            				<dd>4000经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.11</dt>
	            				<dd>8000经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.12</dt>
	            				<dd>14000经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.13</dt>
	            				<dd>26000经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.14</dt>
	            				<dd>50000经验</dd>
	            			</dl>
	            		</div>
	            		<div class="level-line swiper-slide">
	            			<div class="level-line-con"></div>
	            		</div>
	            		<div class="level-list swiper-slide">
	            			<dl>
	            				<dt class="circle">LV.15</dt>
	            				<dd>100000经验</dd>
	            			</dl>
	            		</div>
            		</div>
            		 <!-- Add Scroll Bar -->
		        	<div class="swiper-scrollbar"></div>
		            		
            	</div>
            	<h2>获取经验</h2>
            	<div class="h2-con">
            		<h3>1.签到任务</h3>
	            		<table class="table  table-bordered table-condensed">
			              <tbody>
			                <tr>
			                  <td>连续签到</td>
			                  <td class="grey">1天</td>
			                  <td class="grey">2天</td>
			                  <td class="grey">...</td>
			                  <td class="grey">10天</td>
			                  <td class="grey">11天</td>
			                  <td class="grey">...</td>
			                </tr>
			                <tr>
			                  <td>奖励经验</td>
			                  <td class="orange">+1</td>
			                  <td class="orange">+2</td>
			                  <td class="orange">...</td>
			                  <td class="orange">+10</td>
			                  <td class="orange">+10</td>
			                  <td class="orange">+10</td>
			                </tr>
			              </tbody>
		            </table>
		           <p><span>注：</span>连续签到，每日累计增加获赠1经验，最多10经验封顶； 出现断签，每日累计获赠经验数失效，重新累计。</p>
		           <h3>2.日常任务</h3>
	            		<table class="table  table-bordered table-condensed">
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
		           <h3>3.优质帖子</h3>
	            		<table class="table  table-bordered table-condensed">
			              <tbody>
			                <tr>
			                  <td>回帖量</td>
			                  <td>奖励经验</td>
			                </tr>
			                <tr>
			                  <td class="grey">1-10</td>
			                  <td class="orange">+2</td>
			                </tr>
			                 <tr>
			                  <td class="grey">10-30</td>
			                  <td class="orange">+4</td>
			                </tr>
			                 <tr>
			                  <td class="grey">30-50</td>
			                  <td class="orange">+6</td>
			                </tr>
			                 <tr>
			                  <td class="grey">50-100</td>
			                  <td class="orange">+10</td>
			                </tr>
			                 <tr>
			                  <td class="grey">100以上</td>
			                  <td class="orange">经验暴击</td>
			                </tr>
			              </tbody>
		            </table>
		           <p><span>注：</span>发布优质的帖子，获取额外经验加成，回复越多，奖励越多。</p>
            	</div>
            </div>
     
        </div>
        <!-- 内容结束 -->
        <!-- footer开始 -->
		<jsp:include page="footer.jsp" flush='true'/>
		<!-- footer结束 -->
    </div>	
    
  <script src="/static/feedweb/js/mod/task_level.js"></script>
   
   
</body>

</html>