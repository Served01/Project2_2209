/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-10-04 00:50:13 UTC
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
import java.io.File;
import java.util.Enumeration;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public final class bkUpdatePro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("BKRV.book.bkBean");
    _jspx_imports_classes.add("java.util.Enumeration");
    _jspx_imports_classes.add("com.oreilly.servlet.multipart.DefaultFileRenamePolicy");
    _jspx_imports_classes.add("java.io.File");
    _jspx_imports_classes.add("com.oreilly.servlet.MultipartRequest");
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write(" <!-- request ?????? -->\n");
      out.write(" <!-- ???????????? ????????? ?????? ??? ????????? -->\n");
request.setCharacterEncoding("UTF-8");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>??? ?????? ??????</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<body>\n");

	// ??? ????????? ????????? ???????????? ??????
	// location??? ???????????? ????????? ????????? ???????????? ??????. ??????????????? ????????? ????????? ??? ????????????. ???, ??????????????? ?????? ?????? ?????? ???
	//????????? ????????? ??????
	String location	= "C:\\image";
	// ?????? ????????? ??????: "D:\\?????????\\Github\\Project2\\bookReviewProgram\\src\\main\\webapp\\image";
	// ??? ????????? ??????: "E:\\Github_WS\\Project2_2209\\bookReviewProgram\\src\\main\\webapp\\image";
	String filename = "";
	MultipartRequest imageUp = null;
	
	int maxSize = 5 * 1024 * 1024; //????????? ???????????? ?????? ??????

	try{
	//?????????????????? ??????????????? ??????
	imageUp = new MultipartRequest(request, location, maxSize, "utf-8", new DefaultFileRenamePolicy());//?????? ????????? ???????????? ??????????????? ??????

	//????????? ?????? ????????? ????????? ????????????
	Enumeration <?> files = imageUp.getFileNames();
	
	//?????? ????????? ?????????
	while(files.hasMoreElements()){
	//input ?????????????????? file??? ????????? name ????????? : ???????????? ??????
	String name = (String)files.nextElement();
	
	//????????? ????????? ?????? ??????
	filename = imageUp.getFilesystemName(name);
	
	}
	
	}catch(Exception e){
		e.printStackTrace();
	}
	

      out.write("\n");
      out.write("<!-- bean??? ?????? ?????? ?????? ?????? ????????? ?????? ?????? -->\n");
      BKRV.book.bkBean bBean = null;
      bBean = (BKRV.book.bkBean) _jspx_page_context.getAttribute("bBean", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (bBean == null){
        bBean = new BKRV.book.bkBean();
        _jspx_page_context.setAttribute("bBean", bBean, javax.servlet.jsp.PageContext.PAGE_SCOPE);
        out.write('\n');
        out.write('	');
        out.write('	');
        org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("bBean"), request);
        out.write('	');
        out.write('	');
        out.write('\n');
      }
      out.write('\n');
      out.write('\n');

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
	bdao.updateBook(bBean);
	
	if (bdao.selectcheckBook(Integer.parseInt(bk_number))==1){
		
      out.write("\n");
      out.write("		<script>\n");
      out.write("			alert(\"??? ????????? ?????????????????????.\");\n");
      out.write("			location.href=\"mainSession.jsp?center=bkSelectPro.jsp&bk_number=");
      out.print(bk_number);
      out.write("\";\n");
      out.write("		</script>\n");
      out.write("		");
} else{ 
      out.write("\n");
      out.write("		<script>\n");
      out.write("			alert(\"??? ????????? ???????????? ??????????????????./n?????? ????????? ????????????.\");\n");
      out.write("			history.go(-1);\n");
      out.write("		</script>\n");
      out.write("		");
} 
      out.write("\n");
      out.write("	\n");
      out.write("%>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
