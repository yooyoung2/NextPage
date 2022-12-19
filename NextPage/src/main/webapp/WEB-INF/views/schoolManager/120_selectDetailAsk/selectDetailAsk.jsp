<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>

<style>
.tableLeft {
	width: 15%;
	text-align: center;
}

.disable-div {
	pointer-events: none;
}

.pBox {
	display: block;
	width: 100%;
	padding: 0.375rem 0.75rem;
	font-weight: 400;
	line-height: 1.5;
	background-color: #fff;
	border-radius: 0.25rem;
}

textarea {
	width: 100%;
}

#trp{
	height: 300px;
	overflow: scroll;
}

</style>
<div class="content">
	<form:form method="GET" modelAttribute="myQuestion" id="frm">
		<h3>문의 상세조회</h3>
		<div id="container" class="disable-div">
			<table class="table" style="border: 1px solid lightsteelblue;">
				<tr>
					<th class="table-success tableLeft"><p style="float: left;">제목</p></th>
					<th><form:input class="form-control" path="otoBrdTitle"></form:input></th>
					<th class="table-success tableLeft"><p style="float: left;">작성일자</p></th>
					<th><form:input class="form-control" path="wrteDate" readonly="true"></form:input></th>
					<th class="table-success tableLeft"><p style="float: left;">처리여부</p></th>
					<th  id="otoStat">${myQuestion.prgrsCndtn }</th>
					<th><form:input class="form-control" path="otoBrdNum" hidden="true"></form:input></th>
					<input type="hidden" id="writerId" value="${myQuestion.schId}"/>
				</tr>
				<tr id="trp">
					<th class="table-success"><p style="float: left;"
							class="tableLeft">내용</p></th>
					<th colspan="4" ><form:textarea path="otoBrdCntnt" /></th>

				</tr>
			</table>
		</div>
		<div align="right">
			<form:button type="button" class="btn btn-success" id="updateBtn">수정</form:button>

<%-- 			<c:url value="postDelete" var="mqViewURL"> --%>
<%-- 				<c:param name="what" value="${myQuestion.otoBrdNum }" /> --%>
<%-- 			</c:url> --%>
<%-- 			<a href="${mqViewURL }"><button type="button" --%>
<!-- 					class="btn btn-danger">삭제</button></a> <br> -->
		</div>
	</form:form>
	<%-- <form:form method="GET" modelAttribute="comment" >
	<table class="table " style="border: 1px solid lightsteelblue; text-align: center;">
		<tr>
			<th class="tableLeft table-success">댓글</th>
			<th></th>
		</tr>
	</table>
</form:form> --%>


	<!-- 댓글기능  -->
	<section class="section">
		<div class="row mt-3">
			<div class="col">
				<div class="card">
					<div class="table-responsive">
						<table class="table text-start align-middle table-bordered table-hover mb-0">
							<thead class="thead-dark">
								<tr>
									<th>작성자</th>
									<th>답변내용</th>
									<th>작성일자</th>
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
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="section">
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-header">추가문의</div>
					<div class="card-body">
						<form:form modelAttribute="cmnt" method="post" id="viewForm" name="viewForm"
							action="${pageContext.request.contextPath}/school/manager/my/question/insert"
							enctype="multipart/form-data">
							<input type="hidden" name="otoBrdNum" value="${myQuestion.otoBrdNum }" />
							<input hidden disabled="disabled" name ="otoId" id="otoId" value="${sessionScope.authSch}" />
							<div class="form-floating">
								<input type="text" class="form-control" name="cmmntCntnt" placeholder="문의사항을 작성해주세요" id="cmmntCntnt">
								<label for="floatingTextarea">Comments</label>
							</div>
							<div class="d-flex justify-content-end mt-3">
								<input id="changeStatus" type="button" value="등록" class="btn btn-primary" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="d-flex justify-content-end">
			<div class="me-3">
				<a href="javascript:window.history.back()"><button id="del" class="btn btn-warning">뒤로</button></a>
			</div>
		</div>

<script type="text/javascript" defer="defer">



	//소켓연결시작
// 	let webSocket = null;

	$(document).ready(function() {

		//var url = 'ws://' + window.location.host + '${pageContext.request.contextPath}/usersServerEndpoint';
// 		var url = 'ws://localhost:81/NextPage/alram';
// 		var url = 'ws://localhost/NextPage/alram';

// 		webSocket = connection(url);
// 		webSocket.onopen = function(){ processOpen(); };
// 		webSocket.onmessage = function(message) { processMessage(message); };
// 		webSocket.onerror = function(message) { processError(message); };



		  $("#changeStatus").on("click", function(event){
				event.preventDefault();

				console.log("메시지 전송..");

				let url = "${pageContext.request.contextPath}/school/manager/my/question/insert";
				let data = $("#viewForm").serialize(); // ajaxForm 적용
				$.ajax({
					url : url,
					method : "post",
					data : data,
					dataType : "html",
					success : function(resp) {
						//세션에 저장된 아이디, 현재 글번호 가져오기
						let socketMsg = ($("#otoId").val()+"," + $('[name=otoBrdNum]').val()+","+$('#writerId').val());
						console.log( $('#writerId').val());
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


// 	function connection(url) {
// 		var webSocket = null;
// 		if ('WebSocket' in window) {
// 			webSocket = new WebSocket(url);
// 		} else if ('MozWebSocket' in window) {
// 			webSocket = new MozWebSocket(url);
// 		} else {
// 			Console.log('Error: WebSocket is not supported by this browser.');
// 	        return null;
// 		}
// 		return webSocket;
// 	}

// 	function processOpen() {
// 		connectionType = "firstConnection";
// 		console.log("소켓연결성공!!");
// 		//username = "${loginVO.name}";
// 		//webSocket.send(JSON.stringify({ "connectionType" : connectionType, "username" : username }));
// 	}

// 	//server에서 메시지가 넘어왔을때
// 	function processMessage(message) {
// 		alert(message.data);
// 		toastr.success(JSON.stringify(message.data));
// 		console.log("processMessage : ", message);
// // 		webSocket.close();
// 	}

// 	function processError(message) {
// 		/* messagesTextArea.value += "error...\n"; */
// 		console.log("processError : ", message);
// 	}

// 	window.onbeforeunload = function() {
// 		webSocket.close();
// 	};



</script>


<script>
	CKEDITOR.inline('otoBrdCntnt');

    	$('.btn-success').click( function() {
	    	if( $(this).html() == '수정' ) {
	     		$(this).html(
		     		$('<a>').attr("href","#")
		     				.attr("data-otoBrdNum",${myQuestion.otoBrdNum})
		     				.attr("id","submitBtn")
		     				.text('적용')
	     		).attr('type','button');


	     	$('.btn-danger').html('취소');
		     	document.getElementById('container').classList.remove('disable-div')
	    	}
    	});

    	$(".btn-danger").click( function() {
    		if( $(this).html() == '취소' ) {
    			$(this).html('삭제');
    			$('.btn-success').html('수정');
    			document.getElementById('container').className += 'disable-div';
    		}
    	});


 	$(document).on("click","#submitBtn", function(event){
			let form = document.getElementById( "frm" );
			form.setAttribute( "method", "POST" );
			form.submit();

	});


</script>

