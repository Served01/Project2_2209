/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-09-29 06:57:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BKRV.member.mbDAO;

public final class mbInsertform2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("BKRV.member.mbDAO");
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
      out.write('\n');
request.setCharacterEncoding("UTF-8");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>회원가입 페이지</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("table{\n");
      out.write("margin: auto;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<body>\n");


	mbDAO mdao = new mbDAO();
	String mb_id = request.getParameter("mb_id");
	int check = mdao.duplecateMbid(mb_id);
	if(check==1){

      out.write("\n");
      out.write("	<script>\n");
      out.write("	alert(\"이미 존재하는 아이디입니다.\");\n");
      out.write("	history.go(-1);\n");
      out.write("	</script>\n");
 }else{ 
      out.write("\n");
      out.write("	<script>\n");
      out.write("	alert(\"사용 가능한 아이디입니다.\");\n");
      out.write("	</script>\n");
      out.write("\n");
      out.write("<h2 align = \"center\">회원 가입 페이지</h2>\n");
      out.write("\n");
      out.write("<form action = \"mbInsertform2.jsp\" method = \"post\">\n");
      out.write("	<table border = \"1\">\n");
      out.write("		<tr align = \"center\">\n");
      out.write("		\n");
      out.write("			<td>ID</td>\n");
      out.write("			<td><input type=\"text\" name=\"mb_id\" value=\"");
      out.print(mb_id );
      out.write("\" disabled />\n");
      out.write("				&nbsp; &nbsp;\n");
      out.write("				<button type=\"submit\">중복확인</button></td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align = \"center\">\n");
      out.write("			<td>PW</td>\n");
      out.write("			<td><input type = \"password\" name = \"mb_pw\" placeholder=\"pw입력\" required /></td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align = \"center\">\n");
      out.write("			<td>비밀번호 확인</td>\n");
      out.write("			<td><input type = \"password\" name = \"mb_pw2\" placeholder=\"pw입력\" required /></td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align = \"center\">\n");
      out.write("			<td>이름</td>\n");
      out.write("			<td><input type = \"text\" name = \"mb_name\" placeholder=\"이름입력\" required /></td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align = \"center\">\n");
      out.write("			<td>닉네임</td>\n");
      out.write("			<td><input type = \"text\" name = \"mb_nick\" placeholder=\"닉네임입력\" required /></td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align = \"center\">\n");
      out.write("			<td>이메일</td>\n");
      out.write("			<td><input type = \"email\" name = \"mb_email\" placeholder=\"이메일입력\" required /></td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align = \"center\">\n");
      out.write("			<td>전화번호</td>\n");
      out.write("			<td><input type = \"text\" name = \"mb_tel\" placeholder=\"전화번호입력\" required /></td>\n");
      out.write("		</tr>\n");
      out.write("		<tr align=\"center\">\n");
      out.write("			<td>성별</td>\n");
      out.write("			<td>\n");
      out.write("				<input type=\"radio\" name=\"mb_gender\" value=\"1\" checked/>남자\n");
      out.write("				<input type=\"radio\" name=\"mb_gender\" value=\"2\"/>여자				\n");
      out.write("			</td>\n");
      out.write("		</tr>\n");
      out.write("		<tr height = \"40\" align = \"center\">\n");
      out.write("			<td colspan = \"2\">				\n");
      out.write("				<button type=\"submit\">회원가입</button>&nbsp;&nbsp;\n");
      out.write("				<button type=\"button\" onclick=\"location.href='mainSession.jsp'\">취소</button>\n");
      out.write("			</tr>\n");
      out.write("	</table>\n");
      out.write("</form>\n");
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