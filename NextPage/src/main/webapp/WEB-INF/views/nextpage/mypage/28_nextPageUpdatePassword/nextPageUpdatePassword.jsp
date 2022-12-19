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


.card-front{
	width: 56%;
    height: 500px;
    background-color: white;
    transition: box-shadow .3s;
    border-radius: 10px;
    border: 1px solid #ccc;
    box-shadow: 0 0 11px rgb(33 33 33 / 20%);
    background-position: bottom center;
    background-repeat: no-repeat;
    background-size: 300%;
    border-radius: 6px;
    left: 13%;
    top: 0;
    /* margin-left: 8%; */
    margin-top: 4%;
    padding: 74px;
}
form{
	margin-top : 13%;
}
#subBtn{  
	margin-right: 128px;
    margin-top: 10px;
  border-radius: 4px;
  height: 44px;
  font-size: 13px;
  font-weight: 600;
  text-transform: uppercase;
  -webkit-transition : all 200ms linear;
  transition: all 200ms linear;
  padding: 0 30px;
  letter-spacing: 1px;
  display: -webkit-inline-flex;
  display: -ms-inline-flexbox;
  display: inline-flex;
  -webkit-align-items: center;
  -moz-align-items: center;
  -ms-align-items: center;
  align-items: center;
  -webkit-justify-content: center;
  -moz-justify-content: center;
  -ms-justify-content: center;
  justify-content: center;
  -ms-flex-pack: center;
  text-align: center;
  border: none;
  background-color: #A9BCF5;
  color: #102770;
  box-shadow: 0 8px 24px 0 rgba(255,235,167,.2);
}
#subBtn:active,
#subBtn:focus{  
  background-color: #102770;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}
#subBtn:hover{  
  background-color: #435ebe;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}
</style>


<div class="container">
	<div class="row justify-content-center">
		<div class="card-front">
			<h2 class="row align-items-end justify-content-center text-center">비밀번호 수정</h2>
		<form method="post" action="${pageContext.request.contextPath}/nextpage/user/update/updatePassword">
			<div class="row">
				<div class="col-md-12 form-group">
					<label for="memNm">변경할 비밀번호</label>
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
					<input type="submit" id="subBtn" value="수정" class="btn btn-primary btn-lg px-5 " style="float: right;">
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

