<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.col-md-5 {
    margin-top: 10%;
}
.form-control, label{
	border-color : black;
	color:black;
	width: 270px;
}

#addBox{
	margin-top:23px;
	border: 2px solid black;
	border-radius: 10px;
	width : 400px;
	height: 200px;
	padding-top: 13%;
    padding-left: 4%;
}
	
}
.textTag{
	width : 230px;
}
.labelBox{
	width : 25%;
	float : left;
}
.inputBox{
	width : 50%;
	float : left;
}
.btnRemove{
	float : right;
	margin-top:5%;
}
#chck{
	width : 80px;
	margin-left:6%;
}
#sub{
	width : 80px;
	float:right;
}
</style>

<!-- ===================================== -->
<!-- 				자녀 확인 구역			   -->
<!-- ===================================== -->

<div class="col-md-5">
	<div class="col-md-12 form-group">
		<input type="button" value="추가" class="btn btn-light" id="chck" onclick="form_add()">
		<input type="button" value="신청" class="btn btn-success" id="sub" onclick="form_send()">
		<div class="first" id="addBox">
			<div id="inputList" class="inputList col-md-12 form-group cdck">
				<div class="labelBox">
					<label for="studNm">자녀이름</label>
				</div>
				<div class="textBox">
					<input type="text" name="studNm" class="textTag">
				</div>
				<hr>
				<div class="labelBox">
					<label for="studNum">자녀학번</label>
				</div>
				<div class="textBox">
					<input type="text" name="studId" class="textTag">
				</div>
			</div>
		</div>
	</div>
</div>

<script
	src="<%=request.getContextPath()%>/resources/templates/template01/template01Index/js/main.js"></script>

<script type="text/javascript">

let box = document.querySelector("#addBox");
let list = document.querySelector("#inputList");
var i = 1; // 변수설정은 함수의 바깥에 설정!
// 
function form_add(){
    let boxClone = box.cloneNode(true);
    list.appendChild(boxClone);
    $("#inputList").append("<button type='button' class='btnRemove btn btn-danger' onclick='form_remove()'>△삭제하기</button>");
    i++;
}

function form_remove(){
	if(i>1){
		$('#addBox').remove();
	}
}
 function form_send(){
     // 먼저 보낼 데이터 형식으로 만들어야 함,  [{hname:,hbun:}.....]
     let inputList = document.querySelectorAll(".inputList");	// inputList div안에 input들
     let dataList = [];
     for(let i=0; i<inputList.length; i++){
         console.log(inputList[i].children[1]);
         let stud = {};
         stud.studNm = inputList[i].children[1].value;
         stud.studId = inputList[i].children[3].value;
         dataList.push(stud);
     }

     console.log(dataList); // 항상 중간 중간에 누느로 데이터를 화긴하는 습관!
	
     var schId = '<%=(String) session.getAttribute("id")%>';
     
      $.ajax({
         type:"post",
         url:"${pageContext.request.contextPath}/generation/"+schId+"/generatingMyPage/enrollPrnt/insert",
         data: JSON.stringify(dataList),
         contentType:"application/json; charset=utf-8",
         dataType:"html",
         success: function(data){
             alert(data)
         },
         error:function(error){
             alert("오류");
         }
     }) 
 }

</script>