<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ include file="../include/header.jsp" %>

<style type="text/css">
  
  .right {
  	float: right;
  }
  
  .left {
  	margin-bottom: 3px;
  }
  
  
  .star-rating {
  	display: flex;
  	flex-direction: row-reverse;
  	font-size: 1.5rem;
  	line-height: 2.5rem;
  	justify-content: space-around;
  	padding: 0 0.2em;
  	text-align: center;
  	width: 5em;
  }
  
  .star-rating input {
  	display: none;
  }
  
  .star-rating label {
  	-webkit-text-fill-color: transparent;
  	-webkit-text-stroke-width: 2.3px;
  	-webkit-text-stroke-color: #2b2a29;
  	cursor: pointer;
  }
  
  .star-rating :checked ~ label {
  	-webkit-text-fill-color: #ffd700;
  }
  
  .star-rating label: hover,
  .star-rating label: hover ~ label {
  	-webkit-text-fill-color : pink;
  }

</style>

<div class="container">

		<div class="col-sm-6 col-md-2 col-lg-2 text-center b_menu">
	    	<h4><a class="text-green" href="/DangSchool/">활동사진</a>&emsp;&emsp;&emsp;&emsp;
	    		<a class="text-green" href="/DangSchool/review/list">리뷰</a>
	    	</h4>
    	</div>
<!-- DataTales Example -->

		<div class="right" style="margin-top: 3px;"> 
    		<button type="button" class="btn btn-green" onclick="location.href='register?pageNum=${pageMaker.cri.pageNum}&count=${pageMaker.cri.count }'">글쓰기</button>
		 </div> 
		&emsp;
		
		<div class="left" style="margin-bottom: 10px;">
			<h4>Review | 전체 리뷰</h4>
		</div>	 
		<hr>
 
       			<div class="b_body">
				<div class="table-responsive">
					<table class="table table-bordered" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>								
							</tr>
						</thead>
						<c:forEach var="article" items="${review_list }">
						<tbody>
							<tr>
								<td>${article.num }</td>
	
								<td>
									<a href="content?num=${article.num }&pageNum=${pageMaker.cri.pageNum}&count=${pageMaker.cri.count}">${article.r_title }</a>
								</td>
								<td>${article.id }</td>

							</tr>
						</tbody>
						</c:forEach>
					</table>


	
					
					<!-- 페이징 처리 부분 부트스트랩 참고 -->
					<ul class="pagination justify-content-center">
					
					<!-- 1. 이전 페이지 활성화 여부 -->
					<c:if test="${pageMaker.prev }">
                       	 <li class="page-item">
                       	 <!-- 6. 이전 버튼 활성화 링크 -->
                       	 <!-- 시작 페이지는 startPage가 11일때 활성화 됩니다.
                       	 	이전 페이지를 출력했을 때, startPage -1 = 10을 pageNum으로 전달
                       	 	getPageStart()를 통해 마이바티스에 값이 전달
                       	 -->
							<a class="page-link" href="list?pageNum=${pageMaker.startPage -1 }">Previous</a>
						</li>
					</c:if>
					
					<!-- 2. 페이지 번호 활성화 여부 -->   
					<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
						<!-- 4.1 ##active 속성을 이용하여 활성화 버튼을 연결 / ↓ 삼항연산자 이용 -->
						<li class="page-item ${pageMaker.cri.pageNum == num ? 'active' : '' }">
						<!-- 4. list 요청으로 페이지 번호를 전달, 자동으로 count=10(보여질 페이지수)
							사용자가 버튼을 클릭 시에 해당 버튼에 해당하는 페이지 번호가 Criteria에 매핑됨 -->					    
					    	<a class="page-link" href="list?pageNum=${num }">${num }</a>
					    </li>
				    </c:forEach>
					
					<!-- 3. 다음페이지 활성화 여부 -->
					<c:if test="${pageMaker.next }">
					    <li class="page-item">
					    <!-- 5. Next버튼 활성화 링크 -->
					    <!-- 
					    	pageMaker의 endPage는 화면에 보여지는 끝번호 10이 들어있기 때문에
					    	1증가한 값이 11은 pageNum(페이지번호)에 전달합니다
					    	11이 Criteria 클래스에 pageNum(setter)에 전달되고,
					    	getPageStarter()를 통해서 마이바티스 쿼리에 전달됨
					    -->
					      <a class="page-link" href="list?pageNum=${pageMaker.endPage +1 }">Next</a>
					    </li>
					</c:if>
				    </ul>
					<!-- 페이징 처리 끝 -->
				</div>
			</div>
		</div>
	<!-- End of Main -->
<%@ include file="../include/footer.jsp" %>