<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<meta charset="UTF-8">
<title>컨텐츠폼(추가,수정)</title>
  <meta name="robots" content="noindex, nofolloEEEEEEEEEEEEw">
<script src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<div class="content">

	<!--

	최초 작성자 : 이유영
	작성일 : 1994.2.19


	추가 작성자 : 최현우
	수정일 : 1995.02.01
	수정내용 : 동영상,음원 요소 제거


 -->

	<!-- 내용 시작 -->

	<!-- 컨텐츠 제목  -->
	<!--  action = "<%= request.getContextPath()%>/school/manager/content/insert" method = "GET" -->
	<form id = "frm">
	<!-- <div style="margin-left: 5%;">
		<p style="width: 8%; float: left;">*컨텐츠 제목</p>
		<input type="text" class="form-control" id="title" name="titleName" style="width: 35%;">
		<br>
	</div> -->
	<!-- 컨텐츠 제목 끝 -->

	<div class="gallerylist" style="margin-top:10%;">

		<div class = "view">
			<c:choose>
				<c:when test="${empty content.cntntsTitle }">
					<input type="text" class="form-control" id="title" name="titleName" style="width: 35%;" placeholder = "제목"  >
				</c:when>
				<c:when test="${not empty content.cntntsTitle }"> 
					<input type="text" class="form-control" id="title" name="title" style="width: 35%;" value = "${content.cntntsTitle }">
					<input type="hidden" name = "cntntId" value = "${content.cntntsId }">
				</c:when>
			</c:choose>
			<%-- <select name = "menuNm" style = "margin-left: 20px;">
				<c:forEach var = "menu" items = "${menuList }">
					<option value = "${menu.menuLink }">${menu.menuNm }</option>
				</c:forEach>
			</select> --%>
		</div>
		<br>

			<!-- 에디터 시작 -->

			<!-- <h3>에디터 요소</h3> -->
			<div>
				<tr>
					<td>
					<c:choose>
						<c:when test="${empty content.cntntsCntnt }">
							<textarea id="textArea" name="textArea"></textarea>
						</c:when>
						<c:when test="${not empty content.cntntsCntnt }">
							<textarea id="textArea" name="content">${content.cntntsCntnt }</textarea>
						</c:when>
					</c:choose>
					<script type="text/javascript">
						CKEDITOR.replace('textArea',{
								filebrowserUploadUrl:"ckeditor"
								});
			        </script>
					</td>

				</tr>
			</div>
			<br>

			<!-- 에디터 끝 -->
			<div>
				<input type="file" name="fileName" id="fileName" class="upload-box upload-plus form-control mb-3" accept=".jpg, .png" value="${content.fileName}" >
				<c:if test="${content.fileName ne null}">
					이전 파일명 : ${content.fileName}
					<input type="text" name="hidFilename" value="${content.fileName}" class="form-control mb-3">
				</c:if>
				<%-- <input type="text" value="${content.fileName} "> --%>
				<!-- <a href="#myModal" data-toggle="modal" data-target="#myModal" class="form-control" style="width: 200px;">
					이미지첨부
				</a> -->
			</div>

		<button class="btn btn-danger" style="float: right; margin-right: 1%;">취소</button>
		<!-- <button class="btn btn-primary" style="float: right; margin-right: 1%;">컨텐츠 추가</button> -->
		<c:choose>
			<c:when test="${empty isUpdate }">
				<input id = "submitButton" class = "btn btn-primary" style="float: right; margin-right: 1%;" type = "button" value = "컨텐츠 등록">
			</c:when>

			<c:when test="${not empty isUpdate }">
				<input id = "submitButton" class = "btn btn-primary" style="float: right; margin-right: 1%;" type = "button" value = "컨텐츠 수정">
			</c:when>
		</c:choose>


		<script>

			let button = document.getElementById( "submitButton" );
			button.onclick = function(){

//				alert( "oh yeah~" );

				let form = document.getElementById( "frm" );
				console.log( "버튼 누림" );

				if( button.value == "컨텐츠 등록" ){
					console.log( "컨텐츠 등록을 누르셨습니다." );
					form.setAttribute( "action", "<%= request.getContextPath()%>/school/manager/content/insert" );
					form.setAttribute( "method", "POST" );
					 form.submit(); 

				}else if( button.value == "컨텐츠 수정" ){

					console.log( "컨텐츠 수정 누르셨습니다." );

					/* let title = document.getElementById( "title" ).value;
					let textArea = document.getElementById( "textArea" ).value; */
//					let cntntId = ${contentId};
					/* let fileName = document.getElementById( "fileName" ).value;
					console.log("파일명(변경전) :", fileName);
					
					if(fileName == ""){
						console.log("널");
						fileName = "${content.fileName}";
					}
					console.log("파일명(변경후) :", fileName); */
					
					form.setAttribute( "action", "<%= request.getContextPath()%>/school/manager/content/update");
					form.setAttribute( "method", "POST" );
					//form.setAttribute("fileName", fileName);
					
					/* console.log("전송이전데이터");
					console.log("전송데이터 ? : ", form.fileName);
					console.log("전송데이터 ? : ", form.fileName.value); */
					
										
					
					form.submit(); 
				}

			}

		</script>

	</div>
	</form>
