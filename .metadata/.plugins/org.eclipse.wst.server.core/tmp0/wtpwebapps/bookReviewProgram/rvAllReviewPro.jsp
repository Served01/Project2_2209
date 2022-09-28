<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page import="BKRV.book.bkBean"%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="java.util.Vector" %>  
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

<!-- 책 리뷰 목록 표시 -->

<h2 align="center">전체 리뷰 목록</h2>

<input type="button" value="마이페이지" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp&mb_id=<%=request.getParameter("mb_id") %>'" />&nbsp;&nbsp;
<button onclick="location.href='mainSession.jsp'">메인 페이지</button>
<br><br>

<%

	rvDAO rdao = new rvDAO();
	Vector<rvBean> rvVec = rdao.allselectReview();
	
	for(int i=0; i < rvVec.size(); i++){
		
		rvBean rbean = rvVec.get(i);
		int bk_number = rbean.getRv_bknumber();
		
		bkDAO bdao = new bkDAO();
		String bk_title = bdao.selecttitleBook(bk_number);
		
%>
<table border="1">
	<tr align="center">
		<td>닉네임:&nbsp;<%=rbean.getRv_id() %></td>
		<td>평점:&nbsp;<%=rbean.getRv_score() %></td>
		<td>
		<button type="button">수정</button>
		<button type="button">삭제</button>
		</td>
	</tr>
	<tr align="center">
		<td colspan="2">책 제목:&nbsp;<%=bk_title %></td>
		<td>책 일련번호: &nbsp;<%=bk_number %></td>
	</tr>
	<tr>
		<td colspan="3">
		<%=rbean.getRv_content()%>
		</td>
	</tr>

<%} %>
</table>
</body>
</html>