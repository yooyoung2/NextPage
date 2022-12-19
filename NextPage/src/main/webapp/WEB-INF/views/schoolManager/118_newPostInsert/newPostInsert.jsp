<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<script src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>
</head>
<div class="content">
<h3>문의하기</h3>
<form:form method="post" modelAttribute="myQuestion" enctype="multipart/form-data" id="ffrm">
	<form:input path="otoBrdTitle" name="otoBrdTitle" class="form-control" placeholder="제목" />
	<br>
	<form:textarea path="otoBrdCntnt" class="form-control"/>
	<br>
	<input disabled="disabled" hidden="hidden" id="boardWriter" value="${sessionScope.authSch}"/>
	<div style="margin-left:45%">
		<form:button type="button" class="btn btn-success" id="subBtn" >전송</form:button>

		<form:button type="reset" class="btn btn-danger">취소</form:button>
	</div>
<!-- 	<input type="file" name="" /> -->
	<script type="text/javascript">
		CKEDITOR.replace('otoBrdCntnt',{
			filebrowserUploadUrl:'${pageContext.request.contextPath }/school/manager/my/question/list/imageUpload?type=image'
		});

	</script>
</form:form>
</div>
<script>

$(document).ready(function() {

var form = $('#ffrm');

	  $("#subBtn").on("click", function(event){
			event.preventDefault();

			console.log("메시지 전송..");

			let socketMsg = ($('#boardWriter').val()+"," + $('[name=otoBrdNum]').val()+","+$('#boardWriter').val());
			console.log($('[name=otoBrdNum]').val());
			console.log( $('#boardWriter').val());
			console.log(socketMsg);
			webSocket.send(socketMsg);
	form.submit();	//이벤트 수행 후, form submit 진행

  });
});
</script>