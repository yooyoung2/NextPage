<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content container-fluid">
<h3>로그관리</h3>
<div id="searchUI" class="row g-3 justify-content-center m-3" >
	<div class="col-3 ">
		<select name="searchType" class="form-select row justify-content-left">
			<option selected="selected" value="">전체</option>
			<option value="1" >로그인</option>
			<option value="2">로그아웃</option>
			<option value="3">등록</option>
			<option value="4">수정</option>
			<option value="5">삭제</option>
			<option value="6">결제</option>
			<option value="7">결제취소</option>
			<option value="8">탈퇴</option>
		</select>
	</div>
	<div class="col-auto">
		<div class="form-control col-auto">
			<input type="date" name="searchStartDate" value="">  ~  <input type="date" name="searchEndDate" value="">
		</div>

	</div>
	<div class="col-auto" >
		<input type="text" name="searchWord" placeholder="학교 아이디를 입력하세요" class="form-control" value=""/>
	</div>
	<div class="col-auto " >
		<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
	</div>
</div>
<table class="table table-bordered table-strip bg-white">
	<thead class="table-dark">
		<tr>
 			<th>로그아이디</th>
			<th>로그발생아이디</th>
			<th>로그발생학교이름</th>
			<th>로그발생시간</th>
			<th>로그내용</th>
	</thead>
	<tbody id="listBody">
	<c:set var="logList" value="${pagingVO.dataList }" />
				<c:choose>
					<c:when test="${not empty logList }">
						<c:forEach items="${logList }" var="log">

							<tr>
								<td>${log['logId'] }</td>
								<td>${log['logHpnId'] }</td>
								<td>${log['schNm'] }</td>
								<td>${log['logHpnTime'] }</td>
								<td>${log['logCntnt'] }</td>
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">로그가 없음.</td>
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
	<input type="hidden" name="searchStartDate" />
	<input type="hidden" name="searchEndDate" />
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
	$("[name=searchStartDate]").val("${simpleCondition.searchStartDate}");
	$("[name=searchEndDate]").val("${simpleCondition.searchEndDate}");
	$(".pagingArea").on("click", "a", function(event){
		event.preventDefault();
		let page = $(this).data("page");
		if(!page) return false;
		pageTag.val(page);
		searchForm.submit();
		return false;
	});


</script>
