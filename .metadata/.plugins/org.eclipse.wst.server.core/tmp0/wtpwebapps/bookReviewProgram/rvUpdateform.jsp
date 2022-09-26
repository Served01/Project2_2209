<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="BKRV.book.bkDAO" %>
<%@ page import="BKRV.book.bkBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정 페이지</title>
</head>

<style>
table{
margin: auto;
}
</style>

<body>

<%

	int rv_number= 1; //Integer.parseInt(request.getParameter("rv_number"));
	int rv_bknumber= 20220001; //Integer.parseInt(request.getParameter("bk_number")); 
	String rv_id = "hyun1"; //request.getParameter("mb_id");
	
	rvDAO rdao = new rvDAO();
	rvBean rbean = rdao.updateoneselectboard(rv_number, rv_bknumber, rv_id);
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(rv_bknumber);
	
%>

	<h2 align="center">리뷰 수정 페이지</h2>

<form action="rvUpdatePro.jsp" method="post">
	<table border="1">
		<tr align="center">
			<td>책 제목</td>
			<td><%=bBean.getBk_title() %></td>
		</tr>
		<tr align="center">
			<td>리뷰 작성자</td>
			<td><%=rbean.getRv_id() %></td>
		</tr>
		<tr align="center">
			<td>평점</td>
			<td>
			if(rb)
			1점<input type="radio" name="score">
			2점<input type="radio" name="score">
			3점<input type="radio" name="score">
			4점<input type="radio" name="score">
			5점<input type="radio" name="score">
			</td>
		</tr>
		<tr height="40" align="center">
			<td width="150">내용</td>
			<td width="350">
			<textarea rows="10" cols="67" name="content"><%-- <%=rBean.getRv_content()%> --%></textarea>
		</tr>
		
		<tr height="40" align="center">
			<td colspan="2">
			<input type="button" value="회원목록보기" onclick="location.href='memberList.jsp'"/>&nbsp;&nbsp;
			<input type="submit" value="확인"/>&nbsp;&nbsp;
			<input type="reset" value="취소"/>&nbsp;&nbsp;
		<input type="button" value="글목록보기" onclick="location.href='boardList.jsp'"/>&nbsp;&nbsp;
		<input type="button" value="회원목록보기" onclick="location.href='memberList.jsp'"/>
		<input type="button" value="뒤로가기" onclick="location.href='history.back()'">
		
		</td></tr>
	</table>
</form>
</body>
</html>