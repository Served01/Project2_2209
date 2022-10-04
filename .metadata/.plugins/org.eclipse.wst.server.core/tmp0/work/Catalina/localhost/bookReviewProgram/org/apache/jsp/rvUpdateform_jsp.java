/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-10-04 02:17:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BKRV.review.rvDAO;
import BKRV.review.rvBean;
import BKRV.book.bkDAO;
import BKRV.book.bkBean;

public final class rvUpdateform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("BKRV.book.bkDAO");
    _jspx_imports_classes.add("BKRV.book.bkBean");
    _jspx_imports_classes.add("BKRV.review.rvBean");
    _jspx_imports_classes.add("BKRV.review.rvDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
	request.setCharacterEncoding("UTF-8");	
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/updateform.css\">\n");
      out.write("<title>리뷰 수정 페이지</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
	String id = (String)session.getAttribute("id");

	if(id.equals(request.getParameter("mb_id")) || id.equals("admin")){

	int rv_number= Integer.parseInt(request.getParameter("rv_number"));
	int rv_bknumber= Integer.parseInt(request.getParameter("rv_bknumber")); 
	String rv_id = (String)session.getAttribute("id");
	
	rvDAO rdao = new rvDAO();
	rvBean rbean = rdao.updateOneSelectReview(rv_number, rv_bknumber, rv_id);
	double bk_score = rdao.getScore(rv_bknumber);
	
	bkDAO bdao = new bkDAO();
	bkBean bBean = bdao.selectBook(rv_bknumber);
	

      out.write("\n");
      out.write("<table border=\"1\" class = \"update\">\n");
      out.write("	<tr align = \"center\">\n");
      out.write("		<td rowspan=\"6\"><div style=\"height:100%; width:100%;\"><img src=\"/image/");
      out.print(bBean.getBk_image());
      out.write("\" height=\"100%\" width=\"100%\"></div></td>\n");
      out.write("		<td>일련번호</td>\n");
      out.write("		<td>");
      out.print(bBean.getBk_number());
      out.write("</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr align = \"center\">\n");
      out.write("		<!-- <td> rowspan=6 -->\n");
      out.write("		<td>제목</td>\n");
      out.write("		<td>");
      out.print(bBean.getBk_title());
      out.write("</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr align = \"center\">\n");
      out.write("		<!-- <td> rowspan=6 -->\n");
      out.write("		<td>저자</td>\n");
      out.write("		<td>");
      out.print(bBean.getBk_writer());
      out.write("</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr align = \"center\">\n");
      out.write("		<!-- <td> rowspan=6 -->\n");
      out.write("		<td>출판사</td>\n");
      out.write("		<td>");
      out.print(bBean.getBk_publisher());
      out.write("</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr align = \"center\">\n");
      out.write("		<!-- <td> rowspan=6 -->\n");
      out.write("		<td>출간일</td>\n");
      out.write("		<td>");
      out.print(bBean.getBk_pubdate());
      out.write("</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr align = \"center\">\n");
      out.write("		<!-- <td> rowspan=6 -->\n");
      out.write("		<td>지역</td>\n");
      out.write("		<td>\n");
      out.write("		");
 
		if(bBean.getBk_local()==0){ 
      out.write("\n");
      out.write("		국내도서\n");
      out.write("		");
} 
		else if(bBean.getBk_local()==1){ 
      out.write("\n");
      out.write("		해외도서\n");
      out.write("		");
}; 
		
		
      out.write("\n");
      out.write("		</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr align=\"center\">\n");
      out.write("		<td rowspan=\"2\">평점:&nbsp;\n");
      out.write("		");
if(bk_score==0){
      out.write("\n");
      out.write("			등록된 평점이 없습니다.\n");
      out.write("		");

		} else { 
      out.write("\n");
      out.write("			");
      out.print(bk_score);
      out.write("점\n");
      out.write("		");
}
      out.write("</td>\n");
      out.write("		<td>장르</td>\n");
      out.write("		<td>\n");
      out.write("		");
if(bBean.getBk_genre()==0){
      out.write("	\n");
      out.write("			문학		\n");
      out.write("		");
}
		
		else if(bBean.getBk_genre()==1){
      out.write("\n");
      out.write("			역사\n");
      out.write("		");
} 
		else if(bBean.getBk_genre()==2){
      out.write("\n");
      out.write("			소설\n");
      out.write("		");
} 
		else if(bBean.getBk_genre()==3){
      out.write("\n");
      out.write("			만화\n");
      out.write("		");
}
		else if(bBean.getBk_genre()==4){
      out.write("\n");
      out.write("			기타\n");
      out.write("		");
} 
		
      out.write("\n");
      out.write("		</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr align=\"center\">\n");
      out.write("		<!-- <td> rowspan=2 -->\n");
      out.write("		<td>ebook 유무</td>\n");
      out.write("		<td>\n");
      out.write("		");
if(bBean.getBk_ebook()==0){ 
      out.write("\n");
      out.write("			O\n");
      out.write("		");
}
		else if(bBean.getBk_ebook()==1){
      out.write("\n");
      out.write("			X\n");
      out.write("		");
} 
      out.write("\n");
      out.write("		</td>\n");
      out.write("	</tr>\n");
      out.write("	<!-- 작성일 sysdate 처리 -->\n");
      out.write("	<tr align=\"center\">\n");
      out.write("		<td colspan=\"3\">\n");
      out.write("			<textarea rows=\"10\" cols=\"74\" name=\"bk_detail\" style =\"resize:none\">");
      out.print(bBean.getBk_detail());
      out.write("</textarea>\n");
      out.write("		</td>\n");
      out.write("	</tr>\n");
      out.write("</table>\n");
      out.write("<hr>\n");
      out.write("	<h2 align=\"center\">리뷰 수정</h2>\n");
      out.write("<form action=\"rvUpdatePro.jsp\" method=\"post\">\n");
      out.write("	<table border=\"1\" class = \"update\">\n");
      out.write("		<tr align=\"center\">\n");
      out.write("			<td>리뷰 작성자</td>\n");
      out.write("			<td>");
      out.print(rbean.getRv_id() );
      out.write("</td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align=\"center\">\n");
      out.write("			<td>평점</td>\n");
      out.write("			<td>\n");
      out.write("			");
if(rbean.getRv_score()==1){ 
      out.write("\n");
      out.write("			1점<input type=\"radio\" name=\"rv_score\" value=1 checked=\"checked\" />\n");
      out.write("			2점<input type=\"radio\" name=\"rv_score\" value=2 />\n");
      out.write("			3점<input type=\"radio\" name=\"rv_score\" value=3 />\n");
      out.write("			4점<input type=\"radio\" name=\"rv_score\" value=4 />\n");
      out.write("			5점<input type=\"radio\" name=\"rv_score\" value=5 />\n");
      out.write("			");
}
			else if(rbean.getRv_score()==2){
      out.write("\n");
      out.write("			1점<input type=\"radio\" name=\"rv_score\" value=1 />\n");
      out.write("			2점<input type=\"radio\" name=\"rv_score\" value=2 checked=\"checked\" />\n");
      out.write("			3점<input type=\"radio\" name=\"rv_score\" value=3 />\n");
      out.write("			4점<input type=\"radio\" name=\"rv_score\" value=4 />\n");
      out.write("			5점<input type=\"radio\" name=\"rv_score\" value=5 />\n");
      out.write("			");
}
			else if(rbean.getRv_score()==3){
      out.write("\n");
      out.write("			1점<input type=\"radio\" name=\"rv_score\" value=1 />\n");
      out.write("			2점<input type=\"radio\" name=\"rv_score\" value=2 />\n");
      out.write("			3점<input type=\"radio\" name=\"rv_score\" value=3 checked=\"checked\" />\n");
      out.write("			4점<input type=\"radio\" name=\"rv_score\" value=4 />\n");
      out.write("			5점<input type=\"radio\" name=\"rv_score\" value=5 />\n");
      out.write("			");
}
			else if(rbean.getRv_score()==4){
      out.write("\n");
      out.write("			1점<input type=\"radio\" name=\"rv_score\" value=1 />\n");
      out.write("			2점<input type=\"radio\" name=\"rv_score\" value=2 />\n");
      out.write("			3점<input type=\"radio\" name=\"rv_score\" value=3 />\n");
      out.write("			4점<input type=\"radio\" name=\"rv_score\" value=4 checked=\"checked\" />\n");
      out.write("			5점<input type=\"radio\" name=\"rv_score\" value=5 />\n");
      out.write("			");
}
			else if(rbean.getRv_score()==5){
      out.write("\n");
      out.write("			1점<input type=\"radio\" name=\"rv_score\" value=1 />\n");
      out.write("			2점<input type=\"radio\" name=\"rv_score\" value=2 />\n");
      out.write("			3점<input type=\"radio\" name=\"rv_score\" value=3 />\n");
      out.write("			4점<input type=\"radio\" name=\"rv_score\" value=4 />\n");
      out.write("			5점<input type=\"radio\" name=\"rv_score\" value=5 checked=\"checked\" />\n");
      out.write("			");
};
      out.write("\n");
      out.write("			</td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align=\"center\">\n");
      out.write("			<td>내용</td>\n");
      out.write("			<td>\n");
      out.write("			<textarea rows=\"10\" cols=\"67\" name=\"rv_content\"  required >");
      out.print(rbean.getRv_content());
      out.write("</textarea>\n");
      out.write("			</td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align=\"center\">\n");
      out.write("			<td colspan=\"2\"> 				\n");
      out.write("			<input type=\"submit\" class = \"button\" value=\"수정\"/>&nbsp;&nbsp;\n");
      out.write("			<button type=\"button\" class = \"button\" onclick = \"location.href='mainSession.jsp?center=bkSelectPro.jsp&bk_number=");
      out.print(rv_bknumber);
      out.write("'\">취소</button>\n");
      out.write("			<input type=\"hidden\" name=\"rv_number\" value=");
      out.print(rv_number);
      out.write(" />\n");
      out.write("			<input type=\"hidden\" name=\"rv_bknumber\" value=");
      out.print(rv_bknumber);
      out.write(" />\n");
      out.write("			<input type=\"hidden\" name=\"rv_id\" value=");
      out.print(rv_id);
      out.write(" />\n");
      out.write("			</td>\n");
      out.write("		</tr>\n");
      out.write("	</table>\n");
      out.write("</form>\n");
} else{
      out.write("\n");
      out.write("	<script>\n");
      out.write("	alert(\"권한이 없거나 세션이 만료되었습니다.\");\n");
      out.write("	history.go(-1);\n");
      out.write("	</script>\n");
 	} 
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
