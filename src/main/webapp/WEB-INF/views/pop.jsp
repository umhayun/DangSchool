<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3월 시간표</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		var layer = $('.layerPop');
    	var btnClose = $('.btn-close');

		//닫기버튼 누를시 하루동안 열지않기
		cookiedata = document.cookie;

		function setCookie( name, value, expiredays ) {
        	var todayDate = new Date();
        	todayDate.setDate( todayDate.getDate() + expiredays ); 
        	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" ;
    	}

		btnClose.on("click", function(){
        	//expiredays의 1은 하루를 의미한다, 일주일은 7, 1년은 365로 입력
			setCookie( "layerCookie", "done" , 1);
			window.close();
		})
	});

</script>
</head>
<body>
<div class= "layerPopup">
 	<div class="inform-layer">
 		<div class="cont">
 			<img alt="3월 시간표" src="${pageContext.request.contextPath}/resources/img/schedule.png" width="497", height="570">
 		</div>
 		<div class="btn-popup-close">		
        	<a href="#" id="btn-inform-close" class="btn-close" title="오늘하루 보지않기"><span class="blind">닫기</span></a>
        </div>
    </div>    	
</div> 
</body>
</html>