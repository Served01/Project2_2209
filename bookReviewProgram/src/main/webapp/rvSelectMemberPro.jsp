<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page import="BKRV.book.bkBean"%>
<%@ page import="java.util.Vector" %>  
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>회원의 리뷰 목록</title>
</head>
<body>
<%	String id = (String)session.getAttribute("id");
	if(id==null){
		%>
		<script>
		alert("권한이 없거나 세션이 만료되었습니다.");
		history.go(-1);
		</script>
	<% 	
	   } else {%>
<h2 align="center">회원리뷰조회</h2>
 <% 
	String Rv_id = (String)session.getAttribute("id");
	
	String column = "Rv_id";
	String value = Rv_id;
	
	rvDAO rdao = new rvDAO();
	Vector<rvBean> vec = rdao.allmemberselectReview(Rv_id);
	
	if(vec.size()==0){
%>
		<h2>작성한 댓글이 없습니다.</h2>	
<%		
	}else{
	
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
	
	vec = rdao.allselectBoard(startRow, endRow, column, value);
	
	number = count - (currentPage - 1) * pageSize;		//테이블에 표시할 번호 설정
%>
<%
	for(int i = 0; i < vec.size(); i++){
		rvBean rBean = vec.get(i);
		
		int bk_number = rBean.getRv_bknumber();
		
		bkDAO bdao = new bkDAO();
		String bk_title = bdao.selecttitleBook(bk_number);
		
%>

<table border="1" class = "update" align="center" width="100%">
	<tr align="center">
		<td>아이디:&nbsp;<%=rBean.getRv_id() %></td>
		<td>평점:&nbsp;<%=rBean.getRv_score() %></td>
		<td>
		<button type="button" class = "button" onclick="location.href='mainSession.jsp?center=bkUpdateform.jsp&bk_number=<%=bk_number%>'">수정</button>&nbsp;&nbsp;
		<button type="button" class = "button" onclick="javascript:deleteConfirm()">삭제</button>&nbsp;&nbsp;
			<script>
				function deleteConfirm(){
					var rv_number = <%=rBean.getRv_number()%>;
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
		등록날짜:&nbsp;<%=rBean.getRv_date() %>
		</td>
	</tr>
	<tr>
		<td colspan="3" height="150">
		<%=rBean.getRv_content()%>
		</td>
	</tr>

	<%} %>

</table>
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
			<a align="center" href="mainSession.jsp?center=rvSelectMemberPro.jsp?pageNum=<%=startPage - 10 %>">[previous]</a>
	<% 
		}
			for(int i = startPage; i <= endPage; i++){
	%>
			<a align="center" href="mainSession.jsp?center=rvSelectMemberPro.jsp?pageNum=<%=i %>">[<%=i %>]</a>
	<%
			}
			
		//[이후] 링크 제작
		if(endPage < pagecount){
			endPage = pagecount;		
	%>
			<a align="center" href="mainSession.jsp?center=rvSelectMemberPro.jsp?pageNum=<%=startPage + 10 %>">[next]</a>
	<%
		}
	}}}
	%>
	</div>
	
</body>
</html>