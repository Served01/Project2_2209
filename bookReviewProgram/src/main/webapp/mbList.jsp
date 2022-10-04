<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>  
<%@ page import="java.util.Vector" %> 
<%@ page session = "true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>전체 회원 목록 보기 화면</title>
</head>
<body>
<%String id = (String)session.getAttribute("id"); %>
<%	if(!id.equals("admin")){
%>
	<script>
	alert("권한이 없거나 세션이 만료되었습니다.");
	history.go(-1);
	</script>
<% 	
   } else {

	mbDAO mdao = new mbDAO();
	
	Vector<mbBean> vec = mdao.allselectmember();
	
 %>
 
 <%	
	int pageSize = 5;
	String pageNum = request.getParameter("pageNum");
	
	if(pageNum == null){
		pageNum = "1";
	}
	
	int count = 0;	//전체 글 개수
	int number = 0;	//페이지 넘버링 변수
	
	int currentPage = Integer.parseInt(pageNum);	//현재 페이지 저장
			
	count = mdao.getAllcount();		//전체 게시글 숫자 저장
	
	//현재 페이지에 보여줄 시작번호 설정과 끝 페이지 설정
	//데이터베이스에서 불러올 시작번호 - 1
	int startRow = (currentPage - 1) * pageSize + 1;	//1page (1 - 1) * 10 + 1 = 1
	int endRow = currentPage * pageSize;				//1page 1 * 10 = 10
	
	vec = mdao.allselectBoard(startRow, endRow);
	
	number = count - (currentPage - 1) * pageSize;		//테이블에 표시할 번호 설정
%>

<h2 align="center">전체 회원 정보 조회</h2>
<p align="center">
<input type="button" class = "button" value="마이페이지" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp'" />&nbsp;&nbsp;
<button class = "button" onclick="location.href='mainSession.jsp'">메인 페이지</button>
</p>
<br>

<% if(vec.size()==0){%>
	<h2>회원 목록이 없습니다.</h2>	
<%} else{%>


<table border="1" width="1000" class = "update">
	<tr align="center">
		<td height="10" width="100">ID</td>
		<td height="10" width="100">이름</td>
		<td height="10" width="100">이메일</td>
		<td height="10" width="100">전화번호</td>
		<td height="10" width="100">성별</td>
		<td height="10" width="100">가입일시</td>	
	</tr>

	<%
		for(int i=0; i < vec.size(); i++){
			mbBean mBean = vec.get(i);		
	%>
	
	<tr align="center">
		<td><a style="color:pink" href="#" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp&mb_id=<%=mBean.getMb_id() %>'"><%=mBean.getMb_id() %></a></td>
		<td><%=mBean.getMb_name() %></td>
		
		<td><%=mBean.getMb_email() %></td>
		<td><%=mBean.getMb_tel() %></td>
		<td>
		<%if(mBean.getMb_gender()==1){ %>
		남성
		<%} else if(mBean.getMb_gender()==2) {%>
		여성
		<%} %>
		</td>	
		<td><%=mBean.getMb_date() %></td>	
	</tr>
	<%}%>	
	</table>
	<%} %>
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
			<a align="center" href="mainSession.jsp?center=mbList.jsp&pageNum=<%=startPage - 10 %>">[previous]</a>
	<%
		}
			for(int i = startPage; i <= endPage; i++){
	%>
			<a align="center" href="mainSession.jsp?center=mbList.jsp&pageNum=<%=i %>">[<%=i %>]</a>
	<%
			}
			
		//[이후] 링크 제작
		if(endPage < pagecount){
			endPage = pagecount;		
	%>
			<a align="center" href="mainSession.jsp?center=mbList.jsp&pageNum=<%=startPage + 10 %>">[next]</a>
	<%
		}
	}
	%>
	</div>
<%} %>
</body>
</html>