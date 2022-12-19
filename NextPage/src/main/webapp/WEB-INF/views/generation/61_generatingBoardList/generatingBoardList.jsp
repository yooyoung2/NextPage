<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> -->


<style>
#searchBtn{
	margin-left: -25px;
}

li{
	font-size:16px;
}

.table{
	font-size:15px;
	text-align:center;
}

#noTh{
	width : 10%;
}

#noticeTh{
	width : 8%;
}

#titleTh{
	width : 40%;
}

#writerTh{
	width : 10%;
}

#dateTh{
	width : 20%;
}
#listBody > tr:nth-child(n) > td:nth-child(3){
	text-align : left;
}

</style>

<div class="site-section">
<c:if test="${genBoardOption.notisWhthr eq 'YES'}">
	<div class="inform_bg mb20" style=" width: 100%; height: 130px; padding: 12px 45px; font-size: unset; background-color: lightgray;
    			border-radius: 15px; margin-top: 20px; font-size: 13px;">
		<ul style="color: black;">
			<li>본 사이트는 대한민국 저작권법 및 개인정보보호법을 준수합니다.</li>
			<li>본문 또는 첨부파일에
				<span>타인의 지식재산권 및 기타 권리를 침해하는 내용물은 등록할 수 없습니다</span>. 또한
				<span>개인정보(주민등록번호, 성명, 연락처 등)가 포함된 내용이 게시되지 않도록 주의</span>하시기 바랍니다. 이러한
				<span>게시물로 인한 모든 책임은 작성자 본인</span>에게 있고,
				<span>개인정보가 게시되어 노출된 경우에는 작성자가 개인정보 보호법에 따라 처벌 받을 수 있음</span>
				을 알려드립니다.
			</li>
		</ul>
	</div>
</c:if>
<br>
	<div class="container">
		<div id="searchUI" class="row g-3 justify-content-center" style="margin-left:65%; ">
			<div class="col-auto">
				<input type="text" name="searchWord" class="form-control" value="" placeholder="🔎제목검색" />
			</div>
			<div class="col-auto">
				<input type="button" value="검색" id="searchBtn" class="btn btn-primary" />
			</div>
		</div>
		<br>
		<div class="row justify-content-center">
			<c:set var="genPost" value="${pagingVO.dataList }" />
			<table class="table .table-hover">
				<thead>
					<tr class="table-light">
						<th id="noTh" scope="col">NO.</th>
						<th id="noticeTh" scope="col"></th>
						<th id="titleTh" scope="col">제목</th>
						<th id="writerTh" scope="col">작성자</th>
						<th id="dateTh" scope="col">작성일자</th>
					</tr>
				</thead>
				<tbody id="listBody">
				</tbody>
			</table>
			</div>
			<!-- 글쓰기 권한 처리  -->
			<div style="margin-left: 90%;">
			<c:choose>
				<c:when test="${not empty authCnctList}">
					<c:forEach items="${authCnctList}" var="authCnct">
 						<c:if test="${authCnct.authMemId eq sessionScope.authVal}">
  						<c:if test="${authCnct.authType eq 'WRTE'}">
								<p>
								<button class='btn btn-info' onclick="location.href='<%=request.getContextPath()%>/generation/${genBoardOption.schId}/board/add?brdNum=${genBoardOption.brdNum}'">글쓰기</button></p>
							</c:if>
						</c:if>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h1>글쓰기 권한이 없습니다!</h1>
				</c:otherwise>
			</c:choose>
			</div>
			<div class="pagingArea"></div>

		<form id="searchForm">
			<input type="hidden" name="page" />
			<input type="hidden" name="searchWord" />
		</form>
		<%-- 			<div class="row" style="float: right;">
				<a type="button" class="btn btn-success"
					href="<%=request.getContextPath()%>/generation/generatingWrite">글쓰기</a>
			</div> --%>
	</div>
</div>

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

	const anmtWhthr = ${genBoardOption.anmtWhthr eq 'YES'}; //익명처리

	const brdNum = ${genBoardOption.brdNum};

 	const schIdqqq = "${genBoardOption.schId}";

	let makeTrTag = function(genPost, index) {

		let tr = $("<tr>");
		let aTag = $("<a>").attr("href", "${pageContext.request.contextPath}/generation/"+schIdqqq+"/board/detail?brdNum="+brdNum+"&what="+genPost.postNum)
		.text(genPost.postTitle);

		if(genPost.postNotisWhether =='YES'){
			tr.append(
					$("<td width='10%'>").html(genPost.postNum),
					$("<td width='10%'>").html($("<button class='btn btn-danger'>").html('공지')),
					$("<td width='20%'>").html(aTag),
					$("<td width='20%'>").html(anmtWhthr?"***": genPost.postScrtWhether=='YES'? "***" :genPost.memNm),
					$("<td width='20%'>").html(genPost.postWriteDate));
		}else if(genPost.postPrgrsPrsntCndtn =='대기'){
			tr.append(
				$("<td width='10%'>").html(genPost.postNum),
				$("<td width='10%'>").html($("<button class='btn btn-primary'>").html('대기')),
				$("<td width='20%'>").html(aTag.html(genPost.postScrtWhether=='YES'? "*비밀글입니다*" : genPost.postTitle)),
				$("<td width='20%'>").html(anmtWhthr?"***": genPost.postScrtWhether=='YES'? "***" :genPost.memNm),
				$("<td width='20%'>").html(genPost.postWriteDate));
		}else if(genPost.postPrgrsPrsntCndtn =='접수'){
			tr.append(
				$("<td width='10%'>").html(genPost.postNum),
				$("<td width='10%'>").html($("<button class='btn btn-info'>").html('접수')),
				$("<td width='20%'>").html(aTag.html(genPost.postScrtWhether=='YES'? "*비밀글입니다*" : genPost.postTitle)),
				$("<td width='20%'>").html(anmtWhthr?"***": genPost.postScrtWhether=='YES'? "***" :genPost.memNm),
				$("<td width='20%'>").html(genPost.postWriteDate));
		}else if(genPost.postPrgrsPrsntCndtn =='완료'){
			console.log()
			tr.append(
				$("<td width='10%'>").html(genPost.postNum),
				$("<td width='10%'>").html($("<button class='btn btn-secondary'>").html('완료')),
				$("<td width='20%'>").html(aTag.html(genPost.postScrtWhether=='YES'? "*비밀글입니다*" : genPost.postTitle)),
				$("<td width='20%'>").html(anmtWhthr?"***": genPost.postScrtWhether=='YES'? "***" :genPost.memNm),
				$("<td width='20%'>").html(genPost.postWriteDate));
		}else{
			tr.append(
					$("<td width='10%'>").html(genPost.postNum),
					$("<td width='10%'>").html($("<td>").html()),
					$("<td width='20%'>").html(aTag.html(genPost.postScrtWhether=='YES'? "*비밀글입니다*" : genPost.postTitle)),
					$("<td width='20%'>").html(anmtWhthr?"***": genPost.postScrtWhether=='YES'? "***" :genPost.memNm),
					$("<td width='20%'>").html(genPost.postWriteDate));
		}


		return tr;
	}

	let searchForm = $("#searchForm").on(
			"submit",
			function(event) {
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
						let genPostList = pagingVO.dataList;
						let trTags = [];
						if (genPostList.length > 0) {
							$.each(genPostList, function(index, genPost) {
								let tr = makeTrTag(genPost, index);
								trTags.push(tr);
							});
						} else {
							let tr = $("<tr>").html(
									$("<td>").attr("colspan", "6").html(
											"조건에 맞는 게시글이 없음."));
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


</script>