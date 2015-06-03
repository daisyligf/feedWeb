<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <title>bbs首页</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/index.css">
    <script src="./js/sea.js"></script>
    <script src="./js/sea-config.js"></script>
    <script src="./js/bbs-config.js"></script>
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
                <input type="submit" class="ser-but" value="" id="submit"/>
                <input type="text" class="ser-text" value="${recommendSearchKey} " id="keyword" placeholder="过来搜我"/>
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
                                    <a href="${tickers.thread_link1} "><img src="${tickers.ticker_icon1} "alt="" /></a>
                                    <b class="swipe-wrap-info" >愤怒的小鸟作者再出神作</b>
                                  </li>
                                  <li>
                                    <a href="${tickers.thread_link2}"><img src="${tickers.ticker_icon2}"alt="" /></a>
                                    <b class="swipe-wrap-info" >愤怒的小鸟作者再出神作</b>
                                  </li>
                                  <li>
                                    <a href="${tickers.thread_link3}"><img src="${tickers.ticker_icon3}"alt="" /></a>
                                    <b class="swipe-wrap-info" >愤怒的小鸟作者再出神作</b>
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
		                                    <c:if  test="${hotRank.upDown1=='0'}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown1=='1'}>
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown1=='2'}>
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
		                                </span>
                                    </li>
                                    <li class="clearfix"><span class="num num-color">02</span><a href="#" class="title"><img src="${hotRank.icon2} " alt="">${hotRank.forumName2}</a>
                                    <span class="rank">
                                     		<c:if  test="${hotRank.upDown2=='0'}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2=='1'}>
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2=='2'}>
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    </span>
                                    </li>
                                    <li class="clearfix"><span class="num num-color">03</span><a href="#" class="title"><img src="${hotRank.icon3} " alt="">${hotRank.forumName3}</a>
                                    	<span class="rank">
                                    		<c:if  test="${hotRank.upDown2=='0'}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2=='1'}>
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2=='2'}>
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    	</span>
                                    </li>
                                    <li class="clearfix"><span class="num">04</span><a href="#" class="title"><img src="${hotRank.icon4} " alt="">${hotRank.forumName4}</a>
                                    	<span class="rank">
                                    	    <c:if  test="${hotRank.upDown2=='0'}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2=='1'}>
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2=='2'}>
		                                    	<img src="./img/icon/level.png">
		                                    </c:if>
                                    	</span>
                                    </li>
                                    <li class="clearfix"><span class="num">05</span><a href="#" class="title"><img src="${hotRank.icon5} " alt="">${hotRank.forumName5}</a>
                                    	<span class="rank">
                                    	     <c:if  test="${hotRank.upDown2=='0'}">
		                                    	<img src="./img/icon/up.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2=='1'}>
		                                    	<img src="./img/icon/down.png">
		                                    </c:if>
		                                    <c:if test="${hotRank.upDown2=='2'}>
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
           <div class="h2">热门游戏 <a href="#">更多 ></a></div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="# "><img src="${hotForum.hotIcon1}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName1}</a></dd>
                       <dd>今日  <b class="update">${hotForum.hotTodayThreads1} </b></dd>
                       <dd>帖子  ${hotForum.hotTodayThreads1}</dd>
                   </dl>
                   <div class="h2-con-bot">
                    <c:if  test="${hotRank.upDown1==''}">
                      <a href="${hotForum.hotTodayThreads1}"  class="zq bg-grey">专区</a>
                      <a href="javascript:;" class="bg-grey">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon2}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName2}</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon3}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName3}</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon4}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName4}</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon5}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName5}</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon6}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName6}</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon7}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName7}</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="${hotForum.hotIcon8}" alt=""></a></dt>
                       <dd><a href="#">${hotForum.hotForumName8}</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>

           </div>
           <!-- 热门游戏结束 -->
           <!-- 新游推荐开始 -->
           <div class="h2">新游推荐 <a href="#">更多 ></a></div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b class="update">1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="#"  class="zq">专区</a><a href="#">礼包</a> 
                   </div>
               </div>
               
           </div>
           <!-- 新游推荐结束 -->
           <!-- 综合专区开始 -->
           <div class="h2">综合专区</div>
           <div class="h2-con clearfix container">
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b class="update">1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
                   </dl>
               </div>
               <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="./img/img1.jpg" alt=""></a></dt>
                       <dd><a href="#">金箍棒OL</a></dd>
                       <dd>今日  <b>1352</b></dd>
                       <dd>帖子  10870</dd>
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
</html>
