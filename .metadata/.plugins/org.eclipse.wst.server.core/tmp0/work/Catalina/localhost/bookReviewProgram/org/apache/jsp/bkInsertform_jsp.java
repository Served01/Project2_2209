/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-09-29 07:59:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BKRV.book.bkDAO;

public final class bkInsertform_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>책 정보 입력 페이지</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("table{\r\n");
      out.write("margin: auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<h2 align = \"center\">책 정보 입력</h2>\r\n");
      out.write("<!-- 책 상세정보 입력 -->\r\n");
      out.write("<form action=\"bkInsertform2.jsp\" method=\"post\">\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("	<tr align = \"center\">\r\n");
      out.write("	\r\n");
      out.write("		<td>일련번호</td>\r\n");
      out.write("		<td><input type=\"text\" name=\"bk_number\" placeholder=\"8자리 일련번호\" required />\r\n");
      out.write("			&nbsp; &nbsp;\r\n");
      out.write("			<button type=\"submit\">중복확인</button></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align = \"center\">\r\n");
      out.write("		<td>제목</td>\r\n");
      out.write("		<td><input type=\"text\" name=\"bk_title\"/></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align = \"center\">\r\n");
      out.write("		<td>저자</td>\r\n");
      out.write("		<td><input type=\"text\" name=\"bk_writer\"/></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align = \"center\">\r\n");
      out.write("		<td>출판사</td>\r\n");
      out.write("		<td><input type=\"text\" name=\"bk_publisher\"/></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align = \"center\">\r\n");
      out.write("		<td>출간일</td>\r\n");
      out.write("		<td><input type=\"date\" name=\"bk_pubdate\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align = \"center\">\r\n");
      out.write("		<td>이미지</td>\r\n");
      out.write("		<td>&nbsp;&nbsp;&nbsp;<input type=\"file\" value=\"파일 선택\" name=\"bk_image\"/></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align = \"center\">\r\n");
      out.write("		<td>지역</td>\r\n");
      out.write("		<td>\r\n");
      out.write("		<input type=\"radio\" name=\"bk_local\" value=\"0\" checked />국내도서\r\n");
      out.write("		&nbsp;&nbsp;\r\n");
      out.write("		<input type=\"radio\" name=\"bk_local\" value=\"1\"/>해외도서\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align=\"center\">\r\n");
      out.write("		<td>장르</td>\r\n");
      out.write("		<td>\r\n");
      out.write("			<select name=\"bk_genre\">\r\n");
      out.write("				<option value=\"0\">--문학--</option>\r\n");
      out.write("				<option value=\"1\">--역사--</option>\r\n");
      out.write("				<option value=\"2\">--소설--</option>\r\n");
      out.write("				<option value=\"3\">--만화--</option>\r\n");
      out.write("				<option value=\"4\">--기타--</option>\r\n");
      out.write("			</select>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align=\"center\">\r\n");
      out.write("		<td>ebook 유무</td>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type=\"radio\" name=\"bk_ebook\" value=\"0\" checked /> O\r\n");
      out.write("			<input type=\"radio\" name=\"bk_ebook\" value=\"1\"/> X\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<!-- 작성일 sysdate 처리 -->\r\n");
      out.write("	<tr align=\"center\">\r\n");
      out.write("		<td>상세 내용</td>\r\n");
      out.write("		<td>\r\n");
      out.write("			<textarea rows=\"10\" cols=\"74\" name=\"bk_detail\" style =\"resize:none\"></textarea></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align=\"center\">\r\n");
      out.write("		<td colspan=\"2\"> 				\r\n");
      out.write("			<button type=\"button\" onclick=\"javascript:alert('일련번호 중복확인을 해주십시오.')\">저장</button>&nbsp;&nbsp;\r\n");
      out.write("			<button type=\"button\" onclick=\"location.href='mainSession.jsp'\">취소</button>\r\n");
      out.write("	</tr>\r\n");
      out.write("		\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
