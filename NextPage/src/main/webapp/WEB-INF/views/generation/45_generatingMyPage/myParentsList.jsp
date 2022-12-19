<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.ftco-section{
	margin-top:5%;
}
</style>

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="table-wrap">
					<table id="approvalTable" class="table table-striped">
						<thead>
							<tr>
								<th>학부모 ID</th>
								<th>학부모 이름</th>
								<th>권한 승인 현황</th>
							</tr>
						</thead>
						
						<tbody id="listBody">
							<c:choose>
								<c:when test="${not empty parentsList }">
									<c:forEach items="${parentsList}" var="prnt">
										<tr>
											<td>${prnt.prntId }</td>
											<td>${prnt.memNm}</td>
											<td>${prnt.approvalOk}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3">신청 내역 없음</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
