<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 작성자 : 최현우 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="guja"%>

<style>
	.img-size{
		width : 200px;
		height : 70px;
	}
</style>

<!--
	generation header menu 
 -->

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<div class="site-wrap">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>


		<div class="py-2" style="border-bottom: 1px solid gray;">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-8 d-none d-lg-block">
						<a href="<%=request.getContextPath() %>/generation/${ sessionScope.id }/main" class="small mr-3">
						<img class = "img-size" src="<%= request.getContextPath() %>/resources/templatesPreview/images/schLogo/${sessionScope.fileName}" alt="Image" class="img-fluid"></a>
					</div>
					<!-- 로그인 하지 않았을때 로그인/회원가입 -->
					<guja:if test="${empty sessionScope.authMem }">
						<div class="col-lg-3 text-right">
							<a href="<%=request.getContextPath() %>/generation/${sessionScope.id}/login" class="small mr-3">
								<span class="icon-unlock-alt"></span>로그인</a>
							<a href="<%=request.getContextPath()%>/generation/${sessionScope.id}/join" class="small mr-3">
								<span class="icon-users"></span> 회원가입</a>
						</div>
					</guja:if>

					<!-- 로그인했을때 로그아웃/마이페이지로 변경 -->
					<guja:if test="${not empty sessionScope.authMem }">
						<div class="col-lg-3 text-right">
								<a href="javascript:void(0)" onclick="javascript:logOut()" class="small mr-3"> <span class="icon-unlock-alt"></span>로그아웃</a>

							<a href="<%=request.getContextPath() %>/generation/${sessionScope.id}/generatingMyPage/view" class="small btn btn-primary px-4 py-2 rounded-0">
								<span class="icon-users"></span>마이페이지</a>
						</div>

					</guja:if>
				</div>
			</div>
		</div>
		<header class="site-navbar  js-sticky-header site-navbar-target"
			role="banner">

			<div class="container">
				<div class="d-flex align-items-center">
					<div class="mr-auto">
						<nav class="site-navigation position-relative text-right"
							role="navigation">
							<!-- 동적 시작 -->
							<div id="guja" style="font-size: 1rem;font-weight: 600;">
								<%-- ${view} --%>
								${sessionScope.headerView}
								<!--
								1. view null체크
								2. request url을 저장
								3. ViewMaker.do 호출하면거 request url 전달
								4. ViewMaker.do에서 뷰를 만들고 url 컨트롤러 호출
								-->
							</div>
							
							<!-- 동적 시작 -->
						</nav>

					</div>

				</div>

			</div>

		</header>

	</div>
<body>
	<form id="frm" action="<%=request.getContextPath()%>/generation/${sessionScope.id}/main">
		<input type="hidden" id="topId" name="topMenuId"> 
		<input type="hidden" id="link" name="link">
	</form>
</body>

<script>
	
	/*
		작성자 : 최현우
	*/
/* 	function resolver(e) {

		let data = e.getAttribute("title").split(" ");

		console.log(data[0]); // topMenuId
		console.log(data[1]); // Link

		document.getElementById("topId").value = data[0]; // 컨트롤러에게 보내줄 값 세팅
		document.getElementById("link").value = data[1]; // 컨트롤러에게 보내줄 값 세팅

		let form = document.getElementById("frm");

		form.setAttribute("method", "GET"); // GET방식으로 변경

		form.submit(); // 폼 전송

	}  */
	
	
	// 로그아웃 하는 스크립트긔~!   -- 11.18  위크실버레인 --
	function logOut(){
		let lo = document.createElement('form');		
		lo.setAttribute('method','post');				
		lo.setAttribute('action','<%=request.getContextPath() %>/generation/${sessionScope.id}/logout');
		document.body.appendChild(lo);	
		lo.submit();
	}
	// 로그아웃 스크립트 끝
</script>

</body>


