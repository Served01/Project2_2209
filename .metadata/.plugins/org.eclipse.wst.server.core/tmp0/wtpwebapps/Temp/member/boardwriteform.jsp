<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="kr.co.ezen.boardDAO" %>
<%@ page import="kr.co.ezen.boardBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>

	<h2>글쓰기</h2>
<%-- <%


	int num = Integer.parseInt(request.getParameter("num"));
	int ref = Integer.parseInt(request.getParameter("ref"));
	int re_step = Integer.parseInt(request.getParameter("re_step"));
	int re_level = Integer.parseInt(request.getParameter("re_level"));

%> --%>
<form action="boardwriteformPro.jsp" method="post">
	<table border="1" align="center" width"600" bgccolor="yellow">
		<tr height="40" align="center">
			<td width="150">작성자</td>
			<td width="250"><input type="text" name="writer" size="67" placeholder="홍길동"></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">전자우편</td>
			<td width="250"><input type="text" name="email" size="67" placeholder="id@domain.com"></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">주제</td>
			<td width="250"><input type="text" name="subject" size="67" placeholder="주제입력"></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">비밀번호</td>
			<td width="250"><input type="password" name="password" size="67" placeholder="8~15자리"></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">내용</td>
			<td width="350">
			<textarea rows="10" cols="67" name="content"></textarea>
		</tr>
		
		<tr height="40" align="center">
			<td colspan="2">
			<input type="button" value="회원목록보기" onclick="location.href='memberList.jsp'"/>&nbsp;&nbsp;
			<input type="submit" value="글쓰기"/>&nbsp;&nbsp;
			<input type="reset" value="취소"/>&nbsp;&nbsp;
		<input type="button" value="글목록보기" onclick="location.href='boardList.jsp'"/>&nbsp;&nbsp;
		<input type="button" value="회원목록보기" onclick="location.href='memberList.jsp'"/>
		</td></tr>
	</table>
</form>
</body>
</html>