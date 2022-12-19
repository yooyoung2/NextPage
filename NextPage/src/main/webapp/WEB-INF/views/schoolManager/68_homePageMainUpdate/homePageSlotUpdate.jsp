<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<style>
	.input-file-button{
		padding: 6px 25px;
		background-color:#FF6600;
		border-radius: 4px;
		color: white;
		cursor: pointer;
	}
	.lItems{
		margin: 0 0 0 0;
		padding: 0 0 0 0;
		border : 0;
		float: left;;
	}
	.lList{
		list-style:none;
		margin:0;
		padding:0;
	}
</style>
<form id='addForm' action="school/manager/slot/add" method="post">


<c:choose>
	<c:when test="${not empty genMainImgList}">
			<h3>메인이미지 설정</h3>
			* 메인이미지는 최소 1개에서 최대 3개까지 추가 가능합니다. <br>
			* 입력하고 싶은 이미지 파일을 순서대로 입력해주세요. <br><br>
	<input type="button" class="btn btn-primary" id="mkMainImg" value="메인이미지 추가">
		<div id="mkImg">
			<c:forEach items="${genMainImgList}" var="genMainImg">
				<div class="mainImgs">
					<br>
					
					<input type="file" class="addImage form-control" style="width:400px;">  
					<input type="button" class="btn btn-danger" onclick="fnDeleteImage(this);" value="이미지 삭제">
					기존 파일명 : ${genMainImg.fileName}
					<input type="hidden" class="beforeMain" value="${genMainImg.fileName}">
				</div>
			</c:forEach>
		</div>
	</c:when>
</c:choose>



<c:choose>
	<c:when test="${not empty genBoardList1}">
		<h3>일반게시판 (1x1) 설정</h3>
		* 일반(목록형)게시판을 1x1 설정합니다. <br>
		* 메뉴-하위메뉴에 등록되어 있는 목록중에 메인화면에 보여줄 게시판을 설정합니다. <br><br>
		<select name="listBrdNum1" class="form-select">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genBoardList1}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
	</c:when>
</c:choose>


<c:choose>
	<c:when test="${not empty genBoardList2}">
		<h3>일반게시판 (1x2) 설정</h3>
		* 일반(목록형)게시판을 1x2 설정합니다. <br>
		* 메뉴-하위메뉴에 등록되어 있는 목록중에 메인화면에 보여줄 게시판을 설정합니다. <br>
		* 순서에 따라 보이는 메인화면에 보여지는 게시판의 순서가 달라집니다. <br><br>
		<select name="listBrdNum2" class="form-select">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genBoardList2}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
		<select name="listBrdNum3" class="form-select">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genBoardList2}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty genImageBoardList1}">
		<h3>이미지게시판 (1x1) 설정</h3>
		* 이미지 게시판을 1x1 설정합니다. <br>
		* 메뉴-하위메뉴에 등록되어 있는 목록중에 메인화면에 보여줄 게시판을 설정합니다. <br><br>
		<select name="listBrdNum4" class="form-select">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genImageBoardList1}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
	</c:when>
</c:choose>


<c:choose>
	<c:when test="${not empty genImageBoardList2}">
		<h3>이미지게시판 (1x2) 설정</h3>
		* 이미지 게시판을 (1x2) 설정합니다. <br>
		* 메뉴-하위메뉴에 등록되어 있는 목록중에 메인화면에 보여줄 게시판을 설정합니다. <br>
		* 순서에 따라 보이는 메인화면에 보여지는 게시판의 순서가 달라집니다. <br><br>
		<select name="listBrdNum5" class="form-select">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genImageBoardList2}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
		<select name="listBrdNum6" class="form-select">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genImageBoardList2}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty genVideoBoardList1}">
		<h3>동영상게시판 (1x2) 설정</h3>
		* 동영상 게시판을 (1x2) 설정합니다. <br>
		* 메뉴-하위메뉴에 등록되어 있는 목록중에 메인화면에 보여줄 게시판을 설정합니다. <br>
		* 순서에 따라 보이는 메인화면에 보여지는 게시판의 순서가 달라집니다. <br><br>
		<select name="listBrdNum7" class="form-select" >
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genVideoBoardList1}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
		<select name="listBrdNum8" class="form-select" >
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genVideoBoardList1}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty genVideoBoardList2}">
		<h3>동영상게시판 (1x3) 설정</h3>
		* 동영상 게시판을 (1x3) 설정합니다. <br>
		* 메뉴-하위메뉴에 등록되어 있는 목록중에 메인화면에 보여줄 게시판을 설정합니다. <br>
		* 순서에 따라 보이는 메인화면에 보여지는 게시판의 순서가 달라집니다. <br><br>
		<select name="listBrdNum9" class="form-select" style="width: 250px;">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genVideoBoardList2}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }" >${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
		<select name="listBrdNum10" class="form-select" style="width: 250px;">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genVideoBoardList2}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
		<select name="listBrdNum11" class="form-select" style="width: 250px;">
		<option >게시판을 선택해주세요</option>
		<c:forEach items="${genVideoBoardList2}" var="genBoard">
			${genBoard.brdNum }, ${genBoard.brdTitle}
				<option value="${genBoard.brdNum }">${genBoard.brdTitle} (게시물번호 :${genBoard.brdNum } )</option>
		</c:forEach>
		</select>
	</c:when>
