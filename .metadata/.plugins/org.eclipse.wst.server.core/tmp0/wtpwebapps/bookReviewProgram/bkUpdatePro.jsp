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
	
	int bk_number = bBean.getBk_number();

	bkDAO bdao = new bkDAO();
	bdao.updateBook(bBean);
	
	if (bdao.selectcheckBook(bk_number)==1){
		%>
		<script>
			alert("책 정보를 수정하였습니다.");
			location.href="mainSession.jsp?center=bkUpdateform.jsp&bk_number=<%=bk_number%>";
		</script>
		<%} else{ %>
		<script>
			alert("책 정보를 수정하지 못하였습니다./n다시 확인해 주십시오.");
			history.go(-1);
		</script>
		<%} %>
	
%>

</body>
</html>