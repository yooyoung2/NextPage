<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

<title>신입생 등록</title>
</head>


<%
String msg=(String)request.getAttribute("msg");
System.out.println("메시지"+msg);
if(msg!=null)
{
	%>
	<script>
	window.onload=function()
	{
		Swal.fire({
	    	  position: 'top',
	    	  icon: 'success',
	    	  title: '${msg}',
	    	  showConfirmButton: false,
	    	  timer: 1500
	    	});
	}
    </script>
	<%
}
%>

<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<body>
	<div class="content">
		<div id="all">
			<div id="historyNameArea">
				<h3>신입생 등록</h3>
			</div>
			<div id="searchUI" style="display:flex;">
						<div class="col-auto">
							<select name="searchType" class="form-select">
								<option value>전체</option>
								<option value="name">이름</option>
								<option value="address">지역</option>
							</select>
						</div>
						<div class="col-auto">
							<input type="text" name="searchWord" placeholder="검색키워드"
								class="form-control"
							/>
						</div>
						<div class="col-auto">
							<input type="button" value="검색" id="searchBtn"
								class="btn btn-primary"
							/>
						</div>
					</div>
					<div id="inputTags" style="margin-left: 80%; margin-bottom: 1%;">
						<button type="button" class="btn btn-primary"
							onclick="location.href='<%=request.getContextPath()%>/school/manager/studentEachInsert'">개별등록</button>
						<button type="button" class="btn btn-info"
						data-bs-toggle="modal" data-bs-target="#exampleModal" data-who="test">일괄등록</button>

					</div>
			<div>
				<table id="historyTable"
					class="table text-start align-middle table-bordered table-hover mb-0">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th>주소</th>
							<th>상세주소</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="memberList" value="${pagingVO.dataList }" />
						<c:choose>
							<c:when test="${not empty memberList }">
								<c:forEach items="${memberList }" var="member">
									<tr>
										<%-- <td><a href="<%=request.getContextPath() %>/school/manager/student/update?who=${member['memNm'] }" >${member['memNm'] }</a></td> --%>
										<td><a href="javascript:sendPost('${member['memId'] }')">${member['memId'] }</a></td>
										<td>${member['memNm'] }</td>
										<td>${member['telNum'] }</td>
										<td>${member['memEmail'] }</td>
										<td>${member['addr1'] }</td>
										<td>${member['addr2'] }</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6">회원이 없음.</td>
								</tr>
							</c:otherwise>
						</c:choose>
						<tr>

		</tr>

					</tbody>
				</table>
				<div class="pagingArea mt-3">
					${pagingVO.pagingHTML }
				</div>
			</div>



			<form id="searchForm" >
	<input type="hidden" name="page" />
	<input type="hidden" name="searchType" />
	<input type="hidden" name="searchWord" />
</form>
<form id='viewForm' action="${pageContext.request.contextPath }/member/memberView.do">
	<input type='hidden' name='who'  />
</form>
<form id='updateForm' action="${pageContext.request.contextPath }/member/memberUpdate.do">
	<input type='hidden' name='who'  />
</form>
<form id="deleteForm" action="${pageContext.request.contextPath }/member/memberDelete.do" method="post">
	<input type='hidden' name='who'  />
</form>













		<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-scrollable modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">학생 일괄등록</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="container">
							<table>
								<thead>
									<tr>
										<th>양식<br>다운로드<br>
										</th>
										<th><a href="<%=request.getContextPath() %>/school/manager/teacher/download?what=1004"><button style="margin-left:50px;" class="btn btn-info" >다운로드</button></a></th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td><br>일괄등록<br>양식 첨부<br>
										</td>
										<th><br><a href="<%=request.getContextPath() %>/school/manager/student/fileInsert"><button style="margin-left:50px;" class="btn btn-info" >파일첨부</button></a></th>

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


	<script>


	let test = $("#test2").on("click", function(event){
		event.preventDefault();

		let f = document.createElement('form');


	    f.setAttribute('method', 'get');
	    f.setAttribute('action', '/NextPage/school/manager/student/fileInsert');
	    document.body.appendChild(f);
	    f.submit();


 	});


	</script>


</body>
<script>



function sendPost(email){
    let f = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'email');
    obj.setAttribute('value', email);

    f.appendChild(obj);
    f.setAttribute('method', 'post');
    f.setAttribute('action', '/NextPage/school/manager/student/update/');
    document.body.appendChild(f);
    f.submit();
}





$("#historyTable").on("click",".modify",function(){
	location.href="<%=request.getContextPath()%>/schoolManager/studentEachInsert"})




//검색버튼을 누르면 name속성 2개를 받아 for문을 돌린다.
	//[name, value] 형식으로 값을 저장한 후 서치를 진행한다.
	let searchUI = $("#searchUI").on("click", "#searchBtn", function(event){
		let inputTags = searchUI.find(":input[name]");
		$.each(inputTags, function(index, inputTag){
			let name = $(this).attr("name");
			let value = $(this).val();
			searchForm.get(0)[name].value = value;
		});
		searchForm.submit();
	});

	//서치폼과 페이지테그를 정의한다.
	let searchForm = $("#searchForm");
	let pageTag = $("[name=page]");
	//컨트롤러에서 받아온 서치타입 or 검색어가 있다면 그 값으로 설정한다.
	$("[name=searchType]").val("${simpleCondition.searchType}");
	$("[name=searchWord]").val("${simpleCondition.searchWord}");

	//페이징 지역에서 숫자를 클릭하면
	$(".pagingArea").on("click", "a", function(event){
		event.preventDefault();
		let page = $(this).data("page");
		if(!page) return false;
		pageTag.val(page);
		searchForm.submit();
		return false;
	});














	let updateForm = $("#updateForm");
 	let updateBtn = $("#updateBtn").on("click", function(event){
 		let who = viewModal.data("who");
 		if(!who) return false;
 		updateForm.get(0).who.value = who;
	 	updateForm.submit();
 	});
 	let downloadForm = $("#downloadForm");
 	let downloadBtn = $("#downloadBtn").on("click", function(event){
 		let who = viewModal.data("who");
 		if(!who) return false;
 		if(confirm("진짜 삭제할까?")){
 			downloadForm.get(0).who.value = who;
 			downloadForm.submit();
 		}
 	});

</script>