<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>  
<%@ page import="java.util.Vector" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 보기 화면</title>
</head>
<body>
<%
	mbDAO mdao = new mbDAO();
	
	Vector<mbBean> vec = mdao.allselectmember();
%>

<h2 align="center">회원 정보 조회</h2>
<table border="1" style="align: center width: 100%">
	<tr align="center" style="height: 40; background: pink;">
		<td width="100">ID</td>
		<td width="120">이름</td>
		<td width="120">닉네임</td>
		<td width="120">이메일</td>
		<td width="120">전화번호</td>
		<td width="120">가입일시</td>	
	</tr>

	<%
		for(int i=0; i < vec.size(); i++){
			mbBean Bean = vec.get(i);		
	%>
	
	<tr height="40" align="center">
		<td><a href="mbselectPro.jsp?id=<%=Bean.getMb_id() %>"><%=Bean.getMb_id() %></a></td>
		<td><%=Bean.getMb_name() %></td>
		<td><%=Bean.getMb_nick() %></td>
		<td><%=Bean.getMb_email() %></td>
		<td><%=Bean.getMb_tel() %></td>
		<td><%=Bean.getMb_gender() %></td>	
	</tr>
	<%} %>	
</table>
	<table align="center">
		<tr>
			<td>
				<button onclick="location.href=history.go(-1)">뒤로가기</button>&nbsp;&nbsp;
				<button onclick="location.href='mainSession.jsp'">메인 페이지</button>
		</tr>
	</table>
</body>
</html>