<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

<link href="<%=request.getContextPath()%>/resources/css/History.css"
	rel="stylesheet" />



</style>
<title>학생 정보 수정</title>
</head>

<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<body>
<div class="content">
	<div id="all">
		<div id="historyNameArea">
			<h3>학생 정보 수정</h3>
		</div>
		<div id="tableArea">
			<form>
			<table id="historyTable" class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">이름</th>
						<th scope="col">전화번호</th>
						<th scope="col">이메일</th>
						<th scope="col">주소</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">
							<input type="text">
						</th>
						<td><input type="text"></td>
						<td><input type="email"></td>
						<td><input type="text"></td>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
		<div>
			<div id="inputTags">
				<input type="submit" class="btn btn-primary insert" value="수정" />
				<input type="button" class="btn btn-primary insert" value="취소" />
			</div>
		</div>
	</div>
</div>
</body>
