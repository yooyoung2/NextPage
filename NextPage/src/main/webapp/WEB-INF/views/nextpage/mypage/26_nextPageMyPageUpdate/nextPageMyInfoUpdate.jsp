<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

					<!-- ===================================== -->
					<!-- *************정보변경 폼*************-->
					<!-- ===================================== -->

<style>


b, input {
  margin:10px 0px;
}
.container {
  max-width:500px;
  margin:0 auto;
}


input[type="submit"]:active {
  background:linear-gradient(#009670,#00ae81);
}
input[type="text"] {
  width:70%;
  padding:10px;
  border-radius:5px;
  border:1px solid #A4A4A4;
  box-shadow:0px 0px 3px rgba(0,0,0,0.1) inset;
}
input[type="text"]:focus {
  border:1px solid #4A89DC;
}
b {
  color:#585858;
  font-weight:700;
}

#sample6_postcode{
	text-align : center;
	    width: 104%;
}

#updateBtn {
	text-align : center;
	width: 100px;
    color: white;
    background-color: #435ebe;
    border-color: #435ebe;
    margin-top: 15%;
    margin-left: 47%;
}
#postcodeForm{
display : inline-block;
}
.form-control{
text-align : center;
color : #6E6E6E;
height: 36px;
width: 100px;
}
.card-front{
    width: 520px;
    height: 760px;
    background-color: white;
    transition: box-shadow .3s;
    border-radius: 10px;
    border: 1px solid #ccc;
    box-shadow: 0 0 11px rgb(33 33 33 / 20%);
    background-position: bottom center;
    background-repeat: no-repeat;
    background-size: 300%;
    border-radius: 6px;
 	left: 9%;
  	top: 0;
  	margin-left: -10%;
    margin-top: 4%;
}

.postcodeForm{
	display : block;
}
.postBox{
    float : left;
}

#hTag{
	margin-top: 18%;
    margin-left: 39%;
}

#zipBtn {
    width: 110px;
    height: 40px;
    position: relative;
    display: inline-block;
	margin-top: 40px;
    margin-left: 21px;
    text-align: center;
    font-size: 16px;
    letter-spacing: 1px;
    text-decoration: none;
    color: #848484;
    background: #ffffff;
    border: 3px solid #848484;
    cursor: pointer;
    transition: ease-out 0.5s;
    -webkit-transition: ease-out 0.5s;
    -moz-transition: ease-out 0.5s;
}

.btn.btn-border-1::after,
.btn.btn-border-1::before {
    position: absolute;
    content: "";
    width: 0%;
    height: 0%;
    visibility: hidden;
}

.btn.btn-border-1::after {
    bottom: -3px;
    right: -3px;
    border-left: 3px solid #222222;
    border-bottom: 3px solid #222222;
    transition: width .1s ease .1s, height .1s ease, visibility 0s .2s;
}

.btn.btn-border-1::before {
    top: -3px;
    left: -3px;
    border-top: 3px solid #222222;
    border-right: 3px solid #222222;
    transition: width .1s ease .3s, height .1s ease .2s, visibility 0s .4s;
}

.btn.btn-border-1:hover {
    animation: pulse 1s ease-out .4s;
    color: #222222;
}

.btn.btn-border-1:hover::after,
.btn.btn-border-1:hover::before {
    width: calc(100% + 3px);
    height: calc(100% + 3px);
    visibility: visible;
    transition: width .1s ease .2s, height .1s ease .3s, visibility 0s .2s;
}

.btn.btn-border-1:hover::after {
    transition: width .1s ease .2s, height .1s ease .3s, visibility 0s .2s;
}

.btn.btn-border-1:hover::before {
    transition: width .1s ease, height .1s ease .1s;
}

#updateInfo{
	margin-left: 20%;
    margin-top: 12%;
}

hr{
    margin-top: 30px;
    
	border-top-style: dotted;
	border-top-width: 2px;
	border-top-color: blue;
	background : white;
	width : 70%;
	text-align:center;

}

</style>


<main class="main" id="top">
	<div class="container">
		<div class="card-front">
			<div class="col-lg-11">
				<div class="row flex-center">
						<h1 id="hTag">정보 수정</h1>
			
					<!-- ===================================== -->
					<!-- ********* form 시작 *****************-->
					<!-- ===================================== -->
					<form:form id="updateInfo"  class="updateForm" method="post" action="${pageContext.request.contextPath }/nextpage/mypage/updateAccount"
						modelAttribute="schInfo">
						<form:input path="schId" type="hidden" />
	
								<div class="divClass">
									<label for="schEmail" class="form-label">이메일</label>
									<form:input path="schEmail"
										class="form-control form-control-xl" required="true"/>
								</div>
								
								<hr>
								
								<div class="divClass">
									<label for="schTelNum" class="form-label">전화번호</label>
									<form:input path="schTelNum"
										class="form-control form-control-xl" required="true" />
									<form:errors path="schTelNum" element="span" cssClass="error" />
								</div>
								
								<hr>
								
								<div class="postcodeForm">
									<div class="postBox">
										<label class="form-label" for="schPostNum">학교주소</label>
										<form:input path="schPostNum" id="sample6_postcode"
											class="form-control postcode" required="true" readonly="true" />
									</div>
									<div  class="postBox">
										<input type="button" id="zipBtn" class="btn btn-border-1"  name="schZip"
											onclick="sample6_execDaumPostcode()" value="우편번호">
									</div>
								</div>
								
								<div class="divClass">
									<form:input path="schAddr1" id="sample6_address" class="form-control"
										required="true" readonly="true" />
								</div>
								<div class="divClass">
									<form:input path="schNm"  id="sample6_detailAddress" class="form-control" required="true" />
								</div>
								<input type="hidden" id="sample6_extraAddress" placeholder="참고항목">
						<div class="col-6 d-grid">
							<form:button type="submit" id="updateBtn" class="btn btn-primary" name="submit">수정</form:button>
						</div>
						
					</form:form>
					<!-- ===================================== -->
					<!-- ********* form 끝 *****************-->
					<!-- ===================================== -->
				</div>
			</div>
		</div>
	</div>
</main>



<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
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
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

</script>