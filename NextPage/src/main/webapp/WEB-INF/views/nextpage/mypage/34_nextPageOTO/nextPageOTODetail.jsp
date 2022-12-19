<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>

<style>
.content{
margin-top : 3%;
}

#container{
margin-top : 3%;
}
.table {
  border: 1px #848484 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-radius: 5px;
  overflow: hidden;
  text-align: center;
  vertical-align : middle;
}

  
#contentTh , thead .theadClass{
  font-weight: bold;
  color: #fff;
  background: #A9A9F5;
}
#h3Tag{
text-align:center;
}
.disable-div {
	pointer-events: none;
}

textarea {
	width: 100%;
}

 #trp{
 	height: 300px; 
 	overflow: scroll;
} 
#secondThead{
	margin-top : 4%;
}
#cmtTr{
	height : 30px;
}
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}
</style>

<div class="content">
	<form:form method="GET" modelAttribute="myQuestion" id="frm">
		<h3 id="h3Tag">문의 상세조회</h3>
		<div id="container" class="disable-div">
			<table class="table">
			<thead>
				<tr>
					<th class="theadClass">제목</th>
					<th colspan="5">${myQuestion.otoBrdTitle}</th>
				</tr>
				<tr id="secondThead">
					<th class="theadClass">작성일자</th>
					<th>${myQuestion.wrteDate}</th>
					<th class="theadClass">처리여부</th>
					<th  id="otoStat">${myQuestion.prgrsCndtn }</th>
					<th><form:input class="form-control" path="otoBrdNum" hidden="true"></form:input></th>
					<input type="hidden" id="writerId" value="${myQuestion.schId}"/>
				</tr>
			</thead>
				<tr id="trp">
					<th class="theadClass" id="contentTh">내용</th>
					<th colspan="4" style="text-align: left;"><form:textarea path="otoBrdCntnt" /></th>

				</tr>
			</table>
		</div>
	</form:form>



	<!-- 댓글기능  -->
	<section class="section">
		<div class="row mt-3">
			<div class="col">
						<table class="table" id="cmntTable">
								<c:choose>
									<c:when test="${not empty cmnt }">
										<c:forEach items="${cmnt}" var="cmnt">
											<tr id="cmtTr" style="text-align:center; ">
												<td style="width:20%; height:30px;">${cmnt.cmntId}</td>
												<td colspan="2" style="width:50%;">${cmnt.cmmntCntnt}</td>
												<td colspan="2"style="width:30;">${cmnt.cmmntDate}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="5">답변 없음</td>
										</tr>
									</c:otherwise>
								</c:choose>
						</table>
					</div>
				</div>
			</div>
	</section>
		<div class="d-flex justify-content-end">
			<div class="me-3">
				<a href="javascript:window.history.back()"><button id="del" class="btn btn-warning">뒤로</button></a>
			</div>
		</div>

<script type="text/javascript" defer="defer">



	//소켓연결시작
	$(document).ready(function() {

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

