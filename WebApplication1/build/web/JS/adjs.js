function hinh()
{
   alert("Tính năng đang được hoàn thiện");
}


function AutoRefresh( t ) 
{
   var user = document.getElementById("user").value;  
   
   if(user === null)
   {
   setTimeout("location.reload(true);", t);
   }
}


