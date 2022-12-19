<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!-- 1. CDN -->
<meta name="robots" content="noindex, nofollow">
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>


<div class="custom-breadcrumns border-bottom">
	<div class="container">
		<a href="index.html">Home</a> <span
			class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">Contact</span>
	</div>
</div>

<div class="site-section">
	<div class="row">


		<div class="container">
			<div class="row justify-content-center">
				<table border="1">
					<tr>
						<th class="table-secondary">제목</th>
					</tr>
					<tr>
						<td colspan="4"><textarea id="boContent" name="hello_content"></textarea>
							<script type="text/javascript">
								CKEDITOR
										.replace(
												'boContent',
												{
													filebrowserUploadUrl : '/board/imageUpload.do?type=image'

												});
							</script></td>
					</tr>

					<tr>
						<td rowspan="2">첨부파일</td>
						<td colspan="3"><input type="file" multiple="multiple"></td>
					</tr>
				</table>
			</div>
			<div class="row" style="margin-left: 200px;">
				<button id="modi2" class="btn btn-sm btn-primary" style="margin: 20px">등록</button>
				<button id="del2" class="btn btn-sm btn-danger" style="margin: 20px">취소</button>
			</div>
		</div>
	</div>
</div>
