<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담등록 페이지</title>
<!-- 상담예약 누를 경우 메인으로 보이게 -->
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container">
	<div class ="col">

		<div class="c_header">
    		<h3><strong>| 예약</strong> |상담예약 페이지</h3>
    	</div>

		<div class="c_body">
    		<div class="table-responsive">
    			<form role="form" action="c_register" method="post" name="regform">
    				<table class="table table-bordered" width="100%" cellspacing="0">
    					<tr>
    						<td colspan="2" class="text-center"> 
    						<span>***************************************  <strong>상담 예약 정보 입력</strong>  *************************************** </span>
    						</td>
    					</tr>
    					<tr> 
    						<td><input class="form-control" type="text" id="name" name="name" placeholder="이름" value="${member.name }"></td>
    						<td>
    						<select class="select" name="phone1" id="phone1">
    							<option value="${member.phone1}" ${member.phone1 == 010 ? 'selected="selected"' : ''}>010</option>
    							<option value="${member.phone1}" ${member.phone1 == 011 ? 'selected="selected"' : ''}>011</option>
    							<option value="${member.phone1}" ${member.phone1 == 019 ? 'selected="selected"' : ''}>019</option>
    						</select>
    						<input class="form-control-c" type="text" id="phone2" name="phone2" placeholder="'-'제외하고 입력세요" value="${member.phone2 }" >
    						</td>
    					</tr>
    					<tr>
    						<td><input class="form-control" type="text" id="email" name="email" placeholder="이메일" value="${member.email }" ></td>
    						<td>
    							<h4>**상담유형**</h4>
    							방문<input type="radio" name="consult_type" id="consult_type" value="방문">
    							인터넷<input type="radio" name="consult_type" id="consult_type" value="인터넷">
    							전화<input type="radio" name="consult_type" id="consult_type" value="전화">
    						</td>
    					</tr>
    					<tr>
    						<td colspan="2">
    							<h4 class="text-shadow">방문일의 경우 체크해 주세요!</h4>
    							<input class="form-control" type="datetime-local" name="visit_date" id="visit_date">
     							<!-- <input class="form-control" type="text" name="visit_date" id="visit_date" placeholder="ex)xxxx.xx.xx">  -->
    						</td>
    					</tr>
    					<tr>
    						<td colspan="2">
    							<h4>|반련견 정보를 입력하세요!</h4>
    						</td>	
    					</tr>
    					<tr>
    						<td>견종:<input class="form-control-c" type="text" name="dog_Kind" id="dog_Kind"  ></td>
    						<td>
    							<h4>*백신접종 유무: </h4>
    								접종<input type="radio" name="vaccine" id="vaccine" value="접종">
    								미접종<input type="radio" name="vaccine" id="vaccine" value="미접종">
    						</td>
    					</tr>
    					<tr>
    						<td colspan="2"><textarea class="form-control" rows="20" name="c_content" id="c_content" 
    						placeholder="상담하고 싶은 내용을 적어 주세요. ** 미리 적어 주시면, 담당자가 확인후 상담을 진행해 더 수월히 안내해 드리겠습니다. "></textarea></td>
    					</tr>
    				
    				</table>
    					<input type="submit" class="btn btn-green float-right" onclick="check(); return false;" value="제출">
    			</form>
    		</div>
    		<!-- end table-responsive -->
    	</div>		
		<!-- end c_body -->
	</div>
</div>

<script type="text/javascript">
	function check(){
		
		if(document.regform.phone1.value == ''){
			alert("전화번호1를 입력하세요");	
			return;
		}else if(document.regform.phone2.value == ''){
			alert("전화번호2를 입력하세요");
			return;
		}else if(document.regform.name.value == '') {
			alert("이름을 입력하세요");
			return;
		}else if(document.regform.vaccine.value == '') {
			alert("백신 유무를 선택하세요");
			return;	
		} else if(confirm("상담예약을 하시겠습니까?")){
			document.regform.submit();
			alert("상담예약 되었습니다.");
		}else{
			return;
		}
	}
	
</script>

<%@ include file="../include/footer.jsp" %>
</body>
</html>