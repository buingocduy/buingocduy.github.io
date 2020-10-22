<%-- 
    Document   : UPD
    Created on : Oct 17, 2020, 10:47:53 PM
    Author     : BND6699
--%>

<%@ page import="context.DBContext" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Moto world </title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
        <script src="JS/productjs.js" type="text/javascript"> </script> 
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/UPDcss.css" />
    </head>
    <body>
        <!--header-->        
        <div id="header"> 
           <div class="top-bar"> </div> <!--thanh do tren-->    
           <div id="logo-container"> 
               <p href="hinh.jpg" onclick="hinh()">
               <i class="fa fa-motorcycle logo-icon" id="hinh"></i> <h1> <i> Motoworld  </i> </h1> <!--Logo--> 
               </p>
           </div>
           <ul id="menu"> <!--menu-->
               <li> <a href="home.html">Home</a> </li> 
               <li> <a href="product.jsp">Product</a> </li> 
               <li> <a href="Login.html">Logout</a> </li>
               <li> <a href="cart.jsp"> <i class="fa fa-shopping-cart" id="cart"> </i> </a> </li>
           </ul>
        </div>
 
<!--body-->            
        <div id="body">
        
    <!--content-->
            <div id="content">                          
                    <%          
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham "); 
                    %>
                    <%
                        while(rs.next()){
                    %>  
                    <div class="grid">  
                        <table>
                            <tr>
                                <td> <img src=<%=rs.getString(4)%> height=200 width=300 alt="Khong tai duoc"> </td>
                                <td> 
                        <div style=" border: 2px solid black; text-align: center; width: 400px; padding: 20px; height: 300px; overflow:  auto;"> 
                        <form action="UpdateDPControl" method="get" align="center">
                             <input type="text" name="id" placeholder="ID" value="<%=rs.getString(1)%>"> <br> <br>  
                             <input type="text" name="name" placeholder="Name" value="<%=rs.getString(2)%>"> <br> <br>   
                             <input type="text" name="price" placeholder="Price" value="<%=rs.getString(3)%>"> <br> <br>  
                             <input type="text" name="image" placeholder="Image" value="<%=rs.getString(4)%>"> <br> <br>  
                             <input type="text" name="LWH" placeholder="LxWxH" value="<%=rs.getString(5)%>"> <br> <br>  
                             <input type="text" name="seat" placeholder="Seat height" value="<%=rs.getString(6)%>"> <br> <br>   
                             <input type="text" name="tire" placeholder="Front/rear tire" value="<%=rs.getString(7)%>"> <br> <br>  
                             <input type="text" name="engine" placeholder="Engine" value="<%=rs.getString(8)%>"> <br> <br>  
                             <input type="text" name="cc" placeholder="CC" value="<%=rs.getString(9)%>"> <br> <br>  
                             <input type="text" name="power" placeholder="Power" value="<%=rs.getString(10)%>"> <br> <br>  
                             <input type="text" name="oil" placeholder="Oil" value="<%=rs.getString(11)%>"> <br> <br>  
                             <input type="text" name="gasoline" placeholder="Gasoline" value="<%=rs.getString(12)%>"> <br> <br>   
                             <input type="text" name="brake" placeholder="Brake" value="<%=rs.getString(13)%>"> <br> <br>  
                             <input type="text" name="gearbox" placeholder="Gearbox" value="<%=rs.getString(14)%>"> <br> <br>  
                             <input type="submit" value="Update"> <br>  
                        </form>    
                        </div>
                                </td>
                            </tr>
                        </table>
                    </div>
            </div>  
    
    <!--sidebar-->        
           <!-- <div id="sidebar">               
                <div class="gridsidebar">  
                    <div class="rangersidebar1">  
                           
                    </div>                                                       
                </div>
            </div> -->
        </div> 
                    <%
                        }
                    %>

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
