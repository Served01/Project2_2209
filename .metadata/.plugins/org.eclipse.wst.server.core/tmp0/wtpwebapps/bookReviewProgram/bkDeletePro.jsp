<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page import="BKRV.book.bkBean"%>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 삭제</title>
</head>
<body>

<%
	int bk_number = 20220003; //Integer.parseInt(request.getParameter("bk_number"));
	
	bkDAO bdao = new bkDAO();
	bdao.deleteBook(bk_number);
	
	//out.print("<script>alert('삭제되었습니다.');</script>");
	//response.sendRedirect("bkInsertform.jsp");//response.sendRedirect("mainsession.jsp");
%>
</body>
</html>