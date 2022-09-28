<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "BKRV.member.mbDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginFormPro</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id  = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	mbDAO mdao = new mbDAO();
	mdao.getConnection();
	
	int check = mdao.login(id, pass);
	
	if(check==1){
		
		session.setAttribute("id", id);
		session.setAttribute("pass", pass);
		
		session.setMaxInactiveInterval(60*60*12);
		
		response.sendRedirect("mainSession.jsp");

		}else if(check==0){%>
		<script>
			alert("비밀번호가 맞지 않습니다.");
			history.go(-1);
		</script>
	<%}else{ %>
		
%>
	<script type = "text/javascript">
		alert("아이디가 틀립니다. 확인해 주세요.")
		history.go(-1);
	</script>


<% } %>

</body>
</html>