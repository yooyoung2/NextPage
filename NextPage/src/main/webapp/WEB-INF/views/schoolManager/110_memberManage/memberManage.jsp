<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<title>회원관리</title>
</head>

<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<div class="content">
	<div id="all">
		<div id="historyNameArea">
			<h3>회원관리</h3>
		</div>
		<div>
			<div id="yearChoiceArea2" style="float: left; margin-left: 52%;">
				<!-- <input type="radio"><label>2020</label> <input type="radio"><label>2021</label>
				<input type="radio"><label>2022</label> 

				<div class="btn-group">
					<select id="roleSel">
						<option value="">전체</option>
						<option value="">학생</option>
						<option value="">교사</option>
						<option value="">학부모</option>
					</select>
				</div> -->
			</div>
		<!-- 	<div>
				<input class="search_tag" type="text" placeholder="🔎이름검색" style="    margin-left: 1%;"/>
			</div> -->
		</div>
		<div>
			<c:set var="list" value="${list }" />
			<table id="historyTable" class="table table-striped">
				<thead>
					<tr>
						<th scope="col">학번/사번</th>
						<!-- <th scope="col">비밀번호</th> -->
						<th scope="col">이름</th>
						<!-- <th scope="col">학년/반</th> -->
						<!-- <th scope="col">반</th> -->
						<!-- <th scope="col">회원상태</th> -->
						<th scope="col">이메일</th>
						<!-- <th scope="col">학생상태</th> -->
						<th scope="col">연락처</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var = "vo" items = "${list }">
					<tr data-toggle="modal" data-target="#myModal">
						<th scope="row">${vo.memId }</th>
						<%-- <td>${vo.memPw }</td> --%>
						<td>${vo.memNm }</td>
						<td>${vo.memEmail }</td>
						<td>${vo.telNum }</td>
						<td onclick="event.cancelBubble=true">-</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 2. 이전페이지 활성화 여부 -->
	<div class = "center">
		<ul class = "no-style">
			<c:if test="${pageVO.prev }">
				<li class = "list-row">
					<a class="btn btn-primary" style="background-color: #1b75c3; border-color: #1b75c3;" href = "<%=request.getContextPath() %>/school/manager/member/list?pageNum=${pageVO.startPage - 1}&amount=${pageVO.amount}">이전</a>
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
						<a class="btn btn-success" style="background-color: #1b75c3; border-color: #1b75c3;" href = "<%=request.getContextPath() %>/school/manager/member/list?pageNum=${num}&amount=${pageVO.amount}">${num }</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class = "list-row"> <!-- class = "${pageVO.pageNum eq num ? 'active' : '' }" -->
						<a class="btn btn-info" style="background-color: #1b75c3; border-color: #1b75c3;" href = "<%=request.getContextPath() %>/school/manager/member/list?pageNum=${num}&amount=${pageVO.amount}">${num }</a>
						</li>
					</c:otherwise>
				</c:choose>

			</c:forEach>
			
			<!-- 3. 다음버튼 활성화 여부 -->
			<c:if test="${pageVO.next }">
				<li class = "list-row">
					<a class="btn btn-primary" style="background-color: #1b75c3; border-color: #1b75c3;" href = "<%=request.getContextPath() %>/school/manager/member/list?pageNum=${pageVO.startPage + 1}&amount=${pageVO.amount}">다음</a>
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
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title"></h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<table>
							<tr>
								<th scope="col">학번</th>
								<td>1465001</td>
							</tr>

							<tr>
								<th scope="col">이름</th>
								<td>강은비</td>
							</tr>

							<tr>
								<th scope="col">학년</th>
								<td>3</td>
							</tr>
							<tr>
								<th scope="col">반</th>
								<td>8</td>
							</tr>
							<tr>
								<th scope="col">이메일</th>
								<td><input type="email"></td>
							</tr>
							<tr>
								<th scope="col">주소</th>
								<td><input type="text"></td>
							</tr>
							<tr>
								<th scope="col">전화번호</th>
								<td><input type="text"></td>
							</tr>
							<tr>
								<th scope="col">담임이름</th>
								<td>이유영</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
