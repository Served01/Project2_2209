<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 구현</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
	<jsp:useBean id="Bean" class="BKRV.member.mbBean">
		<jsp:setProperty name="Bean" property="*"/>
	</jsp:useBean>

<%
String id = request.getParameter("mb_id");
	String password = request.getParameter("password");
	
	mbDAO mdao = new mbDAO();
	String pass = mdao.getPassword(id);
	
	if(pass.equals(password)){
		mdao.updatemember(Bean);
		
		response.sendRedirect("mbList.jsp");
	}else{
%>
	<script type="text/javascript">
		alert("비밀번호가 틀립니다. 확인해 주세요.")
		history.back();//go(-1);
	</script>
<% } %>
</body>
</html>