<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/templatesPreview/css/component.css" />
	
<script
	src="<%=request.getContextPath()%>/resources/templatesPreview/js/modernizr.custom.js"></script>
<script
		src="<%=request.getContextPath()%>/resources/templatesPreview/js/toucheffects.js"></script>
</head>

<body>
	<div class="container demo-1" style="margin-left:3%;">
		<!-- Top Navigation -->

		<header>
			<h3>무료템플릿 목록</h3>
		</header>
		<select title="" onchange="window.open(value,'_self');">
			<option value="<%=request.getContextPath()%>/school/manager/homepage/make/free" selected>무료템플릿</option>
			<option value="<%=request.getContextPath()%>/school/manager/homepage/make/cost">유료템플릿</option>
		</select>
<!-- 		<div class="input-group mb-3" style="padding: 0px 400px; margin-left: 400px;">
			<input type="text" class="form-control" placeholder="Search">
			<div class="input-group-append">
				<button class="btn btn-success" type="submit">Go</button>
			</div>
		</div> -->
		
		
		<ul class="grid cs-style-1" style="margin-right: -15%; margin-left: -25%;">			
			<c:choose>
				<c:when test="${not empty freeTemplateList }">
					<c:forEach items="${freeTemplateList }" var="freeTemplate">
						<li style="margin-top: 1px;">
							<figure>
								<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/${freeTemplate.tmpltThmnl}" 
								alt="img01" style="width: 362px; height:300px;">
								<figcaption> 
									<h3> ${freeTemplate.tmpltNm } </h3>
									<!-- <span>Jacob Cummings</span> -->
									<a href="#" data-toggle="modal" data-target="#${freeTemplate.tmpltId}"> 미리보기</a>  
									<a href="${pageContext.request.contextPath}/school/manager/homepage/choiceLayout?tmpltId=${freeTemplate.tmpltId}"> 홈페이지 꾸미기 </a>
								</figcaption>
							</figure>
						</li>
					</c:forEach>
				</c:when>
			</c:choose>
		</ul>
	</div>
	<!-- /container -->
 	<c:choose>
		<c:when test="${not empty freeTemplateList }">
			<c:forEach items="${freeTemplateList }" var="freeTemplate">
				<div class="modal fade" id="${freeTemplate.tmpltId}" data-backdrop="static" data-keyboard="false">
					<div class="modal-dialog modal-xl modal-dialog-centered">
						<div class="modal-content">
						<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">${freeTemplate.tmpltNm }</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<!-- Modal body -->
							<div class="modal-body">
								<img class="card-img-top rounded img-fluid" src="<%=request.getContextPath()%>/resources/templatesPreview/images/${freeTemplate.tmpltThmnl}">
							</div>
							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
	</c:choose> 
</body>
</html>

