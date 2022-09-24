<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 화면 구현</title>
</head>
<body>
<%
String mb_id = request.getParameter("mb_id");
	
	mbDAO mdao = new mbDAO();
	mbBean Bean = mdao.oneselectmember(mb_id);
%>

<h2 align="center">회원정보 수정 화면 구현</h2>
<form action="mbUpdatePro.jsp" method="post"> 
<div align="center">
	<table border="1" style="text-align: center; width: 100%;">
		<tr align="center" style="height: 40; background: pink;">
			<td width="100">아이디</td>
			<td><%=Bean.getMb_id() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">이&nbsp;&nbsp;&nbsp;름</td>
			<td><%=Bean.getMb_name() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">전자우편</td>
			<td>
				<input type="email" name="email" value="<%=Bean.getMb_email() %>">
			</td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">닉네임</td>
			<td><input type="text" name="nick" values="<%=Bean.getMb_nick() %>"></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">비밀번호</td>
			<td>
				<input type="password" name="password">
			</td>
		</tr>
		<tr style="height: 40; ">
			<td colspan="2">
				<input type="hidden" name="id" value="<%=Bean.getMb_id() %>">
				<input type="submit" value="회원정보수정">&nbsp;&nbsp;
				<input type="button" value="회원정보조회" onclick="location.href='mbList.jsp?'"/>&nbsp;&nbsp;
				<input type="button" value="회원가입" onclick="location.href='memberInsertform.jsp?'"/>
			</td>
		</tr>
	</table>
</div>
</form>
</body>
</html>