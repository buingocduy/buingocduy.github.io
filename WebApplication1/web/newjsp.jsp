<%-- 
    Document   : newjsp
    Created on : Nov 6, 2020, 10:21:43 PM
    Author     : BND6699
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> ${sessionScope.cart} </h1>
        
        <table>
                        <tr>
                            <th> Sản phẩm </th>
                            <th> Tên sản phẩm </th>
                            <th> Giá </th>
                            <th> Số lượng </th>
                            <th> Tổng tiền </th>
                            <th> Chức năng </th>
                        </tr>
                               
                <%
                    entity.Item item = new entity.Item();
                    java.util.ArrayList orders = new ArrayList();                  
                    if (session.getAttribute("cart") != null) {
                        orders = ((java.util.ArrayList) session.getAttribute("cart"));
                    }
 
                    int count = orders.size() -1;
                    while (count > -1) {
                        item = (entity.Item) orders.get(count);
                        
                        if (request.getParameter("id") != null) {                          
                            if (item.getId() == (Integer.parseInt(request.getParameter("id")))) {
                                orders.remove(item);                              
                                count--;
                                continue;
                            }
                        }
                        
                        int tongtien=item.getSoluongmua()* item.getGia();
                          
                        out.print("<tr>"); 
                        out.print("<td>" + "<image src="+item.getHinhanh()+" with=100; height=100>" + "</td>");
                        out.print("<td>" + item.getTensp()+ "</td>");               
                        out.print("<td>" + item.getGia()+".000.000"+ "</td>");
                        out.print("<td>" + item.getSoluongmua()+ "</td>");
                        out.print("<td>" + tongtien +".000.000"+ "</td>");                             
                        out.print("<td> <a href='?id="+item.getId()+"'> Delete </a> </td>");                  
                        out.print("</tr>");
                        count--;
                    }
                    
                %>
                </table> <br>
    </body>
</html>
