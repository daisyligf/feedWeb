<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <title>bbs首页</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/index.css">
    <script src="./js/sea.js"></script>
    <script src="./js/sea-config.js"></script>
    <script src="./js/bbs-config.js"></script>
    <script type="text/javascript" src="./js/jquery-2.1.4.js"></script>
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
            <div class="nav clearfix">
                <div class="nav-left">
                    <a href="http://www.mofang.com">魔方网首页</a>
                </div>
                <div class="nav-right" id="topUserInfo">
                    <!-- 登陆状态 -->
                    <!-- top登录模板 -->
                    
                    <a href="http://u.mofang.com/home/person/index" class="head" id="userName"><img src="" alt="" id="userImg" /><s class="icon-red"></s><s class="icon-red"></s></a>
                    <div class="user-info">
                        <ul class="clearfix">
                            <li class="header-money" id="userMoney"><s class="icon-money"></s></li>
                            <li class="zuji"><a href="http://u.mofang.com/home/footprints/games" class="zj">足迹<s class="icon-red"></s></a><a href="http://u.mofang.com/home/message/reply" class="msg">消息<s class="icon-red"></s></a><a href="http://u.mofang.com/home/package/index" class="libao">礼包库<s class="icon-red"></s></a></li>
                            <li class="info">
                               <a href="http://u.mofang.com/home/person/index">个人信息</a><a href="http://u.mofang.com/home/setting/info">设置</a><a href="javascript:;" class="out" id="logout">退出</a> 
                            </li>
                        </ul>
                    </div>
                    
                    <!-- 登陆状态 -->
                    <a href="http://u.mofang.com/home/account/index" class="load" target="_blank"><img src="./img/icon/load.png"></a>
                </div>
            </div>
            <div class="nav-wap clearfix">
                <div class="nav-wap-left">
                  <a href="javascript:;"><img src="./img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a href="http://bbs.mofang.com" class="nav-info-home">首页</a>
                    <a href="http://u.mofang.com">个人中心</a>
                  </p>
                </div>
                  <div class="wap-logo">
                    <img src="./img/icon/bbs_icon_wap.png"alt="">
                  </div>
               
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
        <div class="search">
            <div class="bbs-logo">
                <img src="./img/icon/bbs_icon.png" alt="">
            </div>
            <div class="bbs-search">
               <!--   <input type="submit" class="ser-but" value="" id="submit"/>-->
               <input type="button" class="ser-but" value="" name="search" id="search"/>
                <input type="text" class="ser-text" value="${searchKey} " id="searchKey" placeholder="过来搜我"/>
            </div>
        </div>
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
                                    <a href="${tickers.threadLink1} "><img src="${tickers.tickerIcon1} "alt="" /></a>
                                    <b class="swipe-wrap-info" ></b>
                                  </li>
                                  <li>
                                    <a href="${tickers.threadLink2}"><img src="${tickers.tickerIcon2}"alt="" /></a>
                                    <b class="swipe-wrap-info" ></b>
                                  </li>
                                  <li>
                                    <a href="${tickers.threadLink3}"><img src="${tickers.tickerIcon3}"alt="" /></a>
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
                                <dt><a href="#">${subjects.threadName1} </a></dt>
                                <dd>${subjects.content1}</dd>
                            </dl>
                            <dl>
                                <dt><a href="#">${subjects.threadName2}</a></dt>
                                <dd>${subjects.content2}</dd>
                            </dl>
                            <ul>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a href="#">${subjects.threadName3} </a> <span class="lm">${subjects.forumNmae3} </span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a href="#">${subjects.threadName4} </a> <span class="lm">${subjects.forumNmae4} </span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a href="#">${subjects.threadName5} </a> <span class="lm">${subjects.forumNmae5} </span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a href="#">${subjects.threadName6} </a> <span class="lm">${subjects.forumNmae6} </span></li>
                                 <li class="clearfix"><span class="icon-black-splot"></span><a href="#">${subjects.threadName7} </a> <span class="lm">${subjects.forumNmae7} </span></li>
                             </ul> 
                        </div>
                    </div>
                </div>
                <div class="col-xs-3 col-md-12 col-sm-12 hot-tj">
                    <div class="col-xs-12 hot-tj-con">
                        <div class="hot-nav">
                            <a href="javascript:;" class="active">热门板块</a>
                            <a href="javascript:;" class="">新游推荐</a>
                        </div>
                        <div id="hotNewTab" style="overflow:hidden;">
                            <div class="hot-con swipe-wrap">
                                
                                <ul>
                                    <li class="clearfix"><span class="num num-color">01</span><a href="#" class="title"><img src="${hotRank.icon1} " alt="">${hotRank.forumName1} </a>
	                                    <span class="rank">
		                                     <c:if test="${hotRank.upDown1==0}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown1==1}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown1==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
		                                </span>
                                    </li>
                                    <li class="clearfix"><span class="num num-color">02</span><a href="#" class="title"><img src="${hotRank.icon2} " alt="">${hotRank.forumName2}</a>
                                    <span class="rank">
                                     		<c:if test="${hotRank.upDown2==0}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==1}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    </span>
                                    </li>
                                    <li class="clearfix"><span class="num num-color">03</span><a href="#" class="title"><img src="${hotRank.icon3} " alt="">${hotRank.forumName3}</a>
                                    	<span class="rank">
                                    		<c:if test="${hotRank.upDown2==0}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==1}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    	</span>
                                    </li>
                                    <li class="clearfix"><span class="num">04</span><a href="#" class="title"><img src="${hotRank.icon4} " alt="">${hotRank.forumName4}</a>
                                    	<span class="rank">
                                    	    <c:if test="${hotRank.upDown2==0}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==1}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    	</span>
                                    </li>
                                    <li class="clearfix"><span class="num">05</span><a href="#" class="title"><img src="${hotRank.icon5} " alt="">${hotRank.forumName5}</a>
                                    	<span class="rank">
                                    	    <c:if test="${hotRank.upDown2==0}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==1}">
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2==2}">
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    	</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li class="clearfix"><a href="#" class="title"><img src="${recommendRank.icon1}" alt="">${recommendRank.forumName1}</a><span><a class="package" href="${recommendRank.giftUrl1}">礼包</a> <a class="down" href="${recommendRank.downLoadUrl1}">下载</a></span></li>
                                    <li class="clearfix"><a href="#" class="title"><img src="${recommendRank.icon2}" alt="">${recommendRank.forumName2}</a><span><a class="package" href="${recommendRank.giftUrl2}">礼包</a> <a class="down" href="${recommendRank.downLoadUrl2}">下载</a></span></li>
                                    <li class="clearfix"><a href="#" class="title"><img src="${recommendRank.icon3}" alt="">${recommendRank.forumName3}</a><span><a class="package" href="${recommendRank.giftUrl3}">礼包</a> <a class="down" href="${recommendRank.downLoadUrl3}">下载</a></span></li>
                                    <li class="clearfix"><a href="#" class="title"><img src="${recommendRank.icon4}" alt="">${recommendRank.forumName4}</a><span><a class="package" href="${recommendRank.giftUrl4}">礼包</a> <a class="down" href="${recommendRank.downLoadUrl4}">下载</a></span></li>
                                    <li class="clearfix"><a href="#" class="title"><img src="${recommendRank.icon5}" alt="">${recommendRank.forumName5}</a><span><a class="package" href="${recommendRank.giftUrl5}">礼包</a> <a class="down" href="${recommendRank.downLoadUrl5}">下载</a></span></li>

                                </ul>
                            </div>
                        </div>
                        
                    </div>
                    
                </div>

            </div>
           <!-- 第一块内容结束 -->
           <!-- 热门游戏开始 -->
           <div class="h2">热门游戏 <a href="forumList?forumType=1">更多 ></a></div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="# "><img src="${hotForum.hotIcon1}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName1}</a></dd>
                       <dd>今日  <b class="update">${hotForum.hotTodayThreads1} </b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads1}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl1==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl1 != ''}">
                      <a href="${hotForum.hotPrefectureUrl1}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl1==''}">
                      	<a href="javascript:;" class="zq bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl1 != ''}">
                      	<a href="${hotForum.hotGiftUrl1}"  class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon2}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName2}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads2}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads2}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl2==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl2 != ''}">
                      <a href="${hotForum.hotPrefectureUrl2}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl2==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl2 != ''}">
                      	<a href="${hotForum.hotGiftUrl2}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon3}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName3}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads3}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads3}</dd>
                   </dl>
                   <div class="h2-con-bot">
                     <c:if  test="${hotForum.hotPrefectureUrl3==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl3 != ''}">
                      <a href="${hotForum.hotPrefectureUrl3}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl3==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl3 != ''}">
                      	<a href="${hotForum.hotGiftUrl3}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon4}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName4}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads4}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads4}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl4==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl4 != ''}">
                      <a href="${hotForum.hotPrefectureUrl4}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl4==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl4 != ''}">
                      	<a href="${hotForum.hotGiftUrl4} r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon5}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName5}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads5}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads5}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl5==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl5 != ''}">
                      <a href="${hotForum.hotPrefectureUrl5}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl5==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl5 != ''}">
                      	<a href="${hotForum.hotGiftUrl5}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon6}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName6}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads6}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads6}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl6==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl6 != ''}">
                      <a href="${hotForum.hotPrefectureUrl6}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl6==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl6 != ''}">
                      	<a href="${hotForum.hotGiftUrl6}"  class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon7}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName7}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads7}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads7}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl7==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl7 != ''}">
                      <a href="${hotForum.hotPrefectureUrl7}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl7==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl7 != ''}">
                      	<a href="${hotForum.hotGiftUrl7}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon8}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName8}</a></dd>
                       <dd>今日  <b>${hotForum.hotTodayThreads8}</b></dd>
                       <dd>帖子  ${hotForum.hotTotalThreads8}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotForum.hotPrefectureUrl8==''}">
                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotPrefectureUrl8 != ''}">
                      <a href="${hotForum.hotPrefectureUrl8}"  class="zq l">专区</a>
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl8==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${hotForum.hotGiftUrl8 != ''}">
                      	<a href="${hotForum.hotGiftUrl8}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>

           </div>
           <!-- 热门游戏结束 -->
          	<!-- 新游推荐开始 -->
           <div class="h2">新游推荐 <a href="forumList?forumType=2">更多 ></a></div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${recommendForum.icon1}" alt=""></a></dt>
                       <dd><a href="#">${recommendForum.forumName1}</a></dd>
                       <dd>今日  <b class="update">${recommendForum.todayThreads1}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads1}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl1==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl1 != ''}">
                      <a href="${recommendForum.downloadUrl1}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl1==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl1 != ''}">
                      	<a href="${recommendForum.giftUrl1}" class="zq r">礼包</a> 
                    </c:if> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${recommendForum.icon2}" alt=""></a></dt>
                       <dd><a href="#">${recommendForum.forumName2}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads2}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads2}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl2==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl2 != ''}">
                      <a href="${recommendForum.downloadUrl2}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl2==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl2 != ''}">
                      	<a href="${recommendForum.giftUrl2}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${recommendForum.icon3}" alt=""></a></dt>
                       <dd><a href="#">${recommendForum.forumName3}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads3}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads3}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl3==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl3 != ''}">
                      <a href="${recommendForum.downloadUrl3}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl3==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl3 != ''}">
                      	<a href="${recommendForum.giftUrl3}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${recommendForum.icon4}" alt=""></a></dt>
                       <dd><a href="#">${recommendForum.forumName4}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads4}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads4}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl4==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl4 != ''}">
                      <a href="${recommendForum.downloadUrl4}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl4==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl4 != ''}">
                      	<a href="${recommendForum.giftUrl4}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${recommendForum.icon5}" alt=""></a></dt>
                       <dd><a href="#">${recommendForum.forumName5}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads5}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads5}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl5==''}">
                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl5 != ''}">
                      <a href="${recommendForum.downloadUrl5}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl5==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl5 != ''}">
                      	<a href="${recommendForum.giftUrl5}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${recommendForum.icon6}" alt=""></a></dt>
                       <dd><a href="#">${recommendForum.forumName6}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads6}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads6}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl6==''}">
                      <a href="#"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl6 != ''}">
                      <a href="${recommendForum.downloadUrl6}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl6==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl6 != ''}">
                      	<a href="${recommendForum.giftUrl6}" class="zq r">礼包</a> 
                    </c:if> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${recommendForum.icon7}" alt=""></a></dt>
                       <dd><a href="#">${recommendForum.forumName7}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads7}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads7}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl7==''}">
                      <a href="#"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl7 != ''}">
                      <a href="${recommendForum.downloadUrl7}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl7==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl7 != ''}">
                      	<a href="${recommendForum.giftUrl7}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${recommendForum.icon8}" alt=""></a></dt>
                       <dd><a href="#">${recommendForum.forumName8}</a></dd>
                       <dd>今日  <b>${recommendForum.todayThreads8}</b></dd>
                       <dd>帖子  ${recommendForum.totalThreads8}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${recommendForum.downloadUrl8==''}">
                      <a href="#"  class="zq bg-grey l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.downloadUrl8 != ''}">
                      <a href="${recommendForum.downloadUrl8}"  class="zq l">下载</a>
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl8==''}">
                      	<a href="javascript:;" class="bg-grey r">礼包</a> 
                    </c:if>
                    <c:if  test="${recommendForum.giftUrl8 != ''}">
                      	<a href="${recommendForum.giftUrl8}" class="zq r">礼包</a> 
                    </c:if>
                   </div>
               </div>
               
           </div>
           <!-- 新游推荐结束 -->
           <!-- 综合专区开始 -->
           <div class="h2">综合专区</div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${officalForum.icon1} " alt=""></a></dt>
                       <dd><a href="#">${officalForum.forumName1}</a></dd>
                       <dd>今日  <b>${officalForum.todayThreads1}</b></dd>
                       <dd>帖子  ${officalForum.totalThreads1}</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${officalForum.icon2}" alt=""></a></dt>
                       <dd><a href="#">${officalForum.forumName2}</a></dd>
                       <dd>今日  <b>${officalForum.todayThreads2}</b></dd>
                       <dd>帖子  ${officalForum.totalThreads2}</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${officalForum.icon3}" alt=""></a></dt>
                       <dd><a href="#">${officalForum.forumName3}</a></dd>
                       <dd>今日  <b>${officalForum.todayThreads3}</b></dd>
                       <dd>帖子  ${officalForum.totalThreads3}</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${officalForum.icon4}" alt=""></a></dt>
                       <dd><a href="#">${officalForum.forumName4}</a></dd>
                       <dd>今日  <b>${officalForum.todayThreads4}</b></dd>
                       <dd>帖子  ${officalForum.totalThreads4}</dd>
                   </dl>
               </div>
               
           </div>
           <!-- 综合专区结束 -->
     
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
    </div>	
    
   <script src="./js/mod/index.js"></script>
   <script src="./js/mod/common.js"></script>
   
</body>
<script type="text/javascript">
$('#search').click(function() {
	var searchKey = $('#searchKey').val();
	window.location.href = "search?keyword="+searchKey;
});

</script>
</html>
