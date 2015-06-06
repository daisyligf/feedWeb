<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="com.mofang.feedweb.entity.FeedForum"%>
<%@ page import="com.mofang.feedweb.entity.HotThread"%>
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
    <script src="js/jquery-2.1.4.js"></script>
    <script type="text/javascript">
		function search(){
			window.location.href = 'search?keyword='+document.getElementById("keyword").value;
		}
    </script>
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
                <input type="submit" class="ser-but" value="" id="submit" onclick="search()"/>
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
                    <a href="javascript:;" class="follow fllowed" data-areaid='234' data-dofollow='0'>+ 关注</a>
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
                            <div>
                                <span class="triangle">
                                    
                                </span>
                                <p id="quan">
                                	<a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=0&timeType=${timeType}">全部</a>
                                </p>
                                <p id="type_1">
                                    <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=1&timeType=${timeType}">精华</a>
                                </p>
                                <input type="hidden" value="${type }" id="threadType" name="threadType"/>
                            </div>
                            <div>
                                <span class="triangle">
                                    
                                </span>
                                <p id="time">
                                 	<a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=${type }&timeType=0">回复时间</a>
                                </p>
                                <p id="add_thread_time">
                                    <a href="forum_content?currentPage=${currentPage}&fid=${feedForum.forum_id}&type=${type }&timeType=1">发帖时间</a>
                                </p>
                                <input type="hidden" value="${timeType }" id="timeType" name="timeType"/>
                            </div>
                        </div>
                    </div>
                    <div class="con-left-con">
                    	<c:forEach var="feedThread" items="${threadList}">
                        <dl class="clearfix">
                            <dt><a href="#"><img src="${feedThread.avatar}"alt=""></a></dt>
                            <div class="infos">
                                <dd class="title"><a href="thread_info?thread_id=${feedThread.thread_id }">${feedThread.subject}
                                <c:if test="${feedThread.isTop}"><s class="icon-ding"></s></c:if>
                                
                                <c:if test="${feedThread.isElite}"><s class="icon-jing"></s></c:if>
                                <c:if test="${feedThread.hasPic}"><s class="icon-tu"></s></c:if>
                                </a></dd>
                                <dd>${fn:substring(feedThread.content, 0, 100)}...</dd>
                                <dd class="info clearfix">
                                    <p class="author">
                                        <span>作者：${feedThread.user_name}</span>
                                        <span class="time"><fmt:formatDate value="${feedThread.create_time}" type="both" pattern="MM-dd HH:mm"/></span>
                                    </p>
                                    <p class="look">
                                        <span><s class="icon-look"></s>${feedThread.page_view}</span>
                                        <span><s class="icon-ask"></s>${feedThread.replies}</span>
                                    </p>
                                </dd> 
                            </div>
                            
                        </dl>
                       </c:forEach>
                       <div class="page-plug col-xs-6">
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
			
			            </div>
                    </div>
                </div>
             </div>
             <div class="col-xs-3 con-bot-right">
                <div class="lord-team">
                    <h2 class="lum">
                        吧主团队 <a href="apply_check?forum_id=${feedForum.forum_id}">申请吧主</a>
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
	                       	   	<li><s class="black"></s><a href="${gift.url }">${gift.name }</a></li>
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
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
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
   <script>
   		var tagId = $('#tag_id').val();
   		if (tagId != '' && tagId > 0) {
   			$("#tag_" + tagId).addClass('active');
   		} else {
   			$("#tag_all").addClass('active');
   		}
   		
   		var type = $('#threadType').val();
   		if (type == 1) {
   			$('#quan').addClass('list');
   		} else {
   			$('#type_1').addClass('list');
   		}
   		
   		var timeType = $('#timeType').val();
   		if (timeType == 0) {
   			$('#add_thread_time').addClass('list');
   		} else {
   			$('#add_time').addClass('list');
   		}
   		
   </script>
   
</body>
</html>