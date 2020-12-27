package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import context.DBContext;

public final class sanpham_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("  <meta name=\"description\" content=\"\">\r\n");
      out.write("  <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("  <title> MOWO - MOTO WORLD </title>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("  <!-- Bootstrap core CSS -->\r\n");
      out.write("  <link href=\"CSS/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <!-- Custom styles for this template -->\r\n");
      out.write("  <link href=\"CSS/shop-homepage.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <!-- Navigation -->\r\n");
      out.write("  <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">  MOWO <i class=\"fa fa-motorcycle logo-icon\"></i> </a>\r\n");
      out.write("      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("      </button>\r\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("        <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("          <li class=\"nav-item\">           \r\n");
      out.write("            ");
{
                if(session.getAttribute("user") != null)
                {
                   out.print("<i class='nav-link'> " + session.getAttribute("user") +"</i> ");                
                }
            }
      out.write("\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item active\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"home.jsp\">TRANG CHỦ\r\n");
      out.write("              <span class=\"sr-only\">(current)</span>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"#\"> DỊCH VỤ </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            ");
{
              if(session.getAttribute("user") == null)
              {
                out.print("<a class='nav-link' href='loginuser.jsp'> ĐĂNG NHẬP </a>");   
              }else if(session.getAttribute("user") != null){
                out.print("<a class='nav-link' href='LogoutACCControl'  name='OUT'> ĐĂNG XUẤT </a>");  
              }
            }
      out.write("\r\n");
      out.write("            \r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"cart.jsp\"> <i class=\"fa fa-shopping-cart\"> </i>  </a>\r\n");
      out.write("          </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("\r\n");
      out.write("  <!-- Page Content -->\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        ");

            String hang = request.getParameter("hang");
            DBContext conx = new DBContext();
            ResultSet rsx = conx.chondulieu("select * from hang");
            ResultSet rsx1 = conx.chondulieu("select * from hang where tenhang = '"+hang+"'");
        
      out.write("\r\n");
      out.write("                                  \r\n");
      out.write("      <div class=\"col-lg-3\">\r\n");
      out.write("        <br>\r\n");
      out.write("        <div class=\"list-group\">\r\n");
      out.write("            ");

                while(rsx.next()){
            
      out.write("  \r\n");
      out.write("           <a href=\"sanpham.jsp?hang=");
      out.print(rsx.getString(2));
      out.write("\" class=\"list-group-item\"> <img class=\"d-block img-fluid\" src=\"");
      out.print(rsx.getString(3));
      out.write("\" alt=\"Khong tai duoc\"> </a>\r\n");
      out.write("          <p> </p>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("                                   \r\n");
      out.write("      <!-- /.col-lg-3 -->\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-lg-9\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"carouselExampleIndicators\" class=\"carousel slide my-4\" data-ride=\"carousel\">\r\n");
      out.write("          <ol class=\"carousel-indicators\">\r\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\r\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\r\n");
      out.write("          </ol>\r\n");
      out.write("            \r\n");
      out.write("          <div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("            <div class=\"carousel-item active\">\r\n");
      out.write("            ");

               while(rsx1.next()){
               out.print("<img class='d-block img-fluid' src="+rsx1.getString(3)+" alt='First slide'>");
               }
            
      out.write("               \r\n");
      out.write("            </div>          \r\n");
      out.write("          </div>\r\n");
      out.write("            \r\n");
      out.write("          <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("            <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("            <span class=\"sr-only\">Previous</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("            <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("            <span class=\"sr-only\">Next</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"row\">  \r\n");
      out.write("                    ");
     
                        DBContext cxn = new DBContext();;
                        ResultSet rx = cxn.chondulieu("select * from sanpham where tenhang = '"+ hang +"'");
                    
      out.write("\r\n");
      out.write("                    ");

                       while(rx.next()){
                    
      out.write("                \r\n");
      out.write("          <div class=\"col-lg-4 col-md-6 mb-4\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("                <div class=\"thumbnail\">\r\n");
      out.write("              <a href=\"Xe1.jsp?id=");
      out.print(rx.getString(1));
      out.write("\"> <img class=\"card-img-top\" src=");
      out.print(rx.getString(4));
      out.write("  height=\"200\" alt=\"khongtaiduoc\"> </a>\r\n");
      out.write("                </div>\r\n");
      out.write("              <div class=\"card-footer\">\r\n");
      out.write("                <h4 class=\"card-title\">  ");
      out.print(rx.getString(2));
      out.write(" </h4>\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("              <div class=\"card-body\">\r\n");
      out.write("                <h5> ");
      out.print(rx.getString(3));
      out.write(" $ </h5>\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("                      \r\n");
      out.write("                    ");

                        }
                    
      out.write(" \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- /.col-lg-9 -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- /.container -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Footer -->\r\n");
      out.write("  <footer class=\"py-5 bg-dark\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <p class=\"m-0 text-center text-white\">Copyright &copy; MOWO - MOTO WORLD 2020</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.container -->\r\n");
      out.write("  </footer>\r\n");
      out.write("\r\n");
      out.write("  <!-- Bootstrap core JavaScript -->\r\n");
      out.write("  <script src=\"JS/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"JS/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
