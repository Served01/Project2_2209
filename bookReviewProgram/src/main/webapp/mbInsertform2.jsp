<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO"%>

<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>회원가입 페이지</title>
</head>
<body>
<%
   
	mbDAO mdao = new mbDAO();
	String mb_id = request.getParameter("mb_id");
	int check = mdao.duplecateMbid(mb_id);
	if(check==1){
%>
	<script>
	alert("이미 존재하는 아이디입니다.");
	history.go(-1);
	</script>
<% }else{ %>
	<script>
	alert("사용 가능한 아이디입니다.");
	</script>

<h2 align = "center">회원 가입 페이지</h2>

<form action = "mbInsertPro.jsp" method = "post">
	<table border = "1" class = "update">
		<tr align = "center">
		
			<td>ID</td>
			<td><input type="text" name="mb_id" value="<%=mb_id %>" disabled />
				&nbsp; &nbsp;
				<button type="submit" class = "button">중복확인</button></td>
		</tr>
		<tr align = "center">
			<td>PW</td>
			<td><input type = "password" name = "mb_pw" placeholder="pw입력" required /></td>
		</tr>
		<tr align = "center">
			<td>비밀번호 확인</td>
			<td><input type = "password" name = "mb_pw2" placeholder="pw입력" required /></td>
		</tr>
		<tr align = "center">
			<td>이름</td>
			<td><input type = "text" name = "mb_name" placeholder="이름입력" required /></td>
		</tr>
		<tr align = "center">
			<td>이메일</td>
			<td><input type = "email" name = "mb_email" placeholder="이메일입력" required /></td>
		</tr>
		<tr align = "center">
			<td>전화번호</td>
			<td><input type = "text" name = "mb_tel" placeholder="전화번호입력" required /></td>
		</tr>
		<tr align="center">
			<td>성별</td>
			<td>
				<input type="radio" name="mb_gender" value="1" checked/>남자
				<input type="radio" name="mb_gender" value="2"/>여자				
			</td>
		</tr>
		<tr height = "40" align = "center">
			<td colspan = "2">				
				<button type="submit" class = "button">회원가입</button>&nbsp;&nbsp;
				<button type="button" class = "button" onclick="location.href='mainSession.jsp'">취소</button>
				<input type="hidden" name="mb_id" value=<%=mb_id %> />
			</tr>
	</table>
</form>
<%} %>
</body>
</html>