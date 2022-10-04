<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO" %>  
<%@ page import="BKRV.member.mbBean" %> 
<%@ page session = "true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/updateform.css">
<title>회원정보 수정 화면</title>
</head>
<body>
<%	String id = (String)session.getAttribute("id");
	String mb_id  = request.getParameter("mb_id");

	if(id.equals(mb_id) || id.equals("admin")){
	
	mbDAO mdao = new mbDAO();
	mbBean mBean = mdao.oneselectmember(mb_id);
%>

<h2 align="center">회원정보 수정 화면 구현</h2>
<form action="mbUpdatePro.jsp" method="post"> 
<div align="center">
	<table border="1" class = "update">
		<tr align="center">
			<td>아이디</td>
			<td><%=mBean.getMb_id() %></td>
		</tr>
		<tr align="center">
			<td>이름</td>
			<td><%=mBean.getMb_name() %></td>
		</tr>
		<tr align="center">
			<td>전자우편</td>
			<td>
				<input type="email" name="mb_email" value="<%=mBean.getMb_email() %>" required >
			</td>
		</tr>
		<tr align="center">
			<td>전화번호</td>
			<td>
				<input type="text" name="mb_tel" value="<%=mBean.getMb_tel() %>" required >
			</td>
		</tr>
		<tr align="center">
			<td>성별</td>
			<td>
			<%if(mBean.getMb_gender()==1){ %>
				<input type="radio" name="mb_gender" value="1" checked/>남자
				<input type="radio" name="mb_gender" value="2"/>여자		
			<%} else if(mBean.getMb_gender()==2) { %>	
				<input type="radio" name="mb_gender" value="1" />남자
				<input type="radio" name="mb_gender" value="2" checked />여자	
			<%} %>		
			</td>
		</tr>
		<tr align="center">
			<td>비밀번호</td>
			<td>
				<input type="password" name="password" required >
			</td>
		</tr>
		<tr style="height: 40; ">
			<td colspan="2">
				<input type="hidden" name="mb_id" value="<%=mBean.getMb_id() %>">
				<input type="submit" value="회원정보수정" class = "button">&nbsp;&nbsp;
				<input type="button" class = "button" value="비밀번호 변경" onclick="location.href='mainSession.jsp?center=mbPassform.jsp&mb_id=<%=mBean.getMb_id() %>'"/>&nbsp;&nbsp;
				<input type="button" class = "button" value="회원정보조회" onclick="location.href='mainSession.jsp?center=mbList.jsp'"/>&nbsp;&nbsp;
				<input type="button" class = "button" value="마이페이지" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp&mb_id=<%=mBean.getMb_id() %>'" />
			</td>
		</tr>
	</table>
</div>
</form>
<%} else{ %>
	<script>
	alert("권한이 없거나 세션이 만료되었습니다.");
	history.go(-1);
	</script>
<% }%>
</body>
</html>