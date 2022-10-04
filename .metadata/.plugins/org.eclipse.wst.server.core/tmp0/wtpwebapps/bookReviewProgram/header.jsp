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
    <link rel="stylesheet" type="text/css" href="css/header.css">
</script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	  <div class="navbar">    
        <div class="navbar_logo">
            <i class="fa-solid fa-book"></i>
            <a href="#" onclick="location.href='mainSession.jsp'">Book Review</a>  
        </div>
        <ul class="navbar_menu">
            <li><a href="http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791188331796&orderClick=LET&Kc=">교보문고</a></li>
            <li><a href="https://www.aladin.co.kr/home/welcome.aspx?partner=googlek&BSCPN=ORM&BSPRG=ADWORDS&BSCCN1=83566&utm_source=ADWORDS&utm_medium=cpc&utm_term=%EB%8F%84%EC%84%9C%EC%82%AC%EC%9D%B4%ED%8A%B8&gclid=EAIaIQobChMI6MbRuOyj-gIVGMFMAh0eQwdZEAAYAiAAEgJUUPD_BwE">알라딘</a></li>
            <li><a href="http://www.yes24.com/Main/default.aspx">YES 24</a></li>
            <li><a href="http://www.readersnews.com/">독서신문</a></li>
            <li><a href="http://www.gulnara.net/">글&nbsp;나라</a></li>
        </ul>
	<form action="mainSession.jsp" method="post">
        <div class="search">
            <input type="text" name="search_word" placeholder="검색어 입력">
            <input type="hidden" name="center" value="bkListPro.jsp"/>
            <button type="submit">검색</button>
        </div>
    </form>
<%if((String)session.getAttribute("id")==null){ %>
    <ul class="navbar_links">
            <a href="#" onclick="location.href='loginForm.jsp'">로그인</a>
            <a href="#" onclick="location.href='mainSession.jsp?center=mbinsertform.jsp'">회원가입</a>
    </ul>
<%} else if((String)session.getAttribute("id")!=null){ %>      
     <ul class="navbar_links">
            <a href="#" onclick="javascript:logoutFunction()">로그아웃</a>
            <script>
				function logoutFunction(){
			
					var isLogout = confirm("정말로 로그아웃하시겠습니까?");
					if(isLogout){
						
						location.href = "logout.jsp";
						
					}
				}
			</script>
            <a href="#" onclick="location.href='mainSession.jsp?center=mbSelectPro.jsp'">마이페이지</a>
     </ul>
<%} %>
    </div>     

  
   
</body>
</html>