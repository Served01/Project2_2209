<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<%
	int pageSize = 10;
	String pageNum = request.getParameter("pageNum");
	
	if(pageNum == null){
		pageNum = "1";
	}
	
	int count = 0;	//전체 글 개수
	int number = 0;	//페이지 넘버링 변수
	
	int currentPage = Integer.parseInt(pageNum);	//현재 페이지 저장
		
	rvDAO rdao = new rvDAO();	
	count = rdao.getAllcount();		//전체 게시글 숫자 저장
	
	//현재 페이지에 보여줄 시작번호 설정과 끝 페이지 설정
	//데이터베이스에서 불러올 시작번호 - 1
	int startRow = (currentPage - 1) * pageSize + 1;	//1page (1 - 1) * 10 + 1 = 1
	int endRow = currentPage * pageSize;				//1page 1 * 10 = 10
	
	Vector<rvBean> vec = rdao.allselectBoard(startRow, endRow);
	
	number = count - (currentPage - 1) * pageSize;		//테이블에 표시할 번호 설정
%>
<h2 align="center">게시판 목록 보기 화면</h2>
<table border="1" align="center" style= width: 100%">
	<tr align="center" style="height: 40; background: yellow;">
		<td width="100">번호</td>
		<td width="120">제목</td>
		<td width="120">작성자</td>
		<td width="120">전자우편</td>
		<td width="120">작성일자</td>
		<td width="100">조회수</td>
		<td width="120">글내용</td>
	</tr>

	<%
		for(int i=0; i < vec.size(); i++){
			
			rvBean rBean = vec.get(i);		
	%>
	<tr height="40" align="center">
		<td><%=rBean.getRv_number() %></td>
		<td align="left" width="140">
			<a href="rvSelectbookPro.jsp?num=<%=rBean.getRv_number() %>" style="text-decoration:none">
			<%
			//들여쓰기
			if(rBean.getRv_number() > 1){
				for(int k=0; k < (rBean.getRv_number() - 1) * 3; k++){
					%>
			<%
				}
			}
			%>
		<%=rBean.getRv_bknumber() %></a></td>
		<td><%=rBean.getRv_id() %></td>
		<td><%=rBean.getRv_date() %></td>
		<td><%=rBean.getRv_score() %></td>
		<td><%=rBean.getRv_content() %></td>
	</tr>
	<%} %>	
</table>
	<table align="center">
		<tr>
			<td>
				<input type="button" value="글쓰기" onclick="location.href='boardwriteform.jsp'"/>&nbsp;&nbsp;				
				<input type="button" value="회원목록보기" onclick="location.href='memberList.jsp'"/>&nbsp;&nbsp;				
				<button onclick="location.href='mainSession.jsp'">mainSession</button>
		</tr>
	</table>
	
	<p>
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
		
		//[이전] 링크 제작
		if(endPage > pagecount){
			endPage = pagecount;	
		}
		
		if(startPage > 10){
	%>
			<a href="boardList.jsp?pageNum=<%=startPage - 10 %>">[previous]</a>
	<%
		}
			for(int i = startPage; i <= endPage; i++){
	%>
			<a href="boardList.jsp?pageNum=<%=i %>">[<%=i %>]</a>
	<%
			}
		//[이후] 링크 제작
		if(endPage < pagecount){
			endPage = pagecount;		
	%>
			<a href="boardList.jsp?pageNum=<%=startPage + 10 %>">[next]</a>
	<%
		}
	}
	%>
	
</body>
</html>