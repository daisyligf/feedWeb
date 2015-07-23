<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 搜索开始 -->
   <div class="search">
       <div class="bbs-logo">
           <a href="index"><img src="./img/icon/bbs_icon.png" alt=""></a>
       </div>
       <div class="bbs-search">
          <!--   <input type="submit" class="ser-but" value="" id="submit"/>-->
          <input type="button" class="ser-but" value="" id="submit"/>
           <input type="text" class="ser-text" value="" id="keyword" data-default='${keyword }' placeholder="${keyword }"/>
       </div>
   </div>
   <!-- 搜索结束 -->