<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="kr.co.ezen.boardDAO" %>
<%@ page import="kr.co.ezen.boardBean" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글쓰기</title>
</head>
<body>
	<jsp:useBean id="bBean" class="kr.co.ezen.boardBean">
		<jsp:setProperty name="bBean" property="*"/>
	</jsp:useBean>
<%
	request.setCharacterEncoding("UTF-8");

	int num = Integer.parseInt(request.getParameter("num"));
	String password = request.getParameter("password");
	
	boardDAO bdao = new boardDAO();
	
	String pass = bdao.getPass(bBean.getNum());
	
	if(pass.equals(bBean.getPassword())){
		
		bdao.deleteBoard(num);
		
		response.sendRedirect("boardList.jsp");
		
	}else{
		%>
		<script type="text/javascript">
			alert("비밀번호 불일치");
			history.back();
		</script>
		<%
	}
	
%>
</body>
</html>