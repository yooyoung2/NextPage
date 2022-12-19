<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section">FAQ</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="table-wrap">
					<form:form modelAttribute="faq" method="post"
						enctype="multipart/form-data">
						<table class="table table-hover">
							<tr>
								<td hidden>
									<form:input type="hidden" path="faqId" class="form-control" required="true" />
									<form:errors path="faqId" element="span" cssClass="error" />
								</td>
							</tr>
							<tr>
								<td hidden>
									<form:input type="hidden"  path="adminId" name="adminId" class="form-control editable" required="true" value="${faq.adminId}" />
									<form:errors path="adminId" element="span" cssClass="error" />
								</td>
							</tr>
							<tr>
								<th>제목</th>
								<td><form:input path="faqTitle" class="form-control" required="true" value="${faq.faqTitle}" />
									<form:errors path="faqTitle" element="span" cssClass="error" />
								</td>
							</tr>

							<tr>
								<th>내용</th>
								<td>
									<textarea id="faqCntnt" rows="30" cols="100" class="form-control"name="faqCntnt"></textarea>
								</td>
							</tr>
							
							<tr>
								<th>첨부파일</th>
								<td>
									<input type="file" id="boFiles" name="boFiles">
								</td>
							</tr>
							
							
							<tr>
								<td colspan="2">
									<input type="submit" value="등록" class="btn btn-primary" />
									<input type="reset" value="취소" class="btn btn-warning" />
								</td>
							</tr>
							
							
						</table>
					</form:form>
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
