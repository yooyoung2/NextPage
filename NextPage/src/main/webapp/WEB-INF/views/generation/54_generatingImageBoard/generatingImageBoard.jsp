<%@page import="kr.or.ddit.vo.Image64"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#searchBtn{
margin-left: -25px;
}
li{
font-size:16px;
}
#wrtBtn{
margin-left:25px;
}
</style>

<!-- 1,2 템플릿용 -->
<div class="site-section">
<c:if test="${genBoardOption.notisWhthr eq 'YES'}">
	<div class="inform_bg mb20" style="padding: 12px 45px; font-size: 12px; background-color: lightgray; border-radius: 15px; margin: 10px 132px;">
<!-- 		<img src="/resources/image/notice.gif" alt="머리글" > -->
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
</div>
<br>

	<div class="container" style="margin-top: -10%;">
		<div id="searchUI" class="row g-3 justify-content-center"
			style="margin-left:65%;  ">
			<div class="col-auto">
				<input type="text" name="searchWord" class="form-control" value="" placeholder="🔎제목검색" />
			</div>
			<div class="col-auto">
				<input type="button" value="검색" id="searchBtn" class="btn btn-primary" />
			</div>
		</div>
		<br>
		<div class="justify-content-center" style="padding: -1px 120px;">
			<c:set var="genPost" value="${pagingVO.dataList }" />
		<div class="row" id="listBody">
		</div>
			<!-- 글쓰기 권한 처리  -->
			<div style="margin-left: 90%;">
			<c:choose>
				<c:when test="${not empty authCnctList}">
					<c:forEach items="${authCnctList}" var="authCnct">
 						<c:if test="${authCnct.authMemId eq sessionScope.authVal}">
  						<c:if test="${authCnct.authType eq 'WRTE'}">
								<p>
								<button id="wrtBtn" class='btn btn-info' onclick="location.href='<%=request.getContextPath()%>/generation/${genBoardOption.schId}/board/add?brdNum=${genBoardOption.brdNum}'">글쓰기</button></p>
							</c:if> 
						</c:if>
					</c:forEach>
				</c:when>
			</c:choose>
			</div>
 		<div class="pagingArea"></div>
		
		<form id="searchForm">
			<input type="hidden" name="page" />
			<input type="hidden" name="searchWord" />
		</form>
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
	
	const brdNum = ${genBoardOption.brdNum};
	
	const schIdqqq = "${genBoardOption.schId}";
	
	const boardView ="${genBoardOption.pagePostNum}"
	
	console.log(boardView);
	<%
	List<Image64> ImageList=(List<Image64>)session.getAttribute("ImageList");
	System.out.println("여기야");
	
	System.out.println(ImageList);
	%>
	let makeTrTag = function(genPost, index) {
	let outerDiv;
	let innerDiv;
	let inner2Div;
	if(boardView=="3X3"){
		outerDiv = $("<div class='col-lg-4 col-md-6 mb-5 mb-lg-5'>");
		innerDiv = $("<div class='feature-1 border text-center'>");
		inner2Div = $("<div class='feature-1-content'>");
	}else{
		outerDiv = $("<div class='col-lg-3 col-md-6 mb-5 mb-lg-5'>");
		innerDiv = $("<div class='feature-1 border text-center' style='height:485px;'>");
		inner2Div = $("<div class='feature-1-content'>");
	}

	
	let aTag = $("<a>").attr("href", "${pageContext.request.contextPath}/generation/"+schIdqqq+"/board/detail?brdNum="+brdNum+"&what="+genPost.postNum);
	
	
		let img = $("<img>").attr("src", "data:image/*;base64,"+genPost.realName)  //건호야여기
		.attr("class","img-fluid")
		.attr("style","width:300px; height:270px;");
	
	
						
	
	
	
	let h2Tag = $("<h2>").html(genPost.postTitle);
	let spanTag = $("<span class='position mb-3 d-block'>").html(genPost.memNm)
	
	//모양 합치기
	inner2Div.append(h2Tag);
	inner2Div.append(spanTag);
	
	aTag.append(img);
	
	innerDiv.append(aTag);
	innerDiv.append(inner2Div);
	
	outerDiv.append(innerDiv);
	
	$("#listBody").append(outerDiv);
	
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
						let tr = $("<div class='col-lg-4 col-md-6 mb-5 mb-lg-5'>").html(
								$("<div class='feature-1 border text-center'>").html(
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

