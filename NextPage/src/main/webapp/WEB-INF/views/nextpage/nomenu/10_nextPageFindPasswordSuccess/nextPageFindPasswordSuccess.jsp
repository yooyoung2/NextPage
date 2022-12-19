<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



    <div class="preloader" id="preloader" data-preloader>
      <div class="preloader-wrapper big active" data-preloader>
        <div class="spinner-layer spinner-white-only">
          <div class="circle-clipper left">
            <div class="circle"></div>
          </div>
          <div class="gap-patch">
            <div class="circle"></div>
          </div>
          <div class="circle-clipper right">
            <div class="circle"></div>
          </div>
        </div>
      </div>
    </div>

    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
    <main class="main" id="top">


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="py-0" id="forms-6">

        <div class="bg-holder overlay overlay-0" style="background-image:url(<%=request.getContextPath()%>/resources/slick-v2.0.0/public/assets/img/login.jpg);"> 
        </div>
        <!--/.bg-holder-->

        <div class="container">
          <div class="row min-vh-100 align-items-center justify-content-md-center justify-content-lg-start py-6">
            <!-- <div class="col-md-10 col-lg-6">
              <h1 class="fw-light text-white lh-2">Discover what’s <br />possible when there is <br class="d-none d-sm-block" /><span class="fw-semi-bold">172 layouts </span>ready<br />at your fingertip</h1>
              <p class="lead text-400 mt-5 pe-md-9">Have the power to build professional websites faster than ever before.</p>
            </div> -->
            <div class="col-md-10 col-lg-6 col-xl-6 px-lg-5">
            <h3 style="color:white;">PW</h3>
              <div class="bg-white rounded-3 p-5">
                <form class="row g-3">
                  <div class="col-12">
                  <p>비밀번호</p>
                  </br>
                    '학교명'님의 임시비밀번호는 '1234'입니다.  <br> 마이페이지에서 변경해주세요.
                  </div>

                  <div class="col-12 d-grid">
                    <button class="btn btn-danger" type="submit" name="submit">로그인하기</button>
                  </div>
            
                </form>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->


    </main>
    <!-- ===============================================-->
   