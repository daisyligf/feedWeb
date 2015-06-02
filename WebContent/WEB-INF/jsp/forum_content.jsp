<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="com.mofang.feedweb.entity.FeedForum"%>
<%@ page import="com.mofang.feedweb.entity.HotThread"%>
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
    <title>版块内容页</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/add_list_article.css">
    <script src="js/sea.js"></script>
    <script src="js/sea-config.js"></script>
    <!--{* IE6 png 图像处理 *}-->
    <!--[if IE 6]>
        <script src="js/loader/dd_belatedpng.js"></script>
        <script>
            DD_belatedPNG.fix('.pngfix');
        </script>
    <![endif]-->


    <!--{* ie8 以下浏览器html5兼容层 *}-->
    <!--[if lt IE 9]>
        <script src="js/loader/html5shiv.js"></script>
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
                <div class="nav-right">
                    <!-- 登陆状态 -->
                    <!-- <a href="#" class="head"><img src="statics/img/img1.jpg" alt="">蛋碎先生<s class="icon-red"></s></a>
                    <div class="user-info">
                        <ul class="clearfix">
                            <li class="header-money"><s class="icon-money"></s>34356</li>
                            <li class="zuji"><a href="#">足迹</a><a href="#" class="msg">消息<s class="icon-red"></s></a><a href="#" class="libao">礼包库</a></li>
                            <li class="info">
                               <a href="#">个人信息</a><a href="#">设置</a><a href="#" class="out">退出</a> 
                            </li>
                        </ul>
                    </div> -->
                    <!-- 登陆状态 -->
                    <a href="#" class="load"><img src="img/icon/load.png"></a>
                </div>
            </div>
            <div class="nav-wap clearfix">
              <div class="nav-wap-left">
                  <a href="http://www.mofang.com"><img src="img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a class="nav-info-home">首页</a>
                    <a>个人中心</a>
                  </p>
              </div> 
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
        <div class="search">
            <div class="bbs-logo">
                <img src="img/icon/bbs_icon.png" alt="">
            </div>
            <div class="bbs-search">
                <input type="submit" class="ser-but" value="" id="submit"/>
                <input type="text" class="ser-text" value="" id="keyword" placeholder="过来搜我"/>
            </div>
        </div>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
            <!-- 第一块内容top -->
            <div class="con-top container clearfix">
                <div class="con-top-con col-xs-12">
                    <dl>
                       <dt><img src="${feedForum.icon}" height="336" width="448" alt=""></dt>
                       <dd class="title">${feedForum.forum_name}</dd>
                       <dd>关注  ${feedForum.total_follows}</dd>
                       <dd>帖子  ${feedForum.total_threads}</dd>
                    </dl>
                    <a href="#" class="follow fllowed">+ 关注</a>
                    <a href="#" class="post">发帖</a>
                </div>
            </div>
           <!-- 第一块内容top结束 -->
           <!-- 帖子列表开始 -->
           <div class="con-bottom clearfix">
             <div class="col-xs-9 col-md-12">
                <div class="con-bot-left">
                    <div class="con-nav">
                        <div class="left">
                            <a href="#" class="active">综合</a>
                            <c:forEach var="tag" items="${feedForum.tags}">
                            	<a href="#">${tag.tag_name}</a>
                            </c:forEach>
                        </div>
                        <div class="right">
                            <div>
                                <span class="triangle">
                                    
                                </span>
                                <p>全部</p>
                                <p class="list">
                                    <a href="#">精华</a>
                                    <a href="#">精华1</a>
                                    <a href="#">精华2</a> 
                                </p>
                                
                            </div>
                            <div>
                                <span class="triangle">
                                    
                                </span>
                                <p>回复时间</p>
                                <p class="list">
                                    <a href="#">发帖时间</a>
                                    <a href="#">论坛时间</a>
                                    <a href="#">某个时间</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="con-left-con">
                    	<c:forEach var="feedThread" items="${threadList}">
                        <dl class="clearfix">
                            <dt><a href="#"><img src="img/img1.jpg"alt=""></a></dt>
                            <div class="infos">
                                <dd class="title"><a href="#">《最终幻想14》2.2新版截图推出炫耀装备系统 <s class="icon-ding"></s><s class="icon-jing"></s><s class="icon-tu"></s></a></dd>
                                <dd>是一款首发于iOS，而后跨平台的触摸类游戏。在游戏中，为了报复偷走鸟蛋的绿皮猪们</dd>
                                <dd class="info clearfix">
                                    <p class="author">
                                        <span>作者吧主</span>
                                        <span class="time">05-22 18:90</span>
                                    </p>
                                    <p class="look">
                                        <span><s class="icon-look"></s>3425</span>
                                        <span><s class="icon-ask"></s>563</span>
                                    </p>
                                </dd> 
                            </div>
                            
                        </dl>
                       </c:forEach>
                       
                        <div class="page-plug">
                            <ul class="page-pc">
                                <li class="prev"><a href="#">上一页</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li class="active"><a href="javascript:;">3</a></li>
                                <li><a href="#">4</a></li>
                                <li class="next"><a href="#">下一页</a></li>
                            </ul>
                            <ul class="page-mobile">
                                <li class="prev"><a href="#">上一页</a></li>
                                <li class="text">5/235</li>
                                <li class="next"><a href="#">下一页</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
             </div>
             <div class="col-xs-3 con-bot-right">
                <div class="lord-team">
                    <h2 class="lum">
                        吧主团队 <a href="#">申请吧主</a>
                    </h2>
                    <div class="lum-list">
                    	<c:forEach  var="roleInfo" items="${feedForum.roleList}">
                    		<dl>
                            	<dt><a href="#"><img src="${roleInfo.icon}" alt=""></a></dt>
                            	<dd><a href="#">${roleInfo.roleName}</a></dd>
                        	</dl> 
                    	</c:forEach>
                    </div>
                    
                </div>
                <c:choose>
                    <c:when test="${feedForum.type == 3}">
                        <div class="lord-team">
		                    <h2 class="lum">
		                    	最新热帖
		                    </h2>
		                    <div class="lum-list libao-list">
		                       <ul>
		                           <c:forEach var="hotThread" items="${hotThreadList}">
		                           <li><s class="black"></s><a href="#">${hotThread.subject}</a></li>
		                           </c:forEach>
		                       </ul>
		                    </div>
		                    
		                </div>
		                <div class="lord-team hot-tj">
		                    <!-- <div class="col-xs-12 hot-tj-con"> -->
		                        <h2 class="lum">
		                            热门游戏
		                        </h2>
		                       
		                        <div class="lum-list rec-list">
		                            <ul>
		                            	<c:set var="i" value="1"/>
		                            	<c:forEach var="newGame" items="${newGameList}">
		                           		<li class="clearfix"><span class="num num-color">0${i}</span><a href="#" class="title"><img src="${newGame.icon}" alt="">${newGame.forumName}</a><span class="rank"><a href="${newGame.downloadUrl}" target="_blank"></a><img src="img/icon/down.png"></a></span></li>
		                           		<c:set var="i" value="${i+1}"/>
		                           		</c:forEach>
		                            </ul>
		                        </div>
		                </div>	
                    </c:when>
                    <c:otherwise>
		               <div class="lord-team">
		                    <h2 class="lum">
		                    	礼包发号
		                    </h2>
		                    <div class="lum-list libao-list">
		                       <ul>
		                           <li><s class="black"></s><a href="#">我是大礼包</a></li>
		                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
		                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
		                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
		                           <li><s class="black"></s><a href="#">我是大礼包我是大礼包</a></li>
		                       </ul>
		                    </div>
		                    
		                </div>
		                <div class="lord-team hot-tj">
		                    <!-- <div class="col-xs-12 hot-tj-con"> -->
		                        <h2 class="lum">
		                            新游推荐
		                        </h2>
		                       
		                        <div class="lum-list rec-list">
		                            <ul>
		                                <li class="clearfix"><span class="num num-color">01</span><a href="#" class="title"><img src="img/img1.jpg" alt="">保卫萝卜</a><span class="rank"><img src="img/icon/down.png"></span></li>
		                                <li class="clearfix"><span class="num num-color">02</span><a href="#" class="title"><img src="img/img1.jpg" alt="">保卫萝卜</a><span class="rank"><img src="img/icon/up.png"></span></li>
		                                <li class="clearfix"><span class="num num-color">03</span><a href="#" class="title"><img src="img/img1.jpg" alt="">保卫萝卜</a><span class="rank"><img src="img/icon/level.png"></span></li>
		                                <li class="clearfix"><span class="num">04</span><a href="#" class="title"><img src="img/img1.jpg" alt="">保卫萝卜</a><span class="rank"><img src="img/icon/up.png"></span></li>
		                                <li class="clearfix"><span class="num">05</span><a href="#" class="title"><img src="img/img1.jpg" alt="">保卫萝卜</a><span class="rank"><img src="img/icon/up.png"></span></li>
		
		                            </ul>
		                        </div>
		                </div>
                     </c:otherwise>
                </c:choose>
                
             </div>
           </div>
              
           <!-- 帖子列表结束 -->
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
    </div>
    
   <script src="js/mod/list_article.js"></script>
   
</body>
</html>