</c:choose>

<!--  -->

<c:choose>
	<c:when test="${not empty genAlertBrdList}">
		<h3>알림판 설정</h3>
		* 알림판를 설정합니다.<br>
		* 메뉴순서에 따라 알림판정보(링크, 이미지)를 입력해주세요. <br>
		* 개수는 최소1개에서 최대 10개로 제한합니다.
		<br><br>
		<div id="alertBrd">
			<input type="button" class="btn btn-primary" id="brdMake" value="알림판 입력 생성"> <br>
			<c:forEach items="${genAlertBrdList}" var="genAlertBrd">
				<div class="brd">
					<input type="text" name="genAlertBrd" value="${genAlertBrd.urlInfo}">
					<input type="button" class="brdRemove btn btn-danger btn-sm m-2" value="알림판 삭제" onclick="fnDeleteBrd(this);">
					<input type="file" class="alertFiles form-control form-control-sm" style="display: inline; width: 300px;" > 기존 파일명 : ${genAlertBrd.fileName}
					<input type="hidden" class="alertData" value="${genAlertBrd.fileName}"> 
					<br>
				</div>
			</c:forEach>
		</div>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty genCaldList}">
		<h3>달력 설정</h3>
		* 달력 설정합니다.
		* 날짜정보를 시작날짜 - 종료날짜 순서로 입력해주세요. <br>
		* 이후 스케쥴정보를 입력해주세요.<br><br>
			<input type="button" class="btn btn-primary" id="makeCald" value="일정생성"> <br>
			<div id="mkCald">
			<c:forEach items="${genCaldList}" var="genCald">
				<div style="height:32px;">
					<input type="date" name="caldStartDate" value="${genCald.caldStartDate}">
					<input type="date" name="caldEndDate" value="${genCald.caldEndDate}">
					<input type="text" name="schedule" value="${genCald.schedule }">
					<input type="button" class="caldRemove btn btn-danger btn-sm m-2" value="달력삭제" onclick="fnDeleteCald(this);">
				</div>
			</c:forEach>
			</div>
	</c:when>
</c:choose>





