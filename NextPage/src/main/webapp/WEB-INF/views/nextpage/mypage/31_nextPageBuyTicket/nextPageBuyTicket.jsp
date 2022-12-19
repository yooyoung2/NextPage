<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<style>
.card-front{
    width: 80%;
    height: 600px;
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
	text-align: center

}
#titleBox{
margin-top:10%;
}

.single-post-text{
margin-top:5%;
}
#ticketTable{
	margin-top:5%;
	width : 600px;
    margin-left:auto;
    margin-right:auto;
}

.btnArea{
margin-top:7%;
text-align: center;
}
</style>

	<div class="card-front">
		<div id="titleBox">
			<h2 id="title">이용권 구매</h2>
		</div>
		<div class="single-post-text">
			<h5 class="h5Tag">홈페이지 제너리팅 비용은 최초 100,000원이 결제되고,</h5>
			<h5 class="h5Tag">이후 매월 10,000원의 금액이 부과됩니다.</h5>
			<h5 class="h5Tag">첫 결제는 일할처리되며 다음달 9일까지의 결제금액을 계산하여 부과합니다.</h5>

			<table id="ticketTable" class="table table-bordered">
				<thead>
					<tr>
						<th scope="col" class="tableTitle"></th>
						<th scope="col" class="tableTitle">구매권 명</th>
						<th scope="col" colspan="2" class="tableTitle">비용</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th rowspan="2"></th>
						<td>최초구매</td>
						<td>100,000원</td>
					</tr>
					<tr>
						<td>금일 정기권 구매시</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${price}" />원</td>
					</tr>
					<tr>
						<th scope="row">총액</th>
						<td colspan="2" style="text-align:center;"><span id="totalPrice"></span></td>
					</tr>
				</tbody>
			</table>
			<div class="btnArea">
				<c:choose>
					<c:when test="${schInfo.fstPchStat eq 'YES' }">
						<button class="btn btn-danger" disabled>이용권 결제 완료</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-success" id="buyTicket">이용권 결제하기</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>

//아임포트 실행시키기위한 전역변수 선언
var IMP = window.IMP;
IMP.init("imp77053745"); // 발급받은 "가맹점 식별코드"로 초기화

var genPrice = 100000;
var dayPrice = ${price}
var total = genPrice + dayPrice;

	// 기본10만원 + 오늘 기준 금액 표시
	$(document).ready(function() {
		$("#totalPrice").text(total.toLocaleString()+"원");
	});

	// 결제 버튼 클릭시
	$("#buyTicket").click(pay);

	function pay(){

		//결제 아이디
		var payId = 'NP_' + new Date().getTime();
		// 구매가격
		var price = total;
		// 학교이름
	 	var schNm = `${schInfo.schNm}`;
	 	// 학교 전화번호
		var schTelNum = `${schInfo.schTelNum}`;
		var schId = `${schInfo.schId}`;

		// 아임포트 시작
		IMP.request_pay({
		// param
			pg : "html5_inicis.INIpayTest",
			pay_method : "card",
			merchant_uid : payId,
			name : '이용권(제너레이팅비용 포함)구매',
			amount : total,
			buyer_name : schNm,
			buyer_tel : schTelNum,
		},
		function(rsp) { // callback
			if (rsp.success) {
				$.ajax({
					url : "${pageContext.request.contextPath}/nextpage/mypage/ticket/buyTicket",
					method : "post",
					data : {
						"schId":schId
						,"payId":payId
						},
					datatype : "html",
					success : function(resp) {
						Swal.fire({
							  title: resp,
							  confirmButtonText: '확인',
							}).then((result) => {
							  /* Read more about isConfirmed, isDenied below */
							  if (result.isConfirmed) {
								location.href=location.href;
							} else if (result.isDenied) {
							    Swal.fire('결제취소', '', 'info')
							}
						})


					},
					error : function(errorResp) {
						Swal.fire({
							  position: 'center',
							  icon: 'error',
							  title: errorResp.error_msg ,
							  showConfirmButton: false,
							  timer: 1500
							})
					}
			}).done(function(data) {
					// 가맹점 서버 결제 API 성공시 로직
				})
			} else {
				if (rsp.error_msg.indexOf("0원") != -1) { // 찾았다 같은말로 ">=0"
				// 에러메세지에서 0원이 포함 되어있는 경우
					Swal.fire({
						  position: 'center',
						  icon: 'error',
						  title: '상품 선택 후 이용해주세요',
						  showConfirmButton: false,
						  timer: 1500
						})
					return;
					}
				if (rsp.error_msg.indexOf("취소") != -1) {
				// 에러메세지에서 취소가 들어가있는 경우
					Swal.fire({
						  position: 'center',
						  icon: 'error',
						  title: '사용자가 결제를 취소하셨습니다',
						  showConfirmButton: false,
						  timer: 1500
						})
					return;
					}
			}
		});
	};
</script>
