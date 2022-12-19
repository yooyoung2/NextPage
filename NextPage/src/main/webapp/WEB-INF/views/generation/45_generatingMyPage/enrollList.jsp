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
					<table class="table table-striped">
						<thead>
							<tr>
								<th>자녀 학번(ID)</th>
								<th>자녀 이름</th>
								<th>승인 여부</th>
							</tr>
						</thead>
						<%-- <c:set var="prodList" value="${cartList.prodList }"></c:set> --%>
						<tbody id="listBody">
							<c:choose>
								<c:when test="${not empty childList }">
									<c:forEach items="${childList}" var="child">
										<tr>
											<td>${child.studId}</td>
											<td>${child.memNm}</td>
											<td>${child.approvalOk}</td>
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


