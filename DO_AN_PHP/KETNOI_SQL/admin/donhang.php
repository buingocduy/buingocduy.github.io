<!DOCTYPE html>
<?php session_start();?>

<?php 
    if($_SESSION['USER'] == '')
    {
    header('Location: login.php');    
    }
?>
<?php
require_once ('../db/dbhelper.php');

if(!empty($_POST))
{
    $id = $_POST['id'];

    $sql = 'delete from donhang where id = "'.$id.'"';
    execute($sql);
    header('Location: donhang.php');
    die();

}
?>

<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> MOWO - MOTO WORLD </title>
        <link href="../CSS/styles.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="JS/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="../JS/chart-area-demo.js"></script>
        <script src="../JS/chart-bar-demo.js"></script>
        <script src="../JS/chart-pie-demo.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
<!--Logo-->             
           <a class="navbar-brand" href="admin.php"> Moto World </a>
     
<!--Logout--> 
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">        
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#"> Đổi mật khẩu </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="logout.php"> Đăng xuất </a>
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
                                <?php
                                        // lấy dữ liệu hãng ra
                                        $sql = 'select * from hang';   
                                        $categoryList = executeResult($sql);
                                        $index = 1;
                                        foreach ($categoryList as $item)
                                        {
                                            echo '<a class="nav-link" href="product.php?tenhang='.$item['tenhang'].'">'.$item['tenhang'].'</a>';                                            
                                        }
                                ?>       
                                </nav>
                            </div> 
                            
                            <a class="nav-link" href="category.php">
                                <div class="sb-nav-link-icon"> <i class="fas fa-warehouse"> </i></div>
                                HÃNG XE
                            </a>
                            
                            <a class="nav-link" href="donhang.php">
                                <div class="sb-nav-link-icon"><i class="fas fa-boxes"></i></div>
                                ĐƠN HÀNG
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                          <?php
                                //nếu có session tên dangnhap thì ta thực hiện lệnh dưới
                                if(isset($_SESSION['USER']) && $_SESSION['USER'] != NULL)
                                {
                                    echo $_SESSION['USER'];
                                                    
                                }
                        ?>  
                    </div>
                </nav>
            </div>
        
<!--Content-->                     
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4"> ĐƠN HÀNG
                        </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="admin.php"> DANH MỤC </a></li>
                            <li class="breadcrumb-item active"> 
                                QUẢN LÝ ĐƠN HÀNG          
                            </li>
                        </ol>  
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-motorcycle"></i>
                                Dữ liệu đơn hàng
        
                                &emsp; &emsp;
                                
                            </div>
                 
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th> ID </th>
                                                <th> Tên sản phẩm </th>
                                                <th> Số lượng đặt </th>
                                                <th> Tên khách hàng </th>
                                                <th> Số điện thoại </th>
                                                <th> Email </th>
                                                <th> Địa chỉ </th>
                                                <th> Ghi chú </th>
                                                <th> Chức năng </th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                        <?php                                                                                                               
                                        // lấy dữ liệu hãng ra
                                        $sql = "select * from donhang";   
                                        $categoryList = executeResult($sql);
                                        foreach ($categoryList as $item)
                                        {
                                            echo '<tr>
                                                        <td>'.$item['id'].'</td>
                                                        <td>'.$item['tensp'].'</td>  
                                                        <td>'.$item['soluongdat'].'</td>  
                                                        <td>'.$item['tenkh'].'</td>
                                                        <td>'.$item['sdt'].'</td>
                                                        <td>'.$item['email'].'</td>  
                                                        <td>'.$item['diachi'].'</td>  
                                                        <td>'.$item['ghichu'].'</td>                                                            
                                                        <td> 
                                                            <form method="post">
                                                            <input value="'.$item['id'].'" type="hidden" name="id" id="id">
                                                            <button class="btn btn-primary" name="xoa" id="xoa"> Xóa </button>
                                                            </form>
                                                        </td> 
                                                  </tr>';  
                                        }
                                        ?>
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
