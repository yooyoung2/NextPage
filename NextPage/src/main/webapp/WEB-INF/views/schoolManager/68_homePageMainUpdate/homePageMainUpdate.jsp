<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script> -->
<head>
<!--   <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
   -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/templatesPreview/css/component2.css" />
<script src="<%=request.getContextPath()%>/resources/templatesPreview/js/modernizr.custom.js"></script>
<script src="<%=request.getContextPath()%>/resources/templatesPreview/js/toucheffects.js"></script>



</head>


<style>
.offcanvas {
	position: fixed;
	bottom: 0;
	z-index: 1050;
	display: flex;
	flex-direction: column;
	max-width: 100%;
	visibility: hidden;
	background-color: #fff;
	background-clip: padding-box;
	outline: 0;
	transition: transform .3s ease-in-out
}

@media ( prefers-reduced-motion :reduce) {
	.offcanvas {
		transition: none
	}
}

.offcanvas-header {
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 1rem 1rem
}

.offcanvas-header .btn-close {
	padding: .5rem .5rem;
	margin-top: -.5rem;
	margin-right: -.5rem;
	margin-bottom: -.5rem
}

.offcanvas-title {
	margin-bottom: 0;
	line-height: 1.5
}

.offcanvas-body {
	flex-grow: 1;
	padding: 1rem 1rem;
	overflow-y: auto
}

.offcanvas-start {
	top: 0;
	left: 0;
	width: 400px;
	border-right: 1px solid rgba(0, 0, 0, .2);
	transform: translateX(-100%)
}

.offcanvas-end {
	top: 0;
	right: 0;
	width: 500px;
	border-left: 1px solid rgba(0, 0, 0, .2);
	transform: translateX(100%)
}

.offcanvas-top {
	top: 0;
	right: 0;
	left: 0;
	height: 30vh;
	max-height: 100%;
	border-bottom: 1px solid rgba(0, 0, 0, .2);
	transform: translateY(-100%)
}

.offcanvas-bottom {
	right: 0;
	left: 0;
	height: 30vh;
	max-height: 100%;
	border-top: 1px solid rgba(0, 0, 0, .2);
	transform: translateY(100%)
}

.offcanvas.show {
	transform: none
}

.trs {
	border: 1px solid black;
	border-collapse: collapse;
}

#homepage {
	/* border: 1px solid blue;
	width: 800px; */
	/* border-collapse: collapse; */
}

#layout {
	/* border-collapse: collapse; */
}

.tds {
	width: 150px;
	height: 100px;
	border: 2px solid black;
	overflow: auto;
}

#box1 {
	width: 760px;
	height: 1200px;
	border: 2px solid black;
}

#Image{
	margin-top: 5%;
	width: 450px;
	height : 185px;
	border: 2px solid black;
	position: relative;
	background-image: url('<%=request.getContextPath()%>/resources/templatesPreview/images/${genTemplate.tmpltMain}');
	background-size:  445px 181px;
}
#mainBtn{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

#genBanner{
	width: 450px;
	height : 70px;
	border: 2px solid black;
	position: relative;
	background-image: url('<%=request.getContextPath()%>/resources/templatesPreview/images/${genTemplate.tmpltBanner}');
	background-size: 470px 60px;
}

#bannerBtn{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}


#genFooter{
	width: 450px;
	height : 100px;
	border: 2px solid black;
	position: relative;
	background-image: url('<%=request.getContextPath()%>/resources/templatesPreview/images/${genTemplate.tmpltFoot}');
	background-size: cover;
}

#footerBtn{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

#remoteControl{
	display: block;
	margin: 0 5px;
	text-align: right;
}

#upForm{
	width: 450px;
}

#schLogo{
	margin-right: 90px;
}


