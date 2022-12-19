<%@page import="kr.or.ddit.vo.Image64"%>
<%@page import="kr.or.ddit.vo.GenPostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#modi2,#del2{
	width: 90px;
    height: 44px;
}
</style>


<c:set var="replyList" value="${reply}"/>
<c:set var="authAt" value="false"/>
<c:set var="authCm" value="false"/>

<c:forEach items="${authCnctList}" var="authCnct">
	<c:if test="${authCnct.authMemId eq sessionScope.authVal && authCnct.authType eq 'BRWS'}">
		<c:set var="authAt" value="${authCnct.authType eq 'BRWS'}"/>
	</c:if>
	<c:if test="${authCnct.authMemId eq sessionScope.authVal && authCnct.authType eq 'CMMNT'}">
		<c:set var="authCm" value="${authCnct.authType eq 'CMMNT'}"/>
	</c:if>
</c:forEach>

<c:choose>
	<c:when test="${authAt && not empty authCnctList}">
		<c:forEach items="${authCnctList}" var="authCnct">
 			<c:if test="${authCnct.authMemId eq sessionScope.authVal}">
  				<c:if test="${authCnct.authType eq 'BRWS'}">
  					<div class="site-section">
						<div class="container">
							<table class="table table-bordered" style="width:97%;">
				   			 <thead class="thead-light">
								<tr>
									<th>제목</th>
									<td colspan="4">${genPost.postTitle}</td>
								</tr>
								<tr>
									<th>작성자</th>
									<td>${genPost.memNm}</td>
									<th>작성일자</th>
									<td>${genPost.postWriteDate}</td>
								</tr>
								<tr>
									<td colspan="4" style="height: 400px;">${genPost.postCntnt}
									<% 
									List<Image64> ImageList=(List<Image64>)request.getAttribute("ImageList");
									for(int i=0;i<ImageList.size();i++)
									{
										%>
 										<img style="width:600px; height:400px; margin-bottom:20px; margin-left:195px;" src="data:image/*;base64,<%=ImageList.get(i).getSaveName()%>"/> 
<%-- 											<video src="data:video/mp4;base64,<%=ImageList.get(i).getSaveName()%>" autoplay controls></video> --%>
										<%
									}
									
									%>
									</td>
								</tr>
								<tr>
									<td rowspan="2">첨부파일</td>
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
							<c:if test="${sessionScope.authMem eq genPost.memId}">
							<div class="row-right" style="margin-left: 80%;">
								<!-- <input type="hidden" name="postNotisWhether" value="NO" >
								<input type="hidden"name="postScrtWhether" value="NO" > -->
								<button id="modi2" class="btn btn-sm btn-primary"  onclick="location.href='<%=request.getContextPath()%>/generation/${genBoard.schId}/board/update?brdNum=${genBoard.brdNum}&what=${genPost.postNum}'">수정</button>
								<button id="del2" class="btn btn-sm btn-danger" onclick="location.href='<%=request.getContextPath()%>/generation/${genBoard.schId}/board/delete?brdNum=${genBoard.brdNum}&what=${genPost.postNum}'">삭제</button>
							</div>
							</c:if>						
						<!--댓글 -->
						<c:if test="${genBoard.cmmntWhthr eq 'YES'}">
							
							          <%-- ${genBoard.cmmntWhthr} --%>
								<h3>댓글 목록</h3>	
								<div style="background-color: aliceblue; ">
									<table class="table table-bordered table-strip">
										<tr>
											<th style="width:60%; text-align: center;">내용</th>
											<th style="width:10%; text-align: center;">작성자</th>
											<th style="width:20%; text-align: center;">날짜</th>
											<th width="10%;"></th>
										</tr>
										<tbody id = "replyBody">
											<c:forEach items="${replyList }" var="reply">
												<tr>
													<td style="padding: 10px 30px;">${reply.cmmntCntnt }</td>
													<td style="text-align: center;">${reply.memNm }</td>
													<td>${reply.cmmntDate }</td>
													<td >
														 <c:if test="${reply.cmntId eq sessionScope.authMem}">  
															<a href="<%=request.getContextPath()%>/generation/${genBoard.schId}/board/replyDelete?brdNum=${genBoard.brdNum}&what=${genPost.postNum}&reply=${reply.cmmntId}" id="deleteReply" class="btn btn-sm btn-primary" style="color:white;">댓글 삭제</a>
													      </c:if>  
												    </td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<br>
								<c:if test="${authCm}"> 
								<div>
									<form action="<%=request.getContextPath()%>/generation/${genBoard.schId}/board/replyInsert?brdNum=${genBoard.brdNum}&what=${genPost.postNum}" method="post">
										<div><input type="hidden" class="form-control" name="postNum" value="${genPost.postNum }"/></div>
										<div>
											<h5 style="text-align: left;">댓글 내용</h5>
											<textarea rows="4" cols="80" name="cmmntCntnt" style="float: left;"></textarea>
										<button type="submit" class="btn btn-success " style="margin-left: 1%; padding: 15px; color:white;">댓글 등록</button>
										</div>
									</form>
								</div>
							</c:if>
						</c:if>
						<!-- 댓글끝 -->
						</div>
						<br>
					</div>
				</c:if>			
			</c:if>
		</c:forEach>
	</c:when>
	<c:otherwise>
	<h1  style="margin: 25%;">게시물 접근권한이 없습니다.</h1>
	</c:otherwise>
</c:choose>


