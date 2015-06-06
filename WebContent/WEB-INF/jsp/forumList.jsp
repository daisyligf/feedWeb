<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/channel.css">
    <script src="./js/sea.js"></script>
    <script src="./js/sea-config.js"></script>
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
        <jsp:include page="user_info.jsp" flush='true'/>
      <!--   <div class="header clearfix">
            <div class="nav clearfix">
                <div class="nav-left">
                    <a href="http://www.mofang.com">魔方网首页</a>
                </div>
                	
                <div class="nav-right" id="topUserInfo">
                    登陆状态
                    top登录模板
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
                    
                    登陆状态
                    <a href="http://u.mofang.com/home/account/index" class="load" target="_blank"><img src="./img/icon/load.png"></a>
                </div> 
            </div>
            <div class="nav-wap clearfix">
              <div class="nav-wap-left">
                  <a href="http://www.mofang.com"><img src="./img/icon/nav_three.png"></a>
                  <p class="nav-info">
                    <a class="nav-info-home">首页</a>
                    <a>个人中心</a>
                  </p>
              </div> 
            </div>
        </div>-->
        <!-- 头部结束 -->
        <!-- 搜索开始 -->
        <div class="search">
            <div class="bbs-logo">
                <img src="./img/icon/bbs_icon.png" alt="">
            </div>
            <div class="bbs-search">
                <input type="button" class="ser-but" value="" name="search" id="search"/>
                <input type="text" class="ser-text" value="${searchkey} " id="keyword" placeholder="过来搜我"/>
                <input type="hidden" id="forumType"   name="forumType" value="${forumType }">
                <input type="hidden" id="letterGroup"   name="letterGroup" value="${letterGroup }">
            </div>
        </div>
        <!-- 搜索结束 -->
        <!-- 内容开始 -->
        <div class="con clearfix">
           <div class="h2">热门游戏</div>
           <div class="channel-list">
           <c:if test="${letterGroup=='1'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=1&currentPage=1&forumType=${forumType}">ABCDE</a></div>
           </c:if>  
           <c:if test="${letterGroup !='1'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=1&currentPage=1&forumType=${forumType}">ABCDE</a></div>
           </c:if>
           <c:if test="${letterGroup =='2'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=2&currentPage=1&forumType=${forumType}">FGHIJ</a></div>
           </c:if>
           <c:if test="${letterGroup !='2'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=2&currentPage=1&forumType=${forumType}">FGHIJ</a></div>
           </c:if>
           <c:if test="${letterGroup =='3'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=3&currentPage=1&forumType=${forumType}">KLMNO</a></div>
           </c:if>
           <c:if test="${letterGroup !='3'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=3&currentPage=1&forumType=${forumType}">KLMNO</a></div>
           </c:if>
           <c:if test="${letterGroup =='4'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=4&currentPage=1&forumType=${forumType}">PQRST</a></div>
           </c:if>   
            <c:if test="${letterGroup !='4'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=4&currentPage=1&forumType=${forumType}">PQRST</a></div>
           </c:if>   
           <c:if test="${letterGroup =='5'}">
           		<div class="col-xs-2 active"><a href="forumList?letterGroup=5&currentPage=1&forumType=${forumType}">WXYZ</a></div>
           </c:if>
            <c:if test="${letterGroup !='5'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=5&currentPage=1&forumType=${forumType}">WXYZ</a></div>
           </c:if>
           <c:if test="${letterGroup =='6'}">
               <div class="col-xs-2 active"><a href="forumList?letterGroup=6&currentPage=1&forumType=${forumType}">#</a></div>
           </c:if>
           <c:if test="${letterGroup !='6'}">
           		<div class="col-xs-2"><a href="forumList?letterGroup=6&currentPage=1&forumType=${forumType}">#</a></div>
           </c:if>
           </div>
           <div class="h2-con clearfix container">
           <!-- 内容循环开始 -->
           	<c:choose>
				<c:when test="${not empty listInfo}">
					<c:forEach items="${listInfo}" var="forum" varStatus="vs">						
			               <div class="col-xs-3 col-md-4  col-sm-6">
			                   <dl class="clearfix">
			                       <dt><a href="forum_content?fid=${forum.forumId}"><img src="${forum.icon} " alt=""></a></dt>
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
			                      <a href="#"  class="zq bg-grey l">专区</a>
			                      </c:if>
			                   </c:if>
			                    <c:if test="${forumType == 2}">
			                      <c:if test="${forum.downLoadUrl != ''}">
			                      <a href="${forum.downLoadUrl}"  class="zq l">下载</a>
			                      </c:if>
			                      <c:if test="${forum.downLoadUrl == ''}">
			                      <a href="#"  class="zq bg-grey l">下载</a>
			                      </c:if>
			                   </c:if>
			                   <c:if test="${forum.giftUrl != ''}">
			                      <a href="${forum.giftUrl}" class="zq r">礼包</a> 
			                   </c:if>
			                   <c:if test="${forum.giftUrl == ''}">
			                      <a href="#" class="zq bg-grey r">礼包</a> 
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
                

            </div> 
              
           
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
    </div>
    
   <script src="./js/mod/channel.js"></script>
   
</body>
<script type="text/javascript">
$('#search').click(function() {
	var searchKey = $('#searchKey').val();
	window.location.href = "search?keyword="+searchKey;
});

</script>
</html>