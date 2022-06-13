<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- header에 포함 확인하기 -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


	<!-- 아이디 중복체크/ 비밀번호 확인 추가하기 -->
 <body class="text-center" style="margin:300 auto;">
 			 					
		
				  <form class="user" action="loginForm" method="post">
				  	<a href="/DangSchool">
				    <img class="mb-4" src="${pageContext.request.contextPath}/resources/img/dang2.png" alt="댕스쿨로고" width="173" height="55">
				    </a>
				    <!-- <h1 class="h3 mb-3 fw-normal">로그인</h1> -->
				    <div class="form-floating mx-auto w-25 col-md-3">
				      <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요">
				      <label for="id"  class="p-3 text-black-50">아이디</label>
				    </div>
				    <div class="form-floating mx-auto w-25 col-md-3">
				      <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요">
				      <label for="pw" class="p-3 text-black-50">비밀번호</label>
				    </div>

				
					<!-- 				
					<div class="checkbox mb-3">
				      <label>
				        <input type="checkbox" value="remember-me"> 아이디 기억하기
				      </label>
				    </div> -->
				    <br>
					<div class="d-grid gap-2 mx-auto d-md-block">
					 <button type="submit" class="btn btn-warning btn-lg text-white">로그인</button>
					 <button type="button" class="btn btn-warning btn-lg text-white" onclick="location.href='join'">회원가입</button>
					 </div>
				  </form>
		
			
</body>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> 