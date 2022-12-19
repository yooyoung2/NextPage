<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- jstl 길이 구하려고... -->
<!--
	AUTHOR : JACK SNIDER
	DATE : 2022-11-26
	통합
 -->
	<head>
		<meta charset="UTF-8">
		<title>방문현황</title>

		<link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
		<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>

		<style>
			.container{
				display:flex;
				flex-direction: column;
				/* border: 1px dotted red; */
				padding: 10px;
				width: 100%;
				height: 100%;
			}

			.item{
				display: flex;
				flex-direction: row;
				justify-content: center;
				/* border: 1px solid green; */
				padding: 10px;
				margin-bottom: 2%;
			}

			.item-item{
				flex:1;
				justify-content: center;
				/* border : 1px solid red; */
				margin : 1%;
			}

		</style>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	</head>

	<body>
		<div class="content"> <!-- content start -->
			<div class = "container"> <!-- container start -->

<!-- =========================================================================================================== -->
<!-- 			<div class = "item">item 02 start
				<div class = "item-item">
					<h3>실시간 매출액 : $<span id = "counter"></span></h3>
					<h2>JACK SNIDER IS GOOD</h2>
				</div>

				<div class = "item-item">

				</div>

			</div>item 02 end -->
<!-- =========================================================================================================== -->
<!-- ===================================================== SECTION 1 ===================================================== -->
			<div class = "item"><!-- item 01 start -->

				<div class = "item-item">
					<!-- 방문현황 start -->
					<div class="card">
						<h3>방문현황 - MONTHLY</h3>
<!-- 					<select>
							<option value="">DAILY</option>
							<option value="">WEEKKY</option>
							<option value="">MONTLY</option>
						</select> -->

						<div >
							<!-- 	<div class="col-md-8"> -->
							<canvas id="myChart"></canvas>
						</div>
					</div>
					<!-- 방문현황 end -->
				</div>

				<div class = "item-item">
					<!-- 유입시간대 start -->
					<div class="card">
						<h3>방문현황 - WEEKLY</h3>
		<!-- 				<select>
							<option value="">DAILY</option>
							<option value="">WEEKKY</option>
							<option value="">MONTLY</option>
						</select> -->

						<div >
							<!-- 	<div class="col-md-8"> -->
							<!--차트가 그려질 부분-->
							<canvas id="myChart2"></canvas>
						</div>
					</div>
					<!-- 유입시간대 end -->
				</div>

			</div><!-- item 01 end -->
<!-- =========================================================================================================== -->
<!-- ===================================================== SECTION 2 ===================================================== -->
			<div class = "item"><!-- item 03 start -->
				<div class = "item-item">
					<!-- 탬플릿 - 판매현황 start -->
					<div class="card">
						<h3>탬플릿 - 판매현황</h3>
		<!-- 				<select>
							<option value="">DAILY</option>
							<option value="">WEEKKY</option>
							<option value="">MONTLY</option>
						</select> -->

						<div >
							<!-- 	<div class="col-md-8"> -->
							<!--차트가 그려질 부분-->
							<canvas id="myChart3"></canvas>
						</div>
					</div>
					<!-- 탬플릿 - 판매현황 end -->
				</div>


				<div class = "item-item">
					<!-- 탬플릿 - 사용현황 start -->
					<div class="card">
						<h3>템플릿 - 사용현황</h3>
		<!-- 				<select>
							<option value="">DAILY</option>
							<option value="">WEEKKY</option>
							<option value="">MONTLY</option>
						</select> -->

						<div >
							<!-- 	<div class="col-md-8"> -->
							<!--차트가 그려질 부분-->
							<canvas id="myChart4"></canvas>
						</div>
					</div>
					<!-- 탬플릿 - 사용현황 end -->
				</div>

			</div><!-- item 03 end -->



<!-- =========================================================================================================== -->
			</div><!-- container end -->

	</div><!-- content end -->
	</body>



<script>

window.onload = function(){

    /*
    getFullYear() – 주어진 날짜의 연도를 네 자리 숫자로 반환합니다
    getMonth() – 주어진 날짜의 월 값을 나타내는 0에서 11 사이의 정수를 반환합니다
    getDate() – 주어진 날짜의 일에 해당하는 1 이상 31 이하의 정수를 반환합니다
    getHours() – 주어진 날짜의 시를 나타내는 0에서 23 사이의 정수를 반환합니다
    */


   let count = 234231;
   setInterval(() => {
     /*    let date = new Date();

        let year = date.getFullYear();
        let month = date.getMonth();
        let day = date.getDate();
        let hour = date.getHours();
        let minute = date.getMinutes();
        let second = date.getSeconds();


        let time =  year + "년 " + month + "월  " + day + "일  " + hour + "시 " + minute + "분 "  +   second  + "초";
        document.getElementById( "clock" ).innerText = time; */

        let num = count + Math.floor(Math.random() * 100);
        count = num;
        document.getElementById( "counter" ).innerText = num;



    }, 100 );

}

</script>



