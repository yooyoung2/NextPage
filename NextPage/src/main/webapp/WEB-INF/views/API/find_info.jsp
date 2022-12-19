<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
       
    </head>
    <body id="page-top">
    <form id="memLogin" action="/middleProject/find_id_Servlet.do">
            <table>
               <tr class="loginInput">
                  <td style="padding-bottom: 12px;"><input  id="vid" type="text" name = "name1"  placeholder="이름" required><br></td>
                  <td rowspan="2"><input type = "submit" id = "Idsubmit" class ="finBut" value="확인" ></td>
               </tr>
               <tr  class="loginInput">
                  <td><input id="vpass" type="email" name="email1" placeholder="이메일" required><br></td>
               </tr>
            </table>
         
      </form>
    
   </body>

    
</html>