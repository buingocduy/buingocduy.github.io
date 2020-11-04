<%-- 
    Document   : UACC
    Created on : Nov 2, 2020, 9:14:00 PM
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
               <li> <a href="admin.jsp">Account</a> </li>               
               <li> <a href="LogoutControl"> Logout </a> </li>
           </ul>
           </form>
        </div>
 
<!--body-->            
        <div id="body">
        
    <!--content-->
            <div id="content">  
                    <%          
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from taikhoan "); 
                    %>
                    <%
                        while(rs.next()){
                    %>  
                    <div class="grid">  
                        <table>
                            <tr>
                                <td> 
                        <div style=" border: 2px solid black; text-align: center; width: 400px; padding: 20px; height: 200px; overflow:  auto;"> 
                        <form action="UpdateControl" method="get" align="center">
                            <div style=" color: red; font-size: 14pt; font-weight: bold;">    
                            <input type="hidden" name="username" id="username" placeholder="username" value="<%=rs.getString(1)%>">                      
                            <input type="hidden" name="password" id="password" placeholder="password" value="<%=rs.getString(2)%>"> 
                            Email <br>
                             <input type="text" name="email" id="email" placeholder="email" value="<%=rs.getString(3)%>"> <br> <br>  
                            Phonenumber <br> 
                             <input type="text" name="phonenumber" id="phonenumber" placeholder="phonenumber" value="<%=rs.getString(4)%>"> <br> <br>                          
                             <input type="submit" value="Update"> <br> 
                            </div> 
                        </form>    
                        </div>
                                </td>
                                <td> <h1> <%=rs.getString(1)%> </h1> </td>
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
                   
            </div>
        </div>
            
    </body>
</html>
