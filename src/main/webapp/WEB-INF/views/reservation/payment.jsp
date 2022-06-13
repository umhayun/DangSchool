<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.mar{
		width: 50%;
		margin-left:auto;
		margin-right:auto;
	}
	.textmar{
	padding-top: 10px;
		padding-bottom: 10px;
		text-align: center;
	}
	tr{
		height: 40px;
		}
	td{	
		text-align: center;
	}
	.container{
		margin: 20px;
	}
</style>

</head>
<body>

<%@include file="../include/header.jsp"%>
<div class="container" >
    		<div >
    				<table class="mar table-bordered " >
    					<tr>
    						<td>이름</td>
    						<td colspan="3">${reserv.name }</td>	
    					</tr>
    					<tr>
    						<td>전화번호</td>
    						<td colspan="3">${reserv.phone1 }-${reserv.phone2 }</td>
    					</tr>
    					<tr>
    						<td>강아지이름</td>
    						<td>${reserv.dogname }</td>
    						<td>강아지성별</td>
    						<td>${reserv.doggender }</td>
    					</tr>
    					<tr>
    						<td>강아지종</td>
    						<td>${reserv.kind }</td>
    						<td>강아지크기</td>
    						<td>${reserv.d_size }</td>
    					</tr>
    					<tr>
    						<td>이용서비스</td>
    						<td>${reserv.service }</td>	
    						<td>금액</td>
    						<td>${reserv.sum } </td>	
    					</tr>
    					<tr>
    						<td>중성화여부</td>
    						<td>${reserv.neuter }</td>
    						<td colspan="2" style="color: red;font-size: 10px;">※중성화 여부에 따라 서비스에 제한이 있을 수 있습니다.※</td>
    					</tr>
    					<tr>
    						<td>예약 시간</td>
    						<td>${reserv.reservdate}</td>
    						<td>결제 방법</td>
    						<td>${reserv.pay }</td>
    					</tr>
    					<c:if test="${reserv.pay=='account' }">
    						<tr>
    						<td>계좌번호</td>
    						<td colspan="3"> 110457143190 신한 (엄하윤)</td>
    						</tr>
    					</c:if>
    				</table>
    				<br>	
    		</div>
	</div>
	<input type="text" class="hidden" id="sum" value="${reserv.sum }">
	<div align="center">
    				<input type="button" class="btn btn-light green"  onclick="location.href='/DangSchool/reservation/reserve'" value="다시입력">			
    				
    				<c:if test="${reserv.pay=='naver' }">
    					<button id="naverPayBtn" value="네이버페이 결제 버튼" class="btn btn-green ">네이버페이</button>
    					
    				</c:if>
    				<c:if test="${reserv.pay=='account' }">
    				<input type="button" class="btn btn-green " onclick="location.href='/DangSchool/reservation/myreserve'" value="예약">
						
    				</c:if>
    			</div>


<script src="https://nsp.pay.naver.com/sdk/js/naverpay.min.js"></script>
<script>
    var oPay = Naver.Pay.create({
          "mode" : "production", // development or production
          "clientId": "u86j4ripEt8LRfPGzQ8" // clientId
    });

    //직접 만드신 네이버페이 결제버튼에 click Event를 할당하세요
    var elNaverPayBtn = document.getElementById("naverPayBtn");
 	
    elNaverPayBtn.addEventListener("click", function() {
    	var sum=parseInt(${reserv.sum });
        oPay.open({
          "merchantUserKey": "INIpayTest",
          "merchantPayKey": "1111",
          "productName": "상품명을 입력하세요",
          "totalPayAmount": sum,
          "taxScopeAmount": sum,
          "taxExScopeAmount": "0",
          "returnUrl": "http://localhost:8090/DangSchool/"
        });
    });

</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
