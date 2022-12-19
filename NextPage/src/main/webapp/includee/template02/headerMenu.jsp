<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 작성자 : 최현우 -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "guja" %>

<style>
	.img-size{
		width : 200px;
		height : 70px;
	}
</style>

<!-- Navbar Start -->
<nav id="ss" class="navbar navbar-expand-lg navbar-light sticky-top px-4 px-lg-5 py-lg-0">

	<a href="${pageContext.request.contextPath}/generation/${sessionScope.id}/main" class="navbar-brand">
	    <h1 class="m-0 text-primary"><img class = "img-size" src="<%= request.getContextPath() %>/resources/templatesPreview/images/schLogo/${sessionScope.fileName}" alt="Image" class="img-fluid"></a></h1>
	</a>

	<button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
	    <span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarCollapse">
		${sessionScope.headerView }
	</div>

</nav>
<!-- Navbar End -->

<script>
// 로그아웃 하는 스크립트긔~!   -- 11.18  위크실버레인 --
function logOut(){
	let lo = document.createElement('form');
	lo.setAttribute('method','post');
	lo.setAttribute('action','<%=request.getContextPath() %>/generation/${sessionScope.id}/logout');
	document.body.appendChild(lo);
	lo.submit();
}
// 로그아웃 스크립트 끝
	ss = $("#ss");
	$( document ).ready(function() {
	   /*  console.log( "ready!" );
	    $("#offRemote").trigger('click'); */
	    
	    var btn = "";
	    
	    btn += "<div>";
	    
	    <guja:if test='${not empty sessionScope.authMem }'>
		
    	btn += "	<a href='<%=request.getContextPath() %>/generation/${sessionScope.id}/generatingMyPage/view' class='btn btn-primary rounded-pill'>MY PAGE<i class='fa fa-arrow-right ms-3'></i></a>";
    	btn += "	<a href='javascript:void(0)' onclick='javascript:logOut()' class='btn btn-primary rounded-pill'>LOGOUT<i class='fa fa-arrow-right ms-3'></i></a>";
				
    	</guja:if>
    	<guja:if test='${empty sessionScope.authMem }'>
				
    	btn += "			<a href='${pageContext.request.contextPath}/generation/${sessionScope.id}/join' class='btn btn-primary rounded-pill' style='background-color: #aed1b7; border-color: #aed1b7'>회원가입<i class='fa fa-arrow-right ms-3'></i></a>";
    	btn += "		<a href='${pageContext.request.contextPath}/generation/${sessionScope.id}/login' class='btn btn-primary rounded-pill' style='background-color: #aed1b7; border-color: #aed1b7'>로그인<i class='fa fa-arrow-right ms-3'></i></a>";
				
    	</guja:if> 
 
 		btn += "</div>";
 		
 		ss.append(btn);
 		console.log(btn);
	});

</script>