<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 데이터 입력 페이지</title>
</head>

<style>
table{
margin: auto;
}
</style>

<body>

<% 
	int bk_number= 20220002; //Integer.parseInt(request.getParameter("bk_number")); 
	String mb_id = "hyun2"; //request.getParameter("mb_id");
%>

<h2 align="center">리뷰 작성 페이지</h2>

<form action="rvInsertPro.jsp" method="post">
	<table border="1">
		<tr align="center">
			<td>평점</td>
			<td>
			<input type="radio" name="rv_score" value=1 />1점&nbsp;&nbsp;
			<input type="radio" name="rv_score" value=2 />2점&nbsp;&nbsp;
			<input type="radio" name="rv_score" value=3 />3점&nbsp;&nbsp;
			<input type="radio" name="rv_score" value=4 />4점&nbsp;&nbsp;
			<input type="radio" name="rv_score" value=5 />5점
			</td>
		</tr>
		<tr align="center">
			<td>내용</td>
			<td>
			<textarea rows="10" cols="67" name="content"></textarea>
			</td>
		</tr>
		
		<tr height="40" align="center">
			<td colspan="2">
				<input type="hidden" name="rv_bknumber" value=<%=bk_number %> />
				<input type="hidden" name="rv_id" value=<%=mb_id %> />
				<input type="submit" value="등록"/>&nbsp;&nbsp;
				<input type="button" value="취소"/>&nbsp;&nbsp;
				<input type="button" value="뒤로가기" onclick="location.href='history.back()'" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>