<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글쓰기</title>
</head>
<body>
	<jsp:useBean id="rBean" class="BKRV.review.rvBean">
		<jsp:setProperty name="rBean" property="*"/>
	</jsp:useBean>
<%
	request.setCharacterEncoding("UTF-8");
	
	rvDAO rdao = new rvDAO();
	rdao.updateReview(rBean);
	
	//response.sendRedirect("boardList.jsp");
	
%>
<script type="text/javascript">
		histroy.go(-2);
	</script>
</body>
</html>