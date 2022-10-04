<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>회원가입 페이지</title>
</head>
<body>

<h2 align = "center">회원 가입 페이지</h2>

<form action = "mainSession.jsp" method = "post">
	<table border = "1" class = "update">
		<tr align = "center">
			<td>ID</td>
			<td><input type="text" name="mb_id" placeholder="id입력" required />
				&nbsp;&nbsp;
				<button type="submit" class = "button">중복확인</button></td>
		</tr>
		<tr align = "center">
			<td>PW</td>
			<td><input type = "password" name = "mb_pw" placeholder="pw입력"  /></td>
		</tr>
		<tr align = "center">
			<td>비밀번호 확인</td>
			<td><input type = "password" name = "mb_pw2" placeholder="pw입력" /></td>
		</tr>
		<tr align = "center">
			<td>이름</td>
			<td><input type = "text" name = "mb_name" placeholder="이름입력" /></td>
		</tr>
		<tr align = "center">
			<td>이메일</td>
			<td><input type = "email" name = "mb_email" placeholder="이메일입력" /></td>
		</tr>
		<tr align = "center">
			<td>전화번호</td>
			<td><input type = "text" name = "mb_tel" placeholder="전화번호입력" ></td>
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
				<button type="button" class = "button" onclick="javascript:alert('아이디 중복확인을 해주십시오.')">회원가입</button>&nbsp;&nbsp;
				<button type="button" class = "button" onclick="location.href='mainSession.jsp'">취소</button>
				<input type="hidden" name="center" value="mbInsertform2.jsp"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>