<!-- ======================================== Modal ======================================== -->
	<!-- 이미지 Modal1 -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">이미지 수정</h4>
					<br>
					<br>
					<p>* jpg , png만 첨부 가능합니다.</p>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<table class="table table-borderless">
							<tbody>
								<tr>
									<td><input type="file" name="file" id="file"
										class="upload-box upload-plus form-control" accept=".jpg, .png"></td>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal">업로드</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- 내용 끝 -->


<script>

	let file = document.getElementById( "file" );





</script>

</body>
</html>







































<!-- 원본 코드 보존 -->
<!--
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨텐츠폼(추가,수정)</title>
  <meta name="robots" content="noindex, nofollow">
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style>

/* 중앙정렬 코드- 삭제하고 사용하세요 */
.gallerylist {
	position: absolute;
	top: 25%;
	left: 50%;
	transform: translate(-50%, -50%);
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
} /* 모든 요소 마진패딩 리셋 */
/* 중앙정렬 코드-삭제하고 사용하세요 */
.gallerylist {
	margin: 0 auto;
}

.gallerylist>ul {
	font-size: 0;
}

.gallerylist>ul>li {
	display: inline-block;
	vertical-align: top;
}

.gallerylist>ul>li>a {
	display: block;
	width: auto;
	text-decoration: none;
	margin: 5px;
}

.gallerylist>ul>li>a .screen {
	position: relative;
	overflow: hidden;
}

.gallerylist>ul>li>a .screen .bottom {
	position: absolute;
	top: 150%;
	left: 600px;
	z-index: 2;
	color: #fff;
	font-size: 26px;
	font-weight: 900;
	transition: all .35s;
}

.gallerylist>ul>li>a .screen img {
	width: 100%;
}

.gallerylist>ul>li>a h3 {
	text-align: center;
	padding: 10px;
	color: #666;
}

.gallerylist>ul>li>a .screen::after {
	content: '';
	display: block;
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, .5);
	z-index: 1;
	opacity: 0;
	transition: all .35s;
}

.gallerylist>ul>li>a:hover .bottom {
	top: 1%;
}

.gallerylist>ul>li>a:hover .screen::after {
	opacity: 1;
}

.screen {
	height: 500px;
}
</style>

</head>
<body>
<div class="content">
		<button class="btn btn-primary" style="float: right; margin-right: 1%;">취소</button>
		<button class="btn btn-primary" style="float: right; margin-right: 1%;">컨텐츠 추가</button>
	<div style="margin-left: 5%;">
		<p style="width: 8%; float: left;">*컨텐츠 제목</p>
		<input type="text" class="form-control" id="Title" name="Titlename" style="width: 35%;">
		<br>
	</div>
	<div class="gallerylist" style="margin-top:10%;">
		<ul>
			<h3>제목 요소</h3>
			<input type="text" class="form-control" id="Title" name="Titlename">
			<br>
			<br>
			<li>
			<h3>이미지 요소</h3>
				<a href="#myModal" data-toggle="modal" data-target="#myModal">
					<div class="screen" style="height: 50px; border: 1px solid lightgray; width: 1300px; border-radius: 10px;">
						<h3>이미지</h3>
					</div>
				</a>
			</li>
			<li>
			<h3>동영상 요소</h3>
				<a href="#myModal2" data-toggle="modal" data-target="#myModal2">
					<div class="screen" style="height: 50px; border: 1px solid lightgray; width: 1300px; border-radius: 10px;">
						<h3>동영상</h3>
					</div>
				</a>
			</li>
			<li>
			<h3>에디터 요소</h3>
			<div>
				<tr>
					<td>
					<textarea id="helloContent" name="helloContent"></textarea>
					<script type="text/javascript">
						CKEDITOR.replace('helloContent',{ filebrowserUploadUrl:'/helloContent/imageUpload.do?type=image'});
			        </script>
					</td>
				</tr>
			</div>
			<br>
			</li>
			<li>
			<h3>음원 요소</h3>
				<a href="#myModal3" data-toggle="modal" data-target="#myModal3">
					<div class="screen" style="height: 50px; border: 1px solid lightgray; width: 1300px; border-radius: 10px;">
						<h3>음원</h3>
					</div>
				</a>
			</li>
		</ul>
	</div>
	<!-- 이미지 Modal1 -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">이미지 수정</h4>
					<br>
					<br>
					<p>* jpg , png만 첨부 가능합니다.</p>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<table class="table table-borderless">
							<tbody>
								<tr>
									<td>파일선택</td>
									<td><input type="file" name="file" id="file"
										class="upload-box upload-plus" accept=".jpg, .png"></td>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Upload</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 동영상 Modal2 -->
	<div class="modal fade" id="myModal2" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">동영상 수정</h4>
					<br>
					<br>
					<p>* mp4, wav 만 첨부 가능합니다.</p>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<table class="table table-borderless">
							<tbody>
								<tr>
									<td>파일선택</td>
									<td><input type="file" name="file" id="file"
										class="upload-box upload-plus" accept=".mp4, .wav"></td>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Upload</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 음원 Modal3 -->
	<div class="modal fade" id="myModal3" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">음원 수정</h4>
					<br>
					<br>
					<p>* mp3 만 첨부 가능합니다.</p>
					<button type="button" class="close" data-dismiss="modal">×</button>

				</div>
				<div class="modal-body">
					<div class="container">
						<table class="table table-borderless">
							<tbody>
								<tr>
									<td>파일선택</td>
									<td><input type="file" name="file" id="file"
										class="upload-box upload-plus" accept=".mp3"></td>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Upload</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>  --%>
 -->