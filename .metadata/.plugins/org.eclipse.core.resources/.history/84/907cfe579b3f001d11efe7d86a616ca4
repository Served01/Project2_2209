<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 처리 프로세스</title>
</head>
<body>
	
<%
	String pw1 = request.getParameter("mb_pw1");
	String id = request.getParameter("mb_id");
	
	mbDAO mdao = new mbDAO();
	String password = mdao.getPassword(id);
	
	if(pw1.equals(password)){
	
	String pw2 = request.getParameter("mb_pw2");
	String pw3 = request.getParameter("mb_pw3");

	
	if (pw1.equals(pw2)) {
		
		mdao.updatepass(id,pw2);
		
		out.println("<script>");
		out.println("alert('비밀번호 수정에 성공하였습니다.')");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
		
	}else{
	

%>

	<script type="text/javascript">
		alert("변경후 비밀번호가 다릅니다. 확인해 주세요.")
		history.back();//go(-1);
	</script>
	
	<% } 
	} else{%>
		<script type="text/javascript">
		alert("변경전 비밀번호가 틀립니다. 확인해 주세요.")
		history.back();//go(-1);
	</script>
	
	<% }%>	
</body>
</html>