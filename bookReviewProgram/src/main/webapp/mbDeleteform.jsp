<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 삭제 화면 구현</title>
</head>
<body>
<h2 align="center">회원정보 삭제 화면</h2>
	<div align="center"> 
	<form action="mbDeletePro.jsp" method="post">
	<table border="1">
		<tr align="center">
			<td>아이디</td>
			<td><%=request.getParameter("mb_id") %></td> 
		</tr>				
		<tr align="center">
			<td>비밀번호</td>
			<td>
				<input type="password" name="password">
			</td>
		</tr>		
		<tr>
			<td colspan="2"> 
				<input type="hidden" name="mb_id" value="<%=request.getParameter("mb_id") %>">
				<input type="submit" value="회원정보삭제">&nbsp;&nbsp;		
				<input type="button" value="회원목록보기" onclick="location.href='mbList.jsp'"/>&nbsp;&nbsp;
				<input type="button" value="회원가입" onclick="location.href='mbInsertform.jsp'"/>
			</td>	
		</tr>		
	</table>	
	</form>
</div>
</body>
</html>