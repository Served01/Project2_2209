<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page import="BKRV.book.bkBean"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>책 정보 수정</title>
</head>
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

	int bk_number = Integer.parseInt(request.getParameter("bk_number"));
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(bk_number);
	
%>

<h2 align = "center">책 정보 수정 페이지</h2>

<form action="bkUpdatePro.jsp" method="post" enctype="multipart/form-data" class = "update">
<table border="1" class="update">
	<tr align = "center">
		<td><h4>일련번호</h4></td>
		<td><%=bBean.getBk_number() %></td>
	</tr>
	<tr align = "center">
		<td><h4>제목</h4></td>
		<td><input type="text" name="bk_title" value=<%=bBean.getBk_title() %> /></td>
	</tr>
	<tr align = "center">
		<td><h4>저자</h4></td>
		<td><input type="text" name="bk_writer" value=<%=bBean.getBk_writer() %> /></td>
	</tr>
	<tr align = "center">
		<td><h4>출판사</h4></td>
		<td><input type="text" name="bk_publisher" value=<%=bBean.getBk_publisher() %> /></td>
	</tr>
	<tr align = "center">
		<td><h4>출간일</h4></td>
		<td><input type="date" name="bk_pubdate" value=<%=bBean.getBk_pubdate() %> /></td>
	</tr>
	<tr align = "center">
		<td>이미지</td>
		<td>&nbsp;&nbsp;&nbsp;<input type="file" value="파일 선택" name="bk_image"/></td>
	</tr>
	<tr align = "center">
		<td><h4>지역</h4></td>
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
		<td><h4>장르</h4></td>
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
		<td><h4>ebook유무</h4></td>
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
		<td><h4>상세 내용</h4></td>
		<td>
			<textarea rows="10" cols="74" name="bk_detail" style ="resize:none"><%=bBean.getBk_detail()%></textarea></td>
	</tr>
	<tr align="center">
		<td colspan="2"> 				
			<input type="submit" class= "button" value="수정"/>&nbsp;&nbsp;
			<button type="button" class= "button"onclick="javascript:history.go(-1)">취소</button>
			<input type="hidden" name="bk_number" value=<%=bBean.getBk_number()%> />
	</tr>
		
</table>
</form>
<%} %>
</body>
</html>