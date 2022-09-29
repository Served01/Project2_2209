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
String id = request.getParameter("mb_id");
	
	mbDAO mdao = new mbDAO();
	mbBean mBean = mdao.oneselectmember(id);
%>

<h2 align="center">회원정보 수정 화면 구현</h2>
<form action="mbUpdatePro.jsp" method="post"> 
<div align="center">
	<table border="1">
		<tr align="center">
			<td>아이디</td>
			<td><%=mBean.getMb_id() %></td>
		</tr>
		<tr align="center">
			<td>이름</td>
			<td><%=mBean.getMb_name() %></td>
		</tr>
		<tr align="center">
			<td>전자우편</td>
			<td>
				<input type="email" name="mb_email" value="<%=mBean.getMb_email() %>" required >
			</td>
		</tr>
		<tr align="center">
			<td>닉네임</td>
			<td><input type="text" name="mb_nick" value="<%=mBean.getMb_nick() %>" required ></td>
		</tr>
		<tr align="center">
			<td>비밀번호</td>
			<td>
				<input type="password" name="password" required >
			</td>
		</tr>
		<tr style="height: 40; ">
			<td colspan="2">
				<input type="hidden" name="mb_id" value="<%=mBean.getMb_id() %>">
				<input type="submit" value="회원정보수정">&nbsp;&nbsp;
				<input type="button" value="비밀번호 변경" onclick="location.href='mainSession.jsp?center=mbPassform.jsp&mb_id=<%=mBean.getMb_id() %>'"/>&nbsp;&nbsp;
				<input type="button" value="회원정보조회" onclick="location.href='mainSession.jsp?center=mbList.jsp'"/>&nbsp;&nbsp;
				<input type="button" value="마이페이지" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp&mb_id=<%=mBean.getMb_id() %>'" />
			</td>
		</tr>
	</table>
</div>
</form>
</body>
</html>