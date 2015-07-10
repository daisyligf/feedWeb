<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="com.mofang.feedweb.entity.FeedTag"%>
<%@ page language="java" import="com.mofang.feedweb.entity.FeedThread"%>
<%@ page language="java" import="java.util.*"%>
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
    <title>发帖-魔方论坛</title>
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/base.css">

    <link rel="stylesheet" href="js/editor/css/umeditor.css">
    <link rel="stylesheet" href="js/editor/css/fixeditor.css">
    <link rel="stylesheet" href="js/editor/emotion.css">

    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/post.css">
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
   
    
    <script src="js/editor/js/jquery.min.js"></script>
    <script src="js/editor/js/umeditor.config.js"></script>
    <script src="js/editor/js/umeditor.js"></script>
    <script src="js/editor/lang/zh-cn/zh-cn.js"></script>
    <script src="js/editor/btn.js"></script>
    <script src="js/editor/feed-emotion.js"></script>
    
</head>
<body>
    <div class="page">
        <!-- 头部开始 -->
        <div class="header clearfix">
            <jsp:include page="user_info.jsp" flush='true'/>
            <div class="nav-wap clearfix">
                <div class="nav-wap-left">
                  <a href="<%=request.getHeader("Referer") %>" class="nav-wap-back"></a>
                  <%-- <a href="javascript:;" class="nav-wap-list"><img src="./img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a href="<%=CommonUrl.bbsHomeUrl %>" class="nav-info-home">论坛首页</a>
                    <a href="<%=CommonUrl.mofangHomeUrl %>">魔方首页</a>
                  </p> --%>
                </div>
                  <!-- <div class="wap-logo">
                    帖子详情
                  </div> -->
                  <div class="wap-nav-text">
                  	发新帖
                  </div>
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
         <div class="search">
        <div class="bbs-logo">
           <a href="index"><img src="./img/icon/bbs_icon.png" alt=""></a>
        </div>
        </div>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
            <div class="col-xs-3 user-info-out">
                <div class="user-info">
                   <dl>
                        <dt><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${user.userId}" class="user-info-icon" target="_blank"><img src="${user.avatar }" alt="" class="user-info-icon"><span class="grade">Lv.${user.level}</span></a></dt>
                        <dd><a href="<%=UserCenter.baseUrl %>/home/public/info?to_uid=${user.userId}" target="_blank">${user.nickname }</a></dd>
                        <dd class="money"><s class="icon-money"></s>${user.coin }</dd>
                    </dl>
                    <ul class="clearfix">
                        <li class="col-xs-4"><span>${user.threads }</span>帖子</li>
                        <li class="col-xs-4"><span>${user.replies }</span>回复</li>
                        <li class="col-xs-4 no-line"><span>${user.eliteThreads }</span>精华</li>
                    </ul> 
                </div>
                
            </div>
            <div class="col-xs-9 col-md-12 post">
                <h2>
     	               <c:choose>
                   			<c:when test="${threadInfo.thread_id == 0 }">
                   				发新帖
                   			</c:when>
                   			<c:otherwise>
                   				编辑帖
                   			</c:otherwise>
                   		</c:choose>
                </h2>
                <div class="title-type clearfix">
                    <input type="text" class="col-xs-10 col-sm-9 title editor-title" placeholder="帖子标题不超过30个字"  value="${threadInfo.subject }">
                    <div class="col-xs-2 col-sm-3">
                        <div class="sel">
                        
<%--                               <c:forEach items=" ${tagList}" var="tag" >
                              		<c:choose>
                              			<c:when test="${tag.tag_id == threadInfo.tagId }">
                              				<a class="sel-one">${tag.tag_name }</a>
                              			</c:when>
                              			<c:otherwise>
                              				<a class="sel-one">综合</a>
                              			</c:otherwise>
                              		</c:choose>
                            	</c:forEach> --%>
                           <!--  <a class="sel-one">综合</a> -->
                            	<%
                            		FeedThread threadInfo = (FeedThread)request.getAttribute("threadInfo");
                            		List<FeedTag> list = (List)request.getAttribute("tagList");
                            		for(int idx =0 ; idx < list.size(); idx ++ ) {
                            			FeedTag tag = list.get(idx);
                            			if(threadInfo.getTagId() == tag.getTag_id()) {
                            	%>
                            			<a class="sel-one" data-tagsId="<%=tag.getTag_id() %>"><%=tag.getTag_name() %></a>
                            	<%
                            				break;
                            			}else if(threadInfo.getTagId() == 0){
                            	 %>			
                            			 <a class="sel-one" data-tagsId="0">综合</a>
                            	 <%			
                            	 			break;
                            			}
                            		}
                            	%>             
                            <div class="sel-more">
                            
<%--                             	<c:forEach items=" ${tagList}" var="tag" >
	                                <a href="javascript:;"  data-tagsId="${tag.tag_id }" >1</a>
                            	</c:forEach> --%>
                            	
                            	<%
                            		for(int idx =0 ; idx < list.size(); idx ++ ) {
                            			FeedTag tag = list.get(idx);
                            			if(threadInfo.getTagId() != tag.getTag_id()) {
                            	%>
                            			<a href="javascript:;"  data-tagsId="<%=tag.getTag_id() %>" ><%=tag.getTag_name() %></a>
                            	<%
                            			}
                            		}
                            	%>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="editer">
                    <dl>
                        <dt></dt>
                       
                        <dd>
                            <div class="editer">
                                <div class="editor-textarea">
                                    <div class="textmask">您需要登录后才可以发帖 <a class="maskLogin" href="<%=UserCenter.baseUrl %>">登录</a> | <a  class="maskReg" href="<%=UserCenter.baseUrl %>">立即注册</a></div>
                                </div>
                                <script type="text/plain" id="myEditor" style="height:240px;">${threadInfo.htmlContent }</script>
                            </div>
                        </dd>
                        <form id="editor-form" data-form="post" data-tid="${threadInfo.thread_id }" action="newThread" method="post" ENCTYPE="multipart/form-data">
                            <input type="hidden" name="fid" class="editor-fid" value="${fid }"/>
                            <input type="hidden" name="tid"  class="editor-tid" value="${threadInfo.thread_id }">
                            <input type="hidden" name="subject"  class="editor-title" value="${threadInfo.subject }">
                            <input type="hidden" name="tagId"  class="editor-tags" value="${threadInfo.tagId }">
                            <input type="hidden" name="content"  class="editor-cont" value=""/>
                        </form>
                    </dl>

                </div>
                <div class="sub clearfix">
                    <input type="text" class="code-text">
                   <!--  <img src="http://u.mofang.com/captcha/captcha" alt="" class="code"> -->
					<img src="generageCode" alt="" class="code">
                    <input type="button" class="submit reply-submit" value="发表帖子">
                    <span class="word-count">还可以输入5000字</span>
                </div>
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
        <!--未登录-->
        <div class="pop pop-play pop-login">
            <p class="pop-play-close"><img src="img/icon/pop_close.png" class="close"></p>
            <p class="pop-play-word pop-msg">未登录？</p>
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
        <!-- 弹出框结束 -->
    </div>
   <script src="js/mod/comment.js"></script>
   
</body>
</html>
