<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/templates/template01/template01Index/css/calendar/simple-calendar.css">

<script src="<%=request.getContextPath()%>/resources/templates/template01/template01Index/css/calendar/jquery.simple-calendar.js"></script>



<style>

table {
    margin-left:auto;
    margin-right:auto;
    border:hidden;
}

#tds{
	width: 100%;
	height: 20%;
	background-color: #df728645;
}

.tds{
	background-color: #df728645;
}



.notiImg {
	width: 200px;
	height: 200px;
}

/* container - body */
#noticeBrd {
	width: auto;
	height:300px;
	margin: auto;
}

.banner_wraper {
	height: 60px;
	width: 1200px;
	position: absolute;
	overflow: hidden;
	margin-right: 100px;
}

.banner_wraper img {
	height: 45px;
	position: absolute;
}

#diet, #img1,#board1{
	width: 300px;
	height: 300px;
}

#calContainer{
	width:300px;
	height:300px;
	font-size: 9px;
}

.card .card-body{
	width: auto;
	height: auto;

}


#video2, #img2, #board2{
	height:300px;
}

.linkImg{
	width: 50px;
	height: 50px;
}



</style>


    <div class="container-xxl p-0" style="background-image: url(<%=request.getContextPath()%>/resources/img/back2.jpg);">
        <!-- Spinner Start -->
        <div id="spinner" class="show  position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center" style="background-color: #ffe8fb;">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->





        <!-- Carousel Start -->
        <div class="container-fluid p-0 mb-5" style="width: 73%;">
            <div class="owl-carousel header-carousel position-relative">

            	<!-- 메인 이미지 시작 -->
            	<c:forEach var = "image" items = "${mainImages }">
                <div class="owl-carousel-item position-relative">
                <!--
                	/resources/templatesPreview/images/mainImage
                 -->
                    <img style="height:405px;"  class="img-fluid"  src="<%=request.getContextPath()%>/resources/templatesPreview/images/mainImage/${image.fileName}" alt="" >
                    <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-10 col-lg-8">
                                   <!--  <h1 class="display-2 text-white animated slideInDown mb-4">The Best Kindergarten School For Your Child</h1>
                                    <p class="fs-5 fw-medium text-white mb-4 pb-2">Vero elitr justo clita lorem. Ipsum dolor at sed stet sit diam no. Kasd rebum ipsum et diam justo clita et kasd rebum sea elitr.</p> -->
                                   <!--  <a href="" class="btn btn-primary rounded-pill py-sm-3 px-sm-5 me-3 animated slideInLeft">Learn More</a>
                                    <a href="" class="btn btn-dark rounded-pill py-sm-3 px-sm-5 animated slideInRight">Our Classes</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <!-- 메인 이미지 끝 -->

                <%-- <div class="owl-carousel-item position-relative">
                    <img style="height:405px;"  class="img-fluid"  src="<%=request.getContextPath()%>/resources/img/학교2.jpg" alt="" >
                    <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-10 col-lg-8">
                                    <!-- <h1 class="display-2 text-white animated slideInDown mb-4">The Best Kindergarten School For Your Child</h1>
                                    <p class="fs-5 fw-medium text-white mb-4 pb-2">Vero elitr justo clita lorem. Ipsum dolor at sed stet sit diam no. Kasd rebum ipsum et diam justo clita et kasd rebum sea elitr.</p> -->
                                   <!--  <a href="" class="btn btn-primary rounded-pill py-sm-3 px-sm-5 me-3 animated slideInLeft">Learn More</a>
                                    <a href="" class="btn btn-dark rounded-pill py-sm-3 px-sm-5 animated slideInRight">Our Classes</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div> --%>


