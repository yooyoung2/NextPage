<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--  <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/templates/operator/assets/css/app.css">
 --%>
  

<style>
.id_ok,.pw_ok, .repw_ok,.nm_ok{
color:#008000;
display: none;
font-weight: bold;
}

.id_already,.nm_already{
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
#schmemEmailId{
	width: 30%;
    float: left;
}



</style>


<!-- ============================================-->
<!-- <section> begin ============================-->


	<!--/.bg-holder-->

		<div id="signUpBox" class=" flex-center">
			<div id="auth">

				<div class="h-100">
					<div class="col-lg-5 col-12" style="margin-left: 34%;">
						<div id="auth-left">

							<h1 class="auth-title">회원가입 :)</h1>
							<p class="auth-subtitle mb-5">회원정보를 입력해주세요.</p>

							<form:form modelAttribute="school" method="post" class=" g-3 needs-validation" id="signUpForm">

								<div class="form-group position-relative has-icon-left mb-4">
									<label for="schID" class="form-label">아이디</label>
									<form:input path="schId" id="schId" oninput="checkId()" 
										class="form-control form-control-xl"
										placeholder="영소문자,숫자로 구성된 5글자 이상" required="true" />
									<span class="id_ok">사용 가능한 아이디입니다.</span>
									<span class="id_already">누군가 이 아이디를 사용하고 있어요.</span>
									<span class="id_reg"></span>
	<!-- 								<div class="form-control-icon">
										<i class="bi bi-person"></i>
									</div> -->
								</div>


								<div class="form-group position-relative has-icon-left mb-4">
									<label for="schPw" class="form-label">비밀번호</label>
									<form:input path="schPw" id="schPw" class="form-control form-control-xl" oninput="checkPw()" 
												required="true" type="password"	placeholder="영대소문자,숫자로 구성된 8글자 이상"  value="ddit403!"/>
									<span class="pw_ok">사용 가능한 비밀번호입니다.</span>
									<span class="pw_reg"></span>
<!-- 									<div class="form-control-icon">
										<i class="bi bi-shield-lock"></i>
									</div> -->
								</div>
								
								<div class="form-group position-relative has-icon-left mb-4">
									<label for="schPw" class="form-label">비밀번호 재입력</label>
									<input type="password" id="reschPw" class="form-control form-control-xl" oninput="reCheckPw()" 
												required	placeholder="영대소문자,숫자로 구성된 8글자 이상" value="ddit403!"/>
									<span class="repw_ok">일치합니다</span>
									<span class="pw_err"></span>
<!-- 									<div class="form-control-icon">
										<i class="bi bi-shield-lock"></i>
									</div> -->
								</div>
								
								<div class="form-group position-relative has-icon-left mb-4">
									<label for="schEmail" class="form-label">이메일</label>
									<form:input path="schEmailId" id="schmemEmailId" class="form-control form-control-lg" required="true" value="ddit403" />
									<span>@</span>
									<form:input path="schEmailAddr" id="schEmailAddr" class="memEmail form-control form-control-lg" required="true" />
									<select id="selectEmail" class="selectEmail">
										<option value="type" selected>직접입력</option>
										<option value="naver.com" >naver.com</option>
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
<!-- 									<div class="form-control-icon">
										<i class="bi bi-envelope"></i>
									</div> -->
								</div>

								<div class="form-group position-relative has-icon-left mb-4">
									<label for="schTelNum" class="form-label">전화번호</label>
									<form:input path="schTelNum" class="form-control form-control-xl" required="true" value = "01035117802" />
									<form:errors path="schTelNum" element="span" cssClass="error" />
<!-- 									<div class="form-control-icon">
										<i class="bi bi-envelope"></i>
									</div> -->
								</div>


								<div class="form-group position-relative has-icon-left mb-4">
									<label class="form-label" for="schPostNum">학교주소</label>
								</div>
								
								<div class="form-control-icon">
									<form:input type="hidden" path="schPostNum" id="sample6_postcode" class="form-control" required="true" readonly="true" />
									<form:errors path="schPostNum" element="span" cssClass="error" />
									<input type="button" id="zipBtn" name="schZip" onclick="sample6_execDaumPostcode()" value="학교지역 입력">
								</div>
								<div class="col-12">
									<form:input type="hidden" path="schAddr1" id="schAddr1" class="form-control" required="true" readonly="true" value="대전광역시 오류동"/>
									<form:input path="schAddr2" id="sample6_addressFull" class="form-control" required="true" readonly="true" value="ddit403"/>
								</div>
								<div class="col-12">
									<form:input path="schNm" id="schNm" class="form-control" required="true" oninput="checkSch()" placeholder="상세주소 (ex.샘플초등학교)" value="ddit학교" />
									<span class="nm_reg"></span>
									<span class="nm_ok">중복체크 완료</span>
									<span class="nm_already">이미 사용중인 학교입니다.</span>

									
								</div>
								<input type="hidden" id="sample6_extraAddress" placeholder="참고항목">

								<button id="join" name="join" class="btn btn-primary btn-block btn-lg shadow-lg mt-5" style="margin-left: 37%;">회원가입</button>
							</form:form>
						</div>
							<div class="text-center mt-5 text-lg fs-4">
								<p class='text-gray-600'>
									이미 회원이신가요? <a
										href="${pageContext.request.contextPath }/nextpage/user/login.do"
										class="font-bold">Log in</a>.
								</p>
							</div>
						</div>
					</div>
