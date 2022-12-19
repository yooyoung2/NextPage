<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
</head>
<div class="content">
			<h3>내 문의 목록</h3>
<div id="searchUI" class="row g-3 justify-content-center" style="margin-left: 50%;">
	<div class="col-auto" >
		<input type="text" name="searchWord" class="form-control" value="" placeholder="🔎제목검색"/>
	</div>
	<div class="col-auto">
		<input type="button" value="검색" id="searchBtn" class="btn btn-primary" />
	</div>
	</br>
</div>
	<div style="float:right;margin-top: -4%;">
		<a class="btn btn-success" href="<c:url value='/school/manager/my/question/newPostInsert'/>">새글쓰기</a>
	</div>
	<br></br>
<c:set var="otoList" value="${pagingVO.dataList}" />
			<table id="historyTable" class="table text-start align-middle table-bordered table-hover mb-0">
				<thead>
					<tr>
						<th width='2%'>NO.</th>
						<th width="20%">제목</th>
						<th>작성자</th>
						<th>처리여부</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody id="listBody">
				</tbody>
			</table>
			<br>
			<div class="pagingArea"></div>
		</div>
<form id="searchForm">
	<input type="hidden" name="page" />
	<input type="hidden" name="searchWord" />
</form>
<form name="updateForm" method="GET"  action="<c:url value='/school/manager/my/question/selectDetailAsk'/>">
	<input type="hidden" name="otoBrdNum" value=""/>
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
	let makeTrTag = function(myQuestion,index){
		let tr = $("<tr>");

		tr.append(
				$("<td>").html(myQuestion.otoBrdNum)
			,$("<td>").html(
			 $("<a  href='#' class='update' data-otoBrdNum='"+myQuestion.otoBrdNum+"'>").html(myQuestion.otoBrdTitle)
			 )			
			, $("<td width='10%'>").html(myQuestion.schId)
			, $("<td width='10%'>").html(myQuestion.prgrsCndtn)
			, $("<td width='10%'>").html(myQuestion.wrteDate)
			, $("</a>")
			
			
		);
		
		return tr;
	}
	
	let searchForm = $("#searchForm").on("submit", function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize();
		console.log(url);
		console.log(method);
		console.log(data);
		$.ajax({
			url : url,
			method : method,
			data : data,
			dataType : "json",
			success : function(pagingVO) {
				listBody.empty();
				pagingArea.empty();
				pageTag.val("");
				let otoList = pagingVO.dataList;
				let trTags = [];
				if(otoList.length > 0){
					$.each(otoList, function(index, myQuestion){
						let tr = makeTrTag(myQuestion,index);
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
	$(document).on("click",".update", function(event){
		event.preventDefault();
		$(this).attr('data-otoBrdNum');
		$(document.updateForm.otoBrdNum).val($(this).attr('data-otoBrdNum'));
		$(document.updateForm).submit(); 
		return false;
});
	</script>
