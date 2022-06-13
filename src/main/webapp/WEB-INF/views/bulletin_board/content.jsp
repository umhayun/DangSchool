<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항-상세페이지</title>
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
    			<h4><strong>| 공지사항</strong> | 공지사항 상세페이지 입니다.</h4>
    			
    		</div>
    		<div class="card-header bg-green text-white">게시글 상세</div>
    		<div class="b_body">
    				<table class="table table-bordered" width="100%" cellspacing="0">
    					<tr>
    						<td>제목</td>
    						<td><input class="form-control" readonly="readonly" type="text" name="title" id="title" size="23" value="${board.title }"></td>
    					</tr>
    					<tr>
    						<td>작성자</td>
    						<td><input class="form-control" readonly="readonly" type="text" name="name" id="name" size="23" value="${board.name }"></td>
    					</tr> 
    					<tr>
    						<td>작성일</td>
    						<td><input class="form-control" readonly="readonly" type="text" name="regdate" id="regdate" size="23" value="${board.regdate }"></td>
    					</tr> 
    					<tr>
    						<td colspan="2"><textarea class="form-control" readonly="readonly" rows="20" name="content" id="content" >${board.content }</textarea></td>
    					</tr>
    					
    					
    				</table>
    				<c:if test="${cri.keyword eq null }">
    					<button type="button" id="listbtn" class="btn btn-green float-right" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count}'">목록</button> 
    				</c:if>
    				<c:if test="${cri.keyword != null }">
    					<button type="button" id="listbtn" class="btn btn-green float-right" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count}&keyword=${cri.keyword }'">목록</button>
    				</c:if>
    					 	
    				<c:if test="${sessionScope.user_id eq 'dangschool' }">
    					<c:if test="${cri.keyword eq null }">		
    						<button type="button" id="modifybtn" class="btn btn-green float-right" onclick="location.href='modify?num=${board.num }&pageNum=${cri.pageNum}&count=${cri.count}'">수정</button> 
    					</c:if>
    					<c:if test="${cri.keyword != null }">
    						<button type="button" id="modifybtn" class="btn btn-green float-right" onclick="location.href='modify?num=${board.num }&pageNum=${cri.pageNum}&count=${cri.count}&keyword=${cri.keyword }'">수정</button>
    					</c:if>	 			
    				</c:if>
    			<!-- 이전글, 다음글 -->	
    			<div class="my-3 p-3 ng-white rounded shadow-sm">
    				<c:choose>
    					<c:when test="${move.next != '9999' }">
    						<button type="button" class="btn btn-green mr-3 mb-3" onclick="location.href='/DangSchool/bulletin_board/content?num=${move.next}'">다음글</button>
   						<a href="/DangSchool/bulletin_board/content?num=${move.next}" style="color:black">${move.nexttitle }</a>
    					</c:when>
    					
    					<c:when test="${move.next == '9999' }">
    						<button type="button" class="btn btn-warning mr-3 mb-3" disabled>다음글이 없습니다.</button>
    					</c:when>
    				</c:choose>
    				<br>
    				<c:choose>
    					<c:when test="${move.last != '9999' }">
    						<button type="button" class="btn btn-green mr-3 mb-3" onclick="location.href='/DangSchool/bulletin_board/content?num=${move.last}'">이전글</button>
   						<a href="/DangSchool/bulletin_board/content?num=${move.last}" style="color:black">${move.lasttitle }</a>
    					</c:when>
    					
    					<c:when test="${move.last == '9999' }">
    						<button type="button" class="btn btn-warning mr-3 mb-3" disabled>이전글이 없습니다.</button>
    					</c:when>
    				</c:choose>
    			</div>
    			<!-- end 이전글, 다음글  -->
    		</div>
    		<!-- end b_body -->
    	</div>
	</div>
	<!-- end col -->
</div>

<form id="infoForm" method="get">
	<input type="hidden" name="num" value="${num }">
	<input type="hidden" name="pageNum" value="${cri.pageNum }">
	<input type="hidden" name="count" value="${cri.count }">
	<input type="hidden" name="keyword" value="${cri.keyword }">
</form>	

<script src="//code.jquery.com/jquery-3.6.0.min.js"></script> 
<script type="text/javascript">
	let moveForm = $("#infoForm");
	$("#listbtn").on("click", function(e){
		e.preventDefault();
	
		//moveForm.find("#num").remove();
		moveForm.attr("action","list");
		moveForm.submit();
	})

</script>


<%@ include file="../include/footer.jsp" %>
</body>
</html>