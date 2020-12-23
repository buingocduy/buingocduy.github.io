package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import context.DBContext;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import IO.PD.ProductIO;

public final class UPD_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("   <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title> Moto world </title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"JS/productjs.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/productcss.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--header-->        \n");
      out.write("        <div id=\"header\"> \n");
      out.write("           <div class=\"top-bar\"> </div> <!--thanh do tren-->    \n");
      out.write("           <div id=\"logo-container\"> \n");
      out.write("               <p href=\"hinh.jpg\" onclick=\"hinh()\">\n");
      out.write("               <i class=\"fa fa-motorcycle logo-icon\" id=\"hinh\"></i> <h1> <i> Motoworld  </i> </h1> <!--Logo--> \n");
      out.write("               </p>\n");
      out.write("           </div>\n");
      out.write("           <ul id=\"menu\"> <!--menu-->\n");
      out.write("               <li> <a href=\"index.html\">Home</a> </li> \n");
      out.write("               <li> <a href=\"admin.jsp\">Account</a> </li> \n");
      out.write("               <li> <a href=\"Login.html\">Logout</a> </li>\n");
      out.write("               <li> <a href=\"cart.html\"> <i class=\"fa fa-shopping-cart\" id=\"cart\"> </i> </a> </li>\n");
      out.write("           </ul>\n");
      out.write("        </div>\n");
      out.write(" \n");
      out.write("<!--body-->            \n");
      out.write("        <div id=\"body\">\n");
      out.write("        \n");
      out.write("    <!--content-->\n");
      out.write("            <div id=\"content\">               \n");
      out.write("                    ");
          
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham where id = 'h1' "); 
                    
      out.write("\n");
      out.write("                    ");

                        while(rs.next()){
                    
      out.write("             \n");
      out.write("                    <div style=\" margin: auto; border: 2px solid black; text-align: center; width: 300px; padding: 20px; height: 300px; overflow:  auto;\">  \n");
      out.write("                    <form action=\"UpdateDPControl\" method=\"get\" align=\"center\">                       \n");
      out.write("                         <input type=\"text\" name=\"id\" placeholder=\"ID\" value=\"");
      out.print(rs.getString(1));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"name\" placeholder=\"Name\" value=\"");
      out.print(rs.getString(2));
      out.write("\"> <br> <br>   \n");
      out.write("                         <input type=\"text\" name=\"price\" placeholder=\"Price\" value=\"");
      out.print(rs.getString(3));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"image\" placeholder=\"Image\" value=\"");
      out.print(rs.getString(4));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"LWH\" placeholder=\"LxWxH\" value=\"");
      out.print(rs.getString(5));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"seat\" placeholder=\"Seat height\" value=\"");
      out.print(rs.getString(6));
      out.write("\"> <br> <br>   \n");
      out.write("                         <input type=\"text\" name=\"tire\" placeholder=\"Front/rear tire\" value=\"");
      out.print(rs.getString(7));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"engine\" placeholder=\"Engine\" value=\"");
      out.print(rs.getString(8));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"cc\" placeholder=\"CC\" value=\"");
      out.print(rs.getString(9));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"power\" placeholder=\"Power\" value=\"");
      out.print(rs.getString(10));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"oil\" placeholder=\"Oil\" value=\"");
      out.print(rs.getString(11));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"gasoline\" placeholder=\"Gasoline\" value=\"");
      out.print(rs.getString(12));
      out.write("\"> <br> <br>   \n");
      out.write("                         <input type=\"text\" name=\"brake\" placeholder=\"Brake\" value=\"");
      out.print(rs.getString(13));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"text\" name=\"gearbox\" placeholder=\"Gearbox\" value=\"");
      out.print(rs.getString(14));
      out.write("\"> <br> <br>  \n");
      out.write("                         <input type=\"submit\" value=\"Update\"> <br>  \n");
      out.write("                    </form>    \n");
      out.write("                    </div>                            \n");
      out.write("                   \n");
      out.write("            </div>  \n");
      out.write("    \n");
      out.write("    <!--sidebar-->        \n");
      out.write("            <div id=\"sidebar\">               \n");
      out.write("                <div class=\"gridsidebar\">  \n");
      out.write("                    <div class=\"rangersidebar1\">  \n");
      out.write("                          <img src=");
      out.print(rs.getString(4));
      out.write(" height=200 width=240 alt=\"Khong tai duoc\">     \n");
      out.write("                    </div>                                                       \n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("        </div> \n");
      out.write("                    ");

                        }
                    
      out.write("\n");
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
