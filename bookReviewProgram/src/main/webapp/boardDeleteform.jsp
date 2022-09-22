<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	rvDAO rdao = new rvDAO();
	rvBean rBean = rdao.updateoneselectboard(num);
%>
	<h2 align="center">게시판 정보 수정 화면</h2>
<div align="center">
	<form action="boardDeleteformPro.jsp" method="post"> 
		<table border="1" style="width: 800px; text-align: center;">
			<tr style="height: 50px; background: yellow;">
				<td width="80">번호</td>
				<td width="120"><%=rBean.getNum() %></td>		
				<td width="120">작성자</td>
				<td><%=rBean.getWriter() %></td>			
			</tr>	
			<tr style="height: 50px; background: yellow;">							
				<td width="80">비밀번호</td>
				<td width="120"><input type="password" name="password"></td>
				<td width="120">내용</td>
				<td><%=rBean.getContent()%></td>				
			</tr>
			<tr style="height: 50px;">
				<td colspan="4">
					<input type="hidden" name="num" value="<%=bBean.getNum() %>">
					<input type="submit" value="삭제완료">&nbsp;&nbsp;
					<input type="button" onclick="location.href='boardList.jsp'" value="글목록보기"></button>&nbsp;&nbsp;
					<input type="button" onclick="location.href='memberJoinform.jsp'" value="회원가입"></button>
				</td>
			</tr>			
		</table>	
	</form>
</div>
</body>
</html>