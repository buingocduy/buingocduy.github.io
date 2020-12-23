<%-- 
    Document   : home
    Created on : Dec 11, 2020, 12:16:50 AM
    Author     : BND6699
--%>

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
                   <%
                        String id = request.getParameter("id");
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from sanpham where id='"+id+"'");
                   %>
                   
                   <%
                      while(rs.next()){
                   %> 
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
                    
               
      <div class="col-lg-9">
        <center>
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">       
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                <img class="d-block img-fluid" src=<%=rs.getString(4)%>  alt="Firstslide">
                <h4 style="color: red;"> <%=rs.getString(2)%> </h4>
                <h4> Giá: <%=rs.getString(3)%> $</h4>
                <form onsubmit = "return validateForm1()">
                        <input type="hidden" name="id" id="id" value="<%=rs.getInt(1)%>"/>
                        <input type="hidden" name="tensp" id="tensp" value="<%=rs.getString(2)%>"/>
                        <input type="hidden" name="gia" id="gia" value="<%=rs.getString(3)%>"/>
                        <input type="hidden" name="hinhanh" id="hinhanh" value="<%=rs.getString(4)%>"/>
                        Số lượng : <input type="number" name="soluong" id="soluong" value="1"/>                     
                        <button class="btn btn-primary" type="submit" name="add">
                            <i class="fa fa-shopping-cart"> </i> 
                        </button>
                </form>
            </div>                       
          </div>       
        </div> 
        </center>  
     
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                <table class="table table-striped table-bordered table-list">
                    <tbody>
                        <tr> 
                            <td> <strong> Dài x Rộng x Cao : </strong> <%=rs.getString(5)%> </td> 
                            <td> <strong> Độ cao yên : </strong> <%=rs.getString(6)%> </td>                     
                        </tr>
                        <tr> 
                            <td> <strong> Cỡ lốp trước/sau : </strong> <%=rs.getString(7)%> </td> 
                            <td> <strong> Loại động cơ : </strong> <%=rs.getString(8)%> </td>                     
                        </tr>
                        <tr> 
                            <td> <strong> Dung tích xy-lanh : </strong> <%=rs.getString(9)%> </td> 
                            <td> <strong> Công suất tối đa : </strong> <%=rs.getString(10)%> </td>                     
                        </tr>
                        <tr> 
                            <td> <strong> Dung tích nhớt máy : </strong> <%=rs.getString(11)%> </td> 
                            <td> <strong> Dung tích xăng : </strong> <%=rs.getString(12)%> </td>                     
                        </tr>
                        <tr> 
                            <td> <strong> Phanh trước/sau: </strong> <%=rs.getString(13)%> </td> 
                            <td> <strong> Hộp số : </strong> <%=rs.getString(14)%> </td>                      
                        </tr>
                    </tbody>
                </table>    
        </div>           
        </div>
                    <%
                        }
                    %> 
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
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
