/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-10-04 01:59:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class center_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("	<head>\n");
      out.write("		<meta charset=\"UTF-8\">\n");
      out.write("		<title>공지사항프리뷰</title>\n");
      out.write("		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/center.css\">\n");
      out.write("		<style type=\"text/css\">\n");
      out.write("			\n");
      out.write("		a{ text-decoration: none; }\n");
      out.write("\n");
      out.write("		\n");
      out.write("		.notice{ height: 40px; background-color: #333333; position: relative; top:-50 ;overflow: hidden;   }\n");
      out.write("		.notice h4{ float: left; width: 100px; height: 50px; color: #FFFFFF; font-size: 18px; text-align: center; line-height: 1px; }\n");
      out.write("		.notice ul{ width: 250px; height: 40px; position: absolute; top:0; left: 100px; }\n");
      out.write("		.notice li{ width: 300px; height: 40px; position: relative; }\n");
      out.write("\n");
      out.write("		/* 글자 줄임 - 영역생성 - a는 인라인이라 영역생성X => block으로 변경 */\n");
      out.write("		.notice li a{ display: inline-block; width: 600px; height: 80px; color: #FFFFFF; font-size: 12px; line-height: 10px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; }\n");
      out.write("		.notice li .date{ display: inline-block; position: absolute; right: 0; color: #FFFFFF; font-size: 12px; line-height: 30%; }\n");
      out.write("		.notice .more{ color: #FFFFFF; font-size: 12px; line-height: 40px; position: absolute; right: 20px; }\n");
      out.write("	\n");
      out.write("		\n");
      out.write("		/*이거 지워야함*{ padding: 0; margin: 0; }*/\n");
      out.write("		li{ list-style: none; }\n");
      out.write("\n");
      out.write("		/* hotTopic */\n");
      out.write("		.hotTopic{ width: 920px; height: 300px; margin: 0 auto; }\n");
      out.write("		.hotTopic > div{ width: 300px; height: 300px; float: left; margin-right: 10px; border: 1px solid #666666; box-sizing: border-box; overflow: hidden; }\n");
      out.write("		.hotTopic > .topic03{ margin-right: 0; }\n");
      out.write("\n");
      out.write("		.hotTopic > div > a{ display: block; width: 100%; height: 100%; position: relative; }\n");
      out.write("		.hotTopic > div > a > img{ width: 100%; height: 100%; }\n");
      out.write("\n");
      out.write("		.front{ width: 100%; height: 100%; \n");
      out.write("		position: absolute; top: 0; left: 0; background-color: rgba(0,75,130,0.5); \n");
      out.write("		padding: 25px 20px; box-sizing: border-box; }\n");
      out.write("		.front > *{ display: block; }\n");
      out.write("		.front > img{ width: 50px; height: 50px; margin: 0 auto; margin-bottom: 20px; }\n");
      out.write("		.front .blogName{ text-align: center; font-size: 16px; color: #FFFFFF; font-weight: bold; margin-bottom: 50px; }\n");
      out.write("		.front .descript{ font-size: 12px; color: #FFFFFF; width: 100%; height: 60px; line-height: 20px; overflow: hidden; }\n");
      out.write("		\n");
      out.write("		\n");
      out.write("		\n");
      out.write("		</style>\n");
      out.write("		\n");
      out.write("		<script src=\"js/jquery-1.12.0.min.js\"></script>\n");
      out.write("		<script>\n");
      out.write("			//보드프리뷰\n");
      out.write("			$(document).ready(function(){\n");
      out.write("				//3초마다 ul의 위치값이 -40px\n");
      out.write("				setInterval(function(){\n");
      out.write("					//li한개의 높이를 담는 변수\n");
      out.write("					var h = $('.notice li').height();\n");
      out.write("					\n");
      out.write("					$('.notice ul').animate({\n");
      out.write("						top: '-=' + h\n");
      out.write("					},'fast',function(){ //애니메이트메서드 발생 후 주고 싶은 명령을 담음\n");
      out.write("						$(this).css('top',0);\n");
      out.write("						$('.notice li').first().appendTo('.notice ul');\n");
      out.write("					});\n");
      out.write("				},3000);\n");
      out.write("			});\n");
      out.write("			var slideIndex = 0; //slide index\n");
      out.write("\n");
      out.write("			// HTML 로드가 끝난 후 동작\n");
      out.write("			window.onload=function(){\n");
      out.write("			  showSlides(slideIndex);\n");
      out.write("\n");
      out.write("			  // Auto Move Slide\n");
      out.write("			  var sec = 3000;\n");
      out.write("			  setInterval(function(){\n");
      out.write("			    slideIndex++;\n");
      out.write("			    showSlides(slideIndex);\n");
      out.write("\n");
      out.write("			  }, sec);\n");
      out.write("			}\n");
      out.write("\n");
      out.write("\n");
      out.write("			// Next/previous controls\n");
      out.write("			function moveSlides(n) {\n");
      out.write("			  slideIndex = slideIndex + n\n");
      out.write("			  showSlides(slideIndex);\n");
      out.write("			}\n");
      out.write("\n");
      out.write("			// Thumbnail image controls\n");
      out.write("			function currentSlide(n) {\n");
      out.write("			  slideIndex = n;\n");
      out.write("			  showSlides(slideIndex);\n");
      out.write("			}\n");
      out.write("\n");
      out.write("			function showSlides(n) {\n");
      out.write("\n");
      out.write("			  var slides = document.getElementsByClassName(\"mySlides\");\n");
      out.write("			  var dots = document.getElementsByClassName(\"dot\");\n");
      out.write("			  var size = slides.length;\n");
      out.write("\n");
      out.write("			  if ((n+1) > size) {\n");
      out.write("			    slideIndex = 0; n = 0;\n");
      out.write("			  }else if (n < 0) {\n");
      out.write("			    slideIndex = (size-1);\n");
      out.write("			    n = (size-1);\n");
      out.write("			  }\n");
      out.write("\n");
      out.write("			  for (i = 0; i < slides.length; i++) {\n");
      out.write("			      slides[i].style.display = \"none\";\n");
      out.write("			  }\n");
      out.write("			  for (i = 0; i < dots.length; i++) {\n");
      out.write("			      dots[i].className = dots[i].className.replace(\" active\", \"\");\n");
      out.write("			  }\n");
      out.write("\n");
      out.write("			  slides[n].style.display = \"block\";\n");
      out.write("			  dots[n].className += \" active\";\n");
      out.write("			}\n");
      out.write("			\n");
      out.write("			\n");
      out.write("			$(document).ready(function(){\n");
      out.write("				//초기 상태 - front가 아래로 내려가 있어야 함\n");
      out.write("				$('.front').animate({\n");
      out.write("					top: 220\n");
      out.write("				},0);\n");
      out.write("				$('.front > img').fadeOut(0);\n");
      out.write("				$('.front > .blogName').fadeOut(0);\n");
      out.write("				$('.front > .descript').css({\n");
      out.write("					height: 30,\n");
      out.write("					fontSize: '16px',\n");
      out.write("					lineHeight: '30px'\n");
      out.write("				});\n");
      out.write("\n");
      out.write("				//마우스 오버시 0으로 올라오고 아웃시 220으로 내려감\n");
      out.write("				$('.hotTopic a').hover(function(){\n");
      out.write("					$(this).find('.front').animate({\n");
      out.write("						top: 0\n");
      out.write("					},'fast');\n");
      out.write("					$(this).find('.front > img').fadeIn(0);\n");
      out.write("					$(this).find('.front > .blogName').fadeIn(0);\n");
      out.write("					$(this).find('.front > .descript').css({\n");
      out.write("						height: 60,\n");
      out.write("						fontSize: '12px',\n");
      out.write("						lineHeight: '20px'\n");
      out.write("					});\n");
      out.write("				},function(){\n");
      out.write("					$(this).find('.front').animate({\n");
      out.write("						top: 220\n");
      out.write("					},'fast');\n");
      out.write("					$(this).find('.front > img').fadeOut(0);\n");
      out.write("					$(this).find('.front > .blogName').fadeOut(0);\n");
      out.write("					$(this).find('.front > .descript').css({\n");
      out.write("						height: 30,\n");
      out.write("						fontSize: '16px',\n");
      out.write("						lineHeight: '30px'\n");
      out.write("					});\n");
      out.write("				});\n");
      out.write("			});\n");
      out.write("			\n");
      out.write("			\n");
      out.write("		</script>\n");
      out.write("	</head>\n");
      out.write("	<body>\n");
      out.write("		<div class=\"notice\">\n");
      out.write("			\n");
      out.write("			<ul>\n");
      out.write("				\n");
      out.write("			</ul>\n");
      out.write("			\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		\n");
      out.write("		\n");
      out.write("		  <div class=\"slideshow-container\">\n");
      out.write("\n");
      out.write("      <!-- Full-width images with number and caption text -->\n");
      out.write("      <div class=\"mySlides fade\">\n");
      out.write("        <div class=\"numbertext\">1 / 5</div>\n");
      out.write("        <img src=\"http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/23/61174/kyobo_newbook.jpg\" style=\"width:100%; height:400px\">\n");
      out.write("        <div class=\"text\">ACNE STUDIO</div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"mySlides fade\">\n");
      out.write("        <div class=\"numbertext\">2 / 5</div>\n");
      out.write("        <img src=\"http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/23/69547/eNEWBOOK.jpg\" style=\"width:100%; height:400px\">\n");
      out.write("        <div class=\"text\">ACNE STUDIO</div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"mySlides fade\">\n");
      out.write("        <div class=\"numbertext\">3 / 5</div>\n");
      out.write("        <img src=\"http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/26/66054/newbook.jpg\" style=\"width:100%; height:400px\">\n");
      out.write("        <div class=\"text\">ACNE STUDIO</div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"mySlides fade\">\n");
      out.write("        <div class=\"numbertext\">4 / 5</div>\n");
      out.write("        <img src=\"http://image.kyobobook.co.kr/dwas/images/prom/eBook/2022/0913_sam/bn/bnU_we01.jpg\" style=\"width:100%; height:400px\">\n");
      out.write("        <div class=\"text\">ACNE STUDIO</div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"mySlides fade\">\n");
      out.write("        <div class=\"numbertext\">5 / 5</div>\n");
      out.write("        <img src=\"http://image.kyobobook.co.kr/ink/images/prom/2022/book/220914_bookcat/bnC_w01_f6ce9a.jpg\" style=\"width:100%; height:400px\">\n");
      out.write("        <div class=\"text\">ACNE STUDIO</div>\n");
      out.write("      </div>\n");
      out.write("     \n");
      out.write("\n");
      out.write("      <!-- Next and previous buttons -->\n");
      out.write("      \n");
      out.write("     \n");
      out.write("    </div>\n");
      out.write("    </br>\n");
      out.write("\n");
      out.write("    <!-- The dots/circles -->\n");
      out.write("    <div style=\"text-align:center\">\n");
      out.write("      <span class=\"dot\" onclick=\"currentSlide(0)\"></span>\n");
      out.write("      <span class=\"dot\" onclick=\"currentSlide(1)\"></span>\n");
      out.write("      <span class=\"dot\" onclick=\"currentSlide(2)\"></span>\n");
      out.write("      <span class=\"dot\" onclick=\"currentSlide(3)\"></span>\n");
      out.write("      <span class=\"dot\" onclick=\"currentSlide(4)\"></span>\n");
      out.write("     \n");
      out.write("    </div>\n");
      out.write("		\n");
      out.write("		\n");
      out.write("		<div class=\"hotTopic\">\n");
      out.write("			<div class=\"topic01\">\n");
      out.write("				<a href=\"http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9791158741631&orderClick=JAI\">\n");
      out.write("					<img src=\"image/book2.png\" alt=\"핫토픽01이미지\" />\n");
      out.write("					<div class=\"front\">\n");
      out.write("						<img src=\"http://image.kyobobook.co.kr/images/book/large/631/l9791158741631.jpg\" alt=\"프로필\" />\n");
      out.write("						<span class=\"blogName\">그대만 모르는 비밀 하나</span>\n");
      out.write("						<span class=\"descript\">\n");
      out.write("							“쉿, 아무도 모르는 비밀 하나를 털어놓을게요.가만히 귀 기울여보세요. 세상이 조용히 이렇게 읊조립니다.”\n");
      out.write("						화제작 『나라면 나와 결혼할까?』\n");
      out.write("						</span>\n");
      out.write("					</div>\n");
      out.write("				</a>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"topic02\">\n");
      out.write("				<a href=\"http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9791197647604&orderClick=JAI\">\n");
      out.write("					<img src=\"image/book1.png\" alt=\"핫토픽02이미지\" />\n");
      out.write("					<div class=\"front\">\n");
      out.write("						<img src=\"http://image.kyobobook.co.kr/images/book/large/604/l9791197647604.jpg\" alt=\"프로필\" />\n");
      out.write("						<span class=\"blogName\">나는 당신이 행복했으면 좋겠습니다</span>\n");
      out.write("						<span class=\"descript\">\n");
      out.write("							삶, 사람, 사랑 그 속에서 행복을 쟁취하기 위한 조언「나는 당신이 행복했으면 좋겠습니다」는 \n");
      out.write("							저자가 삶 속에서 사랑과 사람, 그리고 '나'를 대하며 느꼈던 행복에 대한 생각들을 이야기 한다. \n");
      out.write("							\n");
      out.write("						</span>\n");
      out.write("					</div>\n");
      out.write("				</a>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"topic03\">\n");
      out.write("				<a href=\"http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9791191891201&orderClick=JAI\">\n");
      out.write("					<img src=\"image/book3.png\" alt=\"핫토픽03이미지\" />\n");
      out.write("					<div class=\"front\">\n");
      out.write("						<img src=\"http://image.kyobobook.co.kr/images/book/large/201/l9791191891201.jpg\" alt=\"프로필\" />\n");
      out.write("						<span class=\"blogName\">잘될 수밖에 없는 너에게</span>\n");
      out.write("						<span class=\"descript\">\n");
      out.write("							도경완, 드로우앤드류, 이연, 김짠부 강력 추천!\n");
      out.write("							“잘될 줄 알았어, 해낼 줄 알았어!”\n");
      out.write("							50만 독자가 귀 기울이는 작가 최서영의 첫 번째 응원 에세이\n");
      out.write("						</span>\n");
      out.write("					</div>\n");
      out.write("				</a>\n");
      out.write("			</div>\n");
      out.write("		</div>		\n");
      out.write("		\n");
      out.write("	</body>\n");
      out.write("</html>\n");
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
