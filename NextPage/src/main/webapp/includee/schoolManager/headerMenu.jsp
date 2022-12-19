<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

            <!-- Navbar Start -->
            <nav class="navbar navbar-expand">
                <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>

<!--                 <form class="d-none d-md-flex ms-4"> -->
<!--                     <input class="form-control bg-dark border-0" type="search" placeholder="Search"> -->
<!--                 </form> -->
                <div class="navbar-nav align-items-center" style="margin-left: 75%;">
                    <div class="nav-item dropdown">
                    	<a href="${pageContext.request.contextPath }/nextpage/nextPageMain"  class="dropdown-item"><button class="btn-primary rounded-pill ">Next Page 바로가기</button></a>
                    </div>
                </div>
                <div class="navbar-nav align-items-center ms-auto">
                    <div class="nav-item dropdown">
                     <form name="logoutForm" method="post" action="${pageContext.request.contextPath }/login/logout.do">
                      </form> <a href="#" onclick="document.logoutForm.submit(); return false;" class="dropdown-item"><button class="btn-danger rounded-pill ">LogOut</button></a>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->