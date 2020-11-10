<%-- 
    Document   : cart
    Created on : Oct 20, 2020, 11:13:29 PM
    Author     : BND6699
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Item"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Moto world </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
        <script src="JS/cartjs.js" type="text/javascript"> </script> 
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/cartcss.css" />
    </head>
<body>
        <!--header-->        
        <div id="header"> 
           <div class="top-bar"> </div> <!--thanh do tren-->    
           <div id="logo-container"> 
                <i class="fa fa-motorcycle logo-icon" id="hinh"></i> <h1> <i> Motoworld  </i> </h1> <!--Logo--> 
           </div>
           <ul id="menu"> <!--menu-->
               <li><a href="home.html">Trang chủ</a> </li>
               <li><a href="register.jsp">Đăng ký</a> </li>
               <li> <a href="loginuser.jsp">Đăng nhập</a> </li>
               <li> <a href="cart.jsp"> <i class="fa fa-shopping-cart" id="cart"> </i> </a> </li>
           </ul>
        </div>
 
<!--body-->            
        <div id="body">
         
            <!--sidebar-->        
            <div id="sidebar">               
                <div class="gridsidebar">  
                        <a href="honda.jsp">   
                            <div class="thumbnail">
                            <img src="Hinh/honda.jpg"  height="150" width="80%"  style="border: 1px solid red" alt="Khong tai duoc">
                            </div>
                        </a>                        
                        <a href="#">
                            <div class="thumbnail">
                            <img src="Hinh/ya.jpg"  height="150" width="80%" style="border: 1px solid red" alt="Khong tai duoc" onclick="hinh()">                      
                            </div>
                        </a>

                        <a href="#">
                            <div class="thumbnail">
                            <img src="Hinh/su.jpg" height="150" width="80%" style="border: 1px solid red" alt="Khong tai duoc" onclick="hinh()"> 
                            </div> 
                        </a>                               
                </div>
            </div> 
      

        <!--content--> 
            <div id="content"> 
                <h3> User: <i> ${sessionScope.user} </i> <a href="LogoutACCControl"> Đăng xuất </a> </h3>
                <div class="textcontent"> <center> Giỏ hàng </center> </div>                
            </div>
            <div id="content">          
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
                    if (session.getAttribute("Orders") != null) {
                        orders = ((java.util.ArrayList) session.getAttribute("Orders"));
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
                        count--;
                        out.print("</tr>"); 
                    }
                    
                %>
                </table> <br>
                
                
                <%
                    if (request.getParameter("mua") != null )
                    {
                        if  (session.getAttribute("user") != null && session.getAttribute("Orders") != null) 
                        {
                                session.setAttribute("cart", orders);
                                session.removeAttribute("Orders");              
                                response.sendRedirect("cart.jsp");
                        }
                    }
                %>
                
                <center>
                    <form onsubmit = "return validateForm()">
                        <button type="submit" id="mua" name="mua"> Đặt hàng </button> </br> </br> 
                        <input type="hidden" id="user" name="user" value="${sessionScope.user}">
                        <input type="hidden" id="order" name="order" value="${sessionScope.Orders}">                    
                    </form>                  
                </center>
             </div>             
        </div>   
   


<!--footer-->        
        <div id="footer">  
            <div class="textfooter">       
                    © MOTOWORLD HỒ CHÍ MINH <br>
                    Địa chỉ: 475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM <br>
                    SĐT: 0904596810 | Email: MTHCM@Gmail.com       
            </div>
        </div>
            
    </body>
</html>
