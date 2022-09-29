<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page import="BKRV.book.bkBean"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 수정</title>
</head>
<body>

<!-- bean이 있는 것을 보낼 때는 아래와 같이 이용 -->
<jsp:useBean id="bBean" class="BKRV.book.bkBean">
		<jsp:setProperty name="bBean" property="*"/>		
</jsp:useBean>

<%
	
	bkDAO bdao = new bkDAO();
	bdao.updateBook(bBean);
	out.print("location.href='mainSession.jsp'");
%>

</body>
</html>