<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="app container-fluid position-relative d-flex p-0">
		<div id="sidebar" class="active">
			<div class="sidebar-wrapper active">
			<div>
					<div class="d-flex justify-content-between">
						<div class="logo">
<%-- 							<a href="<%=request.getContextPath()%>/school/manager/school/manage/index">
							</a> --%>
						</div>
								<img src="<%=request.getContextPath()%>/resources/templates/schoolmanager/img/Production.png"
								style="width:100%; margin-top:10%;">
						<div class="toggler">
							<a href="#" class="sidebar-hide d-xl-none d-block"><i
								class="bi bi-x bi-middle"></i></a>
						</div>
					</div>
				</div>
				<div class="sidebar-menu">
					<ul class="menu">

						<li class="sidebar-item active ">
							<a href="<%=request.getContextPath()%>/school/manager/school/manage/index" class='sidebar-link'>
								<i class="bi bi-grid-fill"></i>
								<span>Home</span>
							</a>
						</li>
						<li class="sidebar-item">
                            <a href="<%=request.getContextPath()%>/school/manager/home/page/manage" class="sidebar-link">
                                <i class="bi bi-hexagon-fill"></i>
                                <span>메인화면관리</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a href="<%=request.getContextPath()%>/school/manager/menu/manage" class="sidebar-link">
                                <i class="bi bi-grid-1x2-fill"></i>
                                <span>메뉴관리</span>
                            </a>
                        </li>


						<li class="sidebar-item  has-sub"><a href="#"
							class='sidebar-link'> <i class="bi bi-stack"></i> <span>기능관리</span>
						</a>
							<ul class="submenu ">
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/menu/hello">인사말</a>
								</li>
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/schoolHistory">연혁</a>
								</li>
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/school/symbol">학교상징</a>
								</li>
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/school/song">교가</a>
								</li>
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/on/the/way">오시는길</a>
								</li>
							</ul>

						</li>


						<li class="sidebar-item  has-sub">
						<a href="<%=request.getContextPath()%>/school/manager/board/manage" class='sidebar-link'> <i class="bi bi-pen-fill"></i> <span>게시판관리</span>
						</a>
							<ul class="submenu ">
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/board/manage">게시판관리</a>
								</li>
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/schoolManager/postManage">게시물관리</a>
								</li>

							</ul>
						</li>


                        <li class="sidebar-item">
                            <a href="<%=request.getContextPath()%>/school/manager/content/list" class="sidebar-link">
                                <i class="bi bi-file-earmark-spreadsheet-fill"></i>
                                <span>콘텐츠관리</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a href="<%=request.getContextPath()%>/school/manager/Log" class="sidebar-link">
                                <i class="bi bi-collection-fill"></i>
                                <span>이력관리</span>
                            </a>
                        </li>

<!-- 						<li class="sidebar-item  has-sub"> -->
<!-- 						<a href="#" class='sidebar-link'> <i class="bi bi-collection-fill"></i> <span>이력관리</span> -->
<!-- 						</a> -->
<!-- 							<ul class="submenu "> -->
<!-- 								<li class="submenu-item "><a -->
<%-- 									href="<%=request.getContextPath()%>/school/manager/member/history">회원이력</a> --%>
<!-- 								</li> -->
<!-- 								<li class="submenu-item "><a -->
<%-- 									href="<%=request.getContextPath()%>/school/manager/menu/history">메뉴이력</a> --%>
<!-- 								</li> -->
<!-- 								<li class="submenu-item "><a -->
<%-- 									href="<%=request.getContextPath()%>/school/manager/board/history">게시판이력</a> --%>
<!-- 								</li> -->
<!-- 								<li class="submenu-item "><a -->
<%-- 									href="<%=request.getContextPath()%>/school/manager/post/history">게시물이력</a> --%>
<!-- 								</li> -->

<!-- 							</ul> -->
<!-- 						</li> -->

						<li class="sidebar-item  has-sub"><a href="#"
							class='sidebar-link'> <i class="bi bi-person-badge-fill"></i> <span>회원등록</span>
						</a>
							<ul class="submenu ">
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/student/insert">신입생등록</a>
								</li>
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/studentClass/insert">학년/반 등록</a>
								</li>
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/teacher/insert">교사 등록</a>
								</li>
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/teacherClass/insert">담임 등록</a>
								</li>
							</ul></li>

						<li class="sidebar-item">
                            <a href="<%=request.getContextPath()%>/school/manager/member/list" class="sidebar-link">
                            <i class="bi bi-file-earmark-medical-fill"></i>
                                <span>회원관리</span>
                            </a>
                        </li>


						<li class="sidebar-item  has-sub"><a href="<%=request.getContextPath()%>/school/manager/my/question/myQuestionList"
							class='sidebar-link'> <i class="bi bi-chat-dots-fill"></i> <span>1:1문의</span>
						</a>
							<ul class="submenu ">
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/school/manager/my/question/myQuestionList">내 문의목록</a>
								</li>

							</ul></li>
							</ul>
				</div>
			</div>
		</div>
