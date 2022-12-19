			<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>

			<div class="site-section">


				<div class="container">
					<table border="1">
						<tr>
							<th>제목</th>
							<td colspan="4">교실</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>학교관리자</td>
							<th>작성일자</th>
							<td>2022.11.03</td>
						</tr>
						<tr>
							<td colspan="4"><a href="https://vimeo.com/45830194"
								class="video-1 mb-4" data-fancybox="" data-ratio="2"> <span
									class="play"> <span class="icon-play"></span>
								</span> <img
									src="<%=request.getContextPath()%>/resources/templates/template01/template01Index/images/course_5.jpg"
									alt="Image" class="img-fluid">
							</a></td>
						</tr>
						<tr>
							<th><button id="changeStatus">대기</button></th>
						</tr>
					</table>
					<div style="margin-left: 700px;">
	        	<button id="modi2" class="btn btn-sm btn-primary"  onclick="location.href='<%=request.getContextPath()%>/generation/generatingVideoBoardModify'">수정</button>
				<button id="del2" class="btn btn-sm btn-danger">삭제</button>
			</div>
				</div>
				<div class="container">
					<table class="table-primary" style="width: 800px;">

						<tbody>
							<tr class="re2">
								<th scope="row">방형준</th>
								<td>| 2022/01/01 14:30</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="re2">
								<td colspan="2">403화이팅</td>
								<td><button id="modi" class="btn btn-sm btn-primary">수정</button></td>
								<td><button id="del" class="btn btn-sm btn-danger">삭제</button></td>
							</tr>
							<tr>
								<th scope="row">choi현우</th>
								<td>| 2022/11/03 19:30</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2">30분만하신다고...</td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
					<textarea cols="80px;">내용을 입력해주세요.</textarea>
					<button id="del" class="btn">등록</button>
				</div>
			</div>

			<script type="text/javascript">
				$(function() {

					$('#del').click(function() {

						$('tr').remove('.re2'); //div 전체삭제

					});

				});
			</script>


			<script>
				$(function() {
					$('#changeStatus').click(function() {
						if ($(this).html() == '대기') {
							$(this).html('접수');
						} else {
							$(this).html('완료');
						}

					});
				});
			</script>


			</body>

			</html>
	</div>
</div>

<script type="text/javascript">
	$(function() {

		$('#del').click(function() {

			$('tr').remove('.re2'); //div 전체삭제

		});

	});
</script>


