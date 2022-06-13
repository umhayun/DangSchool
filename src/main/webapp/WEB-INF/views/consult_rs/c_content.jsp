<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담예약 상세페이지-관리자</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container">
	<div class ="col">

		<div class="c_header">
    		<h4><strong>|예약</strong>|<small>상담예약 상세페이지 입니다.</small></h4>
    	</div>

		<div class="c_body">
    		<div class="table-responsive">
    				<table class="table table-bordered" width="100%" cellspacing="0">
    					<tr>
    						<td>이름 <input readonly class="form-control" type="text" id="name" name="name" placeholder="이름" value="${consult.name }"></td>
    						<td>
    						번호 <input readonly class="form-control-c" type="text" id="phone" name="phone" value="${consult.phone1 }-${consult.phone2 }" >
    						</td>
    					</tr>
    					<tr>
    						<td>이메일<input readonly class="form-control" type="text" id="email" name="email" value="${consult.email }" ></td>
    						<td>상담유형<input readonly class="form-control" type="text" id="consult_type" name="consult_type" value="${consult.consult_type }" ></td>
    					</tr>
    					<tr>
    						<td colspan="2">
    							<h4 class="text-shadow">방문일</h4>
    							<input readonly class="form-control" type="text" name="visit_date" id="visit_date" value="${consult.visit_date }">
    						</td>
    					</tr>
    					<tr>
    						<td colspan="2">
    							<h6>|반련견 정보</h6>
    						</td>	
    					</tr>
    					<tr>
    						<td>견종:<input readonly class="form-control-c" type="text" name="dog_Kind" id="dog_Kind" value="${consult.dog_Kind }" ></td>
    						<td>*백신접종 유무:<input readonly class="form-control-c" type="text" name="vaccine" id="vaccine" value="${consult.vaccine}"></td>
    					</tr>
    					<tr>
    						<td colspan="2"><textarea readonly class="form-control" rows="20" name="c_content" id="c_content">${consult.c_content }</textarea></td>
    					</tr>
    				
    				</table>
    					<button type="button" id="listbtn" class="btn btn-green float-right" onclick="location.href='c_list?pageNum=${cri.pageNum}&count=${cri.count}'">목록</button> 
    					<button type="button" class="btn btn-green float-right" onclick="check(); return false;">삭제</button>  
    					
    			<!-- 이전글, 다음글 -->	
    			<div class="my-3 p-3 ng-white rounded shadow-sm">
    				<c:choose>
    					<c:when test="${move.next != '9999' }">
    						<button type="button" class="btn btn-green mr-3 mb-3" onclick="location.href='/DangSchool/consult_rs/c_content?num=${move.next}'">다음글</button>
   						<a href="/DangSchool/consult_rs/c_content?num=${move.next}" style="color:black">${move.nextname }</a>
    					</c:when>
    					
    					<c:when test="${move.next == '9999' }">
    						<button type="button" class="btn btn-warning mr-3 mb-3" disabled>다음글이 없습니다.</button>
    					</c:when>
    				</c:choose>
    				<br>
    				<c:choose>
    					<c:when test="${move.last != '9999' }">
    						<button type="button" class="btn btn-green mr-3 mb-3" onclick="location.href='/DangSchool/consult_rs/c_content?num=${move.last}'">이전글</button>
   						<a href="/DangSchool/consult_rs/c_content?num=${move.last}" style="color:black">${move.lastname }</a>
    					</c:when>
    					
    					<c:when test="${move.last == '9999' }">
    						<button type="button" class="btn btn-warning mr-3 mb-3" disabled>이전글이 없습니다.</button>
    					</c:when>
    				</c:choose>
    			</div>
    			<!-- end 이전글, 다음글  -->		
    		</div>
    		<!-- end table-responsive -->
    	</div>		
		<!-- end c_body -->
	</div>
</div>
<form id="infoForm" method="get">
	<input type="hidden" name="num" value="${consult.num }">
	<input type="hidden" name="pageNum" value="${cri.pageNum }">
	<input type="hidden" name="count" value="${cri.count }">
	<input type="hidden" name="keyword" value="${cri.keyword }">
</form>	

<script src="//code.jquery.com/jquery-3.6.0.min.js"></script> 
<script type="text/javascript">
	function check(){
		if(confirm("정말 삭제 하시겠습니까?")){
			location.href="delete?num=${consult.num }"
		}else{
			return;
		}
	}
	
	let moveForm = $("#infoForm");
	$("#listbtn").on("click", function(e){
		e.preventDefault();
	
		moveForm.find("#num").remove();
		moveForm.attr("action","c_list");
		moveForm.submit();
	})
</script>

<%@ include file="../include/footer.jsp" %>
</body>
</html>