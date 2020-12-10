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
        <link href="CSS/styles.css" rel="stylesheet" />
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
                            <a class="nav-link" href="product.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-motorcycle"></i></div>
                                SẢN PHẨM
                            </a>  
                            
                            <a class="nav-link" href="user.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-users"></i></div>
                                TÀI KHOẢN
                            </a>  
                            
                            <a class="nav-link" href="#">
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
                    <form action="InsertDPControl" method="get">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4"> THÊM SẢN PHẨM </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="admin.jsp"> DANH MỤC </a></li>
                            <li class="breadcrumb-item active"> <a href="product.jsp"> SẢN PHẨM </a></li>
                            <li class="breadcrumb-item active"> THÊM SẢN PHẨM </li>
                        </ol>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-motorcycle"></i>
                                Dữ liệu sản phẩm
                            </div>
                            
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th> Tên sản phẩm</th>
                                                <th> Hình ảnh</th>
                                                <th> Giá</th>                         
                                                <th> Dài Rộng Cao</th>
                                                <th> Chiều cao yên </th>
                                                <th> Vỏ trước/sau</th>
                                                <th> Động cơ</th>
                                                <th> Dung tích xi lanh</th>
                                                <th> Công suất</th>
                                                <th> Dung tích nhớt</th>
                                                <th> Dung tích xăng</th>
                                                <th> Thắng trước/sau</th>
                                                <th> Hộp số</th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody>                                            
                                        <tr>                                             
                                            <td> <input type="text" class="form-control py-4" name="name"> </td>
                                            <td> <input type="text" class="form-control py-4" name="image"> </td>
                                            <td> <input type="text" class="form-control py-4" name="price"> </td>
                                            <td> <input type="text" class="form-control py-4" name="LWH"> </td>
                                            <td> <input type="text" class="form-control py-4" name="seat"> </td>
                                            <td> <input type="text" class="form-control py-4" name="tire"> </td>
                                            <td> <input type="text" class="form-control py-4" name="engine"> </td>
                                            <td> <input type="text" class="form-control py-4" name="cc"> </td>
                                            <td> <input type="text" class="form-control py-4" name="power"> </td>
                                            <td> <input type="text" class="form-control py-4" name="oil"> </td>
                                            <td> <input type="text" class="form-control py-4" name="gasoline"> </td>
                                            <td> <input type="text" class="form-control py-4" name="brake"> </td>
                                            <td> <input type="text" class="form-control py-4" name="gearbox"> </td>
                                        </tr>   
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                    <center> <input type="submit" value="Thêm" class="btn btn-primary"> </center>
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
