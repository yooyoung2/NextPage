<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
  /* IE의 경우 */
input::-ms-clear,
input::-ms-reveal{
    display:none;
}
/* 크롬의 경우 */
input::-webkit-search-decoration,
input::-webkit-search-cancel-button,
input::-webkit-search-results-button,
input::-webkit-search-results-decoration{
	display:none;
}
.inputWrap {
    position: relative;
    height: 30px;
    display: inline-block;
 }

.inputWrap input {
  padding-right: 30px;
  height: inherit;
}

.inputWrap .btnClear {
  position: absolute;
  top: 0;
  right: 0;
  width: 30px;
  height: inherit;
  background: url(https://img.icons8.com/pastel-glyph/2x/cancel.png) center center no-repeat;
  background-size: 50%;
  border: none;
  outline: none;
  cursor: pointer;
}
.inputWrap2 {
    position: relative;
    height: 30px;
    display: inline-block;
 }

.inputWrap2 input {
  padding-right: 30px;
  height: inherit;
}

.inputWrap2 .btnClear2 {
  position: absolute;
  top: 0;
  right: 0;
  width: 30px;
  height: inherit;
  background: url(https://img.icons8.com/pastel-glyph/2x/cancel.png) center center no-repeat;
  background-size: 50%;
  border: none;
  outline: none;
  cursor: pointer;
  </style>

<div class="content">
	<br>
	<input id="schId" hidden="hidden" value="${sessionScope.authSch}">

	<h3>교가</h3>
	<input type="file" id="musicNm" name="musicNm" accept=".mp3" style="margin-right: 5%; width: 300px;" class="form-control" />
	    <div>
	    	${song.musicNm}
	    </div>
	<div class="inputWrap2">

	 <%--    <input type="text" name="musicPath" value="${song.musicPath}"/>
	    <button class="btnClear2" style="margin-right: 60%;"></button> --%>
	</div>

	<h3>악보</h3>
	<input type="file" id="imgNm" name="imgNm" class="form-control" style="margin-right: 5%; width: 300px;"/>
		${song.imgNm}
	<br>
	<br>

	<c:if test="${song.musicNm eq null and song.imgNm eq null}">
		<button style="float: right; margin-top: 5%;" class="btn btn-primary" onclick="f_ajax()">적용</button>
	</c:if>
	<c:if test="${song.musicNm ne null or song.imgNm ne null}">
		<button style="float: right; margin-top: 5%;" class="btn btn-success" onclick="modi_ajax()">수정</button>
	</c:if>
</div>

<script type="text/javascript">
/* var btnClear = document.querySelector('.btnClear');
btnClear.addEventListener('click', function(){
    btnClear.parentNode.querySelector('input').value = "";
})
var btnClear2 = document.querySelector('.btnClear2');
btnClear2.addEventListener('click', function(){
    btnClear2.parentNode.querySelector('input').value = "";
}) */
</script>

<script>
function f_ajax(event){
	let schId = $("#schId").val();
	let url = "${pageContext.request.contextPath}/school/manager/school/song";
	let data = {};

	data.imgNm = document.getElementById('imgNm').files[0].name;
	//data.imgPath = $("input[name=imgPath]").val();
	data.musicNm = document.getElementById('musicNm').files[0].name;
	//data.musicPath = $("input[name=musicPath]").val();
	console.log("데이터 :",data);

	$.ajax({
		url : url,
		method : "post",
		data : JSON.stringify(data),
		contentType : "application/json;charset=utf-8",
		dataType :"text",
		success : function(resp) {
			if (resp == "ok") {
				Swal.fire('교가 등록 성공!');
				setTimeout("history.go(0);", 3000);

				clearTimeout(timeoutId);
			}

		},
		error : function(errorResp) {
			console.log(errorResp.status);
			$("input[name=imgNm]").val(errorResp.responseText);
		}
	});

}

function modi_ajax(event){
	let schId = $("#schId").val();
	let url = "${pageContext.request.contextPath}/school/manager/modify/song";
	let data = {};

	var a = document.getElementById('imgNm').files[0];
	var b = document.getElementById('musicNm').files[0];

	if(a==undefined){
		console.log("없다");
		data.imgNm = "${song.imgNm}";
	}else{
		data.imgNm = document.getElementById('imgNm').files[0].name;
	}

	if(b==undefined){
		console.log("없다");
		data.musicNm = "${song.musicNm}";
	}else{
		data.musicNm = document.getElementById('musicNm').files[0].name;
	}



	//data.imgNm = $("input[name=imgNm]").val();
	//data.imgPath = $("input[name=imgPath]").val();
	//data.musicNm = $("input[name=musicNm]").val();
	//data.musicPath = $("input[name=musicPath]").val();
	console.log("데이터 :",data);


	$.ajax({
		url : url,
		method : "post",
		data : JSON.stringify(data),
		contentType : "application/json;charset=utf-8",
		dataType :"text",
		success : function(resp) {
			if(resp == "ok"){
// 				alert('교가 수정 성공!')
				Swal.fire('교가 수정 성공!');
				setTimeout("history.go(0);", 3000);

				clearTimeout(timeoutId);
// 				location.replace("http://localhost/NextPage/generation/"+schId+"/school/song")
			}

		},
		error : function(errorResp) {
			console.log(errorResp.status);
// 			alert("에러발생, 잠시후 다시 시도해주세요");
			Swal.fire('');
			Swal.fire(
					  '교가 등록 실패.',
					  '잠시 후 다시 시도해주세요',
					  'error'
					)
			setTimeout("history.go(0);", 3000);

			clearTimeout(timeoutId);
		}
	});

}


</script>