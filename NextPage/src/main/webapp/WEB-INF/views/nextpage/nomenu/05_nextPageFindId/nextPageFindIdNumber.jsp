<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/templates/operator/assets/css/app.css">
  
    <main class="main" id="top">


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="py-0" id="forms-6">

    <div id="auth">

        <div class="row h-100">
            <div class="col-lg-5 col-12">
                <div id="auth-left">
                    <h1 class="auth-title">아이디찾기 인증번호</h1>
                    <p class="auth-subtitle mb-5">인증번호를 입력해주세요.</p>

                    <form action="findIdNumber.do" method="post">
                        
                        
                 	    <div class="form-group position-relative has-icon-left mb-4">
                            <label id="test" class="form-label" for="inputAuthentication">인증번호 3:00</label>
                  		   <input class="form-control form-control-xl" name="number" type="text" placeholder="인증번호를 입력해주세요" />
                            <div class="form-control-icon" style="margin-top:10px;">
                                <i class="bi bi-shield-lock"></i>
                            </div>
                        </div>
                        <div class="col-4">
               	 	  		<input class="btn btn-primary btn-block btn-lg shadow-lg mt-5" type="submit"  value="전송" />
                 	    </div>
                    </form>
                    <div class="text-center mt-5 text-lg fs-4">
                        <p class='text-gray-600'>Remember your account? <a href="auth-login.html" class="font-bold">Log
                                in</a>.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-7 d-none d-lg-block">
                <div id="auth-right">

                </div>
            </div>
        </div>

    </div>
    
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->


    </main>
    <script>
    var i=2;
    var j=60;
    var timer1 = setInterval(function(){
    	if(j==0)
    		{
    		
    		if(i==0)
    			{
    				alert("인증시간이 초과하였습니다!");
    				location.href='<%=request.getContextPath()%>/nextpage/findId.do'
    				
    				
    				j=0;
    				i=0;
    			}
    		else{
    			i--;
        		j=60;
    		}
    		}
    	j--;
        $("#test").html("인증번호 "+i+":"+j);
        if(j<10)
        	$("#test").html("인증번호 "+i+":0"+j);
        
       
    }, 1000)
    </script>