<!-- 					<div class="col-lg-7 d-none d-lg-block">
						<div id="auth-right"></div>
					</div> -->
				</div>

			</div>

	<!-- end of .container-->
<!-- <section> close ============================--> <!-- ============================================-->



<!-- 카카오 주소 찾기 API -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
	
//이메일 주소 선택에 따라 선택값 자동 입력하고 disable처리
//직접입력시 다시 활성화시키기
const domainListEl = document.querySelector('#selectEmail')	// select
const domainInputEl = document.querySelector('#schEmailAddr')	// 주소가 들어갈 input


//select 옵션 변경 시
domainListEl.addEventListener('change', (event) => {
// option에 있는 도메인 선택 시
if(event.target.value !== "type") {
 // 선택한 도메인을 input에 입력하고 disabled
 domainInputEl.value = event.target.value
 domainInputEl.readOnly = true		// disabled를 쓰면 input이 서버로 전송이 안됨!
 
 
} else { // 직접 입력 시
 // input 내용 초기화 & 입력 가능하도록 변경
 domainInputEl.value = ""
 domainInputEl.readOnly = false
 
}
});




	// 아이디 유효성 검사
 function checkId(){
     
	var id = $('#schId').val(); //id값이 "id"인 입력란의 값을 저장
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
    	 
		$('.id_reg').css("display","none");
     
     event.preventDefault(); 
     $.ajax({
         url:'${pageContext.request.contextPath}/nextpage/user/signup/idCheck', 
         type:'post', //POST 방식으로 전달
         data:{ "schId" : id },
         dataType:"json",
         success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
         	console.log("성공  cnt",cnt);
   
             if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
            	 idOk = true;
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

//비밀번호 유효성 검사
function checkPw(){
	var pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;

	var pw =  $('#schPw').val();
		
		if(pw == ""){
			$('.pw_ok').css("display", "none");
			$('.pw_reg').css("display", "none");
		}else if(!pwReg.test(pw)){
			$('.pw_reg').html("최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자");
		   	$('.pw_reg').css("display","inline-block");
		   	$('.pw_reg').css("color","red");
		   	$('.pw_reg').css("font-weight", "bold");
		}else{
			pwOk = true;
		 	$('.pw_ok').css("display", "inline-block");  
		    $('.pw_reg').css("display","none");
   }
}

//재입력시 유효성 검사
function reCheckPw(){
var pw = $('#schPw').val();
var rePw = $('#reschPw').val();

if(rePw !== pw){
	$('.repw_ok').css("display", "none"); 
}else{
	repwOk = true;
	$('.repw_ok').css("display", "inline-block");
}
}

//'학교'란 단어가 들어갔는지체크
function checkSch(){
    var addr1 = $('#schAddr1').val();
	var nm = $('#schNm').val(); //id값이 "id"인 입력란의 값을 저장
	if(nm.includes('학교') == false || nm == ""){
		$('.nm_ok').css("display","none");
		$('.nm_already').css("display","none");
     	$('.nm_reg').css("display","none");			
      	$('.nm_reg').html("학교분류까지 입력해 주세요.(ex.@@초등학교)");	
      	$('.nm_reg').css("font-weight", "bold");
      	$('.nm_reg').css("display","inline-block");
      	$('.nm_reg').css("color","red");
      	$("#join").attr("disabled",true);
     }else{
		$('.nm_reg').css("display","none");
	    
		event.preventDefault(); 
	     $.ajax({
	         url:'${pageContext.request.contextPath}/nextpage/user/signup/schCheck', 
	         type:'post', //POST 방식으로 전달
	         data:{ "schNm" : nm
	        	 	,"schAddr1" : addr1
	        	 	},
	         dataType:"json",
	         success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
	         	console.log("성공  cnt",cnt);
	   
	             if(cnt == 0){ 
	            	 nmOk = true;
	            	 $('.nm_reg').css("display","none");
	            	 $('.nm_ok').css("display","inline-block");
	            	 $("#join").attr("disabled",false);
	             } else { // cnt가 1일 경우 -> 이미 존재하는 학교
	            	 $('.nm_already').css("display","inline-block");
	            	 $('#schNm').val('');
	             }
	         },
	         error:function(err){
	            alert(err.status);
	            console.log(err);
	         	//console.log(err.status);
	         }
	     });
	     return false;
	  }	
   };

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;	
            document.getElementById("sample6_addressFull").value = addr;
            document.getElementById("schAddr1").value = data.sido +" " + data.sigungu;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("schNm").focus();
        }
    }).open();
}

  
</script>
