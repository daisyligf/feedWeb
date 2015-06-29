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
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>魔方论坛-手机游戏玩家分享讨论基地</title>
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/index.css">
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
                         <div class="box clearfix" id="imgBox">
                            <!-- <div class="swipe-wrap"> -->
                               <ul class="swipe-wrap">
                                  <li>
                                    <a target="_blank" href="${tickers.threadLink1}"><img src="${tickers.tickerIcon1}"alt="" /></a>
                                    <b class="swipe-wrap-info" ></b>
                                  </li>
                                  <li>
                                    <a target="_blank" href="${tickers.threadLink2}"><img src="${tickers.tickerIcon2}"alt="" /></a>
                                    <b class="swipe-wrap-info" ></b>
                                  </li>
                                  <li>
                                    <a target="_blank" href="${tickers.threadLink3}"><img src="${tickers.tickerIcon3}"alt="" /></a>
                                    <b class="swipe-wrap-info" ></b>
                                  </li>
                               </ul>
                               <ol>
                                   <li class="active"></li>
                                   <li></li>
                                   <li></li>
                               </ol>
                            <!--  </div> -->
                         </div>
                    </div>
                    <div class="rec col-xs-6 col-md-6 col-sm-12">
                        <div class="col-xs-12 rec-con">
                            <dl class="title-red">
                                <dt><a target="_blank" href="thread_info?thread_id=${subjects.threadId1}">${subjects.threadName1} </a></dt>
                                <dd>${subjects.content1}</dd>
                            </dl>
                            <dl>
                                <dt><a target="_blank" href="thread_info?thread_id=${subjects.threadId2}">${subjects.threadName2}</a></dt>
                                <dd>${subjects.content2}</dd>
                            </dl>
                            <ul>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="thread_info?thread_id=${subjects.threadId3}">${subjects.threadName3} </a> <span class="lm"><a target="_blank" href="forum_content?fid=${subjects.forumId3}">${subjects.forumNmae3} </a></span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="thread_info?thread_id=${subjects.threadId4}">${subjects.threadName4} </a> <span class="lm"><a target="_blank" href="forum_content?fid=${subjects.forumId4}">${subjects.forumNmae4} </a></span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="thread_info?thread_id=${subjects.threadId5}">${subjects.threadName5} </a> <span class="lm"><a target="_blank" href="forum_content?fid=${subjects.forumId5}">${subjects.forumNmae5} </a></span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="thread_info?thread_id=${subjects.threadId6}">${subjects.threadName6} </a> <span class="lm"><a target="_blank" href="forum_content?fid=${subjects.forumId6}">${subjects.forumNmae6} </a></span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a target="_blank" href="thread_info?thread_id=${subjects.threadId7}">${subjects.threadName7} </a> <span class="lm"><a target="_blank" href="forum_content?fid=${subjects.forumId7}">${subjects.forumNmae7} </a></span></li>
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
                                    <li class="clearfix"><span class="num num-color">01</span><a target="_blank"  href="forum_content?fid=${hotRank.forumId1}" class="title"><img src="${hotRank.icon1}" alt="">${hotRank.forumName1} </a>
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
                                    <li class="clearfix"><span class="num num-color">02</span><a target="_blank"  href="forum_content?fid=${hotRank.forumId2}" class="title"><img src="${hotRank.icon2}" alt="">${hotRank.forumName2}</a>
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
                                    <li class="clearfix"><span class="num num-color">03</span><a target="_blank"  href="forum_content?fid=${hotRank.forumId3}" class="title"><img src="${hotRank.icon3}" alt="">${hotRank.forumName3}</a>
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
                                    <li class="clearfix"><span class="num">04</span><a target="_blank"  href="forum_content?fid=${hotRank.forumId4}" class="title"><img src="${hotRank.icon4}" alt="">${hotRank.forumName4}</a>
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
                                    <li class="clearfix"><span class="num">05</span><a target="_blank"  href="forum_content?fid=${hotRank.forumId5}" class="title"><img src="${hotRank.icon5}" alt="">${hotRank.forumName5}</a>
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
                                    <li class="clearfix"><a target="_blank"  href="forum_content?fid=${recommendRank.forumId1}" class="title"><img src="${recommendRank.icon1}" alt="">${recommendRank.forumName1}</a>
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
                                    <li class="clearfix"><a target="_blank"  href="forum_content?fid=${recommendRank.forumId2}" class="title"><img src="${recommendRank.icon2}" alt="">${recommendRank.forumName2}</a>
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
                                    <li class="clearfix"><a target="_blank"  href="forum_content?fid=${recommendRank.forumId3}" class="title"><img src="${recommendRank.icon3}" alt="">${recommendRank.forumName3}</a>
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
                                    <li class="clearfix"><a target="_blank"  href="forum_content?fid=${recommendRank.forumId4}" class="title"><img src="${recommendRank.icon4}" alt="">${recommendRank.forumName4}</a>
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
                                    <li class="clearfix"><a target="_blank"  href="forum_content?fid=${recommendRank.forumId5}" class="title"><img src="${recommendRank.icon5}" alt="">${recommendRank.forumName5}</a>
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
                       <dt><a target="_blank"  href="forum_content?fid=${officalForum.forumId1}"><img src="${officalForum.icon1}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${officalForum.forumId1}">${officalForum.forumName1}</a></dd>
                       <dd>今日  <b>${officalForum.todayThreads1}</b></dd>
                       <dd>帖子  ${officalForum.totalThreads1}</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${officalForum.forumId2}"><img src="${officalForum.icon2}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${officalForum.forumId2}">${officalForum.forumName2}</a></dd>
                       <dd>今日  <b>${officalForum.todayThreads2}</b></dd>
                       <dd>帖子  ${officalForum.totalThreads2}</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${officalForum.forumId3}"><img src="${officalForum.icon3}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${officalForum.forumId3}">${officalForum.forumName3}</a></dd>
                       <dd>今日  <b>${officalForum.todayThreads3}</b></dd>
                       <dd>帖子  ${officalForum.totalThreads3}</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${officalForum.forumId4}"><img src="${officalForum.icon4}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${officalForum.forumId4}">${officalForum.forumName4}</a></dd>
                       <dd>今日  <b>${officalForum.todayThreads4}</b></dd>
                       <dd>帖子  ${officalForum.totalThreads4}</dd>
                   </dl>
               </div>
               
           </div>
           <!-- 综合专区结束 -->
           <!-- 热门游戏开始 -->
           <div class="h2">热门游戏 <a target="_blank" href="forumList?forumType=1">更多 ></a></div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId1}"><img src="${hotForum.hotIcon1}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId1}">${hotForum.hotForumName1}</a></dd>
                       <dd>今日  <b class="update">${hotForum.hotTodayThreads1} </b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads1}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl1==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl1 != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl1}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl1==''}">
                      	<a href="javascript:;" class="zq bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl1 != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl1}"  class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId2}"><img src="${hotForum.hotIcon2}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId2}">${hotForum.hotForumName2}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads2}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads2}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl2==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl2 != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl2}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl2==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl2 != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl2}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId3}"><img src="${hotForum.hotIcon3}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId3}">${hotForum.hotForumName3}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads3}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads3}</dd>
                   </dl>
                   <div class="h2-con-bot">
                     <c:if  test="${hotForum.hotPrefectureUrl3==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl3 != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl3}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl3==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl3 != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl3}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId4}"><img src="${hotForum.hotIcon4}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId4}">${hotForum.hotForumName4}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads4}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads4}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl4==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl4 != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl4}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl4==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl4 != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl4}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId5}"><img src="${hotForum.hotIcon5}" alt=""></a></dt>
                       <dd><a target="_blank" href="forum_content?fid=${hotForum.hotForumId5}">${hotForum.hotForumName5}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads5}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads5}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl5==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl5 != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl5}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl5==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl5 != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl5}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId6}"><img src="${hotForum.hotIcon6}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId6}">${hotForum.hotForumName6}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads6}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads6}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl6==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl6 != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl6}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl6==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl6 != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl6}"  class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId7}"><img src="${hotForum.hotIcon7}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId7}">${hotForum.hotForumName7}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads7}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads7}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl7==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl7 != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl7}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl7==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl7 != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl7}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId8}"><img src="${hotForum.hotIcon8}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${hotForum.hotForumId8}">${hotForum.hotForumName8}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads8}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads8}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl8==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl8 != ''}">
                      <a target="_blank"  href="${hotForum.hotPrefectureUrl8}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl8==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl8 != ''}">
                      	<a target="_blank"  href="${hotForum.hotGiftUrl8}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>

           </div>
           <!-- 热门游戏结束 -->
          	<!-- 新游推荐开始 -->
           <div class="h2">新游推荐 <a target="_blank" href="forumList?forumType=2">更多 ></a></div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${recommendForum.forumId1}"><img src="${recommendForum.icon1}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${recommendForum.forumId1}">${recommendForum.forumName1}</a></dd>
                       <dd>今日  <b class="update">${recommendForum.todayThreads1}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads1}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl1==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl1 != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl1}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl1==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl1 != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl1}" class="zq r">礼包</a> 
                    </c:if> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${recommendForum.forumId2}"><img src="${recommendForum.icon2}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${recommendForum.forumId2}">${recommendForum.forumName2}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads2}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads2}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl2==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl2 != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl2}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl2==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl2 != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl2}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${recommendForum.forumId3}"><img src="${recommendForum.icon3}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${recommendForum.forumId3}">${recommendForum.forumName3}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads3}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads3}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl3==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl3 != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl3}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl3==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl3 != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl3}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${recommendForum.forumId4}"><img src="${recommendForum.icon4}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${recommendForum.forumId4}">${recommendForum.forumName4}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads4}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads4}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl4==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl4 != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl4}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl4==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl4 != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl4}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${recommendForum.forumId5}"><img src="${recommendForum.icon5}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${recommendForum.forumId5}">${recommendForum.forumName5}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads5}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads5}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl5==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl5 != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl5}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl5==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl5 != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl5}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${recommendForum.forumId6}"><img src="${recommendForum.icon6}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${recommendForum.forumId6}">${recommendForum.forumName6}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads6}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads6}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl6==''}">
                      <a href="#"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl6 != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl6}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl6==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl6 != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl6}" class="zq r">礼包</a> 
                    </c:if> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${recommendForum.forumId7}"><img src="${recommendForum.icon7}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${recommendForum.forumId7}">${recommendForum.forumName7}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads7}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads7}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl7==''}">
                      <a href="#"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl7 != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl7}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl7==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl7 != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl7}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a target="_blank"  href="forum_content?fid=${recommendForum.forumId8}"><img src="${recommendForum.icon8}" alt=""></a></dt>
                       <dd><a target="_blank"  href="forum_content?fid=${recommendForum.forumId8}">${recommendForum.forumName8}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads8}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads8}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl8==''}">
                      <a href="#"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl8 != ''}">
                      <a target="_blank"  href="${recommendForum.downloadUrl8}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl8==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl8 != ''}">
                      	<a target="_blank"  href="${recommendForum.giftUrl8}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               
           </div>
           <!-- 新游推荐结束 -->
           
     
        </div>
        <!-- 内容结束 -->
        <!-- footer开始 -->
		<jsp:include page="footer.jsp" flush='true'/>
		<!-- footer结束 -->
    </div>	
    
   <script src="./js/mod/index.js"></script>
   
   
</body>

</html>
