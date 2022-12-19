<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	<h1>우리학교 홈페이지 프로젝트 </h1>
	<form >
		<table style="margin-top: 10%;" >
		<tr align="center">
			<c:choose>
				<c:when test="${not empty genSiteList }">
					 <c:forEach items="${genSiteList }" var="genSite">
					 
						<c:if test="${'YES' eq genSite.homeSelect}">
							<input type="button" value="홈페이지 이동하기" onclick="moveHomepage('${sessionScope.authSch }')" class="btn btn-success">
						</c:if>

					 	<c:if test="${not empty genSite.tmpltId}">

								<td width="33%" style="padding: 0px 10px;">
									<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/${genSite.tmpltThmnl}" width="300" height="300"> <br><br>

									<input type="button" value="프로젝트비우기" onclick="clearProject('${genSite.prjctId}')" class="btn btn-danger" style="float: left;"/> <br><br>
						 			<input type="button" value="홈페이지수정하기" onclick="updateProject('${genSite.prjctId}')" class="btn btn-primary" style="float: right;margin-top: -16%;}"/> <br><br>

						 			<c:if test="${'YES' eq genSite.homeSelect}">
						 				<input type="button" value="현재적용중" disabled="disabled" >
						 			</c:if>
						 			<c:if test="${'NO' eq genSite.homeSelect}">
						 				<input type="button" value="홈페이지적용하기" onclick="selectProject('${genSite.prjctId}')" class="btn btn-secondary">
						 			</c:if>

							 	</td>
					 	</c:if>
					 	<c:if test="${empty genSite.tmpltId}">
							 	<td>
							 		<input type="button" value="홈페이지만들기" onclick="makeHomePage('${genSite.prjctId}')" class="btn btn-secondary"/>
							 	</td>
						</c:if>


					 </c:forEach>
				</c:when>
			</c:choose>
			</tr>
		</table>


	</form>
</div>
<script>
	function makeHomePage(prjId){
		Swal.fire({
			  title: '프로젝트를 새로 만드시겠습니까?',
			  showCancelButton: true,
			  cancelButtonText:'아니요',
			  confirmButtonText: '예'
			}).then((result) => {
			  /* Read more about isConfirmed, isDenied below */
			  if (result.isConfirmed) {
				  location.href="/NextPage/school/manager/homepage/make/cost?prjctId="+prjId;
			  } else if (result.isDenied) {
				return;
			  }
			})

// 		if (!confirm("프로젝트를 새로 만드시겠습니까? 확인(예) 또는 취소(아니오)를 선택해주세요.")) {
//             return;
//         } else {
//         	location.href="/NextPage/school/manager/homepage/make/cost?prjctId="+prjId;
//         }
	}

	function clearProject(prjId){
		Swal.fire({
			  title: '프로젝트를 비우시겠습니까?',
			  showCancelButton: true,
			  cancelButtonText:'아니요',
			  confirmButtonText: '예'
			}).then((result) => {
			  /* Read more about isConfirmed, isDenied below */
			  if (result.isConfirmed) {
				  location.href="/NextPage/school/manager/homepage/clearProject?prjctId="+prjId;
			  } else if (result.isDenied) {
				return;
			  }
			})
// 		if (!confirm("프로젝트 비우기를 시도합니다. 확인(예) 또는 취소(아니오)를 선택해주세요.")) {
//             return;
//         } else {
//         	location.href="/NextPage/school/manager/homepage/clearProject?prjctId="+prjId;
//         }
	}

	function selectProject(prjId){
		Swal.fire({
			  title: '적용중인 프로젝트를 변경하시겠습니까?',
			  showCancelButton: true,
			  cancelButtonText:'아니요',
			  confirmButtonText: '예'
			}).then((result) => {
			  /* Read more about isConfirmed, isDenied below */
			  if (result.isConfirmed) {
				  location.href="/NextPage/school/manager/homepage/selectProject?prjctId="+prjId;
			  } else if (result.isDenied) {
				return;
			  }
			})
// 		if (!confirm("적용중인 프로젝트를 변경시도합니다. 확인(예) 또는 취소(아니오)를 선택해주세요.")) {
//             return;
//         } else {
//         	location.href="/NextPage/school/manager/homepage/selectProject?prjctId="+prjId;
//         }
	}

	
	function updateProject(prjId){
		Swal.fire({
			  title: '프로젝트를 편집 하시겠습니까?',
			  showCancelButton: true,
			  cancelButtonText:'아니요',
			  confirmButtonText: '예'
			}).then((result) => {
			  /* Read more about isConfirmed, isDenied below */
			  if (result.isConfirmed) {
				  location.href="/NextPage/school/manager/homepage/updateProject?prjctId="+prjId;
			  } else if (result.isDenied) {
				return;
			  }
			})
// 		if (!confirm("프로젝트를 편집 시도합니다. 확인(예) 또는 취소(아니오)를 선택해주세요.")) {
//             return;
//         } else {
//         	location.href="/NextPage/school/manager/homepage/updateProject?prjctId="+prjId;
//         }
	}

	function moveHomepage(authSch){
		window.open("/NextPage/generation/"+authSch+"/main", "_blank" );
	}

</script>
















