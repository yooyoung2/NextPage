<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<meta name="robots" content="noindex, nofollow">


<div class="site-section">
	<div class="container">
				<h3><span style="border-bottom: 4px solid #51be78;">${content.cntntsTitle }</span></h3>
		<div class="row">
			<div class="col-lg-4 col-md-6 mb-5 mb-lg-0" style="margin-top:15px;">
				<!-- <span class="icon flaticon-mortarboard"></span> -->
				<p>${content.cntntsCntnt }</p>
			</div>
		</div>
		<img src="<%=request.getContextPath() %>/resources/templatesPreview/images/contents/${content.fileName}" alt="">
	</div>
</div>