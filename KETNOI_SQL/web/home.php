<?php
require_once ('../db/dbhelper.php');
?>

<!DOCTYPE html>
<html lang="vi">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title> MOWO - MOTO WORLD </title>
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
  <link href="../CSS/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="../CSS/shop-homepage.css" rel="stylesheet">
    <!-- Bootstrap core JavaScript -->
  <script src="../JS/jquery.min.js"></script>
  <script src="../JS/bootstrap.bundle.min.js"></script>
  <script src="../JS/scripts.js"></script>


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
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#">TRANG CHỦ
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#"> DỊCH VỤ </a>
          </li>
          <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> KIỂM TRA ĐƠN HÀNG </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <form action="kiemtradonhang.php" onsubmit="return kiemtradathang()">
                            <h5 style="text-align: center; color: red;"> SỐ ĐIỆN THOẠI </h5>
                            <input type="number" id="sdt" name="sdt" value="" class="form-control py-4" placeholder="SĐT: 0123456789"> <br>
                            <input type="submit" class="btn btn-primary btn-block" value="Kiểm tra">
                        </form>
                    </div>
                </li>
          </ul>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">                                 
      <div class="col-lg-3">
        <br>
        <div class="list-group">
          <?php
            // lấy dữ liệu hãng ra
            $sql = 'select * from hang';   
            $categoryList = executeResult($sql);
            foreach ($categoryList as $item)
            {
                echo '<a class="list-group-item" href="sanpham.php?tenhang='.$item['tenhang'].'"> <img class="d-block img-fluid" src='.$item['logo'].' alt="Khong tai duoc"> </a>  <p> </p>';                                            
            }
           ?>        
        </div>
      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">         
          <div class="carousel-inner" role="listbox">
            <?php
                // lấy dữ liệu hãng ra
                $sql = "select * from hang where tenhang = 'HONDA'";   
                $categoryList = executeResult($sql);
                foreach ($categoryList as $item)
                {
                    echo '
                            <div class="carousel-item active">
                                <img class="d-block img-fluid" src='.$item['logo'].' alt="First slide">
                            </div>
                         ';                                            
                }
            ?> 
              
            <?php
                // lấy dữ liệu hãng ra
                $sql = "select * from hang where not tenhang = 'HONDA'";   
                $categoryList = executeResult($sql);
                foreach ($categoryList as $item)
                {
                    echo '
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src='.$item['logo'].' alt="Second slide">
                            </div>
                         ';                                            
                }
            ?>          
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

          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"> <img class="card-img-top" src="../Hinh/new1.jpg" alt=""> </a>
              
              <div class="card-footer">
                <h4 class="card-title">
                  <a href="#"> HONDA </a>
                </h4>
              </div>
              
              <div class="card-body">
                <h5> GIÁ XE THÁNG 12 </h5>
                <p class="card-text">
                    Giá xe HONDA mới nhất tại các đại lý Việt Nam
                </p> 
              </div>
              
            </div>
          </div>

          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"> <img class="card-img-top" src="../Hinh/new2.jpg" alt=""> </a>
              
              <div class="card-footer">
                <h4 class="card-title">
                  <a href="#"> SUZUKI </a>
                </h4>
              </div>
              
              <div class="card-body">
                <h5> GIÁ XE THÁNG 12 </h5>
                <p class="card-text">
                    Giá xe SUZUKI mới nhất tại các đại lý Việt Nam
                </p> 
              </div>
              
            </div>
          </div>
            
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"> <img class="card-img-top" src="../Hinh/new3.jpg" alt=""> </a>
              
              <div class="card-footer">
                <h4 class="card-title">
                  <a href="#"> YAMAHA </a>
                </h4>
              </div>
              
              <div class="card-body">
                <h5> GIÁ XE THÁNG 12 </h5>
                <p class="card-text">
                    Giá xe YAMAHA mới nhất tại các đại lý Việt Nam
                </p> 
              </div>
              
            </div>
          </div>  
        
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
      <p class="m-0 text-center text-white">HOTLINE: 0904596810</p>
    </div>
    <!-- /.container -->
  </footer>
</body>

</html>
