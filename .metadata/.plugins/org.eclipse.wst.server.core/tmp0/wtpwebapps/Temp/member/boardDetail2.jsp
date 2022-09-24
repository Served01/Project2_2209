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
	
	int ref = Integer.parseInt(request.getParameter("ref"));

	int re_step = Integer.parseInt(request.getParameter("re_step"));

	int re_level = Integer.parseInt(request.getParameter("re_level"));
%>

<h2 align="center">게시글 상세 보기 화면 구현</h2>
		
		<tr style="height: 40; ">
			<td colspan="4">											<!--						글 번호 확인					댓글 여부 확인					몇번째 댓글 확인 						-->
				<button onclick="location.href='boardRewriteform.jsp?num=<%=bBean.getNum()%>&ref<%=bBean.getRef()%>&re_step<%=bBean.getRe_step()%>&re_level<%=bBean.getRe_level()%>'">댓글작성</button>&nbsp;&nbsp;
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