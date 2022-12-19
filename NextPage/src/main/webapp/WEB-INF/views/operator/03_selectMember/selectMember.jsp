<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content container-fluid">
<h3>회원관리</h3>
<div id="searchUI" class="row g-3 justify-content-center m-3" >
	<div class="col-3 ">
		<select name="searchType" class="form-select row justify-content-left">
			<option value="">전체</option>
			<option value="초" >초등학교</option>
			<option value="중">중학교</option>
			<option value="고">고등학교</option>

		</select>
	</div>
	<div class="col-auto" >
		<input type="text" name="searchWord" placeholder="학교 이름을 입력하세요" class="form-control" value=""/>
	</div>
	<div class="col-auto " >
		<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
	</div>
</div>
<table class="table table-bordered table-strip bg-white">
	<thead class="table-dark">
		<tr class="text-center">
				<th>아이디</th>
				<th>학교명</th>
				<th>지역</th>
				<th>최초구매일</th>
				<th>이용상태</th>
			</tr>
	</thead>
	<tbody id="listBody">
	<c:set var="schools" value="${pagingVO.dataList }" />
				<c:choose>
				<c:when test="${not empty schools }">
					<c:forEach items="${schools }" var="sch">
						<tr>
							<td>${sch['schId'] }</td>
							<td><a href="<%=request.getContextPath()%>/operator/select/detail/member?id=${sch['schId']}">${sch['schNm'] }</a></td>
							<td>${sch['schAddr1'] } ${sch['schAddr2'] }</td>
							<td>${sch['fstPchDate'] }</td>
							<td>${sch['srvcWhthr'] }</td>
						</tr>
					</c:forEach>
				</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">회원이 없음.</td>
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
