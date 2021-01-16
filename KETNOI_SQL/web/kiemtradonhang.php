<?php
require_once ('../db/dbhelper.php');
?>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> MOWO - MOTO WORLD </title>
        <link href="../CSS/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h1 class="text-center font-weight-light my-4"> KIỂM TRA ĐƠN HÀNG </h1></div>
                                    <div class="card-body">
                                        <?php                                                                                                               
                                        $sdt = $_GET['sdt'];
                                       
                                        $sql = "SELECT * FROM donhang where sdt = $sdt";   
                                        $categoryList = executeResult($sql);
                                        foreach ($categoryList as $item)
                                        {
                                            echo '
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <h5 style="color:red;"> THÔNG TIN KHÁCH HÀNG </h5> 
                                                        Mã đơn hàng: '.$item['id'].' 
                                                    </div>
                                                </div> 
                                                                                      
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        Trạng thái đơn hàng:';
                                                        
                                            if($item['trangthai'] == "Chờ xác nhận")
                                            {
                                               echo' <h5 style="color: red;"> '.$item['trangthai'].'  </h5>';
                                            } else{
                                               echo' <h5 style="color: green;"> '.$item['trangthai'].'  </h5>';
                                            }
                                            
                                            echo'                   
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputFirstName">Họ và tên</label>
                                                        <input class="form-control py-4" value="'.$item['tenkh'].'" type="text" disabled/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1"> Số điện thoại </label>
                                                        <input class="form-control py-4" value="'.$item['sdt'].'" type="text" disabled/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1"> Tên sản phẩm </label>
                                                        <input class="form-control py-4" value="'.$item['tensp'].'" type="text" disabled/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1"> Số lượng đã đặt </label>
                                                        <input class="form-control py-4" value="'.$item['soluongdat'].'" type="text" disabled/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1"> Tổng tiền $ </label>
                                                        <input class="form-control py-4" value="'.$item['tongtien'].'" type="text" disabled/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">Email</label>
                                                <input class="form-control py-4" value="'.$item['email'].'" type="text" disabled/>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">Địa chỉ</label>
                                                <input class="form-control py-4" value="'.$item['diachi'].'" type="text" disabled/>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">Ghi chú </label>
                                                <textarea class="form-control py-4" type="text" disabled/> '.$item['ghichu'].' </textarea>
                                            </div>              
                                            <p style="border-bottom: 2px solid black;"> </p>
                                        ';}?>
                                        <div class="form-group mt-4 mb-0">
                                                <a class="btn btn-primary btn-block" href="home.php"> Quay về trang chủ </a>
                                        </div>
                                    </div>
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
                            <div class="text-muted">HOTLINE: 0904596810</div>
                            <div class="text-muted">Copyright &copy; MOWO - MOTO WORLD 2020</div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>       
    </body>
</html>
