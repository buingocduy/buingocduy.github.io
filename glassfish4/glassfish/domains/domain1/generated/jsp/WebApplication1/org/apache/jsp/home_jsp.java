package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import context.DBContext;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setHeader("X-Powered-By", "JSP/2.3");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("  <title> MOWO - MOTO WORLD </title>\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("  <!-- Bootstrap core CSS -->\n");
      out.write("  <link href=\"CSS/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("  <!-- Custom styles for this template -->\n");
      out.write("  <link href=\"CSS/shop-homepage.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <!-- Navigation -->\n");
      out.write("  <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">  MOWO <i class=\"fa fa-motorcycle logo-icon\"></i> </a>\n");
      out.write("      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("      </button>\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("        <ul class=\"navbar-nav ml-auto\">\n");
      out.write("          <li class=\"nav-item\">           \n");
      out.write("            ");
{
                if(session.getAttribute("user") != null)
                {
                   out.print("<i class='nav-link'> " + session.getAttribute("user") +"</i> ");                
                }
            }
      out.write("\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item active\">\n");
      out.write("            <a class=\"nav-link\" href=\"#\">TRANG CHỦ\n");
      out.write("              <span class=\"sr-only\">(current)</span>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"#\"> DỊCH VỤ </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            ");
{
              if(session.getAttribute("user") == null)
              {
                out.print("<a class='nav-link' href='loginuser.jsp'> ĐĂNG NHẬP </a>");   
              }else if(session.getAttribute("user") != null){
                out.print("<a class='nav-link' href='LogoutACCControl'  name='OUT'> ĐĂNG XUẤT </a>");  
              }
            }
      out.write("\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"cart.jsp\"> <i class=\"fa fa-shopping-cart\"> </i>  </a>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </nav>\n");
      out.write("\n");
      out.write("  <!-- Page Content -->\n");
      out.write("  <div class=\"container\">\n");
      out.write("\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("        ");

            DBContext conx = new DBContext();
            ResultSet rsx = conx.chondulieu("select * from hang");
            ResultSet rsx1 = conx.chondulieu("select * from hang where id = 1");
            ResultSet rsx2 = conx.chondulieu("select * from hang where not id = 1");
        
      out.write("\n");
      out.write("                                  \n");
      out.write("      <div class=\"col-lg-3\">\n");
      out.write("        <br>\n");
      out.write("        <div class=\"list-group\">\n");
      out.write("            ");

                while(rsx.next()){
            
      out.write("  \n");
      out.write("          <a href=\"sanpham.jsp?hang=");
      out.print(rsx.getString(2));
      out.write("\" class=\"list-group-item\"> <img class=\"d-block img-fluid\" src=\"");
      out.print(rsx.getString(3));
      out.write("\" alt=\"Khong tai duoc\"> </a>\n");
      out.write("          <p> </p>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- /.col-lg-3 -->\n");
      out.write("\n");
      out.write("      <div class=\"col-lg-9\">\n");
      out.write("\n");
      out.write("        <div id=\"carouselExampleIndicators\" class=\"carousel slide my-4\" data-ride=\"carousel\">\n");
      out.write("          <ol class=\"carousel-indicators\">\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\n");
      out.write("          </ol>\n");
      out.write("            \n");
      out.write("          <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("            <div class=\"carousel-item active\"> \n");
      out.write("                ");

                    while(rsx1.next()){
                
      out.write("  \n");
      out.write("                <img class=\"d-block img-fluid\" src=\"");
      out.print(rsx1.getString(3));
      out.write("\" alt=\"First slide\">  \n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("                ");

                    while(rsx2.next()){
                
      out.write(" \n");
      out.write("            <div class=\"carousel-item \">             \n");
      out.write("                <img class=\"d-block img-fluid\" src=\"");
      out.print(rsx2.getString(3));
      out.write("\"  alt=\"Second slide\">                            \n");
      out.write("            </div>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("          </div>\n");
      out.write("        \n");
      out.write("          <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\n");
      out.write("            <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("            <span class=\"sr-only\">Previous</span>\n");
      out.write("          </a>\n");
      out.write("          <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\n");
      out.write("            <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("            <span class=\"sr-only\">Next</span>\n");
      out.write("          </a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("          <div class=\"col-lg-4 col-md-6 mb-4\">\n");
      out.write("            <div class=\"card h-100\">\n");
      out.write("              <a href=\"#\"> <img class=\"card-img-top\" src=\"Hinh/new1.jpg\" alt=\"\"> </a>\n");
      out.write("              \n");
      out.write("              <div class=\"card-footer\">\n");
      out.write("                <h4 class=\"card-title\">\n");
      out.write("                  <a href=\"#\"> HONDA </a>\n");
      out.write("                </h4>\n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("              <div class=\"card-body\">\n");
      out.write("                <h5> GIÁ XE THÁNG 12 </h5>\n");
      out.write("                <p class=\"card-text\">\n");
      out.write("                    Giá xe HONDA mới nhất tại các đại lý Việt Nam\n");
      out.write("                </p> \n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"col-lg-4 col-md-6 mb-4\">\n");
      out.write("            <div class=\"card h-100\">\n");
      out.write("              <a href=\"#\"> <img class=\"card-img-top\" src=\"Hinh/new2.jpg\" alt=\"\"> </a>\n");
      out.write("              \n");
      out.write("              <div class=\"card-footer\">\n");
      out.write("                <h4 class=\"card-title\">\n");
      out.write("                  <a href=\"#\"> SUZUKI </a>\n");
      out.write("                </h4>\n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("              <div class=\"card-body\">\n");
      out.write("                <h5> GIÁ XE THÁNG 12 </h5>\n");
      out.write("                <p class=\"card-text\">\n");
      out.write("                    Giá xe SUZUKI mới nhất tại các đại lý Việt Nam\n");
      out.write("                </p> \n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("            \n");
      out.write("          <div class=\"col-lg-4 col-md-6 mb-4\">\n");
      out.write("            <div class=\"card h-100\">\n");
      out.write("              <a href=\"#\"> <img class=\"card-img-top\" src=\"Hinh/new3.jpg\" alt=\"\"> </a>\n");
      out.write("              \n");
      out.write("              <div class=\"card-footer\">\n");
      out.write("                <h4 class=\"card-title\">\n");
      out.write("                  <a href=\"#\"> YAMAHA </a>\n");
      out.write("                </h4>\n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("              <div class=\"card-body\">\n");
      out.write("                <h5> GIÁ XE THÁNG 12 </h5>\n");
      out.write("                <p class=\"card-text\">\n");
      out.write("                    Giá xe YAMAHA mới nhất tại các đại lý Việt Nam\n");
      out.write("                </p> \n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("          </div>  \n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <!-- /.col-lg-9 -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.row -->\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <!-- /.container -->\n");
      out.write("\n");
      out.write("  <!-- Footer -->\n");
      out.write("  <footer class=\"py-5 bg-dark\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <p class=\"m-0 text-center text-white\">Copyright &copy; MOWO - MOTO WORLD 2020</p>\n");
      out.write("    </div>\n");
      out.write("    <!-- /.container -->\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core JavaScript -->\n");
      out.write("  <script src=\"JS/jquery.min.js\"></script>\n");
      out.write("  <script src=\"JS/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
