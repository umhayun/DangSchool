<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담예약 페이지 목록-관리자</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
	<div class ="col">
			<div class="c_header">
    			<h4><strong>|예약</strong>|<small>상담예약 목록 입니다.</small></h4>
    		</div>
    		<div class="c_body">
    			<div class="table-responsive">
    				<table class="table table-bordered" width="100%" cellspacing="0">
    					<thead>
    						<tr>
    							<th>번호</th>
    							<th>이름</th>
    							<th>전화번호</th>
    							<th>이메일</th>
    							<th>상담유형</th>
    							<th>작성일</th>
    							<th>상세</th>
    						</tr> 
    					</thead>
    					<c:forEach var="clist" items="${consult_list }">
    					<tbody>
    						<tr>
    							<td>${clist.num }</td>
    							<td>${clist.name }</td>
    							<td>${clist.phone1 } - ${clist.phone2 }</td>
    							<td>${clist.email }</td>
    							<td>${clist.consult_type }</td>
    							<td>
    								<fmt:formatDate pattern="yyyy-MM-dd" value="${clist.c_regdate }"/>
    							</td>
    							<td>
    								<!-- 상세페이지 이동/검색시에 키워드값 가지고 갈 수 있게 -->
    								<c:if test="${pageMaker.cri.keyword eq null }">
    									<button type="button" class="btn btn-light-green" onclick="location.href='c_content?num=${clist.num}&pageNum=${cri.pageNum }&count=${cri.count }'">상세</button>
    								</c:if>
    								<c:if test="${pageMaker.cri.keyword != null }">
    									<button type="button" class="btn btn-light-green" onclick="location.href='c_content?num=${clist.num}&pageNum=${cri.pageNum }&count=${cri.count }&keyword=${pageMaker.cri.keyword }'">상세</button>
    								</c:if>
    							</td>
    						</tr>
    					</tbody>
    					</c:forEach>
    				</table>
    				
    				<!-- 검색 -->
    				<div class="search_area">
						<div class="search_wrap">
							<form id="seachForm" action="listsearch" method="get">
								<input class="form-control-search" type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword }" 
										placeholder="(이름+전화번호)검색어를 입력하세요.">
								<button class="btn btn-green" id="moveForm">검색</button>
								
							</form>
						</div>    			
    				</div>	  
    				
    				<!-- 페이징 처리 부분 -->
    				<div class="paging" > 
    				
  						<ul class="pagination ">
  							<!-- 이전 페이지  -->
  							<c:if test="${pageMaker.prev }">
    							<li class="page-item">
      								<a class="page-link" href="c_list?pageNum=${pageMaker.startPage -1 }">&laquo;</a>
   							 	</li>
   							 </c:if>
   							 
   							 <!-- 페이지 번호 --> 
   							 <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
    							<li class="page-item  ${pageMaker.cri.pageNum == num?'active' : '' }">
    								<c:if test="${pageMaker.cri.keyword eq null }">
    						 			<a class="page-link" href="c_list?pageNum=${num }" >${num }</a>
    						 		</c:if>
    						 		<c:if test="${pageMaker.cri.keyword != null }">
    						 			<a class="page-link" href="listsearch?pageNum=${num }&keyword=${pageMaker.cri.keyword}" >${num }</a>
    						 		</c:if>
    							</li>
    						</c:forEach>
    						<!-- 다음 페이지 -->
    						<c:if test="${pageMaker.next }">
   								<li class="page-item">
     								<a class="page-link" href="c_list?pageNum=${pageMaker.endPage +1 }">&raquo;</a>
    							</li>
    						</c:if>
  						</ul>
    				</div>
    				<!-- 페이징 끝 -->
				</div>
			</div>
	</div>
</div>

<form id="moveForm" method="get">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
	<input type="hidden" name="count" value="${pageMaker.cri.count }">
</form>	
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script> 
<script type="text/javascript">

	let moveForm = $("#moveForm");
	$(".move").on("click", function(e){
		e.preventDefault();
		
		moveForm.append("<input type='hidden' name='num' value='"+(this).attr("href")+"'>");
		moveForm.attr("action","consult_rs/c_list");
		moveForm.submit();
	})
	$("#moveForm").on("click", function (e){
		e.prevenDefault();			
    	let val = $("input[name='keyword']").val();
   	 	moveForm.find("input[name='keyword']").val(val);
    	moveForm.find("input[name='pageNum']").val(1);
    	moveForm.submit();
		});
</script>

<%@ include file="../include/footer.jsp" %>
</body>
</html>