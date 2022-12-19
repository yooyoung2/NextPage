<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>


table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
}
  
thead {
  font-weight: bold;
  color: #fff;
  background: #435ebe;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
.page-item.active, .page-link {
   background-color: #435ebe;
   border-color: #435ebe;
}
</style>
<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section">구매내역</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="table-wrap">
					<table>
						<thead>
							<tr>
								<th scope="row">순번</th>
<!-- 								<th scope="row">주문ID</th> -->
								<th scope="row">상품ID</th>
								<th scope="row">상품이름</th>
								<th scope="row">결제일자</th>
							</tr>
						</thead>
						<c:set var="payList" value="${pagingVO.dataList }"></c:set>
						<tbody id="listBody">
							<c:choose>
								<c:when test="${not empty payList }">
									<c:forEach items="${payList}" var="pay">
										<tr>
											<td>${pay.rnum}</td>
<%-- 											<td>${pay.payId}</td> --%>
											<td>${pay.prodId}</td>
											<td>${pay.prodNm}</td>
											<td>${pay.payDate}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">거래 내역 없음</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="7">
									<div class="pagingArea mb-3">${pagingVO.pagingHTML }</div>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>

<form id="searchForm">
	<input type="hidden" name="page" />
</form>


<script>
let pageTag = $("[name=page]");
let listBody = $("#listBody");
let pagingArea = $(".pagingArea").on("click", "a", function(event) {
	event.preventDefault();
	let page = $(this).data("page");
	if (!page)
		return false;
	pageTag.val(page);
	searchForm.submit();
	return false;
});
</script>