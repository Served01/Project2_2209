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
			mbBean Bean = vec.get(i);		
	%>
	
	<tr align="center">
		<td><a href="mbSelectPro.jsp?mb_id=<%=Bean.getMb_id() %>"><%=Bean.getMb_id() %></a></td>
		<td><%=Bean.getMb_name() %></td>
		<td><%=Bean.getMb_nick() %></td>
		<td><%=Bean.getMb_email() %></td>
		<td><%=Bean.getMb_tel() %></td>
		<td><%=Bean.getMb_gender() %></td>	
	</tr>
	<%} %>	
	<tr align="center">
		<td colspan="6">
			<button onclick="javascript:history.go(-1)">뒤로가기</button>&nbsp;&nbsp;
			<button onclick="location.href='mainSession.jsp'">메인 페이지</button>
		</td>
	</tr>
	</table>
</body>
</html>