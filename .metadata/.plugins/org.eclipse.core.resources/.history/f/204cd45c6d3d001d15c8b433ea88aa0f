<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%> 
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면 구현</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

%>
	<jsp:useBean id="Bean" class="BKRV.member.mbBean" scope="page">
		<jsp:setProperty name="Bean" property="*"/>
	</jsp:useBean>

<%

	mbDAO mdao = new mbDAO();
	mdao.insertmember(Bean);

	//response.sendRedirect("mbList.jsp");
%>	

	
</body>
</html>