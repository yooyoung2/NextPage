<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
.sidebar-wrapper .menu {
    margin-top: 40%;
    }
</style>

	<div class="app container-fluid position-relative d-flex p-0">
		<div id="sidebar" class="active">
			<div class="sidebar-wrapper active">
			<div>
					<div class="d-flex justify-content-between">
						<div class="logo">

						</div>

						<div class="toggler">
							<a href="#" class="sidebar-hide d-xl-none d-block">
								<i class="bi bi-x bi-middle"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="sidebar-menu">
					<ul class="menu">
						<li class="sidebar-item">
                            <a href="<%=request.getContextPath() %>/nextpage/mypage/info" class="sidebar-link">
                                <i class="bi bi-person-badge"></i></i>
                                <span>내 정보</span>
                            </a>
                        </li>

 						<li class="sidebar-item  has-sub">
							<a href="" class='sidebar-link'>
								<i class="bi bi-person-badge-fill"></i>
								<span>정보수정</span>
							</a>
							<ul class="submenu ">
								<li class="submenu-item ">
									<a href="<%=request.getContextPath() %>/nextpage/checkPass/updateInfoForm" class="a">계정수정</a>
								</li>
								<li class="submenu-item ">
									<a href="<%=request.getContextPath() %>/nextpage/checkPass/updatePass" class="a">비밀번호 수정</a>
								</li>
								<li class="submenu-item ">
									<a href="<%=request.getContextPath() %>/nextpage/mypage/delete/checkPass" class="a">계정탈퇴</a>
								</li>
							</ul>
						</li>      


						<li class="sidebar-item  has-sub">
						<a href="#" class='sidebar-link'> <i class="bi bi-stack"></i>
							<span>결제관리</span>
						</a>
							<ul class="submenu">
								<li class="submenu-item ">
									<a href="<%=request.getContextPath() %>/nextpage/mypage/ticket/buy" class="a">이용권 구매</a>
								</li>
								
								<li class="submenu-item ">
									<a href="<%=request.getContextPath() %>/nextpage/mypage/payCancel" class="a">이용권 취소</a>
								</li>
								
								<li class="submenu-item ">
									<a href="<%=request.getContextPath() %>/nextpage/payment/info" class="a">결제정보</a>
								</li>
								
								<li class="submenu-item ">
									<a href="<%=request.getContextPath() %>/nextpage/mypage/cartList" class="a">장바구니</a>
								</li>
							</ul>

						</li>


<!-- 						<li class="sidebar-item  has-sub"> -->
<!-- 							<a href="#"	class='sidebar-link'> -->
<!-- 								<i class="bi bi-chat-dots-fill"></i> -->
<!-- 								<span>1:1문의</span> -->
<!-- 							</a> -->
<!-- 							<ul class="submenu "> -->
<!-- 								<li class="submenu-item "> -->
<%-- 									<a href="<%=request.getContextPath() %>/nextpage/myOtoList">1:1 문의 내역</a> --%>
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</li> -->

						<li class="sidebar-item">
                            <a href="#" onclick="authBuy()" class="sidebar-link">
                                <i class="bi bi-hexagon-fill"></i>
                                <span>홈페이지 관리</span>
                            </a>
                        </li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
<script>
function authBuy(){
	$.ajax({
		url :'${pageContext.request.contextPath}/school/manager/school/manage/authValidate',
		method : "get",
		dataType : "html",
		success : function(resp) {
			if(resp == 'YES'){
				location.replace('${pageContext.request.contextPath}/school/manager/school/manage/index') ;
			}else{
				alert('이용 권한이 없습니다! 결제 후 이용해주세요');
			}
		},
		error : function(errorResp) {
			console.log(errorResp.status);
			console.log(errorResp.msg);
		}
	});	
	
}
</script>