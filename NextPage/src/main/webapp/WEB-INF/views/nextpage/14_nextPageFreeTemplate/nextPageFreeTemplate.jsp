<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<%-- 	<script	src="<%=request.getContextPath()%>/resources/templatesPreview/js/toucheffects.js"></script> --%>
  
	<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/templatesPreview/css/component.css" />
	
	<script	src="<%=request.getContextPath()%>/resources/templatesPreview/js/modernizr.custom.js"></script>

<style>
h3{
	text-align : center;
}
#allDiv{
margin-top:3%;
}
#selectList{
	float : right;
	margin-right : 5%;
}
#ulList{
	margin-top : 6%;
}
</style>

	<div id="allDiv" class="container demo-1">
		<!-- Top Navigation -->

		<header>
			<h3>무료템플릿 목록</h3>
		</header>
		<select id="selectList" title="" onchange="window.open(value,'_self');">
			<option value="<%=request.getContextPath()%>/nextpage/template/free.do" selected>무료템플릿</option>
			<option value="<%=request.getContextPath()%>/nextpage/template/cost.do">유료템플릿</option>
		</select>

		<ul id="ulList"class="grid cs-style-1">
		<c:set var="templates" value="${pagingvo.dataList }"/>
		<c:choose>
			<c:when test="${not empty templates }">
				<c:forEach items="${templates }" var="costTemp">
					<li style="display: inline-block; width: 362px; margin: -22px; padding: 34px; text-align: left; position: relative;">
						<figure>
							<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/${costTemp.tmpltThmnl}" alt="img01" style="width: 362px; height:300px;">
							<figcaption>
								<h3>${costTemp.tmpltNm }</h3>
								<!-- <span>Jacob Cummings</span> -->
								<a href="#" data-toggle="modal" data-target="#${costTemp.tmpltId}">미리보기</a>
							</figcaption>
						</figure>
					</li>
				</c:forEach>
			</c:when>
		</c:choose>
	</ul>
	<div class="pagingArea mb-3">
		${pagingvo.pagingHTML }
	</div>
</div>
	<c:choose>
			<c:when test="${not empty templates }">
				<c:forEach items="${templates }" var="costTemp">
			<div class="modal fade" id="${costTemp.tmpltId}" data-backdrop="static"	data-keyboard="false">
				<div class="modal-dialog modal-xl modal-dialog-centered">
					<div class="modal-content">
		
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">${costTemp.tmpltNm}</h4>
							<button type="button" class="close btn btn-outline-dark" data-dismiss="modal">&times;</button>
						</div>
		
						<!-- Modal body -->
						<div class="modal-body">
							<img class="card-img-top rounded img-fluid"
								src="<%=request.getContextPath()%>/resources/templatesPreview/images/${costTemp.tmpltThmnl}">
						</div>
		
						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
		
					</div>
				</div>
			</div>
		</c:forEach>
	</c:when>
</c:choose>
<form id="searchForm">
	<input type="hidden" name="page" />
</form>

<script>
let pageTag = $("[name=page]");
let listBody = $("#listBody");
let pagingArea = $(".pagingArea").on("click", "a", function(event) {
	event.preventDefault();
	let page = $(this).data("page");
	if (!page)
		return false;
	pageTag.val(page);
	searchForm.submit();
	return false;
});

</script>