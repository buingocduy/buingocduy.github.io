<!DOCTYPE html>
<?php
require_once ('../db/dbhelper.php');

if(!empty($_POST)){
    $name = '';
    if(isset($_POST['name']))
    {
        $name = $_POST['name'];
        $hinhanh = $_POST['hinhanh'];
    }
    
    if(!empty($name))
    {

        $sql = 'INSERT INTO hang (tenhang,logo) 
                VALUES ("'.$name.'","'.$hinhanh.'")';
        execute($sql);
        header('Location: category.php');
        die();
    }
}
?>

<html lang="vi">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> ADMIN </title>
        <link href="../CSS/styles_1.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../JS/scripts.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="../JS/datatables-demo.js"></script>
        
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="index.html"> MOWO </a>
            
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                
            </form>
            
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Settings</a>
                        <a class="dropdown-item" href="#">Activity Log</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="login.html">Logout</a>
                    </div>
                </li>
            </ul>
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
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Quản trị viên
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4"> THÊM HÃNG </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="admin.php"> DANH MỤC </a></li>
                            <li class="breadcrumb-item active"> Thêm hãng </li>
                        </ol>
                       
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-users"></i>
                                Thông tin hãng
                            </div>
                            
                            <div class="card-body">
                                <form method="post">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="name"> Tên hãng </label>
                                                        <input class="form-control py-4" id="name" name="name" type="text"/>
                                                    </div>
                                                </div>
                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="name"> Hình ảnh </label>
                                                        <input class="form-control py-4" id="hinhanh" name="hinhanh" type="text"/>
                                                    </div>
                                                </div> 
                                            </div>
                                            <div class="form-group mt-4 mb-0">
                                                <button class="btn btn-primary btn-block"> THÊM </button>
                                            </div>
                                </form>
                            </div>
                        </div>     
                    </div>                    
                </main>
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
    </body>
</html>
