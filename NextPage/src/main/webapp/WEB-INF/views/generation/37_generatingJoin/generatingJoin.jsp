<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.id_ok,.pw_ok, .repw_ok{
color:#008000;
display: none;
font-weight: bold;
}

.id_already{
color:RED;
display: none;
font-weight: bold;
}

.memEmail{
width : 30%;
display:inline-block;
}
#selectEmail{
display:inline-block;
height: calc(2.875rem + 2px);
width : 33%;
padding: 0.5rem 1rem;
font-size: 1.25rem;
line-height: 1.5;
border-radius: 0.3rem;
color: #495057;
background-color: #fff;
background-clip: padding-box;
border: 1px solid #ced4da;
}

label{
display:block;
}

.row {
	margin-bottom: 32px;
}
#info{
	margin-top:4%;
}
#infobox{
  border: 1px solid gray;
  border-radius: 5px;
  text-align: center;
}
#h2Tag{
  font-weight: bold;
}
</style>

			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-5">
					<div id="infobox">
							<p id="info">
							● 회원가입은 학부모만 가능합니다.<br>
							● 학생/교직원은 학번/사번을 이용 바랍니다.<br>
							● 비회원은 공개된 게시글만 이용 가능합니다.</p>
					</div>
					<form method="Post" action="<%=request.getContextPath() %>/generation/{id}/join">
						<h2 id="h2Tag" class="row align-items-end justify-content-center text-center mt-5">회원가입</h2>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="id">아이디</label>
								<input type="text" id="memId" name="memId" class="form-control form-control-lg" oninput="checkId()" placeholder="ID" required>
								<span class="id_ok">사용 가능한 아이디입니다.</span>
								<span class="id_already">누군가 이 아이디를 사용하고 있어요.</span>
								<span class="id_reg"></span>
							</div>

							<div class="col-md-12 form-group">
								<label for="pw">비밀번호</label>
								<input type="password" value = "ddit403!" id="memPw" name="memPw" class="form-control form-control-lg" oninput="checkPw()" placeholder="5자이상 영문소문자, 숫자,특수문자(_)만 사용 " required>
								<span class="pw_ok">사용 가능한 비밀번호입니다.</span>
								<span class="pw_reg"></span>
							</div>

							<div class="col-md-12 form-group">
								<label for="pw2">비밀번호 확인</label>
								<input type="password" value = "ddit403!" id="rememPw" name="rememPw"class="form-control form-control-lg" oninput="reCheckPw()" placeholder="비밀번호를 재입력하세요" required>
								<span class="repw_ok">일치합니다</span>
								<span class="pw_err"></span>
							</div>

							<div class="col-md-12 form-group">
								<label for="username">이름</label>
								<input type="text" value = "강은비" id="memNm" name="memNm" class="form-control form-control-lg" placeholder="내용을 입력해주세요" required>
								<div id="nameError" class="error"></div>
							</div>

							<div class="col-md-12 form-group">
								<label for="tel">전화번호</label>
								<input type="text" id="telNum" value = "01035117802" name="telNum" class="form-control form-control-lg" required>

							</div>

							<div class="col-md-12 form-group">
								<label for="email">이메일</label>
								<input type="text" value = "riverbbb" id="memEmailId" name="memEmailId" class="memEmail form-control form-control-lg" required>
								<span>@</span>
								<input type="text" id="memEmailaddr" name="memEmailAddr"class="memEmail form-control form-control-lg" required>
								<select id="selectEmail" class="selectEmail">
								  	 <option value="type" selected>직접입력</option>
									 <option value="naver.com">naver.com</option>
									 <option value="hanmail.net">hanmail.net</option>
									 <option value="hotmail.com">hotmail.com</option>
									 <option value="nate.com">nate.com</option>
									 <option value="yahoo.co.kr">yahoo.co.kr</option>
									 <option value="empas.com">empas.com</option>
									 <option value="dreamwiz.com">dreamwiz.com</option>
									 <option value="freechal.com">freechal.com</option>
									 <option value="lycos.co.kr">lycos.co.kr</option>
									 <option value="korea.com">korea.com</option>
									 <option value="gmail.com">gmail.com</option>
									 <option value="hanmir.com">hanmir.com</option>
									 <option value="paran.com">paran.com</option>
								</select>
								<div id="emailError" class="error"></div>
							</div>
						</div>
						<div class="row">
							<div class="col-12">
								<input type="submit" id="join" value="가입"	class="btn btn-primary btn-lg px-5">
								<button type="button" class="btn btn-danger btn-lg px-5"  style="float: right;">
									<a href="<%=request.getContextPath()%>/generation/generatingMain">취소</a>
								</button>
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>

