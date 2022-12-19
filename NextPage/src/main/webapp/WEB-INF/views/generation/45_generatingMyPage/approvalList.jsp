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
								<th>자녀 학번(ID)</th>
								<th>자녀 이름</th>
								<th>승인/반려</th>
							</tr>
						</thead>

						<tbody id="listBody">
							<c:choose>
								<c:when test="${not empty approvalList }">
									<c:forEach items="${approvalList}" var="app">
										<tr>
											<td>${app.prntId }</td>
											<td>${app.studId}</td>
											<td>${app.memNm}</td>
											<td>
												<input type="button" id="approval" onclick="approval()" class="btn btn-success" value="승인">
												<input type="button" id="return" onclick="returnApp()" class="btn btn-danger" value="반려">
											</td>
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

<script>
//let data2;

function approval(){
	let table = document.getElementById('approvalTable');
	let approvalList = [];


	for (let i = 1; i < table.rows.length; i++) {
		table.rows[i].cells[3].onclick = function () {

			prntId = table.rows[i].cells[0].innerHTML;
			studId = table.rows[i].cells[1].innerHTML;


			data = {
				"prntId" : prntId
				,"studId" : studId
			};

			console.log("왔다 : " + JSON.stringify(data));


			var schId = '<%=(String) session.getAttribute("id")%>';

		    $.ajax({
		        type:"post",
		        url:"${pageContext.request.contextPath}/generation/"+schId+"/generatingMyPage/approvalList",
		        data: JSON.stringify(data),
		        contentType:"application/json; charset=utf-8",
		      	dataType:"html",
		      	success: function(message){
// 		            alert(message);
		            Swal.fire({
		            	  position: 'top-end',
		            	  icon: 'success',
		            	  title: message,
		            	  showConfirmButton: false,
		            	  timer: 1500
		            	})
		            location.reload();
		        },
		        error:function(error){
		        	Swal.fire({
		            	  position: 'top-end',
		            	  icon: 'success',
		            	  title: '오류',
		            	  showConfirmButton: false,
		            	  timer: 1500
		            	})
		        }
		    });

// 			approvalList.push(data);

			}
	}


}

function returnApp(){
	let table = document.getElementById('approvalTable');
	let approvalList = [];


	for (let i = 1; i < table.rows.length; i++) {
		table.rows[i].cells[3].onclick = function () {

			prntId = table.rows[i].cells[0].innerHTML;
			studId = table.rows[i].cells[1].innerHTML;


			data = {
				"prntId" : prntId
				,"studId" : studId
			};

			console.log("왔다 : " + JSON.stringify(data));


			var schId = '<%=(String) session.getAttribute("id")%>';

		    $.ajax({
		        type:"post",
		        url:"${pageContext.request.contextPath}/generation/"+schId+"/generatingMyPage/approvalList/delete",
		        data: JSON.stringify(data),
		        contentType:"application/json; charset=utf-8",
		      	dataType:"html",
		        success: function(message){
// 		            alert(message);
		            Swal.fire({
		            	  position: 'top-end',
		            	  icon: 'success',
		            	  title: message,
		            	  showConfirmButton: false,
		            	  timer: 1500
		            	})
		            location.reload();
		        },
		        error:function(error){
		        	Swal.fire({
		            	  position: 'top-end',
		            	  icon: 'success',
		            	  title: '오류',
		            	  showConfirmButton: false,
		            	  timer: 1500
		            	})
		        }
		    });

// 			approvalList.push(data);

			}
	}
}
</script>
