<%-- 
    Document   : admin
    Created on : Oct 7, 2020, 1:18:09 AM
    Author     : BND6699
--%>
                <%
                    if(session.getAttribute("user1") == null){
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
                    <p href="hinh.jpg" onclick="hinh()">
                        <i class="fa fa-motorcycle logo-icon" id="hinh"></i> <h1> <i> Admin: ${sessionScope.user1}  </i> </h1> <!--Logo--> 
                    </p> 
           </div>
                   
           <form>
           <ul id="menu"> <!--menu-->              
               <li> <a href="product.jsp">Product</a> </li>               
               <li> <a href="LogoutControl"> Logout </a> </li>
           </ul>
           </form>
        </div>
 
<!--body-->            
        <div id="body">
        
    <!--content-->
            <div id="content">                           
                <form action="ListACC"> 
                    <%
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from taikhoan");
                    %>
                    <table align="center">
                        <thead>
                            <tr>
                                <th> Username </th>
                                <th> Email </th>
                                <th> Phonenumber</th>                          
                            </tr>
                        </thead>
    
                        <tbody>
                            <%                                
                                while(rs.next()){
                            %>
                            <tr>                              
                                <td> <%=rs.getString(1)%> </td>
                                <td> <%=rs.getString(3)%> </td>
                                <td> <%=rs.getString(4)%></td>
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
                    <center> <a href="UACC.jsp"> <input type="button" value="Update"> </a> </center> <br>  
                    </div>                 
                    
                    <div class="rangersidebar"> 
                    <form action="DeleteControl" method="get" align="center">
                         <br>
                         <input type="text" name="username"  placeholder="Username muốn xóa"> <br> <br>               
                         <input type="submit" value="Delete"> <br>  
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
