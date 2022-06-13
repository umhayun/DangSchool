<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	.mar{
		width: 50%;
		margin-left:auto;
		margin-right:auto;
		text-align: center;
	}
	.textmar{
	float:none;
	padding-top: 10px;
		padding-bottom: 10px;
		text-align: center;
		width:300px;
		align-self:center;

	}
	tr{
		height: 40px;
		}
	td{	
		text-align: center;
	}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/header.jsp"%>
<br>
<div class="container">
    		<div >
    		<div class="mar bg-green text-white ">예약현황</div>
    		<c:forEach var="reserv" items="${list }">
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
    						<c:choose>
    						<c:when test="${reserv.complete eq 'no'}">
    						<td>결제 확인</td>
    						<td><button type="button" onclick="location.href='check?reservno=${reserv.reservno}'">결제 완료</button></td>
    						</c:when>
    						<c:otherwise>
    							<td>결제 완료</td>
    							<td>${reserv.complete }</td>
    						</c:otherwise>
    						</c:choose>
    					</tr>
    					
    				</table>
    				<br>	
    			</c:forEach>
    		</div>
	</div>

<%@ include file="../include/footer.jsp"%>
</body>
</html>