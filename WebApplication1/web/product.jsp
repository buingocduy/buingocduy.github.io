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
                            <a class="nav-link collapsed" href="product.jsp" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-motorcycle"></i></div>
                                SẢN PHẨM
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <%
                                        DBContext conx = new DBContext();
                                        ResultSet rsx = conx.chondulieu("select * from hang");
                                    %>
                                    <%
                                            while(rsx.next()){
                                    %>
                                    <a class="nav-link" href="product.jsp?hang=<%=rsx.getString(1)%>"><%=rsx.getString(1)%></a>
                                    <%
                                            }
                                    %>
                                </nav>
                            </div> 
                             
                            <a class="nav-link" href="hangxe.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-warehouse"></i></div>
                                HÃNG XE
                            </a> 
                                
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
                        String hang = request.getParameter("hang");
                        DBContext con = new DBContext();
                        ResultSet rs = con.chondulieu("select * from sanpham where tenhang = '"+hang+"'");
                        ResultSet rx = con.chondulieu("select * from hang where tenhang = '"+hang+"'");
                    %>
                <main>
                        <%
                            while(rx.next()){
                        %>
                    <div class="container-fluid">
                        <h1 class="mt-4"> SẢN PHẨM  <%=rx.getString(1)%>

                        </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="admin.jsp"> DANH MỤC </a></li>
                            <li class="breadcrumb-item active"> 
                                SẢN PHẨM <%=rx.getString(1)%>            
                            </li>
                        </ol>
                        <%
                            }
                        %>     
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-motorcycle"></i>
                                Dữ liệu sản phẩm 
        
                                &emsp; &emsp;
                                
                                <a href="IPD.jsp" class="btn btn-primary"> Thêm sản phẩm </a>
                            </div>
                 
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th> Chức năng </th>
                                                <th> ID</th>
                                                <th> Hình ảnh</th>
                                                <th> Tên sản phẩm</th>
                                                <th> Giá $</th>                         
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
                                                <th> Hãng </th>
                                            </tr>
                                        </thead>
                                        
                                        <%
                                            while(rs.next()){
                                        %>
                                        
                                        <tbody>
                                        <tr>
                                            <td> 
                                                <div class="nav-link">
                                                    <div class="sb-nav-link-icon">
                                            <!--Xóa-->            
                                                        <a href="DeleteDPControl?id=<%=rs.getString(1)%>">
                                                            <i class="fa fa-trash"> </i>   
                                                        </a> &emsp; &emsp;
                                            <!--Sửa-->              
                                                        <a href="UPD.jsp?id=<%=rs.getString(1)%>">
                                                            <i class="fas fa-pencil-alt"> </i>   
                                                        </a>                                                      
                                                    </div>
                                                </div>
                                            </td>
                                            <td> <%=rs.getString(1)%> </td>
                                            <td> <img src=<%=rs.getString(4)%> height="30%" width-max="30%" alt="Khong tai duoc"> </td>
                                            <td> <%=rs.getString(2)%> </td>
                                            <td> <%=rs.getString(3)%> $ </td>
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
                                            <td> <%=rs.getString(15)%> </td>
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
