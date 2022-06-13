<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
	<div class="position-absolute top-50 start-50 translate-middle">
	
		  
		  	
			<h6><a href="/DangSchool"><img src="${pageContext.request.contextPath}/resources/img/dang2.png" alt="댕스쿨로고"/></a></h6>
			<hr>
		    <div class="font-monospace"><h2>MyPage</h2></div>
		    <h3>${sessionScope.user_id }님 로그인을 환영합니다</h3>
	
			<hr>
			  <button type="button" class="btn btn-warning fw-bold" onclick="location.href='modify'">회원정보 변경</button>
			  <button type="button" class="btn btn-success" onclick="location.href='changePwForm'">비밀번호 변경</button>
			  <button type="button" class="btn btn-warning fw-bold" onclick="location.href='logout'">로그아웃</button>
			  <button type="button" class="btn btn-success" onclick="location.href='delete'">회원탈퇴</button>
	

	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>