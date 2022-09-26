<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.book.bkDAO" %>
<%@ page import="BKRV.book.bkBean" %>
<%@ page import="java.util.Vector" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int num = Integer.parseInt(request.getParameter("num"));
	//ID? Number?
	bkDAO bdao = new bkDAO();
	Vector<bkBean> vec = bdao.allselectBook();
%>


<h2 align="center">책정보조회</h2>
<table border="1" style="align: center width: 100%">
	<tr align="center" style="height: 40; background: pink;">
		<td width="100">번호</td>
		<td width="120">책 번호</td>
		<td width="120">작성자 아이디</td>
		<td width="120">작성 날짜</td>
		<td width="120">평점</td>
		<td width="80">리뷰 내용</td>
		<td width="50">연령대</td>
		<td>하고싶은 말</td>
	</tr>

	<%
	for(int i=0; i < vec.size(); i++){
		
		bkBean bBean = vec.get(i);
	%>
	<tr height="40" align="center">
		<td><a href="memberDetail.jsp?id=<%=bBean.getId() %>"><%=bBean.getId() %></a></td>
		<td><%=bBean.getNumber() %></td>
		<td><%=bBean.getBknumber() %></td>
		<td><%=bBean.getId() %></td>
		<td><%=bBean.getDate() %></td>
		<td><%=bBean.getScore() %></td>
		<td><%=bBean.getContent() %></td>		
	</tr>
	<%} %>	
</table>
	<table align="center">
		<tr>
			<td>
				<button onclick="location.href='memberJoinform.jsp'">회원가입</button>&nbsp;&nbsp;
				<button onclick="location.href='mainSession.jsp'">mainSession</button>
		</tr>
	</table>
</body>
</html>