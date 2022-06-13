<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>공지사항 페이지</title>
 
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
	<div class ="col">
	
		<div class="col-sm-6 col-md-2 col-lg-2 text-center b_menu">
    	<h4><a class="text-green" href="/DangSchool/bulletin_board/list">공지사항</a>&emsp;&emsp;&emsp;&emsp;
    		<a class="text-green" href="/DangSchool/qna_board/list">Q&A</a>
    	</h4>
    	</div>
   	
    	<div class="col-sm-6 col-md-10 col-lg-10 ">
    	
    		<div class="b_header">
    		
    			<h4><strong>|공지사항 </strong> | 공지사항 입니다.</h4>
    			<c:if test="${sessionScope.user_id eq 'dangschool' }">
    				<button type="button" class="btn-green btn-sm float-right" 
    				onclick="location.href='register?pageNum=${pageMaker.cri.pageNum}&count=${pageMaker.cri.count }'">글쓰기</button>
    			</c:if>
    		</div>
    		<div class="b_body">
    			<div class="table-responsive">
    				<table class="table table-bordered" width="100%" cellspacing="0">
    					<thead>
    						<tr>
    							<th>번호</th>
    							<th>제목</th>
    							<th>작성일</th>
    						</tr>
    					</thead>
    					<c:forEach var="blist" items="${board_list }">
    					<tbody>
    						<tr>
    							<td>${blist.num }</td>
    							<!-- 상세 페이지 이동 -->
    							<td>
    								<!-- 조회 페이지 이동 /번호사용/키워드?-->
    								<c:if test="${pageMaker.cri.keyword eq null }">
    						 			<a href="content?num=${blist.num }&pageNum=${pageMaker.cri.pageNum}&count=${pageMaker.cri.count }">${blist.title }</a>
    						 		</c:if>
    						 		<c:if test="${pageMaker.cri.keyword != null }">
    						 			<a href="content?num=${blist.num }&pageNum=${pageMaker.cri.pageNum}&count=${pageMaker.cri.count }&keyword=${pageMaker.cri.keyword}">${blist.title }</a>
    						 		</c:if>
    									
    							</td>
    							<td>
    							<!-- fmt:formatDate 사용 -->
    							<fmt:formatDate pattern="yyyy.MM.dd" value="${blist.regdate }"/>
    							</td>
    						</tr>
    					</tbody>
    					</c:forEach>
    				</table>
    				<!-- end table -->
    				
    				<!-- 검색 -->
    				<div class="search_wrap">
						<div class="search_area">
							<form id="seachForm" action="listsearch" method="get">
								<input class="form-control-search" type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword }" placeholder="(제목+내용)검색어를 입력하세요.">
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
      								<a class="page-link" href="list?pageNum=${pageMaker.startPage -1 }&keyword=${pageMaker.cri.keyword }">&laquo;</a>
   							 	</li>
   							 </c:if>
   							 
   							 <!-- 페이지 번호 -->
   							 	<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
    								<li class="page-item  ${pageMaker.cri.pageNum == num?'active' : '' }">
    						 			<c:if test="${pageMaker.cri.keyword eq null }">
    						 				<a class="page-link" href="list?pageNum=${num }" >${num }</a>
    						 			</c:if>
    						 			<c:if test="${pageMaker.cri.keyword != null }">
    						 				<a class="page-link" href="listsearch?pageNum=${num }&keyword=${pageMaker.cri.keyword}" >${num }</a>
    						 			</c:if>
    								</li>
    							</c:forEach>
    						
    						<!-- 다음 페이지 -->
    						<c:if test="${pageMaker.next }">
   								<li class="page-item">
     								<a class="page-link" href="list?pageNum=${pageMaker.endPage +1 }&keyword=${pageMaker.cri.keyword }">&raquo;</a>
    							</li>
    						</c:if>
  						</ul>
    				</div>
    				
    				<!-- 페이징 끝 -->
    			</div>
    		</div>
    		<!-- end b_body -->
    	</div>
	</div>
</div>
<!-- end container -->

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
		moveForm.attr("action","bulletin_board/list");
		moveForm.submit();
	})

	$("#moveForm").on("click", function (e){
		e.prevenDefault();			
    	let val = $("input[name='keyword']").val();
   	 	moveForm.find("input[name='keyword']").val(val);
    	moveForm.find("input[name='pageNum']").val(1);
    	moveForm.submit();
		})
</script>

<%@ include file="../include/footer.jsp" %>
</body>
</html>