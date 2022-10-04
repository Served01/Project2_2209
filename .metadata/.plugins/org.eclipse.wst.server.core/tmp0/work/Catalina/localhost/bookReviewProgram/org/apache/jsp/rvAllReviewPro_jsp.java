/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-10-04 02:04:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import BKRV.book.bkDAO;
import BKRV.book.bkBean;
import BKRV.review.rvDAO;
import BKRV.review.rvBean;
import java.util.Vector;

public final class rvAllReviewPro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.sql");
    _jspx_imports_packages.add("javax.naming");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("BKRV.book.bkDAO");
    _jspx_imports_classes.add("java.util.Vector");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
request.setCharacterEncoding("UTF-8");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/updateform.css\">\n");
      out.write("<title>전체 리뷰 조회</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
	String id = (String)session.getAttribute("id");

	if(!id.equals("admin")){

      out.write("\n");
      out.write("	<script>\n");
      out.write("	alert(\"권한이 없거나 세션이 만료되었습니다.\");\n");
      out.write("	history.go(-1);\n");
      out.write("	</script>\n");
 	
   } else {

      out.write("\n");
      out.write("   \n");
      out.write("<!-- 책 리뷰 목록 표시 -->\n");
      out.write("\n");
      out.write("<h2 align=\"center\">전체 리뷰 목록</h2>\n");
      out.write("\n");
      out.write("<input type=\"button\" class = \"button\" value=\"마이페이지\" onclick=\"location.href='mainSession.jsp?center=mbSelectPro.jsp&mb_id=");
      out.print(request.getParameter("mb_id") );
      out.write("'\" />&nbsp;&nbsp;\n");
      out.write("<button class = \"button\" onclick=\"location.href='mainSession.jsp'\">메인 페이지</button>\n");
      out.write("<br><br>\n");
      out.write("\n");


	rvDAO rdao = new rvDAO();
	Vector<rvBean> rvVec = rdao.allselectReview();
	
	if(rvVec.size()==0){

      out.write("\n");
      out.write("		<h2>리뷰 목록이 존재하지 않습니다.</h2>\n");
	}else{
	
	for(int i=0; i < rvVec.size(); i++){
		
		rvBean rbean = rvVec.get(i);
		int bk_number = rbean.getRv_bknumber();
		
		bkDAO bdao = new bkDAO();
		String bk_title = bdao.selecttitleBook(bk_number);
		

      out.write("\n");
      out.write("<table border=\"1\" class = \"update\">\n");
      out.write("	<tr align=\"center\" height=\"230\" width=\"1150\">\n");
      out.write("		<td height=\"10\" width=\"200\">아이디:&nbsp;");
      out.print(rbean.getRv_id() );
      out.write("</td>\n");
      out.write("		<td height=\"10\" width=\"200\">평점:&nbsp;");
      out.print(rbean.getRv_score() );
      out.write("</td>\n");
      out.write("		<td align=\"center\">\n");
      out.write("		<button type=\"button\" onclick=\"location.href='mainSession.jsp?center=bkUpdateform.jsp&bk_number=");
      out.print(bk_number);
      out.write("'\">수정</button>&nbsp;&nbsp;\n");
      out.write("		<button type=\"button\" onclick=\"javascript:deleteConfirm()\">삭제</button>&nbsp;&nbsp;\n");
      out.write("			<script>\n");
      out.write("				function deleteConfirm(){\n");
      out.write("					var rv_number = ");
      out.print(rbean.getRv_number());
      out.write(";\n");
      out.write("					var isDelete = confirm(\"정말로 삭제하시겠습니까?\");\n");
      out.write("					if(isDelete){\n");
      out.write("						location.href = \"rvDeletePro.jsp?rv_number=\"+rv_number;\n");
      out.write("					}\n");
      out.write("				}\n");
      out.write("			</script>\n");
      out.write("		</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr align=\"center\">\n");
      out.write("		<td colspan=\"2\" height=\"10\" width=\"200\">책 제목:&nbsp;");
      out.print(bk_title );
      out.write("</td>\n");
      out.write("		<td>책 일련번호: &nbsp;");
      out.print(bk_number );
      out.write("</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr>\n");
      out.write("		<td colspan=\"3\" height=\"10\" width=\"200\">\n");
      out.write("		등록날짜:&nbsp;");
      out.print(rbean.getRv_date() );
      out.write("\n");
      out.write("		</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr>\n");
      out.write("		<td colspan=\"3\" height=\"200\" width=\"1150\">\n");
      out.write("		");
      out.print(rbean.getRv_content());
      out.write("\n");
      out.write("		</td>\n");
      out.write("	</tr>\n");
      out.write("\n");
} }}
      out.write("\n");
      out.write("</table>\n");
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
