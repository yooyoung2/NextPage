<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style>
#trp{
	height: 300px;
	overflow: scroll;
}


input:focus{
    border-color:#0982f0;
    outline: none;
}

</style>


<div class="content">
	<div class="col">
		<div class="card">
			<div class="card-header">
				<div class="table-responsive">
					<table class="table text-start align-middle table-bordered mb-0 " id="otoTable">
						<tr>
							<th class="table-primary">제목</th>
							<td>${oto.otoBrdTitle}</td>
							<th class="table-primary">처리여부</th>
							<td id="otoStat">${oto.prgrsCndtn}</td>
						</tr>
						<tbody id="listBody">
							<tr>
								<th class="table-primary">작성자</th>
								<td id="boardWriter">${oto.schId}</td>
								<th class="table-primary">작성일자</th>
								<td>${oto.wrteDate}</td>
							</tr>
							<tr id="trp">
								<td colspan="4">${oto.otoBrdCntnt}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<section class="section">
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="table-responsive">
						<table class="table text-start align-middle table-bordered table-hover mb-0">
							<thead class="thead-dark">
								<tr>
									<th class="table-success">작성자</th>
									<th class="table-success">답변내용</th>
									<th class="table-success">작성일자</th>
									<th class="table-success">답변 수정</th>
								</tr>
							</thead>
							<tbody id="listBody">
								<c:choose>
									<c:when test="${not empty cmnt }">
											<c:forEach items="${cmnt}" var="cmnt">
												<tr>
													<td>${cmnt.cmntId}</td>
													<td>${cmnt.cmmntCntnt}</td>
													<td>${cmnt.cmmntDate}</td>

<%-- 													<input type="hidden" name="otoBrdNum" value="${cmnt.otoBrdNum }" /> --%>

												<!--진행상황: 완료일 시 안보이게... -->
												<c:if test="${oto.prgrsCndtn ne '완료'}">
														<!-- 권한처리 : 작성한 관리자만 글수정,삭제하게... -->
														<c:if test="${sessionScope.authSch eq cmnt.cmntId}">
															<!-- Button to Open the Modal -->
															<td><button type="button" class="btn btn-warning" data-what="${cmnt.cmmntId }"
															data-bs-toggle="modal" data-bs-target="#myModal">답변수정</button></td>
														</c:if>
												</c:if>
												</tr>
											</c:forEach>

									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="5">답변 없음</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="7">
										<div class="pagingArea mb-3">${pagingVO.pagingHTML }</div>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- The Modal -->
		<div class="modal" id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">답변수정</h4>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">

					</div>

					<!-- Modal footer -->
					<div class="modal-footer">

						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">취소</button>
					</div>

				</div>
			</div>
		</div>
		<form id='viewForm' action="${pageContext.request.contextPath }/operator/cmnt" method="get">
			<input type='hidden' name='what'  />
		</form>


	</section>
	<section class="section">
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-header">답변</div>
					<div class="card-body">
						<form:form modelAttribute="cmnt" method="post" id="ffrm" action="${pageContext.request.contextPath}/operator/cmnt/insert"  enctype="multipart/form-data">

							<input type="hidden" name="otoBrdNum" value="${oto.otoBrdNum }" />
							<input type="hidden" name="cmntId" value="${sessionScope.authSch}" />


								<div class="form-floating">
									<textarea class="form-control" name="cmmntCntnt" id="cmmntCntnt"
										 placeholder="답변을 작성해주세요" ></textarea>
									<label for="floatingTextarea">Comments</label>
								</div>
								<div class="d-flex justify-content-end mt-3">
								<c:if test="${oto.prgrsCndtn ne '완료'}">
									<input type="button" value="등록" class="btn btn-primary" id="subBtn"/>
								</c:if>
								</div>


						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="d-flex justify-content-end">
			<div class="me-3">
				<form action="${pageContext.request.contextPath}/operator/clear" name="nm_form">
					<input type="hidden" name="prgrsCndtn" value="${oto.prgrsCndtn }" />
					<input type="hidden" name="otoBrdNum" value="${oto.otoBrdNum }" />
					<button id="changeStatus" name="change_Status" class="btn btn-primary">완료</button>
				</form>
			</div>
			<div>
				<a href="javascript:window.history.back()"><button id="del" class="btn btn-danger">뒤로</button></a>
			</div>
		</div>
	</section>
</div>
<script>

$(document).ready(function() {

	  $("#subBtn").on("click", function(event){
		event.preventDefault();

		console.log("메시지 전송..");
// 		var otoId = ('#otoTable').find('td:eq(2)').text();
		var otoId = document.querySelector("#boardWriter").innerText
		console.log(otoId);

			let url = "${pageContext.request.contextPath}/operator/cmnt/insert";
			let data = $("#ffrm").serialize(); // ajaxForm 적용
			$.ajax({
				url : url,
				method : "post",
				data : data,
				dataType : "html",
				success : function(resp) {
					//세션에 저장된 아이디, 현재 글번호 가져오기
					let socketMsg = ($('[name=cmntId]').val()+"," + $('[name=otoBrdNum]').val()+","+otoId);
					console.log($('[name=otoBrdNum]').val());
					console.log( $('[name=cmntId]').val());
					console.log(socketMsg);
					webSocket.send(socketMsg);
 					location.href = location.href;
				},
				error : function(errorResp) {
					console.log(errorResp.status);
					$("#listBody").html(errorResp.responseText);
				}
			});
			return false;
		});
});

</script>


<script>
//진행상황바꾸기
let otoStat=  $( '#otoStat' ).html();

	if (otoStat=="완료") {

		console.log("여기까지 들어오는지???");

		// 완료가 되었을때
		$("#cmmntCntnt").attr("readonly", "readonly");
		//cmmntCntnt.setAttribute( "readonly" ,"readonly");

		//$("#changeStatus").html("진행");
		$("#changeStatus").attr("hidden","hidden");

	}

//수정버튼 누르면 수정 폼 생성
// 	let modiButton =  document.getElementById( "modi" );

// 	modiButton.onclick = function(){ // 수정 버튼이 눌렸을 때

// 		let cmmntCntnt = document.getElementById( "modiCntnt" );

// 		$("#modiCntnt").css({
// 			"border":"1px solid #435ebe"
// 		});

// 		if( modiButton.value == "수정" ){

// 			// 수정을 시작할 때
// 			cmmntCntnt.removeAttribute( "readonly" );

// 			modiButton.value = "등록"

// 		}else if( modiButton.value == "등록" ){

// 			// 수정을 끝나고 제출할 떄
// 			let updateForm = document.getElementById( "updateForm" );

// 			updateForm.submit();
// 			modiButton.value = "수정";
// 		}

//	}
</script>


<script type="text/javascript">

  let viewModal = $("#myModal").on("hidden.bs.modal", function(event){
 	$(this).find(".modal-body").empty();
 	viewForm.get(0).reset();
 	viewModal.data("what", "");
 }).on("show.bs.modal", function(event){
 	let dataTr = event.relatedTarget;
 	let what = $(dataTr).data('what');
 	viewModal .data("what", what);
 	viewForm.find('[name=what]').val(what);
 	viewForm.submit();
 });
  let viewForm = $("#viewForm").on("submit", function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize(); // ajaxForm 적용
		$.ajax({
			url : url,
			method : method,
			data : data,
			dataType : "html",
			success : function(resp) {
				viewModal.find(".modal-body").html(resp);
			},
			error : function(errorResp) {
				console.log(errorResp.status);
				viewModal.find(".modal-body").html(errorResp.responseText);
			}
		});
		return false;
	});




 </script>



