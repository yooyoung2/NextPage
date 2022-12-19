<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style>
#loginBtn{
    width: 409px;
}
#findIdBtn{
    width: 170px;
}
#findPwBtn{
    width: 165px;
}

#btnArea{
	padding-left: 28px;
}
</style>


<%
	String sessionId=(String)session.getAttribute("id");
%>
<div class="site-section" style="margin: 80px;">
	<div class="container-fluid p-0 mb-5">


		<div class="row justify-content-center">
			<div class="col-md-5">
				<div class="row">
					<form method="post" action="${pageContext.request.contextPath}/generation/{id}/login">
						<div class="m-3">
							<div class="col-md-12 form-group m-3">
								<label for="username">ID</label>
								<input type="text" name="memId"	id="memId" class="form-control form-control-lg" />
							</div>
							<div class="col-md-12 form-group m-3">
								<label for="pword">Password</label>
								<input type="password" name="memPw" id="memPw" class="form-control form-control-lg" />
							</div>
							<div class="row" id="btnArea">
								<input type="submit" value="로그인" id="loginBtn" class="btn btn-primary btn-lg px-5">
								<button id="findIdBtn" type="button" onclick = "location.href ='<%=request.getContextPath()%>/generation/<%=sessionId %>/find/id'"
									class="btn btn-danger btn-lg px-3 m-3">아이디찾기</button>
								<button id="findPwBtn" type="button" onclick = "location.href ='<%=request.getContextPath()%>/generation/<%=sessionId %>/find/pw'"
									class="btn btn-success btn-lg px-3 m-3">비밀번호찾기</button>
							</div>
						</div>
					</form>
					<br>
					<div></div>
					<br> <br>
					<div></div>
					<br>
					<div>
						<p>● 회원가입은 학부모만 가능합니다.</p>
						<p>● 학생/교직원은 학번/사번을 이용 바랍니다.</p>
						<p>● 비회원은 공개된 게시글만 이용 가능합니다.</p>
					</div>
				</div>
			</div>
		</div>



	</div>
</div>