<%--                 <div class="owl-carousel-item position-relative">
                    <img style="height:405px;" class="img-fluid" src="<%=request.getContextPath()%>/resources/img/학교3.jpg" alt="">
                    <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" >
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-10 col-lg-8">
                                    <!-- <h1 class="display-2 text-white animated slideInDown mb-4">Make A Brighter Future For Your Child</h1>
                                    <p class="fs-5 fw-medium text-white mb-4 pb-2">Vero elitr justo clita lorem. Ipsum dolor at sed stet sit diam no. Kasd rebum ipsum et diam justo clita et kasd rebum sea elitr.</p> -->
                                   <!--  <a href="" class="btn btn-primary rounded-pill py-sm-3 px-sm-5 me-3 animated slideInLeft">Learn More</a>
                                    <a href="" class="btn btn-dark rounded-pill py-sm-3 px-sm-5 animated slideInRight">Our Classes</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div> --%>

            </div>
        </div>
        <!-- Carousel End -->

<!--레이아웃 표시부분   -->
<div class="position-relative" style="margin-top: -3%;">
	<div class="justify-content-center">
		${prj. layoutSc}
	</div>
</div>
<!--레이아웃 끝 -->



		<!-- -----------------------게시판 위젯  --------------------------------->
<div id="wdgGroup">
		<!--2개짜리 목록형  -->
		<div id="board2" hidden="hideen" class="card" style="height: 300px;">
			<ul class="nav nav-tabs" id="myTab" role="tablist">

				<c:set var="brdLtWdg" value="${brdLtWdg}"></c:set>
				<c:forEach items="${brdLtWdg}" var="brdLtWdg" varStatus="status">
					<c:if test="${status.first}">
						<li class="nav-item" role="presentation">

							<button class="nav-link active" id="home-tab"
								data-bs-toggle="tab" data-bs-target="#home" type="button"
								role="tab" aria-controls="home" aria-selected="true">${brdLtWdg.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>

				<c:set var="brdRtWdg" value="${brdRtWdg}"></c:set>
				<c:forEach items="${brdRtWdg}" var="brdRtWdg" varStatus="status">
					<c:if test="${status.first }">
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
								data-bs-target="#profile" type="button" role="tab"
								aria-controls="profile" aria-selected="false">${brdRtWdg.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>
			</ul>

			<div class="tab-content" id="myTabContent" class="card-body">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<c:forEach items="${brdLtWdg}" var="brdLtWdg" varStatus="status">
						<div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${brdLtWdg.schId}/board/detail?brdNum=${brdLtWdg.brdNum}&what=${brdLtWdg.postNum}">${brdLtWdg.postTitle}</a>
							<span>${brdLtWdg.postWriteDate}</span>
						</div>
					</c:forEach>
				</div>

				<div class="tab-pane fade card" id="profile" role="tabpanel" class="card-body"
					aria-labelledby="profile-tab">
					<c:forEach items="${brdRtWdg}" var="brdRtWdg" varStatus="status">
						<div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${brdRtWdg.schId}/board/detail?brdNum=${brdRtWdg.brdNum}&what=${brdRtWdg.postNum}">${brdRtWdg.postTitle}</a>
							<span>${brdRtWdg.postWriteDate}</span>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<!--1개짜리 목록형  -->
		<div id="board1" hidden="hideen" class="card">
			<ul class="nav nav-tabs" id="myTab" role="tablist">

				<c:set var="brdOneWdg" value="${brdOneWdg}"></c:set>
				<c:forEach items="${brdOneWdg}" var="brdOneWdg" varStatus="status">
					<c:if test="${status.first}">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="contact-tab"
								data-bs-toggle="tab" data-bs-target="#contact" type="button"
								role="tab" aria-controls="contact" aria-selected="false">${brdOneWdg.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>



			</ul>

			<div class="tab-content" id="myTabContent" class="card-body">
				<div class="tab-pane fade show active" id="contact" role="tabpanel"
					ia-labelledby="contact-tab">
					<c:forEach items="${brdOneWdg}" var="brdOneWdg" varStatus="status">
						<div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${brdOneWdg.schId}/board/detail?brdNum=${brdOneWdg.brdNum}&what=${brdOneWdg.postNum}">${brdOneWdg.postTitle}</a>
							<span>${brdOneWdg.postWriteDate}</span>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>


		<!--1개짜리 이미지형  -->
		<div id="img1" hidden="hideen" class="card">

			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<c:set var="imgOneWdg" value="${imgOneWdg}"></c:set>
				<c:forEach items="${imgOneWdg}" var="imgOneWdg" varStatus="status">
					<c:if test="${status.first}">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="img-tab" data-bs-toggle="tab"
								data-bs-target="#img" type="button" role="tab"
								aria-controls="img" aria-selected="false">${imgOneWdg.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>
			</ul>

			<div class="tab-img" id="myTabImg" >
				<div class="tab-pane fade show active card-body" id="img" role="tabpanel"
					ia-labelledby="img-tab">
					<c:forEach items="${imgOneWdg}" var="imgOneWdg" varStatus="status">
						<div style=" margin-left:60px;">
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${imgOneWdg.schId}/board/detail?brdNum=${imgOneWdg.brdNum}&what=${imgOneWdg.postNum}"><img src="data:image/*;base64,${imgOneWdg.realName}" style="width:130px; height:80px;"><br>${imgOneWdg.postTitle}</a>
							<span>${imgOneWdg.postWriteDate}</span>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>



		<!--2개짜리 이미지형  -->
		<div id="img2" hidden="hideen" class="card">
			<ul class="nav nav-tabs" id="myTab" role="tablist">

				<c:set var="imgLtWdg" value="${imgLtWdg}"></c:set>
				<c:forEach items="${imgLtWdg}" var="imgLtWdg" varStatus="status">
					<c:if test="${status.first }">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="imgLtWdg-tab"
								data-bs-toggle="tab" data-bs-target="#imgLtWdg" type="button"
								role="tab" aria-controls="imgLtWdg" aria-selected="false">${imgLtWdg.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>

				<c:set var="imgRtWdg" value="${imgRtWdg}"></c:set>
				<c:forEach items="${imgRtWdg}" var="imgRtWdg" varStatus="status">
					<c:if test="${status.first}">
						<li class="nav-item" role="presentation">
							<button class="nav-link " id="imgRtWdg-tab" data-bs-toggle="tab"
								data-bs-target="#imgRtWdg" type="button" role="tab"
								aria-controls="imgRtWdg" aria-selected="true">${imgRtWdg.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>

			</ul>

			<div class="tab-content" id="myTabContent" class="card-body">
				<div class="tab-pane fade show active" id="imgLtWdg" role="tabpanel"
					aria-labelledby="imgLtWdg-tab">
					<c:forEach items="${imgLtWdg}" var="imgLtWdg" varStatus="status">
						<div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${imgLtWdg.schId}/board/detail?brdNum=${imgLtWdg.brdNum}&what=${imgLtWdg.postNum}"><img src="data:image/*;base64,${imgLtWdg.realName}" style="width:130px; height:80px;">${imgLtWdg.postTitle}</a>
							<span>${imgLtWdg.postWriteDate}</span>
						</div>
					</c:forEach>
				</div>

				<div class="tab-pane fade card" id="imgRtWdg" role="tabpanel" class="card-body"
					aria-labelledby="imgRtWdg-tab">
					<c:forEach items="${imgRtWdg}" var="imgRtWdg" varStatus="status">
						<div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${imgRtWdg.schId}/board/detail?brdNum=${imgRtWdg.brdNum}&what=${imgRtWdg.postNum}"><img src="data:image/*;base64,${imgRtWdg.realName}" style="width:130px; height:80px;">${imgRtWdg.postTitle}</a>
							<span>${imgRtWdg.postWriteDate}</span>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<!--2개짜리 비디오형  -->
		<div id="video2" class="card" hidden="hidden">
			<ul class="nav nav-tabs" id="myTab" role="tablist">

				<c:set var="vdLtWdg" value="${vdLtWdg}"></c:set>
				<c:forEach items="${vdLtWdg}" var="vdLtWdg" varStatus="status">
					<c:if test="${status.first }">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="vdLtWdg-tab"
								data-bs-toggle="tab" data-bs-target="#vdLtWdg" type="button"
								role="tab" aria-controls="vdLtWdg" aria-selected="false">${vdLtWdg.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>

				<c:set var="vdRtWdg" value="${vdRtWdg}"></c:set>
				<c:forEach items="${vdRtWdg}" var="vdRtWdg" varStatus="status">
					<c:if test="${status.first}">
						<li class="nav-item" role="presentation">
							<button class="nav-link " id="vdRtWdg-tab" data-bs-toggle="tab"
								data-bs-target="#vdRtWdg" type="button" role="tab"
								aria-controls="vdRtWdg" aria-selected="true">${vdRtWdg.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>

			</ul>

			<div class="tab-content " id="myTabContent" >
				<div class="tab-pane fade show active card-body" id="vdLtWdg" role="tabpanel"
					aria-labelledby="vdLtWdg-tab">
					<c:forEach items="${vdLtWdg}" var="vdLtWdg" varStatus="status">
						<div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${vdLtWdg.schId}/board/detail?brdNum=${vdLtWdg.brdNum}&what=${vdLtWdg.postNum}"><video src="data:video/mp4;base64,${vdLtWdg.realName}" style="width:130px; height:80px;"></video>
								${fn:substring(vdLtWdg.postTitle,0,15)}</a>
							<span>${vdLtWdg.postWriteDate}</span>
						</div>
					</c:forEach>
				</div>


				<div class="tab-pane fade card-body" id="vdRtWdg" role="tabpanel"
					aria-labelledby="vdRtWdg-tab">
					<c:forEach items="${vdRtWdg}" var="vdRtWdg" varStatus="status">
						<div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${vdRtWdg.schId}/board/detail?brdNum=${vdRtWdg.brdNum}&what=${vdRtWdg.postNum}"><video src="data:video/mp4;base64,${vdRtWdg.realName}" style="width:130px; height:80px;"></video>${vdRtWdg.postTitle}</a>
							<span>${vdRtWdg.postWriteDate}</span>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>



		<!--3개짜리 비디오형  -->
		<div id="video3" hidden="hidden" class="card">
			<ul class="nav nav-tabs" id="myTab" role="tablist">

				<c:set var="vdTriLt" value="${vdTriLt}"></c:set>
				<c:forEach items="${vdTriLt}" var="vdTriLt" varStatus="status">
					<c:if test="${status.first }">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="vdTriLt-tab"
								data-bs-toggle="tab" data-bs-target="#vdTriLt" type="button"
								role="tab" aria-controls="vdTriLt" aria-selected="false">${vdTriLt.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>

				<c:set var="vdTriMd" value="${vdTriMd}"></c:set>
				<c:forEach items="${vdTriMd}" var="vdTriMd" varStatus="status">
					<c:if test="${status.first}">
						<li class="nav-item" role="presentation">
							<button class="nav-link " id="vdTriMd-tab" data-bs-toggle="tab"
								data-bs-target="#vdTriMd" type="button" role="tab"
								aria-controls="vdTriMd" aria-selected="true">${vdTriMd.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>

				<c:set var="vdTriRt" value="${vdTriRt}"></c:set>
				<c:forEach items="${vdTriRt}" var="vdTriRt" varStatus="status">
					<c:if test="${status.first}">
						<li class="nav-item" role="presentation">
							<button class="nav-link " id="vdTriRt-tab" data-bs-toggle="tab"
								data-bs-target="#vdTriRt" type="button" role="tab"
								aria-controls="vdTriRt" aria-selected="true">${vdTriRt.brdTitle}</button>
						</li>
					</c:if>
				</c:forEach>

			</ul>

			<div class="tab-content card-body" id="myTabContent">
				<div class="tab-pane fade card-body show active container" id="vdTriLt" role="tabpanel"
					aria-labelledby="vdTriLt-tab">
					<div class="row">
					<c:forEach items="${vdTriLt}" var="vdTriLt" varStatus="status">
						<div style="width: 50%;">
							<div >
								<video src="data:video/mp4;base64,${vdTriLt.realName}" style="width:130px; height:80px;"></video>
							</div>
							<div>
								<a
									href="${pagecontext.request.contextpath}/NextPage/generation/${vdTriLt.schId}/board/detail?brdNum=${vdTriLt.brdNum}&what=${vdTriLt.postNum}">${vdTriLt.postTitle}</a>
								<span>[${vdTriLt.postWriteDate}]</span>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>


				<div class="tab-pane fade card-body container" id="vdTriMd" role="tabpanel"
					aria-labelledby="vdTriMd-tab">
					<div class="row">
					<c:forEach items="${vdTriMd}" var="vdTriMd" varStatus="status">
						<div style="width: 50%;">
							<div>
								<video src="data:video/mp4;base64,${vdTriMd.realName}" style="width:130px; height:80px;"></video>
							</div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${vdTriMd.schId}/board/detail?brdNum=${vdTriMd.brdNum}&what=${vdTriMd.postNum}">${vdTriMd.postTitle}</a>
							<span>[${vdTriMd.postWriteDate}]</span>
						</div>
					</c:forEach>
					</div>
				</div>

				<div class="tab-pane fade card-body container" id="vdTriRt" role="tabpanel"
					aria-labelledby="vdTriRt-tab">
					<div class="row">
					<c:forEach items="${vdTriRt}" var="vdTriRt" varStatus="status">
						<div style="width: 50%;">
							<div>
								<video src="data:video/mp4;base64,${vdTriRt.realName}" style="width:130px; height:80px;"></video>
							</div>
							<a
								href="${pagecontext.request.contextpath}/NextPage/generation/${vdTriRt.schId}/board/detail?brdNum=${vdTriRt.brdNum}&what=${vdTriRt.postNum}">${vdTriRt.postTitle}</a>
							<span>[${vdTriRt.postWriteDate}]</span>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
		</div>

		<!-- 알림판 -->
		<div id="noticeBrd" hidden="hidden" class="card">
			<div class="slide_wrap">
				<div class="slide_btn_box">
					알림판
					<button type="button" class="slide_btn_prev" style="bottom: 88%;">&lt;</button>
					<button type="button" class="slide_btn_next" style="bottom: 88%;">&gt;</button>
				</div>
				<hr>
				<div class="slide_box ">
					<div class="slide_list clearfix">

						<c:set var="notice" value="${notice}"></c:set>
						<c:forEach items="${notice}" var="notice" varStatus="status">
							<div class="slide_content slide0${status.count }">
								<a href="${notice.urlInfo}">
									<img class="notiImg"  src="<%=request.getContextPath() %>/resources/templatesPreview/images/alert/${notice.fileName}" style="width:200px; height:200px;">
									<%-- <img class="notiImg" alt="${status.count }.jpg" src="${pageContext.request.contextPath }/resources/img/${notice.fileName }"> --%>
								</a>
							</div>

						</c:forEach>

					</div>
					<!-- // .slide_list -->
				</div>
				<!-- // .slide_box -->

				<!-- // .slide_btn_box -->
				<ul class="slide_pagination"></ul>
				<!-- // .slide_pagination -->
			</div>
			<!-- // .slide_wrap -->
		</div>
		<!-- // .container -->

		<!-- 식단 -->
		<div id="diet" hidden="hidden" class="card" style="background-image: url('/NextPage/resources/img/식단표.png');   background-size: cover;">
			<br>
			<div class="text-center">
				<h5>오늘의 식단</h5>
				<c:if test="${diet eq null}">휴일</c:if>
				<c:if test="${diet.lunch ne null}">
					<p>점심</p>
					<p>${diet.lunch }</p>
				</c:if>
				<c:if test="${diet.dinner ne null}">
					<p>저녁<p>
					<p>${diet.dinner }<p>
				</c:if>
			</div>
		</div>
		<!-- 달력 -->
			<div class="card" id="calContainer" hidden="hidden"></div>
<!--링크리스트  -->
	<div  id="linkList" hidden="hidden">
			<c:forEach items="${linkList}" var="link" varStatus="status">
				<div class="text-center  ml-5" style="float: left;">
					<a id="linkA" href="${link.linkUrl }"  >
						<img class="linkImg ms-5" alt="${link.iconNm }" src="${pageContext.request.contextPath }/resources/templatesPreview/images/widget/${link.iconFileName}">
						<br>
						<span style="margin-left: 51px;"> ${link.linkTitle }</span>
					</a>
				</div>
			</c:forEach>
	</div>

</div>




	<!-- 하단 배너 -->
	<div class="container">
		<div class="banner_wraper justify-content-center m-3">
			<c:set var="banner" value="${banner}"></c:set>
				<c:forEach items="${banner}" var="banner" varStatus="status">
					<a href="${banner.bnrLkUrl }"><img  alt="${banner.bnrLkNm }" src="${pageContext.request.contextPath }/resources/templatesPreview/images/banner/${banner.bnrLkImg }"></a>
				</c:forEach>
		</div>
	</div>

</div>

<br>



	<script type="text/javascript" defer="defer">
		//client rolling banner
		window.onload = function() {
			var bannerLeft = 0;
			var first = 1;
			var last;
			var imgCnt = 0;
			var $img = $(".banner_wraper img");
			var $first;
			var $last;

			$img.each(function() { // 5px 간격으로 배너 처음 위치 시킴
				$(this).css("left", bannerLeft);
				bannerLeft += $(this).width()+5;
				$(this).attr("id", "banner" + (++imgCnt)); // img에 id 속성 추가
			});

			if (imgCnt > 5) { //배너 5개 이상이면 이동시킴

				last = imgCnt;

				var loopInterval = setInterval(function nextMove() {
					$img.each(function() {
						$(this).css("left", $(this).position().left - 1); // 1px씩 왼쪽으로 이동
					});
					$first = $("#banner" + first);
					$last = $("#banner" + last);
					if ($first.position().left < -50) { // 제일 앞에 배너 제일 뒤로 옮김
						$first.css("left", $last.position().left
								+ $last.width()+10);
						first++;
						last++;
						if (last > imgCnt) {
							last = 1;
						}
						if (first > imgCnt) {
							first = 1;
						}
					}
				}, 50); //여기 값을 조정하면 속도를 조정할 수 있다.(위에 1px 이동하는 부분도 조정하면

				//깔끔하게 변경가능하다

				// 슬라이드에 마우스가 올라간 경우 루프 멈추기
				$('.banner_wraper').on('mouseover', function() {
					clearInterval(loopInterval);
				});

			}
			$('.banner_wraper').on(
					'mouseout',
					function() {
						loopInterval = setInterval(function() {
							$img.each(function() {
								$(this)
										.css("left",
												$(this).position().left - 1); // 1px씩 왼쪽으로 이동
							});
							$first = $("#banner" + first);
							$last = $("#banner" + last);
							if ($first.position().left < -5) { // 제일 앞에 배너 제일 뒤로 옮김
								$first.css("left", $last.position().left
										+ $last.width() + 5);
								first++;
								last++;
								if (last > imgCnt) {
									last = 1;
								}
								if (first > imgCnt) {
									first = 1;
								}
							}
						}, 50);
					});

		};

		//알림판위젯
		(function() {
			const slideList = document.querySelector('.slide_list'); // Slide parent dom
			const slideContents = document.querySelectorAll('.slide_content'); // each slide dom
			const slideBtnNext = document.querySelector('.slide_btn_next'); // next button
			const slideBtnPrev = document.querySelector('.slide_btn_prev'); // prev button
			const pagination = document.querySelector('.slide_pagination');
			const slideLen = slideContents.length; // slide length
			const slideWidth = 200; // slide width
			const slideSpeed = 300; // slide speed
			const startNum = 0; // initial slide index (0 ~ 4)

			slideList.style.width = slideWidth * (slideLen + 2) + "px";

			// Copy first and last slide
			let firstChild = slideList.firstElementChild;
			let lastChild = slideList.lastElementChild;
			let clonedFirst = firstChild.cloneNode(true);
			let clonedLast = lastChild.cloneNode(true);

			// Add copied Slides
			slideList.appendChild(clonedFirst);
			slideList.insertBefore(clonedLast, slideList.firstElementChild);

			// Add pagination dynamically
			let pageChild = '';
			for (var i = 0; i < slideLen; i++) {
				pageChild += '<li class="dot';
				pageChild += (i === startNum) ? ' dot_active' : '';
				pageChild += '" data-index="' + i + '"><a href="#"></a></li>';
			}
			pagination.innerHTML = pageChild;
			const pageDots = document.querySelectorAll('.dot'); // each dot from pagination

			slideList.style.transform = "translate3d(-"
					+ (slideWidth * (startNum + 1)) + "px, 0px, 0px)";

			let curIndex = startNum; // current slide index (except copied slide)
			let curSlide = slideContents[curIndex]; // current slide dom
			curSlide.classList.add('slide_active');

			/** Next Button Event */
			slideBtnNext.addEventListener('click', function() {
				if (curIndex <= slideLen - 1) {
					slideList.style.transition = slideSpeed + "ms";
					slideList.style.transform = "translate3d(-"
							+ (slideWidth * (curIndex + 2)) + "px, 0px, 0px)";
				}
				if (curIndex === slideLen - 1) {
					setTimeout(function() {
						slideList.style.transition = "0ms";
						slideList.style.transform = "translate3d(-"
								+ slideWidth + "px, 0px, 0px)";
					}, slideSpeed);
					curIndex = -1;
				}
				curSlide.classList.remove('slide_active');
				pageDots[(curIndex === -1) ? slideLen - 1 : curIndex].classList
						.remove('dot_active');
				curSlide = slideContents[++curIndex];
				curSlide.classList.add('slide_active');
				pageDots[curIndex].classList.add('dot_active');
			});

			/** Prev Button Event */
			slideBtnPrev.addEventListener('click', function() {
				if (curIndex >= 0) {
					slideList.style.transition = slideSpeed + "ms";
					slideList.style.transform = "translate3d(-"
							+ (slideWidth * curIndex) + "px, 0px, 0px)";
				}
				if (curIndex === 0) {
					setTimeout(function() {
						slideList.style.transition = "0ms";
						slideList.style.transform = "translate3d(-"
								+ (slideWidth * slideLen) + "px, 0px, 0px)";
					}, slideSpeed);
					curIndex = slideLen;
				}
				curSlide.classList.remove('slide_active');
				pageDots[(curIndex === slideLen) ? 0 : curIndex].classList
						.remove('dot_active');
				curSlide = slideContents[--curIndex];
				curSlide.classList.add('slide_active');
				pageDots[curIndex].classList.add('dot_active');
			});

			/** Pagination Button Event */
			let curDot;
			Array.prototype.forEach.call(pageDots, function(dot, i) {
				dot.addEventListener('click', function(e) {
					e.preventDefault();
					curDot = document.querySelector('.dot_active');
					curDot.classList.remove('dot_active');

					curDot = this;
					this.classList.add('dot_active');

					curSlide.classList.remove('slide_active');
					curIndex = Number(this.getAttribute('data-index'));
					curSlide = slideContents[curIndex];
					curSlide.classList.add('slide_active');
					slideList.style.transition = slideSpeed + "ms";
					slideList.style.transform = "translate3d(-"
							+ (slideWidth * (curIndex + 1)) + "px, 0px, 0px)";
				});
			});
		})();

		var tdss = document.querySelectorAll(".tds");
		//console.log(tdss);
		let board2 = $('#board2');
		let board = $('#board1');
		let img = $('#img1');
		let img2 = $('#img2');
		let video2 = $('#video2');
		let video3 = $('#video3');
		let noticeBrd = $('#noticeBrd');
		let diet = $('#diet');
		let calendar = $('#calContainer');
		let linkList = $('#linkList');

		for (let i = 0; i < tdss.length; i++) {
			// 	var figure = $("<figure>");

			// 	console.log(tdss[i].id);

			<c:choose>
			<c:when test="${not empty prjDiv}">
			<c:forEach items="${prjDiv}" var="prjDiv">
			if (tdss[i].id == "${prjDiv.divNum}") {

				console.log("tdss id값 : ", tdss[i].id);
				console.log("divValue : ", "${prjDiv.divValue}");
				console.log("divNm :  ", "${prjDiv.divNum}");

				if ("${prjDiv.divValue}" == "board2") {
					board2.removeAttr('hidden');
					$(tdss[i]).html(board2);
				} else if ("${prjDiv.divValue}" == "board1") {
					board.removeAttr('hidden');
					$(tdss[i]).html(board);
				} else if ("${prjDiv.divValue}" == "imageBoard1") {
					img.removeAttr('hidden');
					$(tdss[i]).html(img);

				} else if ("${prjDiv.divValue}" == "imageBoard2") {
					img2.removeAttr('hidden');
					$(tdss[i]).html(img2);

				} else if ("${prjDiv.divValue}" == "videoBoard1") {
					video2.removeAttr('hidden');
					$(tdss[i]).html(video2);

				} else if ("${prjDiv.divValue}" == "videoBoard2") {
					video3.removeAttr('hidden');
					$(tdss[i]).html(video3);

				} else if ("${prjDiv.divValue}" == "noticeBoard") {
					noticeBrd.removeAttr('hidden');
					$(tdss[i]).html(noticeBrd);

				} else if ("${prjDiv.divValue}" == "diet") {
					diet.removeAttr('hidden');
					$(tdss[i]).html(diet);

				} else if ("${prjDiv.divValue}" == "calendar") {
					calendar.removeAttr('hidden');
					$(tdss[i]).html(calendar);
				}else if ("${prjDiv.divValue}" == "linkWidget") {
						linkList.removeAttr('hidden');
						$(tdss[i]).html(linkList);

				}else {
					$(tdss[i]).html("${prjDiv.divValue}");
				}

				/* if(tdss[i].id == "${prjDiv.divNum}"){

					console.log(tdss[i]);
					console.log("${prjDiv.divValue}");
					console.log("이궐ㄴ이"+"${prjDiv}");

				// 					tdss[i].html(myTab);

					//let tdsv = $(tdss[i]).html("${prjDiv.divValue}");
					let tdsv = $(tdss[i]).html(myTab);
					//console.log(tdsv);


				} */
			}
			</c:forEach>
			</c:when>

			</c:choose>

		}
		/*
		 let myTab = $('#board2');
		 let div1 = $("#div1");

		 div1.html(myTab); */
	</script>

	<script type="text/javascript">

// 	$(function(){

// 	$("#calContainer").simpleCalendar();

// 		});
	$("#calContainer").simpleCalendar({
		 months: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
		  days: ['일', '월', '화', '수', '목', '금', '토'],

		  // displays events
		  displayEvent: true,

		  // event dates
		  events: [
		    // generate new event after tomorrow for one hour
			  <c:forEach items="${calendar}" var="calendar" varStatus="status">
			    {
			      startDate:"${calendar.caldStartDate}",
			      endDate: "${calendar.caldEndDate}",
			      summary: "${calendar.schedule}"
			    },
			   	<c:if test="${status.last eq false}">,</c:if>
			    </c:forEach>
			  ],


		  // disable showing event details
		  disableEventDetails: false,

		  // disable showing empty date details
		  disableEmptyDetails: false

		});
	$("#calContainer").simpleCalendar({

		  displayYear: true

		});


$("#calContainer").simpleCalendar({

		  fixedStartDay: true

});
	$("#calContainer").simpleCalendar({

		  // called after init
		  onInit: function (calendar) {},

		  // called on month change
		  onMonthChange: function (month, year) {},

		  // called on date selection
		  onDateSelect: function (date, events) {}

		});


	</script>
