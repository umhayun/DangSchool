<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   
    
    <body class="text-center" style="margin:300 auto;">

     <fieldset>
   	<legend> 회원 정보 수정 페이지</legend>
 	<div>
	<form class="user" action="update" method="post" id="regForm">
	
	<p>아이디 <input type="text" class="form-floating" name="id" id="id" value="${sessionScope.user_id }" readonly><br></p>
	<p>이름 <input type="text" class="form-floating" name="name" id="name" value="${user.name}" readonly><br></p>

	<p>전화번호 
		<select name="phone1"  id="phone1" class="form-floating">
			<option value="${user.phone1}" ${user.phone1 == 010 ? 'selected="selected"' : ''}>010</option>
			<option value="${user.phone1}" ${user.phone1 == 011 ? 'selected="selected"' : ''}>011</option>
			<option value="${user.phone1}" ${user.phone1 == 019 ? 'selected="selected"' : ''}>019</option>
		</select>
		-<input type="text" class="form-floating" name="phone2" value="${user.phone2 }"><br>
		<br></p>

	<p>이메일  <input type="email" name="email" class="form-floating" size="50" value="${user.email }"><br></p>

	<p>주소 <input type="text" name="addr" class="form-floating" size="50" value="${user.addr }"><br></p>

	<p>강아지  <input type="text" name="dog" class="form-floating" size="50"  value="${user.dog }"><br></p>

	<input type="submit" class="btn btn-success btn-lg text-white" value="수정">
	<input type="button" class="btn btn-success btn-lg text-white" value="취소" onclick="location.href='myPage'">
	
	
	</form>
	</div>
	
	</fieldset>
	</body>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>