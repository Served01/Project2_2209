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
<title>회원 가입 기능</title>
</head>
<body>
<%

	request.setCharacterEncoding("UTF-8");
	request.getParameter("mb_pw2");

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