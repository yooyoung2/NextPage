<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="robots" content="noindex, nofollow">
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>

<!-- Page content-->
<div class="container mt-5">

	<div class="row">
		<div class="col-lg-8">
			<!-- Post content-->
			<!-- Post content-->
			<section class="mb-5">
				<div class="row justify-content-center">
					<form
						action="<%=request.getContextPath()%>/nextpage/PostingInsert.do"
						method="post" enctype="multipart/form-data">
						<table class="table-hover">
							<tr>
								<th>제목</th>
								<td colspan="4" ><input class="form-control" type="text" name="notisTitle"></td>
							</tr>
							<tr>
							<td>　</td>
							</tr>
							<tr >
								<td colspan="4"><textarea id="notisCntnt" rows="30" cols="100" style="margin-left: 110px; margin-bottom: 20px;"
								class="form-control"name="notisCntnt"></textarea></td>
							</tr>
							<tr>
								<td rowspan="2">첨부파일</td>
								<td colspan="3"><input type="file" name="boFiles" class="form-control"/>

							</tr>
						</table>
						<div class="row col-3 g-3 m-3 ms-5">
							<div class="col-md-6">
							<button type="submit" class="btn btn-success">등록</button>
							</div>
							<div class="col-md-6">
							<input type="button" onclick="history.go(-1);"
								class="btn btn-danger" value="취소">
							</div>
						</div>
					</form>
				</div>
			</section>



<!-- Bootstrap core JS-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script
	src="<%=request.getContextPath()%>/resources/ViewPosting/js/scripts.js"></script>

