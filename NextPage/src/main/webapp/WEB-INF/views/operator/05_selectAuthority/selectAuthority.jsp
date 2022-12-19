<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content container-fluid">
<h3>권한관리</h3>
<div id="searchUI" class="row g-3 justify-content-center m-3" >
	<div class="col-3 ">
		<select name="searchType" class="form-select row justify-content-left">
			<option value="">전체</option>
			<option value="ADMIN" >운영자</option>
			<option value="MEMBER">회원</option>

		</select>
	</div>
	<div class="col-auto" >
		<input type="text" name="searchWord" placeholder="이름을 입력하세요" class="form-control" value=""/>
	</div>
	<div class="col-auto " >
		<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
	</div>
</div>
<table class="table table-bordered table-strip bg-white">
	<thead class="table-dark">
		<tr class="text-center">
				<th>아이디</th>
				<th>이름</th>
				<th>권한</th>

			</tr>
	</thead>
	<tbody id="listBody">
	<c:set var="memAuth" value="${pagingVO.dataList }" />
				<c:choose>
				<c:when test="${not empty memAuth }">
					<c:forEach items="${memAuth }" var="mem">
						<tr>
							<td>${mem['npMemId'] }</td>
							<c:if test="${mem.schNm eq null}">
								<td>${mem['adminNm'] }</td>
							</c:if>
							<c:if test="${mem.adminNm eq null}">
								<td>${mem['schNm'] }</td>
							</c:if>
							<c:choose>
								<c:when  test ="${mem.memAuth eq 'ADMIN' }">
								<td class="table-warning">${mem.memAuth}</td>
								</c:when>
							<c:otherwise>
								<td>${mem.memAuth}</td>
							</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">결과가 없음.</td>
						</tr>
					</c:otherwise>
				</c:choose>
		</tbody>
</table>
<div class="pagingArea">${pagingVO.pagingHTML }</div>

</div>
<form id="searchForm">
	<input type="hidden" name="page" />
	<input type="hidden" name="searchType" />
	<input type="hidden" name="searchWord" />
</form>


<script type="text/javascript">
	let searchUI = $("#searchUI").on("click", "#searchBtn", function(event) {
		let inputTags = searchUI.find(":input[name]");
		$.each(inputTags, function(index, inputTag) {
			let name = $(this).attr("name");
			let value = $(this).val();
			searchForm.get(0)[name].value = value;
		});
		searchForm.submit();
	});
	let searchForm = $("#searchForm");
	let pageTag = $("[name=page]");
	$("[name=searchType]").val("${simpleCondition.searchType}");
	$("[name=searchWord]").val("${simpleCondition.searchWord}");
	$(".pagingArea").on("click", "a", function(event){
		event.preventDefault();
		let page = $(this).data("page");
		if(!page) return false;
		pageTag.val(page);
		searchForm.submit();
		return false;
	});


</script>
