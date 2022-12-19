<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<title>학교관리자 인덱스</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
.h3 {
	float: left;
}
</style>

<div class="content">
	<div class="page-heading card text-center" style="width: 40%;">
		<h3>&#127979;환영합니다. ${sessionScope.authSch}님!&#127979;</h3>
	</div>
	<!--  Inverse table start -->
	<section class="section">
		<div class="row" id="table-inverse">
			<div class="col-12">
				<div class="card">
					<div class="card-header" style="height: 65px;">
						<h4 class="card-title">공지사항</h4>
						<button type="button" class="btn btn-primary rounded-pill"
							style="margin: 15px; margin-top: -6%; margin-left: 10%;">
							<a
								href="${pageContext.request.contextPath }/nextpage/service/memcenter.do"
								style="color: white;">바로가기</a>
						</button>
					</div>
					<div class="card-content">
						<!-- 공지사항 게시판 -->
						<div class="table-responsive">
							<table class="table table-light mb-0">
								<thead>
									<tr>
										<th>No</th>
										<th width="60%">제목</th>
										<th>작성자</th>
										<th>작성일자</th>
										<th>첨부파일</th>
									</tr>
								</thead>
								<c:set var="notiList" value="${memberCenter.dataList }"></c:set>
								<tbody id="listBody">
									<c:choose>
										<c:when test="${not empty notiList }">
											<c:forEach items="${notiList}" var="noti">
												<tr>
													<td>${noti['notisNum'] }</td>
													<td><a
														href="<%=request.getContextPath() %>/nextpage/PostingView.do?who=${noti['notisNum'] }">${noti.notisTitle}</a></td>
													<td>${noti.adminId}</td>
													<td>${noti.notisWrteDate}</td>
													<td>${noti.saveName}</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="5">공지사항 없음</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
						<div class="card-header" style="height: 65px;">
							<h4 class="card-title">Next FAQ</h4>
							<button type="button" class="btn btn-primary rounded-pill"
								style="margin: 15px; margin-top: -6%; margin-left: 12%;">
								<a
									href="${pageContext.request.contextPath }/nextpage/user/faqList"
									style="color: white;">바로가기</a>
							</button>
						</div>
						<!-- table with light -->
						<div class="table-responsive">
							<table class="table table-light mb-0">
								<thead>
									<tr>
										<th width= "2%">No</th>
										<th width="60%">제목</th>
									</tr>
								</thead>
								<c:set var="faqList" value="${pagingVO.dataList }"></c:set>
								<tbody id="listBody">
									<c:choose>
										<c:when test="${not empty faqList }">
											<c:forEach items="${faqList}" var="faq">
												<tr>
													<td>${faq.faqId}</td>
													<td><a
														href="${pageContext.request.contextPath }/nextpage/FaqUpdate?what=${faq['faqId'] }">${faq.faqTitle}</a></td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="5">FAQ 없음</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
						<div class="card-body">
							<p></p>
							<p></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
