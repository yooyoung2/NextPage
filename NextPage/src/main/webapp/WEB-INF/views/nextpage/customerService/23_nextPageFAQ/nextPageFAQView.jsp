<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<section class="ftco-section" style="padding: 0px 100px;">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section">FAQ</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="table-wrap">
					<form:form id="updateForm" modelAttribute="faq" enctype="multipart/form-data" action = "${pageContext.request.contextPath }/nextpage/FaqUpdate" method="post">
						<table class="table table-hover">
							<tr>
								<td hidden>
									<form:input type="hidden" path="faqId" class="form-control" required="true" value="${faq.faqId }" />
									<form:errors path="faqId" element="span" cssClass="error" />
								</td>
							</tr>
							<tr>
								<td hidden>
									<form:input type="hidden"  path="adminId" name="adminId" class="form-control editable" required="true" value="${faq.adminId}" />
									<form:errors path="adminId" element="span" cssClass="error" />
								</td>
							</tr>
							
							<!-- 수정가능 영역 -->
							
							
							<tr class="col-1">
								<th rowspan="3"></th>
								<td>
									<form:input path="faqTitle" class="form-control" required="true" value="${faq.faqTitle}" readonly="true"/>
									<form:errors path="faqTitle" element="span" cssClass="error" />
								</td>
							</tr>
							<!-- 수정가능 영역 -->
							
							
							<tr>
								<td>
									<textarea id="faqCntnt" rows="30" cols="100" class="form-control"name="faqCntnt" readonly="true" style="height: 260px;">${faq.faqCntnt}</textarea>
								</td>
							</tr>
							
							<tr>
								<td>첨부파일
									<a href="<%=request.getContextPath() %>/nextpage/faq/download?what=${faq.faqId}" style="color:blue;">${faq.fileName}</a>
									<form:input type="hidden" path="boFiles" id="boFiles" name="boFiles" class="form-control"/>
								</td>
							</tr>
							
						
							
							
							<!-- 권한처리 : 관리자만 글수정,삭제하게... -->
							<c:if test="${sessionScope.nextAuth eq 'ADMIN'}">
								<tr>
									<td colspan="2">
										<input id="modi" type="button" class="btn btn-success" value="수정">
										<c:url value="faqDelete" var="faqViewURL">
											<c:param name="what" value="${faq.faqId}" />
										</c:url>
										<a href="${faqViewURL }"><button type="button" class="btn btn-danger">삭제</button></a>
									</td>
								</tr>
							</c:if>
						</table>
					</form:form>
					<div class="col-sm-12 d-flex justify-content-end">
						 <input type="button" onclick="history.go(-1);" class="btn btn-secondary me-1 mb-1" value="뒤로">
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

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

<script>

	let modiButton =  document.getElementById( "modi" );

	modiButton.onclick = function(){ // 수정 버튼이 눌렸을 때

		let faqTitle = document.getElementById( "faqTitle" );
		let faqCntnt = document.getElementById( "faqCntnt" );

		if( modiButton.value == "수정" ){

			// 수정을 시작할 때
			faqTitle.removeAttribute( "readonly" );
			faqCntnt.removeAttribute( "readonly" );
			boFiles.type="file";


			modiButton.value = "등록"

		}else if( modiButton.value == "등록" ){

			// 수정을 끝나고 제출할 떄

			let updateForm = document.getElementById( "updateForm" );

			updateForm.submit();
			modiButton.value = "수정";
		}

	}
</script>