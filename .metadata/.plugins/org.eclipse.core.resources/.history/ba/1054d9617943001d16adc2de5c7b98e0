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
<title>책 상세 정보 조회 화면</title>
</head>

<style>
table{
margin: auto;
}
</style>

<body>

<!-- bean이 없는 상태에서 가져올 때는 아래와 같이 이용 -->
<%	String id = (String)session.getAttribute("id");
	
    int bk_number = Integer.parseInt(request.getParameter("bk_number"));
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(bk_number);
	
	rvDAO rdao = new rvDAO();
	double bk_score=rdao.getScore(bk_number);
	
	
%>

<!-- 책 상세 정보 표시 -->
<table border="1">
	<tr align = "center" height="360" width="1150">
		<td rowspan="6"><div style="height:100%; width:100%;"><img src="/image/<%=bBean.getBk_image()%>" height="100%" width="100%"></div></td>
		<td>일련번호</td>
		<td height="20" width="400"><%=bBean.getBk_number()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td height="20" width="200">제목</td>
		<td height="20" width="400"><%=bBean.getBk_title()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td height="20" width="200">저자</td>
		<td height="20" width="400"><%=bBean.getBk_writer()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td height="20" width="200">출판사</td>
		<td height="20" width="400"><%=bBean.getBk_publisher()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td height="20" width="200">출간일</td>
		<td height="20" width="400"><%=bBean.getBk_pubdate()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=6 -->
		<td height="20" width="200">지역</td>
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
		<td height="20" width="200">장르</td>
		<td height="20" width="400">
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
		<td height="20" width="200">ebook 유무</td>
		<td height="20" width="400">
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
		<td colspan="3" height="200" width="400">
			<%=bBean.getBk_detail()%>
		</td>
	</tr>
	<tr align="center">
		<td colspan="3"> 
<%	if(id.equals("admin")){	
   } else {		%>		
			<button type="button" onclick="location.href='mainSession.jsp?center=bkUpdateform.jsp&bk_number=<%=bk_number%>'">수정</button>&nbsp;&nbsp;
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
			<%} %>
			<button type="button" onclick="javascript:history.go(-1)">이전</button>
	</tr>	
</table>

<!-- 책 리뷰 목록 표시 -->
<%
	int rv_bknumber = bk_number; 
	
%>	

<hr>
<h2 align="center">리뷰</h2>
<p align="center">
	<button type="button" onclick="location.href='mainSession.jsp?center=rvInsertform.jsp&bk_number=<%=bBean.getBk_number() %>'">리뷰 등록</button>
</p>

<% 	

		Vector<rvBean> rvVec = rdao.allbookselectReview(rv_bknumber);

		String Rv_bknumber = Integer.toString(rv_bknumber);
		
		String column = "Rv_bknumber";
		String value = Rv_bknumber;
		
		
		int pageSize = 5;
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null){
			pageNum = "1";
		}
		
		int count = 0;	//전체 글 개수
		int number = 0;	//페이지 넘버링 변수
		
		int currentPage = Integer.parseInt(pageNum);	//현재 페이지 저장
				
		count = rdao.getAllcount(column, value);		//전체 게시글 숫자 저장
		
		//현재 페이지에 보여줄 시작번호 설정과 끝 페이지 설정
		//데이터베이스에서 불러올 시작번호 - 1
		int startRow = (currentPage - 1) * pageSize + 1;	//1page (1 - 1) * 10 + 1 = 1
		int endRow = currentPage * pageSize;				//1page 1 * 10 = 10
		
		rvVec = rdao.allselectBoard(startRow, endRow, column, value);
		
		number = count - (currentPage - 1) * pageSize;		//테이블에 표시할 번호 설정
		
		for(int i=0; i < rvVec.size(); i++){
		
		rvBean rbean = rvVec.get(i);
		int rv_number = rbean.getRv_number();
		String rv_id = rbean.getRv_id();
%>




<table border="1">
	<tr align="center">
		<td>아이디:&nbsp;<%=rbean.getRv_id() %></td>
		<td>평점:&nbsp;<%=rbean.getRv_score() %></td>
		<td>
		<%	if(id.equals("admin") || id.equals(rbean.getRv_id())){	
  		 } else {		%>		
		<button type="button" onclick="location.href='mainSession.jsp?center=rvUpdateform.jsp&rv_number=<%=rbean.getRv_number() %>&rv_bknumber=<%=rbean.getRv_bknumber() %>&mb_id=<%=(String)session.getAttribute("id")%>'">수정</button>
		<button type="button" onclick="javascript:rvdeleteConfirm()">삭제</button>&nbsp;&nbsp;
			<script>
				function rvdeleteConfirm(){
					
					var rv_number = <%=rv_number%>;
					var rv_id = "<%=rv_id%>";
					var bk_number = <%=bk_number%>
					var isDelete1 = confirm("정말로 삭제하시겠습니까?");
					if(isDelete1){
						location.href = "rvDeletePro.jsp?rv_number="+rv_number+"&rv_id="+rv_id+"&rv_bknumber="+bk_number;
					}
				}
			</script>
		<%} %>
		
		</td>
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
</table>
<%} %>
<!-- 스타트 페이지 -->
	<%
	
	if(count > 0){
		//
		int pagecount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1;
		
		if(currentPage % 10 != 0){
			startPage = (currentPage / 10) * 10 + 1;	
		}else{
			startPage = (currentPage / 10 ) * 10 - 1;
		}
		
		int pageBlock = 10;
		
		int endPage = startPage + pageBlock - 1;
		%>
		
	<div align="center">
		<%
		//[이전] 링크 제작
		if(endPage > pagecount){
			endPage = pagecount;	
		}
		
		if(startPage > 10){
	%>
			<a align="center" href="mainSession.jsp?center=bkSelectPro.jsp&bk_number=<%=bk_number %>&pageNum=<%=startPage - 10 %>">[previous]</a>
	<%
		}
			for(int i = startPage; i <= endPage; i++){
	%>
			<a align="center" href="mainSession.jsp?center=bkSelectPro.jsp&bk_number=<%=bk_number %>&pageNum=<%=i %>">[<%=i %>]</a>
	<%
			}
			
		//[이후] 링크 제작
		if(endPage < pagecount){
			endPage = pagecount;		
	%>
			<a align="center" href="mainSession.jsp?center=bkSelectPro.jsp&bk_number=<%=bk_number %>&pageNum=<%=startPage + 10 %>">[next]</a>
	<%
		}
	}
	%>
	</div>

</body>
</html>