<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
 

<div class="container"> 

	<div class="col">
		<div class="col-10 b_menu">
			<h4><strong>| 수업일정</strong> | <small> 교육안내 입니다.</small></h4>
		</div>
		
        <div class="col-10 training b_header" style="margin:5% auto 10% auto;">
        	 <h3><span>00</span> 교육진행과정 안내</h3>
        	 <p class="study_step"><img src="${pageContext.request.contextPath}/resources/img/training.png" alt="교육진행과정 안내 이미지"/></p>
        </div>
        
        <div class="col-10 bound b_body" style="margin:5% auto 20% auto;">
        	<div class="part1">
        		<div class="-title">
        			<a name="part1"></a>
        			<h3><span>01</span> 기본예절교육</h3>
        		</div>
        		<p><img src="${pageContext.request.contextPath}/resources/img/program01.png" alt="기본예절교육"/></p>
        	</div><br>
        	<div class="part2">
        		<div class="-title">
        			<h3><span>02</span> 문제행동교육</h3>
        		</div>
        		<p><img src="${pageContext.request.contextPath}/resources/img/program02.png" alt="문제행동교육"/></p>
        	</div><br>
        	
        	<div class="part3">
        		<div class="-title">
        			<h3><span>03</span> 퍼피클래스</h3>
        		</div>
        		<p><img src="${pageContext.request.contextPath}/resources/img/program03.png" alt="퍼피클래스"/></p>
        	</div><br>
        	<div class="part4">
        		<div class="-title">
        			<a name="part4"></a>
        			<h3><span>04</span> 도그스포츠교육</h3>
        		</div>
        		<p><img src="${pageContext.request.contextPath}/resources/img/program04.png" alt="도그스포츠교육"/></p>
        	</div><br><br>
        	<div class="part5">
        		<div class="-title">
        			<h3><span>05</span> 전문(특수)교육</h3>  
        		</div>
        		<p><img src="${pageContext.request.contextPath}/resources/img/program05.png" alt="전문(특수)교육"/></p>
        	</div><br>
        	<div class="part6">
        		<div class="-title">
        			<a name="part6"></a>
        			<h3><span>06</span> 추가서비스 신청</h3>
        		</div>
        		<p><img src="${pageContext.request.contextPath}/resources/img/program06.png" alt="추가서비스 신청"/></p>
        	</div><br>
        	<div class="part7">
        		<div class="-title">
        			<h3><span>07</span> 비용안내</h3>
        		</div>
        		<p><img src="${pageContext.request.contextPath}/resources/img/program07.png" alt="비용안내" /></p>
        	</div>		
        		
        	
        	
        </div>
	</div>
	

</div>
 
<%@ include file="../include/footer.jsp" %>
</body>
</html>