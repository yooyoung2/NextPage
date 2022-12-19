<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>


.card {
	width: 700px;
	height: 510px;
	background: #fff;
	margin: 7% auto 0 auto;
	-webkit-transform: translatez(-50px);
	padding-top: 6%;
	box-shadow: 0 0 35px -20px #000;
	border-radius: 20px;
}

img{
width : 100px;
height : 100px;
margin-bottom : 5%;
}


</style>

    <main class="main" id="top">


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="card text-center" id="pricing-1">
      	<div>
      		<img src="${pageContext.request.contextPath }/resources/img/buy.png" >
      	</div>
                <h1 class="mb-3">첫 결제 이후 월10,000원</h1>
                <h5 class="mb-2">첫 결제시 제너레이팅 비용100,000원<br>+<br>
                				유지비용 일할계산가</h5>
                <br>
                <h6 class="text-500 mb-5 mt-2">첫 달 구매시 유지비용은 일할 계산으로 책정됩니다.<br><br>오늘의 일할가격은 마이페이지에서 확인 가능합니다.</h6>
                
      </section>
    </main>

