<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="site-section">

	<div class="container pt-5 mb-5" style="border:1px solid gray;">
	<c:if test="${symb.schmtt ne null}">
	
		<div class="row" style="float: left;">
			<div class="col-lg-4" style="margin-left: 15%;margin-top: 7%;">
				<h2 class="section-title-underline"  style="margin-top: -5%;margin-left: 3%;">
					<span style="font-weight: 600;">교훈　</span>
				</h2>
			</div>
		</div>
	
		<div class="row align-items-end justify-content-left">
			<div class="m-3">
				<h3>${symb.schmtt }</h3>
			</div>
		</div>
	</c:if>
		<div class="site-section">
			<div class="container">
	<c:if test="${symb.schTree ne null }">
				<div class="row">
					<div>
						<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${symb.treeFileName}" alt="Image" class="img-fluid" style="width:150px; height:150px;    margin-bottom: 7%;">
					</div>
					<div class="col-lg-5 mr-auto align-self-center order-2 order-lg-1" style="margin-left:3%;">
						<h2 class="section-title-underline mb-5" style="font-size: x-large; float: left;margin-right: 5%;">
							<span style="border-bottom: 4px solid #961cb56b;">교목 </span>
						</h2>
						<h4>${symb.schTree}</h4>
						<p>${symb.treeInfo}</p>
					</div>
				</div>
	</c:if>
	<c:if test="${symb.schFlower ne null }">
				<div class="row">
					<div>
						<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${symb.flowerFileName}" alt="Image" class="img-fluid" style="width:150px; height:150px;    margin-bottom: 7%;">
					</div>
					<div class="col-lg-5 mr-auto align-self-center order-2 order-lg-1" style="margin-left:3%;">
						<h2 class="section-title-underline mb-5" style="font-size: x-large; float: left;margin-right: 5%;">
							<span style="border-bottom: 4px solid #961cb56b;">교화  </span>
						</h2>
						<h4>${symb.schFlower}</h4>
						<p>${symb.flowerInfo}</p>
					</div>
				</div>
	</c:if>
		<c:if test="${symb.schBird ne null }">
				<div class="row">
					<div>
						<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${symb.birdFileName}" alt="Image" class="img-fluid" style="width:150px; height:150px;    margin-bottom: 7%;">
					</div>
					<div class="col-lg-5 mr-auto align-self-center order-2 order-lg-1" style="margin-left:3%;">
						<h2 class="section-title-underline mb-5" style="font-size: x-large; float: left;margin-right: 5%;">
							<span style="border-bottom: 4px solid #961cb56b;">교조  </span>
						</h2>
						<h4>${symb.schBird}</h4>
						<p>${symb.birdInfo}</p>
					</div>
				</div>
		</c:if>
		<c:if test="${symb.schSymbol ne null }">
				<div class="row">
					<div>
						<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${symb.symbolFileName}" alt="Image" class="img-fluid" style="width:150px; height:150px;    margin-bottom: 7%;">
					</div>
					<div class="col-lg-5 mr-auto align-self-center order-2 order-lg-1" style="margin-left:3%;">
						<h2 class="section-title-underline mb-5" style="font-size: x-large; float: left;margin-right: 5%;">
							<span style="border-bottom: 4px solid #961cb56b;">교표  </span>
						</h2>
						<h4>${symb.schSymbol}</h4>
						<p>${symb.symbolInfo}</p>
					</div>
				</div>
		</c:if>
			</div>
		</div>
	</div>
</div>
