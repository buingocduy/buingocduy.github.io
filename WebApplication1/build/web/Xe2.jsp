<%-- 
    Document   : Xe2
    Created on : Oct 20, 2020, 11:51:48 PM
    Author     : BND6699
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Moto world </title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
        <script src="JS/xejs.js" type="text/javascript"> </script> 
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/xecss.css" />
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
               <li> <a href="index.html">Home</a> </li> 
               <li> <a href="Xe1.jsp" onclick="hinh()">About</a> </li> 
               <li> <a href="Login.html">Login</a> </li>
               <li> <a href="cart.html"> <i class="fa fa-shopping-cart" id="cart"> </i> </a> </li>
           </ul>
        </div>
 
<!--body-->            
        <div id="body">
            
    <!--content-->
            <div id="content">
                   <%
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham where id='h2'");
                   %>
                   
                   <%
                      while(rs.next()){
                   %>
                <div class="textcontent"> <center> <%=rs.getString(2)%> </center> </div>
                
                <div class="leftrangecontent">
                    <img src=<%=rs.getString(4)%> height="375" width="350" alt="Khong tai duoc"> 
                </div>
                
                <div class="rightrangecontent">
                    <h2> Giá: <%=rs.getString(3)%> </h2> 
                    <form action="Buy" method="get">
                        <input type="submit" id="<%=rs.getString(1)%>" name="<%=rs.getString(1)%>" value="Thêm vào giỏ hàng">
                    </form>
                </div>
                
                <table>
                    <thead>
                        <th> Thông số kỹ thuật </th>
                    </thead>
                    
                    <tbody>
                        <tr> 
                            <td> Dài x Rộng x Cao : <%=rs.getString(5)%> </td> 
                            <td> Độ cao yên : <%=rs.getString(6)%> </td>                     
                        </tr>
                        <tr> 
                            <td> Cỡ lốp trước/sau : <%=rs.getString(7)%> </td> 
                            <td> Loại động cơ : <%=rs.getString(8)%> </td>                     
                        </tr>
                        <tr> 
                            <td> Dung tích xy-lanh : <%=rs.getString(9)%> </td> 
                            <td> Công suất tối đa : <%=rs.getString(10)%> </td>                     
                        </tr>
                        <tr> 
                            <td> Dung tích nhớt máy : <%=rs.getString(11)%> </td> 
                            <td> Dung tích xăng : <%=rs.getString(12)%> </td>                     
                        </tr>
                        <tr> 
                            <td> Phanh trước/sau: <%=rs.getString(13)%> </td> 
                            <td> Hộp số : <%=rs.getString(14)%> </td>                      
                        </tr>
                    </tbody>
                </table>
                   <%
                        }
                   %> 
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
