<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

    <div class="site-section">
			<div class="container">
				<div class="row justify-content-center">

					<table class="table">
						  <thead>
						    <tr>
								<th scope="col"></th>
								<th scope="col"></th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일자</th>
								<th scope="col">첨부파일</th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      <th scope="row">1</th>
							<td><button>공지</button></td>
							<td><a class="asd" href="<%=request.getContextPath() %>/generation/generatingBoardDetail">안녕</a></td>
							<td>가응비</td>
							<td>2022.11.03</td>
							<td>ㅁ</td>
						    </tr>
						    <tr>
						      <th scope="row">2</th>
						      <td><button>완료</button></td>
						      <td>Jacob</td>
						      <td>Thornton</td>
						      <td>@fat</td>
						      <td>@fat</td>
						    </tr>
						    <tr>
						      <th scope="row">3</th>
								<td><button>대기</button></td>
								<td>안녕</td>
								<td>이우영</td>
								<td>2022.11.03</td>
								<td>ㅂ</td>
						    </tr>
						  </tbody>
						</table>
				<a type="button" class="btn-success" href="<%=request.getContextPath() %>/generation/generatingWrite">글쓰기</a>

				</div>
				<div class="row justify-content-center">
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li class="page-item"><a class="page-link" href="#">1</a></li>
			    <li class="page-item"><a class="page-link" href="#">2</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			</div>
		</div>
	</div>

</body>

</html>