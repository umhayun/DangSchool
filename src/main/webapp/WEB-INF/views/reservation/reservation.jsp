<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/header.jsp"%>

<html>
<head>
	<div align="center">
	<br>
	<br>
	<h2>서비스 예약</h2>
	<br>
	<form action="reservform" method="post" id="reserve">
	<table>
	<tr>
	<td>아이디</td>
	<td colspan="2"><input class="form_control" type="text" name="id" placeholder="아이디 입력"><br></td>
	</tr>
	<tr>
		<td>성함</td>
		<td colspan="2"><input class="form_control" type="text" name="name" placeholder="이름 입력"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td colspan="2">
			<select name="phone1">
				<option value="010">010</option>
				<option value="019">019</option>
			</select>
			<input type="text" name="phone2" placeholder="전화번호 입력">
		</td>
	</tr>
	<tr>
		<td>반려견 이름</td>
		<td><input type="text" name="dogname" placeholder="이름"><br></td>
		<td><input type="radio" name="doggender" value="수컷">남
		<input type="radio" name="doggender" value="암컷">여</td>
	</tr>
	<tr>
		<td>종</td>
		<td ><input type="text" name="kind" placeholder="견종"></td>
		<td>
			<input class="form_control" type="radio" name="d_size" value="소">소
			<input class="form_control" type="radio" name="d_size" value="중">중
			<input class="form_control" type="radio" name="d_size" value="대">대
		</td>
	</tr>
	<tr>
		<td>중성화 여부 </td>
		<td>
			<input class="form_control" type="checkbox" name="service" id="kinder" value="kindergarten" >유치원
			<input class="form_control" type="checkbox" name="service" id="shower" value="shower">목욕
			<input class="form_control" type="checkbox" name="service" id="cut" value="haircut">미용
			<input class="form_control" type="button" id="sumbtn" onclick="money()" value="예상금액">
		</td>	
			<td><p class="sum2"  value="">0원</p></td>
		
			
		
		
			
	</tr>
	<tr>
		<td>중성화 여부 </td>
		<td colspan="2"><input type="radio" name="neuter" value="yes">예
			<input type="radio" name="neuter" value="no">아니오</td>
	</tr>
	<tr>
		<td colspan="3" style="color: red;font-size: 5px;">※중성화 여부에 따라 서비스에 제한이 있을 수 있습니다.※</td>
	</tr>
	<tr>
		<td>예약 날짜 선택</td>
		<td colspan="2"><input type="datetime-local" name="reservdate" ></td>
	</tr>
	</table>
	<input type="submit" value="예약">
	<input type="button" value="취소">
	</form>
	<select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
 	 <option selected>Open this select menu</option>
  	<option value="1">One</option>
  	<option value="2">Two</option>
  	<option value="3">Three</option>
	</select>
	<br>
	<br>
	<br>
	</div>
	
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>
 	function money(){
		
		 if($('input:checkbox[id="kinder"]').is(':checked')){
			if($('input:checkbox[id="shower"]').is(':checked')){				
				if($('input:checkbox[id="cut"]').is(':checked')){
					$(".sum2").text("100000원");
				}
				else{
					$(".sum2").text("70000원");
				}
			}else if($('input:checkbox[id="cut"]').is(':checked')){
				$(".sum2").text("70000원");
			}
			
			else{
				$(".sum2").text("50000원");
			}
		}
		 else if ($('input:checkbox[id="shower"]').is(':checked')){
			 $(".sum2").text("30000원");
			 if($('input:checkbox[id="cut"]').is(':checked')){
				 $(".sum2").text("50000원");
			 }
		 }
		 else if($('input:checkbox[id="cut"]').is(':checked')){
			 $(".sum2").text("30000원");
		 }
		
	} 
</script>
</body>
</html>
<%@include file="../include/footer.jsp"%>