<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mofang.feedweb.global.CommonUrl"%>
<%@ page import="com.mofang.feedweb.global.UserCenter"%>

            <div class="nav clearfix">
                <div class="nav-left">
                    <a target="_blank" href="http://www.mofang.com">魔方网首页</a>
                    <!--  <a href="http://bbs.mofang.com" class="old-bbs">返回旧版</a>-->
                </div>
                <div class="nav-right" id="topUserInfo">
                    <!-- 登陆状态 -->
                    <!-- top登录模板 -->
                    
                    <p class="nav-right-title head">
                    	<a href="<%=UserCenter.baseUrl %>/home/person/index" class="level-img">
                    		<span class="grade" id="level">Lv.15</span><img src="" alt="" id="userImg" />
                    	</a>
                    	<a class="level-text" href="<%=UserCenter.baseUrl %>/home/person/index" id="userName"><s class="icon-red"></s></a>
                    </p>
                    <div class="user-info">
                        <ul class="clearfix">
                            <li class="header-money"><span id="userMoney"><s class="icon-money"></s></span></li>
                            <li class="header-task"><span class="task-info"></span><span class="task-text">经验值 0/0</span></li>
                            <li class="zuji"><a href="<%=UserCenter.baseUrl %>/home/footprints/games" class="zj">足迹<s class="icon-red"></s></a><a href="<%=UserCenter.baseUrl %>/home/message/reply" class="msg">消息<s class="icon-red"></s></a><a href="<%=UserCenter.baseUrl %>/home/package/index" class="libao">礼包库<s class="icon-red"></s></a></li>
                            <li class="info">
                               <a href="<%=UserCenter.baseUrl %>/home/person/index">个人信息</a><a href="<%=UserCenter.baseUrl %>/home/setting/info">设置</a><a href="javascript:;" class="out" id="logout">退出</a> 
                            </li>
                        </ul>
                    </div>
                    
                    <!-- 登陆状态 -->
                    <div class="no-login">
                    	<a href="<%=UserCenter.baseUrl %>/home/account/index" class="load" ><img src="<%=CommonUrl.baseUrl%>/img/icon/load.png"></a>
                    	<a href="<%=UserCenter.baseUrl %>/home/account/index" class="no-login-login">登录</a> | <a href="<%=UserCenter.baseUrl %>/home/account/index" class="no-login-reg">注册</a>
                    </div>
                    
                </div>
            </div>
 