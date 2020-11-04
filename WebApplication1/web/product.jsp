<%-- 
    Document   : product
    Created on : Oct 12, 2020, 9:04:54 PM
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
        <link rel="stylesheet" href="CSS/productcss.css" />
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
               <li> <a href="admin.jsp">Account</a> </li>               
               <li> <a href="LogoutControl"> Logout </a> </li>
           </ul>
           </form>
        </div>
 
<!--body-->            
        <div id="body">
        
    <!--content-->
            <div id="content">            
                <form> 
                    <%
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham");
                    %>
                    <table align="center">
                        <thead>
                            <tr>
                                <th> ID</th>
                                <th> Name</th>
                                <th> Price</th>
                                <th> Image</th>
                                <th> LxWxH</th>
                                <th> Seat height</th>
                                <th> Front/rear tire</th>
                                <th> Engine</th>
                                <th> CC</th>
                                <th> Power</th>
                                <th> Oil</th>
                                <th> Gasoline</th>
                                <th> Front/rear brake</th>
                                <th> Gearbox</th> 
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
                                <td> <%=rs.getString(4)%> </td>
                                <td> <%=rs.getString(5)%> </td>
                                <td> <%=rs.getString(6)%> </td>
                                <td> <%=rs.getString(7)%> </td>
                                <td> <%=rs.getString(8)%> </td>
                                <td> <%=rs.getString(9)%> </td>
                                <td> <%=rs.getString(10)%> </td>
                                <td> <%=rs.getString(11)%> </td>
                                <td> <%=rs.getString(12)%> </td>
                                <td> <%=rs.getString(13)%> </td>
                                <td> <%=rs.getString(14)%> </td>
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
                    <div class="rangersidebar1">  
                        <center> <a href="UPD.jsp"> <input type="button" value="Update"> </a> </center> <br>  
                    </div>          
                           
                    <div class="rangersidebar1"> 
                    <form action="DeleteDPControl" method="get" align="center">
                         <br>
                         <input type="text" name="id"  placeholder="ID muốn xóa"> <br> <br>               
                         <input type="submit" value="Delete"> <br>  
                    </form>
                    </div> 
                    
                    <div class="rangersidebar2">  
                    <form action="InsertDPControl" method="get" align="center">                       
                         <input type="text" name="id" placeholder="ID"> <br> <br>  
                         <input type="text" name="name" placeholder="Name"> <br> <br>   
                         <input type="text" name="price" placeholder="Price"> <br> <br>  
                         <input type="text" name="image" placeholder="Image"> <br> <br>  
                         <input type="text" name="LWH" placeholder="LxWxH"> <br> <br>  
                         <input type="text" name="seat" placeholder="Seat height"> <br> <br>   
                         <input type="text" name="tire" placeholder="Front/rear tire"> <br> <br>  
                         <input type="text" name="engine" placeholder="Engine"> <br> <br>  
                         <input type="text" name="cc" placeholder="CC"> <br> <br>  
                         <input type="text" name="power" placeholder="Power"> <br> <br>  
                         <input type="text" name="oil" placeholder="Oil"> <br> <br>  
                         <input type="text" name="gasoline" placeholder="Gasoline"> <br> <br>   
                         <input type="text" name="brake" placeholder="Brake"> <br> <br>  
                         <input type="text" name="gearbox" placeholder="Gearbox"> <br> <br>  
                         <input type="submit" value="Insert"> <br>  
                    </form>    
                    </div>                            
                </div>
            </div> 
        </div> 

<!--footer-->        
        <div id="footer">  
            <div class="textfooter">       
                     
            </div>
        </div>
            
    </body>
</html>
