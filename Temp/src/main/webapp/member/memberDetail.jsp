<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.ezen.memberDAO" %>  
<%@ page import="kr.co.ezen.memberBean" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세 보기</title>
</head>
<body>
<%
	String id = request.getParameter("id");

	memberDAO mdao = new memberDAO();
	memberBean mBean = mdao.oneselectmember(id);
%>

<h2 align="center">회원정보 상세 보기 화면 구현</h2>
<div align="center">
	<table border="1" style="text-align: center; width: 100%;">
		<tr align="center" style="height: 40; background: pink;">
			<td width="100">아이디</td>
			<td><%=mBean.getId() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">이&nbsp;&nbsp;&nbsp;름</td>
			<td><%=mBean.getName() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">전자우편</td>
			<td><%=mBean.getEmail() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">전화번호</td>
			<td><%=mBean.getTele() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">관심분야</td>
			<td><%=mBean.getHobby() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="80">직&nbsp;&nbsp;&nbsp;업</td>
			<td><%=mBean.getJob() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="120">연령대</td>
			<td><%=mBean.getAge() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="80">하고싶은 말</td>
			<td><%=mBean.getInfo() %></td>
		</tr>
		<tr style="height: 40; ">
			<td colspan="2">
				<button onclick="location.href='memberUpdateform.jsp?id=<%=mBean.getId() %>'">수정버튼</button>&nbsp;&nbsp;
				<button onclick="location.href='memberDeleteform.jsp?id=<%=mBean.getId() %>'">삭제버튼</button>&nbsp;&nbsp;
				<button onclick="location.href='memberList.jsp?'">회원정보조회</button>&nbsp;&nbsp;
				<button onclick="location.href='memberJoinform.jsp?'">회원가입</button>
			</td>
		</tr>
	</table>

</div>
</body>
</html>