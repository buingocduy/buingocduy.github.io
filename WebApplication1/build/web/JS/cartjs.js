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
   
   alert("Đặt hàng thành công \n"+user+" sẽ được liên hệ sau vài phút để xác nhận");
   
   return true;
}








