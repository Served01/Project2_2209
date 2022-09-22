<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.ezen.boardDAO" %>  
<%@ page import="kr.co.ezen.boardBean" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세 보기</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	boardDAO bdao = new boardDAO();
	boardBean bBean = bdao.oneselectboard(num);
	
%>

<h2 align="center">게시글 상세 보기 화면 구현</h2>
<div align="center">
	<table border="1" style="text-align: center; width: 100%;">
		<tr align="center" style="height: 40; background: yellow;">
			<td width="100">번호</td>
			<td><%=bBean.getNum() %></td>
			<td width="200">조회수</td>
			<td><%=bBean.getReadCount() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="100">작성자</td>
			<td><%=bBean.getWriter() %></td>
			<td width="200">전자우편</td>
			<td><%=bBean.getEmail() %></td>
		</tr>		
		<tr align="center" style="height: 40; background: yellow;">
			<td width="100">작성일자</td>
			<td><%=bBean.getReg_date() %></td>
			<td width="200">제목</td>
			<td><%=bBean.getSubject() %></td>
		</tr>
		<tr align="center" style="height: 40; background: yellow;">
			<td width="80">내용</td>
			<td colspan="3"><%=bBean.getContent() %></td>
		</tr>
		
		<tr style="height: 40; ">
			<td colspan="4">											<!--						글 번호 확인					댓글 여부 확인					몇번째 댓글 확인 						-->
				<button onclick="location.href='boardRewriteform.jsp?num=<%=bBean.getNum()%>&ref=<%=bBean.getRef()%>&re_step=<%=bBean.getRe_step()%>&re_level=<%=bBean.getRe_level()%>'">댓글작성</button>&nbsp;&nbsp;
				<button onclick="location.href='boardUpdateform.jsp?num=<%=bBean.getNum() %>'">수정하기</button>&nbsp;&nbsp;
				<button onclick="location.href='boardDeleteform.jsp?num=<%=bBean.getNum() %>'">삭제하기</button>&nbsp;&nbsp;
				<button onclick="location.href='boardList.jsp'">목록조회</button>&nbsp;&nbsp;
				<button onclick="location.href='boardwriteform.jsp'">글쓰기</button>
			</td>
		</tr>
	</table>

</div>
</body>
</html>