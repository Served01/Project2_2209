<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="BKRV.book.bkDAO" %>
<%@ page import="BKRV.book.bkBean" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>리뷰 데이터 입력 페이지</title>
</head>
<body>

<%	String id = (String)session.getAttribute("id");
	if(id==null){
%>
	<script>
	alert("로그인을 먼저 해주시기 바랍니다.");
	history.go(-1);
	</script>
<% 	
   } else { 

	int rv_bknumber= Integer.parseInt(request.getParameter("bk_number")); 
	String rv_id = (String)session.getAttribute("id");
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(rv_bknumber);
	
	
	rvDAO rdao = new rvDAO();
	double bk_score=rdao.getScore(rv_bknumber);
	
%>
<table border="1" class = "update">
	<tr align = "center" height="230" width="1150">
		<td rowspan="6" width="250"><div style="height:100%; width:100%;"><img src="/image/<%=bBean.getBk_image()%>" height="100%" width="100%"></div></td>
		<td>일련번호</td>
		<td><%=bBean.getBk_number()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>제목</td>
		<td height="20" width="400"><%=bBean.getBk_title()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>저자</td>
		<td height="20" width="400"><%=bBean.getBk_writer()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>출판사</td>
		<td height="20" width="400"><%=bBean.getBk_publisher()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>출간일</td>
		<td height="20" width="400"><%=bBean.getBk_pubdate()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td>지역</td>
		<td height="20" width="400">
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
		<td rowspan="2" height="20" width="400">평점:&nbsp;
		<%if(bk_score==0){%>
			등록된 평점이 없습니다.
		<%
		} else { %>
			<%=bk_score%>점
		<%}%>
		</td>
		<td height="20" width="400">장르</td>
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
		<td height="20" width="400">ebook 유무</td>
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
<h2 align="center">리뷰 작성</h2>

<form action="rvInsertPro.jsp" method="post">
	<table border="1" class="update" width="100%">
		<tr align="center">
			<td>리뷰 작성자</td>
			<td><%=rv_id %></td>
		</tr>
		<tr align="center">
			<td>평점</td>
			<td>
			<input type="radio" name="rv_score" value=1 />1점&nbsp;&nbsp;
			<input type="radio" name="rv_score" value=2 />2점&nbsp;&nbsp;
			<input type="radio" name="rv_score" value=3 />3점&nbsp;&nbsp;
			<input type="radio" name="rv_score" value=4 />4점&nbsp;&nbsp;
			<input type="radio" name="rv_score" value=5 checked />5점
			</td>
		</tr>
		<tr align="center">
			<td>내용</td>
			<td>
			<textarea  rows="10" cols="100" name="rv_content"  required ></textarea>
			</td>
		</tr>
		
		<tr align="center">
			<td colspan="2">
				<input type="hidden" name="rv_bknumber" value=<%=rv_bknumber %> />
				<input type="hidden" name="rv_id" value=<%=rv_id %> />
				<input type="submit" class = "button" value="등록"/>&nbsp;&nbsp;
				<input type="button" class = "button" value="취소"/>&nbsp;&nbsp;
				<input type="button" class = "button" value="뒤로가기" onclick="javascript:history.go(-1)" />
			</td>
		</tr>
	</table>
</form>
<%} %>
</body>
</html>