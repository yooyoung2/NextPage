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
			<h2> 레이아웃선택 </h2>
			<h4> 현재 선택되어 있는 템플릿 : ${genTemplate.tmpltNm }</h4>
		</header>

<!-- 		<div class="input-group mb-3" style="padding: 0px 400px; margin-left: 400px;">
			<input type="text" class="form-control" placeholder="Search">
			<div class="input-group-append">
				<button class="btn btn-success" type="submit">Go</button>
			</div>
		</div> -->
		
		
		<ul class="grid cs-style-1" style="margin-right: -15%; margin-left: -25%;">			
			<c:choose>
				<c:when test="${not empty layoutList }">
					<c:forEach items="${layoutList }" var="layout">
						<li style="display: inline-block; width: 362px; margin: -22px; padding: 34px; text-align: left; position: relative;">
							<figure>
								<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/layout/${layout.layoutFile}" alt="img01" style="width: 362px;">
								<figcaption> 
									<h3> ${layout.layoutId } </h3> 
									<!-- <span>Jacob Cummings</span> -->
									<!-- <a href="#" data-toggle="modal" data-target="#${freeTemplate.tmpltId}"> 미리보기</a> -->
									 
									<a href="${pageContext.request.contextPath}/school/manager/homepage/makeHomepage?tmpltId=${genTemplate.tmpltId}&layoutId=${layout.layoutId }"> 홈페이지 꾸미기 </a>
								
								</figcaption>
							</figure>
						</li>
					</c:forEach>
				</c:when>
			</c:choose>
		</ul>
	</div>
	
</body>
