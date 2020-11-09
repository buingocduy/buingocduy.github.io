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
               <li> <a href="product.jsp">Sản phẩm</a> </li>               
               <li> <a href="LogoutControl"> Đăng xuất </a> </li>
           </ul>
           </form>
        </div>
 
<!--body-->            
        <div id="body">
        
    <!--content-->
            <div id="content">               
                    <% 
                        String id = request.getParameter("id");
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham where id='" + id + "'"); 
                    %>
                    <%
                        while(rs.next()){                           
                    %>  
                    <div class="grid">     
                        <img src=<%=rs.getString(4)%> height="80%" width="400%" style="padding-top: 30px" alt="Khong tai duoc">
                        <div style=" border: 2px solid black; text-align: center; width: 500px; padding: 20px; height: 300px; overflow:  auto;"> 
                        <form action="UpdateDPControl" method="get" align="center">
                            <div style=" color: red; font-size: 14pt; font-weight: bold;">                    
                            <input type="hidden" name="id" placeholder="ID" value="<%=rs.getString(1)%>"> 
                            Tên xe <br>
                             <input type="text" name="name" placeholder="Name" value="<%=rs.getString(2)%>"> <br> <br>   
                            Giá xe <br>
                             <input type="text" name="price" placeholder="Price" value="<%=rs.getString(3)%>"> <br> <br>  
                            Hình ảnh <br> 
                             <input type="text" name="image" placeholder="Image" value="<%=rs.getString(4)%>"> <br> <br>  
                            Dài Rộng Cao <br> 
                             <input type="text" name="LWH" placeholder="LxWxH" value="<%=rs.getString(5)%>"> <br> <br>  
                            Độ cao yên <br> 
                             <input type="text" name="seat" placeholder="Seat height" value="<%=rs.getString(6)%>"> <br> <br>   
                            Size bánh trước/sau <br> 
                             <input type="text" name="tire" placeholder="Front/rear tire" value="<%=rs.getString(7)%>"> <br> <br>  
                            Động cơ <br> 
                             <input type="text" name="engine" placeholder="Engine" value="<%=rs.getString(8)%>"> <br> <br>  
                            Dung tích máy <br> 
                             <input type="text" name="cc" placeholder="CC" value="<%=rs.getString(9)%>"> <br> <br>  
                            Công suất <br> 
                             <input type="text" name="power" placeholder="Power" value="<%=rs.getString(10)%>"> <br> <br>  
                            Dung tích nhớt <br> 
                             <input type="text" name="oil" placeholder="Oil" value="<%=rs.getString(11)%>"> <br> <br>  
                            Dung tích xăng <br> 
                             <input type="text" name="gasoline" placeholder="Gasoline" value="<%=rs.getString(12)%>"> <br> <br>   
                            Thắng trước/sau <br> 
                             <input type="text" name="brake" placeholder="Brake" value="<%=rs.getString(13)%>"> <br> <br>  
                            Hộp số <br> 
                             <input type="text" name="gearbox" placeholder="Gearbox" value="<%=rs.getString(14)%>"> <br> <br>  
                             <input type="submit" value="Update"> <br> 
                            </div> 
                        </form>    
                        </div>
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
