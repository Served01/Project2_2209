<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BKRV.review.rvDAO" %>
<%@ page import="BKRV.review.rvBean" %>
<%@ page import="java.util.Vector" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원의 리뷰 목록</title>

</head>
<body>
<%
	int Rv_id = Integer.parseInt(request.getParameter("Rv_id"));
	//ID? Number?
	rvDAO rdao = new rvDAO();
	Vector<rvBean> vec = rdao.allmemberselectReview(Rv_id);
	
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
		
		rvBean rBean = vec.get(i);
	%>
	<tr height="40" align="center">
		<%-- <td><a href="memberDetail.jsp?id=<%=rBean.getRv_id() %>"><%=rBean.getRv_id() %></a></td> --%>
		<td><%=rBean.getRv_number() %></td>
		<td><%=rBean.getRv_bknumber() %></td>
		<td><%=rBean.getRv_id() %></td>
		<td><%=rBean.getRv_date() %></td>
		<td><%=rBean.getRv_score() %></td>
		<td><%=rBean.getRv_content() %></td>
		<td>
			<button onclick="location.href='rvUpdate.jsp?num=<%=rBean.getRv_number() %>&<%=rBean.getRv_bknumber() %>'">수정하기</button>&nbsp;&nbsp;
			<button onclick="location.href='rvDelete.jsp?num=<%=rBean.getRv_number() %>&<%=rBean.getRv_bknumber() %>'">삭제하기</button>&nbsp;&nbsp;
				
		<script type="text/javascript">
			
			function update() {
				var result = confirm();
				if(result == true){
					location.href = "rvUpdate.jsp?Rv_num=<%=rBean.getRv_number() %>";
					return true;
				}else{
					return fale;
				}
			}
			
			function delete() {
				var result = confirm();
				if(result == true){
					location.href = "rvDelete.jsp?Rv_num=<%=rBean.getRv_number() %>";
					return true;
				}else{
					return fale;
				}
			}
			
		</script>
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