</style>

	<h2>메인화면 수정하기</h2>

	<!-- <input class="btn btn-primary" type="button" value="저장하기"> -->



	<form method="post" id="upForm" >

	<div id="remoteControl"> 
		<input class="btn btn-primary" type="button" id="Logo1" value="로고설정" data-bs-toggle="modal" data-bs-target="#schLogo">
		<input type="button" value="홈페이지 이동" onclick="moveHomepage('${sessionScope.authSch }')" class="btn btn-primary">
		<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" id="offRemote"
						data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">슬롯 리모콘</button>
		<input class="btn btn-primary" type="submit" value="저장하기" id="subBtn" data-prjctid="${prjctId}">
	</div>

	<%-- <img alt="" src="<%=request.getContextPath()%>/resources/templatesPreview/images/${genTemplate.tmpltThmnl}"> --%>
	<div id="Image">
			<input type="button" id="mainBtn" class="btn btn-secondary" value="메인이미지" data-bs-toggle="modal" data-bs-target="#mainImage" >
	</div>
	    <div id="homepage">

	    	<%-- <div id="layout" class="grid cs-style-1"> 레이아웃
		    	<figure>
		    		${layout.layoutSc}
		    		<figcaption>
		    			<a href="#" data-toggle="modal" data-target="123"> 미리보기</a>
					</figcaption>
		    	</figure>
		    </div> --%>
		    <div id="layout" class="grid cs-style-custom">
		    	${layout.layoutSc}
		    </div>


	    </div>
    </form>

    <div id="genBanner" >
		<input type="button"class="btn btn-secondary" id="bannerBtn" value="배너세팅" data-bs-toggle="modal" data-bs-target="#banner">
	</div>


	<div id="genFooter" >
		<input type="button" id="footerBtn" class="btn btn-secondary" value="푸터세팅" data-bs-toggle="modal" data-bs-target="#footer">
	</div>

	<!-- -------------------------------밑으로는 모달과 오프캔버스 데이터----------------------------------------- -->
	<!-- 로고 -->


	<div class="offcanvas offcanvas-end" data-bs-scroll="true"
	data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling"
	aria-labelledby="offcanvasScrollingLabel">
	<div class="offcanvas-header">
		<h5 class="offcanvas-title" id="offcanvasScrollingLabel">메뉴선택</h5>
		<button type="button" class="btn-close text-reset"
			data-bs-dismiss="offcanvas" aria-label="Close"></button>
	</div>
	<div class="offcanvas-body">

		<div id="box1" ondrop="drop(event)" ondragover="dragOver(event)">

				<c:choose>
					<c:when test="${not empty slotOptList}">
						<c:forEach items="${slotOptList}" var="slotOpt">
							<%-- <div class="con" style="width:${slotOpt.slotSize}px; height:195px;" draggable="true" ondragstart="drag(event)" id="${slotOpt.slotId}" >
							<img data-name="${slotOpt.slotNm}" src="<%=request.getContextPath()%>/resources/templatesPreview/images/layout/${slotOpt.slotFile}"  style="width:80%; height:80%; z-index:-1;"     alt=""  >
							<input type="button" class="top-right" value="톱니">
						</div> --%>
							<%-- <img data-name="${slotOpt.slotNm}" src="<%=request.getContextPath()%>/resources/templatesPreview/images/layout/${slotOpt.slotFile}"
								alt="" style="width:${slotOpt.slotSize}px; height:195px;" draggable="true" ondragstart="drag(event)" id="${slotOpt.slotId}">
							 --%>

							 <figure>
								<div style="width: ${slotOpt.slotSize}px; height: 95px; background-image: url('<%=request.getContextPath()%>/resources/templatesPreview/images/layout/${slotOpt.slotFile}'); background-repeat: no-repeat; background-size: cover"
									data-name="${slotOpt.slotNm}" id="${slotOpt.slotId}" draggable="true" ondragstart="drag(event)">
									<figcaption>
										<!-- <a href="#" data-toggle="modal" data-target="#${freeTemplate.tmpltId}"> 미리보기</a> -->
										<!-- <a href="#" data-toggle="modal"    data-target="#${slotOpt.slotId}" style="color:white" >설정하기</a> -->
										<a href="#" data-bs-toggle="modal" data-bs-target="#${slotOpt.slotId}1"  style="color:white" >설정하기</a>
									</figcaption>
								</div>
								</figure>
						</c:forEach>
					</c:when>
				</c:choose>

			<!-- <div style="width: 90px; height: 90px; padding: 0.5em; float: left; margin: 0 10px 10px 0;" draggable="true" ondragstart="drag(event)" id="asd" class="ui-widget-content ui-draggable ui-draggable-handle" style="position: relative; z-index: 6; left: 15px; top: -9px;">
		<p>..whose z-indexes are controlled automatically..</p> -->
		</div>
	</div>
