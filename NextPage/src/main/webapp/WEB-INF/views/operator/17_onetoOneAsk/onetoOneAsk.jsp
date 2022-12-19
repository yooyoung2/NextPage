<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="content">
	<h3>문의현황</h3>
	<br>
	<div class="table-responsive ">
		<table class="table table-bordered table-strip bg-white">
			<thead class="table-dark">
				<tr class="text-white">
					<th scope="col">글번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">날짜</th>
					<th scope="col">처리여부</th>
				</tr>
			</thead>
			<c:set var="otoList" value="${pagingVO.dataList }"></c:set>
			<tbody id="listBody">
				<c:choose>
					<c:when test="${not empty otoList }">
						<c:forEach items="${otoList}" var="otoList">
							<tr>
								<td>${otoList.otoBrdNum}</td>
								<td><a href="${pageContext.request.contextPath }/operator/onetoOneAskDetail?oto=${otoList.otoBrdNum }">${otoList.otoBrdTitle}</a></td>
								<td>${otoList.schId}</td>
								<td>${otoList.wrteDate}</td>
								<td>${otoList.prgrsCndtn}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">문의 없음</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
		<div class="pagingArea mb-3">${pagingVO.pagingHTML }</div>
	</div>
<form id="searchForm">
	<input type="hidden" name="page" />
</form>
</section>


</div>
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
