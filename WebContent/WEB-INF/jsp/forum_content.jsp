<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="com.mofang.feedweb.entity.FeedForum"%>
<%@ page import="com.mofang.feedweb.entity.HotThread"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>
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
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>版块内容页</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/add_list_article.css">
    <script src="js/sea.js"></script>
    <script src="js/sea-config.js"></script>
    <script src="js/bbs-config.js"></script>
    <script src="js/mod/common.js"></script>
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
            <jsp:include page="user_info.jsp" flush='true'/>
            <div class="nav-wap clearfix">
                <div class="nav-wap-left">
                  <a href="javascript:;" class="nav-wap-list"><img src="./img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a href="http://bbs.mofang.com" class="nav-info-home">首页</a>
                    <a href="<%=UserCenter.baseUrl %>">个人中心</a>
                  </p>
                </div>
                <div class="nav-wap-right">
                	<a href="newThreadInit?fid=${feedForum.forum_id}" class="nav-wap-post">发帖</a>
                </div>
                  <!-- <div class="wap-logo">
                    帖子详情
                  </div> -->
                  <div class="wap-nav-text">
                  	${feedForum.forum_name}
                  </div>
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
         <jsp:include page="commonSearch.jsp" flush='true'/>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
            <!-- 第一块内容top -->
            <div class="con-top container clearfix">
                <div class="con-top-con col-xs-12">
                    <dl>
                       <dt><img src="${feedForum.icon}" height="336" width="448" alt=""></dt>
                       <dd class="title"><span class="title-text">${feedForum.forum_name}</span><c:if test="${isFollow}"><a href="javascript:;" class="follow followed" data-areaid='${feedForum.forum_id}' data-dofollow='0'>已关注</a></c:if>
                     <c:if test="${!isFollow}"> <a href="javascript:;" class="follow" data-areaid='${feedForum.forum_id}' data-dofollow='1'>+ 关注</a></c:if></dd>
                       <dd>关注  ${feedForum.total_follows}</dd>
                       <dd>帖子  ${feedForum.total_threads}</dd>
                    </dl>
                     
                    <a href="newThreadInit?fid=${feedForum.forum_id}" class="post">发帖</a>
                </div>
            </div>
           <!-- 第一块内容top结束 -->
           <!-- 帖子列表开始 -->
           <div class="con-bottom clearfix">
             <div class="col-xs-9 col-md-12">
                <div class="con-bot-left">
                    <div class="con-nav">
                        <div class="left">
                            <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=${type}&timeType=${timeType}" id="tag_all">综合</a>
                            <c:forEach var="tag" items="${feedForum.tags}">
                            	<a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=${type}&timeType=${timeType}&tag_id=${tag.tag_id}" id="tag_${tag.tag_id }">${tag.tag_name}</a>
                            </c:forEach>
                            <input type="hidden" id="tag_id" value="${tag_id }"/>
                        </div>
                        <div class="right">
                            <div id="quan">
                                <span class="triangle">
                                    
                                </span>
                                <c:if test="${type==0 }">
                                <p>全部</p>
                                <p class="list">
                                    <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=1&timeType=${timeType}&tag_id=${tag_id}">精华</a>
                                </p>
                                </c:if>
                                
                                <c:if test="${type ==1 }">
                                <p>精华</p>
                                <p class="list">
                                    <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=0&timeType=${timeType}&tag_id=${tag_id}">全部</a>
                                </p>
                                </c:if>
                                
                                <%-- <p >
                                	<a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=0&timeType=${timeType}">全部</a>
                                </p>
                                <p id="type_1">
                                    <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=1&timeType=${timeType}">精华</a>
                                </p> --%>
                                <input type="hidden" value="${type }" id="threadType" name="threadType"/>
                            </div>
                            <div id="time">
                                <span class="triangle">
                                    
                                </span>
                                
                                <c:if test="${timeType==0 }">
                                <p id="reply_time">回复时间</p>
                                <p id="create_time" class="list">
                                    <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=${type }&timeType=1&tag_id=${tag_id}">发帖时间</a>
                                </p>
                                </c:if>
                                
                                <c:if test="${timeType==1 }">
                                <p id="reply_time">发帖时间</p>
                                <p id="create_time" class="list">
                                    <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=${type }&timeType=0&tag_id=${tag_id}">回复时间</a>
                                </p>
                                </c:if>
                               
                                <%-- <p>
                                 	<a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=${type }&timeType=0">回复时间</a>
                                </p>
                                <p id="add_thread_time">
                                    <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=${type }&timeType=1">发帖时间</a>
                                </p> --%>
                                <input type="hidden" value="${timeType }" id="timeType" name="timeType"/>
                            </div>
                        </div>
                    </div>
                    <div class="con-left-con">
                    	<c:if test="${currentPage==1 }">
                    	<c:forEach var="topThread" items="${topThreadList}">
                        <dl class="clearfix">
                            <dt><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${user_id}"><img src="${topThread.avatar}"alt=""></a></dt>
                            <div class="infos">
                                <dd class="title">
                                <c:choose>
                                	<c:when test="${topThread.isElite}">
                                	<a href="thread_info?thread_id=${topThread.thread_id }" target="_blank" class="add-a-hover">
                                	</c:when>
                                	<c:otherwise>
                                	<a href="thread_info?thread_id=${topThread.thread_id }" target="_blank" >
                                	</c:otherwise>
                                </c:choose>
                                
                                ${topThread.subject}
                                <c:if test="${topThread.isTop}"><s class="icon-ding"></s></c:if>
                                
                                <c:if test="${topThread.isElite}"><s class="icon-jing"></s></c:if>
                                <c:if test="${topThread.hasPic}"><s class="icon-tu"></s></c:if>
                                </a></dd>
                                <dd>${fn:substring(topThread.content, 0, 40)}...</dd>
                                <dd class="info clearfix">
                                    <p class="author">
                                        <span>${topThread.user_name}</span>
                                        <span class="time"><fmt:formatDate value="${topThread.create_time}" type="both" pattern="yyyy-MM-dd HH:mm"/></span>
                                    </p>
                                    <p class="look">
                                        <span><s class="icon-look"></s>${topThread.page_view}</span>
                                        <span><s class="icon-ask"></s>${topThread.replies}</span>
                                    </p>
                                </dd> 
                            </div>
                            
                        </dl>
                       </c:forEach>
                    	
                    	</c:if>
                    	<c:forEach var="feedThread" items="${threadList}">
                        <dl class="clearfix">
                            <dt><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${user_id}"><img src="${feedThread.avatar}"alt=""></a></dt>
                            <div class="infos">
                                <dd class="title">
                                <c:choose>
                                	<c:when test="${feedThread.isElite}">
                                	<a href="thread_info?thread_id=${feedThread.thread_id }" target="_blank" class="add-a-hover">
                                	</c:when>
                                	<c:otherwise>
                                	<a href="thread_info?thread_id=${feedThread.thread_id }" target="_blank" >
                                	</c:otherwise>
                                </c:choose>
                                
                                ${feedThread.subject}
                                <c:if test="${feedThread.isTop}"><s class="icon-ding"></s></c:if>
                                
                                <c:if test="${feedThread.isElite}"><s class="icon-jing"></s></c:if>
                                <c:if test="${feedThread.hasPic}"><s class="icon-tu"></s></c:if>
                                </a></dd>
                                <dd>${fn:substring(feedThread.content, 0, 40)}...</dd>
                                <dd class="info clearfix">
                                    <p class="author">
                                        <span>作者：${feedThread.user_name}</span>
                                        <span class="time"><fmt:formatDate value="${feedThread.create_time}" type="both" pattern="yyyy-MM-dd HH:mm"/></span>
                                    </p>
                                    <p class="look">
                                        <span><s class="icon-look"></s>${feedThread.page_view}</span>
                                        <span><s class="icon-ask"></s>${feedThread.replies}</span>
                                    </p>
                                </dd> 
                            </div>
                            
                        </dl>
                       </c:forEach>
                       <div class="page-plug">
			                <ul class="page-pc">
			                <!-- 上一页 按钮 -->
			                
							<c:choose>
							<c:when test="${currentPage != 1}">
								<li class="prev"><a href="forum_content?currentPage=${currentPage-1}&fid=${feedForum.forum_id}&type=${type}&timeType=${timeType}&tag_id=${tag_id }">上一页</a></li>
							</c:when>
							<c:otherwise>
								<!--  <li class="prev" disabled="true" ><a ></a></li>--><!-- 为了要那个灰掉的button -->
							</c:otherwise>
							</c:choose>
							
							<!-- 页数列表 -->
							<c:forEach items="${pagelist}" var="item">
							<c:choose>
							<c:when test="${item == currentPage}">
								<li class="active"><a href="forum_content?currentPage=${item }&fid=${feedForum.forum_id}&type=${type}&timeType=${timeType}&tag_id=${tag_id }" >${item}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="forum_content?currentPage=${item}&fid=${feedForum.forum_id}&type=${type}&timeType=${timeType}&tag_id=${tag_id }">${item}</a></li>
							</c:otherwise>
							</c:choose>
							</c:forEach>
							
							<!-- 下一页 按钮 -->
							<c:choose>
							<c:when test="${currentPage != totalPages}">
								<li class="next"><a href="forum_content?currentPage=${currentPage+1}&fid=${feedForum.forum_id}&type=${type}&timeType=${timeType}&tag_id=${tag_id }">下一页</a></li>
							</c:when>
							<c:otherwise>
								<!--  <li class="next" disabled="true"><a >下一页</a></li>-->
							</c:otherwise>
							</c:choose>
			                </ul>
			                
			                
			                <!--
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
			                </ul>-->
			                
			                <ul class="page-mobile">
			                <!-- 上一页 按钮 -->
			                
							<c:choose>
							<c:when test="${currentPage != 1}">
								<li class="prev"><a href="forum_content?currentPage=${currentPage-1}&fid=${feedForum.forum_id}&type=${type}&timeType=${timeType}&tag_id=${tag_id }">上一页</a></li>
							</c:when>
							<c:otherwise>
								<!--  <li class="prev" disabled="true" ><a ></a></li>--><!-- 为了要那个灰掉的button -->
							</c:otherwise>
							</c:choose>
							
							 <li class="text">${currentPage}/${totalPages}</li>
							
							<!-- 下一页 按钮 -->
							<c:choose>
							<c:when test="${currentPage != totalPages}">
								<li class="next"><a href="forum_content?currentPage=${currentPage+1}&fid=${feedForum.forum_id}&type=${type}&timeType=${timeType}&tag_id=${tag_id }">下一页</a></li>
							</c:when>
							<c:otherwise>
								<!--  <li class="next" disabled="true"><a >下一页</a></li>-->
							</c:otherwise>
							</c:choose>
			                </ul>
			                
			
			            </div>
                    </div>
                </div>
             </div>
             <div class="col-xs-3 con-bot-right">
                <div class="lord-team">
                    <h2 class="lum">
                        吧主团队 <c:if test="${!is_full }"><a href="apply_check?forum_id=${feedForum.forum_id}"  target="_blank">申请吧主</a></c:if>
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
		                           <li><s class="black"></s><a href="thread_info?thread_id=${hotThread.threadId }">${fn:substring(hotThread.subject, 0, 17)}...</a></li>
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
                        	游戏下载 
                    		</h2>
                    	<div class="down">
	                       	<p>
	                           ${game.comment }
	                       	</p>
	                       	<a href="${game.url }" target="_blank">立即下载</a>
                    	</div>
                	</div>
                	<c:if test="${fn:length(giftList) > 0}">
                	<div class="lord-team">
	                    <h2 class="lum">
	                        礼包发号
	                    </h2>
	                    <div class="lum-list libao-list">
	                       <ul>
	                       	   <c:forEach var="gift" items="${giftList }">
	                       	   	<li><s class="black"></s><a href="${gift.url }" target="_blank">${gift.name }</a></li>
	                       	   </c:forEach>
	                       </ul>
	                    </div>
                    
                	</div>
                	</c:if>
                  </c:otherwise>
                </c:choose>
                
             </div>
           </div>
              
           <!-- 帖子列表结束 -->
        </div>
        <!-- 内容结束 -->
        <!-- footer开始 -->
		<jsp:include page="footer.jsp" flush='true'/>
		<!-- footer结束 -->
        <!-- 弹出框插件开始 -->
        <!-- 遮罩层开始 -->
        <div class="mask-bg">
            
        </div>
        <!-- 遮罩层结束 -->
        <!-- 确定不玩？弹出框开始 -->
        <div class="pop pop-play pop-warn">
            <p class="pop-play-close"><img src="img/icon/pop_close.png" class="close"></p>
            <p class="pop-play-word pop-msg">突破经典的飞行射击类精品手机游戏。继承了经典飞机大战简单爽快的操作体验，玩法更多样。这么好玩的游戏，确定不玩吗？</p>
            <p class="clearfix">
                <input type="button" class="pop-play-cancel pop-cancel" value="取消">
                <input type="button" class="pop-play-ok pop-ok" value="好的，去取消">
            </p>
        </div>
        <!--未登录-->
        <div class="pop pop-play pop-login">
            <p class="pop-play-close"><img src="img/icon/pop_close.png" class="close"></p>
            <p class="pop-play-word pop-msg">突破经典的飞行射击类精品手机游戏。继承了经典飞机大战简单爽快的操作体验，玩法更多样。这么好玩的游戏，确定不玩吗？</p>
            <p class="clearfix">
                <input type="button" class="pop-play-cancel pop-cancel" value="取消">
                <input type="button" class="pop-play-ok pop-ok" value="前往登录">
            </p>
        </div>
        <!-- 成功 -->
        <div class="pop pop-post-ok">   
            <img src="img/icon/pop_ok.png"><span class="pop-msg">成功</span>
        </div>
        <!-- 失败 -->
        <div class="pop pop-top-fail">
            <img src="img/icon/pop_fail.png"><span class="pop-msg">失败</span>
        </div>
        <!-- 弹出框插件结束 -->
    </div>
    
   <script src="js/mod/list_article.js"></script>

   
</body>
</html>
