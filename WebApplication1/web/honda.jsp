<%-- 
    Document   : honda
    Created on : Oct 22, 2020, 5:27:35 PM
    Author     : BND6699
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Moto world </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
        <script src="JS/indexjs.js" type="text/javascript"> </script> 
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/indexcss.css" />
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
               <li> <a href="home.html">Home</a> </li> 
               <li> <a href="honda.jsp" onclick="hinh()">About</a> </li> 
               <li> <a href="Login.html">Login</a> </li>
               <li> <a href="cart.jsp"> <i class="fa fa-shopping-cart" id="cart"> </i> </a> </li>
           </ul>
        </div>
 
<!--body-->            
        <div id="body">
            
    <!--content-->
            <div id="content"> 
                <div class="textcontent"> <center> HONDA </center> </div>
                <div class="grid">
                   <%
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham");
                   %>
                   <%
                      while(rs.next()){
                   %>
                    <div class="rangecontent">                     
                        <a href="Xe1.jsp?id=<%=rs.getString(1)%>">
                            <img src=<%=rs.getString(4)%> height="200" width="200" alt="Khong tai duoc"> 
                        </a>    
                        <div class="bottomrangecontent">
                            <p class="texttitle"> <%=rs.getString(2)%> </p> 
                            <p class="textprice"> <%=rs.getString(3)%> </p>
                            <a href="Xe1.jsp?id=<%=rs.getString(1)%>">
                            <input type="button" name="1" value="Xem thông tin chi tiết"> 
                            </a>
                        </div>
                    </div>
                    <%
                        }
                    %>          
                </div>       
            </div> 
                
    <!--sidebar-->        
            <div id="sidebar">               
                <div class="gridsidebar">  
                    <div class="rangersidebar"> 
                        <img src="Hinh/ya.jpg"  height="110" width="220" alt="Khong tai duoc" onclick="hinh()"> 
                    </div>             
                    <div class="rangersidebar">  
                        <img src="Hinh/su.jpg" height="110" width="220" alt="Khong tai duoc" onclick="hinh()"> 
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
