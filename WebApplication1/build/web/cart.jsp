<%-- 
    Document   : cart
    Created on : Oct 20, 2020, 11:13:29 PM
    Author     : BND6699
--%>

<%@page import="IO.PD.ProductIO"%>
<%@page import="entity.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                   <%
                        String id = request.getParameter("id");
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham where id='"+id+"'");
                   %>
                   
                   <%
                      while(rs.next()){
                   %>
        <h3> cart </h3>
        <table>
            <tr>
                <td> Image </td>
                <td> TenSP </td>
                <td> Gia </td>
            </tr>
            <tr>
                <td> <img src="<%=rs.getString(4)%>"</td>
                <td> <%=rs.getString(2)%> </td>
                <td> <%=rs.getString(3)%> </td>
            </tr>
        </table>
               <%
                    }
               %> 
        
    
    </body>
</html>
