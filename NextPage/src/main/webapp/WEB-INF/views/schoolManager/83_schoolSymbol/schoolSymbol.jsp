<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<meta charset="UTF-8">
<title>학교상징</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>


<div class="content">
<c:if test="${symb eq null}">
	<h4>학교 상징</h4>
	<input id="schId" name="schId" hidden="hidden" value="${sessionScope.authSch}">
		<div id="accordion">
			<div class="card">
				<div class="card-header">
					<a class="btn" data-bs-toggle="collapse" href="#collapseZero">
						교훈 </a>
				</div>
				<div id="collapseZero" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						<input type="text" class="form-control" id="Title" name="schmtt" value="${symb.schmtt }"
							style="width: 50%;">
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header">
					<a class="btn" data-bs-toggle="collapse" href="#collapseOne">
						교목 </a>
				</div>
				<div id="collapseOne" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						교목이름 <input type="text" class="form-control" id="Title"  value="${symb.schTree }"
							name="schTree" style="width: 50%; margin-left: 150px;"> <br>
						<p style="width: 5%; float: left;">교목 설명</p>
						<textarea rows="6" cols="120" style="margin-left: 5%;"
							name="treeInfo">${symb.treeInfo }</textarea>
						<br>
						<div style="width: 150px; height: 150px; float: left;">
							<div>
								<div class="file-wrapper flie-wrapper-area">
									<div class="float-left">
										<span class="label-plus"><i class="fas fa-plus"></i></span>
										<!-- <input type="text" class="form-control" name="treeSaveName"> -->
										<input type="file" name="treeFileName" id="treeFileName"
											class="upload-box upload-plus fileNames" accept="image/*">
										<div id="preview1"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header">
					<a class="collapsed btn" data-bs-toggle="collapse"
						href="#collapseTwo"> 교화 </a>
				</div>
				<div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						교화이름 <input type="text" class="form-control" id="Title" value="${symb.schFlower }"
							name="schFlower"  style="width: 50%; margin-left: 150px;"> <br>
						<p style="width: 5%; float: left;">교화 설명</p>
						<textarea rows="6" cols="120" style="margin-left: 5%;"
							name="flowerInfo">${symb.flowerInfo }</textarea>
						<br>
						<div style="width: 150px; height: 150px; float: left;">
							<div>
								<div class="file-wrapper flie-wrapper-area">
									<div class="float-left">
										<span class="label-plus"><i class="fas fa-plus"></i></span>
										<!-- <input type="text" class="form-control" name="flowerSaveName"> -->
										<input type="file" name="flowerFileName" id="flowerFileName"
											class="upload-box upload-plus fileNames" accept="image/*">
										<div id="preview2"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header">
					<a class="collapsed btn" data-bs-toggle="collapse"
						href="#collapseThree"> 교조 </a>
				</div>
				<div id="collapseThree" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						교조이름 <input type="text" class="form-control" id="Title" value="${symb.schBird }"
							name="schBird" style="width: 50%; margin-left: 150px;"> <br>
						<p style="width: 5%; float: left;">교조 설명</p>
						<textarea rows="6" cols="120" style="margin-left: 5%;"
							name="birdInfo">${symb.birdInfo }</textarea>
						<br>
						<div style="width: 150px; height: 150px; float: left;">
							<div>
								<div class="file-wrapper flie-wrapper-area">
									<div class="float-left">
										<span class="label-plus"><i class="fas fa-plus"></i></span>
										<!-- <input type="text" class="form-control" name="birdSaveName"> -->
										<input type="file" name="birdFileName" id="birdFileName"
											class="upload-box upload-plus fileNames" accept="image/*">
										<div id="preview3"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header">
					<a class="collapsed btn" data-bs-toggle="collapse"
						href="#collapseFour"> 교표 </a>
				</div>
				<div id="collapseFour" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						교표이름 <input type="text" class="form-control" id="Title" value="${symb.schSymbol }"
							name="schSymbol" style="width: 50%; margin-left: 150px;">
						<br>
						<p style="width: 5%; float: left;">교표 설명</p>
						<textarea rows="6" cols="120" style="margin-left: 5%;"
							name="symbolInfo">${symb.symbolInfo }</textarea>
						<br>
						<div style="width: 150px; height: 150px; float: left;">
							<div>
								<div class="file-wrapper flie-wrapper-area">
									<div class="float-left">
										<span class="label-plus"><i class="fas fa-plus"></i></span>
										 <!-- <input type="text" class="form-control" name="symbolSaveName"> -->
										<input type="file" name="symbolFileName" id="symbolFileName"
											class="upload-box upload-plus fileNames" accept="image/*">
										<div id="preview4"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	<div class="">
		<button style="float: right; margin-right: 0px; margin-top: 5%;"
			class="btn btn-info" onclick="f_ajax()">등록</button>
	</div>
	</c:if>
