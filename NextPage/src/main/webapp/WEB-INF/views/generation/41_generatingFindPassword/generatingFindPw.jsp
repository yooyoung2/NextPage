<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String session2=(String)session.getAttribute("id");
%>

<style>
form{
	margin-left : 20%;
}
#h2Tag{
	margin-left : 15%;
	margin-top:15%;
	margin-bottom:10%;
	color:#6E6E6E;
}
#pTag{
	margin-left:10%;
}
#subBtn{
    width: 162px;
    margin-left: 17%;
    margin-top:5%;
}
.form-control{
	width : 370px;
	margin-left: -11%;
}
label{
    margin-left: -11%;
	color:#6E6E6E;
}
#outline{
    border-radius: 10px;
    border: 2px solid #BDBDBD;
	padding-right : 8%;
	margin-top:5%;
}
input{
	border-color:#6E6E6E;
}
</style>


<div class="container">

	<div class="row justify-content-center">
		<div id="outline" class="col-md-5">
			
		<h2 id="h2Tag" class="row align-items-end justify-content-center text-center">비밀번호 찾기</h2>
				<div class="row">
				<form action="pw" method="post">
					<div class="col-md-12 form-group">
						<label for="id">아이디</label> <input type="text" id="username" name="memId"
							class="form-control form-control-lg">
					</div>
					<div class="col-md-12 form-group">
						<label for="pword">이메일</label> <input type="email" id="email" name="memEmail"
							class="form-control form-control-lg">
					</div>
					<div class="col-md-12 form-group">
						<button id="subBtn" type="submit" class="btn btn-primary btn-lg px-3">전송</button>
					</div>
				</form>
				</div>
		</div>
		
		<br> <br>
	</div>