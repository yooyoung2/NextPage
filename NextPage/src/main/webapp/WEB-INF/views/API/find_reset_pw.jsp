<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
    </head>
    <body id="page-top">
    
   <h3 id="loginText">비밀번호 변경</h3>

   
      
      
   <!-- Password modifying Form  -->
      <form id="memLogin" action="/middleProject/find_pw_insert_Servlet.do" method="post">

         
            <table>
               <%
			String id=request.getParameter("id");
			System.out.println("이전페이지:"+id);
			request.setAttribute("id",id);
			%>
			<input type="hidden" name="id" value=<%=id %>>
               <tr class="loginInput">
                  <td style="padding-bottom: 12px;" class = "pw-change-label"><br><p>변경할 비밀번호</p></td>
                  <td ><input class = "pw-change-input"  type="text" name="pass1"  placeholder="비밀번호 입력" required> </td>
               </tr>
               <tr  class="loginInput">
                  <td class = "pw-change-label"><p>비밀번호 확인</p></td>
                  <td><input class = "pw-change-input" type="text" name="pass2" placeholder="비밀번호 재입력" required><br></td>
               </tr>
               
             
            </table>
            <input type="submit" value="제출">
          
      
      </form>

      
   
  
</body>
        
        <!-- Services-->
             
        
       
    </body>

</html>