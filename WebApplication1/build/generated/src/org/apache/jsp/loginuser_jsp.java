package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import context.DBContext;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public final class loginuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("     <head> \r\n");
      out.write("        <title> Moto world </title> \r\n");
      out.write("        <meta charset=\"UTF-8\"> \r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\" type=\"text/javascript\"></script> \r\n");
      out.write("        <script src=\"JS/Loginjs.js\" type=\"text/javascript\"> </script> \r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\"> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/registercss.css\"/>\r\n");
      out.write("    </head> \r\n");
      out.write("\r\n");
      out.write("    <body> \r\n");
      out.write("        \r\n");
      out.write("<!--header-->        \r\n");
      out.write("        <div id=\"header\"> \r\n");
      out.write("           <div class=\"top-bar\"> </div> <!--thanh do tren-->    \r\n");
      out.write("           <div id=\"logo-container\"> \r\n");
      out.write("               <i class=\"fa fa-motorcycle logo-icon\" id=\"hinh\"></i> <h1> <i> Motoworld  </i> </h1> <!--Logo--> \r\n");
      out.write("           </div>           \r\n");
      out.write("           <ul id=\"menu\"> <!--menu-->\r\n");
      out.write("               <li><a href=\"home.html\">Trang chủ</a> </li>\r\n");
      out.write("               <li><a href=\"register.jsp\">Đăng ký</a> </li>\r\n");
      out.write("               <li> <a href=\"loginuser.jsp\">Đăng nhập</a> </li>\r\n");
      out.write("               <li> <a href=\"cart.jsp\"> <i class=\"fa fa-shopping-cart\" id=\"cart\"> </i> </a> </li>\r\n");
      out.write("           </ul>\r\n");
      out.write("        </div>\r\n");
      out.write(" \r\n");
      out.write("<!--body-->            \r\n");
      out.write("        <div id=\"body\">\r\n");
      out.write("            \r\n");
      out.write("<!--content-->\r\n");
      out.write("            <div id=\"content\"> \r\n");
      out.write("                <div class=\"textcontent\"> <center> Đăng nhập </center> </div> <br>          \r\n");
      out.write("                <div class=\"rangeregister\">\r\n");
      out.write("                    <form method=\"GET\" action=\"LoginControl\">\r\n");
      out.write("                            Username: <input type=\"text\" id=\"username\" name=\"username\"> <br> <br>\r\n");
      out.write("                            Password: <input type=\"password\" id=\"password\" name=\"password\"> <br> <br>\r\n");
      out.write("                            <input type=\"submit\" value=\"Xác nhận\"> <br> \r\n");
      out.write("                            <p style=\"color: red\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.dangnhap}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </p>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>  \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("<!--sidebar-->        \r\n");
      out.write("            <div id=\"sidebar\">               \r\n");
      out.write("                <div class=\"gridsidebar\">  \r\n");
      out.write("                        <a href=\"honda.jsp\">   \r\n");
      out.write("                            <div class=\"thumbnail\">\r\n");
      out.write("                            <img src=\"Hinh/honda.jpg\"  height=\"150\" width=\"80%\"  style=\"border: 1px solid red\" alt=\"Khong tai duoc\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>                        \r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div class=\"thumbnail\">\r\n");
      out.write("                            <img src=\"Hinh/ya.jpg\"  height=\"150\" width=\"80%\" style=\"border: 1px solid red\" alt=\"Khong tai duoc\" onclick=\"hinh()\">                      \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div class=\"thumbnail\">\r\n");
      out.write("                            <img src=\"Hinh/su.jpg\" height=\"150\" width=\"80%\" style=\"border: 1px solid red\" alt=\"Khong tai duoc\" onclick=\"hinh()\"> \r\n");
      out.write("                            </div> \r\n");
      out.write("                        </a>                               \r\n");
      out.write("                </div>\r\n");
      out.write("            </div> \r\n");
      out.write("        </div> \r\n");
      out.write("\r\n");
      out.write("<!--footer-->        \r\n");
      out.write("        <div id=\"footer\">  \r\n");
      out.write("            <div class=\"textfooter\">       \r\n");
      out.write("                    © MOTOWORLD HỒ CHÍ MINH <br>\r\n");
      out.write("                    Địa chỉ: 475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM <br>\r\n");
      out.write("                    SĐT: 0904596810 | Email: MTHCM@Gmail.com       \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>    \r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
