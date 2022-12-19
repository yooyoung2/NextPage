<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- jstl 길이 구하려고... -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>템플릿 판매 현황</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
	<!--
		탬플릿분석
		그래프 참고
		https://coding-restaurant.tistory.com/65 
	 -->
	<div class="content">
		<div class="container-fluid pt-4 px-4">

			<h3>템플릿 분석</h3>


			<div style="width: 900px; height: 900px;">
				<!--차트가 그려질 부분-->
				<canvas id="chDonut1"></canvas>
				<canvas id="chDonut2"></canvas>
				<canvas id="chDonut2"></canvas>
			</div>

		</div>
	</div>

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