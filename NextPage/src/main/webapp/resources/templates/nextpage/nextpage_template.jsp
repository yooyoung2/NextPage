<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:getAsString name="title" /></title>
<link href="<c:url value='/resources/css/dashboard.css' />" rel="stylesheet"></link>
</head>
<style>
#main{
margin-left: 250px;
    min-height: 100vh;
    transition: 0.5s;
}

</style>
<body>
	
	<section id="preScript">
		<tiles:insertAttribute name="preScript" />
	</section>


	<header id="headerMenu">
		<tiles:insertAttribute name="headerMenu" />
	</header>

	<section id="leftMenu" style="margin-top:0%;" class="d-flex flex-column flex-shrink-0 p-3 bg-light">
        <tiles:insertAttribute name="leftMenu" />
    </section>

	<section id="main" style="min-height: 0vh;">
		<tiles:insertAttribute name="main" />
	</section>

	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
	
	<section id="postScript">
		<tiles:insertAttribute name="postScript" />
	</section>
</body>
</html>
