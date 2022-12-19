<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "guja" %>

<style>
#leftmenu{
	width:255px;
}
</style>

	<a href="#"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
		<svg class="bi me-2" width="40" height="32"></svg> <span class="fs-4">메뉴</span>
	</a>
	<hr>
	
	${sessionScope.leftView}
		


