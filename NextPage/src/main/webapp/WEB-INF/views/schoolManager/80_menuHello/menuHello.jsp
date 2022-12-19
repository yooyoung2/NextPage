<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<meta charset="UTF-8">
<meta name="robots" content="noindex, nofollow">
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>


<title>학교관리자 인사말</title>

<div class="content">
	<h3>학교장인사말</h3>
<form id="frm" enctype="multipart/form-data">
	<div>
	<input id="schId" hidden="hidden" value="${sessionScope.authSch}">
	<c:if test="${hello.cntnt ne null}">
		<textarea id="cntnt" name="cntnt">${hello.cntnt}</textarea>
		<script type="text/javascript">
			CKEDITOR.replace(
							'cntnt',
							{
								filebrowserUploadUrl : '/helloContent/imageUpload.do?type=image'
							});
		</script>
	</c:if>
	<c:if test="${hello.cntnt eq null}">
		<textarea id="cntnt" name="cntnt" ></textarea>
		<script type="text/javascript">
			CKEDITOR.replace(
							'cntnt',
							{
								filebrowserUploadUrl : '/helloContent/imageUpload.do?type=image'
							});
		</script>
	</c:if>

	</div>
	<br>

	<div style="background-color: #d5d5d5; border-radius: 5px; width: 50%; height: 50px; padding: 10px 1px;">
		<p style="float: left;">이미지 첨부</p>

		<input type="file" name="boFiles" class="form-control form-control-sm" id="file" class="upload-box upload-plus" accept="image/*" style="margin-left: 100px; width: auto">

		<div class="position-absolute bottom-10 end-0">
			<c:if test="${hello.cntnt eq null}">
				<button type="button" class="btn btn-primary" onclick="f_ajax()" style="margin-left: -80%; margin-top:-90%">적용</button>
			</c:if>
			<c:if test="${hello.cntnt ne null}">
				<button type="button" class="btn btn-success" onclick="modi_ajax()" style="margin-left: -80%; margin-top:-90%">수정</button>
			</c:if>
		</div>
	</div>
	<br>
	<div >
		<p>첨부된 이미지</p>
		<div>
			<div class="file-wrapper flie-wrapper-area">
				<div class="float-left row">
					<span class="label-plus"><i class="fas fa-plus"></i></span>
					<div id="preview">
						<c:choose >
							<c:when test="${not empty hello.fileName }">
								<div class="file-edit-icon" >
									<img width="200px" height="200px" class="thumb" src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${hello.fileName}">
									<br>
									<a href="#" class="btn-sm btn-success preview-edit" >수정</a><a href="#" class="btn-sm btn-danger preview-de">삭제</a>
								</div>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>

</form>
</div>

<script type="text/javascript">
		window.onload = function() {

		}



 	function handleFileSelect(event) {
 		var input = this;
 		if (input.files && input.files.length) {

 			var reader = new FileReader();
 			this.enabled = false
 			reader.onload = (function(e) {
 				console.log(e);
 				$("#preview").html(
 					[
 						'<div class="file-edit-icon"><img  width="200px" height="200px" class="thumb" src="',
 						e.target.result,
 						'" title="',
 						escape(e.name),
 						'"/><br><a href="#" class="btn-sm btn-success preview-edit" style="width:100px" >수정</a><a href="#" class="btn-sm btn-danger preview-de" style="width:100px">삭제</a></div>'
 					]
 						.join(''))
 			});
 			reader.readAsDataURL(input.files[0]);
 		}
 	}

 	$('#file').change(handleFileSelect);

 	$(document).on('click', '.preview-de', function() {
 		$("#preview").empty();
 		$("#file").val("");
 	});

 	$(document).on('click', '.preview-edit', function() {
 		$("#file").click();
 	});

	function f_ajax(event) {

		let url = "${pageContext.request.contextPath}/school/manager/menu/hello";

		data={
				cntnt : CKEDITOR.instances.cntnt.getData(),
				fileName : document.getElementById('file').files[0].name

		};

		/* data.cntnt = CKEDITOR.instances.cntnt.getData();
		data.fileName = document.getElementById('file').files[0].name; */
		console.log("주소 :",url);
		console.log("데이터 :",JSON.stringify(data));
		console.log("새입력");



		$.ajax({
			url : url,
			method : "post",
			data : data,
			dataType :"html",
			/* contentType : "application/json; charset=utf-8", */
			success : function(resp) {

				Swal.fire({
					  title: '등록이 완료되었습니다.',
					  confirmButtonText: '확인',
					}).then((result) => {
					  if (result.isConfirmed) {
						  //location.replace("http://localhost/NextPage/generation/"+schId+"/hello");

						  location.reload();
					  }
					})
				location.href = location.href;


			},
			error : function(errorResp) {

				console.log(errorResp.status);
				$("input[name=cntnt]").val(errorResp.responseText);
			}
		});


	}

	function modi_ajax(event) {
		let schId = $("#schId").val();
		let url = "${pageContext.request.contextPath}/school/manager/hello/modify";

		a = document.getElementById('file').files[0];

		let ttt = $(".thumb");
		console.log("111", ttt.length);

		//console.log(a);


		if(a==undefined){
			console.log("없다");
			if(ttt.length > 0){
				data={
						cntnt : CKEDITOR.instances.cntnt.getData(),
						fileName : "${hello.fileName}"
				};
			}else{
				data={
						cntnt : CKEDITOR.instances.cntnt.getData(),
						fileName : ""
				};
			}

		}else{
			console.log("있다");

			data={
					cntnt : CKEDITOR.instances.cntnt.getData(),
					fileName : document.getElementById('file').files[0].name

			};
		}



		console.log("url : ", url)
		console.log("데이터 :", data);


		$.ajax({
			url : url,
			method : "post",
			data : data,
			dataType :"html",
			success : function(resp) {

			 	Swal.fire({
				  title: '수정이 완료되었습니다.',
				  confirmButtonText: '확인',
				}).then((result) => {
				  if (result.isConfirmed) {
					  //location.replace("http://localhost/NextPage/generation/"+schId+"/hello");

					  location.reload();
				  }
				})

			},
			error : function(errorResp) {
				console.log(errorResp.status,"에러야!");
				$("input[name=cntnt]").val(errorResp.responseText);
			}
		});

	}



// 	function modi_ajax(event) {

// 		let url = "${pageContext.request.contextPath}/test/test2";
// 		let data = [];

// 		for(var i=1; i<=5; i++){
// 			let dataJson ={};
// 			dataJson.name = "apple"+i;
// 			dataJson.name2 = "banana"+i;
// 			data.push(dataJson);

// 		}


// 		console.log("데이터 :",data);

// 		$.ajax({
// 			url : url,
// 			method : "post",
// 			data : JSON.stringify(data),
// 			contentType : "application/json; charset=utf-8",
// 			dataType :"text",
// 			success : function(resp) {
// 				if(resp == "ok"){

// 					Swal.fire({
// 					  title: '정말 수정하시겠습니까??',
// 					  confirmButtonText: '확인',
// 					}).then((result) => {
// 					  if (result.isConfirmed) {
// 						  location.href = location.href;
// 					  }
// 					})
// 					//Swal.fire('인사말 수정 성공!')
// 					//;
// 				}
// 			},
// 			error : function(errorResp) {
// 				console.log(errorResp.status);
// 				$("input[name=cntnt]").val(errorResp.responseText);
// 			}
// 		});

// 	}


</script>
