<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

     <!-- Site Metas -->
    <title>SmartEDU - Education Responsive HTML5 Template</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <!--
    	/NextPage3/src/main/webapp/resources/templates/template03/css
     -->
     <!--
     	/NextPage3/src/main/webapp/resources/templates/template03/images
      -->
    <link rel="shortcut icon" href="<%= request.getContextPath() %>/resources/templates/template03/images/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="<%= request.getContextPath() %>/resources/templates/template03/images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/templates/template03/css/bootstrap.min.css">
    <!-- Site CSS -->
    <!--
    	/NextPage3/src/main/webapp/resources/templates/template03
     -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/templates/template03/style.css">
    <!-- ALL VERSION CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/templates/template03/css/versions.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/templates/template03/css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/templates/template03/css/custom.css">
<link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
  />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.6.1.min.js"></script>    <!--[if lt IE 9]>

<c:if test="${not empty message }">
	<script type="text/javascript">
	Swal.fire({
		  position: 'center',
		  icon: 'success',
		  title: '${message}',
		  showConfirmButton: false,
		  timer: 1500
		});
	</script>
</c:if>

	<!--
		/NextPage3/src/main/webapp/resources/templates/template03/js
	 -->
    <!-- Modernizer for Portfolio -->
    <script src="<%= request.getContextPath() %>/resources/templates/template03/js/modernizer.js"></script>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->