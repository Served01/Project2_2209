<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %>    
<%@ page session = "true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
</head>
<body>
<%
	
	String id = (String)session.getAttribute("id");

	mbDAO mdao = new mbDAO();
	mbBean mBean = mdao.oneselectmember(id);
%>
	
		<h2 align="center">회원 정보 상세 보기</h2>
		
		<p align="right">
		
			<button onclick="location.href='mainSession.jsp?center=rvSelectMemberPro.jsp?rv_id=<%=id%>'">My review</button><!-- reviewSelectMemberPro.jsp.만들기 -->
			<%	if(id.equals("admin")){
			%>
			<button onclick="location.href='mainSession.jsp?center=rvAllReviewPro.jsp'">리뷰목록</button><!-- reviewAllSelectMemberPro.jsp 만들기 -->
			<button onclick="location.href='mainSession.jsp?center=mbList.jsp'">회원목록</button>
			<button onclick="location.href='mainSession.jsp?center=bkInsertform.jsp'">책정보입력</button>
			<button onclick="location.href='mainSession.jsp?center=bkAllListPro.jsp'">책전체목록</button>
			<%} else{ %>
			<%} %>
			
			
	
<div align="center">
	<table border="1">
		<tr align="center">
			<td>아이디</td>
			<td><%=mBean.getMb_id() %></td>
		</tr>
		<tr align="center">
			<td>이름</td>
			<td><%=mBean.getMb_name() %></td>
		</tr>

		<tr align="center">
			<td>이메일</td>
			<td><%=mBean.getMb_email() %></td>
		</tr>
		<tr align="center">
			<td>전화번호</td>
			<td><%=mBean.getMb_tel() %></td>
		</tr>
		
		<tr align="center">
			<td>성별</td>
			<td>
			<%if(mBean.getMb_gender()==1){ %>
			남성
			<%} else if(mBean.getMb_gender()==2) {%>
			여성
			<%} %>
			</td>
		</tr>
		<tr align="center">
			<td>가입일자</td>
			<td><%=mBean.getMb_date() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='mainSession.jsp?center=mbUpdateform.jsp&mb_id=<%=mBean.getMb_id()%>'">수정</button>
				<button onclick="location.href='mainSession.jsp?center=mbDeleteform.jsp&mb_id=<%=mBean.getMb_id()%>'">삭제</button>
				<button onclick="location.href='mainSession.jsp'">메인페이지</button>
			</td>
		</tr>
	</table>

</div>
</body>
</html>