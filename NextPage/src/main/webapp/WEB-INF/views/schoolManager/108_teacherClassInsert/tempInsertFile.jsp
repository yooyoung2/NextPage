<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  

	<form:form method="post" modelAttribute="board" enctype="multipart/form-data">  
<table class="table table-bordered">
	<tr>
		<th>첨부파일</th>
		<td>
			<input type="file" name="boFiles" />
			<input type="file" name="boFiles" />
			<input type="file" name="boFiles" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<form:button type="submit" class="btn btn-success">전송</form:button>
			<form:button type="reset" class="btn btn-danger">취소</form:button>
		</td>
	</tr>
</table>
</form:form>
