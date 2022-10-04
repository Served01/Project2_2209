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
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>메뉴용 책 리스트 조회 화면</title>
</head>
<body>

<!-- bean이 없는 상태에서 가져올 때는 아래와 같이 이용 -->
<%
	int bk_local = Integer.parseInt(request.getParameter("bk_local"));
	int bk_genre = Integer.parseInt(request.getParameter("bk_genre"));
	
	bkDAO bdao = new bkDAO();
	Vector<bkBean> bkVec = bdao.selectMenuBookList(bk_local,bk_genre);
	if(bkVec.size()==0){ %>
	<script>
		location.href="mainSession.jsp?center=noResultPro.jsp";
	</script>	
<%	} else{
	
		String column1 = "BK_local";
		int value1 = bk_local;
		String column2 = "BK_genre";
		int value2 = bk_genre;
		
		int pageSize = 5;
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null){
			pageNum = "1";
		}
		
		int count = 0;	//전체 글 개수
		int number = 0;	//페이지 넘버링 변수
		
		int currentPage = Integer.parseInt(pageNum);	//현재 페이지 저장
				
		count = bdao.getbkmenucount(column1, value1, column2, value2);		//전체 게시글 숫자 저장
		
		//현재 페이지에 보여줄 시작번호 설정과 끝 페이지 설정
		//데이터베이스에서 불러올 시작번호 - 1
		int startRow = (currentPage - 1) * pageSize + 1;	//1page (1 - 1) * 10 + 1 = 1
		int endRow = currentPage * pageSize;				//1page 1 * 10 = 10
		
		bkVec = bdao.bkmenuselectBoard(startRow, endRow, column1, value1, column2, value2);
		
		number = count - (currentPage - 1) * pageSize;
		for(int i=0; i < bkVec.size(); i++){
			
			bkBean bBean = bkVec.get(i);
			int bk_number = bBean.getBk_number();
			
			rvDAO rdao = new rvDAO();
			double bk_score=rdao.getScore(bk_number);
		
			String bk_title= bBean.getBk_title();
	%>


<!-- 책 일부 정보 표시 -->
<table border="1" class= "update">
	<tr align = "center" height="80" width="1150">
		<td rowspan="4" width="250"><div style="height:100%; width:100%;"><img src="/image/<%=bBean.getBk_image()%>" height="100%" width="100%"></div></td>
		<td height="20" width="200">책 일련번호</td>
		<td colspan="3"><%=bBean.getBk_number()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=4 -->
		<td height="20" width="200">책 제목</td>
		<td height="20" width="400"><a style="color:pink" href="#" onclick="location.href='mainSession.jsp?center=bkSelectPro.jsp&bk_number=<%=bBean.getBk_number()%>'"><%=bk_title %></a></td>
		<td height="20" width="200">책 저자</td>
		<td height="20" width="400"><%=bBean.getBk_writer()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=4-->
		<td height="20" width="200">출판사</td>
		<td height="20" width="400"><%=bBean.getBk_publisher()%></td>
		<td height="20" width="200">출간일</td>
		<td height="20" width="400"><%=bBean.getBk_pubdate()%></td>
	</tr>
	<tr align = "center">
		<!-- <td> rowspan=4 -->
		<td height="20" width="200">평점</td>
		<td colspan="3" height="20" width="400">
		<%if(bk_score==0){%>
			등록된 평점이 없습니다.
		<%
		} else { %>
			<%=bk_score%>점
		<%}%></td>
	</tr>
</table>
<%}%>
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
		<a align="center" href="mainSession.jsp?center=bkListMenuPro.jsp&bk_local=<%=bk_local%>&bk_genre=<%=bk_genre%>&pageNum=<%=startPage - 10 %>">[previous]</a>
<%
	}
		for(int i = startPage; i <= endPage; i++){
%>
		<a align="center" href="mainSession.jsp?center=bkListMenuPro.jsp&bk_local=<%=bk_local%>&bk_genre=<%=bk_genre%>&pageNum=<%=i %>">[<%=i %>]</a>
<%
		}
		
	//[이후] 링크 제작
	if(endPage < pagecount){
		endPage = pagecount;		
%>
		<a align="center" href="mainSession.jsp?center=bkListMenuPro.jsp&bk_local=<%=bk_local%>&bk_genre=<%=bk_genre%>&pageNum=<%=startPage + 10 %>">[next]</a>
<%
	}
}
%>
</div>
<%} %>


</body>
</html>