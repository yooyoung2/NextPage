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
    text-align: center;
}

th {
  text-align: center;
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
  
.pagination {
    margin-left: 8%;
}

.page-item.active .page-link {
    z-index: 3;
    color: #fff;
    background-color: #435ebe;
    border-color: #435ebe;
}
#noTh{
 width:15%;
}
#dateTh{
 width:35%;
}
#titleTh{
 width:35%;
}
#statTh{
 width:15%;
}


</style>
   <section class="ftco-section">
      <div class="container">
         <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
               <h2 class="heading-section">1:1 문의글 조회</h2>
            </div>
         </div>
         <div class="row">
            <div class="col-md-12">
               <div class="table-wrap">
                  <table>
                     <thead class="thead-dark">
                        <tr>
                           <th id="noTh">No</th>
                           <th id="titleTh">제목</th>
                           <th id="dateTh">작성일</th>
                           <th id="statTh">처리현황</th>
                        </tr>
                     </thead>
                     <c:set var="otoList" value="${pagingVO.dataList }"></c:set>
                     <tbody id="listbody">
                       	<c:choose>
                       		<c:when test="${not empty otoList }">
                       			<c:forEach items="${otoList }" var="oto">
                       				<tr>
                       					<td>${oto.otoBrdNum }</td>
                       					<td><a href="<%=request.getContextPath() %>/nextpage/myOtoDetail?what=${oto['otoBrdNum'] }">${oto.otoBrdTitle}</a></td>
                       					<td>${oto.wrteDate}</td>
                       					<td>${oto.prgrsCndtn}</td>
                       				</tr>
                       			</c:forEach>
                       		</c:when>
                       		<c:otherwise>
									<tr>
										<td colspan="5">문의 내역 없음</td>
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