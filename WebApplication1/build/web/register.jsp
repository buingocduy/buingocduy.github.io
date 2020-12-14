<%-- 
    Document   : loginuser
    Created on : Nov 9, 2020, 4:46:12 PM
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
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> MOWO - MOTO WORLD </title> 
        <link href="CSS/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="JS/scripts.js"></script>
    </head> 

    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4"> <strong> TẠO TÀI KHOẢN </strong> </h3></div>
                                    <div class="card-body">
                                        <form method="GET" action="RegisterControl" onsubmit="return validateForm()">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputFirstName"> TÀI KHOẢN </label>
                                                        <input class="form-control py-4" id="username" name="username" type="text"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputConfirmPassword"> MẬT KHẨU </label>
                                                        <input class="form-control py-4" id="password" name="password" type="password"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress"> EMAIL </label>
                                                <input class="form-control py-4" id="email" name="email" type="email" aria-describedby="emailHelp"/>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1"> SỐ ĐIỆN THOẠI </label>
                                                        <input class="form-control py-4" id="phonenumber" name="phonenumber" type="number"/>
                                                    </div>
                                                </div> 
                                                  
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <br> 
                                                        <h4 style="color: red"> ${sessionScope.thongbao} </h4>
                                                    </div>
                                                </div>        
                                            </div>
                                            <button class="btn btn-primary btn-block" type="submit"> Tạo tài khoản  </button>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"> 
                                            <a href="loginuser.jsp" name="out" id="out"> 
                                                Có tài khoản rồi ? Đến trang đăng nhập
                                            </a> 
                                        </div>
                                    </div>
                                                    <%
                                                        {
                                                            if (request.getParameter("out") == null )
                                                            {
                                                                session.removeAttribute("thongbao");  
                                                            }
                                                        }
                                                    %>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
