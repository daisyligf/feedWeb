<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <title>bbs列表页</title>
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/channel.css">
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
        <div class="header clearfix">
            <jsp:include page="user_info.jsp" flush='true'/>
            <div class="nav-wap clearfix">
                <div class="nav-wap-left">
                  <a href="<%=request.getHeader("Referer") %>" class="nav-wap-back"></a>
                  <p class="nav-info">
                    <a href="<%=CommonUrl.bbsHomeUrl %>" class="nav-info-home">论坛首页</a>
                    <a href="<%=CommonUrl.mofangHomeUrl %>">魔方首页</a>
                  </p>
                </div>
                  <div class="wap-nav-text">
                  	热门游戏
                  </div>
            </div>
        </div>
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
         <jsp:include page="commonSearch.jsp" flush='true'/>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
        	<c:if test="${forumType=='1'}">
           <div class="h2">热门游戏</div>
           </c:if>
          <c:if test="${forumType=='2'}">
           <div class="h2">新游推荐</div>
           </c:if>
           <div class="channel-list">
           <c:if test="${letterGroup=='1'}">
           		<div class="col-xs-2 active" ><a href="forumList?letterGroup=1&currentPage=1&forumType=${forumType}" style=text-decoration:none>ABCDE</a></div>
           </c:if>  
           <c:if test="${letterGroup !='1'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=1&currentPage=1&forumType=${forumType}" style=text-decoration:none>ABCDE</a></div>
           </c:if>
           <c:if test="${letterGroup =='2'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=2&currentPage=1&forumType=${forumType}" style=text-decoration:none>FGHIJ</a></div>
           </c:if>
           <c:if test="${letterGroup !='2'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=2&currentPage=1&forumType=${forumType}" style=text-decoration:none>FGHIJ</a></div>
           </c:if>
           <c:if test="${letterGroup =='3'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=3&currentPage=1&forumType=${forumType}" style=text-decoration:none>KLMNO</a></div>
           </c:if>
           <c:if test="${letterGroup !='3'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=3&currentPage=1&forumType=${forumType}" style=text-decoration:none>KLMNO</a></div>
           </c:if>
           <c:if test="${letterGroup =='4'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=4&currentPage=1&forumType=${forumType}" style=text-decoration:none>PQRST</a></div>
           </c:if>   
            <c:if test="${letterGroup !='4'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=4&currentPage=1&forumType=${forumType}" style=text-decoration:none>PQRST</a></div>
           </c:if>   
           <c:if test="${letterGroup =='5'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=5&currentPage=1&forumType=${forumType}" style=text-decoration:none>WXYZ</a></div>
           </c:if>
            <c:if test="${letterGroup !='5'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=5&currentPage=1&forumType=${forumType}" style=text-decoration:none>WXYZ</a></div>
           </c:if>
           <c:if test="${letterGroup =='6'}">
               <div class="col-xs-2 active"><a href="forumList?letterGroup=6&currentPage=1&forumType=${forumType}" style=text-decoration:none>#</a></div>
           </c:if>
           <c:if test="${letterGroup !='6'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=6&currentPage=1&forumType=${forumType}" style=text-decoration:none>#</a></div>
           </c:if>
           <input type="hidden" id="forumType"   name="forumType" value="${forumType }">
           <input type="hidden" id="letterGroup"   name="letterGroup" value="${letterGroup }">
           </div>
           <div class="h2-con clearfix container">
           <!-- 内容循环开始 -->
           	<c:choose>
				<c:when test="${not empty listInfo}">
					<c:forEach items="${listInfo}" var="forum" varStatus="vs">						
			               <div class="col-xs-3 col-md-4  col-sm-6">
			                   <dl class="clearfix">
			                       <dt><a href="forum_content?fid=${forum.forumId}"><img src="${forum.icon}" alt=""></a></dt>
			                       <dd><a href="forum_content?fid=${forum.forumId}">${forum.forumName}</a></dd>
			                       <dd>今日  <b class="update">${forum.todayThreads}</b></dd>
			                       <dd>帖子  ${forum.totalThreads}</dd>
			                   </dl>
			                   <div class="h2-con-bot">
			                   <c:if test="${forumType == 1}">
			                      <c:if test="${forum.prefectureUrl != ''}">
			                      <a href="${forum.prefectureUrl}"  class="zq l">专区</a>
			                      </c:if>
			                      <c:if test="${forum.prefectureUrl == ''}">
			                      <a href="javascript:;"  class="zq bg-grey l">专区</a>
			                      </c:if>
			                   </c:if>
			                    <c:if test="${forumType == 2}">
			                      <c:if test="${forum.downLoadUrl != ''}">
			                      <a href="${forum.downLoadUrl}"  class="zq l">下载</a>
			                      </c:if>
			                      <c:if test="${forum.downLoadUrl == ''}">
			                      <a href="javascript:;"  class="zq bg-grey l">下载</a>
			                      </c:if>
			                   </c:if>
			                   <c:if test="${forum.giftUrl != ''}">
			                      <a href="${forum.giftUrl}" class="zq r">礼包</a> 
			                   </c:if>
			                   <c:if test="${forum.giftUrl == ''}">
			                      <a href="javascript:;" class="zq bg-grey r">礼包</a> 
			                   </c:if>
			                   </div>
			               </div>
            		</c:forEach>
				</c:when>
			</c:choose>
            <!-- 内容循环结束 -->   
           </div>
          <!--  <div class="load-more">
              <a href="#">加载更多</a>
           </div>-->
           <c:if test="${totalPages > 1 }">
            <div class="page-plug">
                <ul class="page-pc">
                <!-- 上一页 按钮 -->
                
				<c:choose>
				<c:when test="${currentPage != 1}">
					<li class="prev"><a href="forumList?currentPage=${currentPage-1}&forumType=${forumType}&letterGroup=${letterGroup}">上一页</a></li>
				</c:when>
				<c:otherwise>
					<!--  <li class="prev" disabled="true" ><a ></a></li>--><!-- 为了要那个灰掉的button -->
				</c:otherwise>
				</c:choose>
				
				<!-- 页数列表 -->
				<c:forEach items="${pagelist}" var="item">
				<c:choose>
				<c:when test="${item == currentPage}">
					<li class="active"><a href="forumList?currentPage=${item }&forumType=${forumType}&letterGroup=${letterGroup}" >${item}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="forumList?currentPage=${item}&forumType=${forumType}&letterGroup=${letterGroup}">${item}</a></li>
				</c:otherwise>
				</c:choose>
				</c:forEach>
				
				<!-- 下一页 按钮 -->
				<c:choose>
				<c:when test="${currentPage != totalPages}">
					<li class="next"><a href="forumList?currentPage=${currentPage+1}&forumType=${forumType}&letterGroup=${letterGroup}">下一页</a></li>
				</c:when>
				<c:otherwise>
					<!--  <li class="next" disabled="true"><a >下一页</a></li>-->
				</c:otherwise>
				</c:choose>
                </ul>
                

            <ul class="page-mobile">
                <!-- 上一页 按钮 -->
                
				<c:choose>
				<c:when test="${currentPage != 1}">
					<li class="prev"><a href="forumList?currentPage=${currentPage-1}&forumType=${forumType}&letterGroup=${letterGroup}">上一页</a></li>
				</c:when>
				<c:otherwise>
					<!--  <li class="prev" disabled="true" ><a ></a></li>--><!-- 为了要那个灰掉的button -->
				</c:otherwise>
				</c:choose>
				
				 <li class="text">${currentPage}/${totalPages}</li>
				
				<!-- 下一页 按钮 -->
				<c:choose>
				<c:when test="${currentPage != totalPages}">
					<li class="next"><a href="forumList?currentPage=${currentPage+1}&forumType=${forumType}&letterGroup=${letterGroup}">下一页</a></li>
				</c:when>
				<c:otherwise>
					<!--  <li class="next" disabled="true"><a >下一页</a></li>-->
				</c:otherwise>
				</c:choose>
                </ul>

				
            </div> 
             </c:if>
           
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <!-- footer开始 -->
		<jsp:include page="footer.jsp" flush='true'/>
		<!-- footer结束 -->
        <!-- 底部结束 -->
    </div>
    
   
   
   
</body>

</html>