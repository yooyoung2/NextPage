<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<style>
.pw_ok, .repw_ok{
color:#008000;
display: none;
font-weight: bold;
}

#outlineBox{
	margin-top:13%;
	margin-right:5%;
}

#pwlabel{
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
		<form method="post" action="<%=request.getContextPath() %>/generation/{id}/generatingMyPage/updatePassword">
			<div class="row">
				<div class="col-md-12 form-group">
					<label id="pwlabel" for="memNm">변경할 비밀번호</label>
					<input type="password" id="memPw" name="memPw" oninput="checkPw()" class="form-control form-control-lg" required/>
					<span class="pw_ok">사용 가능한 비밀번호입니다.</span>
					<span class="pw_reg"></span>
					
				</div>
				<div class="col-md-12 form-group">
					<label for="compNum">동일하게 입력해주세요</label>
					<input type="password" id="rememPw" oninput="reCheckPw()" class="form-control form-control-lg" required/>
					<span class="repw_ok">일치합니다</span>
				</div>

			</div>
			<br>
			<div class="row">
				<div class="col-12">
					<input id="updateBtn" type="submit" value="수정" class="btn btn-primary btn-lg px-5 " style="float: right;">
				</div>
			</div>
		</form>
		</div>
	</div>
</div>
<script>
//비밀번호 유효성 검사
function checkPw(){
	var pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;

	var pw =  $('#memPw').val();
		
		if(pw == ""){
		$('.pw_ok').css("display", "none");
		$('.pw_reg').css("display", "none");
		 $("#join").attr("disabled",true);
		}else if(!pwReg.test(pw)){
		$('.pw_reg').html("최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자");
      	$('.pw_reg').css("display","inline-block");
      	$('.pw_reg').css("color","red");
      	$('.pw_reg').css("font-weight", "bold");
      	 $("#join").attr("disabled",true);
		}else{
		$("#join").attr("disabled",false);
    	$('.pw_ok').css("display", "inline-block");  
        $('.pw_reg').css("display","none");
      }
}

// 재입력시 유효성 검사
function reCheckPw(){
 var pw = $('#memPw').val();
 var rePw = $('#rememPw').val();
 
 if(rePw !== pw){
	$("#join").attr("disabled",true);
 	$('.repw_ok').css("display", "none"); 
 }else{
	 $("#join").attr("disabled",false);
	 $('.repw_ok').css("display", "inline-block");
 }
}
</script>

