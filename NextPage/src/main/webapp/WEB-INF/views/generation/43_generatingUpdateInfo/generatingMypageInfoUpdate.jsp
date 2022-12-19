<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<style>
#outlineBox{
	margin-top:10%;
}
</style>

<div class="container">
	<div class="row justify-content-center">
		<div id="outlineBox" class="col-md-5">
			<h2 class="row align-items-end justify-content-center text-center">마이페이지</h2>
			<form:form modelAttribute="schMem" method="post" >
				<div class="row">
					<div class="col-md-12 form-group">
						<label for="memNm">이름</label>
						<form:input path="memNm" id="memNm" class="form-control form-control-lg" required="true"/>
					</div>
					<div class="col-md-12 form-group">
						<label for="compNum">사번/학번/ID</label>
						<form:input path="memId" id="memId" class="form-control form-control-lg" required="true"/>
						<form:input path="memPw" id="memPw" type="hidden" class="form-control form-control-lg"/>
					</div>
					
					<div class="col-md-12 form-group">
						<label for="email">이메일</label>
						<form:input path="memEmail" id="email" class="form-control form-control-lg editable" /> 
					</div>
	
					<div class="col-md-12 form-group">
						<label for="tel">전화번호</label>
						<form:input path="telNum" id="telNum" class="form-control form-control-lg editable" />
					</div>
	
				</div>
				<br>
				<div class="row">
					<div class="col-12">
						<input type="submit" value="수정" class="btn btn-primary btn-lg px-5 " style="float: right;">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>

<c:if test="${command eq 'UPDATE' }">
	<script type="text/javascript">
		$(":input:not(.editable)").prop("readonly", true);
	</script>
</c:if>

