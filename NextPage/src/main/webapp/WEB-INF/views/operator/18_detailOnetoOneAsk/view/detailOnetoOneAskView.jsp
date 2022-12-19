<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>


input:focus{
    border-color:#0982f0;
    outline: none;
}

</style>


<%-- ${cmnt.cmntId eq cmnt.cmntId ? 'tttt' : 'fffff'}<br> --%>

	<form id="updateForm"action="${pageContext.request.contextPath}/operator/cmnt/modify" method="post">
		<table
			class="table text-start align-middle table-bordered table-hover mb-0">
			<thead class="thead-dark">
				<tr>
					<th>작성자</th>
					<th>답변내용</th>
					<th>작성일자</th>
				</tr>
			</thead>
			<tbody id="listBody">
				<tr>
					<td><input name="cmntId" value="${cmnt.cmntId}" readonly="readonly"></td>
					<td><input id="modiCntnt" name="cmmntCntnt"
						value="${cmnt.cmmntCntnt}"></td>
					<td>${cmnt.cmmntDate}</td>
					<input type="hidden" name="otoBrdNum" value="${cmnt.otoBrdNum }">
					<input type="hidden" name="cmmntId" value="${cmnt.cmmntId }">
				<td colspan="2">
			</tbody>
		</table>
			<input id="modi" type="submit" class="btn btn-success" value="완료">
<%-- 			<c:url value="cmntDelete" var="cmntViewURL"> --%>
<%-- 				<c:param name="what" value="${cmnt.cmntId}" /> --%>
<%-- 			</c:url> --%>
<%-- 			<a href="${cmntViewURL }"><button type="button" class="btn btn-danger">삭제</button></a> --%>
			<input type="reset" value="취소" class="btn btn-warning" />
	</form>

