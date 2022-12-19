<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

<%-- <link href="<%=request.getContextPath()%>/resources/css/History.css" --%>
<!-- 	rel="stylesheet" /> -->





<title>교직원 개별 수정</title>
</head>

<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<body>
<div class="content">
	<div id="all">
		<div id="historyNameArea">
			<h3>교직원 개별 수정</h3>
		</div>
		<div id="tableArea">										
			<form:form modelAttribute="member" method="post">
	<table class="table table-bordered">
		<tr>
			<th>이름</th>
			<td>
				<form:input path="memNm" class="form-control" required="true" />
				<form:errors path="memNm" element="span" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
				<form:input path="telNum" class="form-control" required="true" />
				<form:errors path="telNum" element="span" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<form:input path="memEmail" class="form-control" required="true" />
				<form:errors path="memEmail" element="span" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<form:input path="addr1" class="form-control" required="true" />
				<form:errors path="addr1" element="span" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td>
				<form:input path="addr2" class="form-control" required="true" />
				<form:errors path="addr2" element="span" cssClass="error" />
			</td>
		</tr>
		
		
	
		<tr>
			<td id="inputTags">
				<input type="submit" class="btn btn-primary insert" value="수정" />
				<input type="button" class="btn btn-primary insert" value="취소" onclick="cancelBtn();"/>
			</td>
		</tr>
		
		
		</table>
	</form:form>
	
	
	
	
	
	
	
	
		</div>
	</div>
	
	
</div>
</body>
<script>

function cancelBtn() {
	location.href="<%=request.getContextPath()%>/school/manager/teacher/insert"
}
</script>


