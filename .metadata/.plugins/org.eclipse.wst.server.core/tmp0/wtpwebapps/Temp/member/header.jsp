<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
</head>
<body>
<!-- session을 이용한 로그인 처리 -->
<%
	String id = (String)session.getAttribute("id");

	if(id == null){
		id = "GUEST";
	}
%>

<table width="1000" bordercolor="skyblue">
	<tr height="80">
		<td colspan="2" align="center">
			<img alt="회사로고" src="./images/campingLogo.PNG" height="60">
		</td>
		<td colspan="4" align="center">
			<font size="20">낭만캠프</font>
		</td>
		<td align="center" width="200">
			<%=id %>님 반갑습니다.
		<%
			if(id.equals("GUEST")){
		%>
			<button onclick="location.href='mainSession.jsp?center=sessionloginform.jsp'">로그인</button>	
		<%
			}else{
		%>		
			<button onclick="location.href='mainSession.jsp?center=sessionlogout.jsp?logout=1'">로그아웃</button>	
		<% } %>	
		</td>
	</tr>
	<tr height="50">
		<td align="center" width="150" bgcolor="yellow">
			<font size="5" color="white">
				<a href="mainSession.jsp?center=koveaTent2.jsp" style="text-decoration: none">텐트</a></font>
		</td>
		<td align="center" width="150" bgcolor="yellow">
			<font size="5" color="white">
				<a href="mainSession.jsp?center=sleeping_bag.jsp" style="text-decoration: none">침낭</a></font>
		</td>
		<td align="center" width="150" bgcolor="yellow">
			<font size="5" color="white">
				<a href="mainSession.jsp?center=chair.jsp" style="text-decoration: none">의자</a></font>
		</td>
		<td align="center" width="150" bgcolor="yellow">
			<font size="5" color="white">
				<a href="mainSession.jsp?center=sleeping_bag.jsp" style="text-decoration: none">테이블</a></font>
		</td>
		<td align="center" width="150" bgcolor="yellow">
			<font size="5" color="white">
				<a href="mainSession.jsp?center=burner.jsp" style="text-decoration: none">버너</a></font>
		</td>
	</tr>	
</table>
</body>
</html>