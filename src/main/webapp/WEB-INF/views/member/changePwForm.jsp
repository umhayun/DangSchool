<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    
    <body class="text-center" style="margin:300 auto;">

	<h6><a href="/DangSchool"><img src="${pageContext.request.contextPath}/resources/img/dang2.png" alt="댕스쿨로고"/></a></h6>
	<hr>
    
   		<legend class="fw-bold">비밀번호 변경</legend>
 	
 	<form role="form" action="changePw" method="post" id="regform">
           <%-- <input type="hidden" id="id" name="id" value="${sessionScope.user_id }"> --%>

           <div class="p-2 form-group">
                    <input type="password" name="oldPw" id="oldPw" class="form-floating w-25 p-3" placeholder="현재 비밀번호" />
           </div>
           <div class="p-2 form-group">
                    <input type="password" name="newPw" id="newPw" class="form-floating w-25 p-3" placeholder="새 비밀번호" />
           </div>
           <div class="p-2 form-group">
                    <input type="password" name="newPw2" id="newPw2" class="form-floating w-25 p-3" placeholder="새 비밀번호 확인" />
           </div>
				<input type="submit" class="btn btn-success btn-sm text-white" onclick="return check_Pw()" value="비밀번호 변경">
                <input type="button" class="btn btn-success btn-sm text-white" value="취소" onclick="location.href='${pageContext.request.contextPath}/member/myPage'">
  			<div>
				<hr>
           <div style="color: red;">
            	<c:if test="${msg == false}">
               		비밀번호를 확인해주세요! (동일한 비밀번호 사용불가)
            	</c:if>
         </div>
			</div>

	</form>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	