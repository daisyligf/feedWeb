<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="com.mofang.feedweb.entity.FeedForum"%>
<%@ page import="com.mofang.feedweb.entity.FeedThread"%>
<%@ page import="com.mofang.feedweb.entity.FeedPost"%>
<%@ page import="com.mofang.feedweb.entity.FeedComment"%>
<%@ page import="com.mofang.feedweb.entity.ThreadUserInfo"%>
<%@ page import="com.mofang.feedweb.entity.UserInfo"%>
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
    <title>帖子详情页</title>
    <!-- <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" /> -->
    <link rel="stylesheet" href="css/base.css">

    <link rel="stylesheet" href="js/editor/css/umeditor.css">
    <link rel="stylesheet" href="js/editor/css/fixeditor.css">
    <link rel="stylesheet" href="js/editor/emotion.css">

    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/article_article.css">
    <script src="js/sea.js"></script>
    <script src="js/sea-config.js"></script>
    <script src="js/bbs-config.js"></script>

    <script src="js/editor/js/jquery.min.js"></script>
    <script src="js/editor/js/umeditor.config.js"></script>
    <script src="js/editor/js/umeditor.js"></script>
    <script src="js/editor/lang/zh-cn/zh-cn.js"></script>
    <script src="js/editor/btn.js"></script>
    <script src="js/editor/feed-emotion.js"></script>
    
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
                <div class="nav-right" id="topUserInfo">
                    <!-- 登陆状态 -->
                    <!-- top登录模板 -->
                    
                    <a href="http://u.mofang.com/home/person/index" class="head" id="userName"><img src="" alt="" id="userImg" /><!-- <s class="icon-red"></s> --></a>
                    <div class="user-info">
                        <ul class="clearfix">
                            <li class="header-money" id="userMoney"><s class="icon-money"></s></li>
                            <li class="zuji"><a href="http://u.mofang.com/home/footprints/games">足迹</a><a href="http://u.mofang.com/home/message/reply" class="msg">消息<s class="icon-red"></s></a><a href="http://u.mofang.com/home/package/index" class="libao">礼包库</a></li>
                            <li class="info">
                               <a href="http://u.mofang.com/home/person/index">个人信息</a><a href="http://u.mofang.com/home/setting/info">设置</a><a href="javascript:;" class="out" id="logout">退出</a> 
                            </li>
                        </ul>
                    </div>
                    
                    <!-- 登陆状态 -->
                    <a href="http://u.mofang.com/home/account/index" class="load" target="_blank"><img src="img/icon/load.png"></a>
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
        
        <!-- 内容开始 -->
        <div class="con clearfix">
            <div class="nav clearfix">
                <div class="nav-left col-xs-6">
                    <a href="index">论坛首页</a> > <a href="forum_content?fid=${feedForum.forum_id }">${feedForum.forum_name }</a> > <a href="javascript:;" class="end">${feedThread.subject }</a>
                </div>
                <div class="page-plug col-xs-6">
                <ul class="page-pc">
                <!-- 上一页 按钮 -->
                
				<c:choose>
				<c:when test="${currentPage != 1}">
					<li class="prev"><a href="thread_info?currentPage=${currentPage-1}&thread_id=${feedThread.thread_id}&type=${type}">上一页</a></li>
				</c:when>
				<c:otherwise>
					<!--  <li class="prev" disabled="true" ><a ></a></li>--><!-- 为了要那个灰掉的button -->
				</c:otherwise>
				</c:choose>
				
				<!-- 页数列表 -->
				<c:forEach items="${pagelist}" var="item">
				<c:choose>
				<c:when test="${item == currentPage}">
					<li class="active"><a href="thread_info?currentPage=${item }&thread_id=${feedThread.thread_id}&type=${type}" >${item}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="thread_info?currentPage=${item}&thread_id=${feedThread.thread_id}&type=${type}">${item}</a></li>
				</c:otherwise>
				</c:choose>
				</c:forEach>
				
				<!-- 下一页 按钮 -->
				<c:choose>
				<c:when test="${currentPage != totalPages}">
					<li class="next"><a href="thread_info?currentPage=${currentPage+1}&thread_id=${feedThread.thread_id}&type=${type}">下一页</a></li>
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
            <div class="col-xs-3 user-info-out">
                <div class="user-info">
                   <dl>
                        <dt><a href="#"><img src="${threadUserInfo.avatar}" alt=""></a></dt>
                        <dd><a href='#'>${threadUserInfo.nickname}</a></dd>
                        <dd class="money"><s class="icon-money"></s>${threadUserInfo.coin}</dd>
                    </dl>
                    <ul class="clearfix">
                        <li class="col-xs-4"><span>${threadUserInfo.threads}</span>帖子</li>
                        <li class="col-xs-4"><span>${threadUserInfo.replies}</span>回复</li>
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
                       	   <li><s class="black"></s><a href="thread_info?thread_id=${highThread.tid }">${highThread.subject }</a></li>
                       	   </c:forEach>
                       </ul>
                    </div>
                    
                </div>
            </div>
            <div class="col-xs-9 col-md-12" id="getPostData" data-tid="${feedThread.thread_id} " data-uid="23412" data-fid="${feedForum.forum_id }">
            	<c:if test="${currentPage==1}">
                <div class="con-right1 clearfix">
                    <dl class="con-author clearfix">
                        <dt class="author-img">
                            <img src="img/img1.jpg" alt="">
                        </dt>
                        <dd class="author-name">但岁先生</dd>
                        <dd class="author-detail"><b>楼主</b><span>05-14</span><span> 15:10</span></dd>
                    </dl>
                    <h2> ${feedThread.subject } 
                     <c:choose>
                        	<c:when test="${type==1 }">
                        	<a href="thread_info?currentPage=${currentPage+1}&thread_id=${feedThread.thread_id}&type=0" class="landord">全部</a>
                        	</c:when>
                        	<c:otherwise>
                        	<a href="thread_info?currentPage=${currentPage+1}&thread_id=${feedThread.thread_id}&type=1" class="landord">只看楼主</a>
                        	</c:otherwise>
                        </c:choose>
                        
                         <c:if test="${fn:length(currentUser.privileges) > 0}">
                        <div class="manage">帖子管理
                            <div class="manage-more clearfix">
                                <a href="#" class="manege-top">置顶</a>
                                <a href="#" class="manege-great">精华</a>
                                <a href="#" class="manage-lock">锁帖</a>
                            </div>
                        </div>
                        </c:if>
                        
                    </h2>
                    <h3>楼主  <a href="#">${threadUserInfo.nickname}</a>  发表于  <fmt:formatDate value="${feedThread.create_time}" type="both" pattern="MM-dd HH:mm"/></h3>
                    <div class="con-con">
                    	${postList[0].htmlContent }
                    </div>
                    <p class="look">
                        <span class="thread-zan"><s class="icon-zan"></s><a href="javascript:;">${feedThread.recommends }</a></span>
                        <span><a href="#conRight2"><s class="icon-ask"></s>${feedThread.page_view }</a></span>
                    </p>
                </div>
                </c:if>
                <div class="con-right2" id="conRight2">
                    <!-- 楼层回复模板1 -->
                    <script id="floorCommentTemplate" type="text/x-handlebars-template">
                        {{#each this}}
                        <dl class="clearfix">
                            <dt><a href="{{url}}"><img src="{{avatar}}" alt=""></a></dt>
                            <dd><a href="{{url}}">{{nickname}}:</a>&nbsp;&nbsp;&nbsp; {{content}}</dd>
                            <dd class="autor">{{timeformat ctime}}        <a href="javascript:;" class="dianping" data-name="{{nickname}}" data-uid="{{uid}}" data-tid="{{tid}}">回复</a></dd>
                        </dl>
                        {{/each}} 
                    </script>
                    <!-- 楼层回复模板2 -->
                    <script id="floorCommentTemplate2" type="text/x-handlebars-template">
                        
                        <dl class="clearfix">
                            <dt><a href="{{url}}"><img src="{{avatar}}" alt=""></a></dt>
                            <dd><a href="{{url}}">{{nickname}}:</a>&nbsp;&nbsp;&nbsp; {{content}}</dd>
                            <dd class="autor">{{timeformat ctime}}        <a href="javascript:;" class="dianping" data-name="{{nickname}}" data-uid="{{uid}}" data-tid="{{tid}}">回复</a></dd>
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
                    <div class="con-list" data-postid="123214" data-uid="1234" data-page='1'>
                        <p class="con-list-left">
                            <img src="${feedPost.postUserInfo.avatar }" alt="">
                        </p>
                        <div class="con-list-right">
                            <dl class="list-right-dl">
                                <dt><a href="javascript:;" class="list-del">删除</a>${feedPost.position }楼  <a href="#">${feedPost.postUserInfo.nickname }</a>    发表于  <fmt:formatDate value="${feedPost.create_time}" type="both" pattern="MM-dd HH:mm"/></dt>
                                <dd>${feedPost.htmlContent }</dd>
                                <dd class="clearfix">
                                    <p class="look">
                                        <span class="zan"><s class="icon-zan"></s><a href="javascript:;">${feedPost.recommends}</a></span><span class="floor-stop"><s class="icon-ask reply-hide"></s>收起</span><span class="floor-rec"><s class="icon-ask"></s><a href="javascript:;">${feedPost.replies}</a></span>
                                    </p>
                                </dd>
                            </dl>
                            <div class="con-list-reply">
                                <div class="con-list-replycon">
                                    <!--楼层回复内容-->
                                </div>
                                
                                <p class="floor-reply-more">更多${feedPost.comments }条回复    <a href="javascript:;">点击加载</a></p>
                                <div class="reply-textarea">
                                    <input type="hidden"  name="tid" class="tid" value="2342"/>
                                    <input type="hidden"  name="uid" class="uid" value="2342"/>
                                    <input type="hidden"  name="postname" class="postname" value="2342"/>
                                    <textarea name="" class="dianping-textarea" cols="30" rows="10">回复</textarea>
                                    <p class="replay-floor"><span class="replay-count">还可以输入140字</span> <input type="button" class="reply-btn" value="回复"></p>
                                </div>
                            </div>
                            
                        </div>
                       
                    </div>
                    </c:forEach>
                    <!-- 分页 -->
                    <div class="page-plug">
                        <ul class="page-mobile clearfix">
                            <li class="prev"><a href="#">上一页</a></li>
                            <li class="text">5/235</li>
                            <li class="next"><a href="#">下一页</a></li>
                        </ul>
                    </div>

                </div>
                <div class="con-right3 reply-textarea">
                    <div class="reply-textarea-info clearfix">
                        <p class="reply-head"><a href="#"><img src="img/img1.jpg" alt=""></a></p>
                        <dl>
                            <dt></dt>
                            <dd><textarea name="" id="" cols="30" rows="10" class="editor-cont"></textarea></dd>
                            <dd>
                                <div class="editer">
                                    <div class="editor-textarea">
                                        <div class="textmask">您需要登录后才可以发帖 <a class="maskLogin" href="http://u.mofang.com/">登录</a> | <a  class="maskReg" href="http://u.mofang.com/">立即注册</a></div>
                                    </div>
                                    <script type="text/plain" id="myEditor" style="height:240px;"></script>
                                </div>
                            </dd>
                            <form id="editor-form" data-form="post" data-tid="${feedThread.thread_id }" action="send_reply" method="POST">
                                <input type="hidden" name="fid" class="editor-fid" value="${feedForum.forum_id }"/>
                                <input type="hidden" name="tid"  class="editor-tid" value="${feedThread.thread_id }">
                                <input type="hidden" name="content"  class="editor-cont" value=""/>
                            </form>
                        </dl>
                    </div>
                    
                    <p class="replay-floor"><span class="word-count">还可以输入5000字</span> <input type="button" class="reply-editer reply-submit" value="回复"></p>
                </div>
            </div>
        </div>
        <!-- 内容结束 -->
        <!-- 底部开始 -->
        <div class="footer cleafix">
            <p>© 2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
        </div>
        <!-- 底部结束 -->
        <!-- 弹出框开始 -->
        <!-- 遮罩层开始 -->
        <div class="mask-bg">
             <h2>《最终幻想14》2.2新版截图推出炫耀装备系统 
                 <a href="#" class="landord">只看楼主</a>
                 <div class="manage">帖子管理
	                 <div class="manage-more clearfix">
	                      <a href="#">编辑</a>
	                      <a href="javascript:;" class="manage-delete">删除</a>
	                      <a href="javascript:;" class="manege-top">置顶</a>
	                       <a href="javascript:;" class="manege-top off-manege-top">取消精华</a>
	                      <a href="javascript:;" class="manege-great">精华</a>
	                      <a href="javascript:;" class="manege-great off-manege-great">取消精华</a>
	                      <a href="javascript:;" class="manage-lock">锁帖</a>
	                      <a href="javascript:;" class="manage-lock off-manege-lock">锁帖</a>
	                      <a href="javascript:;" class="manage-reward">奖励</a>
	                  </div>
                 </div>
                        
            </h2>
        </div>
        <!-- 遮罩层结束 -->
        
        <div class="pop pop-post-delete">
            <h2 class="clearfix">
                <span>
                    <img src="img/icon/pop_close.png" class="close">
                </span>删除帖子
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
    
    <script src="js/mod/article_article.js"></script>
    <script src="js/mod/common.js"></script>
    <script src="js/mod/comment.js"></script>
</body>
</html>
