<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

 
<body class="text-center" style="margin:300 auto;">

<form class="user" action="joinForm" method="post" id="regForm">
 <fieldset>
	<legend>회원가입</legend>

	<p>
	<input type="text" class="form-floating" placeholder="아이디" name="id" id="id"  size="39">
	<input type="button" class="btn btn-warning btn-sm text-white" value="중복체크" onclick="IdCheck()"></p>
	<p><input type="text" class="form-floating" placeholder="이름" name="name" id="name"  size="50"><br></p>
	<p><input type="password" class="form-floating" placeholder="비밀번호" name="pw" id="pw"  size="50"><br><p>
	<p><input type="password" class="form-floating" placeholder="비밀번호체크" name="pwCheck" id="pwCheck"  size="50"><br></p>
	<p>
		<select name="phone1" class="form-floating">
		    <option>010</option>
    		<option>011</option>
    		<option>019</option>
		</select>
		-<input type="text"  class="form-floating" name="phone2" placeholder=" -제외하고 입력해주세요" size="42">
		<br></p>
	<p> <input type="email" name="email"  class="form-floating" placeholder="email을 @포함하여 입력해주세요" size="50"><br></p> 
	<p><input type="text" name="addr"  class="form-floating" placeholder="주소를 입력해주세요" size="50"><br></p>
	<p><input type="text" name="dog"  class="form-floating" placeholder="강아지 '있음', '없음'으로 입력해주세요" value="있음" size="50"><br></p>
	
	<input type="button" class="btn btn-warning btn-lg text-white" value="회원가입" onclick="joinCheck()">
</fieldset>
</form>

</body>


<script type="text/javascript" src="//code.jquery.com/jquery-3.4.0.min.js"></script>
<script>

   function IdCheck() {
	   
	   var id = $("#id").val();	
	   var userId = {"id" : id} 
	   
	   if(id.length < 4) {
		   alert("아이디는 4글자 이상을 입력하세요");
	   }else {

		   $.ajax({
			   type : "post",
			   url : "checkId",	
			   data : userId,	
			   error : function(request, error) {
				   alert(error + "\n" + request.status);
			   },
			   success : function(result) {
				   console.log("성공실패여부: " + result);
				   
				   if (result == 1) {	
					   alert("이미 존재하는 아이디 입니다.");
				   }else {
					   alert("사용가능한 아이디 입니다.");
					   $("#id").attr("readonly", true);
				   }
			   }
		   })
		   
	   }
	   console.log(userId);
   }
   

   function joinCheck() {
	   
    	if ( !$("#id").attr("readonly")) {
    		alert("아이디 중복체크를 해야 합니다.");
    	}else if( $("#name").val().length < 1 ) {
    		alert("이름을 입력하세요");
    	}else if( $("#pw").val().length < 1 ) {
    		alert("비밀번호를 입력하세요");
    	}else if ( $("#pw").val() != $("#pwCheck").val() ) {
    		alert("비밀번호 확인란을 확인해주세요");
    		$("#pwCheck").focus();
    	}else if ( confirm("회원 가입 하시겠습니까?")){
    		$("#regForm").submit();
    	}
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
