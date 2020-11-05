<%-- 
    Document   : IPD
    Created on : Nov 5, 2020, 11:56:07 PM
    Author     : BND6699
--%>

<%@ page import="context.DBContext" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <%
                    if(session.getAttribute("user1") == null){
                        response.sendRedirect("Login.html");
                    }
                    %>   
        <!--header-->        
        <div id="header"> 
           <div class="top-bar"> </div> <!--thanh do tren-->    
           <div id="logo-container"> 
                    <p href="hinh.jpg" onclick="hinh()">
                        <i class="fa fa-motorcycle logo-icon" id="hinh"></i> <h1> <i> Admin: ${sessionScope.user1}  </i> </h1>
                    </p> 
           </div>
          
           <form>
           <ul id="menu"> <!--menu-->
               <li> <a href="product.jsp"> Sản phẩm </a> </li>               
               <li> <a href="LogoutControl"> Đăng xuất </a> </li>
           </ul>
           </form>
        </div>
 
<!--body-->            
        <div id="body">
            <form action="InsertDPControl" method="get" align="center">                       
                         <input type="text" name="id" placeholder="ID"> &emsp; 
                         <input type="text" name="name" placeholder="Name"> &emsp;  
                         <input type="text" name="price" placeholder="Price"> <br> <br>     
                         <input type="text" name="image" placeholder="Image"> &emsp;
                         <input type="text" name="LWH" placeholder="LxWxH"> &emsp;
                         <input type="text" name="seat" placeholder="Seat height"> <br> <br>   
                         <input type="text" name="tire" placeholder="Front/rear tire"> &emsp; 
                         <input type="text" name="engine" placeholder="Engine"> &emsp; 
                         <input type="text" name="cc" placeholder="CC"> <br> <br>  
                         <input type="text" name="power" placeholder="Power"> &emsp;
                         <input type="text" name="oil" placeholder="Oil"> &emsp; 
                         <input type="text" name="gasoline" placeholder="Gasoline"> <br> <br>   
                         <input type="text" name="brake" placeholder="Brake"> &emsp;
                         <input type="text" name="gearbox" placeholder="Gearbox"> <br> <br>  
                         <input type="submit" value="Insert"> <br>  
            </form>    
        </div>

<!--footer-->        
        <div id="footer">  
            <div class="textfooter">       
                   
            </div>
        </div>
    </body>
</html>