<script	src="<%=request.getContextPath()%>/resources/templates/template01/template01Index/js/main.js"></script>

<script type="text/javascript">


// 이메일 주소 선택에 따라 선택값 자동 입력하고 disable처리
// 직접입력시 다시 활성화시키기
const domainListEl = document.querySelector('#selectEmail')	// select
const domainInputEl = document.querySelector('#memEmailaddr')	// 주소가 들어갈 input
var memEmailId = document.getElementById("memEmailId");	// 이메일 아이디

// select 옵션 변경 시
domainListEl.addEventListener('change', (event) => {
  // option에 있는 도메인 선택 시
  if(event.target.value !== "type") {
    // 선택한 도메인을 input에 입력하고 disabled
    domainInputEl.value = event.target.value
    domainInputEl.readOnly = true		// disabled를 쓰면 input이 서버로 전송이 안됨!

    console.log(memEmailId.value);
    console.log(domainInputEl.value);

  } else { // 직접 입력 시
    // input 내용 초기화 & 입력 가능하도록 변경
    domainInputEl.value = ""
    domainInputEl.readOnly = false

  }
})





	// 아이디 유효성 검사
    function checkId(){

		var id = $('#memId').val(); //id값이 "id"인 입력란의 값을 저장
	    var regId = /^[a-zA-Z0-9_]{5,16}$/;
		if(id == ""){
        	$('.id_ok').css("display", "none"); 	// OK메세지 안보이게
        	$('.id_reg').css("display","none");
		}else if(!regId.test(id)){			//id 정규식에 맞지않거나 id 입력란이 비어있는경우
         	$('.id_reg').html("아이디는 5자이상 영문소문자, 숫자,특수문자(_)만 사용 가능합니다.");
         	$('.id_reg').css("font-weight", "bold");
         	$('.id_reg').css("display","inline-block");
         	$('.id_reg').css("color","red");
        }else{

		// url로 보낼때 {id}에 필요한 학교 아이디 세션에서 꺼냄
		var schId = '<%=(String) session.getAttribute("id")%>';
		$('.id_reg').css("display","none");

        event.preventDefault();
        $.ajax({
            url:'${pageContext.request.contextPath}/generation/'+schId+'/idCheck',
            type:'post', //POST 방식으로 전달
            data:{ "memId" : id},
            dataType:"json",
            success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다
            	console.log("성공  cnt",cnt);

                if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
                    $('.id_ok').css("display","inline-block");
                    $('.id_already').css("display", "none");
                    $("#join").attr("disabled",false);
                } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                    $('.id_already').css("display","inline-block");
                    $('.id_ok').css("display", "none");
                    $("#join").attr("disabled",true);
                }

            },
            error:function(err){
               alert("엑럿ㅆㅆ",err.status);
               console.log(err);
            	//console.log(err.status);
            }
        });
        return false;
     }
};

// 비밀번호 유효성 검사
function checkPw(){
	var pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;

	var pw =  $('#memPw').val();

		if(pw == ""){
		$('.pw_ok').css("display", "none");
		$('.pw_reg').css("display", "none");
		}else if(!pwReg.test(pw)){
		$('.pw_reg').html("최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자");
      	$('.pw_reg').css("display","inline-block");
      	$('.pw_reg').css("color","red");
      	$('.pw_reg').css("font-weight", "bold");
		}else{
    	$('.pw_ok').css("display", "inline-block");
        $('.pw_reg').css("display","none");
      }
}

// 재입력시 유효성 검사
function reCheckPw(){
 var pw = $('#memPw').val();
 var rePw = $('#rememPw').val();

 if(rePw !== pw){
 	$('.repw_ok').css("display", "none");
 }else{
	 $('.repw_ok').css("display", "inline-block");
 }
}





// 자녀 확인 칸 추가 하는곳
/* 	$(document).ready(function() {
		var i = 1; // 변수설정은 함수의 바깥에 설정!
		$("#chck").click(function() {
			$(".first").append(
				"<div class='col-md-12 form-group cdck' ><label for='email'>자녀이름</label>"
				+ "<input type='cdname' id='cdname' class='form-control form-control-sm' placeholder='내용을 입력해주세요'>"
				+ "<label for='cdnum'>자녀학번</label>"
				+ "<input type='text' id='cdnum' class='form-control form-control-sm' placeholder='내용을 입력해주세요'></div>"
				+ "<button type='button' class='btnRemove'>삭제하기</button>"
				);
			$(".btnRemove").on("click",function() {
				$(this).prev().remove();
				$(this).next().remove();
				$(this).remove();
				});
			i++; // 함수 내 하단에 증가문 설정
		});
	}); */
</script>

