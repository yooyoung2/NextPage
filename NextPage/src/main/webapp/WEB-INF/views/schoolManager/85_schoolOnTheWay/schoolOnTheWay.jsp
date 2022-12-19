<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<title>오시는 길</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<div class="content">
		<h2 style="margin-left: 3%;">오시는 길</h2>
		<div class="row-fluid">
			<a href="https://map.kakao.com/" class="btn btn-warning"
				target="_blank" style="margin-left: 75%;">지도검색</a>
			<button type="button" data-toggle="modal" data-target="#myModal"
				class="btn btn-secondary ">사용매뉴얼</button>
		</div>
		<br><br><br>
		<div class="container m-30">
			<form id="ffrm">
				<input id="schId" hidden="hidden" value="${sessionScope.authSch}">
				<c:if test="${map.drctnUrl eq null}">
				<textarea rows="10" cols="100" name="drctnUrl" class="form-control"></textarea>
				<br>
				<div class="text-lg-end">
					<button type="button" class="btn btn-info" id="submitBtn" >등록</button>
				</div>
				</c:if>
				<c:if test="${map.drctnUrl ne null}">
				<div class="text-lg-end">
				<textarea rows="20" cols="100" name="drctnUrl" style="margin-top: -5%;margin-right: 5%;">${map.drctnUrl}</textarea><br>
					<button type="button" class="btn btn-primary" id="moditBtn" style="float: right; margin-right: 30px;">등록하기</button>
				</div>
				</c:if>
			</form>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">오시는 길 등록방법</h4>
						<button type="button" class="close" data-dismiss="modal">×</button>
					</div>
					<div class="modal-body">
						1. 지도검색을 클릭한다.<br>
						2. 좌측 검색창에 학교 주소를 입력한다.<br>
						3. 지도에 표시된 파란색아이콘을 클릭한다.<br>
						4. 아이콘 클릭 시 뜨는 팝업창 내 길찾기버튼 옆의 공유하기 버튼을 클릭한다.<br>
						5. HTML태그 복사를 클릭한다.<br>
						6. 원하는 크기와 아이콘을 선택 후 소스생성하기를 클릭한다.<br>
						7. 소스를 복사한다.<br>
						8. 관리자 페이지 지도검색 밑의 공간에 붙여넣기 후 등록버튼을 클릭한다.
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
var form = document.getElementById( "ffrm" );
let schId = $("#schId").val();
console.log(schId);

$("#submitBtn").on("click", function(event){

	let url = "${pageContext.request.contextPath}/school/manager/on/the/way";
	let data = $("#ffrm").serialize(); // ajaxForm 적용]
	console.log("데이터 :",data);
	$.ajax({
		url : url,
		method : "post",
		data : data,
		dataType :"text",
		success : function(resp) {
			if (resp == "ok") {
				Swal.fire({
					  position: 'center',
					  icon: 'success',
					  title: '등록 성공!',
					  showConfirmButton: false,
					  timer: 1500
					})
			}

		},
		error : function(errorResp) {
			console.log(errorResp.status);
			$("#listBody").html(errorResp.responseText);
		}
	});
});

$("#moditBtn").on("click", function(event){

	let url = "${pageContext.request.contextPath}/school/manager/modiMap";
	//let data = $("#ffrm").serialize(); // ajaxForm 적용]
	let data = {
			"drctnUrl" : $("textarea[name=drctnUrl]").val()
	};

	console.log("데이터 :",data);


	$.ajax({
		url : url,
		method : "post",
		data : JSON.stringify(data),
		contentType:"application/json;charset:utf-8",
		dataType :"text",
		success : function(resp) {
			if(resp == "ok"){

				Swal.fire({
					  title: '수정이 완료되었습니다.',
					  confirmButtonText: '확인',
					}).then((result) => {
					  if (result.isConfirmed) {
// 						location.replace("http://localhost/NextPage/generation/"+schId+"/direction")

						  location.href = location.href;
					  }
					})


			}else {
				location.href="http://localhost/NextPage/school/manager/on/the/way";
			}

		},
		error : function(errorResp) {
			console.log(errorResp.status);
			Swal.fire("에러발생, 잠시후 다시 시도해주세요");
			console.log(errorResp.responseText);
			const timeoutId = setTimeout("history.go(0);", 3000);
			clearTimeout(timeoutId);
		}
	});
});
</script>



