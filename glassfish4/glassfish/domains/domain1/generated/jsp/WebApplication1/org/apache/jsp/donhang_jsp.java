package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import context.DBContext;

public final class donhang_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                ");

                    if(session.getAttribute("user1") == null){
                        response.sendRedirect("loginadmin.html");
                    }
                
      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vi\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("        <meta name=\"author\" content=\"\" />\n");
      out.write("        <title> Motor World </title>\n");
      out.write("        <link href=\"CSS/styles_1.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"JS/scripts.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"JS/chart-area-demo.js\"></script>\n");
      out.write("        <script src=\"JS/chart-bar-demo.js\"></script>\n");
      out.write("        <script src=\"JS/chart-pie-demo.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body class=\"sb-nav-fixed\">\n");
      out.write("        <nav class=\"sb-topnav navbar navbar-expand navbar-dark bg-dark\">\n");
      out.write("<!--Logo-->             \n");
      out.write("           <a class=\"navbar-brand\" href=\"admin.jsp\"> Moto World </a>\n");
      out.write("     \n");
      out.write("<!--Logout--> \n");
      out.write("            <form class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0\">        \n");
      out.write("            <ul class=\"navbar-nav ml-auto ml-md-0\">\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" id=\"userDropdown\" href=\"#\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"><i class=\"fas fa-user fa-fw\"></i></a>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"userDropdown\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"> Đổi mật khẩu </a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"LogoutControl\"> Đăng xuất </a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("            </form>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!--Menu--> \n");
      out.write("        </nav>\n");
      out.write("        <div id=\"layoutSidenav\">\n");
      out.write("            <div id=\"layoutSidenav_nav\">\n");
      out.write("                <nav class=\"sb-sidenav accordion sb-sidenav-dark\" id=\"sidenavAccordion\">\n");
      out.write("                    <div class=\"sb-sidenav-menu\">\n");
      out.write("                        <div class=\"nav\">\n");
      out.write("                            <div class=\"sb-sidenav-menu-heading\"> DANH MỤC </div>\n");
      out.write("                            <a class=\"nav-link collapsed\" href=\"product.jsp\" data-toggle=\"collapse\" data-target=\"#collapseLayouts\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-motorcycle\"></i></div>\n");
      out.write("                                SẢN PHẨM\n");
      out.write("                                <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"collapse\" id=\"collapseLayouts\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\">\n");
      out.write("                                <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                    ");

                                        DBContext conx = new DBContext();
                                        ResultSet rsx = conx.chondulieu("select * from hang");
                                    
      out.write("\n");
      out.write("                                    ");

                                            while(rsx.next()){
                                    
      out.write("\n");
      out.write("                                    <a class=\"nav-link\" href=\"product.jsp?hang=");
      out.print(rsx.getString(2));
      out.write('"');
      out.write('>');
      out.print(rsx.getString(2));
      out.write("</a>\n");
      out.write("                                    ");

                                            }
                                    
      out.write("\n");
      out.write("                                </nav>\n");
      out.write("                            </div> \n");
      out.write("                            \n");
      out.write("                            <a class=\"nav-link\" href=\"hangxe.jsp\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-warehouse\"></i></div>\n");
      out.write("                                HÃNG XE\n");
      out.write("                            </a> \n");
      out.write("                                \n");
      out.write("                            <a class=\"nav-link\" href=\"user.jsp\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-users\"></i></div>\n");
      out.write("                                TÀI KHOẢN\n");
      out.write("                            </a>  \n");
      out.write("                            \n");
      out.write("                            <a class=\"nav-link\" href=\"#\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-boxes\"></i></div>\n");
      out.write("                                ĐƠN HÀNG\n");
      out.write("                            </a>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"sb-sidenav-footer\">\n");
      out.write("                        <div class=\"small\">Logged in as:</div>\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("<!--Content-->                     \n");
      out.write("            <div id=\"layoutSidenav_content\">\n");
      out.write("                    ");

                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from hoadon");
                    
      out.write("\n");
      out.write("                <main>\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <h1 class=\"mt-4\"> ĐƠN HÀNG </h1>\n");
      out.write("                        <ol class=\"breadcrumb mb-4\">\n");
      out.write("                            <li class=\"breadcrumb-item\"><a href=\"admin.jsp\"> DANH MỤC </a></li>\n");
      out.write("                            <li class=\"breadcrumb-item active\"> ĐƠN HÀNG </li>\n");
      out.write("                        </ol>\n");
      out.write("\n");
      out.write("                        <div class=\"card mb-4\">\n");
      out.write("                            <div class=\"card-header\">\n");
      out.write("                                <i class=\"fas fa-users\"></i>\n");
      out.write("                                Dữ liệu đơn hàng    \n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th> STT đơn hàng </th>\n");
      out.write("                                                <th> Người đặt </th>\n");
      out.write("                                                <th> Tên sản phẩm </th>\n");
      out.write("                                                <th> Số lượng </th>\n");
      out.write("                                                <th> Tổng tiền </th>\n");
      out.write("                                                <th> Chức năng </th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        \n");
      out.write("                                        ");

                                            while(rs.next()){
                                        
      out.write("\n");
      out.write("                                        <tbody>\n");
      out.write("                                        <tr>                                           \n");
      out.write("                                            <td> ");
      out.print(rs.getString(1));
      out.write(" </td>\n");
      out.write("                                            <td> ");
      out.print(rs.getString(2));
      out.write(" </td>\n");
      out.write("                                            <td> ");
      out.print(rs.getString(3));
      out.write("</td>\n");
      out.write("                                            <td> ");
      out.print(rs.getString(4));
      out.write(" </td>\n");
      out.write("                                            <td> ");
      out.print(rs.getString(5));
      out.write(" $ </td>\n");
      out.write("                                            <td> \n");
      out.write("                                                <div class=\"nav-link\">\n");
      out.write("                                                    <div class=\"sb-nav-link-icon\">\n");
      out.write("                                            <!--Xóa-->   \n");
      out.write("                                                        <input type=\"hidden\" id=\"id\" value=\"");
      out.print(rs.getString(1));
      out.write("\">\n");
      out.write("                                                        <a href=\"DeleteCart?MaHD=");
      out.print(rs.getString(1));
      out.write("\" nclick=\"return xoa()\">\n");
      out.write("                                                            <i class=\"fa fa-trash\"> </i>   \n");
      out.write("                                                        </a> &emsp; &emsp;                                                                                          \n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>   \n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </main>\n");
      out.write("                \n");
      out.write("                <footer class=\"py-4 bg-light mt-auto\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <div class=\"d-flex align-items-center justify-content-between small\">\n");
      out.write("                            <div class=\"text-muted\"> &copy; Motoword 2020 </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </footer>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
