package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Xe1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"JS/xejs.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/xecss.css\" />\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <!--header-->        \n");
      out.write("        <div id=\"header\"> \n");
      out.write("           <div class=\"top-bar\"> </div> <!--thanh do tren-->    \n");
      out.write("           <div id=\"logo-container\"> \n");
      out.write("               <p href=\"hinh.jpg\" onclick=\"hinh()\">\n");
      out.write("               <i class=\"fa fa-motorcycle logo-icon\" id=\"hinh\"></i> <h1> <i> Motoworld  </i> </h1> <!--Logo--> \n");
      out.write("               </p>\n");
      out.write("           </div>\n");
      out.write("           <ul id=\"menu\"> <!--menu-->\n");
      out.write("               <li> <a href=\"index.html\">Home</a> </li> \n");
      out.write("               <li> <a href=\"index.html\" onclick=\"hinh()\">About</a> </li> \n");
      out.write("               <li> <a href=\"Login.html\">Login</a> </li>\n");
      out.write("               <li> <a href=\"cart.html\"> <i class=\"fa fa-shopping-cart\" id=\"cart\"> </i> </a> </li>\n");
      out.write("           </ul>\n");
      out.write("        </div>\n");
      out.write(" \n");
      out.write("<!--body-->            \n");
      out.write("        <div id=\"body\">\n");
      out.write("            \n");
      out.write("    <!--content-->\n");
      out.write("            <div id=\"content\"> \n");
      out.write("                <div class=\"textcontent\"> <center> HONDA </center> </div>\n");
      out.write("                <div class=\"grid\">                   \n");
      out.write("                    <div class=\"rangecontent\">\n");
      out.write("                        <a href=\"\">\n");
      out.write("                            <img src=\"Hinh\\vario.jpg\" height=\"200\" width=\"200\" alt=\"Khong tai duoc\">   \n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"bottomrangecontent\">\n");
      out.write("                            <p class=\"texttitle\"> CLICK 2020 </p> \n");
      out.write("                            <p class=\"textprice\"> 85.000.000VNĐ </p>\n");
      out.write("                            <input type=\"button\" name=\"1\" value=\"Thêm vào vỏ hàng\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"rangecontent\"> \n");
      out.write("                        <a href=\"\">\n");
      out.write("                            <img src=\"Hinh/CB150RST.jpg\" height=\"200\" width=\"200\" alt=\"Khong tai duoc\"> \n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"bottomrangecontent\"> \n");
      out.write("                            <p class=\"texttitle\"> CB150R ST </p>\n");
      out.write("                            <p class=\"textprice\"> 85.000.000VNĐ </p>\n");
      out.write("                            <input type=\"button\" name=\"2\" value=\"Thêm vào vỏ hàng\">\n");
      out.write("                        </div>                         \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"rangecontent\"> \n");
      out.write("                        <a href=\"\">\n");
      out.write("                            <img src=\"Hinh/winnerx.jpg\" height=\"200\" width=\"200\" alt=\"Khong tai duoc\">\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"bottomrangecontent\">\n");
      out.write("                            <p class=\"texttitle\"> Winner X </p>\n");
      out.write("                            <p class=\"textprice\"> 45.000.000VNĐ </p>\n");
      out.write("                            <input type=\"button\" name=\"3\" value=\"Thêm vào vỏ hàng\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"rangecontent\"> \n");
      out.write("                        <a href=\"\">\n");
      out.write("                            <img src=\"Hinh/airblade.jpg\" height=\"200\" width=\"200\" alt=\"Khong tai duoc\"> \n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"bottomrangecontent\">\n");
      out.write("                            <p class=\"texttitle\"> Air Blade </p>\n");
      out.write("                            <p class=\"textprice\"> 55.000.000VNĐ </p>\n");
      out.write("                            <input type=\"button\" name=\"4\" value=\"Thêm vào vỏ hàng\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"rangecontent\"> \n");
      out.write("                        <a href=\"\">\n");
      out.write("                            <img src=\"Hinh/monkey.jpg\" height=\"200\" width=\"200\" alt=\"Khong tai duoc\">\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"bottomrangecontent\">\n");
      out.write("                            <p class=\"texttitle\"> Monkey 2020 </p>\n");
      out.write("                            <p class=\"textprice\"> 84.990.000VNĐ </p>\n");
      out.write("                            <input type=\"button\" name=\"5\" value=\"Thêm vào vỏ hàng\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>    \n");
      out.write("                    <div class=\"rangecontent\">\n");
      out.write("                        <a href=\"\">\n");
      out.write("                            <img src=\"Hinh/SH.jpg\" height=\"200\" width=\"200\" alt=\"Khong tai duoc\"> \n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"bottomrangecontent\">\n");
      out.write("                            <p class=\"texttitle\"> SH 2020 </p>\n");
      out.write("                            <p class=\"textprice\"> 70.990.000VNĐ </p>\n");
      out.write("                            <input type=\"button\" name=\"6\" value=\"Thêm vào vỏ hàng\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>                     \n");
      out.write("                </div>       \n");
      out.write("            </div>  \n");
      out.write("    \n");
      out.write("    <!--sidebar-->        \n");
      out.write("            <div id=\"sidebar\">               \n");
      out.write("                <div class=\"gridsidebar\">  \n");
      out.write("                    <div class=\"rangersidebar\"> \n");
      out.write("                        <img src=\"Hinh/ya.jpg\"  height=\"110\" width=\"220\" alt=\"Khong tai duoc\" onclick=\"hinh()\"> \n");
      out.write("                    </div>             \n");
      out.write("                    <div class=\"rangersidebar\">  \n");
      out.write("                        <img src=\"Hinh/su.jpg\" height=\"110\" width=\"220\" alt=\"Khong tai duoc\" onclick=\"hinh()\"> \n");
      out.write("                    </div>                            \n");
      out.write("                </div>\n");
      out.write("            </div> \n");
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
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
