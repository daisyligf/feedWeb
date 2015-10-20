<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <meta name="keywords" content="游戏论坛,手游论坛,安卓游戏论坛,iphone游戏论坛,魔方网论坛">
    <meta name="description" content="魔方网手游论坛致力于打造国内第一手游论坛,推荐最新的安卓游戏,iPhone游戏,是手游玩家分享游戏攻略的基地,还有丰厚的游戏礼包和游戏周边领取活动，欢迎广大手游玩家来魔方网论坛交流游戏心得体验.">
    <title>魔方论坛_手游游戏论坛_安卓iPhone游戏论坛_魔方网手游游戏玩家分享社区</title>
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/swiper.min.css">
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
                    <a href="<%=CommonUrl.bbsHomeUrl%>" class="nav-info-home">论坛首页</a>
                    <a href="<%=CommonUrl.mofangHomeUrl%>">魔方首页</a>
                    <a href="<%=CommonUrl.mNewsUrl%>">新闻</a>
                    <a href="<%=CommonUrl.mVideosUrl%>">视频</a>
                    <a href="<%=CommonUrl.mTopicsUrl%>">专区</a>
                    <a href="<%=CommonUrl.mChangyeUrl%>">产业</a>
                    <a href="<%=CommonUrl.mGameUrl%>">游戏库</a>
                    <a href="<%=CommonUrl.mCsUrl%>">厂商库</a>
                    <a href="<%=CommonUrl.mAppUrl%>">app</a>
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
            <!-- 第一块内容开始 -->
            <div class="con-top container clearfix">
                <div class="col-xs-9 col-md-12 col-sm-12">
                    <div class="col-xs-6 col-md-6 col-sm-12">
                         <div class="box img-box clearfix" id="imgBox">
                               <ul class="swipe-wrap swiper-wrapper">
                                  <li class="swiper-slide">
                                    <a target="_blank" href="${tickers.threadLink1}"><img src="${tickers.tickerIcon1}"alt="" /></a>
                                    <b class="swipe-wrap-info" ></b>
                                  </li>
                                  <li class="swiper-slide">
                                    <a target="_blank" href="${tickers.threadLink2}"><img src="${tickers.tickerIcon2}"alt="" /></a>
                                    <b class="swipe-wrap-info" ></b>
                                  </li>
                                  <li class="swiper-slide">
                                    <a target="_blank" href="${tickers.threadLink3}"><img src="${tickers.tickerIcon3}"alt="" /></a>
                                    <b class="swipe-wrap-info" ></b>
                                  </li>
                               </ul>
                               <!-- Add Pagination -->
						        <ol class="swiper-pagination-index">
	                                   <li class="active"></li>
	                                   <li></li>
	                                   <li></li>
	                               </ol>
						        <!-- Add Navigation -->
						        <div class="swiper-button-prev"></div>
						        <div class="swiper-button-next"></div>
                               
                         </div>
                    </div>
                    <div class="rec col-xs-6 col-md-6 col-sm-12">
                        <div class="col-xs-12 rec-con">
                            <dl class="title-red">
                                <dt><a target="_blank" href="<%=CommonUrl.baseUrl%>/thread/${subjects.threadId1}.html">${subjects.threadName1} </a></dt>
                                <dd>${subjects.content1}</dd>
                            </dl>
                            <dl>
                                <dt><a target="_blank" href="<%=CommonUrl.baseUrl%>/thread/${subjects.threadId2}.html">${subjects.threadName2}</a></dt>
                                <dd>${subjects.content2}</dd>
                            </dl>
                            <ul>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="<%=CommonUrl.baseUrl%>/thread/${subjects.threadId3}.html">${subjects.threadName3} </a> <span class="lm"><a target="_blank" href="<%=CommonUrl.baseUrl%>/forum/${subjects.forumId3}.html">${subjects.forumNmae3} </a></span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="<%=CommonUrl.baseUrl%>/thread/${subjects.threadId4}.html">${subjects.threadName4} </a> <span class="lm"><a target="_blank" href="<%=CommonUrl.baseUrl%>/forum/${subjects.forumId4}.html">${subjects.forumNmae4} </a></span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="<%=CommonUrl.baseUrl%>/thread/${subjects.threadId5}.html">${subjects.threadName5} </a> <span class="lm"><a target="_blank" href="<%=CommonUrl.baseUrl%>/forum/${subjects.forumId5}.html">${subjects.forumNmae5} </a></span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="<%=CommonUrl.baseUrl%>/thread/${subjects.threadId6}.html">${subjects.threadName6} </a> <span class="lm"><a target="_blank" href="<%=CommonUrl.baseUrl%>/forum/${subjects.forumId6}.html">${subjects.forumNmae6} </a></span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="<%=CommonUrl.baseUrl%>/thread/${subjects.threadId7}.html">${subjects.threadName7} </a> <span class="lm"><a target="_blank" href="<%=CommonUrl.baseUrl%>/forum/${subjects.forumId7}.html">${subjects.forumNmae7} </a></span></li>
                             </ul> 
                        </div>
                    </div>
                </div>
                <div class="col-xs-3 col-md-12 col-sm-12 hot-tj">
                    <div class="col-xs-12 hot-tj-con">
                        <div class="hot-nav">
                            <a href="javascript:;" class="active">热门版块</a>
                            <a href="javascript:;" class="">新游推荐</a>
                        </div>
                        <div id="hotNewTab" style="overflow:hidden;">
                            <div class="hot-con swipe-wrap">
                                
                                <ul>
                                    <li class="clearfix"><span class="num num-color">01</span><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${hotRank.forumId1}.html" class="title"><img src="${hotRank.icon1}" alt="">${hotRank.forumName1} </a>
	                                    <span class="rank">
		                                     <c:if test="${hotRank.upDown1==1}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown1==0}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown1==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
		                                </span>
                                    </li>
                                    <li class="clearfix"><span class="num num-color">02</span><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${hotRank.forumId2}.html" class="title"><img src="${hotRank.icon2}" alt="">${hotRank.forumName2}</a>
                                    <span class="rank">
                                     		<c:if test="${hotRank.upDown2==1}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==0}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    </span>
                                    </li>
                                    <li class="clearfix"><span class="num num-color">03</span><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${hotRank.forumId3}.html" class="title"><img src="${hotRank.icon3}" alt="">${hotRank.forumName3}</a>
                                    	<span class="rank">
                                    		<c:if test="${hotRank.upDown3==1}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown3==0}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown3==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    	</span>
                                    </li>
                                    <li class="clearfix"><span class="num">04</span><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${hotRank.forumId4}.html" class="title"><img src="${hotRank.icon4}" alt="">${hotRank.forumName4}</a>
                                    	<span class="rank">
                                    	    <c:if test="${hotRank.upDown4==1}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown4==0}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown4==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    	</span>
                                    </li>
                                    <li class="clearfix"><span class="num">05</span><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${hotRank.forumId5}.html" class="title"><img src="${hotRank.icon5}" alt="">${hotRank.forumName5}</a>
                                    	<span class="rank">
                                    	    <c:if test="${hotRank.upDown5==1}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown5==0}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown5==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    	</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li class="clearfix"><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${recommendRank.forumId1}.html" class="title"><img src="${recommendRank.icon1}" alt="">${recommendRank.forumName1}</a>
                                    <span>
                                        <c:if test="${recommendRank.giftUrl1 == ''}">
                                    	<a class="package off-package" href="javascript:;">礼包</a>
                                    	</c:if>
                                    	 <c:if test="${recommendRank.giftUrl1 != ''}">
                                    	<a target="_blank"  class="package" href="${recommendRank.giftUrl1}">礼包</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.downLoadUrl1 == ''}">
                                    	<a class="down off-down" href="javascript:;">下载</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.downLoadUrl1 != ''}">
                                    	<a target="_blank"  class="down" href="${recommendRank.downLoadUrl1}">下载</a>
                                    	</c:if>
                                    </span>
                                    </li>
                                    <li class="clearfix"><a target="_blank"  href="<%=CommonUrl.baseUrl%>/forum/${recommendRank.forumId2}.html" class="title"><img src="${recommendRank.icon2}" alt="">${recommendRank.forumName2}</a>
                                    <span>
                                       <c:if test="${recommendRank.giftUrl2 == ''}">
                                    	<a class="package off-package" href="javascript:;">礼包</a> 
                                    	</c:if>
                                    	<c:if test="${recommendRank.giftUrl2 != ''}">
                                    	<a target="_blank"  class="package" href="${recommendRank.giftUrl2}">礼包</a> 
                                    	</c:if>
                                    	<c:if test="${recommendRank.downLoadUrl2==''}">
                                    	<a class="down off-package" href="javascript:;">下载</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.downLoadUrl2!=''}">
                                    	<a target="_blank"  class="down" href="${recommendRank.downLoadUrl2}">下载</a>
                                    	</c:if>
                                    </span>
                                    </li>
                                    <li class="clearfix"><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${recommendRank.forumId3}.html" class="title"><img src="${recommendRank.icon3}" alt="">${recommendRank.forumName3}</a>
                                    <span>
                                    <c:if test="${recommendRank.giftUrl3 == ''}">
                                    	<a class="package off-package" href="javascript:;">礼包</a> 
                                    </c:if>
                                    <c:if test="${recommendRank.giftUrl3 != ''}">
                                    	<a target="_blank"  class="package" href="${recommendRank.giftUrl3}">礼包</a> 
                                    </c:if>
                                    <c:if test="${recommendRank.downLoadUrl3 == ''}">
                                    	<a class="down off-package" href="javascript:;">下载</a>
                                    </c:if>
                                     <c:if test="${recommendRank.downLoadUrl3 != ''}">
                                    	<a target="_blank"  class="down" href="${recommendRank.downLoadUrl3}">下载</a>
                                    </c:if>
                                    </span>
                                    </li>
                                    <li class="clearfix"><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${recommendRank.forumId4}.html" class="title"><img src="${recommendRank.icon4}" alt="">${recommendRank.forumName4}</a>
                                    <span>
                                    	<c:if test="${recommendRank.giftUrl4 == ''}">
                                    	<a class="package off-package" href="javascript:;">礼包</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.giftUrl4 != ''}">
                                    	<a target="_blank"  class="package" href="${recommendRank.giftUrl4}">礼包</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.downLoadUrl4 == ''}">
                                    	<a class="down off-package" href="javascript:;">下载</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.downLoadUrl4 != ''}">
                                    	<a target="_blank"  class="down" href="${recommendRank.downLoadUrl4}">下载</a>
                                    	</c:if>
                                    </span>
                                    </li>
                                    <li class="clearfix"><a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${recommendRank.forumId5}.html" class="title"><img src="${recommendRank.icon5}" alt="">${recommendRank.forumName5}</a>
                                    <span>
                                       	<c:if test="${recommendRank.giftUrl5 == ''}">
                                    	<a class="package off-package" href="javascript:;">礼包</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.giftUrl5 != ''}">
                                    	<a target="_blank"  class="package" href="${recommendRank.giftUrl5}">礼包</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.downLoadUrl5 == ''}">
                                    	<a class="down off-package" href="javascript:;">下载</a>
                                    	</c:if>
                                    	<c:if test="${recommendRank.downLoadUrl5 != ''}">
                                    	<a target="_blank"  class="down" href="${recommendRank.downLoadUrl5}">下载</a>
                                    	</c:if>
                                    </span>
                                   	</li>

                                </ul>
                            </div>
                        </div>
                        
                    </div>
                    
                </div>

            </div>
           <!-- 第一块内容结束 -->
           <!-- 综合专区开始 -->
           <div class="h2">综合专区</div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <a target="_blank" href="<%=CommonUrl.baseUrl %>/forum/${officalForum.forumId1}.html">
	                       <dt><img src="${officalForum.icon1}" alt=""></dt>
	                       <dd><span>${officalForum.forumName1}</span></dd>
	                       <c:if test="${officalForum.todayThreads1 > 0}">
	                       		<dd>今日  <b class="update">${officalForum.todayThreads1}</b></dd>
	                       </c:if>
	                       <c:if test="${officalForum.todayThreads1 == 0}">
	                       		<dd>今日  <b>${officalForum.todayThreads1}</b></dd>
	                       </c:if>
	                       <dd>帖子  ${officalForum.totalThreads1}</dd>
                       </a>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <a target="_blank" href="<%=CommonUrl.baseUrl%>/forum/${officalForum.forumId2}.html">
	                       <dt><img src="${officalForum.icon2}" alt=""></dt>
	                       <dd><span>${officalForum.forumName2}</span></dd>
	                       <c:if test="${officalForum.todayThreads2 > 0}">
	                       		<dd>今日  <b class="update">${officalForum.todayThreads2}</b></dd>
	                       </c:if>
	                       <c:if test="${officalForum.todayThreads2 == 0}">
	                       		<dd>今日  <b>${officalForum.todayThreads2}</b></dd>
	                       </c:if>
	                       <dd>帖子  ${officalForum.totalThreads2}</dd>
                       </a>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                   	   <a target="_blank" href="<%=CommonUrl.baseUrl %>/forum/${officalForum.forumId3}.html">
	                       <dt><img src="${officalForum.icon3}" alt=""></dt>
	                       <dd><span>${officalForum.forumName3}</span></dd>
	                       <c:if test="${officalForum.todayThreads3 > 0}">
	                       		<dd>今日  <b class="update">${officalForum.todayThreads3}</b></dd>
	                       </c:if>
	                       <c:if test="${officalForum.todayThreads3 == 0}">
	                       		<dd>今日  <b>${officalForum.todayThreads3}</b></dd>
	                       </c:if>
	                       <dd>帖子  ${officalForum.totalThreads3}</dd>
                       </a>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                   	   <a target="_blank" href="<%=CommonUrl.baseUrl %>/forum/${officalForum.forumId4}.html">
	                       <dt><img src="${officalForum.icon4}" alt=""></dt>
	                       <dd><span>${officalForum.forumName4}</span></dd>
	                       <c:if test="${officalForum.todayThreads4 > 0}">
	                       		<dd>今日  <b class="update">${officalForum.todayThreads4}</b></dd>
	                       </c:if>
	                        <c:if test="${officalForum.todayThreads4 == 0}">
	                       		<dd>今日  <b>${officalForum.todayThreads4}</b></dd>
	                       </c:if>
	                       <dd>帖子  ${officalForum.totalThreads4}</dd>
                       </a>
                   </dl>
               </div>
               
           </div>
           <!-- 综合专区结束 -->
           <!-- 热门游戏开始 -->
           <div class="h2">热门游戏 <a target="_blank" href="<%=CommonUrl.baseUrl %>/forumList/1.html">更多 ></a></div>
           <div class="h2-con clearfix container">
           <c:forEach var="hotForum" items="${hotForumList}">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                   <a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${hotForum.hotForumId}.html">
                       <dt><img src="${hotForum.hotIcon}" alt=""></dt>
                       <dd><span>${hotForum.hotForumName}</span></dd>
                       <c:if test="${hotForum.hotTodayThreads > 0}">
                       		<dd>今日  <b class="update">${hotForum.hotTodayThreads} </b></dd>
                       </c:if>
                       <c:if test="${hotForum.hotTodayThreads == 0}">
                       		<dd>今日  <b>${hotForum.hotTodayThreads} </b></dd>
                       </c:if>
                       <dd>帖子  ${hotForum.hotTotalThreads}</dd>
                    </a>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl==''}">
                      	<a href="javascript:;" class="zq bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl}"  class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
              </c:forEach>
           </div>
           <!-- 热门游戏结束 -->
          	<!-- 新游推荐开始 -->
           <div class="h2">新游推荐 <a target="_blank" href="<%=CommonUrl.baseUrl %>/forumList/2.html">更多 ></a></div>
           <div class="h2-con clearfix container">
           <c:forEach var="recommendForum" items="${recommendForumList}">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                   <a target="_blank"  href="<%=CommonUrl.baseUrl %>/forum/${recommendForum.forumId}.html">
                       <dt><img src="${recommendForum.icon}" alt=""></dt>
                       <dd><span>${recommendForum.forumName}</span></dd>
                       <c:if test="${recommendForum.todayThreads > 0}">
                       		<dd>今日  <b class="update">${recommendForum.todayThreads}</b></dd>
                       </c:if>
                       <c:if test="${recommendForum.todayThreads == 0}">
                       		<dd>今日  <b>${recommendForum.todayThreads}</b></dd>
                       </c:if>
                       <dd>帖子  ${recommendForum.totalThreads}</dd>
                   </a>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl}" class="zq r">礼包</a> 
                    </c:if> 
                   </div>
               </div>
               </c:forEach>
           </div>
           <!-- 新游推荐结束 -->
           
     
        </div>
        <!-- 内容结束 -->
        <!-- footer开始 -->
        <jsp:include page="footer_link.jsp" flush='true'/>
		<!-- footer结束 -->
    </div>	
    
   <script src="./js/mod/index.js"></script>
   
   
</body>

</html>
