<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='en'>
<head>
<h1>달력입니다.</h1>
<meta charset='utf-8' />
<link href='fullcalendar/main.css' rel='stylesheet' />
<script src='fullcalendar/main.js'></script>
<script>
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {
						var calendarEl = document.getElementById('calendar');
						var calendar = new FullCalendar.Calendar(
								calendarEl,
								{
									initialView : 'dayGridMonth',
									googleCalendarApiKey : 'AIzaSyA_WrD4_uVom_UACX1MmjPlwHgHbRB17BI',
									events : {
										googleCalendarId : '0v0d6q9s9frkbs74rveqv74luc@group.calendar.google.com',
										className : 'gcal-event' //an option!
									}
								});
						calendar.render();
					});
</script>
<style>
#calendar {
	width: 500px;
	height: 500px;
	resize: both;
	overflow: auto;
}
</style>
</head>
<body>
	<div id="gunho"></div>
	<div id='calendar'></div>
</body>
</html>

<!-- 
let calendar=new Calendar(calendarEl,{
plugins: [googleCalendarPlugin],
googleCalendarApiKey: '<YOUR API KEY>',
events: {
googleCalendarId: 'abcd1234@group.calendar.google.com',
className: 'gcal-event' //an option!
}
});
 -->