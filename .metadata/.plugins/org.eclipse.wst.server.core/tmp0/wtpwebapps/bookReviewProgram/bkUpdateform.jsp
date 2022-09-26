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
<title>책 정보 수정</title>
</head>

<style>
table{
margin: auto;
}
</style>

<body>

<%
	int bk_number = Integer.parseInt(request.getParameter("bk_number"));
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(bk_number);
	
%>
<h2 align = "center">책 정보 수정 페이지</h2>

<form action="bkUpdatePro.jsp" method="post">
<table border="1">
	<tr align = "center">
		<td>일련번호</td>
		<td><%=bBean.getBk_number() %></td>
	</tr>
	<tr align = "center">
		<td>제목</td>
		<td><input type="text" name="bk_title" value=<%=bBean.getBk_title() %> /></td>
	</tr>
	<tr align = "center">
		<td>저자</td>
		<td><input type="text" name="bk_writer" value=<%=bBean.getBk_writer() %> /></td>
	</tr>
	<tr align = "center">
		<td>출판사</td>
		<td><input type="text" name="bk_publisher" value=<%=bBean.getBk_publisher() %> /></td>
	</tr>
	<tr align = "center">
		<td>출간일</td>
		<td><input type="date" name="bk_pubdate" value=<%=bBean.getBk_pubdate() %> /></td>
	</tr>
	<tr align = "center">
		<td>이미지</td>
		<td><button type="button">이미지 수정</button></td>
	</tr>
	<tr align = "center">
		<td>지역</td>
		<td>
		<% 
		
		if(bBean.getBk_local()==0){ %>
		<input type="radio" name="bk_local" value="0" checked="checked" />국내도서
		&nbsp;&nbsp;
		<input type="radio" name="bk_local" value="1" />해외도서
		<%} 
		
		else if(bBean.getBk_local()==1){ %>
		<input type="radio" name="bk_local" value="0" />국내도서
		&nbsp;&nbsp;
		<input type="radio" name="bk_local" value="1" checked="checked" />해외도서
		<%}; 
		
		%>
		</td>
	</tr>
	<tr align="center">
		<td>장르</td>
		<td>
		<%if(bBean.getBk_genre()==0){%>
			<select name="bk_genre">
				<option value="0" selected="selected">--문학--</option>
				<option value="1">--역사--</option>
				<option value="2">--소설--</option>
				<option value="3">--만화--</option>
				<option value="4">--기타--</option>
			</select>
		<%}
		
		else if(bBean.getBk_genre()==1){%>
			<select name="bk_genre">
				<option value="0">--문학--</option>
				<option value="1" selected="selected">--역사--</option>
				<option value="2">--소설--</option>
				<option value="3">--만화--</option>
				<option value="4">--기타--</option>
			</select>
		<%} 
		else if(bBean.getBk_genre()==2){%>
			<select name="bk_genre">
				<option value="0">--문학--</option>
				<option value="1">--역사--</option>
				<option value="2" selected="selected">--소설--</option>
				<option value="3">--만화--</option>
				<option value="4">--기타--</option>
			</select>
		<%} 
		else if(bBean.getBk_genre()==3){%>
			<select name="bk_genre">
				<option value="0">--문학--</option>
				<option value="1">--역사--</option>
				<option value="2">--소설--</option>
				<option value="3" selected="selected">--만화--</option>
				<option value="4">--기타--</option>
			</select>
		<%}
		else if(bBean.getBk_genre()==4){%>
			<select name="bk_genre">
				<option value="0">--문학--</option>
				<option value="1">--역사--</option>
				<option value="2">--소설--</option>
				<option value="3">--만화--</option>
				<option value="4" selected="selected">--기타--</option>
			</select>
		<%} 
		%>
		</td>
	</tr>
	<tr align="center">
		<td>ebook 유무</td>
		<td>
		<%if(bBean.getBk_ebook()==0){ %>
			<input type="radio" name="bk_ebook" value="0" checked="checked" /> O
			<input type="radio" name="bk_ebook" value="1"/> X
		<%}
		else if(bBean.getBk_ebook()==1){%>
			<input type="radio" name="bk_ebook" value="0"/> O
			<input type="radio" name="bk_ebook" value="1" checked="checked" /> X
		<%} %>
		</td>
	</tr>
	<!-- 작성일 sysdate 처리 -->
	<tr align="center">
		<td>상세 내용</td>
		<td>
			<textarea rows="10" cols="74" name="bk_detail" style ="resize:none"><%=bBean.getBk_detail()%></textarea></td>
	</tr>
	<tr align="center">
		<td colspan="2"> 				
			<input type="submit" value="수정"/>&nbsp;&nbsp;
			<button type="button" onclick="javascript:history.go(-1)">취소</button>
			<input type="hidden" name="bk_number" value=<%=bBean.getBk_number()%> />
	</tr>
		
</table>
</form>

</body>
</html>