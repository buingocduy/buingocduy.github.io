<%-- 
    Document   : loginuser
    Created on : Nov 9, 2020, 4:46:12 PM
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
        <title> Moto world </title> 
        <meta charset="UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script> 
        <script src="JS/Loginjs.js" type="text/javascript"> </script> 
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
        <link rel="stylesheet" href="CSS/registercss.css"/>
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
            
<!--content-->
            <div id="content"> 
                <div class="textcontent"> <center> Đăng nhập </center> </div> <br>          
                <div class="rangeregister">
                    <form method="GET" action="LoginControl">
                            Username: <input type="text" id="username" name="username"> <br> <br>
                            Password: <input type="password" id="password" name="password"> <br> <br>
                            <input type="submit" value="Xác nhận"> <br> 
                            <p style="color: red"> ${sessionScope.dangnhap} </p>
                    </form>
                </div>  
            </div>

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
