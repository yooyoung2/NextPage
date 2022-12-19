<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<div class="content ">
<h2 style="margin-top: 1%;">게시판 목록</h2>
<div id="searchUI" class="row g-3 justify-content-center" style="margin-bottom: -5%;">
	<div class="col-auto">
		<select name="searchType" class="form-select">
			<option value="">전체</option>
			<option value="1" >일반게시판</option>
			<option value="2">이미지게시판</option>
			<option value="3">동영상게시판</option>
		</select>
	</div>
	<div class="col-auto" >
		<input type="text" name="searchWord" placeholder="검색키워드" class="form-control" value=""/>
	</div>
	<div class="col-auto">
		<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
	</div>
</div>
		<button class="btn btn-primary" style="background-color: #1b75c3;border-color: #1b75c3;margin-top: 1%;margin-bottom: 1%;float: right;" onclick="location.href='/NextPage/school/manager/board/add'">게시판 추가</button>
<c:set var="genBoardList" value="${pagingVO.dataList }" />
<table class="table table-bordered table-strip">
	<thead class="table-dark">
		<tr>
			<!-- <th><input type="checkbox" name="selectedAll"/></th> -->
			<th>홈페이지</th>
 			<th>게시판 아이디</th>
			<th>게시판명</th>
			<th>메뉴 경로</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody id="listBody">
	</tbody>
</table>
<div class="pagingArea"></div>

</div>
<form id="searchForm">
	<input type="hidden" name="page" />
	<input type="hidden" name="searchType" />
	<input type="hidden" name="searchWord" />
</form>

<form name="deleteForm" method="POST" action="/NextPage/school/manager/board/delete">
	<input type="hidden" name="brdNum" value=""/>
</form>
<form name="updateForm" method="GET"  action="/NextPage/school/manager/board/datail">
	<input type="hidden" name="brdNum" value=""/>
</form>

<script type="text/javascript">

	let searchUI = $("#searchUI").on("click", "#searchBtn", function(event){
		let inputTags = searchUI.find(":input[name]");
		$.each(inputTags, function(index, inputTag){
			let name = $(this).attr("name");
			let value = $(this).val();
			searchForm.get(0)[name].value = value;
		});
		searchForm.submit();
	});
	let pageTag = $("[name=page]");
	let listBody = $("#listBody");
	let pagingArea = $(".pagingArea").on("click", "a", function(event){
		event.preventDefault();
		let page = $(this).data("page");
		if(!page) return false;
		pageTag.val(page);
		searchForm.submit();
		return false;
	});

	let makeTrTag = function(genBoard,index){
		let tr = $("<tr>");

		tr.append(
			  /* $("<td width='2%'><input type=checkbox name='selected' value=ROW_"+index+">") */
			$("<td width='10%'>").html(genBoard.schNm)
			, $("<td width='20%'>").html(genBoard.brdNum)
			, $("<td width='20%'>").html(genBoard.brdTitle)
			,$("<td width='20%'>")
			,$("<td width='20%'><a href='#' data-brdnum='"+genBoard.brdNum+"'class='btn btn-success updateBtn'>수정</a><a href='#' data-brdnum='"+genBoard.brdNum+"'class='btn btn-danger deleteBtn ms-2'>삭제</a>")
		);

		return tr;
	}

	let searchForm = $("#searchForm").on("submit", function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize();
		$.ajax({
			url : url,
			method : method,
			data : data,
			dataType : "json",
			success : function(pagingVO) {
				listBody.empty();
				pagingArea.empty();
				pageTag.val("");
				let genBoardList = pagingVO.dataList;
				let trTags = [];
				if(genBoardList.length > 0){
					$.each(genBoardList, function(index, genBoard){
						let tr = makeTrTag(genBoard,index);
						trTags.push(tr);
					});
				}else{
					let tr = $("<tr>").html(
						$("<td>").attr("colspan", "6")
								 .html("조건에 맞는 게시글이 없음.")
					);
					trTags.push(tr);
				}
				listBody.append(trTags);
				let pagingHTML = pagingVO.pagingHTML;
				pagingArea.html(pagingHTML);
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});
		return false;
	}).submit();
	$('input[name=selectedAll]').on('change', function(){
		  $('input[name=selected]').prop('checked', this.checked);
		});
	var arr = $('input[name=selected]:checked').serializeArray().map(function(item) { return item.value });
	console.log(arr);

	$(document).on("click",".deleteBtn", function(event){
		if(confirm("삭제하시겠습니까?")){
			event.preventDefault();
			$(this).attr('data-brdnum');
			$(document.deleteForm.brdNum).val($(this).attr('data-brdnum'));
			$(document.deleteForm).submit();
		}else{
            return false;
        }
	});

	$(document).on("click",".updateBtn", function(event){
			event.preventDefault();
			$(this).attr('data-brdnum');
			$(document.updateForm.brdNum).val($(this).attr('data-brdnum'));
			$(document.updateForm).submit();
	});
</script>