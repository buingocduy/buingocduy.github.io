<%-- 
    Document   : admin
    Created on : Dec 9, 2020, 9:50:50 PM
    Author     : BND6699
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

                <%
                    if(session.getAttribute("user1") == null){
                        response.sendRedirect("loginadmin.html");
                    }
                %>  

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> MOWO - MOTO WORLD </title>
        <link href="CSS/styles_1.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="JS/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="JS/chart-area-demo.js"></script>
        <script src="JS/chart-bar-demo.js"></script>
        <script src="JS/chart-pie-demo.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
<!--Logo-->             
           <a class="navbar-brand" href="admin.jsp"> Moto World </a>
     
<!--Logout--> 
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">        
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#"> Đổi mật khẩu </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="LogoutControl"> Đăng xuất </a>
                    </div>
                </li>
            </ul>
            </form>
        </nav>

        <!--Menu--> 
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading"> DANH MỤC </div>
                            <a class="nav-link collapsed" href="product.jsp" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-motorcycle"></i></div>
                                SẢN PHẨM
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="product.jsp?hang=HONDA">HONDA</a>
                                    <a class="nav-link" href="product.jsp?hang=YAMAHA">YAMAHA</a>
                                    <a class="nav-link" href="product.jsp?hang=SUZUKI">SUZUKI</a>
                                </nav>
                            </div> 
                            
                            
                            <a class="nav-link" href="user.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-users"></i></div>
                                TÀI KHOẢN
                            </a>  
                            
                            <a class="nav-link" href="donhang.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-boxes"></i></div>
                                ĐƠN HÀNG
                            </a>
                        </div>
                    </div>
                    
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        ${sessionScope.user1}
                    </div>
                </nav>
            </div>
        
<!--Content-->                     
            <div id="layoutSidenav_content">
                    <%    
                        String user = request.getParameter("username");
                        DBContext con = new DBContext();;
                        ResultSet rs = con.chondulieu("select * from taikhoan where username='" + user + "'"); 
                    %>
                    <form action="UpdateControl" method="get">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4"> SỬA TÀI KHOẢN </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"> <a href="admin.jsp"> DANH MỤC </a> </li>
                            <li class="breadcrumb-item active"> <a href="user.jsp"> TÀI KHOẢN </a> </li>
                            <li class="breadcrumb-item active"> SỬA TÀI KHOẢN </li>
                        </ol>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-users"></i>
                                Dữ liệu tài khoản
                            </div>
                            
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th> Tài khoản </th>
                                                <th> Email </th>
                                                <th> Số điện thoại </th>
                                            </tr>
                                        </thead>
                                        
                                        <%
                                            while(rs.next()){
                                        %>
                                        <tbody>
                                        <tr>      
                                            <input type="hidden" name="username" id="username" placeholder="username" value="<%=rs.getString(1)%>">
                                            <input type="hidden" name="password" id="password" placeholder="password" value="<%=rs.getString(2)%>"> 
                                            <td> <%=rs.getString(1)%> </td>
                                            <td> <input type="text" class="form-control py-4" name="email" id="email" value="<%=rs.getString(3)%>"> </td>
                                            <td> <input type="text" class="form-control py-4" name="phonenumber" id="phonenumber" value="<%=rs.getString(4)%>"> </td>
                                        </tr>   
                                        <%
                                            }
                                        %>
                                        </tbody>
                                    </table>                         
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                    <center> <input type="submit" value="Sửa" class="btn btn-primary"> </center> 
                    </form>
    
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted"> Copyright &copy; MOWO - MOTO WORLD 2020 </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </body>
</html>
