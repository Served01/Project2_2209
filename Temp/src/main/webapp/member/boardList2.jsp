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
<title>글쓰기</title>
</head>
<body>
<%
	boardDAO bdao = new boardDAO();	
	Vector<boardBean> vec = bdao.allselectBoard();
	
%>
<h2 align="center">게시판 목록 보기 화면</h2>
<table border="1" align="center" style= width: 100%">
	<tr align="center" style="height: 40; background: yellow;">
		<td width="100">번호</td>
		<td width="120">제목</td>
		<td width="120">작성자</td>
		<td width="120">전자우편</td>
		<td width="120">작성일자</td>
		<td width="100">조회수</td>
		<td width="120">글내용</td>
	</tr>

	<%
		for(int i=0; i < vec.size(); i++){
			
			boardBean bBean = vec.get(i);		
	%>
	<tr height="40" align="center">
		<td><%=bBean.getNum() %></td>
		<td>
			<a href="boardDetail.jsp?num=<%=bBean.getNum() %>" style="text-decoration:none">
			<%
			//들여쓰기
			if(bBean.getRe_step() > 1){
				for(int k=0; k < (bBean.getRe_step() - 1) * 3; k++){
					%>
			<%
				}
			}
			%>
			<%=bBean.getSubject() %></a></td>
		<td><%=bBean.getWriter() %></td>
		<td><%=bBean.getEmail() %></td>
		<td><%=bBean.getReg_date() %></td>
		<td><%=bBean.getReadCount() %></td>
		<td><%=bBean.getContent() %></td>
	</tr>
	<%} %>	
</table>
	<table align="center">
		<tr>
			<td>
				<input type="button" value="글쓰기" onclick="location.href='boardwriteform.jsp'"/>&nbsp;&nbsp;				
				<input type="button" value="회원목록보기" onclick="location.href='memberList.jsp'"/>&nbsp;&nbsp;				
				<button onclick="location.href='mainSession.jsp'">mainSession</button>
		</tr>
	</table>
</body>
</html>