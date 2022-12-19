<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>


@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700,800,900');



.link {
  color: #c4c3ca;
}
.link:hover {
  color: #ffeba7;
}


.card-front{
  margin-left: 20%;
  margin-top: 6%;
  width: 540px;
  height: 530px;
  background-color: white;

  transition: box-shadow .3s;
  border-radius:10px;
  border: 1px solid #ccc;
  box-shadow: 0 0 11px rgba(33,33,33,.2); 


  background-position: bottom center;
  background-repeat: no-repeat;
  border-radius: 6px;
  top: 0;
  -webkit-transform-style: preserve-3d;
  transform-style: preserve-3d;
  -webkit-backface-visibility: hidden;
  -moz-backface-visibility: hidden;
  -o-backface-visibility: hidden;
  backface-visibility: hidden;
}

.center-wrap{
  position: absolute;
  width: 100%;
  padding: 0 35px;
  top: 50%;
  left: 0;
  transform: translate3d(0, -50%, 35px) perspective(100px);
  z-index: 20;
  display: block;
}


.form-group{ 
  position: relative;
  display: block;
    margin: 0;
    padding: 0;
}
.form-style {
  text-align : center;
  padding: 9px 28px;
  padding-left: 40px;
  height: 48px;
  width: 100%;
  font-weight: 500;
  border-radius: 4px;
  font-size: 14px;
  line-height: 22px;
  letter-spacing: 0.5px;
  outline: none;
  color: #2E2E2E;
  background-color: #EFF5FB;
  border: none;
  -webkit-transition: all 200ms linear;
  transition: all 200ms linear;
  box-shadow: 0 4px 8px 0 rgba(21,21,21,.2);
}
.form-style:focus,
.form-style:active {
  border: none;
  outline: none;
  box-shadow: 0 4px 8px 0 rgba(21,21,21,.2);
}

.form-group input:-ms-input-placeholder  {
  color: #c4c3ca;
  opacity: 0.7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input::-moz-placeholder  {
  color: #c4c3ca;
  opacity: 0.7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:-moz-placeholder  {
  color: #c4c3ca;
  opacity: 0.7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input::-webkit-input-placeholder  {
  color: #c4c3ca;
  opacity: 0.7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:focus:-ms-input-placeholder  {
  opacity: 0;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:focus::-moz-placeholder  {
  opacity: 0;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:focus:-moz-placeholder  {
  opacity: 0;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:focus::-webkit-input-placeholder  {
  opacity: 0;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}

#subBtn{  
  border-radius: 4px;
  height: 44px;
  width: 30%;
  margin-left: 36%;
  font-size: 13px;
  font-weight: 600;
  text-transform: uppercase;
  -webkit-transition : all 200ms linear;
  transition: all 200ms linear;
  padding: 0 30px;
  letter-spacing: 1px;
  display: -webkit-inline-flex;
  display: -ms-inline-flexbox;
  display: inline-flex;
  -webkit-align-items: center;
  -moz-align-items: center;
  -ms-align-items: center;
  align-items: center;
  -webkit-justify-content: center;
  -moz-justify-content: center;
  -ms-justify-content: center;
  justify-content: center;
  -ms-flex-pack: center;
  text-align: center;
  border: none;
  background-color: #A9BCF5;
  color: #102770;
  box-shadow: 0 8px 24px 0 rgba(255,235,167,.2);
}
#subBtn:active,
#subBtn:focus{  
  background-color: #102770;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}
#subBtn:hover{  
  background-color: #435ebe;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}

.form-control{
	text-align : center;
	margin-top: 20px;
    margin-bottom: 10px;
}
h5{
	color:red;
}
</style>
<main> <!-- ============================================-->
	<!-- <section> begin ============================-->
	<div class="card-front">
		<div class="center-wrap">
			<div class="section text-center">
				<form:form path="memvo" modelAttribute="memvo" commandName="memvo" class="row g-3"
				method="post" action="${pageContext.request.contextPath}/nextpage/mypage/delete/delAccountCheckPass">
				<h3>※ 계정탈퇴 안내 ※</h3>
					<h5>1. 탈퇴 전 이용권 취소하셨는지 확인 바랍니다.</h5>
					<h5>2. 이용권은 환불 되지 않으며 다음달 이용권 결제대상에서 제외됩니다.</h5>
					<h5>3. 계정 탈퇴신청 시 다음달 이용날짜 전까지<br>홈페이지가 유지 됩니다.</h5>
					<h5>4. 탈퇴 후 다시 재가입시에는 초기 비용이<br>다시 발생됩니다.</h5>
				<div class="form-group mt-2">
					<form:input path="npMemId" type="hidden" />
				<!-- ************비밀번호 입력 ************* -->
					<form:password path="memPw" class="form-control" showPassword="false" placeholder="탈퇴신청을 위해 비밀번호를 입력해주세요"/>
				</div>
				<button id="subBtn" class="btn mt-4">submit</button>
				</form:form>
   			</div>
 		</div>
  	</div>
</main>
