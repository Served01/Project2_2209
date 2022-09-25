<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page import="BKRV.book.bkBean"%>
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

<!-- bean이 없는 상태에서 가져올 때는 아래와 같이 이용 -->
<%
	int bk_number = 20220004; //Integer.parseInt(request.getParameter("bk_number"));
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(bk_number);
	
%>

<!-- 책 상세 정보 표시 -->
<table border="1">
	<tr align = "center">
		<td rowspan="6">이미지</td>
		<td>일련번호</td>
		<td><%=bBean.getBk_number()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>제목</td>
		<td><%=bBean.getBk_title()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>저자</td>
		<td><%=bBean.getBk_writer()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>출판사</td>
		<td><%=bBean.getBk_publisher()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>출간일</td>
		<td><%=bBean.getBk_pubdate()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>지역</td>
		<td><%=bBean.getBk_local()%></td>
	</tr>
	<tr align="center">
		<td rowspan="2">평점</td>
		<td>장르</td>
		<td><%=bBean.getBk_genre()%></td>
	</tr>
	<tr align="center">
		<!-- <td> rowspan=2 -->
		<td>ebook 유무</td>
		<td><%=bBean.getBk_ebook()%></td>
	</tr>
	<!-- 작성일 sysdate 처리 -->
	<tr align="center">
		<td colspan="3">
			<textarea rows="10" cols="74" name="bk_detail" style ="resize:none"><%=bBean.getBk_detail()%></textarea></td>
	</tr>
	<tr align="center">
		<td colspan="3"> 				
			<button type="button">수정</button>&nbsp;&nbsp;
			<button type="button">삭제</button>&nbsp;&nbsp;
			<button type="button">이전</button>
	</tr>	
</table>


<!-- 책 리뷰 목록 표시 -->


</body>
</html>