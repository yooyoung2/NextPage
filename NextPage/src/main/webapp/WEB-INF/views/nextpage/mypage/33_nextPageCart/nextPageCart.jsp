<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>


table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
  text-align : center;
}


  
thead {
  font-weight: bold;
  color: #fff;
  background: #435ebe;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
 }
 
h2{
margin-left: 45%;
margin-top: 5%;
margin-bottom: 3%;
}

#payBtn{
    float: right;
    margin-top: 4%;
    margin-right: 8%;
    width: 20%;
    height: 50px;
    background-color:#435ebe;
    border: 1px solid #435ebe;
}
#delBtn{
  color : red;
  top: 0;
  right: 0;
  height: inherit;
  border: none;
  outline: none;
  cursor: pointer;
  background-color:white;
  font-weight : 1000;
}

#checkTh{
	width :8% ;
}
#cartNumTh{
	width : 20%;
}
#pridIdTh{
	width : 20%;
}
#tempTh{
	width : 20%;
}
#priceTh{
	width : 20%;
}
#xTh{
	width : 10%;
}
</style>

			<div>
				<h2 class="heading-section">장바구니</h2>
			</div>
		<div class="row">
			<div class="col-md-12">
				<div class="table-wrap">
				<input type="hidden" id="schNm" value="${schInfo.schNm}"/>
				<input type="hidden" id="schTelNum" value="${schInfo.schTelNum}"/>
					<table>
						<thead>
							<tr>
								<th id="checkTh"><input class="form-check-input" type="checkbox"
									id="flexCheckChecked" name="_selected_all_"></th>
								<th id="cartNumTh">카트번호</th>
								<th id="pridIdTh">상품ID</th>
								<th id="tempTh">템플릿명</th>
								<th id="priceTh">금액</th>
								<th id="xTh"></th>
							</tr>
						</thead>
						<%-- <c:set var="prodList" value="${cartList.prodList }"></c:set> --%>
						<tbody id="listBody">
							<c:choose>
								<c:when test="${not empty cartList }">
									<c:forEach items="${cartList}" var="cart">
										<tr>
											<td><input onclick="total()" class="form-check-input" type="checkbox" id="flexCheckChecked" name="_selected_"></td>
											<td>${cart.cartId}</td>
											<td>${cart.prodId}</td>
											<td>${cart.prodNm}</td>
											<td>${cart.prodPrice}</td>
											<td><button id="delBtn" onclick="deleteCart('${cart.cartId}','${cart.prodId}')">X</button></td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="5" align="center"><h6 id="totalPrice">총금액  0원</h6></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3">장바구니가 비었습니다!</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					
					<c:if test="${schInfo.fstPchStat eq 'YES' }">
						<button id="payBtn" class="btn btn-success">결제하기</button>
					</c:if>
					<c:if test="${schInfo.fstPchStat eq 'NO' }">
						<button id="payBtn" class="btn btn-danger" disabled>결제하기</button>
					</c:if>
				</div>
			</div>
		</div>


<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">

// 아임포트 실행시키기위한 전역변수 선언
var IMP = window.IMP;
IMP.init("imp77053745"); // 발급받은 "가맹점 식별코드"로 초기화

//================================================================================================================

//전체 체크하기
$('input[name=_selected_all_]').on('change', function() {
	$('input[name=_selected_]').prop('checked', this.checked);
	total();
});

//================================================================================================================
	// 장바구니 삭제
function deleteCart(cartId,prodId){
	console.log(cartId);
	console.log(prodId);
	$.ajax({
		url : "${pageContext.request.contextPath}/nextpage/mypage/cartDel",
		method : "post",
		data : {
			"cartId" : cartId,
			"prodId" : prodId
		},
		success : function(resp) {
			location.reload();
		},
		error : function(errorResp) {
			console.log(errorResp.status);
		}
	});
}

	
	

