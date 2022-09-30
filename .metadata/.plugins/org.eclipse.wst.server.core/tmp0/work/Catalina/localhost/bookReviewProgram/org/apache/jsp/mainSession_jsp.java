/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-09-30 07:19:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainSession_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Document</title>\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/ece1cdce53.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Pen+Script&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>메인 세션</title>\r\n");
      out.write("<style>\r\n");
      out.write("	\r\n");
      out.write("		table {\r\n");
      out.write("    margin-left:auto; \r\n");
      out.write("    margin-right:auto;\r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("     max-height:100%;\r\n");
      out.write("     background-color:white;\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("		table, td, th {	\r\n");
      out.write("    border-collapse : collapse;\r\n");
      out.write("    border : 1px solid black;\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	\r\n");

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\" height=\"1000px\" width=\"1000px\"style=\"align:center\">\r\n");
      out.write("	<tr height=\"5px\" width=\"300px\">\r\n");
      out.write("		  <td align=\"center\" colspan=\"2\">\r\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr width=\"500px\">\r\n");
      out.write("	 <td align=\"left\" width=\"85\" height=\"100\">\r\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "left.jsp", out, false);
      out.write("\r\n");
      out.write("		</td> \r\n");
      out.write("		<td align=\"center\" width=\"400px\">\r\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, url , out, false);
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr height=\"80\" width=\"150\">\r\n");
      out.write("		<td align=\"center\" colspan=\"2\">\r\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
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
