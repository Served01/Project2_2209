<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세 정보 조회 화면</title>
</head>
<style>
table{
margin: auto;
}
</style>
<body>
<%
	
%>
<table border="1">
	<tr align = "center">
		<td rowspan="6">이미지</td>
		<td>일련번호</td>
		<td>11111111111111111111</td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>제목</td>
		<td></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>저자</td>
		<td></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>출판사</td>
		<td></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>출간일</td>
		<td></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>지역</td>
		<td></td>
	</tr>
	<tr align="center">
		<td rowspan="2">평점</td>
		<td>장르</td>
		<td></td>
	</tr>
	<tr align="center">
		<!-- <td> rowspan=2 -->
		<td>ebook 유무</td>
		<td></td>
	</tr>
	<!-- 작성일 sysdate 처리 -->
	<tr align="center">
		<td colspan="3">
			<textarea rows="10" cols="74" name="bk_detail" style ="resize:none">상세설명</textarea></td>
	</tr>
	<tr align="center">
		<td colspan="3"> 				
			<button type="button">수정</button>&nbsp;&nbsp;
			<button type="button">삭제</button>&nbsp;&nbsp;
			<button type="button">이전</button>
	</tr>
		
</table>
</body>
</html>