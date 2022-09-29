/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-09-29 08:15:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/ece1cdce53.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/header.css\">\r\n");
      out.write("</script>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	  <div class=\"navbar\">    \r\n");
      out.write("        <div class=\"navbar_logo\">\r\n");
      out.write("            <i class=\"fa-solid fa-book\"></i>\r\n");
      out.write("            <a href=\"#\" onclick=\"location.href='mainSession.jsp'\">Book Review</a>  \r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"navbar_menu\">\r\n");
      out.write("            <li><a href=\"http://www.kyobobook.co.kr\">교보문고</a></li>\r\n");
      out.write("            <li><a href=\"https://www.aladin.co.kr\">알라딘</a></li>\r\n");
      out.write("            <li><a href=\"http://www.yes24.com/Main/default.aspx\">YES 24</a></li>\r\n");
      out.write("            <li><a href=\"http://www.readersnews.com/\">독서신문</a></li>\r\n");
      out.write("            <li><a href=\"http://www.gulnara.net/\">글&nbsp;나라</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("	<form action=\"mainSession.jsp\" method=\"post\">\r\n");
      out.write("        <div class=\"search\">\r\n");
      out.write("            <input type=\"text\" name=\"search_word\" placeholder=\"검색어 입력\">\r\n");
      out.write("            <input type=\"hidden\" name=\"center\" value=\"bkListPro.jsp\"/>\r\n");
      out.write("            <button type=\"submit\">검색</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
if((String)session.getAttribute("id")==null){ 
      out.write("\r\n");
      out.write("    <ul class=\"navbar_links\">\r\n");
      out.write("            <a href=\"#\" onclick=\"location.href='loginform.jsp'\">로그인</a>\r\n");
      out.write("            <a href=\"#\" onclick=\"location.href='mainSession.jsp?center=mbInsertform.jsp'\">회원가입</a>\r\n");
      out.write("    </ul>\r\n");
} else if((String)session.getAttribute("id")!=null){ 
      out.write("      \r\n");
      out.write("     <ul class=\"navbar_links\">\r\n");
      out.write("            <a href=\"#\" onclick=\"javascript:logoutFunction()\">로그아웃</a>\r\n");
      out.write("            <script>\r\n");
      out.write("				function logoutFunction(){\r\n");
      out.write("			\r\n");
      out.write("					var isLogout = confirm(\"정말로 로그아웃하시겠습니까?\");\r\n");
      out.write("					if(isLogout){\r\n");
      out.write("						\r\n");
      out.write("						location.href = \"logout.jsp\";\r\n");
      out.write("						\r\n");
      out.write("					}\r\n");
      out.write("				}\r\n");
      out.write("			</script>\r\n");
      out.write("            <a href=\"#\" onclick=\"location.href='mainSession.jsp?center=mbSelectPro.jsp'\">마이페이지</a>\r\n");
      out.write("     </ul>\r\n");
} 
      out.write("\r\n");
      out.write("    </div>     \r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("   \r\n");
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
