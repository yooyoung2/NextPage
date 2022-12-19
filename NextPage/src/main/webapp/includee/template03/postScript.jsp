<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- ALL JS FILES -->
    <script src="<%= request.getContextPath() %>/resources/templates/template03/js/all.js"></script>
    <!-- ALL PLUGINS -->
    <script src="<%= request.getContextPath() %>/resources/templates/template03/js/custom.js"></script>
	<script src="<%= request.getContextPath() %>/resources/templates/template03/js/timeline.min.js"></script>
	<script>
		timeline(document.querySelectorAll('.timeline'), {
			forceVerticalMode: 700,
			mode: 'horizontal',
			verticalStartPosition: 'left',
			visibleItems: 4
		});
	</script>