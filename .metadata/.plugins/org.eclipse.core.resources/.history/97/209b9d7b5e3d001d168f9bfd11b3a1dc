<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="BKRV.book.bkDAO" %>
<%@ page import="BKRV.book.bkBean" %>
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

	int rv_bknumber= 20220001; //Integer.parseInt(request.getParameter("bk_number")); 
	String rv_id = "hyun"; //request.getParameter("mb_id");
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(rv_bknumber);
	
%>

<h2 align="center">리뷰 작성 페이지</h2>

<form action="rvInsertPro.jsp" method="post">
	<table border="1">
		<tr align="center">
			<td>책 제목</td>
			<td><%=bBean.getBk_title() %></td>
		</tr>
		<tr align="center">
			<td>리뷰 작성자</td>
			<td><%=rv_id %></td>
		</tr>
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
			<textarea rows="10" cols="67" name="rv_content"></textarea>
			</td>
		</tr>
		
		<tr align="center">
			<td colspan="2">
				<input type="hidden" name="rv_bknumber" value=<%=rv_bknumber %> />
				<input type="hidden" name="rv_id" value=<%=rv_id %> />
				<input type="submit" value="등록"/>&nbsp;&nbsp;
				<input type="button" value="취소"/>&nbsp;&nbsp;
				<input type="button" value="뒤로가기" onclick="location.href='history.back()'" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>