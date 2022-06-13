<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정&삭제 비밀번호 입력</title>
</head>
<body> 
<div class="container">
	<div class="pw_check">
		<h5>|비밀번호 확인 창입니다 - 작성시에 입력한 비빌번호를 입력해 주세요!</h5>
		<form action="pw_check" method="post" id="regform">
			<h3>비밀번호</h3>
			<input type="hidden" name="num"  id="num" value="<%=request.getParameter("num")%>" />
			<input type="hidden" name="pageNum" value="${cri.pageNum }">
			<input type="hidden" name="count" value="${cri.count }">
			<input type="hidden" name="keyword" value="${cri.keyword }">
			
			<input type="password" id="q_pw" name="q_pw" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
				placeholder="숫자 +4글자">
			<button class="btn btn-green float-right" id="okbtn" onclick="check(); return false;">확인</button>
		</form>	
	</div>
</div> 
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script> 
<script type="text/javascript">
	$(document).ready(function(){
		var msg = '${msg}';
		if(msg != ''){
			alert(msg);
		}
	}) 

	function check(){
		if($("#q_pw").val().length < 4 || $("#q_pw").val().length > 4){
			alert("비밀번호를 입력하세요, 4글자 입니다.");
			$("#q_pw").focus();
		}else{
			$("#regform").submit();
			}
		} 
	
	let moveForm = $("#regform");
	$("#okbtn").on("click", function(e){
		e.preventDefault();
	
		//moveForm.find("#num").remove();
		moveForm.attr("action","pw_check");
		moveForm.submit();
	})
</script>
</body>
</html>