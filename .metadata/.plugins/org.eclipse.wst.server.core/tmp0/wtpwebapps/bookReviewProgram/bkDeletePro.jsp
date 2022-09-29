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
	bkDAO bdao = new bkDAO();
	int bk_number=Integer.parseInt(request.getParameter("bk_number"));
	
	if(bdao.selectcheckBook(bk_number)==1){
	bdao.deleteBook(bk_number);
	out.print("<script>alert('삭제되었습니다.');</script>");
	out.print("<script>location.href='mainSession.jsp'</script>");
	} else{
		out.print("<script>alert('삭제하려는 정보가 없습니다.');</script>");
		out.print("<script>history.go(-1);</script>");
	}
	
%>
</body>
</html>