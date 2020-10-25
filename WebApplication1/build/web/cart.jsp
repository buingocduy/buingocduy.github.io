<%-- 
    Document   : cart
    Created on : Oct 20, 2020, 11:13:29 PM
    Author     : BND6699
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Item"%>
<%@page import="entity.Item"%>
<%@page import="entity.Product"%>
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
        <script src="JS/indexjs.js" type="text/javascript"> </script> 
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/cartcss.css" />
    </head>
<body>
        <!--header-->        
        <div id="header"> 
           <div class="top-bar"> </div> <!--thanh do tren-->    
           <div id="logo-container"> 
                <a href="Login.html"> 
                    <p href="hinh.jpg" onclick="hinh()">
                        <i class="fa fa-motorcycle logo-icon" id="hinh"></i> <h1> <i> Motoworld  </i> </h1> <!--Logo--> 
                    </p> 
                </a>
           </div>
           <ul id="menu"> <!--menu-->
               <li> <a href="home.html">Home</a> </li> 
               <li> <a href="honda.jsp" onclick="hinh()">About</a> </li>
               <li><a href="register.html"> Register</a> </li>
               <li> <a href="cart.jsp"> <i class="fa fa-shopping-cart" id="cart"> </i> </a> </li>
           </ul>
        </div>
 
<!--body-->            
        <div id="body">
         
            <!--sidebar-->
            <div id="sidebar">               
                <div class="gridsidebar">  
                    <div class="rangersidebar">
                        <a href="honda.jsp">
                            <img src="Hinh/honda.jpg"  height="110" width="220" alt="Khong tai duoc">
                        </a>
                    </div>           
                    <div class="rangersidebar"> 
                        <img src="Hinh/ya.jpg"  height="110" width="220" alt="Khong tai duoc" onclick="hinh()"> 
                    </div>             
                    <div class="rangersidebar">  
                        <img src="Hinh/su.jpg" height="110" width="220" alt="Khong tai duoc" onclick="hinh()"> 
                    </div>                            
                </div>
            </div> 
      

        <!--content--> 
            <div id="content"> 
                <div class="textcontent"> <center> CART </center> </div>                   
            </div>
                   <%
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from giohang");                 
                   %>
                   
                   <%
                      while(rs.next()){
                   %>  
            <div id="content">     
                <table>
                        <tr>
                            <td> ID sản phẩm </td>
                            <td> Tên sản phẩm </td>
                            <td> Giá </td>
                            <td> Hình ảnh </td>
                            <td> Số lượng </td>
                        </tr>
                        <tr>
                            <td> <%=rs.getString(1)%> </td>
                            <td> <%=rs.getString(2)%> </td>
                            <td> <%=rs.getString(3)%> </td>
                            <td> <img src=<%=rs.getString(4)%> height="150" width="150" alt="Khong tai duoc"> </td>
                            <td> <%=rs.getString(5)%> </td>
                        </tr>
                </table>
            </div>    
                <%
                      }
                %>      
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
