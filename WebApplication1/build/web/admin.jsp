<%-- 
    Document   : admin
    Created on : Oct 7, 2020, 1:18:09 AM
    Author     : BND6699
--%>
                <%
                    if(session.getAttribute("user") == null){
                        response.sendRedirect("Login.html");
                    }
                %>  


<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
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
        <script src="JS/cartjs.js" type="text/javascript"> </script> 
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/adcss.css" />
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
                   
           <form>
           <ul id="menu"> <!--menu-->
               <li> <a href="home.html">Home</a> </li> 
               <li> <a href="product.jsp">Product</a> </li>               
               <li> <a href="cart.jsp"> <i class="fa fa-shopping-cart" id="cart"> </i> </a> </li>
               <li> <a href="LogoutControl"> Logout </a> </li>
           </ul>
           </form>
        </div>
 
<!--body-->            
        <div id="body">
        
    <!--content-->
            <div id="content">
                
                <h3> Admin: ${sessionScope.user} </h3>
                
                <form action="ListACC"> 
                    <%
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from taikhoan");
                    %>
                    <table align="center">
                        <thead>
                            <tr>
                                <th> Username </th>
                                <th> Password </th>
                                <th> Email </th>
                                <th> Phonenumber</th>
                                <th> Key </th>                            
                            </tr>
                        </thead>
    
                        <tbody>
                            <%                                
                                while(rs.next()){
                            %>
                            <tr>                              
                                <td> <%=rs.getString(1)%> </td>
                                <td> <%=rs.getString(2)%> </td>
                                <td> <%=rs.getString(3)%> </td>
                                <td> <%=rs.getString(4)%></td>
                                <td> <%=rs.getBoolean(5)%></td>
                            </tr>   
                            
                            <%
                                }
                            %>
                        </tbody>           
                    </table>
                </form>
            </div>  
    
    <!--sidebar-->        
            <div id="sidebar">               
                <div class="gridsidebar">  
                    <div class="rangersidebar"> 
                    <form action="DeleteControl" method="get" align="center">
                         <br>
                         <input type="text" name="username"  placeholder="Username muốn xóa"> <br> <br>               
                         <input type="submit" value="Delete"> <br>  
                    </form>
                    </div>             
                    <div class="rangersidebar">  
                    <form action="UpdateControl" method="get" align="center">  
                         <input type="text" name="username" placeholder="Username"> <br> <br>  
                         <input type="text" name="password" placeholder="Password"> <br> <br>   
                         <input type="text" name="email" placeholder="Email"> <br> <br>  
                         <input type="text" name="phonenumber" placeholder="Phonemunber"> <br> <br>     
                         <input type="text" name="key" placeholder="Key true or false"> <br> <br>  
                         <input type="submit" value="Update"> <br> 
                         </form>
                    </form>   
                    </div>                            
                </div>
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
