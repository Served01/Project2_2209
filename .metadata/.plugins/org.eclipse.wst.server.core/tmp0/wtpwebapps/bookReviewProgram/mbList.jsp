<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>  
<%@ page import="java.util.Vector" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원 목록 보기 화면</title>
</head>

<style>
table{
margin: auto;
}
</style>

<body>
<%
	mbDAO mdao = new mbDAO();
	
	Vector<mbBean> vec = mdao.allselectmember();
%>

<h2 align="center">전체 회원 정보 조회</h2>
<input type="button" value="마이페이지" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp&mb_id=<%=request.getParameter("mb_id") %>'" />&nbsp;&nbsp;
<button onclick="location.href='mainSession.jsp'">메인 페이지</button>
<br><br>

<table border="1">
	<tr align="center">
		<td>ID</td>
		<td>이름</td>
		<td>닉네임</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>가입일시</td>	
	</tr>

	<%
		for(int i=0; i < vec.size(); i++){
			mbBean mBean = vec.get(i);		
	%>
	
	<tr align="center">
		<td><a style="color:black" href="#" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp&mb_id=<%=mBean.getMb_id() %>'"><%=mBean.getMb_id() %></a></td>
		<td><%=mBean.getMb_name() %></td>
		<td><%=mBean.getMb_nick() %></td>
		<td><%=mBean.getMb_email() %></td>
		<td><%=mBean.getMb_tel() %></td>
		<td><%=mBean.getMb_gender() %></td>	
	</tr>
	<%} %>	
	</table>
</body>
</html>