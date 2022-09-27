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

<!-- bean이 없는 상태에서 가져올 때는 아래와 같이 이용 -->
<%
	int bk_number = Integer.parseInt(request.getParameter("bk_number"));
	
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
	<tr align="center">
		<td colspan="3"> 				
			<button type="button" onclick="location.href='bkUpdateform.jsp?bk_number=<%=bk_number%>'">수정</button>&nbsp;&nbsp;
			<button type="button" onclick="javascript:deleteConfirm()">삭제</button>&nbsp;&nbsp;
			<script>
				function deleteConfirm(){
					var bk_number = <%=bk_number%>;
					var isDelete = confirm("정말로 삭제하시겠습니까?");
					if(isDelete){
						location.href = "bkDeletePro.jsp?bk_number="+bk_number;
					}
				}
			</script>
			<button type="button" onclick="javascript:history.go(-1)">이전</button>
	</tr>	
</table>

<!-- 책 리뷰 목록 표시 -->
<hr>
<h2 align="center">리뷰</h2>

<%
	int rv_bknumber = bk_number; 
	
	rvDAO rdao = new rvDAO();
	Vector<rvBean> rvVec = rdao.allbookselectReview(rv_bknumber);
	
	for(int i=0; i < rvVec.size(); i++){
		
		rvBean rbean = rvVec.get(i);
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
	<tr>
		<td colspan="3">
		<%=rbean.getRv_content()%>
		</td>
	</tr>
</table>
<%} %>

</body>
</html>