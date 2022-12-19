<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900"
	rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/fonts/icomoon/style.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/jquery-ui.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/owl.theme.default.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/owl.theme.default.min.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/jquery.fancybox.min.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/bootstrap-datepicker.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/aos.css">
<link href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/templates/template01/template01Index/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.6.1.min.js"></script>

<!-- sweet alert -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


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
</head>