<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 기능</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String logout  = (String)session.getAttribute("id");

	if(logout != null){
		
		session.setMaxInactiveInterval(0);
		session.invalidate();
		%>
		<script>
		location.href="mainSession.jsp";
		</script>
		<% }else if(logout == null){%>
		<script>
		alert("세션이 만료되었습니다.\n자동으로 로그아웃됩니다.");
		location.href="mainSession.jsp";
		</script>
	<%}%>

</body>
</html>