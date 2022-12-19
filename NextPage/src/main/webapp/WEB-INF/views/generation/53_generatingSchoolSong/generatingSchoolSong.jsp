<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<div class="site-section">
	<div class="container">

			<h3 style="	margin-left : 30px;"><span style="border-bottom: 4px solid #51be78;">교가</span></h3>

		<div>
			<div style="padding-left: 15%;">
				<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${song.imgNm}" alt="Image"
					class="img-fluid" style="margin-left: 81px; margin-top: 30px;">
			</div>
			<div style="margin-left: 30%; margin-top: 30px;">
				<audio loop controls>
					<source src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${song.musicNm}" type="audio/mpeg">
				</audio>
			</div>
		</div>
	</div>
</div>