
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
table,tr,th,td{
	border:1px solid gray;
}
#aBtn:hover{
	color: white;
}
#aBtn{
	color: white;
}
</style>
<div class="content">
<h2>게시판 추가</h2>
<form:form modelAttribute="genBoard" method="post">

<table class="table table-bordered">
 <h4>[게시판 기본설정] 항목</h4>
	<tr>
		<th>게시판명</th>
		<td><form:input path="brdTitle" name="brdTitle" class="form-control" id="select3" style="background-color: #f3eeee;" required="required"/></td>
		<th>게시판 타입</th>
		<td>
			<form:select path="brdTypeId" class="form-control" id="select1" onchange="itemChange()" name="brdTypeId" >
				<form:option value="1" selected="selected">일반게시판</form:option>
				<form:option value="2">이미지게시판</form:option>
				<form:option value="3">동영상게시판</form:option>
			</form:select>
		</td>
	</tr>

	<tr>
		<th>한페이지 게시물 개수</th>
		<td>
			<form:select path="pagePostNum" class="form-control" id="select2" name="pagePostNum" >
				<form:option value="5">5</form:option>
				<form:option value="10" selected="selected">10</form:option>
				<form:option value="15">15</form:option>
				<form:option value="20">20</form:option>
			</form:select>
		</td>
		<th>첨부파일 최대 개수</th>
		<td>
			<form:select path="attachNum" class="form-control" id="select4" name="attachNum">
				<form:option value="3">3개</form:option>
				<form:option value="5">5개</form:option>
				<form:option value="10" selected="selected">10개</form:option>
			</form:select>
		</td>
	</tr>

	<tr class="tr1">
		<th>공지 사용 유무</th>
		<td>
			<form:radiobutton path="notisBtnWhthr" name="notisBtnWhthr" value="YES"/>사용
			<form:radiobutton path="notisBtnWhthr"  name="notisBtnWhthr" value="NO" checked="true"/>미사용
		</td>
		<th>비밀글 사용 유무</th>
		<td>
			<form:radiobutton path="scrtWriteWhthr" name="scrtWriteWhthr" value="YES"/>사용
			<form:radiobutton path="scrtWriteWhthr"  name="scrtWriteWhthr" value="NO" checked="true"/>미사용
		</td>
	</tr>
	<tr>
		<th>익명 사용 유무</th>
		<td>
			<form:radiobutton path="anmtWhthr" name="anmtWhthr" value="YES"/>사용
			<form:radiobutton path="anmtWhthr" name="anmtWhthr" value="NO" checked="true"/>미사용
		</td>
		<th>댓글 사용 유무</th>
		<td>
			<form:radiobutton path="cmmntWhthr" name="cmmntWhthr" value="YES"/>사용
			<form:radiobutton path="cmmntWhthr"  name="cmmntWhthr" value="NO" checked="true"/>미사용
		</td>
	</tr>
</table>

<br>
<h4>[게시판 고급설정] 항목</h4>
<table class="table table-bordered">
	<tr>
		<th>게시판상단 notice 문구</th>
		<td>
			<form:radiobutton path="notisWhthr"  name="notisWhthr" value="YES"/>사용
			<form:radiobutton path="notisWhthr" name="notisWhthr" value="NO" checked="true"/>미사용
		</td>
		<th>진행현황 표시여부</th>
		<td>
			<form:radiobutton path="prgrsCndtn" name="prgrsCndtn" value="YES"/>사용
			<form:radiobutton path="prgrsCndtn"  name="prgrsCndtn" value="NO" checked="true"/>미사용
		</td>
	</tr>
</table>

<h4>권한 설정</h4><p>※비회원은 읽기 권한만  설정 가능합니다.</p>
<table class="table table-bordered table-strip">
	<thead class="table-dark">
	<tr>
		<th>게시물 열람 권한</th>
		<td>
			<form:checkbox path="BRWS" name="BRWS[]" class="checkSelect1" value="STUD"/>학생
			<form:checkbox path="BRWS" name="BRWS[]" class="checkSelect1" value="PRNT"/>학부모
			<form:checkbox path="BRWS" name="BRWS[]" class="checkSelect1" value="EDUPSN"/>교직원
			<form:checkbox path="BRWS" name="BRWS[]" class="checkSelect1" value="NORMAL"/>일반
			<form:checkbox path="BRWS" name="BRWS[]" class="checkSelect1" value="NONE" id="selectedAll"/>전체(비회원포함)
