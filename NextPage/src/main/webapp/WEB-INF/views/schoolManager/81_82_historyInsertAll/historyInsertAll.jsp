<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연혁</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
</head>
<script>
$(document).ready(function(){
  $(".dropdown-toggle").dropdown();
});
</script>
<body>
<div class="content">
<div class="container">
  <h2>학교 연혁</h2>
 
  
  
  
  <div>
				<div id="inputTags" style="margin-left: 80%;    margin-bottom: 1%;">
					
					<button type="button" class="btn btn-info" 
					data-bs-toggle="modal" data-bs-target="#exampleModal" data-who="test">일괄등록</button>
				</div>
			</div>
			
			
  <div>
				<table id="historyTable" class="table">
					<thead>
						<tr>
							<th width="20%">연혁날짜</th>
							<th>연혁내용</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="histList" value="${histList}" />
						<c:choose>
							<c:when test="${not empty histList }">
								<c:forEach items="${histList }" var="histList">
									<tr>
										<%-- <td><a href="<%=request.getContextPath() %>/school/manager/teacher/update?who=${member['memNm'] }" >${member['memNm'] }</a></td> --%>
										<td>${histList['histDate'] }</td>
										<td>${histList['histCntnt'] }</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6">연혁을 넣어주세요</td>
								</tr>
							</c:otherwise>
						</c:choose>
<!-- 						<tr> -->
<!-- 			<td colspan="7"> -->
<!-- 				<div class="pagingArea mb-3"> -->
<%-- 					${pagingVO.pagingHTML } --%>
<!-- 				</div> -->
<!-- 				<div id="searchUI" style="display:flex;margin-left: 30%;"> -->
<!-- 					<div class="col-auto"> -->
<!-- 						<select name="searchType" class="form-select"> -->
<!-- 							<option value>전체</option> -->
<!-- 							<option value="name">이름</option> -->
<!-- 							<option value="address">지역</option> -->
<!-- 						</select> -->
<!-- 					</div> -->
<!-- 					<div class="col-auto"> -->
<!-- 						<input type="text" name="searchWord" placeholder="검색키워드" -->
<!-- 							class="form-control" -->
<!-- 						/> -->
<!-- 					</div> -->
<!-- 					<div class="col-auto"> -->
<!-- 						<input type="button" value="검색" id="searchBtn" -->
<!-- 							class="btn btn-primary" -->
<!-- 						/> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</td> -->
<!-- 		</tr> -->

		</tbody>
	</table>
</div>


</div>
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-scrollable modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">교사 일괄등록</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="container">
							<table>
								<thead>
									<tr>
										<th>양식<br>다운로드<br>
										</th>
										<th><a href="<%=request.getContextPath() %>/school/manager/teacher/download?what=1005"><button style="margin-left:50px;" class="btn btn-info" >다운로드</button></a></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><br>일괄등록<br>양식 첨부<br>
										</td>
										<th><br><a href="<%=request.getContextPath() %>/school/manager/history/fileInsert"><button style="margin-left:50px;" class="btn btn-info" >파일첨부</button></a></th>
										
								</tbody>
							</table>
						</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- 모달창을 띄우고 모든 이벤트를 적용하는 js파일 -->
</body>
</html>