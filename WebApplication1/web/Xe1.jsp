<%-- 
    Document   : Xe1
    Created on : Oct 10, 2020, 11:23:25 PM
    Author     : BND6699
--%>

<%@page import="javax.persistence.criteria.Order"%>
<%@page import="entity.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
        <script src="JS/xejs.js" type="text/javascript"> </script> 
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/xecss.css" />
        <title> Moto world </title>
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
               <li><a href="home.html">Trang chủ</a> </li>
               <li><a href="register.html">Đăng ký</a> </li>
               <li> <a href="LoginUSER.html">Đăng nhập</a> </li>
               <li> <a href="cart.jsp"> <i class="fa fa-shopping-cart" id="cart"> </i> </a> </li>
           </ul>
        </div>
         
                   <%
                        String id = request.getParameter("id");
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham where id='"+id+"'");
                   %>
                   
                   <%
                      while(rs.next()){
                   %> 
<!--body-->            
        <div id="body">
            <div class="textcontent"> <center> <%=rs.getString(2)%> </center> </div>    
    <!--sidebar             
            <div id="sidebar">                 

                <div class="leftrangecontent">
                    <img src=<%=rs.getString(4)%> height="80%" width="100%" alt="Khong tai duoc"> 
                </div>
            </div>-->
    <!--content-->           
    
            <div id="content">               
                <div class="rightrangecontent">
                    
                    
                    <center> <img src=<%=rs.getString(4)%> height="100%" width-max="100%" alt="Khong tai duoc">
                    
                    
                    <%
                    if (request.getParameter("add") != null) {
                        entity.Item item = new entity.Item();

                        item.setId(Integer.parseInt(request.getParameter("id")));
                        item.setHinhanh(request.getParameter("hinhanh"));
                        item.setTensp(request.getParameter("tensp"));
                        item.setGia(Integer.parseInt(request.getParameter("gia")));
                        item.setSoluongmua(Integer.parseInt(request.getParameter("soluong")));                      
                        
                        java.util.ArrayList orders = new ArrayList();
                        if (session.getAttribute("Orders") != null) {
                            orders = ((java.util.ArrayList) session.getAttribute("Orders"));
                        }
                        
                        orders.add(item);
                        session.setAttribute("Orders", orders);
                        response.sendRedirect("cart.jsp");
                    }
                    %>
                    
                    <h2> Giá: <%=rs.getString(3)%>.000.000 VNĐ</h2>
                    <form onsubmit = "return validateForm()">
                        <input type="hidden" name="id" id="id" value="<%=rs.getInt(1)%>"/>
                        <input type="hidden" name="tensp" id="tensp" value="<%=rs.getString(2)%>"/>
                        <input type="hidden" name="gia" id="gia" value="<%=rs.getString(3)%>"/>
                        <input type="hidden" name="hinhanh" id="hinhanh" value="<%=rs.getString(4)%>"/>
                        Số lượng: <input type="number" name="soluong" id="soluong" value="1"/>
                        <button type="submit" name="add" class="fa fa-shopping-cart"> </button>
                    </form>
                      
                     <h2 style="color:red"> Thông số kỹ thuật </h2>
                     
                <table>
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
                </div>
                        </center>  
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
