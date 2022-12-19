<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.row:not(.form-label){
  display: block;
/*   justify-content: center; */
  align-items: center;
  margin-top: 6%;
}
.form-control{
text-align : center;
}
.col-5 {
    display : flex;
    flex: 0 0 auto;
    width: 70%;
	padding-top: 11px;
    margin-left: 14%;
    
}

.card-front{
    width: 80%;
    height: 600px;
    background-color: white;
    transition: box-shadow .3s;
    border-radius: 10px;
    border: 1px solid #ccc;
    box-shadow: 0 0 11px rgb(33 33 33 / 20%);
    background-position: bottom center;
    background-repeat: no-repeat;
    background-size: 300%;
    border-radius: 6px;
 	left: 13%;
  	top: 0;
  	margin-left: 8%;
    margin-top: 7%;
}

.form-label{
    width: 133px;
    text-align : center;
}

#hTag{
	text-align: center;
    padding-top: 10%;
    margin-bottom: 3%;
}
hr{
    margin-top: 30px;
    
	border-top-style: dotted;
	border-top-width: 7px;
	border-top-color: blue;
	background : white;
	width : 50px;
	text-align:center;
	margin: 0px auto;
}

</style>

<main class="main" id="top">

				<div class="card-front">
					<h1 id="hTag">내 정보</h1>
					<hr >
					<form class="row g-3">
						<div class="col-5">
							<label class="form-label" for="inputName">ID</label>
							<input class="form-control" id="inputName" type="text"
								value="${schvo['schId'] }" readonly />
						</div>
						<div class="col-5">
							<label class="form-label" for="inputPassword">학교명</label>
							<input class="form-control" id="inputPassword" type="text"
								placeholder="${schvo['schNm'] }" readonly />
						</div>
						<div class="col-5">
							<label class="form-label" for="inputRetypePassword">학교이메일</label>
							<input class="form-control" id="inputRetypePassword" type="email"
								placeholder="${schvo['schEmail'] }" readonly />
						</div>
						<div class="col-5">
							<label class="form-label" for="inputRetypePassword">전화번호</label>
							<input class="form-control" id="inputRetypePassword"
								placeholder="${schvo['schTelNum'] }" readonly />
						</div>
						<div class="col-5">
							<label class="form-label" for="inputCompanyName">학교주소</label> <input
								class="form-control" id="inputCompanyName" type="text"
								placeholder="${schvo['schAddr1'] }" readonly />
						</div>
					</form>
				</div>					

<!-- <section> close ============================--> <!-- ============================================-->


</main>


