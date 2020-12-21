<%-- 
    Document   : home
    Created on : Dec 11, 2020, 12:16:50 AM
    Author     : BND6699
--%>

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
          <a href="sanpham.jsp?hang=<%=rsx.getString(1)%>" class="list-group-item"> <img class="d-block img-fluid" src="Hinh/<%=rsx.getString(1)%>.jpg" alt="Khong tai duoc"> </a>
          <p> </p>
            <%
                }
            %>
        </div>
      </div>
                                   
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
            
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
            <%{
               String hang = request.getParameter("hang");
               out.print("<img class='d-block img-fluid' src='Hinh/"+hang+".jpg' alt='First slide'>");         
            }%>               
            </div>          
          </div>
            
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        
        <div class="row">  
                    <%     
                        String hang = request.getParameter("hang");
                        DBContext cxn = new DBContext();;
                        ResultSet rx = cxn.chondulieu("select * from sanpham where tenhang = '"+ hang +"'");
                    %>
                    <%
                       while(rx.next()){
                    %>                
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
                <div class="thumbnail">
              <a href="Xe1.jsp?id=<%=rx.getString(1)%>"> <img class="card-img-top" src=<%=rx.getString(4)%>  height="200" alt="khongtaiduoc"> </a>
                </div>
              <div class="card-footer">
                <h4 class="card-title">  <%=rx.getString(2)%> </h4>
              </div>
              
              <div class="card-body">
                <h5> <%=rx.getString(3)%> $ </h5>
              </div>
              
            </div>
          </div>
                      
                    <%
                        }
                    %> 
        </div>
        
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
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
