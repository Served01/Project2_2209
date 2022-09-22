<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.ezen.boardDAO" %>  
<%@ page import="kr.co.ezen.boardBean" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 작성</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int ref = Integer.parseInt(request.getParameter("ref"));
	int re_step = Integer.parseInt(request.getParameter("re_step"));
	int re_level = Integer.parseInt(request.getParameter("re_level"));
%>

<h2 align="center">게시글 상세 보기 화면 구현</h2>
		
	<div align="center">
		<form action="boardRewriteformPro.jsp">
			<table border="1" style="width:100%; text-align="center";>
				<tr style="height:40; background:yellow;">
					<td width="100">작성자</td>
					<td><input type="text" name="writer"></td>
					<td width="100">제목</td>
					<td><input type="text" name="subject" value=[reply]:></td>
					</tr>
				<tr style="height:40; background:yellow;">
					<td width="100">전자우편</td>
					<td><input type="text" name="email"></td>
					<td width="100">비밀번호</td>
					<td><input type="password" name="password"></td>
					</tr>
				<tr style="height:40; background:yellow;">
					<td width="100">내용
					<td colspan="3">
						<textarea rows="10" cols="87" name="content"></textarea></td>
					</tr>
					<tr style="height:50;">
						<td colspan="4">
							<input type="hidden" name="ref" value="<%=ref %>">
							<input type="hidden" name="re_step" value="<%=re_step %>">
							<input type="hidden" name="re_level" value="<%=re_level %>">
							<input type="submit" value="댓글쓰기">&nbsp;&nbsp;
							<input type="reset" value="취소">&nbsp;&nbsp;
							<input type="button" onclick="location.href='boardList.jsp'" value="목록보기"></button>&nbsp;&nbsp;
							<input type="button" onclick="location.href='memberJoinform.jsp'" value="회원가입"></button>
						</td>
					</tr>
			</table>
		</form>
	</div>
		
</body>
</html>