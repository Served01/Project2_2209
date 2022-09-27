<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="BKRV.book.bkDAO" %>
<%@ page import="BKRV.book.bkBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정 페이지</title>
</head>

<style>
table{
margin: auto;
}
</style>

<body>

<%

	int rv_number= 1; //Integer.parseInt(request.getParameter("rv_number"));
	int rv_bknumber= 20220001; //Integer.parseInt(request.getParameter("bk_number")); 
	String rv_id = "hyun"; //request.getParameter("mb_id");
	
	rvDAO rdao = new rvDAO();
	rvBean rbean = rdao.updateOneSelectReview(rv_number, rv_bknumber, rv_id);
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(rv_bknumber);
	
%>
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
		<td>
		<% 
		if(bBean.getBk_local()==0){ %>
		국내도서
		<%} 
		else if(bBean.getBk_local()==1){ %>
		해외도서
		<%}; 
		
		%>
		</td>
	</tr>
	<tr align="center">
		<td rowspan="2">평점:&nbsp;3</td>
		<td>장르</td>
		<td>
		<%if(bBean.getBk_genre()==0){%>	
			문학		
		<%}
		
		else if(bBean.getBk_genre()==1){%>
			역사
		<%} 
		else if(bBean.getBk_genre()==2){%>
			소설
		<%} 
		else if(bBean.getBk_genre()==3){%>
			만화
		<%}
		else if(bBean.getBk_genre()==4){%>
			기타
		<%} 
		%>
		</td>
	</tr>
	<tr align="center">
		<!-- <td> rowspan=2 -->
		<td>ebook 유무</td>
		<td>
		<%if(bBean.getBk_ebook()==0){ %>
			O
		<%}
		else if(bBean.getBk_ebook()==1){%>
			X
		<%} %>
		</td>
	</tr>
	<!-- 작성일 sysdate 처리 -->
	<tr align="center">
		<td colspan="3">
			<textarea rows="10" cols="74" name="bk_detail" style ="resize:none"><%=bBean.getBk_detail()%></textarea>
		</td>
	</tr>
</table>
<hr>
	<h2 align="center">리뷰 수정</h2>
<form action="rvUpdatePro.jsp" method="post">
	<table border="1">
		<tr align="center">
			<td>리뷰 작성자</td>
			<td><%=rbean.getRv_id() %></td>
		</tr>
		<tr align="center">
			<td>평점</td>
			<td>
			<%if(rbean.getRv_score()==1){ %>
			1점<input type="radio" name="rv_score" value=1 checked="checked" />
			2점<input type="radio" name="rv_score" value=2 />
			3점<input type="radio" name="rv_score" value=3 />
			4점<input type="radio" name="rv_score" value=4 />
			5점<input type="radio" name="rv_score" value=5 />
			<%}
			else if(rbean.getRv_score()==2){%>
			1점<input type="radio" name="rv_score" value=1 />
			2점<input type="radio" name="rv_score" value=2 checked="checked" />
			3점<input type="radio" name="rv_score" value=3 />
			4점<input type="radio" name="rv_score" value=4 />
			5점<input type="radio" name="rv_score" value=5 />
			<%}
			else if(rbean.getRv_score()==3){%>
			1점<input type="radio" name="rv_score" value=1 />
			2점<input type="radio" name="rv_score" value=2 />
			3점<input type="radio" name="rv_score" value=3 checked="checked" />
			4점<input type="radio" name="rv_score" value=4 />
			5점<input type="radio" name="rv_score" value=5 />
			<%}
			else if(rbean.getRv_score()==4){%>
			1점<input type="radio" name="rv_score" value=1 />
			2점<input type="radio" name="rv_score" value=2 />
			3점<input type="radio" name="rv_score" value=3 />
			4점<input type="radio" name="rv_score" value=4 checked="checked" />
			5점<input type="radio" name="rv_score" value=5 />
			<%}
			else if(rbean.getRv_score()==5){%>
			1점<input type="radio" name="rv_score" value=1 />
			2점<input type="radio" name="rv_score" value=2 />
			3점<input type="radio" name="rv_score" value=3 />
			4점<input type="radio" name="rv_score" value=4 />
			5점<input type="radio" name="rv_score" value=5 checked="checked" />
			<%};%>
			</td>
		</tr>
		<tr align="center">
			<td>내용</td>
			<td>
			<textarea rows="10" cols="67" name="rv_content"><%=rbean.getRv_content()%></textarea>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2"> 				
			<input type="submit" value="수정"/>&nbsp;&nbsp;
			<button type="button">취소</button>
			<input type="hidden" name="rv_number" value=<%=rv_number%> />
			<input type="hidden" name="rv_bknumber" value=<%=rv_bknumber%> />
			<input type="hidden" name="rv_id" value=<%=rv_id%> />
			</td>
		</tr>
	</table>
</form>
</body>
</html>