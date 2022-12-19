<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="guja"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Content Start -->
<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.11"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<div class="page-content">
	<!-- <section class="row"> -->

			<div class="row">
				<div class="col-6 col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body px-3 py-4-5">
							<div class="row">
								<div class="col-md-4">
									<div class="stats-icon purple">
										<i class="iconly-boldTicket-Star"></i>
									</div>
								</div>
								<div class="col-md-8">
									<!-- 수익현황  ( 작성자 : 최현우 ) -->
									<h6 class="text-muted font-semibold">수익현황</h6>
									<%-- <h6 class="font-extrabold mb-0">${totalSell }</h6> --%>
									<h6 class="font-extrabold mb-0"><span id = "sellAmount">${totalSell }</span></h6>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-6 col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body px-3 py-4-5">
							<div class="row">
								<div class="col-md-4">
									<div class="stats-icon blue">
										<i class="iconly-boldProfile"></i>
									</div>
								</div>
								<div class="col-md-8">
									<h6 class="text-muted font-semibold">방문자수</h6>
									<h6 class="font-extrabold mb-0"><span id = "totalVisitors">${totalVisitors }</span></h6>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-6 col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body px-3 py-4-5">
							<div class="row">
								<div class="col-md-4">
									<div class="stats-icon green">
										<i class="iconly-boldAdd-User"></i>
									</div>
								</div>
								<div class="col-md-8">
									<h6 class="text-muted font-semibold">신규회원</h6>
									<h6 class="font-extrabold mb-0"><span id = "totalMem">${totalMem }</span></h6>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-6 col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body px-3 py-4-5">
							<div class="row">
								<div class="col-md-4">
									<div class="stats-icon red">
										<i class="iconly-boldHeart"></i>
									</div>
								</div>
								<div class="col-md-8">
									<h6 class="text-muted font-semibold">거래현황</h6>
									<h6 class="font-extrabold mb-0"><span id = "dealTotal">${dealTotal }</span></h6>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h4>월별 매출 현황</h4>
						</div>
						<div class="card-body">
							<!-- 그래프 들어갈 곳 -->
							<!-- <div id="chart-profile-visit">hello world!</div> -->
							<canvas id="myChart"></canvas>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header d-flex align-items-center justify-content-between mb-4">
							<h4>거래현황</h4>
							<a class="btn btn-sm btn-primary" href="<%=request.getContextPath()%>/operator/visit/status">상세보기</a>
						</div>
						<div class="card-body">
							<div class="table-responsive ofsc">
								<table class="table table-hover table-lg">
									<thead>
										<tr>
											<!-- 게시글 제목 -->
											<th>날짜</th>
											<th>학교</th>
											<th>탬플릿명</th>
											<th>상품가격</th>
										</tr>
									</thead>
									<tbody>
										<!-- 여기가 게시글 목록 ( for문으로 뿌려주기 ) -->
										<guja:set var="dealList" value="${dealList }" />
										<guja:choose>
											<guja:when test="${not empty dealList }">
												<guja:forEach items="${dealList }" var="deal">

													<tr>

														<td class="col-3">${ deal['day'] }</td>
														<td class="col-3">${ deal['schNm'] }</td>
														<%-- <td class="col-3">${ deal['tmpltId'] }</td> --%>
														<td class="col-3">${ deal['tmpltNm'] }</td>
														<td class="col-4">${ deal['prodPrice'] }</td>
														<%-- <td class="col-3">${ deal['payStat'] }</td> --%>
													</tr>

												</guja:forEach>
											</guja:when>
										</guja:choose>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
	<!-- 	</div> -->

	<!-- </section> -->
</div>

<script type = "text/javascript">


		let sellAmount = document.getElementById( "sellAmount" );
		console.log( ${totalSell } );
		let tmp = ${totalSell };

		let totalVisitors = document.getElementById( "totalVisitors" );
		console.log( ${totalVisitors} );
		let tmp2 = ${totalVisitors};

		let totalMem = document.getElementById( "totalMem" );
		console.log( ${totalMem} );
		let tmp3 = ${totalMem};


		let dealTotal = document.getElementById( "dealTotal" );
		console.log( ${dealTotal} );
		let tmp4 = ${dealTotal};

/* 		setInterval(()=>{

			let cnt = tmp + Math.floor(Math.random() * 1000);
			tmp = cnt;
			sellAmount.innerText = "$" + cnt;

 			let cnt2 = tmp2 + Math.floor(Math.random() * 100);
			tmp2 = cnt2;
			totalVisitors.innerText = cnt2;

			let cnt3 = tmp3 + Math.floor(Math.random() * 10);
			tmp3 = cnt3;
			totalMem.innerText = cnt3;

			let cnt4 = tmp4 + Math.floor(Math.random() * 10);
			tmp4 = cnt4;
			dealTotal.innerText = cnt4;


		}, 300 ); */



</script>


<script type="text/javascript">



	var context = document.getElementById('myChart').getContext('2d');
	/* setInterval( ()=>{ */

		var myChart = new Chart(context,
				{
					type : 'bar', // 차트의 형태
					data : { // 차트에 들어갈 데이터
						labels : [
						//x 축
						'1', '2', '3', '4', '5', '6', '7','8','9','10','11','12' ],
						datasets : [ { //데이터
							label : '월별 매출( $ )', //차트 제목
							fill : false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
							data : [	Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										Math.floor(Math.random() * 10000),
										2022 //x축 label에 대응되는 데이터 값
							],
							backgroundColor : [
							//색상
							'rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ,
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(255, 206, 86, 0.2)'
									],
							borderColor : [
							//경계선 색상
							'rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(255, 206, 86, 1)'
									],
							borderWidth : 1
						//경계선 굵기
						} /* ,
																					                        {
																					                            label: 'test2',
																					                            fill: false,
																					                            data: [
																					                                8, 34, 12, 24
																					                            ],
																					                            backgroundColor: 'rgb(157, 109, 12)',
																					                            borderColor: 'rgb(157, 109, 12)'
																					                        } */
						]
					},
					options : {
						scales : {
							yAxes : [ {
								ticks : {
									beginAtZero : true
								}
							} ]
						}
					}
				});

/* 	} , 1000 ); */

</script>


