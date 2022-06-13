
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

	
 <body class="text-center" style="margin:300 auto;">

			<h6><a href="/DangSchool"><img src="${pageContext.request.contextPath}/resources/img/dang2.png" alt="댕스쿨로고"/></a></h6>
			<hr>

		<form action="memberDelete" method="post" id="delete">
			<h3>비밀번호를 한번 더 입력해주세요</h3>
			<hr>
			<input type="hidden" class="form-floating mx-auto w-25 col-md-3" name="id" id="id" value="${sessionScope.user_id }"><br> 
			현재 비밀번호 : <input type="password" class="form-floating mx-auto w-25 col-md-3" name="pw" id="pw"><br>
			비밀번호 확인 : <input type="password" class="form-floating mx-auto w-25 col-md-3" name="pw2" id="pw2"><br>
			<br>
			<input type="submit" class="btn btn-success btn-sm text-white" id="deletee" value="확인">
			<input type="button" class="btn btn-success btn-sm text-white" value="취소" onclick="location.href='${pageContext.request.contextPath}/member/myPage'">
		</form>
			<div>
				<c:if test="${msg == false}">
					비밀번호가 맞지 않습니다.
				</c:if>
			</div>
		
</body>

<script type="text/javascript" src="//code.jquery.com/jquery-3.4.0.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
		
			$("#deletee").on("click", function(){
				
				if($("#pw").val()==""){
					alert("비밀번호를 입력해주세요");
					$("#pw").focus();
					return false
				}
				
				if($("#pw2").val()==""){
					alert("비밀번호 확인을 입력해주세요");
					$("#pw2").focus();
					return false
				}
				
				if ($("#pw").val() != $("#pw2").val()) {
					alert("비밀번호가 일치하지 않습니다.");
					$("#pw2").focus();
					 
					return false;
				}
				
			})
		});
	</script>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>