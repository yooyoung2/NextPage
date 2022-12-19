<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<div class="content container-fluid">
<h2 style="margin-top: 1%;">게시물 목록</h2>
<div id="searchUI" class="row g-3 justify-content-center m-3" >
	<div class="col-3 ">
		<select name="searchType" class="form-select row justify-content-left">
			<option selected="selected" value="">전체</option>
			<option value="1" >일반게시판</option>
			<option value="2">이미지게시판</option>
			<option value="3">동영상게시판</option>
		</select>
	</div>
	<div class="col-auto">
		<div class="form-control col-auto">
			<input type="date" name="searchStartDate" value="">  ~  <input type="date" name="searchEndDate" value="">
		</div>

	</div>
	<div class="col-auto" >
		<input type="text" name="searchWord" placeholder="제목을입력하세요" class="form-control" value=""/>
	</div>
	<div class="col-auto " >
		<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
	</div>
</div>
<table class="table table-bordered table-strip">
	<thead class="table-dark">
		<tr>
 			<th>게시판 아이디</th>
			<th>게시물 번호</th>
			<th>게시판 타입</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody id="listBody">
	<c:set var="genPostList" value="${pagingVO.dataList }" />
				<c:choose>
					<c:when test="${not empty genPostList }">
						<c:forEach items="${genPostList }" var="genPost">
			<c:if test="${sessionScope.authSch eq genPost.schId}">
							<tr>
								<td>${genPost.brdNum}</td>
								<td id="postNum" data-postNum="${genPost.postNum}">${genPost.postNum}</td>
								<td>${genPost.typeNm }</td>
								<td style="width: 290px;">${genPost.postTitle}</td>
								<td>${genPost.memNm }</td>
								<td>${genPost.postWriteDate }</td>
<%-- 								<td>${genPost.schId }</td> --%>
								<td><button type="button" class="btn btn-danger" id="deleteBtn${genPost.postNum}">삭제</button></td>
							</tr>
			</c:if>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">게시물이 없음.</td>
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

<form name="deleteForm" method="GET" action="${pageContext.request.contextPath}/schoolManager/postManage/deletePost">
	<input type="hidden" name="postNum" value=""/>
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


	function deleteForm(){
		$(document.deleteForm).submit();
	}
	//삭제
	$("button[id^='deleteBtn']").on('click',function(event){
			console.log("들어옴????");

					event.preventDefault();
			Swal.fire({
				  title: '삭제하시겠습니까?',
				  showDenyButton: true,
				  confirmButtonText: '네',
				  denyButtonText: `아니요`,
				}).then((result) => {
				  /* Read more about isConfirmed, isDenied below */
				  if (result.isConfirmed) {
					let postNum = $("#postNum").attr('data-postNum');
					$(document.deleteForm.postNum).val(postNum);
					setTimeout(deleteForm, 2000);
					Swal.fire('삭제가 완료되었습니다!', '', 'success')
				  } else if (result.isDenied) {
		            return false;
				    Swal.fire('삭제실패, 잠시 후에 다시 시도해주세요!', '', 'info')
				  }
				})

	});
</script>

