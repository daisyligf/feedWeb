<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="com.mofang.feedweb.entity.FeedForum"%>
<%@ page import="com.mofang.feedweb.entity.FeedThread"%>
<%@ page import="com.mofang.feedweb.entity.FeedPost"%>
<%@ page import="com.mofang.feedweb.entity.FeedComment"%>
<%@ page import="com.mofang.feedweb.entity.ThreadUserInfo"%>
<%@ page import="com.mofang.feedweb.entity.CurrentUser"%>
<%@ page import="com.mofang.feedweb.global.SysPrivilege"%>
<%@ page import="com.mofang.feedweb.entity.UserInfo"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <meta name="keywords" content="${feedForum.gameName},${feedForum.gameName},魔方论坛">
   	<meta name="description" content="${feedThread.content_sub100}。更多${feedForum.gameName}的精彩内容，请关注魔方${feedForum.gameName}论坛(版块)。">
    <title>${feedThread.subject}_${feedForum.gameName}论坛(版块)_魔方论坛: 最懂你的手机游戏社区</title>
    <link rel="shortcut icon" href="<%=CommonUrl.baseUrl%>/img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=CommonUrl.baseUrl%>/css/base.css">

    <link rel="stylesheet" href="<%=CommonUrl.baseUrl%>/js/editor/css/umeditor.css">
    <link rel="stylesheet" href="<%=CommonUrl.baseUrl%>/js/editor/css/fixeditor.css">
    <link rel="stylesheet" href="<%=CommonUrl.baseUrl%>/js/editor/emotion.css">

    <link rel="stylesheet" href="<%=CommonUrl.baseUrl%>/css/common.css">
    <link rel="stylesheet" href="<%=CommonUrl.baseUrl%>/css/article_article.css">
    <script src="<%=CommonUrl.baseUrl%>/js/sea.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/sea-config.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/bbs-config.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/mod/common.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/editor/js/jquery.min.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/editor/js/umeditor.config.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/editor/js/umeditor.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/editor/lang/zh-cn/zh-cn.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/editor/btn.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/editor/feed-emotion.js"></script>
    
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
                  <a href="<%=request.getHeader("Referer") %>" class="nav-wap-back"></a>
                  <a href="javascript:;" class="nav-wap-list"><img src="<%=CommonUrl.baseUrl%>/img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a href="<%=CommonUrl.bbsHomeUrl%>" class="nav-info-home">论坛首页</a>
                    <a href="<%=CommonUrl.mofangHomeUrl%>">魔方首页</a>
                  </p>
                </div>
                <div class="nav-wap-right">
                <a href="#conRight3" class="nav-wap-comment">评论</a>

                <c:choose>
                   	<c:when test="${type==1 }">
                   	<a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/1/0/0.html" class="nav-wap-floor">全部</a>
                   	</c:when>
                   	<c:otherwise>
                   	<a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/1/1/0.html" class="nav-wap-floor">楼主</a>
                   	</c:otherwise>
                   </c:choose>                
                
                
                	
                </div>
                  <!-- <div class="wap-logo">
                    帖子详情
                  </div> -->
                  <div class="wap-nav-text">
                  	帖子详情
                  </div>
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
        <jsp:include page="commonSearch.jsp" flush='true'/>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
            <div class="nav clearfix">
                <div class="nav-left col-xs-6">
                    <a href="<%=CommonUrl.bbsHomeUrl%>">论坛首页</a> > <a href="<%=CommonUrl.baseUrl%>/forum/${feedForum.forum_id}.html">${feedForum.forum_name }</a> > <a href="javascript:;" class="end">${feedThread.subject }</a>
                </div>
                
                <c:if test="${totalPages > 1 }">
                <div class="page-plug col-xs-6">
                <ul class="page-pc">
                <!-- 上一页 按钮 -->
                
				<c:choose>
				<c:when test="${currentPage != 1}">
					<li class="prev"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${currentPage-1}/${type}/0.html">上一页</a></li>
				</c:when>
				<c:otherwise>
					<!--  <li class="prev" disabled="true" ><a ></a></li>--><!-- 为了要那个灰掉的button -->
				</c:otherwise>
				</c:choose>
				
				<!-- 页数列表 -->
				<c:forEach items="${pagelist}" var="item">
				<c:choose>
				<c:when test="${item == currentPage}">
					<c:if test="${item == 0}">
					<li class="active"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/1/${type}/0.html" >首页</a></li>
					</c:if>
					<c:if test="${item == -1}">
					<li class="active"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${totalPages}/${type}/0.html" >尾页</a></li>
					</c:if>
					<c:if test="${item != 0}">
					  	<c:if test="${item != -1}">
						<li class="active"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${item}/${type}/0.html" >${item}</a></li>
						</c:if>
					</c:if>
				</c:when>
				<c:otherwise>
				<c:if test="${item == 0}">
					<li><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/1/${type}/0.html">首页</a></li>
				</c:if>
				<c:if test="${item == -1}">
					<li><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${totalPages}/${type}/0.html">尾页</a></li>
				</c:if>
				<c:if test="${item != 0}">
					<c:if test="${item != -1}">
						<li><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${item}/${type}/0.html">${item}</a></li>
					</c:if>
				</c:if>
				</c:otherwise>
				</c:choose>
				</c:forEach>
				
				<!-- 下一页 按钮 -->
				<c:choose>
				<c:when test="${currentPage != totalPages}">
					<li class="next"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${currentPage+1}/${type}/0.html">下一页</a></li>
				</c:when>
				<c:otherwise>
					<!--  <li class="next" disabled="true"><a >下一页</a></li>-->
				</c:otherwise>
				</c:choose>
				<!-- 页码跳转 -->
				<li class="jump-text"><input type="text" /></li><li class="jump-page-btn"><a href="javascript:;">跳转</a></li>
                </ul>
                

            </div>
            </c:if>
            </div>
            <div class="col-xs-3 user-info-out">
                <div class="user-info">
                   <dl>
                        <dt><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${threadUserInfo.userId}" class="user-info-icon" target="_blank"><img src="${threadUserInfo.avatar}" alt=""><span class="grade">Lv.${threadUserInfo.level}</span></a></dt>
                        <dd><a href='<%=UserCenter.baseUrl %>/home/public/info?to_uid=${threadUserInfo.userId}' target="_blank">${threadUserInfo.nickname}</a></dd>
                        <dd class="money"><s class="icon-money"></s>${threadUserInfo.coin}</dd>
                    </dl>
                    <ul class="clearfix">
                        <li class="col-xs-4"><span><a href="<%=UserCenter.baseUrl %>/home/public/mythreads?to_uid=${threadUserInfo.userId}" target="_blank">${threadUserInfo.threads}</a></span>帖子</li>
                        <li class="col-xs-4"><span><a href="<%=UserCenter.baseUrl %>/home/public/myreply?to_uid=${threadUserInfo.userId}" target="_blank">${threadUserInfo.replies}</a></span>回复</li>
                        <li class="col-xs-4 no-line"><span>${threadUserInfo.eliteThreads}</span>精华</li>
                    </ul> 
                </div>
                <div class="lord-team">
                    <h2 class="lum">
                        最热推荐
                    </h2>
                    <div class="lum-list libao-list">
                       <ul>
                       	   <c:forEach var="highThread" items="${highestList }">
                       	   <li><s class="black"></s><a href="<%=CommonUrl.baseUrl%>/thread/${highThread.thread_id}.html">${fn:substring(highThread.subject, 0, 16)}
                       	   <c:if test="${fn:length(highThread.subject) > 16}">
                       	   ...
                       	   </c:if>
                       	   </a></li>
                       	   </c:forEach>
                       </ul>
                    </div>
                    
                </div>
            </div>
            <div class="col-xs-9 col-md-12" id="getPostData" data-tid="${feedThread.thread_id}" data-uid="${threadUserInfo.userId }" data-fid="${feedForum.forum_id }" data-isclosed="${feedThread.isClosed}">
                <div class="con-right1 clearfix">
                    <dl class="con-author clearfix">
                        <dt class="author-img">
                        <!--<dd class="money"><s class="icon-money"></s>${threadUserInfo.coin}</dd>-->   
                         <a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${threadUserInfo.userId}"><img src="${threadUserInfo.avatar}" alt=""></a>
                        </dt>
                        <dd class="author-name"><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${threadUserInfo.userId}">${threadUserInfo.nickname}</a><a href="<%=CommonUrl.baseUrl%>/level_info"><span class="grade">Lv.${threadUserInfo.level}</span></a></dd>
                        <dd class="author-detail"><b>楼主</b><span><fmt:formatDate value="${feedThread.create_time}" type="both" pattern="${feedThread.format }"/></span></dd>
                    </dl>
                    <h1> ${feedThread.subject } 
                     <c:choose>
                        	<c:when test="${type==1 }">
                        	<!--  <a href="thread_info?currentPage=${currentPage+1}&thread_id=${feedThread.thread_id}&type=0" class="landord">全部</a>-->
                        	<a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/1/0/0.html" class="landord">全部</a>
                        	</c:when>
                        	<c:otherwise>
                        	<!--<a href="thread_info?currentPage=${currentPage+1}&thread_id=${feedThread.thread_id}&type=1" class="landord">只看楼主</a>-->
                        	<a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/1/1/0.html" class="landord">只看楼主</a>
                        	</c:otherwise>
                        </c:choose>
                        
                        <c:if test="${fn:length(currentUser.privileges) > 0}">
                        <div class="manage">帖子管理
                            <div class="manage-more clearfix">
                            	<% 
                                CurrentUser currentUser = (CurrentUser) request.getAttribute("currentUser");
                            	FeedThread feedThread = (FeedThread) request.getAttribute("feedThread");
                                if (currentUser.getPrivileges().contains(SysPrivilege.EDIT_THREAD)) {
                                %>
		                      	<a href="<%=CommonUrl.baseUrl%>/editThreadInit/${feedForum.forum_id }/${feedThread.thread_id}.html" target="_blank">编辑</a><% } %>
		                      	<% if (currentUser.getPrivileges().contains(SysPrivilege.DEL_THREAD)) {
                                %>
		                      	<a href="javascript:;" class="manage-delete">删除</a><% } %>
		                      	<% if (currentUser.getPrivileges().contains(SysPrivilege.TOP_THREAD)) {
                                %>
                                <% if (feedThread.getIsTop()) {%>
		                      	<a href="javascript:;" class="manege-top off-manege-top">取消置顶</a>
		                      	
		                      	<%} else {%>
		                      	<a href="javascript:;" class="manege-top">置顶</a>
		                      	<%} %>
		                      	<%} %>
		                      	<% if (currentUser.getPrivileges().contains(SysPrivilege.ELITE_THREAD)) {
                                %>
                                
                                <% if (feedThread.getIsElite()) {%>
                                <a href="javascript:;" class="manege-great off-manege-great">取消精华</a>
                                <%} else {%>
		                       	<a href="javascript:;" class="manege-great">精华</a>
		                   		<%} %>
		                       	<%} %>
		                      	<% if (currentUser.getPrivileges().contains(SysPrivilege.CLOSE_THREAD)) {
                                %>
                                
                                <% if (feedThread.getIsClosed()) {%>
                                <a href="javascript:;" class="manage-lock off-manege-lock">打开帖子</a>
                                <%} else {%>
		                      	<a href="javascript:;" class="manage-lock">锁帖</a>
		                      	<%} %>
		                       	<%} %>
		                      	<% if (currentUser.getPrivileges().contains(SysPrivilege.AWARD)) {
                                %>
		                      	<a href="javascript:;" class="manage-reward">奖励</a><%} %>
                            </div>
                        </div>
                        </c:if>
                        
                    </h1>
                    <c:if test="${currentPage==1}">
                    <h3>楼主  <a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${threadUserInfo.userId}" target="_blank">${threadUserInfo.nickname}</a>    <fmt:formatDate value="${feedThread.create_time}" type="both" pattern="${feedThread.format}"/></h3>
                    <div class="con-con">
                    	${postList[0].htmlContent } 
                    	
                    	<c:if test="${fn:length(postList[0].pic) > 0 }">
                    		<c:forEach var="pic" items="${postList[0].pic }">
                    			<img src="${pic}"/>
                    		</c:forEach>
                    	</c:if>
                    </div>
                    
                   <p class="look" data-tid="${feedThread.thread_id }">
                   		<c:choose>
                   			<c:when test="${feedThread.isRecommend}">
                        		<span class="thread-zan zan-hover">
                        	</c:when>
                   			<c:otherwise>
                   				<span class="thread-zan">
                   			</c:otherwise>
                   		</c:choose>
                        
                        <s class="icon-zan"></s><a href="javascript:;">${feedThread.recommends }</a></span>
                        <span class="thread-comment"><a href="#conRight3"><s class="icon-ask"></s>${feedThread.replies }</a></span>
                    </p>
                    </c:if>
                    <!-- 广告位（新版不加）  -->
                    <!-- <div class="BD_AD_ad1 clearfix" id="BD_AD_ad1">
                    	
                    </div> -->
                </div>
                
                <c:if test="${(fn:length(postList) > 1 and currentPage == 1) or (fn:length(postList) >= 1 and currentPage >= 2)}">
                <div class="con-right2" id="conRight2">
                    <!-- 楼层回复模板1 -->
                    <script id="floorCommentTemplate" type="text/x-handlebars-template">
                        {{#each this}}
                        <dl class="clearfix">
                            <dt><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid={{user.user_id}}" target="_blank"><img src="{{avatar}}" alt=""></a></dt>
                            <dd><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid={{user.user_id}}" target="_blank">{{nickname}}:</a>&nbsp;&nbsp;&nbsp; {{{content}}}</dd>
                            <dd class="autor">{{timeformat create_time}}        <a href="javascript:;" class="dianping" data-name="{{nickname}}" data-uid="{{uid}}" data-tid="{{tid}}">回复</a></dd>
                        </dl>
                        {{/each}} 
                    </script>
                    <!-- 楼层回复模板2 -->
                    <script id="floorCommentTemplate2" type="text/x-handlebars-template">
                        
                        <dl class="clearfix">
                            <dt><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid={{user.user_id}}" target="_blank"><img src="{{user.avatar}}" alt=""></a></dt>
                            <dd><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid={{user.user_id}}" target="_blank">{{user.nickname}}:</a>&nbsp;&nbsp;&nbsp; {{content}}</dd>
                            <dd class="autor">{{timeformat create_time}}        <a href="javascript:;" class="dianping" data-name="{{user.nickname}}" data-uid="{{uid}}" data-tid="{{tid}}">回复</a></dd>
                        </dl>
                    </script>
                    
                    <c:choose>
                    	<c:when test="${currentPage==1}">
                    		<c:set var="start" value="1"></c:set>
                    	</c:when>
                    	<c:otherwise>
                    		<c:set var="start" value="0"></c:set>
                    	</c:otherwise>
                    </c:choose>
                    <c:forEach var="feedPost" begin="${start }" items="${postList }">
                    <c:if test="${feedPost.lastPositionFlg == true}">
                    <div class="con-list" id="replayUserFloorLast" data-postid="${feedPost.post_id }" data-uid="${feedPost.postUserInfo.userId}"   data-page='1'>
                    </c:if>
                     <c:if test="${feedPost.lastPositionFlg == false}">
                    <div class="con-list" data-postid="${feedPost.post_id }" data-uid="${feedPost.postUserInfo.userId}"   data-page='1'>
                    </c:if>
                        <p class="con-list-left">
                        	<a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${feedPost.postUserInfo.userId}" target="_blank">
                            	<img src="${feedPost.postUserInfo.avatar}" alt="">
                            </a>
                        </p>
                        <div class="con-list-right">
                            <dl class="list-right-dl">
                                <dt>
                                	 <p class="floor-num">${feedPost.position }楼</p>
                                <% 
                                CurrentUser currentUser = (CurrentUser) request.getAttribute("currentUser");
                                if (currentUser.getPrivileges().contains(SysPrivilege.DEL_FLOOR)) {
                                %> 
                                <div class="floor-manage">楼层管理
		                            <div class="manage-more clearfix">
		                                <a href="javascript:;" class="list-del">删除</a>
		                                <a href="javascript:;" class="floor-manage-reward">奖励</a>
		                            </div>
		                        </div>
		                        <%} else {%>
                                <c:if test="${feedPost.currentUserFlg == true}">
                                    <div class="floor-manage">楼层管理
		                            <div class="manage-more clearfix">
		                                <a href="javascript:;" class="list-del">删除</a>
		                            </div>
		                        </div>
                                </c:if>
                                <%} %>
                                <a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${feedPost.postUserInfo.userId}" target="_blank">${feedPost.postUserInfo.nickname }</a><a href="<%=CommonUrl.baseUrl%>/level_info"><span class="grade">Lv.${feedPost.postUserInfo.level}</span></a>    <fmt:formatDate value="${feedPost.create_time}" type="both" pattern="${feedPost.format}"/></dt>

                                <dd class="info">${feedPost.htmlContent }
                                <br/>
                                <c:forEach var="pic" items="${feedPost.pic }">
                                	<img src="${pic}"/>
                                </c:forEach>
                                </dd>
                                <dd class="clearfix">
                                    <p class="look">
                                        <c:choose>
                   							<c:when test="${feedPost.isRecommend}">
                        						<span class="zan zan-hover">
                        					</c:when>
                   							<c:otherwise>
                   								<span class="zan">
                   							</c:otherwise>
                   						</c:choose>
                                        
                                        <s class="icon-zan"></s><a href="javascript:;">${feedPost.recommends}</a></span><span class="floor-stop"><s class="icon-ask reply-hide"></s>收起</span><span class="floor-rec"><s class="icon-ask"></s><a href="javascript:;">${feedPost.comments}</a></span>
                                    </p>
                                </dd>
                            </dl>
	                            <c:choose>
	                            	<c:when test="${feedThread.isClosed == true }">
	                            	<div class="con-list-reply clearfix">
	                            	</c:when>
	                            	<c:otherwise>
	                            	<c:if test="${feedPost.comments > 0}">
	                            	<div class="con-list-reply clearfix" style="display: block;">
	                            	</c:if>
	                            	<c:if test="${feedPost.comments == 0}">
	                            	<div class="con-list-reply clearfix">
	                            	</c:if>
	                            	</c:otherwise>
	                            </c:choose>
                                <div class="con-list-replycon">
                                    <!--楼层回复内容-->
                                </div>
                                <div class="replay-lay-btn">回复层主</div>
                                <p class="floor-reply-more">更多${feedPost.comments }条回复    <a href="javascript:;">点击加载</a></p>
                                <div class="reply-textarea">
                                    <input type="hidden"  name="tid" class="tid" value="2342"/>
                                    <input type="hidden"  name="uid" class="uid" value="2342"/>
                                    <input type="hidden"  name="postname" class="postname" value="2342"/>
                                    <textarea name="" class="dianping-textarea" cols="30" rows="10" placeholder="回复"></textarea>
                                    <p class="replay-floor"><span class="replay-count">还可以输入140字</span> <input type="button" class="reply-btn" value="回复"></p>
                                </div>
                            </div>
                            
                        </div>
                        </div>
                    </c:forEach>
                    
                   
                    
                    <!-- 分页 -->
                       <!-- 上一页 按钮 -->
                    <c:if test="${totalPages > 1 }">
               		<div class="page-plug">
                        <ul class="page-pc clearfix">
						<c:choose>
						<c:when test="${currentPage != 1}">
							<li class="prev"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${currentPage-1}/${type}/0.html">上一页</a></li>
						</c:when>
						<c:otherwise>
							<!--  <li class="prev" disabled="true" ><a ></a></li>--><!-- 为了要那个灰掉的button -->
						</c:otherwise>
						</c:choose>
						
						<!-- 页数列表 -->
						<c:forEach items="${pagelist}" var="item">
						<c:choose>
						<c:when test="${item == currentPage}">
						 <c:if test="${item == 0}">
							<li class="active"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/1/${type}/0.html" >首页</a></li>
						</c:if>
						 <c:if test="${item == -1}">
							<li class="active"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${totalPages}/${type}/0.html" >尾页</a></li>
						</c:if>
						 <c:if test="${item != 0}">
						 	<c:if test="${item != -1}">
							<li class="active"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${item}/${type}/0.html" >${item}</a></li>
							</c:if>
						</c:if>
						</c:when>
						<c:otherwise>
							<c:if test="${item == 0}">
								<li><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/1/${type}/0.html">首页</a></li>
							</c:if>
							<c:if test="${item == -1}">
								<li><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${totalPages}/${type}/0.html">尾页</a></li>
							</c:if>
							<c:if test="${item != 0}">
								<c:if test="${item != -1}">
									<li><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${item}/${type}/0.html">${item}</a></li>
								</c:if>
							</c:if>
						</c:otherwise>
						</c:choose>
						</c:forEach>
						
						<!-- 下一页 按钮 -->
						<c:choose>
						<c:when test="${currentPage != totalPages}">
							<li class="next"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${currentPage+1}/${type}/0.html">下一页</a></li>
						</c:when>
						<c:otherwise>
							<!--  <li class="next" disabled="true"><a >下一页</a></li>-->
						</c:otherwise>
						</c:choose>
						<!-- 页码跳转 -->
						<li class="jump-text"><input type="text" /></li><li class="jump-page-btn"><a href="javascript:;">跳转</a></li>
                		</ul>
                	
                	  <ul class="page-mobile clearfix">
						<c:choose>
						<c:when test="${currentPage != 1}">
							<li class="prev"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${currentPage-1}/${type}/0.html">上一页</a></li>
						</c:when>
						<c:otherwise>
							<!--  <li class="prev" disabled="true" ><a ></a></li>--><!-- 为了要那个灰掉的button -->
						</c:otherwise>
						</c:choose>
						
						<li class="text"><input type="text" class="wap-page-text" pattern="[0-9]*" value="${currentPage}/${totalPages}"/></li>
						
						<!-- 下一页 按钮 -->
						<c:choose>
						<c:when test="${currentPage != totalPages}">
							<li class="next"><a href="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${currentPage+1}/${type}/0.html">下一页</a></li>
						</c:when>
						<c:otherwise>
							<!--  <li class="next" disabled="true"><a >下一页</a></li>-->
						</c:otherwise>
						</c:choose>
                	</ul>
                </div>
                </c:if>

               </div>
              </c:if>
              <c:choose>
              	<c:when test="${!feedThread.isClosed}">
               <div class="con-right3 reply-textarea"  id="conRight3">
                   <div class="reply-textarea-info clearfix">
                       <p class="reply-head">
                       <c:choose>
                       	<c:when test="${loginUser.avatar == null}">
                       	<a href="#"><img src="<%=CommonUrl.baseUrl%>/img/default.png" alt="">
                       	</a>
                       	</c:when>
                       	<c:otherwise>
                       	<a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${loginUser.userId}" target="_blank"><img src="${loginUser.avatar}" alt="">
                       	</a>
                       	</c:otherwise>
                       </c:choose>
                       </p>
                       <dl>
                           <dt></dt>
                           <dd><textarea name="" id="" cols="30" rows="10" class="editor-cont"></textarea></dd>
                           <dd>
                               <div class="editer" data-maxurl="<%=CommonUrl.baseUrl%>/thread/${feedThread.thread_id}/${totalPages}/${type}/1.html">
                                   <div class="editor-textarea">
                                       <div class="textmask">您需要登录后才可以发帖 <a class="maskLogin" href="<%=UserCenter.baseUrl %>">登录</a> | <a  class="maskReg" href="<%=UserCenter.baseUrl %>">立即注册</a></div>
                                   </div>
                                   <script type="text/plain" id="myEditor" style="height:240px;"></script>
                               </div>
                           </dd>
                           <form id="editor-form" data-form="replayPost" data-tid="${feedThread.thread_id }" action="<%=CommonUrl.baseUrl%>/send_reply.json" method="POST">
                               <input type="hidden" name="fid" class="editor-fid" value="${feedForum.forum_id }"/>
                               <input type="hidden" name="tid"  class="editor-tid" value="${feedThread.thread_id }">
                               <input type="hidden" name="content"  class="editor-cont" value=""/>
                           </form>
                       </dl>
                   </div>
                   
                   <p class="replay-floor"><span class="word-count">还可以输入5000字</span> <input type="button" class="reply-editer reply-submit" value="回复"></p>
               </div>
               </c:when>
               <c:otherwise>
               <div class="con-right3 replay-ban">
               	该帖子已被禁止回复:-D！
               </div>
               </c:otherwise>
              </c:choose>
            </div>
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <!-- footer开始 -->
		<jsp:include page="footer.jsp" flush='true'/>
		<!-- footer结束 -->
        <!-- 底部结束 -->
        <!-- 弹出框开始 -->
        <!-- 遮罩层开始 -->
        <div class="mask-bg">
            
        </div>
        <!-- 遮罩层结束 -->
        
        <!-- 删除/置顶/加精 -->
        <div class="pop pop-post-delete">
            <h2 class="clearfix">
                <span>
                    <img src="<%=CommonUrl.baseUrl%>/img/icon/pop_close.png" class="close">
                </span>帖子管理操作
            </h2>
            <div class="post-delete-reason">
                <p  class="post-delete-sure pop-title">确定要删除帖子？</p>
                    <div class="delete-reason-choose">
                        <h3 class="delete-choose-title">不喜欢</h3>
                        <div class="delete-choose-sort">
                            <span>不喜欢这个帖子</span>
                            <span>烦这个帖子</span>
                            <span>鄙视这个帖子</span>
                        </div>	
                    </div>
    
                    <textarea name="" class="pop-msg"></textarea>
                    <p class="delete-reason-but clearfix">
                        <input type="button" class="delete-reason-cancel pop-cancel" value="取消">
                        <input type="button" class="delete-reason-ok pop-ok" value="确定">
                    </p>
            </div>
        </div>
        <!-- 奖励 -->
        <div class="pop pop-post-reward">
            <h2 class="clearfix">
                <span>
                    <img src="<%=CommonUrl.baseUrl%>/img/icon/pop_close.png" class="close">
                </span>帖子/楼层管理操作
            </h2>
            <div class="post-delete-reason">
                <p  class="post-delete-sure pop-title">奖励原因</p>
                    <div class="delete-reason-choose">
                       <input class="reward-icon" type="text" value="" class="">
                    </div>
    
                    <textarea name="" class="pop-msg"></textarea>
                    <p class="delete-reason-but clearfix">
                        <input type="button" class="delete-reason-cancel pop-cancel" value="取消">
                        <input type="button" class="delete-reason-ok pop-ok" value="确定">
                    </p>
            </div>
        </div>
        <!--未登录-->
        <div class="pop pop-play pop-login">
            <p class="pop-play-close"><img src="<%=CommonUrl.baseUrl%>/img/icon/pop_close.png" class="close"></p>
            <p class="pop-play-word pop-msg">未登录？</p>
            <p class="clearfix">
                <input type="button" class="pop-play-cancel pop-cancel" value="取消">
                <input type="button" class="pop-play-ok pop-ok" value="前往登录">
            </p>
        </div>
        <!-- 发帖失败 -->
        <div class="pop pop-play pop-warn">
            <p class="pop-play-close"><img src="<%=CommonUrl.baseUrl%>/img/icon/pop_close.png" class="close"></p>
            <p class="pop-play-word pop-msg">突破经典的飞行射击类精品手机游戏。继承了经典飞机大战简单爽快的操作体验，玩法更多样。这么好玩的游戏，确定不玩吗？</p>
            <p class="clearfix">
                <input type="button" class="pop-play-cancel pop-cancel" value="稍后再试">
                <input type="button" class="pop-play-ok pop-ok" value="重新发送">
            </p>
        </div>
        <!-- 成功 -->
        <div class="pop pop-post-ok">   
            <img src="<%=CommonUrl.baseUrl%>/img/icon/pop_ok.png"><span class="pop-msg">成功</span>
        </div>
        <!-- 失败 -->
        <div class="pop pop-top-fail">
            <img src="<%=CommonUrl.baseUrl%>/img/icon/pop_fail.png"><span class="pop-msg">失败</span>
        </div>
        <!-- 弹出框结束 -->
    </div>
    <!-- 回到顶部  -->
     <div class="go-top">
     	<a href="#conRight3" class="quick-reply">快速回复</a>
	 	<a href="<%=CommonUrl.baseUrl%>/newThreadInit/${feedForum.forum_id}.html" data-href="" class="post get-post">发帖</a>
	 	<a href="javascript:;" class="scroll-top">顶部</a>
	 </div>
	
    <script src="<%=CommonUrl.baseUrl%>/js/mod/article_article.js"></script>
    <script src="<%=CommonUrl.baseUrl%>/js/mod/comment.js"></script>
</body>
</html>
