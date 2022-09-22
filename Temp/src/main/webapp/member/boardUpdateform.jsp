<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="kr.co.ezen.boardDAO" %>
<%@ page import="kr.co.ezen.boardBean" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	boardDAO bdao = new boardDAO();
	boardBean bBean = bdao.updateoneselectboard(num);
%>
	<h2 align="center">게시판 정보 수정 화면</h2>
<div align="center">
	<form action="boardUpdateformPro.jsp" method="post"> 
		<table border="1" style="width: 800px; text-align: center;">
			<tr style="height: 50px; background: yellow;">
				<td width="80">번호</td>
				<td><%=bBean.getNum() %></td>		
				<td width="120">작성자</td>
				<td><%=bBean.getWriter() %></td>			
			</tr>	
			<tr style="height: 50px; background: yellow;">							
				<td width="80">비밀번호</td>
				<td><input type="password" name="password"></td>
				<td width="120">내용</td>
				<td colspan="3">
					<textarea rows="10" cols="90" name="content"><%=bBean.getContent()%></textarea></td>				
			</tr>
			<tr style="height: 50px;">
				<td colspan="4">
					<input type="hidden" name="num" value="<%=bBean.getNum() %>">
					<input type="submit" value="수정완료">&nbsp;&nbsp;
					<input type="reset" value="수정취소">&nbsp;&nbsp;
					<input type="button" onclick="location.href='boardList.jsp'" value="글목록보기"></button>&nbsp;&nbsp;
					<input type="button" onclick="location.href='memberJoinform.jsp'" value="회원가입"></button>
				</td>
			</tr>			
		</table>	
	</form>
</div>
</body>
</html>