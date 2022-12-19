<%@page import="kr.or.ddit.vo.GenPostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="robots" content="noindex, nofollow">
<script src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>
<!-- Page content-->
<style>
	#title{
    width: 20%;
    text-align : center;
    vertical-align:m
	}
</style>
			<div style="margin-left: -2%; margin-top: 6%; padding: 10px 120px;">
				<div>
					<form action="<%=request.getContextPath()%>/generation/${genBoard.schId}/board/update?brdNum=${genPost.brdNum}&what=${genPost.postNum}" method="post" >
						<table class="table">
							<tr>
								<th id="title">제목</th>
								<td colspan="4" ><input class="form-control" type="text" name="postTitle" value="${genPost.postTitle}"></td>
							</tr>
			
							<tr>
								<td colspan="4"><textarea rows="30" cols="80"  name="postCntnt">${genPost.postCntnt}</textarea></td>
							</tr>
							<tr>
								<td>첨부파일</td>
							</tr>
							
							<%
								List<GenPostVO> genList=(List<GenPostVO>)request.getAttribute("genList");
								
								for(int i=0;i<genList.size();i++)
								  {%>
									<tr>
									<td colspan="30">
									
									
									<a href="<%=request.getContextPath() %>/board/download?what=<%=genList.get(i).getSaveName() %>" style="color:blue;"><%=genList.get(i).getFileName() %></a><input type="hidden" id="boFiles" name="boFiles">

									<input type="hidden" name="boFiles" />
									
									</td>
									</tr>
								<%}
								%>

						</table>
						<div style="margin-left: 45%;">
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
