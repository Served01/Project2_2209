<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BKRV.member.mbDAO"%>
<%@ page import="BKRV.member.mbBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정 화면</title>
</head>
<body>
<%
	String id = request.getParameter("mb_id");

	mbDAO mdao = new mbDAO();
	mbBean mBean = mdao.oneselectmember(id);
%>
	<h2 align="center">비밀번호 수정 화면</h2>
	<form action="mbPassPro.jsp" method="post">
		<div align="center">
			<table border="1" style="text-align: center; width: 25%;">
				<tr align="center" style="height: 100; background: grey;">
					<td width="100">아이디</td>
					<td><%=mBean.getMb_id()%></td>
				</tr>
				<tr align="center" style="height: 40; background: yellow;">
					<td width="120">비밀번호</td>
					<td><input type="password" id="mb_pw" name="mb_pw"></td>
				</tr>
				<tr align="center" style="height: 40; background: yellow;">
					<td width="120">비밀번호 확인</td>
					<td><input type="password" id="mb_pw2" name="mb_pw2"></td>
				</tr>
				<tr style="height: 40;">
					<td colspan="2"><input type="hidden" name="mb_id" value="<%=mBean.getMb_id()%>">
						 <input type="submit" value="비밀번호 변경하기">&nbsp;&nbsp;
						 <input type="button" value="회원정보조회" onclick="location.href='mbList.jsp?'" />
						 <button type="button" onclick="javascript:history.go(-1)">뒤로가기</button>
				   </td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>