<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

<title>재학생 목록</title>
</head>

<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<body>
<div class="content">
	<div id="all">
		<div id="historyNameArea">
			<h3>재학생 목록</h3>
		</div>
		<div>
			<div id="yearChoiceArea">
				<button type="button" class="btn btn-outline-light">2020</button>
				<button type="button" class="btn btn-outline-light">2021</button>
				<button type="button" class="btn btn-outline-light">2022</button>
			</div>
			<div id="inputTags">
				<button type="button" class="btn btn-primary"
					onclick="location.href='<%=request.getContextPath()%>/schoolManager/studentEachInsert'">개별등록</button>
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#myModal">일괄등록</button>
			</div>
		</div>
		<div>
			<table id="historyTable" class="table text-start align-middle table-bordered table-hover mb-0">
				<thead>
					<tr>
						<th scope="col">연도</th>
						<th scope="col">학번</th>
						<th scope="col">이름</th>
						<th scope="col">학년</th>
						<th scope="col">반</th>
						<th scope="col">상태</th>
					</tr>
				</thead>
				<tbody>
					<tr class="modify" onclick="modify()">
						<th scope="row">2014</th>
						<td>1465001</td>
						<td>강은비</td>
						<td>졸업생</td>
						<td>졸업생</td>
						<td>졸업</td>
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
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title"></h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<table class="table table-borderless">
							<thead>
								<tr>
									<th>양식<br>다운로드
									</th>
									<th><button class="btn btn-info">다운로드</button></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td>일괄등록<br>양식 첨부
									</td>
									<td><input type="file" name="file" id="file"
										class="upload-box upload-plus" accept="image/*"></td>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Upload</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script>
// upadate만들어야함
$("#historyTable").on("click",".modify",function(){
	location.href="<%=request.getContextPath()%>
	/schoolManager/"
	})
</script>