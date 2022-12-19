<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<style>
	.no-style{
		list-style: none;
	}

	.list-row{
		float: left;
		margin : 5px;
	}

	.center{
		display : flex;
		justify-content: center;
	}

</style>

<div class="content">
<h2 style="margin-top: 1%;">컨텐츠 목록</h2>

		<!-- 컨텐츠 추가 -->
		<!-- /NextPage3/src/main/webapp/WEB-INF/views/schoolManager/93_94_contentForm/contentForm.jsp -->
		<button class="btn btn-primary" style="background-color: #1b75c3;border-color: #1b75c3;margin-top: 1%;margin-bottom: 1%;float: right;" onclick="location.href='/NextPage/school/manager/content/add'">컨텐츠 추가</button>
<c:set var="list" value="${list }" />
<table class="table table-bordered table-strip">
	<thead class="table-dark">
		<tr>
			<th>홈페이지</th>
 			<th>컨텐츠 아이디</th>
			<th>컨텐츠명</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody id="listBody">
		<c:forEach var = "vo" items = "${list }">
			<tr>
				<td></td>
				<td>${vo.cntntsId }</td>
				<td>${vo.cntntsTitle }</td>
				<td>
					<button class="btn btn-success" onclick = "location.href='/NextPage/school/manager/content/add?cntntId=${vo.cntntsId }'">수정</button>
					<button class="btn btn-danger" onclick = "location.href='/NextPage/school/manager/content/delete?cntntId=${vo.cntntsId }'">삭제</button>

				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="pagingArea"></div>
	<!-- 2. 이전페이지 활성화 여부 -->

	<div class = "center">
		<ul class = "no-style">
			<c:if test="${pageVO.prev }">
				<li class = "list-row">
					<a class="btn bg-white" style="border-color: black;" href = "<%=request.getContextPath() %>/school/manager/content/list?pageNum=${pageVO.startPage - 1}&amount=${pageVO.amount}">이전</a>
				</li>
			</c:if>

			<%-- <c:if test="${not pageVO.prev }">
				<li class = "list-row">
					<a class="btn btn-primary" style="background-color: #1b75c3; border-color: #1b75c3;" href = "<%=request.getContextPath() %>/school/manager/content/list?pageNum=${pageVO.startPage - 1}&amount=${pageVO.amount}">이전</a>
				</li>
			</c:if> --%>

			<!-- 1. 페이지네이션 처리 -->
			<c:forEach var = "num" begin = "${pageVO.startPage }" end = "${pageVO.endPage }">

				<c:choose>
					<c:when test="${pageVO.pageNum eq num }">
						<li class = "list-row"> <!-- class = "${pageVO.pageNum eq num ? 'active' : '' }" -->
						<a class="btn btn-success" style="background-color: #435ebe; border-color: #435ebe;" href = "<%=request.getContextPath() %>/school/manager/content/list?pageNum=${num}&amount=${pageVO.amount}">${num }</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class = "list-row"> <!-- class = "${pageVO.pageNum eq num ? 'active' : '' }" -->
						<a class="btn btn-info" style="background-color: #435ebe; border-color: #435ebe;" href = "<%=request.getContextPath() %>/school/manager/content/list?pageNum=${num}&amount=${pageVO.amount}">${num }</a>
						</li>
					</c:otherwise>
				</c:choose>

			</c:forEach>

			<!-- 3. 다음버튼 활성화 여부 -->
			<c:if test="${pageVO.next }">
				<li class = "list-row">
					<a class="btn bg-white" style="border-color: black;" href = "<%=request.getContextPath() %>/school/manager/content/list?pageNum=${pageVO.startPage + 1}&amount=${pageVO.amount}">다음</a>
				</li>
			</c:if>

<%-- 			<c:if test="${not pageVO.next }">
				<li class = "list-row">
					<a class="btn btn-primary" style="background-color: #1b75c3; border-color: #1b75c3;" href = "<%=request.getContextPath() %>/school/manager/content/list?pageNum=${pageVO.startPage + 1}&amount=${pageVO.amount}">다음</a>
				</li>
			</c:if> --%>
		</ul>
	</div>


</div>


<script type="text/javascript">



</script>

<!-- 원본파일 보존 -->
<!--
<%-- 	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<style>
.list-table{
    border: 1px solid #444444;
    border-collapse: collapse;
}
.list-th,.list-td{
	border-bottom: 1px solid #444444;
    padding: 10px;
}
</style>
<div class="content">
<table>
	<tr>
		<td>
			<form class="search" style="margin-top: 5%;">
				<select id="select1" onchange="itemChange()">
					<option>콘텐츠명</option>
					<option>콘텐츠ID</option>
				</select>
				<input type="text" name="search">
				<button class="post-btn" type="submit" value="검색">검색</button>
			</form>
		</td>
		<td>
			<input type="button" value="일괄삭제">
		</td>
		<td>
			<input type="button" value="콘텐츠 추가">
		</td>
	</tr>
</table>
<table class="list-table">
	<thead>
		<tr>
			<th class="list-th">
				<input type="checkbox">
			</th>
			<th class="list-th">콘텐츠아이디</th>
			<th class="list-th">콘텐츠명</th>
			<th class="list-th">메뉴경로</th>
			<th class="list-th">관리</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="list-td">
				<input type="checkbox">
			</td>
			<td class="list-td">1234</td>
			<td class="list-td">2022셔틀버스</td>
			<td class="list-td">학교소식 > 셔틀버스 운행아내</td>
			<td class="list-td"><input type="button" value="수정"><input type="button" value="삭제"></td>
		</tr>
	</tbody>
</table>
</div>



 -->