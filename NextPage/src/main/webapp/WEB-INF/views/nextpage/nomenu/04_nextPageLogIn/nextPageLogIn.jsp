<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/templates/operator/assets/css/app.css"> 

<style>
#formBox{
	margin-top:13%;
	margin-left: 5%;
}

.autoBtn{
    width: 33%;
}
.loginBtn{
	background-color: #6fbee3;
	border: #6fbee3;
}
</style>
 

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

<section class="py-0" id="forms-6" style="margin-left: 20%;">
	<div class="row h-100 ">
		<div id="formBox" class="col-lg-5 col-12">
			<div>
				<div class="auth-logo">
					<img
						src="<%=request.getContextPath()%>/resources/templates/nextpage/img/logo2.png"
						alt="Logo">
				</div>
				<!-- <h1 class="auth-title">&nbsp;Log in.</h1> -->
				<p class="auth-subtitle mb-5">&nbsp;NextPage에 오신것을 환영합니다 :)!</p>

				<form
					action="${pageContext.request.contextPath }/nextpage/user/loginProcess.do"
					method="post">
					<div class="form-group position-relative has-icon-left mb-4">
						<input name="npMemId" class="form-control form-control-xl"
							placeholder="ID">
						<div class="form-control-icon">
							<i class="bi bi-person"></i>
						</div>
					</div>
					<div class="form-group position-relative has-icon-left mb-4">
						<input name="memPw" type="password"
							class="form-control form-control-xl" placeholder="Password" >
						<div class="form-control-icon">
							<i class="bi bi-shield-lock"></i>
						</div>
					</div>
			<!--  시연할때 자동로그인 시킬 버튼 -->		
					<div class="col-6 d-grid form-group" style="margin-right: 1%; width:32%;">
						<input type="button" id="adnminBtn" class="loginBtn btn btn-primary"
							onclick="location.href='<%=request.getContextPath()%>/nextpage/autoLogin/admin'"	value="ADMIN" />
					</div>
					<div class="col-6 d-grid " style="float: right; width:32%; margin-top: -47px; margin-right:34%;">
						<input type="button" id="yyTest" class="loginBtn btn btn-primary"
							onclick="location.href='<%=request.getContextPath()%>/nextpage/autoLogin/yyTest'"	value="TEST" />
					</div>
					<div class="col-6 d-grid " style="float: right; margin-top: -47px; width:32%; margin-right: -1%;">
						<input type="button" id="dditBtn" class="loginBtn btn btn-primary"
							onclick="location.href='<%=request.getContextPath()%>/nextpage/autoLogin/ddit'"	value="DDIT"/>
					</div>
			<!-- 시연버튼 끝 -->		

					<div class="col-12 d-grid">
						<input type="submit" class="loginBtn btn btn-primary btn-block btn-lg shadow-lg mt-5" value="로그인"/>
					</div>
					<!-- ==================login log start 구지현=============================-->
					<div hidden>
						<input type="text" name="logTypeId" class="form-control" value="1" />
					</div>
					<div hidden>
						<input type="text" name="logHpnId" class="form-control" />
					</div>
					<div hidden>
						<input type="text" name="logCntnt" class="form-control"
							value="로그인"  />
					</div>

					<!-- ==================login log end=============================-->


					<div class="text-center mt-5 text-lg fs-4"></div>
					<div class="col-6 d-grid form-group" style="margin-right: 1%;">
						<!-- <input class="btn btn-primary" type="submit"  value="ID 찾기"/> -->
						<input type="button" class="loginBtn btn btn-primary"
							onclick="location.href='<%=request.getContextPath()%>/nextpage/findId.do'"	value="아이디찾기" />
					</div>
					<div class="col-6 d-grid "
						style="float: right; margin-top: -47px; margin-right: -1%;">
						<input type="button" class="loginBtn btn btn-primary"
							onclick="location.href='<%=request.getContextPath()%>/nextpage/findPw.do'"	value="비밀번호찾기"/>
					</div>
				</form>

			</div>
			<div class="text-center mt-5 text-lg fs-4">
				<p class="text-gray-600">
					아직 회원이 아니신가요? <a
						href="<%=request.getContextPath()%>/nextpage/user/signup.do"
						class="font-bold" style="color:#6fbee3;">Sign up</a>.
				</p>
			</div>
		</div>
	</div>
</section>

<script>

</script>