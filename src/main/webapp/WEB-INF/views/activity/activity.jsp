<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <%@include file="../include/header.jsp"%> 
<style>
	.thumb{
		align:center;
		float:left;
		width: 450px;
		width: 430px;
		margin-left:30px;
		margin-right:30px;
		margin-bottom: 20px;
	}

	b{
		font-size: 27px; 
	}
	small{
		font-size:14px;
	}
</style>
<div class="container" >
<div class="col-sm-6 col-md-2 col-lg-2 text-center b_menu">
	    	<h4><a class="text-green" href="/DangSchool/activity/active">활동사진</a>&emsp;&emsp;&emsp;&emsp;
	    		<a class="text-green" href="/DangSchool/review/list">리뷰</a>
	    	</h4>
    	</div>
	<div class ="row">

    	<div class="col-sm-6 col-md-10 col-lg-10 ">
    		<div class="c_header" >
    			<c:if test="${sessionScope.user_id eq 'dangschool' }">
    				<button type="button" class="btn btn-green btn-sm float-right" 
    				onclick="location.href='/DangSchool/activity/register?pageNum=${page.cri.pageNum}&count=${page.cri.imgcount }'">글쓰기
    				</button>
    				</c:if>
    		</div>
			<br>
			<br>
    		<div class="c_body">
    			<div class="table-responsive">
    				<table class="table ">
    						
    						
    						<c:forEach var="list" items="${a_list }">
    							<c:forEach var="img" items="${img }">
    								<c:if test="${img.num==list.num }">
    								
    								<tr class="thumb">
    								<td><a href="content?num=${list.num }&pageNum=${page.cri.pageNum}&count=${page.cri.imgcount }"><img alt="" src="/DangSchool/resources/upload/${img.save_file_name }" style="width: 400px; height: 380px" ></a><br>
    									<a href="content?num=${list.num }&pageNum=${page.cri.pageNum}&count=${page.cri.imgcount }"><b>${list.title}</b></a> <br>
    									${list.regdate }<br>
    									<small>조회수 : ${list.hit }</small>
    									</td>
    								</tr>
    						
    								
    								
    							</c:if>
    							</c:forEach>
    							</c:forEach>
    							
    						
    						
    					
    					
    				</table>
    				
    				
    				<!-- 남기기 -->
    				<!-- 검색 -->
    				<div class="search_area">
						<div class="search_wrap">
							<form id="seachForm" action="active?pageNum=${page.startPage -1 }" method="get">
								<input class="form-control-search" type="text" name="keyword" id="keyword" value="${page.cri.keyword }" placeholder="(제목+내용)검색어를 입력하세요." >
								<button class="btn btn-green" >검색</button>
							</form>
						</div>    			
    				</div>
    				
    				<!-- 페이징 처리 부분 -->
    				<div class="paging" > 
    				
  						<ul class="pagination ">
  							<!-- 이전 페이지  -->
  							<c:if test="${page.prev }">
    							<li class="page-item">
      								<a class="page-link" href="active?pageNum=${page.startPage -1 }">&laquo;</a>
   							 	</li>
   							 </c:if>
   							 
   							 <!-- 페이지 번호 -->
   							 <c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
    							<li class="page-item  ${page.cri.pageNum == num?'active' : '' }">
    						 		<a class="page-link" href="active?pageNum=${num }&keyword=${page.cri.keyword}" >${num }</a>
    							</li>
    						</c:forEach>
    						<!-- 다음 페이지 -->
    						<c:if test="${page.next }">
   								<li class="page-item">
     								<a class="page-link" href="active?pageNum=${page.endPage +1 }">&raquo;</a>
    							</li>
    						</c:if>
  						</ul>
    				</div>
    				<!-- 페이징 끝 -->
    				
    			</div>
    			<!-- end table-responsive -->
    		</div>
    		<!-- end b_body -->
    	</div>
	</div>
</div>



<%@include file="../include/footer.jsp"%>