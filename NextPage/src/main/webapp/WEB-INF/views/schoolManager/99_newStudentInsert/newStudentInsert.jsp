<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<div class="content">
	<div id="all">
		<div id="historyNameArea">
			<h3>신입생 등록</h3>
		</div>
		<div>
			<div id="inputTags">
				<button type="button" class="btn btn-primary"
				onclick="location.href='<%=request.getContextPath()%>/schoolManager/newStudentEachInsert'">개별등록</button>
				<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">일괄등록</button>
			</div>
		</div>
		<div>
			<table id="historyTable" class="table text-start align-middle table-bordered table-hover mb-0">
				<thead>
					<tr>
						<th scope="col" class="tdId">이름</th>
						<th scope="col">전화번호</th>
						<th scope="col">이메일</th>
						<th scope="col">주소</th>
					</tr>
				</thead>
				<tbody>
					<tr class="modify">
						<th scope="row" id="name">강은비</th>
						<td id="tel">010-3511-7802</td>
						<td id="email">kbee_5@naver.com</td>
						<td id="">대전광역시 중구 용두동 123-12 403호</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<nav id="pagingBtn" aria-label="...">
				<ul class="pagination">
					<li class="page-item disabled"><span class="page-link">Previous</span>
					</li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item active" aria-current="page"><span
						class="page-link">2</span></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
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
           <table class="table table-borderless">
             <thead>
               <tr>
                 <th>양식<br>다운로드 </th>
                 <th><button class="btn btn-info">다운로드</button></th>

               </tr>
             </thead>
             <tbody>
               <tr>
                 <td>일괄등록<br>양식 첨부</td>
                 <td><input type="file" name="file" id="file" class="upload-box upload-plus" accept="image/*"></td>

             </tbody>
           </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Upload</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
 </div>
</div>

<script>
$("#historyTable").on("click",".modify",function(){
	location.href ="<%=request.getContextPath()%>/schoolManager/newStudentUpdate"
})
</script>