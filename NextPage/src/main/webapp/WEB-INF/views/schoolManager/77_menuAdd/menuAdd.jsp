<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
.menuAdd{
	background-color: #d1d2d385;
    margin-bottom: 1%;
    padding: 12px 30px;
    border-radius: 5px;
}
.menuAdd2{
	float: left;
    font-family: sans-serif;
    font-weight: 600;
    font-size: larger;
/*     color: white; */
}
.menuAdd3{
	margin-left: 25%;
/* 	color: ghostwhite; */
}
</style>
<form id='addForm' action="/NextPage/school/manager/menu/add" method="post">
	<div>
		<div class="menuAdd">
			<div class="menuAdd2">*메뉴명</div>
			<div class="menuAdd3"><input type="text" id="menuNm" class="form-control"></div>
		</div>
		<div class="menuAdd"> 
			<div class="menuAdd2">상위메뉴</div>
			<div class="menuAdd3">${genMenu['menuNm']}<br /> * 생성할 메뉴의 부모 메뉴를 의미합니다.</div>
		</div>
		<div class="menuAdd">
			<div class="menuAdd2">*메뉴접근권한</div>
			<div class="menuAdd3">
				<input type="checkbox" name="box[]" class="checkSelect" value="EDUPSN"> 교직원 
				<input type="checkbox" name="box[]" class="checkSelect" value="STUD"> 학생 
				<input type="checkbox" name="box[]" class="checkSelect" value="PRNT"> 학부모
				<input type="checkbox" name="box[]" class="checkSelect" value="NORMAL"> 일반회원
				<input type="checkbox" name="box[]" class="checkSelectAll" value="NONE"> 전체
				<input type="checkbox" name="box[]" value="SCH" checked="checked" hidden="true" >
			</div>
		</div>
		<div id="searchMenu" class="menuAdd">
			<div class="menuAdd2">*메뉴타입</div>
			<div class="menuAdd3">
				<select name="menuType" class="choices form-select choices__input" style="width: 27%;">
					<option value="noType" selected="selected">타입없음</option> 
					<option value="board">게시판</option>
					<option value="contents">콘텐츠</option>
					<option value="link">링크</option>
					<option value="greeting">학교장인사말</option>
					<option value="schHistory">학교연혁</option>
					<option value="symbol">학교상징</option>
					<option value="EDUPSNintro">교직원소개</option>
					<option value="schSong">교가</option>
					<option value="Directions">오시는길</option>
				</select > 
				<select name="menuName" id="optList" style="display:none; width: 71%; float: right; " class="form-select">
					<!-- <option value>목록</option> -->
				</select>
				<input type="text" id="menuLink" style="display:none; width: 71%; float: right;" value="#" class="form-control" >
			</div>
		</div>
		<div class="menuAdd">
			<div class="menuAdd2">*메뉴사용여부</div>
			<div class="menuAdd3">
				<input type="radio" name="radioList" value="YES"> 사용 
				<input type="radio"	name="radioList" value="NO" checked> 미사용
			</div> 			
		</div>
	</div>
</form>

<script>
		$('input[class=checkSelectAll]').on('change', function(){
		  $('.checkSelect').prop('checked', this.checked);
		  console.log( $('.checkSelect').prop('checked'));
		  disabled = $('.checkSelect').prop('checked');
		  if(disabled){
			  console.log("true");
			  $('.checkSelect').prop('disabled', true);
		  }else{
			  $('.checkSelect').prop('disabled', false);
		  }
		  
		});


		optList = $("#optList");
		menuLink = $("#menuLink");
		
		changeSecondMenu = $("#searchMenu").on("change", "[name=menuName]", function(event){
			secondNum = $(this).val(); 
			console.log("두번째 옵션 선택", secondNum);
		})
		
	 searchMenu = $("#searchMenu").on("change", "[name=menuType]", function(event){
		menuType = $(this).val();
		//console.log(menuType);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/school/manager/menu/menuType",
			data : {
				menuType : menuType
			},
			dataType : "json",
			success : function(resp) {
				optList.hide();
				menuLink.hide();
				
				console.log(resp);
				let options = [];
				
				//debugger;
				
				if(menuType == "board"){
					optList.show();
					//console.log("게시판응답시작")
					genBoardList = resp.options;
					//console.log(genBoardList);
					$.each(genBoardList, function(index, genBoard){
					let option = $("<option>").attr("value", genBoard.brdNum )
											  .text(genBoard.brdTitle+"(게시판 아이디: " + genBoard.brdNum + ")");
					options.push(option);
					//console.log(genBoard.brdNum, "   ", genBoard.brdTitle)
					});
					//menuLink.attr("value", "/generation//board?brdNum="+genBoard.brdNum);
					menuLink.attr("value","/generation//board?brdNum=");
					
				}else if(menuType == "contents"){
					optList.show();
					//console.log("콘텐츠응답시작")
					genCntntList = resp.options;
					$.each(genCntntList, function(index, genCntnt){
					let option = $("<option>").attr("value", genCntnt.cntntsId )
											  .text(genCntnt.cntntsTitle + "(콘텐츠 아이디 : " +genCntnt.cntntsId +")");
					options.push(option);
					});
					//menuLink.attr("value", "/generation//contents?cntntsId="+genCntnt.cntntsId);
					menuLink.attr("value", "/generation//contents?cntntsId=");
				}else if(menuType == "link"){
					menuLink.attr("value", "");
					menuLink.show();
					console.log("링크응답시작")
					let option = $("<option>").attr("name", menuType )
											  .attr("id", "linkMenu")
					  						  .text(menuType);
					options.push(option);
					
				}else if(menuType == "noType"){
					let option = $("<option>").attr("name", menuType )
											  .text("#");
					options.push(option);
					
				}else if(menuType == "greeting"){
					console.log("학교장인사말")
					let option = $("<option>").attr("value", menuType )
					 						  .text(menuType);
					options.push(option);
					menuLink.attr("value", "/generation//hello");
					
				}else if(menuType == "schHistory"){
					console.log("연혁")
					let option = $("<option>").attr("value", menuType )
					 						  .text(menuType);
					options.push(option);
					menuLink.attr("value", "/generation//history");
					
				}else if(menuType == "symbol"){
					console.log("학교상징")
					let option = $("<option>").attr("value", menuType )
					 						  .text(menuType);
					options.push(option);
					menuLink.attr("value", "/generation//symbol");
					
				}else if(menuType == "EDUPSNintro"){
					console.log("교직원소개")
					let option = $("<option>").attr("value", menuType )
					 						  .text(menuType);
					options.push(option);
					menuLink.attr("value", "/generation//teacher/intro");
					
				}else if(menuType == "schSong"){
					console.log("교가")
					let option = $("<option>").attr("value", menuType )
					 						  .text(menuType);
					options.push(option);
					menuLink.attr("value", "/generation//school/song");
					
				}else if(menuType == "Directions"){
					console.log("오시는길")
					let option = $("<option>").attr("value", menuType )
					 						  .text(menuType);
					options.push(option);
					menuLink.attr("value", "/generation//direction");
				}
				
				let menuNameTag = searchMenu.find("[name=menuName]");
				/* menuNameTag.find("option:not(:first)").remove(); */
				menuNameTag.find("option").remove();
				menuNameTag.append(options);

			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});
	});
	
	
</script>