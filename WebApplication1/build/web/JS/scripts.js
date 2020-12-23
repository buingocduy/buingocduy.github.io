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
             var e = document.getElementById("email").value;
             var ph = document.getElementById("phonenumber").value;  
             
             if(u === "") {
                 alert("Please enter your Username");
                 return false;
             }
             if(p === "") {
                 alert("Please enter you Password");
                 return false;
             }
             if(e === "") {
                 alert("Please enter your Email");
                 return false;
             }
             if(ph === "") {
                 alert("Please enter you Phonenumber");
                 return false;
             }
 
             alert("Okay")
 
             return true;
         }
         

function xoa()
{  
  var xoa1=confirm('Bạn có muốn xóa không?');   
  if (xoa1 === true) {
    alert("Xóa thành công");
} else {
    alert("Hủy xóa");
}
}
