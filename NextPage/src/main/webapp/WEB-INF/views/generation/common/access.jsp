<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/templates/operator/assets/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/templates/operator/assets/vendors/bootstrap-icons/bootstrap-icons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/templates/operator/assets/css/app.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/templates/operator/assets/css/pages/error.css">
<body>
    <div id="error" style="background-color: ghostwhite;">


        <div class="error-page container">
            <div class="col-md-8 col-12 offset-md-2">
                <img class="img-error" src="<%=request.getContextPath()%>/resources/templates/template01/template01Index/images/error-500.png" alt="Not Found">
                <div class="text-center">
                    <h1 class="error-title">메뉴 접근권한이 없습니다.</h1>
                    <input type="button" onclick="history.go(-1);" class="btn btn-lg btn-outline-primary mt-3" value="뒤로 가기">
                </div>
            </div>
        </div>


    </div>
</body>
