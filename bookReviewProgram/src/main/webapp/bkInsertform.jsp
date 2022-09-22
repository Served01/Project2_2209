<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 입력 페이지</title>
</head>
<style>
table{
margin: auto;
}
</style>
<body>
<h2 align = "center">책 정보 입력 페이지</h2>

<form action="bkInsertPro.jsp" method="post">
<table border="1">
	<tr align = "center">
		<td>일련번호</td>
		<td><input type="text" name="bk_number">
			&nbsp; &nbsp;
			<button type="button">중복확인</button></td>
	</tr>
	<tr align = "center">
		<td>책 제목</td>
		<td><input type="text" name="bk_title"></td>
	</tr>
	<tr align = "center">
		<td>책 저자</td>
		<td><input type="text" name="bk_writer"></td>
	</tr>
	<tr align = "center">
		<td>책 출판사</td>
		<td><input type="text" name="bk_publisher"></td>
	</tr>
	<tr align = "center">
		<td>책 출간일</td>
		<td><input type="text" name="bk_pubdate"></td>
	</tr>
	<tr align = "center">
		<td>책 이미지</td>
		<td><input type="text" name="bk_image"></td>
	</tr>
	<tr align = "center">
		<td>지역</td>
		<td>
		<input type="radio" name="bk_local" value="0"/>국내도서
		&nbsp;&nbsp;&nbsp;
		<input type="radio" name="bk_local" value="1"/>해외도서
		</td>
	</tr>
	
		
		
	
		
</table>
</form>

</body>
</html>