<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section">공지사항</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12" style="width:90%;margin-left: 5%;">
				<div class="table-wrap">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>작성일</th>
								<th>작성자</th>
							</tr>
						</thead>
						<c:set var="notiList" value="${pagingVO.dataList }"></c:set>
						<tbody id="listBody">
							<c:choose>
								<c:when test="${not empty notiList }">
									<c:forEach items="${notiList}" var="noti">
										<tr>
											<td>${noti['notisNum'] }</td>
											<td><a href="<%=request.getContextPath() %>/nextpage/PostingView.do?who=${noti['notisNum'] }">${noti.notisTitle}</a></td>
											<td>${noti.notisWrteDate}</td>
											<td>${noti.adminId}</td>
<%-- 										<td hidden="">${noti.memAuth}</td> --%>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="5">공지사항 없음</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="7">
									<div class="pagingArea mb-3">${pagingVO.pagingHTML }</div>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
			<div>
			<!-- 권한처리 : 관리자만 글쓰기하게... -->
				<c:if test="${sessionScope.nextAuth eq 'ADMIN'}">
					<div class="h-100 d-lg-inline-flex align-items-center d-none">
				<a class="btn btn-primary "
					href="<%=request.getContextPath()%>/nextpage/PostingInsert.do">
					글쓰기</a>
					</div>
				</c:if>

			</div>
		</div>
	</div>
</section>
<form id="searchForm">
	<input type="hidden" name="page" />
</form>


<script type="text/javascript" src='${pageContext.request.contextPath }/resources/js/nextpage/noticeBoard.js'></script>
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