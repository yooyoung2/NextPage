<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<title>게시물이력</title>
</head>

<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<body>
<div class="content">
	<div id="all">
		<div id="historyNameArea">
			<h3>게시물이력</h3>
		</div>
		<div>
			<div id="inputTags">
				<input class="search__tag" type="text" placeholder="🔎회원아이디" />
				<input type="text" class="datepicker">
			</div>
		</div>
		<div>
			<table id="historyTable" class="table text-start align-middle table-bordered table-hover mb-0">
				<thead>
					<tr>
						<th scope="col" class="postId">학번/사번/아이디</th>
						<th scope="col">날짜</th>
						<th scope="col">상태</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row" class="postId">1</th>
						<td>Mark</td>
						<td>Otto</td>
					</tr>
					<tr>
						<th scope="row" class="postId">2</th>
						<td>Jacob</td>
						<td>Thornton</td>
					</tr>
					<tr>
						<th scope="row" class="postId">3</th>
						<td>Jacob</td>
						<td>Thornton</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<nav id="pagingBtn" aria-label="...">
				<ul class="pagination">
					<li class="page-item disabled"><span class="page-link">Previous</span>
					</li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item active" aria-current="page"><span
						class="page-link">2</span></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
</body>

<script>
	$(".datepicker").datepicker().datepicker('setDate', new Date());
	$(".datepicker").datepicker("option", "dateFormat", "yy-mm-dd");
	$.datepicker.setDefaults({
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
				'10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년',
		dateFormat : 'yy-mm-dd',
		constrainInput : true
	});

	$(function() {
		$('.datepicker').datepicker();
	});
</script>

