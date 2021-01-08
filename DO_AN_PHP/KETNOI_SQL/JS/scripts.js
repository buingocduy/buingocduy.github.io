/*!
    * Start Bootstrap - SB Admin v6.0.2 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    (function($) {
    "use strict";

    // Add active state to sidbar nav links
    var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
        $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
            if (this.href === path) {
                $(this).addClass("active");
            }
        });

    // Toggle the side navigation
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });
})(jQuery);



 function validateForm()  
 {
             var u = document.getElementById("username").value;
             var p = document.getElementById("password").value;

             if(u === "") {
                 alert("Làm ơn nhập username");
                 return false;
             }
             if(p === "") {
                 alert("Làm ơn nhập Password");
                 return false;
             }
             
             alert("Đăng nhập thành công");
 
             return true;
         }

 function validateForm1()  
 {
             var hvt = document.getElementById("hovaten").value;
             var sdt = document.getElementById("sdt").value;
             var e = document.getElementById("email").value;
             var dc = document.getElementById("diachi").value;  
             
             if(hvt === "") {
                 alert("Làm ơn điền họ và tên");
                 return false;
             }
             if(sdt === "") {
                 alert("Làm ơn điền số điện thoại");
                 return false;
             }
             if(e === "") {
                 alert("Làm ơn điền email");
                 return false;
             }
             if(dc === "") {
                 alert("Làm ơn điền địa chỉ");
                 return false;
             }
             alert("Đặt hàng thành công bạn sẽ được liên hệ để xác minh đơn hàng");
             return true;
         }

function xoa()
{  
  var id = document.getElementById("id").value;    
  var xoa1=confirm('Bạn có muốn xóa '+id);   
  if (xoa1 === true) {
    alert("Xóa thành công");
    return true;
} else {
    alert("Hủy xóa");
    return false;
}
}
