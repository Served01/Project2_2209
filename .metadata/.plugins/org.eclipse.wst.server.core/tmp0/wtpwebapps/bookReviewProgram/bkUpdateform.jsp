<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 수정 페이지</title>
</head>
<style>
table{
margin: auto;
}
</style>
<body>
<h2 align = "center">책 정보 수정 페이지</h2>

<form action="bkInsertPro.jsp" method="post" enctype="multipart/form-data">
<table border="1">
	<tr align = "center">
		<td>일련번호</td>
		<td>1111111111111</td>
	</tr>
	<tr align = "center">
		<td>제목</td>
		<td><input type="text" name="bk_title"/></td>
	</tr>
	<tr align = "center">
		<td>저자</td>
		<td><input type="text" name="bk_writer"/></td>
	</tr>
	<tr align = "center">
		<td>출판사</td>
		<td><input type="text" name="bk_publisher"/></td>
	</tr>
	<tr align = "center">
		<td>출간일</td>
		<td><input type="date" name="bk_pubdate"/></td>
	</tr>
	<tr align = "center">
		<td>이미지</td>
		<td>&nbsp;&nbsp;&nbsp;<input type="file" value="파일 선택" name="bk_image"/>
	</tr>
	<tr align = "center">
		<td>지역</td>
		<td>
		<input type="radio" name="bk_local" value="0"/>국내도서
		&nbsp;&nbsp;
		<input type="radio" name="bk_local" value="1"/>해외도서
		</td>
	</tr>
	<tr align="center">
		<td>장르</td>
		<td>
			<select name="bk_genre">
				<option value="0">--문학--</option>
				<option value="1">--역사--</option>
				<option value="2">--소설--</option>
				<option value="3">--만화--</option>
				<option value="4">--기타--</option>
			</select>
		</td>
	</tr>
	<tr align="center">
		<td>ebook 유무</td>
		<td>
			<input type="radio" name="bk_ebook" value="0"/> O
			<input type="radio" name="bk_ebook" value="1"/> X
		</td>
	</tr>
	<!-- 작성일 sysdate 처리 -->
	<tr align="center">
		<td>상세 내용</td>
		<td>
			<textarea rows="10" cols="74" name="bk_detail" style ="resize:none"></textarea></td>
	</tr>
	<tr align="center">
		<td colspan="2"> 				
			<input type="submit" value="수정"/>&nbsp;&nbsp;
			<button type="button">취소</button>
	</tr>
		
</table>
</form>

</body>
</html>