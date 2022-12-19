<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<div class="sidebar-sticky pt-3" style="height: 300px; margin-top:80px;">
	<ul class="nav flex-column" style="text-align: center;">
	
	
	<!--======================  -->
	<!-- 	  	공통  메뉴		 	-->	
	<!--======================  -->
		<li><a
			href="<%=request.getContextPath()%>/generation/${sessionScope.id}/generatingMyPage/view">정보수정</a></li>
		<li><a
			href="<%=request.getContextPath()%>/generation/${sessionScope.id}/generatingMyPage/passwordUpdate">비밀번호 수정</a></li>
			
	<!--======================  -->
	<!-- 	  	학생  메뉴		 	-->	
	<!--======================  -->
		<c:if test="${sessionScope.authVal eq 'STUD' }">
			<li><a href="<%=request.getContextPath()%>/generation/${sessionScope.id}/generatingMyPage/parentsList">학부모 확인</a></li>
		</c:if>
			
	<!--======================  -->
	<!-- 		일반회원			-->	
	<!--======================  -->	
	
	<c:if test="${sessionScope.authVal eq 'NORMAL' }">
		<li><a href="<%=request.getContextPath()%>/generation/${sessionScope.id}/generatingMyPage/enrollPrnt">학부모 권한 신청</a></li>
				<li><a href="<%=request.getContextPath()%>/generation/${sessionScope.id}/generatingMyPage/childList">신청 현황</a></li>
	</c:if>
	
	<!--======================  -->
	<!-- 		학부모회원			-->	
	<!--======================  -->
	<c:if test="${sessionScope.authVal eq 'PRNT' }">
		<li><a href="<%=request.getContextPath()%>/generation/${sessionScope.id}/generatingMyPage/enrollPrnt">자녀 추가</a></li>
		<li><a href="<%=request.getContextPath()%>/generation/${sessionScope.id}/generatingMyPage/childList">추가한 자녀 목록</a></li>
	</c:if>
	
	<!--======================  -->
	<!-- 		교직원회원			-->	
	<!--======================  -->
	<c:if test="${sessionScope.authVal eq 'EDUPSN' }">
		<li><a
			href="<%=request.getContextPath()%>/generation/${sessionScope.id}/generatingMyPage/approvalList">학부모 신청 목록</a></li>
	</c:if>
	</ul>
</div>

