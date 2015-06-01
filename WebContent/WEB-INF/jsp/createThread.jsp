<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<scripttype="text/javascript"src="${pageContext.request.contextPath}/resource/script/jquery-1.9.1.min.js"></script>
<scripttype="text/javascript">
$(document).ready(function(){
$("#button_getUser").click(function(){
//异步请求json数据
$.ajax({
type:"POST",
url:"${pageContext.request.contextPath}/user/getUserList",
success:function(data){
//迭代返回的json数据
$.each(data,function(i,user){
$("#results").append(user.userName+"---"+user.password+"<br>");
});
},
error:function(e) {
alert("出错："+e);
}
});
});
});
</script>
</head>
<body>

</body>
</html>