package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html> \n");
      out.write("    <head> \n");
      out.write("        <title> Moto world </title> \n");
      out.write("        <meta charset=\"UTF-8\"> \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\" type=\"text/javascript\"></script> \n");
      out.write("        <script src=\"JS/Loginjs.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/logincss.css\"/>\n");
      out.write("    </head> \n");
      out.write("    \n");
      out.write("    <body> \n");
      out.write("        \n");
      out.write("<!--header-->        \n");
      out.write("        <div id=\"header\"> \n");
      out.write("           <div class=\"top-bar\"> </div> <!--thanh do tren-->    \n");
      out.write("           <div id=\"logo-container\"> \n");
      out.write("               <a href=\"login.html\"> <p href=\"hinh.jpg\" onclick=\"hinh()\"> </a>\n");
      out.write("               <i class=\"fa fa-motorcycle logo-icon\" id=\"hinh\"></i> <h1> <i> Motoworld  </i> </h1> <!--Logo--> \n");
      out.write("               </p>\n");
      out.write("           </div>           \n");
      out.write("           <ul id=\"menu\"> <!--menu-->\n");
      out.write("               <li><a href=\"home.html\"> Home</a> </li> \n");
      out.write("               <li><a href=\"Login.html\" onclick=\"hinh()\"> About</a> </li> \n");
      out.write("               <li><a href=\"register.html\"> Register</a> </li>\n");
      out.write("               <li> <a href=\"cart.jsp\"> <i class=\"fa fa-shopping-cart\" id=\"cart\"> </i> </a> </li>\n");
      out.write("           </ul>\n");
      out.write("        </div>\n");
      out.write(" \n");
      out.write("<!--body-->            \n");
      out.write("        <div id=\"body\">\n");
      out.write("            \n");
      out.write("    <!--content-->\n");
      out.write("            <div id=\"content\"> \n");
      out.write("                <div class=\"textcontent\"> <center> Login </center> </div> <br> \n");
      out.write("                    <form action=\"LoginADControl\" method=\"post\">\n");
      out.write("                        <div class=\"rangelogin\">\n");
      out.write("                            <div class=\"textlogin\">\n");
      out.write("                            Username: <input type=\"text\" id=\"username\" name=\"username\"> <br> <br>\n");
      out.write("                            Password: <input type=\"password\" id=\"password\" name=\"password\"> <br> <br>\n");
      out.write("                            <input type=\"submit\" value=\"Sign in\"> <br>                                                \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("            </div>\n");
      out.write("    \n");
      out.write("    <!--sidebar-->        \n");
      out.write("            <div id=\"sidebar\">               \n");
      out.write("                <div class=\"gridsidebar\">  \n");
      out.write("                    <div class=\"rangersidebar\">\n");
      out.write("                        <div class=\"thumbnail\">\n");
      out.write("                        <a href=\"honda.jsp\">\n");
      out.write("                            <img src=\"Hinh/honda.jpg\"  height=\"110\" width=\"220\" alt=\"Khong tai duoc\">\n");
      out.write("                        </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>           \n");
      out.write("                    <div class=\"rangersidebar\"> \n");
      out.write("                        <div class=\"thumbnail\">\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                        <img src=\"Hinh/ya.jpg\"  height=\"110\" width=\"220\" alt=\"Khong tai duoc\" onclick=\"hinh()\"> \n");
      out.write("                        </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>             \n");
      out.write("                    <div class=\"rangersidebar\">\n");
      out.write("                        <div class=\"thumbnail\">\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                        <img src=\"Hinh/su.jpg\" height=\"110\" width=\"220\" alt=\"Khong tai duoc\" onclick=\"hinh()\">\n");
      out.write("                        </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>                            \n");
      out.write("                </div>\n");
      out.write("            </div>  \n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("<!--footer-->        \n");
      out.write("        <div id=\"footer\">  \n");
      out.write("            <div class=\"textfooter\">       \n");
      out.write("                    © MOTOWORLD HỒ CHÍ MINH <br>\n");
      out.write("                    Địa chỉ: 475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM <br>\n");
      out.write("                    SĐT: 0904596810 | Email: MTHCM@Gmail.com       \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
