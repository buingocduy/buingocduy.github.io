function hinh()
{
   alert("Tính năng đang được hoàn thiện");
}

function tin()
{
   alert("Đang cập nhật");
}

function validateForm() 
{
   var user = document.getElementById("user").value;  
   var order = document.getElementById("order").value;  
   
   if(user === ""){
     alert("Làm ơn đăng nhập");
     return false;
   }
   if(order === ""){
     alert("Làm ơn thêm sản phẩm vào giỏ hàng");
     return false;
   }
   
   alert("Đặt hàng thành công \n"+user+" sẽ được liên hệ để xác nhận đơn hàng");
   
   return true;
}


function validateForm1() 
{
   var soluong = document.getElementById("soluong").value;  
 
   if(soluong > 10)
   {
     alert("Chỉ đặt số lượng dưới 10");
     return false;
   }
   
   return true;
}








