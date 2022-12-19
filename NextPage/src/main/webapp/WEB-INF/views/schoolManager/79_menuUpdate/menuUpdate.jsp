<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
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
<form id='updateForm' action="/NextPage/school/manager/menu/update" method="post">
	<div>
		<div class="menuAdd">
			<div class="menuAdd2">*메뉴명</div>
			<div class="menuAdd3"><input type="text" id="menuNm" value="${respMenu['menuNm'] }" class="form-control"> </div>
		</div>
		<div class="menuAdd">
			<div class="menuAdd2">상위메뉴</div>
			<div class="menuAdd3">
				<c:if test="${empty respMenu['topMenuNm'] }">
             	 * 최상위 메뉴는 상위메뉴가 없습니다.
            	</c:if>
				<c:if test="${not empty respMenu['topMenuNm'] }">
					${respMenu['topMenuNm'] }
					<br/> * 생성된 부모 메뉴를 의미합니다.	
				</c:if>
			<br/> 
			</div>
		</div>
		<div class="menuAdd">
			<div class="menuAdd2">*메뉴접근권한</div>
			<div class="menuAdd3"><input type="checkbox" name="box[]" class="checkSelect" value="EDUPSN" > 교직원 
				<input type="checkbox" name="box[]" class="checkSelect" value="STUD"> 학생 
				<input type="checkbox" name="box[]" class="checkSelect" value="PRNT"> 학부모
				<input type="checkbox" name="box[]" class="checkSelect" value="NORMAL"> 일반회원
				<input type="checkbox" name="box[]" class="checkSelectAll" value="NONE"> 전체
				<input type="checkbox" name="box[]" value="SCH" hidden="true">
			</div>
		</div>
		<div id="searchMenu" class="menuAdd">
			<div class="menuAdd2">*메뉴타입</div>
			<div class="menuAdd3">
				<select name="menuType" id="select1" class="choices form-select choices__input" style="width: 27%;">
					<option value="noType">타입없음</option> 
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
				<select name="menuName" id="optList" class="ckBoxs form-select" style="display:none; width: 71%; float: right; ">
					<!-- <option value>목록</option> -->
				</select>
				<input type="text" id="menuLink" style="display:none; width: 71%; float: right;" value="#" class="form-control" value="#">
			</div>
		</div>
		<div class="menuAdd">
			<div class="menuAdd2">*메뉴사용여부</div>
			<div class="menuAdd3">
				<div>
					<input type="radio" name="radioList" value="YES"> 사용 
					<input type="radio"	name="radioList" value="NO" > 미사용
				</div>
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


	changeSecondMenu = $("#searchMenu").on("change", "[name=menuName]", function(event){
		secondNum = $(this).val(); 
		console.log("두번째 옵션 선택", secondNum);
	})


	function fn_changeSecond(scndMenuNum){
		console.log("두번째 셀렉터", scndMenuNum,"번을 골라야함.");
		
		
		
		/* $('.ckBoxs').val(scndMenuNum).trigger('selected');
		$('.ckBoxs').val(scndMenuNum).trigger('change');
		$('.ckBoxs').val(scndMenuNum).trigger('click'); */
		/* $('.ckBoxs').val(scndMenuNum); */
		//$('select[name="menuName"]').find('option[value='+scndMenuNum+']').prop("selected",true); 
		 $('.ckBoxs')[0].value=scndMenuNum;  
		
		
		
	}
	
	$(document).ready(function(){
		$("input[id=menuLink]").val("");
		
		var ckRadio = "${respMenu['menuUseOk']}";
		$("input[name='radioList'][value="+ckRadio+"]").prop("checked", true);
		
		var mType = "${respMenu['menuType']}";				
		$("select[name='menuType']").find("option[value='"+mType+"']").attr("selected", true);
		
		var ckList = "${authMemList}";
		var splitCode = ckList.split(',');
		for(var idx in splitCode){
			
			$("input[name='box[]'][value=" + splitCode[idx] + "]").attr("checked", true);
			//console.log("스플릿 : " + splitCode[idx]);
			
			if(splitCode[idx]=="NONE"){ 
				//$("input[name='box[]'][value=" + splitCode[idx] + "]").attr("checked", true);
				$("input[name='box[]']").attr("disabled", true);
				$("input[name='box[]'][value=" + splitCode[idx] + "]").attr("disabled", false);
			}
		}
		
		var scndMenu = "${respMenu['menuLink']}";
		console.log("링크일때",scndMenu);
		
		
		
		scndMenuNum = 0;
		//board or contents일때 글번호 가져옴.
		if(!(mType=="link")){
			scndMenuNum = scndMenu.substring(scndMenu.indexOf("=")+1);
			console.log("게시물번호 or 컨텐츠번호",scndMenuNum);
			
		}else{
			//링크값 가져오기(링크일때만)
			$("input[id=menuLink]").val(scndMenu);
		}
		
		var select1 = $("#select1");
		
		console.log("select1번",select1);
		
		//1차셀렉터내의 옵션을 고르고 난뒤 2차 옵션을 만드는 부분.
		select1.change(function(){
			
			var result = $("#select1 option:selected").val();
			fn_changeSelect(result,scndMenuNum); 
			
			
		}).trigger('change');
		
		
		
		//2차 셀렉터 만들고난뒤 해당 글번호 고르기. 시퀸스상 여기에서 제어하고 싶어서 약간의 딜레이 타임을 주어서 해결함(0.05초)
		// 만약 아작스가 시간이 오래 걸리면 문제가 될 수도 있음
		setTimeout(fn_changeSecond,200,scndMenuNum);
		//fn_changeSecond(scndMenuNum);
		
	});
	 
	
	optList = $("#optList");
	menuLink = $("#menuLink");
	
	searchMenu = $("#searchMenu").on("change", "[name=menuType]", function(event){
	menuType = $(this).val();
	console.log("메뉴타입변경중",menuType);
	
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
				menuLink.attr("value", "/generation//board?brdNum=");
				
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
				menuLink.attr("value", "#");
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
				console.log("교가");
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
		
			menuNameTag.find("option").remove();
			menuNameTag.append(options);
			//$('.ckBoxs')[0].value="2";
		},
		error : function(errorResp) {
			console.log(errorResp.status);
			}
		});
	});
	

	
	function fn_changeSelect(selectItem,scndMenuNum){
		console.log("두번째 쎌렉터 생성시작");
		$.ajax({
			url : "${pageContext.request.contextPath}/school/manager/menu/menuType",
			data : {
				menuType : selectItem
			},
			dataType : "json",
			success : function(resp) {
				optList.hide();
				menuLink.hide();
				
				console.log(resp);
				let options = [];
				
				
				if(menuType == "board"){
					optList.show();
					//console.log("게시판응답시작")
					genBoardList = resp.options;
					//console.log(genBoardList);
					$.each(genBoardList, function(index, genBoard){
						/* console.log("디비값", scndMenuNum);
						console.log("전체값", genBoard.brdNum); */
						let option = "";
						option = $("<option>").attr("value", genBoard.brdNum )
								    		  .text(genBoard.brdTitle+"(게시판 아이디: " + genBoard.brdNum + ")");		
						options.push(option);
						//console.log(genBoard.brdNum, "   ", genBoard.brdTitle)
					});
					//menuLink.attr("value", "/generation//board?brdNum="+genBoard.brdNum);
					menuLink.attr("value", "/generation//board?brdNum=");
					
				}else if(menuType == "contents"){
					optList.show();
					//console.log("콘텐츠응답시작")
					genCntntList = resp.options;
						$.each(genCntntList, function(index, genCntnt){
						let option = $("<option>").attr("value", genCntnt.cntntsId )
//											  .prop("selected",true)
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
					menuLink.attr("value", "#");
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
				
		/* 		 console.log("pppp",$('.ckBoxs')[0]);
				
				 $('.ckBoxs')[0].value="2";   */
				
			},
			error : function(errorResp) {
				console.log(errorResp.status);
				}
			});
	}

	
</script>




