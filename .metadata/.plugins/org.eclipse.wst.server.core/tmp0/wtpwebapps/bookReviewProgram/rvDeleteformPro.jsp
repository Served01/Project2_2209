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
<title>글 삭제</title>
</head>
<body>
	<jsp:useBean id="rBean" class="BKRV.review.rvBean">
		<jsp:setProperty name="rBean" property="*"/>
	</jsp:useBean>
<%
	request.setCharacterEncoding("UTF-8");

	int Rv_number = Integer.parseInt(request.getParameter("Rv_number"));
	int Rv_bknumber = Integer.parseInt(request.getParameter("Rv_bknumber"));
	String Rv_id = request.getParameter("Rv_id");
	
	rvDAO rdao = new rvDAO();
	
	/* String pass = rdao.getPass(rBean.getNum());
	
	if(pass.equals(rBean.getPassword())){ */
		
		rdao.deleteReview(Rv_number, Rv_bknumber, Rv_id);
		
		//response.sendRedirect("boardList.jsp");
		
	/*
	}else{
		*/
		%>
		<!--
		<script type="text/javascript">
			alert("비밀번호 불일치");
			histroy.go(-2);
		</script>
		-->
		<script type="text/javascript">
			histroy.back();
		</script>
		<%
	/*
	}
	*/
	
%>
</body>
</html>