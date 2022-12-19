<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="app">
	<div id="sidebar" class="active">
		<div class="sidebar-wrapper active">
			<div class="sidebar-header">
				<div class="d-flex justify-content-between">
					<div class="logo">
						<a href="<%=request.getContextPath()%>/operator/index">
							Admin System </a>
					</div>
					<div class="toggler">
						<a href="#" class="sidebar-hide d-xl-none d-block"><i
							class="bi bi-x bi-middle"></i></a>
					</div>
				</div>
			</div>
			<div class="sidebar-menu">
				<ul class="menu">

					<li class="sidebar-item active "><a
						href="<%=request.getContextPath()%>/operator/index"
						class='sidebar-link'> <i class="bi bi-grid-fill"></i> <span>Home</span>
					</a></li>

					<li class="sidebar-item  has-sub"><a href="#"
						class='sidebar-link'> <i class="bi bi-stack"></i> <span>회원관리</span>
					</a>
						<ul class="submenu ">
							<li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/school/list">회원조회</a>
							</li>
						</ul></li>

					<li class="sidebar-item  has-sub"><a href="#"
						class='sidebar-link'> <i class="bi bi-collection-fill"></i> <span>권한관리</span>
					</a>
						<ul class="submenu ">
							<li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/selectAuthority">권한조회</a>
							</li>
						</ul></li>

					<li class="sidebar-item  has-sub"><a href="#"
						class='sidebar-link'> <i class="bi bi-bar-chart-fill"></i> <span>통계분석</span>
					</a>
						<ul class="submenu ">
							<li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/visit/status">방문/템플릿</a>
							</li>
							<%-- <li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/inflowTime">유입시간대</a>
							</li> --%>
							<%-- <li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/analysisTemplate">템플릿거래현황</a>
							</li> --%>
							<%-- <li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/incomeStatus">게시물별
									조회수</a></li> --%>
							<%-- <li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/paymentStatus">수익현황</a>
							</li> --%>
						</ul></li>


					<li class="sidebar-item  has-sub"><a href="#"
						class='sidebar-link'> <i class="bi bi-cash"></i> <span>결제</span>
					</a>
						<ul class="submenu ">
							<li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/paymentStatus">결제현황</a>
							</li>
						</ul></li>



					<li class="sidebar-item  has-sub"><a href="#"
						class='sidebar-link'> <i class="bi bi-pen-fill"></i> <span>로그관리</span>
					</a>
						<ul class="submenu ">
							<li class="submenu-item "><a
								href="<%=request.getContextPath()%>/operator/login_logout_log">이력조회</a>
							</li>
						</ul></li>

						<li class="sidebar-item  has-sub"><a href="#"
						class='sidebar-link'> <i class="bi bi-person-badge-fill"></i> <span>1:1문의</span>
						</a>
							<ul class="submenu ">
								<li class="submenu-item "><a
									href="<%=request.getContextPath()%>/operator/onetoOneAsk">문의목록</a>
								</li>
							</ul>
						</li>

				</ul>
			</div>
			<button class="sidebar-toggler btn x">
				<i data-feather="x"></i>
			</button>
		</div>
	</div>