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
<title>메뉴용 책 리스트 조회 화면</title>
</head>

<style>
table{
margin: auto;
}
</style>

<body>

<!-- bean이 없는 상태에서 가져올 때는 아래와 같이 이용 -->
<%
	int bk_local = Integer.parseInt(request.getParameter("bk_local"));
	int bk_genre = Integer.parseInt(request.getParameter("bk_genre"));
	
	bkDAO bdao = new bkDAO();
	Vector<bkBean> bkVec = bdao.selectMenuBookList(bk_local,bk_genre);
	if(bkVec.size()==0){ %>
	<script>
		location.href="mainSession.jsp?center=noResultPro.jsp";
	</script>	
<%	} else{
	for(int i=0; i < bkVec.size(); i++){
		
		bkBean bBean = bkVec.get(i);
		int bk_number = bBean.getBk_number();
		
		rvDAO rdao = new rvDAO();
		double bk_score=rdao.getScore(bk_number);
	
%>

<!-- 책 일부 정보 표시 -->
<table border="1">
	<tr align = "center">
		<td rowspan="4"><img src="/image/<%=bBean.getBk_image()%>"></td>
		<td>책 일련번호</td>
		<td colspan="3"><%=bBean.getBk_number()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=4 -->
		<td>책 제목</td>
		<td><%=bBean.getBk_title()%></td>
		<td>책 저자</td>
		<td><%=bBean.getBk_writer()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=4-->
		<td>출판사</td>
		<td><%=bBean.getBk_publisher()%></td>
		<td>출판사</td>
		<td><%=bBean.getBk_publisher()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=4 -->
		<td>평점</td>
		<td colspan="3">
		<%if(bk_score==0){%>
			등록된 평점이 없습니다.
		<%
		} else { %>
			<%=bk_score%>점
		<%}%></td>
	</tr>
</table>
<%}} %>

</body>
</html>