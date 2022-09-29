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

	String password2=request.getParameter("mb_pw2");

%>
	<jsp:useBean id="mbean" class="BKRV.member.mbBean" scope="page">
		<jsp:setProperty name="mbean" property="*"/>
	</jsp:useBean>

<%
	if(password2.equals(mbean.getMb_pw())){
		
	mbDAO mdao = new mbDAO();
	mdao.insertmember(mbean);
	if (mdao.onecheckmember(mbean.getMb_id())==1){
		%>
		<script>
			alert("회원가입에 성공하였습니다. 로그인 해 주십시오.");
			location.href="loginform.jsp";
		</script>
		<%} else{ %>
		<script>
			alert("회원가입에 실패하였습니다./n다시 확인해 주십시오.");
			history.go(-1);
  		</script>
<%	} }else{ %>
	<script>
	alert("비밀번호가 다릅니다. 다시 확인해 주십시오.");
	history.go(-1);
	</script>
<% 	} %>	

	
</body>
</html>