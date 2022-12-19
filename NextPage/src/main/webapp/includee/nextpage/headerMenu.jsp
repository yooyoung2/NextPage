<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">

<nav
	class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0 px-4 px-lg-5">
	<a href="<%=request.getContextPath()%>/nextpage/nextPageMain"
		class="d-flex align-items-center">
		<h2 class="m-0" style="color:black; font-family: 'Audiowide', sans-serif;">
			<img class="img-fluid me-2" src="img/icon-1.png" alt=""
				style="width: 45px;">NEXTPAGE
		</h2>
	</a>
	<button type="button" class="navbar-toggler" data-bs-toggle="collapse"
		data-bs-target="#navbarCollapse">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<div class="navbar-nav ms-auto py-4 py-lg-0" style="margin-right: 5%;">
<%-- 			<div class="nav-item dropdown">
				<a
					href="<%=request.getContextPath()%>/nextpage/user/company/info.do"
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown">회사소개</a>
				<div class="dropdown-menu shadow-sm m-0">
					<a
						href="<%=request.getContextPath()%>/nextpage/user/company/info.do"
						class="dropdown-item">인사말</a> <a
						href="<%=request.getContextPath()%>/nextpage/compnay/team/intro.do"
						class="dropdown-item">탐구성</a> <a
						href="<%=request.getContextPath()%>/nextpage/compnay/onway.do"
						class="dropdown-item">오시는길</a>
				</div>
			</div> --%>
			<div class="nav-item dropdown">
				<a href="<%=request.getContextPath()%>/nextpage/template/free.do"
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="margin-right: 100px;">템플릿</a>
				<div class="dropdown-menu shadow-sm m-0">
					<a href="<%=request.getContextPath()%>/nextpage/template/free.do"
						class="dropdown-item">템플릿소개</a>
				</div>
			</div>
			<a
				href="<%=request.getContextPath()%>/nextpage/nextPageSystemUseGuide"
				class="nav-item nav-link" style="margin-right: 100px;">시스템이용가이드</a> 
				<a href="<%=request.getContextPath()%>/nextpage/nextPageChargeGuide"
				class="nav-item nav-link" style="margin-right: 100px;">요금안내</a>
				
				<!--
					작성자 : 최현우 
					로그인 한 아이디의 권한이 'ADMIN'일 경우 운영자페이지로 갈 수 있는 버튼을 추가한다. 
				-->
				<%-- <c:if test="${not empty sessionScope.auth }">
					<a href="<%=request.getContextPath()%>/operator/index"
					class="nav-item nav-link">운영자페이지</a>
				</c:if> --%>
				<%-- <c:if test="${empty sessionScope.auth }">
					<a href="<%=request.getContextPath()%>/operator/index"
					class="nav-item nav-link">세션비었어~</a>
				</c:if> --%>
				<!-- 최현우 작성 끝 -->
			<div class="nav-item dropdown">
				<a
					href="<%=request.getContextPath()%>/nextpage/service/memcenter.do"
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="margin-right: 100px;">고객센터</a>
				<div class="dropdown-menu shadow-sm m-0">
					<a
						href="<%=request.getContextPath()%>/nextpage/service/memcenter.do"
						class="dropdown-item">공지사항</a> <a
						href="<%=request.getContextPath()%>/nextpage/user/faqList"
						class="dropdown-item">FAQ</a>
				</div>
			</div>
		</div>
		<c:if test="${empty sessionScope.authSch }">
			<div class="h-100 d-lg-inline-flex align-items-center d-none">
				<a class="btn btn-square rounded-circle bg-light text-primary me-2"
					href="<%=request.getContextPath()%>/nextpage/user/signup.do"> <i
					class="fa fa-user-plus"></i></a> <a
					class="btn btn-square rounded-circle bg-light text-primary me-2"
					href="${pageContext.request.contextPath }/nextpage/user/login.do">

					<i class="fa fa-sign-in-alt"></i>
				</a>
			</div>
		</c:if>
		<c:if test="${not empty sessionScope.authSch }">
			<c:choose>
				<c:when test="${sessionScope.nextAuth eq 'MEMBER' }">
					<div class="h-100 d-lg-inline-flex align-items-center d-none">
						<a class="btn btn-square rounded-circle bg-light text-primary me-2"
							href="${pageContext.request.contextPath }/nextpage/mypage/info.do">

							<i class="fa fa-user-circle"></i>
						</a>

						<form name="logoutForm" method="post"
							action="${pageContext.request.contextPath }/login/logout.do"></form>
						<a class="btn btn-square rounded-circle bg-light text-primary me-2"
							href="#" onclick="document.logoutForm.submit(); return false;">

							<i class="fa fa-sign-out-alt"></i>
						</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="h-100 d-lg-inline-flex align-items-center d-none">
						<a class="btn btn-square rounded-circle bg-light text-primary me-2"
							href="${pageContext.request.contextPath }/operator/index">

							<i class="fa fa-user-circle"></i>
						</a>

						<form name="logoutForm" method="post"
							action="${pageContext.request.contextPath }/login/logout.do"></form>
						<a class="btn btn-square rounded-circle bg-light text-primary me-2"
							href="#" onclick="document.logoutForm.submit(); return false;">

							<i class="fa fa-sign-out-alt"></i>
						</a>
					</div>
				</c:otherwise>
			</c:choose>


		</c:if>


	</div>
</nav>
<!-- Navbar End -->

