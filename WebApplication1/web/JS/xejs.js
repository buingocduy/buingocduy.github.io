function hinh()
{
   alert("Tính năng đang được hoàn thiện");
}

  function validateForm()  
{
     var sl = document.getElementById("soluong").value; 
     
            if(sl === "") {
                 alert("Làm ơn thêm số lượng");
                 return false;
            }
            
            if(sl == 0) {
                 alert("Làm ơn thêm số lượng");
                 return false;
            }
 
             alert("Thêm thành công")
 
             return true;
}