</div>



<div class="modal fade" id="schLogo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-scrollable modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body"> 로고

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary addBtn" id="addBtn" data-menuid="123">저장</button>
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>


	<!-- 메인 -->
<div class="modal fade" id="mainImage" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-scrollable modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body"> 메인이미지

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary addBtn" id="addBtn" data-menuid="123">저장</button>
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>






<c:choose>
	<c:when test="${not empty slotOptList }">
		<c:forEach items="${slotOptList }" var="slotOpt">


			<div class="modal fade" id="${slotOpt.slotId}1" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-scrollable modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel"></h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">...</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-primary addBtn" id="addBtn" data-menuid="123">추가</button>
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty divInSlotOptList}">
		<c:forEach items="${divInSlotOptList}" var="divInSlot">
			<div class="modal fade" id="${divInSlot.slotId}1" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-scrollable modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel"></h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">...</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-primary addBtn" id="addBtn" >확인</button>
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:when>
</c:choose>


<!-- 배너 -->
<div class="modal fade" id="banner" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-scrollable modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary addBtn" id="addBtn" data-menuid="123">저장</button>
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>


<!-- Footer -->
<div class="modal fade" id="footer" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-scrollable modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<form action="">
				<div class="modal-body">footer 정보

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary addBtn" id="addBtn" data-menuid="123">전송</button>
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
				</div>
			</form>
		</div>
	</div>
</div>






<form id='viewForm' action="/NextPage/school/manager/slot/add" method="get">
	<input type='hidden' name='menuid' />
</form>


<script type="text/javascript" src="/NextPage/resources/js/schoolManager/genSlotInfo.js"></script>

