<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="robots" content="noindex, nofollow">
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>

<!-- Page content-->
<section class="ftco-section" style="padding: 0px 100px;">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section">공지사항</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="table-wrap">
					<form id="updateForm" action = "<%=request.getContextPath()%>/nextpage/PostingUpdate.do" method="post" enctype="multipart/form-data">
						<table class="table table table-hover">
							<tr ><input hidden name="notisNum" value="${noti.notisNum}"></tr>
							<tr><input hidden value="${noti.notisWrteDate}"></tr>
							<tr>
								<th class="col-1">제목</th>
								<td>
									<!-- 수정가능 영역 -->
									 <input id="notisTitle" class="form-control" name="notisTitle"
									required readonly value="${noti.notisTitle }" />
								</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td><input id="adminId" class="form-control" name="adminId"
									value="${noti.adminId }" readonly /></td>
							</tr>
							<tr>
								<!-- 수정가능 영역 -->
								<td colspan="2"><textarea id="notisCntnt" rows="30" name="notisCntnt"
										cols="100" class="form-control " required readonly style="height: 260px;">${noti.notisCntnt }</textarea>
								</td>
							</tr>
							
							<tr>
								<th><br>첨부파일<br>
								</th>
								<th><br><a href="<%=request.getContextPath() %>/notice/board/download?what=${noti.notisNum}" style="color:blue;">${noti.fileName}</a><input type="hidden" id="boFiles" name="boFiles"><br></th>
								
							</tr>

							<!-- 권한처리 : 관리자만 글수정,삭제하게... -->
						</table>
						<c:if test="${sessionScope.nextAuth eq 'ADMIN'}">
							<div class="row col-3 g-3">
								<div class="col-md-6">
									<input id="modi" type="button" class="btn btn-success"
										value="수정">
								</div>
								<div class="col-md-6">
									<c:url value="postingDelete" var="notiViewURL">
										<c:param name="who" value="${noti.notisNum }" />
									</c:url>
									<a href="${notiViewURL }"><button type="button"
											class="btn btn-danger">삭제</button></a>
								</div>
							</div>
						</c:if>
					</form>
						<div class="col-sm-12 d-flex justify-content-end">
						 	<input type="button" onclick="history.go(-1);" class="btn btn-secondary me-1 mb-1" value="뒤로">
						</div>
				</div>
			</div>
		</div>
	</div>
</section>

<form id="searchForm">
	<input type="hidden" name="page" />
</form>


<script>

	let modiButton =  document.getElementById( "modi" );

	modiButton.onclick = function(){ // 수정 버튼이 눌렸을 때

		let notisTitle = document.getElementById( "notisTitle" );
		let notisCntnt = document.getElementById( "notisCntnt" );
		let boFiles=document.getElementById("boFiles");

		if( modiButton.value == "수정" ){

			// 수정을 시작할 때
			notisTitle.removeAttribute( "readonly" );
			notisCntnt.removeAttribute( "readonly" );
			boFiles.type="file";

			modiButton.value = "등록"

		}else if( modiButton.value == "등록" ){

			// 수정을 끝나고 제출할 떄

			let updateForm = document.getElementById( "updateForm" );

			updateForm.submit();
			modiButton.value = "수정";
		}

	}
</script>
