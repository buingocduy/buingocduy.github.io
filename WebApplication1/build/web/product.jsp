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
                        <i class="fa fa-motorcycle logo-icon" id="hinh"></i> <h1> <i> Admin: ${sessionScope.user1}  </i> </h1> 
           </div>
           <form>
           <ul id="menu"> <!--menu-->               
               <li> <a href="admin.jsp">Tài khoản</a> </li>               
               <li> <a href="LogoutControl">Đăng xuất</a> </li>
           </ul>
           </form>
        </div>
 
<!--body-->            
        <div id="body">
            <h1 style="padding-left: 200px; color: maroon"> <i> Danh sách sản phẩm </i> </h1>
    <!--content-->
            <div id="content">  
                <a href="IPD.jsp" style="float: left"> <input type="button" value="Thêm sản phẩm"> </a>
                <form> 
                    <%
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham");
                    %>
                    <table align="center">
                        <thead>
                            <tr>
                                <th> Chức năng </th>
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
                                <td> 
                                    <a href="UPD.jsp?id=<%=rs.getString(1)%>" class="fa fa-pencil"> </a> &emsp; &emsp;
                                    <a href="DeleteDPControl?id=<%=rs.getString(1)%>" class="fa fa-trash"> </a>
                                </td>
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
        </div>
   
<!--footer-->        
        <div id="footer">  
            <div class="textfooter">       
                     
            </div>
        </div>
            
    </body>
</html>