<c:choose>
	<c:when test="${not empty bnrLkInfoList}">
		<h3>배너 설정</h3>
		* 배너를 설정합니다.
		* 메뉴순서에 배너를 입력해주세요. <br>
		* 개수는 최소1개에서 최대 12개로 제한합니다.
		* 추가로 필요한 배너정보는 1:1문의를 통해서 신청해주세요.(이미지와 링크 필수) <br><br>
		<input type="button" class="btn btn-primary" id="bnrMake" value="배너 입력 생성"> <br>
		<div id="banMake">
			<c:forEach items="${genBnrList}" var="genBnr">
				<div>
					<select name="bnrLk" class="bnrLk form-select" id="${genBnr.bnnrOrd}">
						<c:forEach items="${bnrLkInfoList}" var="bnrLkInfo">
							<option value="${bnrLkInfo.bnrLkId}">${bnrLkInfo.bnrLkNm} </option>
						</c:forEach>
					</select>
					<input type="button" class="brdRemove btn btn-sm btn-danger m-2" value="배너 삭제" onclick="fnDeleteBnr(this);">
				</div>
			</c:forEach>
		</div>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty lkLstIconList}">
		<h3>링크위젯 설정</h3>
		* 링크 위젯을 설정합니다.<br>
		* 메뉴순서에 따라 링크 위젯 정보(위젯이미지와 링크이름, 링크URL)를 입력해주세요. <br>
		* 개수는 최소1개에서 최대 6개로 제한합니다. <br><br>
	
		<input type="button" id="lkMake" class="btn btn-primary mb-2" value="링크 위젯 생성"> <br>
		<div id="lkDiv">
			<c:forEach items="${genLkLstList}" var="genLkLst" varStatus="status">

				<div >
					<!-- 위젯 리스트 시작 -->
                    <div class="btn-group dropend me-1 mb-1" > 
                       <button type="button" class="btn btn-secondary dropdown-toggle"
                          data-bs-toggle="dropdown" aria-haspopup="true"
                          aria-expanded="false">위젯 선택</button>
                       <div class="dropdown-menu" id="allForms" style="width:800px;" >
							<ul class="lList">
								<c:forEach items="${lkLstIconList}" var="lkLstIcon"> 
		                       		<li class="lItems"><a class="dropdown-item"  href="#" onclick="fcopy(this,${status.count})"><img style="margin:20%;" width="50px" height="50px" data-lk="${lkLstIcon.iconNm}" src="<%=request.getContextPath() %>/resources/templatesPreview/images/widget/${lkLstIcon.iconFileName}"></a></li>
								</c:forEach>
							</ul>
                       </div>
                    </div>
                    <!-- 위젯 리스트 끝 -->
                    <!-- 골라진 위젯값이 상태가 바뀐다. -->
                    <div  id="merong${status.count}" class="lkWidget" style="border: 1px solid black;width: 8%;height: 80px; float:left;">

                    </div>
                    <div style="margin-left:8%; width:50%; padding: 2px 7px;"> 
						<input type="text" name="lkTitle" value="${genLkLst.linkTitle}">
						<input type="text" name="lkUrl" value="${genLkLst.linkUrl}">
						<input type="button" class="brdRemove btn btn-danger" value="링크위젯 삭제" onclick="fnDeleteLk(this,${status.count});">
					</div>
					
				</div>
			</c:forEach>
		</div>
	</c:when>
</c:choose>





<c:choose>
	<c:when test="${not empty genFooter}">
		<h3>로고 설정</h3>
		* 메인페이지에 보여질 푸터정보를 입력해주세요. <br><br>
		이메일 : <input type="text" class="form-control" name="email" required="required" value="${genFooter.email}"> <br>
		대표번화번호 : <input type="text" class="form-control" required="required" name="schTelNum" value="${genFooter.schTelNum}"> <br>
		팩스번호 : <input type="text" class="form-control" required="required" name="schFaxNum" value="${genFooter.schFaxNum}">

	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty schLogo}">
		<h3>로고 설정</h3>
		* 메인페이지에 보여질 로고이미지를 입력해주세요. <br><br>
		<input type="file" class="logoFile form-control" style="width:400px;" > 기존 파일명 : ${schLogo.fileName}
		<input type="hidden" class="beforeLogo" value="${schLogo.fileName}">

	</c:when>
</c:choose>



</form>