</div>
<div>

	<c:if test="${symb ne null}">
	<h4>상징수정 / 추가</h4>
		<input id="schId" name="schId" hidden="hidden" value="${sessionScope.authSch}">
		<div id="accordion">
			<div class="card">
				<div class="card-header">
				<c:if test="${symb.schmtt eq null}">
					<a class="btn" data-bs-toggle="collapse" href="#collapseZero">
						교훈 추가 </a>
				</c:if>
				<c:if test="${symb.schmtt ne null}">
					<a class="btn" data-bs-toggle="collapse" href="#collapseZero">
						교훈 </a>
				</c:if>
				</div>
				<div id="collapseZero" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						<input type="text" class="form-control" id="Title" name="schmtt" value="${symb.schmtt }"
							>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header">
				<c:if test="${symb.schTree eq null}">
					<a class="btn" data-bs-toggle="collapse" href="#collapseOne">
						교목 추가 </a>
				</c:if>
				<c:if test="${symb.schTree ne null}">
					<a class="btn" data-bs-toggle="collapse" href="#collapseOne">
						교목 </a>
				</c:if>
				</div>
				<div id="collapseOne" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						교목이름 <input type="text" class="form-control mt-3" id="Title"  value="${symb.schTree }"
							name="schTree" style="width: 50%;"> <br>
						<p style="width: auto; float: left;">교목 설명</p> <br>
						<textarea rows="6" cols="120"  class="form-control"
							name="treeInfo">${symb.treeInfo }</textarea>
						<br>
						<div style="width: 150px; height: 150px; float: left;">
							<div>
								<div class="file-wrapper flie-wrapper-area">
									<div class="float-left">
										<span class="label-plus"><i class="fas fa-plus"></i></span>
										<!-- <input type="text" class="form-control" name="treeSaveName"> -->
										<input type="file" name="treeFileName" id="treeFileName" style="width: auto;"
											class="upload-box upload-plus form-control" accept="image/*">
										<div id="preview1">
											파일명 : ${symb.treeFileName}
											<input type="button" onclick="delFile(this,'${symb.treeFileName}')" value="파일삭제" class="btn btn-danger rounded-pill">
											<%-- <c:choose >
												<c:when test="${not empty symb.treeFileName }">
													<div class="file-edit-icon">
														<img width="200px" height="200px" class="thumb"
														src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${symb.treeFileName}">


													</div>
												</c:when>
											</c:choose> --%>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header">
				<c:if test="${symb.schFlower eq null}">
					<a class="btn" data-bs-toggle="collapse" href="#collapseTwo">
						교화 추가 </a>
				</c:if>
				<c:if test="${symb.schFlower ne null}">
					<a class="collapsed btn" data-bs-toggle="collapse"
						href="#collapseTwo"> 교화 </a>
				</c:if>
				</div>
				<div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						교화이름 <input type="text" class="form-control mt-3" id="Title" value="${symb.schFlower }"
							name="schFlower"  style="width: 50%;"> <br>
						<p style="width: auto; float: left;">교화 설명</p><br>
						<textarea rows="6" cols="120" class="form-control"
							name="flowerInfo">${symb.flowerInfo }</textarea>
						<br>
						<div style="width: 150px; height: 150px; float: left;">
							<div>
								<div class="file-wrapper flie-wrapper-area">
									<div class="float-left">
										<span class="label-plus"><i class="fas fa-plus"></i></span>
										<!-- <input type="text" class="form-control" name="flowerSaveName"> -->
										<input type="file" name="flowerFileName" id="flowerFileName" style="width: auto;"
											class="upload-box upload-plus form-control" accept="image/*">
										<div id="preview2">
											파일명 : ${symb.flowerFileName}
											<input type="button" onclick="delFile(this,'${symb.flowerFileName}')" value="파일삭제" class="btn btn-danger rounded-pill">
											<%-- <c:choose >
												<c:when test="${not empty symb.flowerFileName }">
													<div class="file-edit-icon">
														<img width="200px" height="200px" class="thumb" src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${symb.flowerFileName}">
														<br>
														<a href="#" class="btn btn-primary preview-edit" style="width:100px" >수정</a><a href="#" class="btn btn-danger preview-de" style="width:100px">삭제</a>
													</div>
												</c:when>
											</c:choose> --%>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header">
				<c:if test="${symb.schBird eq null}">
					<a class="btn" data-bs-toggle="collapse" href="#collapseThree">
						교조 추가 </a>
				</c:if>
				<c:if test="${symb.schBird ne null}">
					<a class="collapsed btn" data-bs-toggle="collapse"
						href="#collapseThree"> 교조 </a>
				</c:if>
				</div>
				<div id="collapseThree" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						교조이름 <input type="text" class="form-control mt-3" id="Title" value="${symb.schBird }"
							name="schBird" style="width: 50%; "> <br>
						<p style="width: auto; float: left;">교조 설명</p><br>
						<textarea rows="6" cols="120" class="form-control"
							name="birdInfo">${symb.birdInfo }</textarea>
						<br>


						<div style="width: 150px; height: 150px; float: left;">
							<div>
								<div class="file-wrapper flie-wrapper-area">
									<div class="float-left">
										<span class="label-plus"><i class="fas fa-plus"></i></span>
										<!-- <input type="text" class="form-control" name="birdSaveName"> -->
										<input type="file" name="birdFileName" id="birdFileName" style="width: auto;"
											class="upload-box upload-plus form-control" accept="image/*">
										<div id="preview3">
											파일명 : ${symb.birdFileName}
											<input type="button" onclick="delFile(this,'${symb.birdFileName}')" value="파일삭제" class="btn btn-danger rounded-pill">
											<%-- <c:choose >
												<c:when test="${not empty symb.birdFileName }">
													<div class="file-edit-icon">
														<img width="200px" height="200px" class="thumb" src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${symb.birdFileName}">
														<br>
														<a href="#" class="btn btn-primary preview-edit" style="width:100px" >수정</a><a href="#" class="btn btn-danger preview-de" style="width:100px">삭제</a>
													</div>
												</c:when>
											</c:choose>
 --%>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header">
				<c:if test="${symb.schSymbol eq null}">
					<a class="btn" data-bs-toggle="collapse" href="#collapseFour">
						교표 추가 </a>
				</c:if>
				<c:if test="${symb.schSymbol ne null}">
					<a class="collapsed btn" data-bs-toggle="collapse"
						href="#collapseFour"> 교표 </a>
				</c:if>
				</div>
				<div id="collapseFour" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						교표이름 <input type="text" class="form-control mt-3" id="Title" value="${symb.schSymbol }"
							name="schSymbol" style="width: 50%;">
						<br>
						<p style="width: auto; float: left;">교표 설명</p><br>
						<textarea rows="6" cols="120" class="form-control"
							name="symbolInfo">${symb.symbolInfo }</textarea>
						<br>

						<div style="width: 150px; height: 150px; float: left;">
							<div>
								<div class="file-wrapper flie-wrapper-area">
									<div class="float-left">
										<span class="label-plus"><i class="fas fa-plus"></i></span>
										<!-- <input type="text" class="form-control" name="symbolSaveName"> -->
										<input type="file" name="symbolFileName" id="symbolFileName" style="width: auto;"
											class="upload-box upload-plus form-control"  accept="image/*">
										<div id="preview4">
											파일명 : ${symb.symbolFileName}
											<input type="button" onclick="delFile(this,'${symb.symbolFileName}')" value="파일삭제" class="btn btn-danger rounded-pill">
											<%-- <c:choose >
												<c:when test="${not empty symb.symbolFileName }">
													<div class="file-edit-icon">
														<img width="200px" height="200px" class="thumb" src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${symb.symbolFileName}">
														<br>
														<a href="#" class="btn btn-primary preview-edit" style="width:100px" >수정</a><a href="#" class="btn btn-danger preview-de" style="width:100px">삭제</a>
													</div>
												</c:when>
											</c:choose> --%>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<button style="float: right; margin-right: 1%;" onclick="mod_ajax()"
			class="btn btn-success">수정</button>
		<!-- 		<button style="float: right; margin-right: 37%;" -->
		<!-- 			class="btn btn-danger">삭제</button> -->
	</c:if>
