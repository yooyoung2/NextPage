<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/templates/operator/assets/css/app.css">
  
  
  
 <style>
 #formBox{
    margin-left: 20%;
    margin-top: 10%;
    
 }
 
 #findBtn{
	width: 388px;
	
 }
 
.auth-title{
 color:#6fbee3;
 text-align: center;
 
 }
.auth-subtitle{
 text-align: center;
}
 </style>
  
    <main class="main" id="top">


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="py-0" id="forms-6">

    <div id="auth">
		
		<%
		String msg=(String)request.getAttribute("msg");
		if(msg!=null)
		{
			%>
			  Swal.fire({
    	  position: 'top-end',
    	  icon: 'success',
    	  title: '${msg}',
    	  showConfirmButton: false,
    	  timer: 1500
    	})
			<%
		}
			 %>
		
        <div class="row h-100">
            <div id="formBox" class="col-lg-5 col-12">
                    <h1 class="auth-title">아이디찾기</h1>
                    <p class="auth-subtitle mb-5">이메일 인증 후 이용하세요.</p>

                    <form action="findId.do" method="post">
                        <div class="form-group position-relative has-icon-left mb-4">
                            <label class="form-label" for="inputSchoolName">학교명</label>
                  		    <input class="form-control form-control-xl" type="text" placeholder="학교명을 입력해주세요" name="schNm" />
                            <div class="form-control-icon" style="margin-top:10px;">
                                <i class="bi bi-person"></i>
                            </div>
                        </div>
                        <div class="form-group position-relative has-icon-left mb-4">
                            <label class="form-label" for="inputEmail">이메일</label>
                  		    <input class="form-control form-control-xl" id="inputEmail" type="text" placeholder="이메일을 입력해주세요" name="schEmail"/>
                            <div class="form-control-icon" style="margin-top:10px;">
                                <i class="bi bi-envelope"></i>
                            </div>
                        </div>
                        <div class="col-4">
               	 	  		<input id="findBtn" class="btn btn-primary btn-block btn-lg shadow-lg mt-5" type="submit"
               	 	  			style="background-color: #6fbee3;; border: #6fbee3;;"  value="전송" />
                 	    </div>
                 	    
                    </form>
                    <div class="text-center mt-5 text-lg fs-4">
                        <p class='text-gray-600'>Remember your account? <a href="auth-login.html" style="color:#6fbee3;" class="font-bold">Log
                                in</a>.
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->


    </main>
    