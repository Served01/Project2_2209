<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="https://kit.fontawesome.com/ece1cdce53.js" crossorigin="anonymous"></script>
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>메인 세션</title>
<style>

html{
background-image:url('https://png.pngtree.com/background/20211215/original/pngtree-the-background-photography-of-the-empty-library-bookstore-indoors-picture-image_1474812.jpg');
}
	
		table {
    margin-left:auto; 
    margin-right:auto;
    	
    
     
   
     background-color:white;
    
}

		table, td, th {	
    border-collapse : collapse;
    border : 1px solid black;
    
    
}


</style>
</head>
<body>
	
<%
	request.setCharacterEncoding("UTF-8");
	String center = request.getParameter("center");
	String bk_local = request.getParameter("bk_local");
	String bk_genre = request.getParameter("bk_genre");
	String search_word = request.getParameter("search_word");
	String bk_number = request.getParameter("bk_number");
	String rv_id = request.getParameter("Rv_id");
	String pageNum = request.getParameter("pageNum");
	String mb_id = request.getParameter("mb_id");
	
	String url = null;
	
	if(center == null){
		
		url = "center.jsp";
		
	} else if(center=="bkListMenuPro.jsp") {
		
		int bk_local2 = Integer.parseInt(bk_local);
		int bk_genre2 = Integer.parseInt(bk_genre);
		url = center+"? bk_local="+bk_local2+" & bk_genre="+bk_genre2;
		
	} else if(center=="bkListPro.jsp"){
		
		url = center+"? search_word='"+search_word+"'";
		
	} else if(center=="bkSelectPro.jsp"){
		
		int bk_number2 = Integer.parseInt(bk_number);
		url = center+"? bk_number="+bk_number2;
		
	} else if(center=="rvSelectMemberPro.jsp"){
		
		int pageNum2 = Integer.parseInt(pageNum);
		
		url = center+"? Rv_id='"+rv_id+"'&pageNum="+pageNum2;
	} else if(center=="mbInsertform.jsp"){
		
		url = center+"? mb_id= '"+mb_id+"'";
	} else if (center=="bkInsertform.jsp"){
		
		int bk_number2 = Integer.parseInt(bk_number);
		url = center+"? bk_number=" +bk_number2;
	}
	
	else {
		
		url = center;
		
	}
%>

<table border="1" height="900px" width="1300px" style="align:center">
	<tr height="100px"width="1300px">
		  <td align="center" width="1300px" colspan="2">
			<jsp:include page="header.jsp"></jsp:include>
		</td>
	</tr>
	<tr height="700px" width="1300px">
	 <td align="left" margin="0" width="100px" height="800px">
			<jsp:include page="left.jsp"></jsp:include>
		</td> 
		<td align="center" width="1200px">
			<div style="background-color:#f7f1e3;height:100%; width:100%"><jsp:include page="<%=url %>"></jsp:include></div>
		</td>
	</tr>
	<tr  width="1300px" height="100px">
		<td align="center" colspan="2">
			<jsp:include page="footer.jsp"></jsp:include>
		</td>
	</tr> 


</table>
</body>
</html>