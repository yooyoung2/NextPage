<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style>
#outlineBox{
	margin-top:13%;
	margin-right:5%;
}

#memPw{
	margin-top:5%;
}

#updateBtn{
	width:385px;
}
</style>

<div class="container">
	<div class="row justify-content-center">
		<div id="outlineBox" class="col-md-5">
		<h2 class="row align-items-end justify-content-center text-center">비밀번호 수정</h2>
		<form method="post" action="${pageContext.request.contextPath}/generation/{id}/generatingMyPage/passwordOk">
			<div class="row">
				<div class="col-md-12 form-group">
					<input type="password" id="memPw" name="memPw" class="form-control form-control-lg" placeholder="현재 비밀번호" required/>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-12">
					<input type="submit" value="수정" id="updateBtn" class="btn btn-primary btn-lg px-5 " style="float: right;">
				</div>
			</div>
		</form>
		</div>
	</div>
</div>