<script>
	bannerMake = $("#banMake");
	alertBrd = $("#alertBrd");
	bnrLk = $(".bnrLk");
	i = 0;
	lkDiv = $("#lkDiv");
	lkWidget = $(".lkWidget");
	j = 0;
	mkCald = $("#mkCald");
	mkImg = $("#mkImg");
	//console.log(bnrLk[0].id);

	//console.log(bnrLk.length);

	/*
	$(".brdRemove").on("click", function(){
	console.log("삭제클릭됨");
	console.log(this);

	console.log($(this).parent());

	$(this).parent().remove();
	});
	*/

	var testArr = [] ;
	
	
	 function fcopy(pThis,pNum){
	      console.log(pThis.children[0]);
	      let limg = pThis.children[0].cloneNode(true);  // dom 깊은 복사(내용까지 복사, true없으면 얕은복사 껍데기만)
	      document.querySelector("#merong"+pNum).innerHTML="";
	      document.querySelector("#merong"+pNum).appendChild(limg);

	      console.log($(limg).data("lk"));

	      ddd = $(limg).data("lk");

	      testArr[pNum-1] = ddd;

	      console.log(testArr);


	}

	function fnDeleteBrd(obj){
		$(obj).parent().remove();
	}

	function fnDeleteBnr(obj){
		$(obj).parent().remove();
	}
	function fnDeleteCald(obj){
		$(obj).parent().remove();
	}
	function fnDeleteImage(obj){
		$(obj).parent().remove();
	}


	function fnDeleteLk(obj, num){
		$(obj).parent().parent().remove();
		testArr[num-1] = "";
		//console.log("넘어온값 : ", num);
		//console.log("길이",testArr.length);
		//console.log("바꾸기전",testArr);

		//배열을 1칸씩 땡긴다.
		for(var i = num ; i <= testArr.length-1 ; i++){
			console.log(testArr);
			console.log(i,testArr[i-1], testArr[i] );
			testArr[i-1] = testArr[i];
		}
		//마지막 배열에 있는 값을 없애버린다. (사이즈가 1줄어듬.)
		testArr.pop();
		//console.log("바꾸기후",testArr);
	}
	

	$(document).ready(function(){
		
		$("#mkMainImg").on("click", function(){
			console.log("메인이미지 생성");
			
			mainImgs = $(".mainImgs");
			console.log(mainImgs.length);
			
			if(mainImgs.length < 3){
				var imgObj ="";
				imgObj += "<div class='mainImgs'> <br>";
				imgObj += "<input type='file' class='addImage form-control' style='width:400px;'>";
				imgObj += "<input type='button' class='btn btn-danger' onclick='fnDeleteImage(this);' value='이미지 삭제'>";
				imgObj += "</div>";
				
				console.log(imgObj);
				
				mkImg.append(imgObj);
			}else{
				console.log("갯수가 3개가 넘는다.")
			}
		})
		
		$("#makeCald").on("click", function(){
			console.log("일정생성");

			var caldObj = "";

			caldObj += "<div>";
			caldObj += "<input type='date' name='caldStartDate' > ";
			caldObj += "<input type='date' name='caldEndDate' > ";
			caldObj += "<input type='text' name='schedule'> &nbsp; ";
			caldObj += "<input type='button' class='caldRemove btn btn-sm btn-danger' value='달력삭제' onclick='fnDeleteCald(this);'>";
			caldObj += "</div>";



			mkCald.append(caldObj);


		})



		$("#lkMake").on("click", function(){
			console.log("링크위젯생성클릭");

			var lkWidget = $(".lkWidget");
			console.log(lkWidget.length);

			lkLength = lkWidget.length+1;

			if(lkWidget.length >= 6){
				console.log("링크위젯은 6개로 제한함");
			}else{
				console.log("링크위젯 사이즈 6보다 작음.");
				console.log(lkLength);


				var lkList="";

			    lkList  += " <div >";
				lkList	+= "	<div class='btn-group dropend me-1 mb-1'>";
				lkList	+= "		<button type='button' class='btn btn-secondary dropdown-toggle'";
				lkList	+= "			data-bs-toggle='dropdown' aria-haspopup='true' ";
				lkList	+= "			aria-expanded='false'>위젯 선택</button>";
				lkList	+= "		<div class='dropdown-menu' id='allForms' style='width:800px;'>";
				lkList	+= " 		<ul class='lList'>";
				<c:forEach items='${lkLstIconList}' var='lkLstIcon'>
				lkList	+= "				<li class='lItems'><a class='dropdown-item'  href='#' onclick='fcopy(this,"+lkLength+")'><img style='margin:20%;' width='50px' height='50' data-lk='${lkLstIcon.iconNm}' src='<%=request.getContextPath() %>/resources/templatesPreview/images/widget/${lkLstIcon.iconFileName}'></a></li>";
				</c:forEach>
				lkList	+= " 		</ul>";
				lkList	+= "		</div>";
				lkList	+= "	</div>";
				lkList	+= "	<div  id='merong"+lkLength+"' class='lkWidget' style='border: 1px solid black;width: 8%;height: 80px; float:left;'>";
				lkList	+= "	</div>";
				lkList	+= "		<div style='margin-left:8%; width:50%; padding: 2px 7px;'>";
				lkList	+= "        <input type='text' name='lkTitle'>";
				lkList	+= "		<input type='text' name='lkUrl' >";
				lkList	+= "		<input type='button' class='brdRemove btn btn-danger' value='링크위젯 삭제' onclick='fnDeleteLk(this,"+lkLength+");'>";
				lkList	+= "	</div>";
				/* lkList	+= "	<br>"; */
				lkList	+= "</div>";



				<%-- var lkList  = " <div >";
				lkList	+= "	<div class='btn-group dropend me-1 mb-1'>";
				lkList	+= "		<button type='button' class='btn btn-secondary dropdown-toggle'";
				lkList	+= "			data-bs-toggle='dropdown' aria-haspopup='true' ";
				lkList	+= "			aria-expanded='false'>위젯 선택😆</button>";
				lkList	+= "		<div class='dropdown-menu' id='allForms'>";
				<c:forEach items="${lkLstIconList}" var="lkLstIcon" >
				lkList	+= "				<a class='dropdown-item'  href='#' onclick='fcopy(this,'${status.count}')'><img width='50px' height='50' data-lk='${lkLstIcon.iconNm}' src='<%=request.getContextPath() %>/resources/templatesPreview/images/widget/${lkLstIcon.iconFileName}'></a>";
				</c:forEach>
				lkList	+= "		</div>";
				lkList	+= "	</div>";
				lkList	+= "	<div  id='merong${status.count}' class='lkWidget' style='border: 1px solid black;width: 8%;height: 80px;'>";
				lkList	+= "	</div>";
				lkList	+= "	<input type='text' name='lkUrl' >";
				lkList	+= "	<input type='button' class='brdRemove' value='링크위젯 삭제' onclick='fnDeleteLk(this,${status.count});'>";
				lkList	+= "	<br>";
				lkList	+= "</div>"; --%>



				//console.log(lkList);
				lkDiv.append(lkList);

			}
		});


		$("#brdMake").on("click", function(){
			//console.log("클릭됨");
			brd = $(".brd");
			console.log(brd.length);

			if(brd.length >= 10){
				console.log("길이가 10이 넘습니다.");
			}else{
				
				var objBrd = "<div class='brd' style='height:47px;'>";
				objBrd += "<input type='text' name='genAlertBrd'>  &nbsp;&nbsp;";
				objBrd += "<input type='button' class='btn btn-danger btn-sm brdRemove' value='알림판 삭제'  onclick='fnDeleteBrd(this);'> &nbsp;&nbsp;";
				objBrd += "<input type='file' class='alertFiles form-control form-control-sm'  style='display: inline; width: 300px;'>";
				/* objBrd += "<input type='text' class='alertData' > "; */
				
				objBrd += "<br></div>";

				alertBrd.append(objBrd);
			}
		});
/* 
					<div class="brd">
						<input type="text" name="genAlertBrd" value="${genAlertBrd.urlInfo}">
						<input type="file" class="alertFiles" >
						<input type="text" class="alertData" value="${genAlertBrd.fileName}"> 
						<input type="button" class="brdRemove" value="알림판 삭제" onclick="fnDeleteBrd(this);">
						<br>
					</div> */

		
		
		

		$("#bnrMake").on("click", function(){
			console.log("배너클릭됨");

			var bnrLks = $(".bnrLk");
			console.log("길이 : ", bnrLks.length);

			if(bnrLks.length >= 12){
				console.log("개수가 많다");
			}else{

				var objBan = "<div>";
				objBan += "<select name='bnrLk' class='bnrLk form-select' id='${genBnr.bnnrOrd}'>"
				objBan += "<c:forEach items='${bnrLkInfoList}' var='bnrLkInfo'>"
				objBan += "<option value='${bnrLkInfo.bnrLkId}'>${bnrLkInfo.bnrLkNm} </option>";
				objBan += "</c:forEach>";
				objBan += "</select>";
				objBan += "&nbsp;<input type='button' class='brdRemove btn btn-sm btn-danger m-2' value='배너삭제' onclick='fnDeleteBnr(this);'>";
/* 				objBan += "<br>"; */
				objBan += "</div>";

				bannerMake.append(objBan);
			}

			//var objBnr =

			/*brd = $(".brd");
			console.log(brd.length);



			if(brd.length >= 10){
				console.log("길이가 10이 넘습니다.");
			}else{

				var objFile = "<div class='brd'>";
				objFile += "<img src='' style='width:50px; height:50px;'>";
				objFile += "<input type='text' name='genAlertBrd'>";
				objFile += "<input type='file'>";
				objFile += "<input type='button' class='brdRemove' value='this 알림판 삭제' onclick='fnDelete(this);'><br>";
				objFile += "</div>";

				alertBrd.append(objFile);
			}		 */
		});



		<c:choose>

			<c:when test="${not empty brdWdgt1}">
				$("select[name='listBrdNum1']").find("option[value='"+"${brdWdgt1.brdNum}"+"']").attr("selected", true);
			</c:when>


			<c:when test="${not empty brdWdgtList2}">
				<c:forEach items="${brdWdgtList2}" var="brdWdgt2">
					var mType = "${brdWdgt2.brdNum}";
					if("${brdWdgt2.widgetOrd}"==2){
						$("select[name='listBrdNum2']").find("option[value='"+mType+"']").attr("selected", true);
					}
					if("${brdWdgt2.widgetOrd}"==3){
						$("select[name='listBrdNum3']").find("option[value='"+mType+"']").attr("selected", true);
					}
				</c:forEach>
			</c:when>

			<c:when test="${not empty imgBrdWdgt1}">
				$("select[name='listBrdNum4']").find("option[value='"+"${imgBrdWdgt1.brdNum}"+"']").attr("selected", true);
			</c:when>

			<c:when test="${not empty imgBrdWdgtList2}">
				<c:forEach items="${imgBrdWdgtList2}" var="imgBrdWdgt2">
					var mType = "${imgBrdWdgt2.brdNum}";
					if("${imgBrdWdgt2.widgetOrd}"==5){
						$("select[name='listBrdNum5']").find("option[value='"+mType+"']").attr("selected", true);
					}
					if("${imgBrdWdgt2.widgetOrd}"==6){
						$("select[name='listBrdNum6']").find("option[value='"+mType+"']").attr("selected", true);
					}
				</c:forEach>
			</c:when>

			<c:when test="${not empty videoBrdWdgtList1}">
				<c:forEach items="${videoBrdWdgtList1}" var="videoBrdWdgt1">
					var mType = "${videoBrdWdgt1.brdNum}";
					if("${videoBrdWdgt1.widgetOrd}"==7){
						$("select[name='listBrdNum7']").find("option[value='"+mType+"']").attr("selected", true);
					}
					if("${videoBrdWdgt1.widgetOrd}"==8){
						$("select[name='listBrdNum8']").find("option[value='"+mType+"']").attr("selected", true);
					}
				</c:forEach>
			</c:when>

			<c:when test="${not empty videoBrdWdgtList2}">
				<c:forEach items="${videoBrdWdgtList2}" var="videoBrdWdgt2">
					var mType = "${videoBrdWdgt2.brdNum}";
					if("${videoBrdWdgt2.widgetOrd}"==9){
						$("select[name='listBrdNum9']").find("option[value='"+mType+"']").attr("selected", true);
					}
					if("${videoBrdWdgt2.widgetOrd}"==10){
						$("select[name='listBrdNum10']").find("option[value='"+mType+"']").attr("selected", true);
					}
					if("${videoBrdWdgt2.widgetOrd}"==11){
						$("select[name='listBrdNum11']").find("option[value='"+mType+"']").attr("selected", true);
					}
				</c:forEach>
			</c:when>

			<c:when test="${not empty genBnrList}">
				<c:forEach items="${genBnrList}" var="genBnr" varStatus="status">
					var mType = "${genBnr.bnrLkId}";
					var mOrd = "${genBnr.bnnrOrd}";

					if(bnrLk[i].id == "${genBnr.bnnrOrd}"){
						$("select[id='${genBnr.bnnrOrd}']").find("option[value='"+mType+"']").attr("selected", true);
					}
					i = i + 1;
				</c:forEach>
			</c:when>

			<c:when test="${not empty genLkLstList}">
				<c:forEach items="${genLkLstList}" var="genLkLst" varStatus="status">
					var mType = "${genLkLst.iconNm}";
					var mOrd = "${genLkLst.widgetOrd}";

					console.log(lkWidget[j].id);
					//console.log(lkWidget[j]);
					console.log("${genLkLst.widgetOrd}");
					if(lkWidget[j].id == "merong"+"${genLkLst.widgetOrd}"){
						<c:forEach items="${lkLstIconList}" var="lkLstIcon" varStatus="status">

							//console.log("${lkLstIcon.iconNm}", "${genLkLst.iconNm}");
							if("${lkLstIcon.iconNm}" == "${genLkLst.iconNm}"){
								var aTag = "<img style='margin:20%' width='50px' height='50' data-lk='${lkLstIcon.iconNm}' src='<%=request.getContextPath() %>/resources/templatesPreview/images/widget/${lkLstIcon.iconFileName}'>";
								console.log(aTag);
								document.querySelector("#merong"+"${genLkLst.widgetOrd}").innerHTML += aTag;
								testArr[j] = "${lkLstIcon.iconNm}";

							}
						</c:forEach>
					}
					j = j + 1;
				</c:forEach>
			</c:when>


		</c:choose>





	})



</script>
