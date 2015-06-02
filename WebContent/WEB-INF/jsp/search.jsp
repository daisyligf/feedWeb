<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>bbs搜索页</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
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
                    <a href="#" class="load"><img src="statics/img/icon/load.png"></a>
                </div>
            </div>
            <div class="nav-wap clearfix">
              <div class="nav-wap-left">
                  <a href="http://www.mofang.com"><img src="statics/img/icon/nav_three.png"></a>
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
                <img src="statics/img/icon/bbs_icon.png" alt="">
            </div>
            <div class="bbs-search">
                <form action="search.html">
                    <input type="submit" class="ser-but" value="" id="submit"/>
                    <input type="text" class="ser-text" value="" id="keyword" placeholder="过来搜我"/>
                </form> 
            </div>
        </div>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
            
           <!-- 搜索板块开始 -->
           <div class="h2">板块<span>${forumTotalPages}</span> <a href="javascript:;" id="plateMore" class="plate-more">更多 ></a></div>
           <!-- 板块模板 -->
            <script id="plateTemplate" type="text/x-handlebars-template">
                {{#each list}}
                <div class="col-xs-3 col-md-4  col-sm-6">
                   <dl class="clearfix">
                       <dt><a href="#"><img src="{{icon}}" alt=""></a></dt>
                       <dd><a href="#">{{name}}</a></dd>
                       <dd>今日  {{today_threads}}</dd>
                       <dd>帖子  {{threads}}</dd>
                   </dl>
                   <div class="h2-con-bot">
                      <a href="{{prefecture_url}}"  class="zq">专区</a><a href="{{gift_url}}">礼包</a> 
                   </div>
                </div>
                {{/each}} 
            </script>
           <div class="h2-con clearfix container" id="plate">
                
                <c:forEach items="${forumList}" var="forum">
			            <div class="col-xs-3 col-md-4  col-sm-6">
		                   <dl class="clearfix">
		                       <dt><a href="${forum.forum_url}"><img src="${forum.icon}" alt=""></a></dt>
		                       <dd><a href="${forum.forum_url}">${forum.forum_name}</a></dd>
		                       <dd>今日  ${forum.today_threads}</dd>
		                       <dd>帖子  ${forum.total_threads}</dd>
		                   </dl>
		                   <div class="h2-con-bot">
		                      <a href="${forum.prefecture_url}"  class="zq">专区</a><a href="${forum.gift_url}">礼包</a> 
		                   </div>
		                </div>
	           </c:forEach>
                
           </div> 
           <!-- 搜索板块结束 -->
              
           <!-- 搜索帖子开始 -->
           <div class="h2">帖子<span>${threadTotalPages}</span><a href="#">更多 ></a></div>
            <div class="con-bottom clearfix">
             <div class="col-xs-12 bg-white">

                                    <!-- <s class="icon-ding"></s><s class="icon-jing"></s><s class="icon-tu"></s> -->
                <!-- 帖子模板 -->
                <script id="postTemplate" type="text/x-handlebars-template">
                    {{#each list}}
                    <dl class="clearfix">
                        <dt><a href="{{link_url}}"><img src="{{avatar}}"alt=""></a></dt>
                        <div class="infos">
                            <dd class="title">
                                <a href="{{link_url}}">{{title}}

                                    
                                    {{compare tags}}
                                    
                                </a>
                            </dd>
                            <dd>{{subject}}</dd>
                            <dd class="info clearfix">
                                <p class="author">
                                    <span>{{nickname}}</span>
                                    <span class="time">{{utime}}</span>
                                </p>
                                <p class="look">
                                    <span><s class="icon-look"></s>{{pageview}}</span>
                                    <span><s class="icon-ask"></s>{{replies}}</span>
                                </p>
                            </dd> 
                        </div>
                        
                    </dl>
                    {{/each}} 
                </script>
                <div class="con-left-con" id="post">
                
<!--                     <dl class="clearfix">
                        <dt><a href="#"><img src="statics/img/img1.jpg"alt=""></a></dt>
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
                        
                    </dl> -->
                   
                    <c:forEach items="${threadList}" var="thread">
	                    <dl class="clearfix">
	                        <dt><a href="#"><img src="${thread.icon}" alt=""></a></dt>
	                        <div class="infos">
	                            <dd class="title"><a href="#">${thread.thread_name}<s class="icon-ding"></s><s class="icon-jing"></s><s class="icon-tu"></s></a></dd>
	                            <dd>${thread.content }</dd>
	                            <dd class="info clearfix">
	                                <p class="author">
	                                    <span>作者吧主 ${thread.user_name }</span>
	                                    <span class="time">${thread.create_time }</span>
	                                </p>
	                                <p class="look">
	                                    <span><s class="icon-look"></s>${thread.page_view }</span>
	                                    <span><s class="icon-ask"></s>${thread.replies }</span>
	                                </p>
	                            </dd> 
	                        </div>
	                        
	                    </dl>
                   </c:forEach>
                   
                </div>
                <div class="page-plug">
                    <ul class="page-pc" id="pagePc">
                    	<!-- 上一页 -->
                    	<c:choose>
                    		<c:when test="${threadPage != 1 }">
                    			<li class="prev"><a href="thread/search?p=${threadPage-1}&fid=${fid}&status=${status}&keyword=${keyword}&author=${author}">上一页</a></li>
                    		</c:when>
                    		<c:otherwise>
                    			<li class="prev"><a href="#" >上一页</a></li>
                    		</c:otherwise>
                    	</c:choose>
                    	
 						<!-- 页数列表 -->
						<c:forEach items="${threadPageList}" var="item">
							<c:choose>
								<c:when test="${item == threadPage}">
									<li class="active"><a href="thread/search?p=${item }&fid=${fid}&status=${status}&keyword=${keyword}&author=${author}">${item }</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="thread/search?p=${item }&fid=${fid}&status=${status}&keyword=${keyword}&author=${author}">${item }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
                    	
						<!-- 下一页 按钮 -->
						<c:choose>
							<c:when test="${threadPage != threadTotalPages}">
								<li class="next"><a href="thread/search?p=${threadPage+1}&fid=${fid}&status=${status}&keyword=${keyword}&author=${author}">下一页</a></li>
							</c:when>
							<c:otherwise>
								<li class="next"><a href="#">下一页</a></li>
							</c:otherwise>
						</c:choose>                    	
                    	
<!--                         <li class="prev"><a href="#">上一页</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li class="active"><a href="javascript:;">3</a></li>
                        <li><a href="#">4</a></li>
                        <li class="next"><a href="#">下一页</a></li> -->
                        
                    </ul>

                    <ul class="page-mobile">
                        <li class="prev"><a href="#">上一页</a></li>
                        <li class="text">5/235</li>
                        <li class="next"><a href="#">下一页</a></li>
                    </ul>
                </div>
             </div>
           </div>
              
           <!-- 搜索帖子结束 -->
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
    </div>
    
   <script src="js/mod/search.js"></script>
   
</body>
</html>
