<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>

	<h2>글쓰기</h2>

<%-- 
<%
	회원 ID, 책 번호 받기
	 
	int Rv_bknumber = Integer.parseInt(request.getParameter("Rv_bknumber"));
	String Rv_id = request.getParameter("Rv_id");
	
	rvDAO rdao = new rvDAO();
	rvBean rBean = rdao.selectoneselectboard(Rv_number, Rv_bknumber, Rv_id);
%>

 --%>


<form action="rvInsertPro.jsp" method="post">
	<table border="1" align="center" width"600" bgccolor="yellow">
		
		<%--
		<tr height="40" align="center">
			<td width="150">작성자</td>
			<td width="250"><%=rBean.getNick() %></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">전자우편</td>
			<td width="250"><input type="text" name="email" size="67" disabled="disabled"></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">주제</td>
			<td width="250"><input type="text" name="subject" size="67" placeholder="주제입력"></td>
		</tr>
		--%>
		
		<tr height="40" align="center">
			<td width="150">평점</td>
			<td width="250">
			1점<input type="radio" name="score">
			2점<input type="radio" name="score">
			3점<input type="radio" name="score">
			4점<input type="radio" name="score">
			5점<input type="radio" name="score"></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">내용</td>
			<td width="350">
			<textarea rows="10" cols="67" name="content"></textarea>
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