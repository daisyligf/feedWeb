<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String str = "";
try {
	Object obj = request.getAttribute("linkflg");
 if (null != obj) {
	 str = String.valueOf(obj);
 };
} catch (Exception e) {
}
 %>
 <!-- 底部开始 -->
 <div class="footer cleafix">
 	
 	 <div class="footer-con">
	 	 <div class="footer-nav clearfix width-1280">	
	 	  <% if (str.equals("1")) {%>
	        <div class="footer-crumbs">
	              <c:if test="${feedThread.subject != null }"> 
	        	  <a href="<%=CommonUrl.bbsHomeUrl%>">论坛首页</a> > <a href="<%=CommonUrl.baseUrl%>/forum/${feedForum.forum_id}.html">${feedForum.forum_name }</a> > <a href="javascript:;" class="end">${feedThread.subject }</a>
				  </c:if>
				   <c:if test="${feedThread.subject == null and feedForum.forum_name != ''}"> 
	        	  <a href="<%=CommonUrl.bbsHomeUrl%>">论坛首页</a> > <a href="javascript:;" class="end">${feedForum.forum_name }</a>
				  </c:if> 
	    	</div>
	    	<% }%>
	    	<div class="footer-nav-list clearfix">
	    		<dl>
	    			<dt><a target="_blank" href="<%=CommonUrl.mofangHomeUrl%>">魔方网</a></dt>
	    			<dd><a target="_blank" href="http://www.mofang.com/about/index">关于魔方</a></dd>
	    			<dd><a target="_blank" href="http://www.mofang.com/about/join">加入魔方</a></dd>
	    			<dd><a target="_blank" href="http://www.mofang.com/about/contact">广告合作</a></dd>
	    		</dl>
	    		<dl>
	    			<dt><a target="_blank" href="javascript:void(0);">游戏资讯</a></dt>
	    			<dd><a target="_blank" href="http://www.mofang.com/news/">游戏新闻</a></dd>
	    			<dd><a target="_blank" href="http://www.mofang.com/pingce_www/">新游评测</a></dd>
	    			<dd><a target="_blank" href="http://game.mofang.com">游戏库</a></dd>
	    			<dd><a target="_blank" href="http://newbbs.mofang.com/index">手游论坛</a></dd>
	
	    		</dl>
	    		<dl>
	    			<dt><a target="_blank" href="javascript:void(0);">游戏视频</a></dt>
	    			<dd><a target="_blank" href="http://v.mofang.com/markpi/934-1.html">魔客派</a></dd>
	    			<dd><a target="_blank" href="http://v.mofang.com/fwbk/1172-1.html">非玩不可</a></dd>
	    			<dd><a target="_blank" href="http://v.mofang.com/introduction/">手游全攻略</a></dd>
	
	    		</dl>
	    		<dl>
	                <dt><a target="_blank" href="javascript:void(0);">游戏专区</a></dt>
	    			<dd><a target="_blank" href="http://my.m.mofang.com/">梦幻西游</a></dd>
	    			<dd><a target="_blank" href="http://nnhysj.m.mofang.com/">暖暖环游世界</a></dd>
	    			<dd><a target="_blank" href="http://hyrzol.m.mofang.com/">火影忍者手游</a></dd>
	    			<dd><a target="_blank" href="http://m.mofang.com/mxd/">冒险岛手游</a></dd>
	    		</dl>
	    		<dl>
	    			<dt><a target="_blank" href="javascript:void(0);">魔方产业</a></dt>
	    			<dd><a target="_blank" href="http://c.mofang.com/news_c/">产业新闻</a></dd>
	                <dd><a target="_blank" href="http://c.mofang.com/guandian/">星观点</a></dd>
	                <dd><a target="_blank" href="http://c.mofang.com/shilu/">媒良心</a></dd>
	                <dd><a target="_blank" href="http://cs.mofang.com/">厂商库</a></dd>
	    		</dl>
	    		
	    		<dl>
	    			<dt><a target="_blank" href="javascript:void(0);">关于我们</a></dt>
	    			<dd><a target="_blank" href="http://weibo.com/3228285935/profile">魔方微博</a></dd>
	    			<dd><a target="_blank" href="javascript:void(0);">魔方带你飞</a></dd>
	    			<dd><a target="_blank" href="javascript:void(0);">魔方网络</a></dd>
	    			<dd><a target="_blank" href="javascript:void(0);">魔方陪你玩</a></dd>
	
	    		</dl>
	    		<dl class="last-dl">
	    			<dt><a target="_blank" href="javascript:void(0);"><img src="<%=CommonUrl.baseUrl%>/img/footer_logo.png" alt=""></a></dt>
	    			<dd><a target="_blank" href="javascript:;">关注魔方网，一起发现好游戏！</a></dd>
	
	    		</dl>
	    	</div>
	        <p class="record">©2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
	    </div>
 	 	<!-- <p class="beian">© 2015 魔方网 皖ICP备13001602号-1</p> 
 	 	<p class="link">友情连接：<a href="http://bbs.ptbus.com">口袋巴士</a><a href="http://www.haimawan.com">海马玩</a><a href="http://bbs.haimawan.com">海马玩论坛</a><a href="http://dou.tgbus.com">巴豆论坛</a><a href="http://game.ali213.net">游侠netshow论坛</a></p>
 	 	-->
 	 	<div class="wap-footer">
 	 		<div class="wap-footer-nav">
				<a href="http://game.m.mofang.com/tag_0_platform_1_sort_0.html">苹果游戏</a>
				<a href="http://game.m.mofang.com/tag_0_platform_2_sort_0.html">安卓游戏</a>
				<a href="http://weibo.com/cubegame">魔方微博</a>
				<a href="http://m.mofang.com">更多资讯</a>
			</div>
			<div class="footer-logo">
			
			</div>
			<p class="beian"> <span>&copy;</span>2015 魔方网 MOFANG.COM 皖ICP备13001602号-1</p>
 	 	</div>
 	 </div>
     
 </div>
 <!-- cnzz统计代码 -->
 <div class="cnzz" style="display:none">
 	<script type="text/javascript">
 		var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
 		document.write(unescape("%3Cspan id='cnzz_stat_icon_1000370935'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/q_stat.php%3Fid%3D1000370935' type='text/javascript'%3E%3C/script%3E"));
 	</script>
 </div>
  <!-- baidu统计代码 -->
  <div class="baidu" style="display:none">
	<script type="text/javascript">
		var _hmt = _hmt || [];
		(function() {
  			var hm = document.createElement("script");
  				hm.src = "//hm.baidu.com/hm.js?b5fe97c9be553611eaa9d4aa4f803f71";
  			var s = document.getElementsByTagName("script")[0]; 
  				s.parentNode.insertBefore(hm, s);
		})();
</script>
 </div>
 <!--单独版块的统计代码  -->
 <c:if test="${statisticsInfo.forum_statistics_id > 0 and feedForum.forum_id == statisticsInfo.forum_statistics_id}">
 	<div class="forumStatistics" style="display:none">
 		${statisticsInfo.forum_statistics_url}
 	</div>
 </c:if>
 
 <!-- 底部结束 -->
 
