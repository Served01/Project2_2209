<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<h2 align = "center">회원가입 페이지</h2>
<form action = "mbinsertformPro.jsp" method = "post" align = "center">
	<table border = "1" align = "center" width = "650">
		<tr height = "40" align = "center">
			<td width = "150">ID</td>
			<td width = "250"><input type = "text" name = "id" size = "67" placeholder="id입력"/></td>
		</tr>
		<tr height = "40" align = "center">
			<td width = "150">PW</td>
			<td width = "250"><input type = "text" name = "pw1" size = "67" placeholder="pw입력"/></td>
		</tr>
		<tr height = "40" align = "center">
			<td width = "150">비밀번호 확인</td>
			<td width = "250"><input type = "text" name = "pw2" size = "67" placeholder="pw입력"/></td>
		</tr>
		<tr height = "40" align = "center">
			<td width = "150">이름</td>
			<td width = "250"><input type = "text" name = "name" size = "67" placeholder="이름입력"/></td>
		</tr>
		<tr height = "40" align = "center">
			<td width = "150">닉네임</td>
			<td width = "250"><input type = "text" name = "nick" size = "67" placeholder="닉네임입력"/></td>
		</tr>
		<tr height = "40" align = "center">
			<td width = "150">이메일</td>
			<td width = "250"><input type = "text" name = "email" size = "67" placeholder="이메일입력"/></td>
		</tr>
		<tr height = "40" align = "center">
			<td width = "150">전화번호</td>
			<td width = "250"><input type = "text" name = "tel" size = "67" placeholder="전화번호입력"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">성별</td>
			<td width="250">
				<input type="radio" name="hobby" value="남자"/>남자
				<input type="radio" name="hobby" value="여자"/>여자				
			</td>
		</tr>
		<tr height = "40" align = "center">
			<td colspan = "2">				
				<input type = "submit" value = "회원가입"/>&nbsp;&nbsp;
				<input type = "reset" value = "취소"/>
		</tr>
	</table>
</form>
</body>
</html>