<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO"%>
<%@ page import="BKRV.member.mbBean"%>
<%@ page import="BKRV.review.rvDAO"%>
<%@ page import="BKRV.review.rvBean"%>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 리뷰 정보 삭제</title>
</head>
<body>

<%
	int rv_number = Integer.parseInt(request.getParameter("rv_number"));
	int rv_bknumber = Integer.parseInt(request.getParameter("rv_bknumber"));
	String rv_id = request.getParameter("rv_id");
	
	rvDAO rdao = new rvDAO();
	rdao.deleteReview(rv_number);
	
	if(rdao.checkReview(rv_number)==-1){
%>		
<script>
	alert("삭제되었습니다.");
	location.href="mainSession.jsp?center=bkSelectPro.jsp&bk_number=<%=rv_bknumber%>";
</script>
<%} else{ %>
<script>
	alert("삭제를 실패하였습니다./n문의해 주십시오.");
	location.href="mainSession.jsp?center=bkSelectPro.jsp&bk_number=<%=rv_bknumber%>";
</script>
<%} %>
</body>
</html>