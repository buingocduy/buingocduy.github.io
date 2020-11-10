/* global i, register */

function hinh()
{
   alert("Tính năng đang được hoàn thiện");
}

  function validateForm()  {
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


