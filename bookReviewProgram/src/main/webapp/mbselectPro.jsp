<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
</head>
<body>
<%
	String id = request.getParameter("Mb_id");

	mbDAO mdao = new mbDAO();
	mbBean Bean = mdao.oneselectmember(id);
%>

	 <%

	if(id != "admin") {  %>
	
		<h2 align="center">회원 정보 상세 보기</h2>
		
		<p align="right">
			<button onclick="location.href='reviewSelectMemberPro.jsp'">내가 쓴 리뷰</button>
		</p>
		
	<% }else if(id == "admin") { %>
	
		<h2 align="center">관리자 페이지</h2>
	
	<% } %>


<div align="center">
	<table border="1" style="text-align: center; width: 100%;">
		<tr align="center" style="height: 40; background: pink;">
			<td width="100">아이디</td>
			<td><%=Bean.getMb_id() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">이름</td>
			<td><%=Bean.getMb_name() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">닉네임</td>
			<td><%=Bean.getMb_nick() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">이메일</td>
			<td><%=Bean.getMb_email() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">전화번호</td>
			<td><%=Bean.getMb_tel() %></td>
		</tr>
		
		<tr align="center" style="height: 40; background: yellow;">
			<td width="80">성별</td>
			<td><%=Bean.getMb_gender() %></td>
		</tr>
		<tr style="height: 40; ">
			<td colspan="2">
			<button onclick="location.href='memberUpdateform.jsp?id=<%=Bean.getMb_id() %>'">수정</button>&nbsp;&nbsp;
			
			<%

			if(id != "admin") {  %>
	
				<button onclick="location.href='memberDeleteform.jsp?id=<%=Bean.getMb_id() %>'">삭제</button>&nbsp;&nbsp;
	
			<% }else if(id == " admin") { %>
			
			<button onclick="location.href='mbList.jsp'">회원 목록 조회</button>
			
			<% } %>
			
				<button onclick="location.href=history.go(-1)">뒤로가기</button>&nbsp;&nbsp;
				<button onclick="location.href='mainSession.jsp">메인페이지</button>
			</td>
		</tr>
	</table>

</div>
</body>
</html>