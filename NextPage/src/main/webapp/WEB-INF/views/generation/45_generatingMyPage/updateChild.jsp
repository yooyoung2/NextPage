<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


							
<!-- ===================================== -->
<!-- 				자녀 확인 구역			   -->
<!-- ===================================== -->
	<div class="col-md-12 form-group">
		<p>부/모</p>
		<label><input type="radio" name="fm" value="부">부</label>
		<label><input type="radio" name="fm" value="모">모</label>
	</div>
	<div class="col-md-12 form-group" style="background-color: gray; color: white;">
		<div class="first">
			<button type="button" class="btn-sm" id=chck>자녀인증</button>
			<div class="col-md-12 form-group cdck">
				<label for="studNm">자녀이름</label>
					<input type="text" name="cdname" class="form-control form-control-sm" placeholder="내용을 입력해주세요">
				<label for="studNum">자녀학번</label>
					<input type="text" name="cdnum" class="form-control form-control-sm" placeholder="내용을 입력해주세요">
			</div>
		</div>
	</div>
<script	src="<%=request.getContextPath()%>/resources/templates/template01/template01Index/js/main.js"></script>

<script type="text/javascript">

// 자녀 확인 칸 추가 하는곳
$(document).ready(function() {
	var i = 1; // 변수설정은 함수의 바깥에 설정!
	$("#chck").click(function() {
		$(".first").append(
			"<div class='col-md-12 form-group cdck' ><label for='email'>자녀이름</label>"
			+ "<input type='cdname' id='cdname' class='form-control form-control-sm' placeholder='내용을 입력해주세요'>"
			+ "<label for='cdnum'>자녀학번</label>"
			+ "<input type='text' id='cdnum' class='form-control form-control-sm' placeholder='내용을 입력해주세요'></div>"
			+ "<button type='button' class='btnRemove'>삭제하기</button>"
			);
		$(".btnRemove").on("click",function() {
			if(i = 1){
				$(".btnRemove").attr('disable',true);
			}else{
				$(this).prev().remove();
				$(this).next().remove();
				$(this).remove();
			}
		});
		i++; // 함수 내 하단에 증가문 설정
	});
});
</script>

