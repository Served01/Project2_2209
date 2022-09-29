<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import = "java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정 기능</title>
</head>
<body>

	<jsp:useBean id="rbean" class="BKRV.review.rvBean">
		<jsp:setProperty name="rbean" property="*"/>
	</jsp:useBean>
	
<%

	rvDAO rdao = new rvDAO();
	rdao.updateReview(rbean);
	
%>

<script>
alert("댓글정보를 변경하였습니다.");
location.href="mainSession.jsp?center=bkSelectPro.jsp&bk_number=<%=rbean.getRv_bknumber()%>";
</script>

</body>
</html>