<!-- 			<input type="checkbox" name= "BRWS[]" id="selectedAll"/> -->
			<form:checkbox path="BRWS" name="BRWS" value="SCH" checked="checked" hidden="true"/>
		</td>
	</tr>
	<tr>
		<th>게시물 글쓰기 권한</th>
		<td>
			<form:checkbox path="WRTE"  name="WRTE[]" class="checkSelect2" value="STUD"/>학생
			<form:checkbox path="WRTE"  name="WRTE[]" class="checkSelect2" value="PRNT"/>학부모
			<form:checkbox path="WRTE"  name="WRTE[]" class="checkSelect2" value="EDUPSN"/>교직원
			<form:checkbox path="WRTE" name="WRTE[]" class="checkSelect2" value="NORMAL"/>일반
			<form:checkbox path="WRTE"  name="WRTE[]" class="checkSelect2" value="SCH" checked="checked" hidden="true"/>
		</td>
	</tr>
	<tr id="notNormal">
		<th>비밀글 열람 권한</th>
		<td>
			<form:checkbox path="SCRT" name="SCRT[]" class="checkSelect3" value="STUD"/>학생
			<form:checkbox path="SCRT" name="SCRT[]" class="checkSelect3" value="PRNT"/>학부모
			<form:checkbox path="SCRT" name="SCRT[]" class="checkSelect3" value="EDUPSN"/>교직원
			<form:checkbox path="SCRT" name="SCRT[]" class="checkSelect3" value="NORMAL"/>일반
			<form:checkbox path="SCRT" name="SCRT[]" class="checkSelect3" value="SCH" checked="checked" hidden="true"/>
		</td>
	</tr>
	<tr>
		<th>댓글쓰기 권한</th>
		<td>
			<form:checkbox path="CMMNT" name="CMMNT[]" class="checkSelect4" value="STUD"/>학생
			<form:checkbox path="CMMNT" name="CMMNT[]" class="checkSelect4" value="PRNT"/>학부모
			<form:checkbox path="CMMNT" name="CMMNT[]" class="checkSelect4" value="EDUPSN"/>교직원
			<form:checkbox path="CMMNT" name="CMMNT[]" class="checkSelect4" value="NORMAL"/>일반
			<form:checkbox path="CMMNT" name="CMMNT[]" class="checkSelect4" value="SCH" checked="checked" hidden="true"/>
		</td>
	</tr>
	</thead>
</table>
<form:button type="submit" class="btn btn-success" >추가</form:button>
<form:button type="submit" class="btn btn-danger"><a id="aBtn" href="javascript:history.go(-1)"/>취소</form:button>

<%-- <form:input type = "hidden" name="" value=""> --%>

</form:form>
</div>
<br>
<br>



<script>
/*   viewForm = $("form").on("submit", function(event){

	event.preventDefault();
	arr = $('input[name=BRWS]:checked').serializeArray().map(function(item) { return item.value });
	alert(arr);
	return false;
}); */

	function itemChange(){
		var normal = ["5","10","15","20"];
		var image = ["3X3","4X2"];
		var video = ["3X3","4X2"];

		var selectItem = $("#select1").val();

		var changeItem;

		if(selectItem == "1"){
			changeItem = normal;
		}
		else if(selectItem == "2"){
			changeItem = image;
		}
		else if(selectItem == "3"){
			changeItem = video;
		}

		$("#select2").empty();

		for(var count = 0; count < changeItem.length; count++){
			var option = $("<option value="+changeItem[count]+">"+ changeItem[count]+"</option>");
			$("#select2").append(option);
		}


	}

	$('input[id=selectedAll]').on('change', function(){
		  $('.checkSelect1').prop('checked', this.checked);
/*		  disabled = $('.checkSelect1').prop('checked');
  		  if(disabled){
			  console.log("true");
			  $('.checkSelect1').prop('disabled', true);
		  }else{
			  $('.checkSelect1').prop('disabled', false);
		  }  */
		});
	  arr = $('input[name=BRWS]:checked').serializeArray().map(function(item) { return item.value });

	$(document).ready(function(){
		$("#select1").change(function(){
			var result = $("#select1 option:selected").val();
			console.log(result);
			if(result ==1){
				console.log("일반게시판 true");
				$(".tr1").show();
			}else{
				console.log("일반게시판 false");
				$(".tr1").hide();
			}
		});
	});

</script>

