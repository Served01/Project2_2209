<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainsession.jsp</title>
<style>
	body {
		margin: 30px 30px 20px 250px;
	}
</style>
</head>
<body>
<%
	String center = request.getParameter("center");

	if(center == null){
		center = "Center.jsp";
	}
%>

<table border="1" style="align:center width: 800">
	<tr height="150">
		<td align="center" colspan="2">
			<jsp:include page="header.jsp"></jsp:include>
		</td>
	</tr>
	<tr height="150">
		<td align="center" width="150">
			<jsp:include page="left.jsp"></jsp:include>
		</td>
		<td align="center" width="150">
			<jsp:include page="<%=center %>"></jsp:include>
		</td>
	</tr>
	<tr height="150">
		<td align="center" colspan="2">
			<jsp:include page="footer.jsp"></jsp:include>
		</td>
	</tr>

</table>
</body>
</html>