<script>
	function moveHomepage(authSch){
		
		/* location.href="/NextPage/generation/"+authSch+"/main"; */
		 window.open("/NextPage/generation/"+authSch+"/main", "_blank" ); 
	}


	$( document ).ready(function() {
	    console.log( "ready!" );
	    $("#offRemote").trigger('click');
	});

	var tdss = document.querySelectorAll(".tds");
	//console.log(tdss);
	for(let i = 0 ; i < tdss.length ; i++){
		var figure = $("<figure>");

		/* console.log(tdss[i].id); */

		<c:choose>
			<c:when test="${not empty divInSlotOptList}">
				<c:forEach items="${divInSlotOptList}" var="divInSlot">
				var figure = $("<figure>");
					if(tdss[i].id == "${divInSlot.divNum}"){

							 img = $("<div>").attr("style", "width:${divInSlot.slotSize}px; height:95px; background-image:url(<%=request.getContextPath()%>/resources/templatesPreview/images/layout/${divInSlot.slotFile});background-repeat:no-repeat; background-size: cover")
												.attr("data-name", "${divInSlot.slotNm}")
												.attr("id", "${divInSlot.slotId}")
						  						.attr("draggable", true)
						  						.attr("ondragstart", "drag(event)");
						$(".tds");

						figcaption = $("<figcaption>");

						aTag = $("<a>").attr("href", "#")
									   .attr("style", "color:white")
									   .attr("data-bs-toggle", "modal")
									   .attr("data-bs-target", "#${divInSlot.slotId}1")
									   .text("설정하기");

						$(aTag).appendTo(figcaption);

						//$(img).after(figcaption);
						//$(img).appendTo(figure).after(figcaption);

						$(figcaption).appendTo(img);
						$(img).appendTo(figure);


						$(figure).appendTo("#${divInSlot.divNum}");
						//$(figcaption).append("#${divInSlot.divNum}");
					}

				</c:forEach>
			</c:when>

		</c:choose>

		$(figure).appendTo("#"+tdss[i].id);
	}

	function drag(ev) {
		ev.dataTransfer.setData("text", ev.target.id);

		console.log(ev.target.style.width);


		//slot정보를 집었을때 사이즈를 취득해서, col값을 만들어준다.
		col = 0;
		if(ev.target.style.width=="145px"){
			col = 1;
		}else if(ev.target.style.width=="295px"){
			col = 2;
		}else if(ev.target.style.width=="445px"){
			col = 3;
		}

		console.log("값 : "+ col);
		//console.log("내가집은 이미지정보",ev.target);

	}

	function dragOver(ev) {
		ev.preventDefault();

		if (ev.target.tagName == "IMG"){
			//alert("이미 위젯이 등록 되어있습니다.");
		}
		/* console.log("내려놓기전 ev.tartget : ",ev.target); //ev.target => TD,
		console.log("내려놓기전 ev.tartget.children : ",ev.target.children); //ev.target => TD,  */
		//console.log("내려놓기전",ev.target.tagName); //내가 내려놓을 타겟의 태그이름 비어있으면 TD, 있으면 IMG

	}

	function drop(ev) {
		ev.preventDefault();
		//console.log("내려놓은후",ev.target); //이때 타겟은  내려놓은 대상(지금은 tds와 이미지정보 출력)

		var data = ev.dataTransfer.getData("text"); //id값 출력.
		/* console.log(ev.target);
		console.log(ev.target.children);
		console.log(ev.currentTarget);
		console.log("내가 드래그 -> 드롭한 id값 : "+data);

		console.log(ev.target.childNodes); */

		console.log("넘어온값 : " + col);

		console.log(ev.target);
		console.log(ev.target.colSpan); //colspan값 비교할 대상(중요)

		//figure
		if (ev.target.tagName == "TD"){ //내려놓을위치가 TD인경우

			if(col == ev.target.colSpan){ // TD이면서 들어가는곳의 사이즈가 같아야함.
				ev.target.children[0].appendChild(document.getElementById(data));
			}
		} else { //내려놓는 위치가 TD가 아닌경우
			//alert("이미 위젯이 등록 되어있습니다.");
		}
		console.log("타겟 : "+ev.target.id);

		// 슬롯정보 반납
		if(ev.target.id == "box1"){

			ev.target.children[0].appendChild(document.getElementById(data));

		}


		console.log("asdasdasd",ev.target);
	}

	var eeeee = $("#upForm").on("submit", function(){

		event.preventDefault();

		console.log("eee눌림");

		var prjctId = $("#subBtn").data('prjctid');
		console.log(prjctId);

		let url = "/NextPage/school/manager/homepage/updateProject";
		//let url = this.action;
		let method = "post";
		//let data = $(this).serialize;
		let datas = [];  // [{id: "" , name: ""}, ...] //형태로 감
		let tds = document.querySelectorAll(".tds");
		 for(let i=0; i<tds.length; i++){

			let imVO = {};
			imVO.id = tds[i].getAttribute("id");
			if(tds[i].children[0].children[0]){
				imVO.name = tds[i].children[0].children[0].dataset["name"];
			}else{
				imVO.name = "";
			}
			datas.push(imVO);
		}
		 console.log("만들어진 데이터(VO) :",datas);

		//let data = JSON.stringify(datas);
		//let data = { layoutData : JSON.stringify(datas)};
       // JSON.stringify(datas)
		let data = {
				layoutData :  datas
				, prjctId : prjctId
			};

		console.log("url : " + url);
		console.log("method : " + method);
		console.log("전송될 data : " + data);

		$.ajax({
			url : url,
			method : method,
			data : JSON.stringify(data),
			contentType: 'application/json',
			dataType : "html",
			success : function(resp) {
				//console.log("성공");
				location.reload();
				// location.href="/NextPage/school/manager/home/page/manage";
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});

		return false;
	})
</script>
