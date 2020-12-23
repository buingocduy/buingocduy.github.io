<%-- 
    Document   : home
    Created on : Dec 11, 2020, 12:16:50 AM
    Author     : BND6699
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title> MOWO - MOTO WORLD </title>
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
  <link href="CSS/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="CSS/shop-homepage.css" rel="stylesheet">
  <link rel="stylesheet" href="CSS/newcss.css" type="text/css"/>
  <script src="JS/cartjs.js" type="text/javascript"> </script> 

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">  MOWO <i class="fa fa-motorcycle logo-icon"></i> </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">           
            <%{
                if(session.getAttribute("user") != null)
                {
                   out.print("<i class='nav-link'> " + session.getAttribute("user") +"</i> ");                
                }
            }%>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="home.jsp">TRANG CHỦ
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#"> DỊCH VỤ </a>
          </li>
          <li class="nav-item">
            <%{
              if(session.getAttribute("user") == null)
              {
                out.print("<a class='nav-link' href='loginuser.jsp'> ĐĂNG NHẬP </a>");   
              }else if(session.getAttribute("user") != null){
                out.print("<a class='nav-link' href='LogoutACCControl'  name='OUT'> ĐĂNG XUẤT </a>");  
              }
            }%>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="cart.jsp"> <i class="fa fa-shopping-cart"> </i>  </a>
          </li>        
        </ul>
      </div>
    </div>
  </nav>
                   
  <!-- Page Content -->
  <div class="container">

    <div class="row">

        <%
            DBContext conx = new DBContext();
            ResultSet rsx = conx.chondulieu("select * from hang");
        %>
                                  
      <div class="col-lg-3">
        <br>
        <div class="list-group">
            <%
                while(rsx.next()){
            %>  
          <a href="sanpham.jsp?hang=<%=rsx.getString(2)%>" class="list-group-item"> <img class="d-block img-fluid" src="<%=rsx.getString(3)%>" alt="Khong tai duoc"> </a>
          <p> </p>
            <%
                }
            %>
        </div>
      </div>
      <!-- /.col-lg-3 -->

                 
                
      <div class="col-lg-9">
        <center>
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">       
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                
            </div>                       
          </div>       
        </div> 
        </center>       
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">      
                <table class="table table-striped table-bordered table-list">                    
                        <tr>
                            <th> Sản phẩm </th>
                            <th> Tên sản phẩm </th>
                            <th> Giá </th>
                            <th> Số lượng </th>
                            <th> Tổng tiền </th>
                            <th> Chức năng </th>
                        </tr>
                               
                <%
                    entity.Item item = new entity.Item();
                    java.util.ArrayList orders = new ArrayList();                  
                    if (session.getAttribute("Orders") != null) {
                        orders = ((java.util.ArrayList) session.getAttribute("Orders"));
                    }
 
                    int count = orders.size() -1;
                    if (count > -1) 
                    {
                        item = (entity.Item) orders.get(count);
                        
                        if (request.getParameter("id") != null) {                          
                            if (item.getId() == (Integer.parseInt(request.getParameter("id")))) 
                            {
                                orders.remove(item);                       
                                session.removeAttribute("Orders");                       
                                response.sendRedirect("cart.jsp");
                            }
                        }
                        
                        int tongtien=item.getSoluongmua()* item.getGia();
                          
                        out.print("<tr>"); 
                        out.print("<td>" + "<image src="+item.getHinhanh()+" with=100; height=100>" + "</td>");
                        out.print("<td>" + item.getTensp()+ "</td>");               
                        out.print("<td>" + item.getGia()+" $"+ "</td>");
                        out.print("<td>" + item.getSoluongmua()+ "</td>");
                        out.print("<td>" + tongtien +" $"+ "</td>");
                        out.print("<td> <a href='?id="+item.getId()+"'> Xóa </a> </td>");                      
                        out.print("</tr>");        
                    }                
                %>                    
                </table> <br>
                
                <%
                    if (request.getParameter("mua") != null )
                    {
                        if  (session.getAttribute("user") != null && session.getAttribute("Orders") != null) 
                        {
                                session.setAttribute("cart", orders);
                                session.removeAttribute("Orders");              
                                response.sendRedirect("cart.jsp");
                        }
                    }
                %>
                
                <center>
                    <form method="GET" action="InsertCart" onsubmit = "return validateForm()">
                        <button class="btn btn-primary" type="submit" id="mua" name="mua"> Đặt hàng </button> </br> </br>
                        <input type="hidden" id="user" name="user" value="${sessionScope.user}">
                        <input type="hidden" id="order" name="order" value="${sessionScope.Orders}">
                        <%                      
                            out.print("<input type='hidden' id='tensp' name='tensp' value='"+ item.getTensp()+ "'>"); 
                            out.print("<input type='hidden' id='soluongmua' name='soluongmua' value='"+ item.getSoluongmua()+ "'>");
                            out.print("<input type='hidden' id='tongtien' name='tongtien' value='"+ item.getSoluongmua() * item.getGia() + "'>");
                        %>
                    </form>            
                </center>
        </div>           
        </div>
                    
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div> <br>
    <!-- /.row -->
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; MOWO - MOTO WORLD 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="JS/jquery.min.js"></script>
  <script src="JS/bootstrap.bundle.min.js"></script>

</body>

</html>
