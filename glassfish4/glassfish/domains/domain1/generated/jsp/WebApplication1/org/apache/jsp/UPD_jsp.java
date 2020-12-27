package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import context.DBContext;

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
      out.write("                ");

                    if(session.getAttribute("user1") == null){
                        response.sendRedirect("loginadmin.html");
                    }
                
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n");
      out.write("        <meta name=\"description\" content=\"\" />\r\n");
      out.write("        <meta name=\"author\" content=\"\" />\r\n");
      out.write("        <title> MOWO - MOTO WORLD </title>\r\n");
      out.write("        <link href=\"CSS/styles.css\" rel=\"stylesheet\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"JS/scripts.js\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"JS/chart-area-demo.js\"></script>\r\n");
      out.write("        <script src=\"JS/chart-bar-demo.js\"></script>\r\n");
      out.write("        <script src=\"JS/chart-pie-demo.js\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    <body class=\"sb-nav-fixed\">\r\n");
      out.write("        <nav class=\"sb-topnav navbar navbar-expand navbar-dark bg-dark\">\r\n");
      out.write("<!--Logo-->             \r\n");
      out.write("           <a class=\"navbar-brand\" href=\"admin.jsp\"> Moto World </a>\r\n");
      out.write("     \r\n");
      out.write("<!--Logout--> \r\n");
      out.write("            <form class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0\">        \r\n");
      out.write("            <ul class=\"navbar-nav ml-auto ml-md-0\">\r\n");
      out.write("                <li class=\"nav-item dropdown\">\r\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" id=\"userDropdown\" href=\"#\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"><i class=\"fas fa-user fa-fw\"></i></a>\r\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"userDropdown\">\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"> Đổi mật khẩu </a>\r\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"LogoutControl\"> Đăng xuất </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            </form>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <!--Menu--> \r\n");
      out.write("        </nav>\r\n");
      out.write("        <div id=\"layoutSidenav\">\r\n");
      out.write("            <div id=\"layoutSidenav_nav\">\r\n");
      out.write("                <nav class=\"sb-sidenav accordion sb-sidenav-dark\" id=\"sidenavAccordion\">\r\n");
      out.write("                    <div class=\"sb-sidenav-menu\">\r\n");
      out.write("                        <div class=\"nav\">\r\n");
      out.write("                            <div class=\"sb-sidenav-menu-heading\"> DANH MỤC </div>\r\n");
      out.write("                            <a class=\"nav-link collapsed\" href=\"product.jsp\" data-toggle=\"collapse\" data-target=\"#collapseLayouts\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\">\r\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-motorcycle\"></i></div>\r\n");
      out.write("                                SẢN PHẨM\r\n");
      out.write("                                <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <div class=\"collapse\" id=\"collapseLayouts\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\">\r\n");
      out.write("                                <nav class=\"sb-sidenav-menu-nested nav\">\r\n");
      out.write("                                    ");

                                        DBContext conx = new DBContext();
                                        ResultSet rsx = conx.chondulieu("select * from hang");
                                    
      out.write("\r\n");
      out.write("                                    ");

                                            while(rsx.next()){
                                    
      out.write("\r\n");
      out.write("                                    <a class=\"nav-link\" href=\"product.jsp?hang=");
      out.print(rsx.getString(2));
      out.write('"');
      out.write('>');
      out.print(rsx.getString(2));
      out.write("</a>\r\n");
      out.write("                                    ");

                                            }
                                    
      out.write("\r\n");
      out.write("                                </nav>\r\n");
      out.write("                            </div> \r\n");
      out.write("                            \r\n");
      out.write("                            <a class=\"nav-link\" href=\"hangxe.jsp\">\r\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-warehouse\"></i></div>\r\n");
      out.write("                                HÃNG XE\r\n");
      out.write("                            </a> \r\n");
      out.write("                                \r\n");
      out.write("                            <a class=\"nav-link\" href=\"user.jsp\">\r\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-users\"></i></div>\r\n");
      out.write("                                TÀI KHOẢN\r\n");
      out.write("                            </a>  \r\n");
      out.write("                            \r\n");
      out.write("                            <a class=\"nav-link\" href=\"donhang.jsp\">\r\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-boxes\"></i></div>\r\n");
      out.write("                                ĐƠN HÀNG\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"sb-sidenav-footer\">\r\n");
      out.write("                        <div class=\"small\">Logged in as:</div>\r\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("<!--Content-->                     \r\n");
      out.write("            <div id=\"layoutSidenav_content\">\r\n");
      out.write("                    ");
 
                        String id = request.getParameter("id");
                        DBContext con = new DBContext();;
                        ResultSet rx = con.chondulieu("select * from hang"); 
                        ResultSet rs = con.chondulieu("select * from sanpham where id='" + id + "'"); 
                    
      out.write("\r\n");
      out.write("                    <form action=\"UpdateDPControl\" method=\"get\">\r\n");
      out.write("                <main>\r\n");
      out.write("                    <div class=\"container-fluid\">\r\n");
      out.write("                        <h1 class=\"mt-4\"> SỬA SẢN PHẨM </h1>\r\n");
      out.write("                        <ol class=\"breadcrumb mb-4\">\r\n");
      out.write("                            <li class=\"breadcrumb-item\"><a href=\"admin.jsp\"> DANH MỤC </a></li>\r\n");
      out.write("                            ");

                                while(rs.next()){
                            
      out.write("\r\n");
      out.write("                            <li class=\"breadcrumb-item active\"> <a href=\"product.jsp?hang=");
      out.print(rs.getString(15));
      out.write("\"> SẢN PHẨM ");
      out.print(rs.getString(15));
      out.write(" </a></li>\r\n");
      out.write("                           \r\n");
      out.write("                            <li class=\"breadcrumb-item active\"> SỬA SẢN PHẨM </li>\r\n");
      out.write("                        </ol>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"card mb-4\">\r\n");
      out.write("                            <div class=\"card-header\">\r\n");
      out.write("                                <i class=\"fas fa-motorcycle\"></i>\r\n");
      out.write("                                Dữ liệu sản phẩm\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <div class=\"table-responsive\">\r\n");
      out.write("                                    <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\r\n");
      out.write("                                        <thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <th> Hãng </th>\r\n");
      out.write("                                                <th> Hình ảnh</th>\r\n");
      out.write("                                                <th> Tên sản phẩm</th>\r\n");
      out.write("                                                <th> Giá</th>                         \r\n");
      out.write("                                                <th> Dài Rộng Cao</th>\r\n");
      out.write("                                                <th> Chiều cao yên </th>\r\n");
      out.write("                                                <th> Vỏ trước/sau</th>\r\n");
      out.write("                                                <th> Động cơ</th>\r\n");
      out.write("                                                <th> Dung tích xi lanh</th>\r\n");
      out.write("                                                <th> Công suất</th>\r\n");
      out.write("                                                <th> Dung tích nhớt</th>\r\n");
      out.write("                                                <th> Dung tích xăng</th>\r\n");
      out.write("                                                <th> Thắng trước/sau</th>\r\n");
      out.write("                                                <th> Hộp số </th>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </thead>\r\n");
      out.write("                                        \r\n");
      out.write("                                        \r\n");
      out.write("                                        <tbody>\r\n");
      out.write("                                            <img src=");
      out.print(rs.getString(4));
      out.write(" height=\"30%\" width-max=\"30%\" alt=\"Khong tai duoc\">\r\n");
      out.write("                                        <tr> \r\n");
      out.write("                                            <td>\r\n");
      out.write("                                            <select name=\"hang\">\r\n");
      out.write("                                                ");

                                                    while(rx.next()){
                                                
      out.write("\r\n");
      out.write("                                                <option> ");
      out.print(rx.getString(2));
      out.write("  </option>\r\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                            </td>\r\n");
      out.write("                                            <input type=\"hidden\" name=\"id\" placeholder=\"ID\" value=\"");
      out.print(rs.getString(1));
      out.write("\">\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"image\" value=\"");
      out.print(rs.getString(4));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"name\" value=\"");
      out.print(rs.getString(2));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"price\" value=\"");
      out.print(rs.getString(3));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"LWH\" value=\"");
      out.print(rs.getString(5));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"seat\" value=\"");
      out.print(rs.getString(6));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"tire\" value=\"");
      out.print(rs.getString(7));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"engine\" value=\"");
      out.print(rs.getString(8));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"cc\" value=\"");
      out.print(rs.getString(9));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"power\" value=\"");
      out.print(rs.getString(10));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"oil\" value=\"");
      out.print(rs.getString(11));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"gasoline\" value=\"");
      out.print(rs.getString(12));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"brake\" value=\"");
      out.print(rs.getString(13));
      out.write("\"> </td>\r\n");
      out.write("                                            <td> <input type=\"text\" class=\"form-control py-4\" name=\"gearbox\" value=\"");
      out.print(rs.getString(14));
      out.write("\"> </td>                                          \r\n");
      out.write("                                        </tr>   \r\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\r\n");
      out.write("                                        </tbody>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </main>\r\n");
      out.write("                    <center> <input type=\"submit\" value=\"Sửa\" class=\"btn btn-primary\"> </center>\r\n");
      out.write("                    </form>\r\n");
      out.write("                \r\n");
      out.write("                <footer class=\"py-4 bg-light mt-auto\">\r\n");
      out.write("                    <div class=\"container-fluid\">\r\n");
      out.write("                        <div class=\"d-flex align-items-center justify-content-between small\">\r\n");
      out.write("                            <div class=\"text-muted\"> Copyright &copy; MOWO - MOTO WORLD 2020 </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </footer>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
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