</div>
<script type="text/javascript">
	function handleFileSelect(event) {
		var input = this;
		if (input.files && input.files.length) {
			var reader = new FileReader();
			this.enabled = false
			reader.onload = (function(e) {
				console.log(e);
				$("#preview")
						.html(
								[
										'<div class="file-edit-icon" style=" float: right;"><img  width="200px" height="200px" class="thumb" src="',
										e.target.result,
										'" title="',
										escape(e.name),
										'"/><br><a href="#" class="preview-edit" >수정</a><a href="#" class="preview-de">삭제</a></div>' ]
										.join(''))
			});
			reader.readAsDataURL(input.files[0]);
		}

	}

	$('#file1').change(handleFileSelect);

	$(document).on('click', '.preview-de', function() {
		$("#preview").empty();
		$("#file").val("");
	});
	$(document).on('click', '.preview-edit', function() {
		$("#file").click();
	});


</script>
<script>

	treeData = "${symb.treeFileName}";
	flowerData = "${symb.flowerFileName}";
	birdData = "${symb.birdFileName}";
	symbolData = "${symb.symbolFileName}";


	function delFile(obj,objFile){
		console.log(objFile);

		$(obj).parent().remove();

	/* 	console.log("this : ",$(this));

		console.log("${symb.treeFileName}");
		console.log("${symb.flowerFileName}");
		console.log("${symb.birdFileName}");
		console.log("${symb.symbolFileName}");
		 */
		if(objFile ==  "${symb.treeFileName}"){
			console.log("교목삭제");
			treeData = "";
		}

		if(objFile ==  "${symb.flowerFileName}"){
			console.log("교화삭제");
			flowerData = "";
		}

		if(objFile ==  "${symb.birdFileName}"){
			console.log("교조삭제");
			birdData = "";
		}


		if(objFile ==  "${symb.symbolFileName}"){
			console.log("교표삭제");
			symbolData = "";
		}

	}







	function f_ajax(event) {
		let schId =  $('input[name = schId]').val();
		let url = "${pageContext.request.contextPath}/school/manager/symbol/insert";

		let data = {};





		data.schmtt    = $('input[name = schmtt]').val();
		data.schTree    = $('input[name = schTree]').val();
		data.treeFileName= document.getElementById('treeFileName').files[0].name;
		data.treeSaveName = $('input[name = treeSaveName]').val();
		data.schFlower      = $('input[name = schFlower]').val();
		data.flowerFileName= document.getElementById('flowerFileName').files[0].name;
		data.flowerSaveName= $('input[name = flowerSaveName]').val();
		data.schBird       = $('input[name = schBird]').val();
		data.birdFileName=  document.getElementById('birdFileName').files[0].name;
		data.birdSaveName= $('input[name = birdSaveName]').val();
		data.schSymbol     = $('input[name = schSymbol]').val();
		data.symbolFileName= document.getElementById('symbolFileName').files[0].name;
		data.symbolSaveName= $('input[name = symbolSaveName]').val();
		data.treeInfo    = $('textarea[name = treeInfo]').val();
		data.flowerInfo = $('textarea[name = flowerInfo]').val();
		data.birdInfo      = $('textarea[name = birdInfo]').val();
		data.symbolInfo  = $('textarea[name = symbolInfo]').val();
		console.log("데이터 :", data);


		$.ajax({
			url : url,
			method : "post",
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf-8",
			dataType : "text",
			success : function(resp) {
				if (resp == "ok") {
					Swal.fire('등록 성공!');
					setTimeout("history.go(0);", 3000);

// 					const timeoutId = setTimeout("history.go(0);", 3000);
					clearTimeout(timeoutId);
					// 				location.href = location.href;
// 					location.replace("http://localhost/NextPage/generation/"+schId+"/school/symbol")
				}

			},
			error : function(errorResp) {
				console.log(errorResp.status);
				Swal.fire("에러발생, 잠시후 다시 시도해주세요");
				console.log(errorResp.responseText);
				const timeoutId = setTimeout("history.go(0);", 3000);
				clearTimeout(timeoutId);
			}
		});

	}

	function mod_ajax(event) {
		let schId =  $('input[name = schId]').val();
		let url = "${pageContext.request.contextPath}/school/manager/symbol/modify";
		let data = {};


		var a = document.getElementById('treeFileName').files[0];
		var b = document.getElementById('flowerFileName').files[0];
		var c = document.getElementById('birdFileName').files[0];
		var d = document.getElementById('symbolFileName').files[0];



		if(a==undefined){
			console.log("없다");
			data.treeFileName = treeData;
		}else{
			data.treeFileName= document.getElementById('treeFileName').files[0].name;
		}

		if(b==undefined){
			console.log("없다");
			data.flowerFileName = flowerData;
		}else{
			data.flowerFileName= document.getElementById('flowerFileName').files[0].name;
		}

		if(c==undefined){
			console.log("없다");
			data.birdFileName = birdData;
		}else{
			data.birdFileName= document.getElementById('birdFileName').files[0].name;
		}

		if(d==undefined){
			console.log("없다");
			data.symbolFileName = symbolData;
		}else{
			data.symbolFileName= document.getElementById('symbolFileName').files[0].name;
		}



		data.schmtt    = $('input[name = schmtt]').val();
		data.schTree    = $('input[name = schTree]').val();
		//data.treeFileName= document.getElementById('treeFileName').files[0].name;
		//data.treeSaveName = $('input[name = treeSaveName]').val();
		data.schFlower      = $('input[name = schFlower]').val();
		//data.flowerFileName= document.getElementById('flowerFileName').files[0].name;
		//data.flowerSaveName= $('input[name = flowerSaveName]').val();
		data.schBird       = $('input[name = schBird]').val();
		//data.birdFileName=  document.getElementById('birdFileName').files[0].name;
		//data.birdSaveName= $('input[name = birdSaveName]').val();
		data.schSymbol     = $('input[name = schSymbol]').val();
		//data.symbolFileName= document.getElementById('symbolFileName').files[0].name;
		//data.symbolSaveName= $('input[name = symbolSaveName]').val();
		data.treeInfo    = $('textarea[name = treeInfo]').val();
		data.flowerInfo = $('textarea[name = flowerInfo]').val();
		data.birdInfo      = $('textarea[name = birdInfo]').val();
		data.symbolInfo  = $('textarea[name = symbolInfo]').val();

		console.log(data);


		$.ajax({
			url : url,
			method : "post",
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf-8",
			dataType : "text",
			success : function(resp) {
				if (resp == "ok") {

					Swal.fire({
						  title: '수정이 완료되었습니다.',
						  confirmButtonText: '확인',
						}).then((result) => {
						  if (result.isConfirmed) {
							//location.replace("http://localhost/NextPage/generation/"+schId+"/symbol")
							location.reload();
//	 						  location.href = location.href;
						  }
						})
					}

			},
			error : function(errorResp) {
				if (resp == "no") {
				console.log(errorResp.status);
				Swal.fire("에러발생, 잠시후 다시 시도해주세요");
				console.log(errorResp.responseText);
				const timeoutId = setTimeout("history.go(0);", 3000);
				clearTimeout(timeoutId);
				}
			}
		});

	}


</script>

