<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="robots" content="noindex, nofollow">
<script src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>

<style>
#title{
    width: 21%;
    text-align : center;
    vertical-align:middle;
}
</style>

<!-- Page content-->

<!-- <div style="margin-left: -8%;padding: 110px 180px;"> -->

			<div style="margin-left: -2%; margin-top: 6%; padding: 10px 120px;">
				<div>
					<form action="<%=request.getContextPath()%>/generation/${genBoard.schId}/board/add?brdNum=${genBoard.brdNum}" method="post" enctype="multipart/form-data">
						<table class="table">
							<tr>
								<th id="title">제목</th>
								<td colspan="4" ><input class="form-control" type="text" name="postTitle"></td>
							</tr>
			
							<tr>
								<td colspan="4"><textarea id="postTitle" rows="30" cols="100" name="postCntnt"></textarea></td>
							</tr>
							<%
									int attach_num=(int)request.getAttribute("attach_num");
							%>
							<tr>
								<td>첨부파일</td>
							</tr>
							<%for(int i=0;i<attach_num;i++) {%>
							<tr>
								<td colspan="3" style="word-wrap:break-word;"><input type="file" id="boFiles" name="boFiles"/><br></td>
							</tr>
							<%} %>
							
						</table>
							<div style="margin-left: 45%;">
							<input type="hidden" name="postNotisWhether" value="NO" >
							<input type="hidden"name="postScrtWhether" value="NO" >
								<button type="submit" class="btn btn-success">등록</button>
								<input type="button" onclick="history.go(-1);" class="btn btn-danger" value="취소">
							</div>
					</form>
				</div>
			</div>
	<script type="text/javascript">
		 CKEDITOR.replace(
					'postCntnt',
					{
						filebrowserUploadUrl : '${pageContext.request.contextPath }/generation/website/board/imageUpload?type=image'
						,height:390
	
					});

	</script>
