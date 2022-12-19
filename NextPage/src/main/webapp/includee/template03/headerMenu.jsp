<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
	TEMPLATE 03 HEADER MENU
 -->
 
<style>
	.img-size{
		width : 200px;
		height : 70px;
	}
</style> 
 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!-- Start header -->
	<header class="top-navbar"> <!-- header 태그 시작 -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<!-- <div class="container-fluid"> --> <!-- container 시작 -->
				<!--
					/resources/templates/template03/images
				 -->
				<a href="${pageContext.request.contextPath}/generation/${sessionScope.id}/main">
					<img class = "img-size" src="<%= request.getContextPath() %>/resources/templatesPreview/images/schLogo/${sessionScope.fileName}" alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-host" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
					<span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
				</button>

				${sessionScope.headerView }

				<!-- <div class="collapse navbar-collapse" id="navbars-host"> -->
					<!-- 목록 시작되는 부분 -->
					<!-- <ul class="navbar-nav ml-auto"> -->

						<!-- 얘네는 드롭다운 없는 애들 -->
						<!-- <li class="nav-item active"><a class="nav-link" href="index.html">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="about.html">About Us</a></li> -->

						<!-- 드롭다운 있는 애들 -->
						<!-- 드롭다운 1번 -->
				<!-- 		<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="dropdown-a" data-toggle="dropdown">Course </a>
							<div class="dropdown-menu" aria-labelledby="dropdown-a">
								<a class="dropdown-item" href="course-grid-2.html">Course Grid 2 </a>
								<a class="dropdown-item" href="course-grid-3.html">Course Grid 3 </a>
								<a class="dropdown-item" href="course-grid-4.html">Course Grid 4 </a>
							</div>
						</li> -->

						<!-- 드롭다운 2번 -->
					<!-- 	<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="dropdown-a" data-toggle="dropdown">Blog </a>
							<div class="dropdown-menu" aria-labelledby="dropdown-a">
								<a class="dropdown-item" href="blog.html">Blog </a>
								<a class="dropdown-item" href="blog-single.html">Blog single </a>
							</div>
						</li> -->

						<!-- 얘네도 드롭다운이 아니라 그냥 일반 목록 -->
						<!-- <li class="nav-item"><a class="nav-link" href="teachers.html">Teachers</a></li>
						<li class="nav-item"><a class="nav-link" href="pricing.html">Pricing</a></li>
						<li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li> -->
						<!-- 일반 목록 끝 -->

					<!-- </ul> -->
					<!-- 목록 끝 -->

					 <ul class="nav navbar-nav navbar-right">
					 	<c:if test="${empty sessionScope.authMem }">
	                        <%-- <li><a class="hover-btn-new log orange" href="<%= request.getContextPath() %>/generation/${sessionScope.id}/login" data-toggle="modal" data-target="#login"><span>LOG IN</span></a></li> --%>
	                        <li><a class="hover-btn-new log orange" href="<%= request.getContextPath() %>/generation/${sessionScope.id}/login"><span>로그인</span></a></li>
					 		<li><a class="hover-btn-new log orange" href="<%= request.getContextPath() %>/generation/${sessionScope.id }/join"><span>회원가입</span></a></li>
					 	</c:if>
					 	<c:if test="${not empty sessionScope.authMem }">
					 		<li><a class="hover-btn-new log orange" href="<%= request.getContextPath() %>/generation/${sessionScope.id}/logout"><span>로그아웃</span></a></li>
					 		<li><a class="hover-btn-new log orange" href="<%=request.getContextPath() %>/generation/${sessionScope.id}/generatingMyPage/view"><span>마이페이지</span></a></li>
					 	</c:if>
                    </ul>
				<!-- </div> -->
			<!-- </div> -->  <!-- container 끝 -->
		</nav>
	</header> <!-- End header태그  -->
	<!-- End header -->