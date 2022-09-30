<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 삭제 기능</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	String logout  = (String)session.getAttribute("id");
	String id = request.getParameter("mb_id");
	String password = request.getParameter("password");
	
	mbDAO mdao = new mbDAO();
	String pass = mdao.getPassword(id);
	
	if(pass.equals(password)){
		
		mdao.deletemember(id);
		
	if (mdao.onecheckmember(id)==-1){
		
		session.setMaxInactiveInterval(0);
		session.invalidate();
		%>
		<script>
		location.href="mainSession.jsp";
		alert("회원 정보를 삭제하였습니다.");
		location.href="mainSession.jsp";
		</script>
			<%} else{ %>
			<script>
				alert("회원 정보 삭제에 실패하였습니다./n문의해 주십시오.");
				history.go(-1);
			</script>
			<%} %>	
		
	}else{
%>
	<script type="text/javascript">
		alert("비밀번호가 틀립니다. 확인해 주세요.")
		history.back();//go(-1);
	</script>		
<%
	}%>	
</body>
</html>