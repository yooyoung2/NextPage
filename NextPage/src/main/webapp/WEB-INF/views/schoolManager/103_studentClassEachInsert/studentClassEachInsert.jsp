<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

<%-- <link href="<%=request.getContextPath()%>/resources/css/History.css" --%>
<!-- 	rel="stylesheet" /> -->





<title>교직원 개별등록</title>
</head>

<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<body>


<div class="content">
	<div id="all">
		<div id="historyNameArea">
			<h3>학생 학년-반</h3>
		</div>
		<br>
		<h5>※ 이미 등록된 교사중 학년 반이 현재 등록하려는 학년 반을 초과할 경우 <label style="color:red;">초기화 될 수 있습니다!! ※</label></h5>
		<h5>※ 학년 반을 입력하실 때 학년-반 형식으로 입력해주세요!! ex) 3-6 </h5>
		<br>
		<div id="tableArea">
			<form:form modelAttribute="member" method="post">
	<table class="table table-bordered">
		<tr>
			<th>학년-반</th>
			<td>
				<form:input path="classes" class="form-control" required="true" />
				<form:errors path="classes" element="span" cssClass="error" />
			</td>
		</tr>
		
		
		
	
		<tr>
			<td id="inputTags">
				<input type="submit" class="btn btn-primary insert" value="등록" />
				<input type="button" class="btn btn-primary insert" value="취소" onclick="cancelBtn();"/>
			</td>
		</tr>
		
		</table>
	</form:form>
		</div>
	</div>
</div>
</body>

<c:if test="${command eq 'UPDATE' }">
	<script type="text/javascript">
		$(":input:not(.editable)").prop("readonly", true);
	</script>
</c:if>


<script>
function cancelBtn() {
	location.href="<%=request.getContextPath()%>/school/manager/studentClass/insert"
}
</script>
