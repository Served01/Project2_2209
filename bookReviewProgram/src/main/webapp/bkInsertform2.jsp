<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page session = "true" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>책 정보 입력 페이지</title>
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

	bkDAO bdao = new bkDAO();
	String bk_number2 = request.getParameter("bk_number");
	int bk_number = Integer.parseInt(bk_number2);
	int check = bdao.duplecateBKnum(bk_number);
	if(check==1){
%>
	<script>
	alert("이미 존재하는 일련번호입니다.");
	history.go(-1);
	</script>
<% }else{ %>
	<script>
	alert("사용 가능한 일련번호입니다.");
	</script>

<h2 align = "center">책 정보 입력</h2>
<!-- 책 상세정보 입력 -->
<form action="bkInsertPro.jsp" method="post" enctype="multipart/form-data">
<table border="1"  class= "update">
	<tr align = "center">
	
		<td>일련번호</td>
		<td><input type="text" name="bk_number" value = <%= bk_number%> disabled />
			&nbsp; &nbsp;
			<button type="button" class = "button" onclick="javascript:alert('사용가능한 일련번호로 확인되었습니다.')">중복확인</button></td>
	</tr>
	<tr align = "center">
		<td>제목</td>
		<td><input type="text" name="bk_title"  required  /></td>
	</tr>
	<tr align = "center">
		<td>저자</td>
		<td><input type="text" name="bk_writer"  required  /></td>
	</tr>
	<tr align = "center">
		<td>출판사</td>
		<td><input type="text" name="bk_publisher"   required /></td>
	</tr>
	<tr align = "center">
		<td>출간일</td>
		<td><input type="date" name="bk_pubdate"  required  /></td>
	</tr>
	<tr align = "center">
		<td>이미지</td>
		<td><input type="file" value="파일 선택" name="bk_image" /></td>
	</tr>
	<tr align = "center">
		<td>지역</td>
		<td>
		
		<input type="radio" name="bk_local" value="0" checked="checked" />국내도서
		&nbsp;&nbsp;
		<input type="radio" name="bk_local" value="1" />해외도서
		
		</td>
	</tr>
	<tr align="center">
		<td>장르</td>
		<td>
		
			<select name="bk_genre">
				<option value="0" selected="selected">--문학--</option>
				<option value="1">--역사--</option>
				<option value="2">--소설--</option>
				<option value="3">--만화--</option>
				<option value="4">--기타--</option>
			</select>
	
		</td>
	</tr>
	<tr align="center">
		<td>ebook 유무</td>
		<td>
			<input type="radio" name="bk_ebook" value="0" checked="checked" /> O
			<input type="radio" name="bk_ebook" value="1"/> X
		
		</td>
	</tr>
	<!-- 작성일 sysdate 처리 -->
	<tr align="center">
		<td>상세 내용</td>
		<td>
			<textarea rows="10" cols="74" name="bk_detail" style ="resize:none"></textarea></td>
	</tr>
	<tr align="center">
		<td colspan="2"> 				
			<input type="submit" class= "button" value="저장"/>&nbsp;&nbsp;
			<button type="button" class= "button" onclick="location.href='mainSession.jsp'">취소</button>
			<input type="hidden" name="bk_number" value=<%=bk_number %> />
	</tr>
		
</table>
</form>
<%}} %>
</body>
</html>