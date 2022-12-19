<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="robots" content="noindex, nofollow">

<style>
</style>

<div class="site-section">
	<div class="container">

		<c:choose>
			<c:when test="${not empty title }">
				<h1>${title }</h1>
			</c:when>
			<c:otherwise>
				<h1>title이 비워있는디요?</h1>
			</c:otherwise>
		</c:choose>

	

		<c:choose>
			<c:when test="${not empty content }">
				<p>${content }</p>
			</c:when>
			<c:otherwise>
				<h1>content가 비워있습니다.</h1>
			</c:otherwise>
		</c:choose>

	</div>
</div>