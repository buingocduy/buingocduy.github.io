<%-- 
    Document   : IPD
    Created on : Nov 5, 2020, 11:56:07 PM
    Author     : BND6699
--%>
<%@ page import="entity.Item"%>
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
                        <i class="fa fa-motorcycle logo-icon" id="hinh"></i> <h1> <i> Admin: ${sessionScope.user1}  </i> </h1>
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
                         <input type="text" name="name" placeholder="Tên sản phẩm"> &emsp;  
                         <input type="text" name="price" placeholder="Giá"> &emsp;     
                         <input type="text" name="image" placeholder="Hình ảnh"> <br> <br> 
                         <input type="text" name="LWH" placeholder="DàixRộngxCao"> &emsp;  
                         <input type="text" name="seat" placeholder="Chiều cao yên"> &emsp; 
                         <input type="text" name="tire" placeholder="Vỏ trức/sau"> <br> <br> 
                         <input type="text" name="engine" placeholder="Động cơ"> &emsp; 
                         <input type="text" name="cc" placeholder="Dung tích xi lanh"> &emsp; 
                         <input type="text" name="power" placeholder="Công suất"> <br> <br> 
                         <input type="text" name="oil" placeholder="Dung tích dầu"> &emsp; 
                         <input type="text" name="gasoline" placeholder="Dung tích xăng"> &emsp;
                         <input type="text" name="brake" placeholder="Thắng trước/sau"> <br> <br>  
                         <input type="text" name="gearbox" placeholder="Hộp số"> <br> <br>  
                         <input type="submit" value="Thêm"> <br>                         
            </form>           
        </div>
<!--footer-->        
        <div id="footer">  
            <div class="textfooter">       
                   
            </div>
        </div>
    </body>
</html>
