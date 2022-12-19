<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
 
 
 <style>
.card-front{
    width: 80%;
    height: 400px;
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
  	margin-left: 8%;
    margin-top: 7%;
}

#title, .h5Tag, .pTag {
	margin-top:6%;
	text-align: center
	
}
.btnArea{
text-align: center;
}

#ticketTable{
	width : 600px;
    margin-left:auto; 
    margin-right:auto;
}
.btn{
	margin-top : 5%;
}

</style>

	<div class="card-front">
		<div>
			<h2 id="title">※ 이용취소시 유의사항 ※</h2>
		</div>
		<div class="single-post-text">
			<h5 class="h5Tag">마지막 결제일 : 2022.12.15</h5>
			<h5 class="h5Tag">2023년01월9일부터 결제에서 제외 되며,<br>2023년01월9일부터 생성된 홈페이지는 이용할 수 없습니다.</h5>
			<div class= "btnArea">
				<c:if test="${schInfo.srvcWhthr eq 'YES' }">
					<button class="payBtn btn btn-danger" id="paymentCancel">이용권 취소</button>
				</c:if>
				<c:if test="${schInfo.srvcWhthr eq 'NO' }">
					<button class="payBtn btn btn-danger" disabled>취소할 이용권이 없습니다.</button>
				</c:if>
			</div>
		</div>
	</div>
 
<script>

var schId = `${schInfo.schId}`;

$('#paymentCancel').click(cancel);

function cancel(){
	$.ajax({
		url : "${pageContext.request.contextPath}/nextpage/mypage/payCancel",
		method : "post",
		data : {"schId" : schId},
		datatype : "html",
		success : function(resp) {
			alert(resp);
			location.href=location.href;
		},
		error : function(errorResp) {
			alert(errorResp.status);
		}
	});
}
</script>