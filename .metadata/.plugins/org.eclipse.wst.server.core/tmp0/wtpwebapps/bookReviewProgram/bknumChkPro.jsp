<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page import="BKRV.book.bkBean"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일련번호 중복 확인</title>
</head>
<body>
	
<%

    int bk_number=Integer.parseInt(request.getParameter("bk_number"));
	
    bkDAO bdao = new bkDAO();
    
    int check = bdao.duplecateBKnum(bk_number);
    
    if(check==1){
    %>
    	<h2>사용할 수 없는 일련번호입니다.</h2>
    	
	<% }else{
	%>
    	<h2>사용가능한 일련번호입니다.</h2>
    	
  <%  } %>
 
</body>
</html>