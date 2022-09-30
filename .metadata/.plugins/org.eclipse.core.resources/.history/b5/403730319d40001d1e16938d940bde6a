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
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 리뷰 조회</title>
</head>

<style>
table{
margin: auto;
}
</style>

<body>
<%	String id = (String)session.getAttribute("id");

	if(!id.equals("admin")){
%>
	<script>
	alert("권한이 없거나 세션이 만료되었습니다.");
	history.go(-1);
	</script>
<% 	
   } else {
%>
   
<!-- 책 리뷰 목록 표시 -->

<h2 align="center">전체 리뷰 목록</h2>

<input type="button" value="마이페이지" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp&mb_id=<%=request.getParameter("mb_id") %>'" />&nbsp;&nbsp;
<button onclick="location.href='mainSession.jsp'">메인 페이지</button>
<br><br>

<%

	rvDAO rdao = new rvDAO();
	Vector<rvBean> rvVec = rdao.allselectReview();
	
	if(rvVec.size()==0){
%>
		<h2>리뷰 목록이 존재하지 않습니다.</h2>
<%	}else{
	
	for(int i=0; i < rvVec.size(); i++){
		
		rvBean rbean = rvVec.get(i);
		int bk_number = rbean.getRv_bknumber();
		
		bkDAO bdao = new bkDAO();
		String bk_title = bdao.selecttitleBook(bk_number);
		
%>
<table border="1">
	<tr align="center">
		<td>아이디:&nbsp;<%=rbean.getRv_id() %></td>
		<td>평점:&nbsp;<%=rbean.getRv_score() %></td>
		<td>
		<button type="button" onclick="location.href='mainSession.jsp?center=bkUpdateform.jsp&bk_number=<%=bk_number%>'">수정</button>&nbsp;&nbsp;
		<button type="button" onclick="javascript:deleteConfirm()">삭제</button>&nbsp;&nbsp;
			<script>
				function deleteConfirm(){
					var rv_number = <%=rbean.getRv_number()%>;
					var isDelete = confirm("정말로 삭제하시겠습니까?");
					if(isDelete){
						location.href = "rvDeletePro.jsp?rv_number="+rv_number;
					}
				}
			</script>
		</td>
	</tr>
	<tr align="center">
		<td colspan="2">책 제목:&nbsp;<%=bk_title %></td>
		<td>책 일련번호: &nbsp;<%=bk_number %></td>
	</tr>
	<tr>
		<td colspan="3">
		등록날짜:&nbsp;<%=rbean.getRv_date() %>
		</td>
	</tr>
	<tr>
		<td colspan="3">
		<%=rbean.getRv_content()%>
		</td>
	</tr>

<%} }}%>
</table>
</body>
</html>