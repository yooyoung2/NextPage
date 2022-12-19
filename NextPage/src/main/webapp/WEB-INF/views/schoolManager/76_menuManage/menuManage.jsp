<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />

<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script> -->
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>

<style>
.menu2 {
	margin-top : 1%;
    padding: 5px 10px;
    background-color: ghostwhite;
    color: darkslategrey;
    font-family: none;
    font-weight: 550;
    border-radius: 10px;
    margin-bottom: 1%;
    padding: 5px 10px;
}
/* #menuCon{
    border-radius: 10px;
    background-color: #002e5c82;
    padding: 5px 10px;
    margin: -25px;
    margin-bottom: 1%;
} */

.menu1 {
	padding : 10px 15px;
	margin-top : 1%;
	border-radius: 15px;
	background-color: currentcolor;
	cursor: pointer;
}

.hide {
	display: none;
}

ul li {
	
	list-style: none;
}
#topul{
	padding-left: 0rem;
}
.btn-light {
	font-weight: bold;
}
/* .btn-info{
	font-weight: bold;
	background-color: #80c2cf;
    border-color: #80c2cf;
} */
.btn-dark{
	font-weight: bold;
}
#topmenu{
	float: right;
    margin-top: -5%;
}
</style>
<div><h3 style="margin-left: 2%;">메뉴  관리</h3></div>
<div class="content" style="margin-top: 3%;">
<br>
<input type="button" value="최상위메뉴추가" id="topmenu" class="btn btn-warning" data-bs-toggle="modal" data-menuid="0" data-bs-target="#exampleModal" >


<div id="itemBoxWrap">${genMenuList }</div>


<%-- <div id="ttt">
	<c:set var="genMenuList" value="${genMenuList }" />
	<c:choose>
		<c:when test="${not empty genMenuList }">
			<div>
				<ul>
					<c:forEach items="${genMenuList }" var="genMenu">
						<c:if test="${genMenu['level'] eq 1 }">
							<li class="menu"><a> ${genMenu['menuNm'] } </a><input
								type="button" value="설정"> <input
								data-menuid="${genMenu['menuId'] }" data-bs-toggle="modal"
								data-bs-target="#exampleModal" type="button" value="하위메뉴추가">
							</li>
						</c:if>
						<ul class="hide">
							<c:if test="${genMenu['level'] eq 2 }">

								<li>${genMenu['menuNm'] }<input type="button" value="설정">
								</li>

							</c:if>
						</ul>
					</c:forEach>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">회원이 없음.</td>
			</tr>
		</c:otherwise>
	</c:choose>
</div> --%>


<!-- The Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-scrollable modal-xl">
		<div class="modal-content" style="width: 75%;margin-left: 25%;">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">메뉴 추가</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">...</div>
			<div class="modal-footer">
				
				<button type="button" class="btn btn-primary" id="addBtn" data-menuid="123">추가</button>
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<!-- The Modal -->
<div class="modal fade" id="exampleModal2" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-scrollable modal-xl">
		<div class="modal-content" style="width: 75%;margin-left: 25%;">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">설정 수정</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">...</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" id="delBtn" data-menuid="">삭제</button>
				<button type="button" class="btn btn-primary" id="updateBtn" >수정</button>
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
</div>


<form id='viewForm' action="/NextPage/school/manager/menu/add" method="get">
	<input type='hidden' name='menuid' />
</form>

<form id='viewForm2' action="/NextPage/school/manager/menu/update" method="get">
	<input type='hidden' name='menuid' />
</form>

<script type="text/javascript" src="/NextPage/resources/js/schoolManager/genMenuInfo.js"></script>

<script type="text/javascript">

	// html dom 이 다 로딩된 후 실행된다.
	$(document).ready(function() {
		// menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
		$(".menu1>a").click(function() {

			var submenu = $(this).next("ul");
			
			// submenu 가 화면상에 보일때는 위로 부드랍게 접고 아니면 아래로 부드랍게 펼치기
			if (submenu.is(":visible")) {
				submenu.slideUp();
			} else {
				submenu.slideDown();
			}
		});
	});
</script>
