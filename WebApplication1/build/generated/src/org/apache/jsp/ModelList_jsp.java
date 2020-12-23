package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ModelList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Model List</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            <p>\n");
      out.write("                <font size=\"3\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                    <strong>Model List</strong>\n");
      out.write("                </font>\n");
      out.write("            </p>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ShoppingCart.jsp\" mce_href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ShoppingCart.jsp\">View Cart</a>\n");
      out.write("            <br/><br/>\n");
      out.write("            <table width=\"75%\" border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <form name=\"modelDetail1\" method=\"POST\" action=\"CartController\">\n");
      out.write("                            <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                <strong>Model:</strong>\n");
      out.write("                                TF-Model1\n");
      out.write("                            </font>\n");
      out.write("                            <input type=\"hidden\" name=\"modelNo\" value=\"TF-MODEL1\">\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Description:</strong>\n");
      out.write("                                    Tech-Freaks imaginary model 1. \n");
      out.write("                                </font>\n");
      out.write("                                <input type=\"hidden\" name=\"description\" value=\"Tech-Freaks imaginary model 1.\">\n");
      out.write("                            </p>\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Quantity:<input type=\"text\" size=\"2\" value=\"1\" name=\"quantity\"></strong>\n");
      out.write("                                </font>\n");
      out.write("                            </p>\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Price:</strong>\n");
      out.write("                                    $10.00\n");
      out.write("                                </font>\n");
      out.write("                                <input type=\"hidden\" name=\"price\" value=\"10\">\n");
      out.write("                            </p>\n");
      out.write("                            <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("                            <input type=\"submit\" name=\"addToCart\" value=\"Add To Cart\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                    <td><form name=\"modelDetail2\" method=\"POST\" action=\"servlet/CartController\">\n");
      out.write("                            <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                <strong>Model</strong>:\n");
      out.write("                                TF-Model2 \n");
      out.write("                            </font>\n");
      out.write("                            <input type=\"hidden\" name=\"modelNo\" value=\"TF-MODEL2\">\n");
      out.write("                            <font face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                <p>\n");
      out.write("                                    <font size=\"2\">\n");
      out.write("                                        <strong>Description</strong>: Tech-Freaks imaginary model 2. \n");
      out.write("                                    </font>\n");
      out.write("                                    <input type=\"hidden\" name=\"description\" value=\"Tech-Freaks imaginary model 2.\">\n");
      out.write("                                </p>\n");
      out.write("                                <p>\n");
      out.write("                                    <font size=\"2\"><strong>Quantity</strong>: \n");
      out.write("                                        <input type=\"text\" size=\"2\" value=\"1\" name=\"quantity\">\n");
      out.write("                                    </font>\n");
      out.write("                                </p>\n");
      out.write("                                <p>\n");
      out.write("                                    <font size=\"2\">\n");
      out.write("                                        <strong>Price</strong>: $20.00\n");
      out.write("                                        <input type=\"hidden\" name=\"price\" value=\"20\">\n");
      out.write("                                    </font>\n");
      out.write("                                </p>\n");
      out.write("                                <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("                                <input type=\"submit\" name=\"addToCart\" value=\"Add To Cart\">\n");
      out.write("                            </font>\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <form name=\"modelDetail3\" method=\"POST\" action=\"servlet/CartController\">\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Model:</strong> TF-Model3\n");
      out.write("                                </font>\n");
      out.write("                                <input type=\"hidden\" name=\"modelNo\" value=\"TF-MODEL3\">\n");
      out.write("                            </p>\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Description:</strong> Tech-Freaks imaginary model 3. \n");
      out.write("                                </font>\n");
      out.write("                                <input type=\"hidden\" name=\"description\" value=\"Tech-Freaks imaginary model 3.\">\n");
      out.write("                            </p>\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Quantity:</strong>\n");
      out.write("                                </font> \n");
      out.write("                                <input type=\"text\" size=\"2\" value=\"1\" name=\"quantity\">\n");
      out.write("                            </p>\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Price: $30.00</strong>\n");
      out.write("                                </font>\n");
      out.write("                                <input type=\"hidden\" name=\"price\" value=\"30\">\n");
      out.write("                            </p>\n");
      out.write("                            <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("                            <input type=\"submit\" name=\"addToCart\" value=\"Add To Cart\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <form name=\"modelDetail4\" method=\"POST\" action=\"servlet/CartController\">\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Model</strong>: TF-Model4\n");
      out.write("                                </font>\n");
      out.write("                                <input type=\"hidden\" name=\"modelNo\" value=\"TF-MODEL4\">\n");
      out.write("                            </p>\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Description</strong>: Tech-Freaks imaginary model 4. \n");
      out.write("                                </font>\n");
      out.write("                                <input type=\"hidden\" name=\"description\" value=\"Tech-Freaks imaginary model 4.\">\n");
      out.write("                            </p>\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Quantity</strong>:\n");
      out.write("                                </font> \n");
      out.write("                                <input type=\"text\" size=\"2\" value=\"1\" name=\"quantity\">\n");
      out.write("                            </p>\n");
      out.write("                            <p>\n");
      out.write("                                <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">\n");
      out.write("                                    <strong>Price</strong>: $40.00\n");
      out.write("                                </font>\n");
      out.write("                                <input type=\"hidden\" name=\"price\" value=\"40\">\n");
      out.write("                            </p>\n");
      out.write("                            <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("                            <input type=\"submit\" name=\"addToCart\" value=\"Add To Cart\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </center>\n");
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
