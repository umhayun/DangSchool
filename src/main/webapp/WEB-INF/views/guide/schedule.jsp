<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container"> 
	<div class="b_header">
		<div class="col-7 b_menu ">
			<h4><strong>| 수업일정 </strong>| <small> 시간표 입니다.</small></h4>
		</div>
	</div>
	<div class="b_body col-7">
		<div class="b_menu">
			<img src="${pageContext.request.contextPath}/resources/img/schedule.png" alt="시간표 이미지" >
		</div>
		<div class="b_menu">
			<img src="${pageContext.request.contextPath}/resources/img/schedule2.png" alt="시간표 이미지">
		</div>
		
	</div>
</div>
<%@ include file="../include/footer.jsp" %>
</body>
</html>