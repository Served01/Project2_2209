<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="BKRV.book.bkDAO"%>
<%@ page import="BKRV.book.bkBean"%>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %> <!-- request 대신 -->
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %> <!-- 파일이름 중복을 피할 수 있도록 -->
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 입력 정보 저장</title>
</head>

<body>
<%
	// 책 이미지 파일을 저장하는 부분
	// location에 해당하는 위치에 폴더를 만들어야 한다. 사용자마다 폴더를 지정을 해 주어야함. 즉, 입력값으로 하는 것이 좋을 듯
	String location	= "E:\\Github_WS\\Project2_2209\\bookReviewProgram\\src\\main\\webapp\\image";//사진이 저장될 경로
	String filename = "";
	MultipartRequest imageUp = null;
	
	int maxSize = 5 * 1024 * 1024; //한번에 업로드될 최대 용량

	try{
	//파일업로드를 직접적으로 담당
	imageUp = new MultipartRequest(request, location, maxSize, "utf-8", new DefaultFileRenamePolicy());//파일 이름이 중복되지 않게해주는 역활

	//전송한 파일 정보를 가져와 출력한다
	Enumeration <?> files = imageUp.getFileNames();
	
	//파일 정보가 있다면
	while(files.hasMoreElements()){
	//input 태그의속성이 file인 태그의 name 속성값 : 파라미터 이름
	String name = (String)files.nextElement();
	
	//서버에 저장된 파일 이름
	filename = imageUp.getFilesystemName(name);
	
	}
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
%>
	<!-- 책 상세정보를 DB에 올리는 기능 -->
	<jsp:useBean id="bBean" class="BKRV.book.bkBean" scope="page">
		
	</jsp:useBean>	
<%
	String bk_number = imageUp.getParameter("bk_number");
	String bk_title = imageUp.getParameter("bk_title");
	String bk_writer = imageUp.getParameter("bk_writer");
	String bk_publisher = imageUp.getParameter("bk_publisher");
	String bk_pubdate = imageUp.getParameter("bk_pubdate");
	String bk_image = imageUp.getParameter("bk_image");
	String bk_local = imageUp.getParameter("bk_local");
	String bk_genre = imageUp.getParameter("bk_genre");
	String bk_ebook = imageUp.getParameter("bk_ebook");
	String bk_detail = imageUp.getParameter("bk_detail");
	
	bBean.setBk_number(Integer.parseInt(bk_number));
	bBean.setBk_title(bk_title);
	bBean.setBk_writer(bk_writer);
	bBean.setBk_publisher(bk_publisher);
	bBean.setBk_pubdate(bk_pubdate);
	bBean.setBk_image(filename);
	bBean.setBk_local(Integer.parseInt(bk_local));
	bBean.setBk_genre(Integer.parseInt(bk_genre));
	bBean.setBk_ebook(Integer.parseInt(bk_ebook));
	bBean.setBk_detail(bk_detail);
	
	bkDAO bdao = new bkDAO();
	bdao.insertBook(bBean);
	
	//response.sendRedirect("mainsession.jsp");

%>
</body>
</html>