<!-- ======================================== CHART ======================================== -->
<script>
var context = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(context,
		{
			type : 'bar', // 차트의 형태
			data : { // 차트에 들어갈 데이터
				labels : [
				//x 축
				'1', '2', '3', '4', '5', '6', '7','8','9','10','11','12' ],
				datasets : [ { //데이터
					label : 'MONTHLY', //차트 제목
					fill : false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
					data : [	${monthly.get(0)['visitorAmount']},
								${monthly.get(1)['visitorAmount']},
								${monthly.get(2)['visitorAmount']},
								${monthly.get(3)['visitorAmount']},
								${monthly.get(4)['visitorAmount']},
								${monthly.get(5)['visitorAmount']},
								${monthly.get(6)['visitorAmount']},
								${monthly.get(7)['visitorAmount']},
								${monthly.get(8)['visitorAmount']},
								${monthly.get(9)['visitorAmount']},
								${monthly.get(10)['visitorAmount']},
								${monthly.get(11)['visitorAmount']} //x축 label에 대응되는 데이터 값
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
</script>
<script type="text/javascript">
		var context = document.getElementById('myChart2').getContext('2d');
		var myChart = new Chart(context,
				{
					type : 'bar', // 차트의 형태
					data : { // 차트에 들어갈 데이터
						labels : [
						//x 축
						'1', '2', '3', '4', '5', '6', '7' ],
						datasets : [ { //데이터
							label : 'WEEKLY', //차트 제목
							fill : false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
							data : [
								${weekly.get(0)['visitorAmount']},
								${weekly.get(1)['visitorAmount']},
								${weekly.get(2)['visitorAmount']},
								${weekly.get(3)['visitorAmount']},
								${weekly.get(4)['visitorAmount']},
								${weekly.get(5)['visitorAmount']},
								${weekly.get(6)['visitorAmount']}
							],
								//21, 19, 25, 20, 23, 26, 25 //x축 label에 대응되는 데이터 값
							backgroundColor : [
							//색상
							'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [
							//경계선 색상
							'rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
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
	</script>




<!-- ===================================================================================================== -->
	<script type="text/javascript">


		console.log( "JACK SNIDER : " + ${fn:length(templateSell)} );

		let dataList = new Array();
		for( var i = 0; i < ${fn:length(templateSell)}; i++ ){
			dataList[i] = ${templateSell.get(i)["amount"]}  + Math.floor(Math.random() * (10 - 1) + 1) ;
			console.log( i + "번째 : " + dataList[i] );
		}

		var context = document.getElementById('myChart3').getContext('2d');
		var myChart = new Chart(context,
				{
					type : 'bar', // 차트의 형태
					data : { // 차트에 들어갈 데이터
						labels : [
						//x 축
						'1', '2', '3', '4', '5', '6', '7' ],
						datasets : [ { //데이터
							label : 'TEMPLATE SELL', //차트 제목
							fill : false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
							data : dataList,
							backgroundColor : [
							//색상
							'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [
							//경계선 색상
							'rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
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
	</script>
<!-- ===================================================================================================== -->
	<script type="text/javascript">

		console.log( "TEMPLATE USE : " + ${fn:length(templateSell)} );

		let useList = new Array();
		for( var i = 0; i < ${fn:length(templateUse)}; i++ ){
			useList[i] = ${templateUse.get(i)["amount"]} + Math.floor(Math.random() * (10 - 1) + 1);
			console.log( i + "번째 : " + useList[i]  );
		}


		var context = document.getElementById('myChart4').getContext('2d');
		var myChart = new Chart(context,
				{
					type : 'bar', // 차트의 형태
					data : { // 차트에 들어갈 데이터
						labels : [
						//x 축
						'1', '2', '3', '4', '5', '6', '7' ],
						datasets : [ { //데이터
							label : 'TEMPLATE USE', //차트 제목
							fill : false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
							data : useList,
							backgroundColor : [
							//색상
							'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [
							//경계선 색상
							'rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
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
	</script>
<!-- ===================================================================================================== -->



<script type="text/javascript">

			var lstLength = ${fn:length(data)}; // data의 길이 구하기
			console.log( lstLength );


			valueList = [];

			for( let i = 0; i < 7; i++ ){
				console.log( "i : " + i );
				valueList.push( ${data[i]['amount']} );
				console.log( ${data[i]['amount']} );
			}



			var colors = ['red','skyblue','yellowgreen','#c3e6cb','#dc3545','#6c757d',
							'#00FFFF'
				];

			var donutOptions = {
			  cutoutPercentage: 30, //도넛두께 : 값이 클수록 얇아짐
			  legend: {position:'bottom', padding:5, labels: {pointStyle:'circle', usePointStyle:true}}
			};

			// donut 1
			var chDonutData1 = {
			    labels: ['탬플릿1', '탬플릿2', '탬플릿3', '탬플릿4', '탬플릿5','탬플릿6','탬플릿7'],
			    datasets: [
			      {
			        backgroundColor: colors.slice(0,7),
			        borderWidth: 0,
			        data: [25,6,20,29,1,17,1]

			      }
			    ]
			};

			var chDonut1 = document.getElementById("chDonut1");
			  if (chDonut1) {
			    new Chart(chDonut1, {
			      type: 'pie',
			      data: chDonutData1,
			      options: donutOptions
			  });
			}

	</script>