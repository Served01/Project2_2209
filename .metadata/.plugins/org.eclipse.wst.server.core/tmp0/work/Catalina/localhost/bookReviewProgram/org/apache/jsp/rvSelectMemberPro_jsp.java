/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-09-29 00:22:08 UTC
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
import java.util.Vector;

public final class rvSelectMemberPro_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원의 리뷰 목록</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2 align=\"center\">회원리뷰조회</h2>\r\n");

	String Rv_id = "hyun";/*  request.getParameter("Rv_id"); */
	
	String column = "Rv_id";
	String value = Rv_id;
	
	rvDAO rdao = new rvDAO();
	Vector<rvBean> vec = rdao.allmemberselectReview(Rv_id);
	
	
	int pageSize = 5;
	String pageNum = request.getParameter("pageNum");
	
	if(pageNum == null){
		pageNum = "1";
	}
	
	int count = 0;	//전체 글 개수
	int number = 0;	//페이지 넘버링 변수
	
	int currentPage = Integer.parseInt(pageNum);	//현재 페이지 저장
			
	count = rdao.getAllcount(column, value);		//전체 게시글 숫자 저장
	
	//현재 페이지에 보여줄 시작번호 설정과 끝 페이지 설정
	//데이터베이스에서 불러올 시작번호 - 1
	int startRow = (currentPage - 1) * pageSize + 1;	//1page (1 - 1) * 10 + 1 = 1
	int endRow = currentPage * pageSize;				//1page 1 * 10 = 10
	
	vec = rdao.allselectBoard(startRow, endRow, column, value);
	
	number = count - (currentPage - 1) * pageSize;		//테이블에 표시할 번호 설정

      out.write('\r');
      out.write('\n');

	for(int i = 0; i < vec.size(); i++){
		rvBean rBean = vec.get(i);
		
		int bk_number = rBean.getRv_bknumber();
		
		bkDAO bdao = new bkDAO();
		String bk_title = bdao.selecttitleBook(bk_number);
		

      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\" align=\"center\">\r\n");
      out.write("	<tr align=\"center\">\r\n");
      out.write("		<td>닉네임:&nbsp;");
      out.print(rBean.getRv_id() );
      out.write("</td>\r\n");
      out.write("		<td>평점:&nbsp;");
      out.print(rBean.getRv_score() );
      out.write("</td>\r\n");
      out.write("		<td>\r\n");
      out.write("		<button type=\"button\">수정</button>\r\n");
      out.write("		<button type=\"button\">삭제</button>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align=\"center\">\r\n");
      out.write("		<td colspan=\"2\">책 제목:&nbsp;");
      out.print(bk_title );
      out.write("</td>\r\n");
      out.write("		<td>책 일련번호: &nbsp;");
      out.print(bk_number );
      out.write("</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td colspan=\"3\">\r\n");
      out.write("		등록날짜:&nbsp;");
      out.print(rBean.getRv_date() );
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td colspan=\"3\">\r\n");
      out.write("		");
      out.print(rBean.getRv_content());
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("\r\n");
      out.write("	");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("	<!-- 스타트 페이지 -->\r\n");
      out.write("	");

	
	if(count > 0){
		//
		int pagecount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1;
		
		if(currentPage % 10 != 0){
			startPage = (currentPage / 10) * 10 + 1;	
		}else{
			startPage = (currentPage / 10 ) * 10 - 1;
		}
		
		int pageBlock = 10;
		
		int endPage = startPage + pageBlock - 1;
		
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	<div align=\"center\">\r\n");
      out.write("		");

		//[이전] 링크 제작
		if(endPage > pagecount){
			endPage = pagecount;	
		}
		
		if(startPage > 10){
	
      out.write("\r\n");
      out.write("			<a align=\"center\" href=\"mainSession.jsp?center=rvSelectMemberPro.jsp?Rv_id=");
      out.print(Rv_id );
      out.write("&pageNum=");
      out.print(startPage - 10 );
      out.write("\">[previous]</a>\r\n");
      out.write("	");
 
		}
			for(int i = startPage; i <= endPage; i++){
	
      out.write("\r\n");
      out.write("			<a align=\"center\" href=\"mainSession.jsp?center=rvSelectMemberPro.jsp?Rv_id=");
      out.print(Rv_id );
      out.write("&pageNum=");
      out.print(i );
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(i );
      out.write("]</a>\r\n");
      out.write("	");

			}
			
		//[이후] 링크 제작
		if(endPage < pagecount){
			endPage = pagecount;		
	
      out.write("\r\n");
      out.write("			<a align=\"center\" href=\"mainSession.jsp?center=rvSelectMemberPro.jsp?Rv_id=");
      out.print(Rv_id );
      out.write("&pageNum=");
      out.print(startPage + 10 );
      out.write("\">[next]</a>\r\n");
      out.write("	");

		}
	}
	
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
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