//================================================================================================================
// 체크박스 체크시 가격계산 해서 뷰로 보여주기
function total(){
	var checkbox = $(":input[name=_selected_]:checked");	// 체크된거 가져오기
	
	let dataList = [];				// td한줄한줄 가져와서 넣을 배열
	var totalSum = 0;
	checkbox.each(function(i,ckbox) {
		
		var tr = ckbox.parentElement.parentElement;			// 체크박스의 상위(<td>)의 상위(<tr>)
		var tds = tr.children;								// 위에서 구한 tr의 자식 태그들
		
		totalSum += parseInt(tds[tds.length-2].innerText) 		// 상품 가격이 위치한 인덱스의 값을 꺼내고 숫자로 파싱
	});
	var total = totalSum.toLocaleString();
	$('#totalPrice').text("총금액  "+total+"원");
}

//================================================================================================================

//체크박스 체크된 행 값 가져오기 실행!!!!
$("#payBtn").click(pay);		// 괄호 붙이면 클릭안해도 실행되버림

//================================================================================================================

// 결제하기 버튼 눌렀을때 실행
function pay(){ 

	var schNm = document.getElementById('schNm').value;
	var schTelNum = document.getElementById('schTelNum').value;
	
	console.log(schNm);
	console.log(schTelNum);
// 아임포트 실행 전 전달 할 값 추출!!!!
	var checkbox = $("input[name=_selected_]:checked");		// 체크된거 가져오기
	console.log(checkbox);
	
	let dataList = [];	// td한줄한줄 가져와서 넣을 배열
	var cartId=[];			// 구매할 상품의 카트아이디들을 넣을 변수
	var prodId=[];			// 구매할 상품의 상품아이디들을 넣을 변수
	var prodNm=[];			// 구매할 상품의 상품이름들을 넣을 변수
	var prodPrice=[];		// 구매할 상품의 상품가격들을 넣을 변수
	var totalSum = 0;		// 구매할 상품들의 총액
	var payId = 'NP_' + new Date().getTime();
	
	checkbox.each(function(i,ckbox) {
		console.log("ck:",i,ckbox);
		console.log("tr",ckbox.parentElement.parentElement); // $().closest("tr")
		
		var tr = ckbox.parentElement.parentElement;// 체크박스의 상위(<td>)의 상위(<tr>)
		var tds = tr.children;								// 위에서 구한 tr의 자식 태그들
	 	
		totalSum += parseInt(tds[tds.length-2].innerText) // 상품 가격이 위치한 인덱스의 값을 꺼내고 숫자로 파싱
		

		
		var colNames = ["cartId","prodId","prodNm","prodPrice","payId"];
	    var rawData = {};
	    
		for(let i=1; i<tds.length; i++){
			console.log("아아ㅏ아아"+colNames[i]);
			rawData[colNames[i]] = payId
			console.log(rawData[colNames[i]]);
		    rawData[colNames[i-1]] = tds[i].innerText;
		    console.log("for문 안에는 괜찮은가",rawData);
		}
		dataList.push(rawData);	
	});


	
 	console.log("dataList : ", dataList);
	console.log("merchant_uid : ",'NP_' + new Date().getTime())
// 추출끝	


// 아임포트 시작
	   IMP.request_pay({ // param
	          pg: "html5_inicis.INIpayTest",
	          pay_method: "card",
	          merchant_uid: payId,
	          name: '템플릿 구매',
	          amount: totalSum,
	          buyer_name: schNm,
	          buyer_tel: schTelNum,
	      }, function (rsp) { // callback
	          if (rsp.success) {
	        		$.ajax({
	        			url : "${pageContext.request.contextPath}/nextpage/mypage/pay",
	        			method : "post",
	        			contentType:"application/json; charset=utf-8",
	        			data :JSON.stringify(dataList),
	        			datatype : "html",
	        			success : function(resp) {
	        				Swal.fire({
								  position: 'center',
								  icon: 'success',
								  title: resp ,
								  showConfirmButton: false,
								  timer: 1500
								})
	        				location.reload();
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
	        		}).done(function (data) {
	              // 가맹점 서버 결제 API 성공시 로직
	            })
	          } else {
	            // alert(rsp.error_msg);
	            if(rsp.error_msg.indexOf("0원") != -1){		// 찾았다 같은말로 ">=0"
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
	            
	            if(rsp.error_msg.indexOf("취소") != -1){
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
	            
	            //alert("선택한 결제 상품이 없습니다");
	          }
	      });

}


//================================================================================================================
	

</script>
</html>

