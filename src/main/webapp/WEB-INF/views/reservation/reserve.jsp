<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/header.jsp"%>
<style>
.ra{
	margin-top:3px;
	width:20px;
	height:20px;
	border:1px;
	font-size: 20px;
}
.la{
	width:200px;
}
</style>
<html>
<head>
</head>
<body>
	<div align="center">
	<br>
	<br>
	<h2>서비스 예약</h2>
	<br>
	<form action="payment" method="post" id="reserve">
	<table  style="width:1000px" >
	<tr>
	<td>아이디</td>
	<td colspan="2"><input  class="form-control" class="form_control" type="text" name="id" readonly value="${sessionScope.user_id }"><br></td>
	</tr>
	<tr >
		<td class="la">성함</td>
		<td colspan="2"><input  class="form-control" class="form_control" type="text" name="name" placeholder="이름 입력"><br></td>
	</tr>
	<tr>
		<td class="la">전화번호</td>
		<td style="width:200px">
			<select name="phone1" class="form-control"  class="tel">
				<option value="010">010</option>
				<option value="019">019</option>
			</select>
			</td>
			<td>
			<input class="form-control" type="text" name="phone2" placeholder="전화번호 입력" style="width:510px;height: 30px">
		</td>
	</tr>
	
	</table>
<br>
	<table  style="width:1000px" >
	<tr>
		<td class="la">반려견 이름</td>
		<td><input class="form-control"  type="text" name="dogname" placeholder="이름"><br></td>
		<td><input type="radio" name="doggender" value="수컷">남
		<input  type="radio" name="doggender" value="암컷">여</td>
	</tr>
	<tr>
		<td class="la">종</td>
		<td ><input class="form-control" type="text" name="kind" placeholder="견종"></td>
		<td>
			<input class="form_control" type="radio" name="d_size" value="소">소
			<input class="form_control" type="radio" name="d_size" value="중">중
			<input class="form_control" type="radio" name="d_size" value="대">대
		</td>
	</tr>
	<tr>
		<td class="la"> <br>서비스 </td>
		<td><br>
			<input class="ra" type="checkbox" name="service" id="kinder" value="유치원" >유치원
			<input class="ra" type="checkbox" name="service" id="shower" value="목욕">목욕
			<input class="ra" type="checkbox" name="service" id="cut" value="미용">미용
			
			<input  type="button" id="sumbtn" onclick="money()" value="결제금액" style="margin-left: 10px;" >
		</td>	
			<td ><br><input class="form-control" type="text" value="" name="sum" id="sum" style="width:100px;height: 10px;" readonly></td>
			
			
	</tr>
	<tr>
	
		<td class="la"><br>중성화 여부 </td>
		<td colspan="2"><br><input  type="radio" name="neuter" value="yes">예
			<input  type="radio" name="neuter" value="no">아니오</td>
	</tr>
	<tr>
		<td colspan="3" style="color: red;font-size: 10px;">※중성화 여부에 따라 서비스에 제한이 있을 수 있습니다.※</td>
	</tr>
	<tr>
		<td class="la"><br>예약 날짜 선택</td>
		<td colspan="2"><br><input type="datetime-local" name="reservdate"  class="form_control"></td>
	</tr>

	<tr>
		<td  class="la"> <br>결제 방법</td>
		<td> <br>
			<input class="ra" type="radio" name="pay" id="account" value="account"> 무통장입금 
			<input class="ra" type="radio" name="pay" id="credit" value="naver"> 네이버페이
			
			
		</td>
	</tr>
	</table>
	<input type="submit" class="btn btn-green" onclick="reserve()" value="예약">
	<input type="button" class="btn btn-light green" value="취소">
	
	</form>

	<br>
	<br>
	<br>
	</div>


<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

</body>
<%@include file="../include/footer.jsp"%>
<script>
 	function money(){
 		let sum=0;
		if($("#kinder").is(':checked')){
				sum+=50000;
		}
		if($("#cut").is(':checked')){
			sum+=30000;
		}
		if($("#shower").is(':checked')){
			sum+=30000;
		}
		$("#sum").val(sum);
		
	} 
 	function reserve(){
 		confirm("예약하시겠습니까?");
 	}

</script>

</html>


