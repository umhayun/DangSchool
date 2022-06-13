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
  
  .colll {
	 margin-left: 12.5px;
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
  
/*   .star-rating label {
  	-webkit-text-fill-color: transparent;
  	-webkit-text-stroke-width: 2.3px;
  	-webkit-text-stroke-color: #2b2a29;
  	cursor: pointer;
  } */
  
  .star-rating label {
  	-webkit-text-fill-color: #ffd700;
  }
  
/*   .star-rating label: hover,
  .star-rating label: hover ~ label {
  	-webkit-text-fill-color : pink;
  } */
  
 

</style>

<div class="container">

		<div class="col-sm-6 col-md-2 col-lg-2 text-center b_menu">
	    	<h4><a class="text-green" href="/DangSchool/">활동사진</a>&emsp;&emsp;&emsp;&emsp;
	    		<a class="text-green" href="/DangSchool/review/list">리뷰</a>
	    	</h4>
    	</div>
<form>

		 <div class="right" style="margin-top: 3px;"> 
		  <button type="button" class="btn btn-green" onclick="location.href='list?&pageNum=${cri.pageNum }&count=${cri.count }'">목록</button>
		  <c:if test="${sessionScope.user_id eq review.id }">
          <button type="button" class="btn btn-green" onclick="location.href='delete?num=${review.num}&pageNum=${cri.pageNum }&count=${cri.count }'">삭제</button>
          </c:if>
		 </div> 
		&emsp;
		
		<div class="left" style="margin-bottom: 10px;">
			<h4>Review | content 보기</h4>
		</div>	 
		<hr>
	  <div class="b_body" style="margin:5px;">
	  	<div class="row" style="margin-bottom:5px;">
		  	<div class="colll">
	        <input class="form-control" name='num' id="num" value="${review.num }" readonly="readonly">  
	        </div>
	        &emsp;
	        <div class="colll">  
            <input class="form-control" name='id' id="id" value="${review.id }" readonly="readonly"> 
            </div>
        </div>

		<div class="row" style="margin-bottom:5px;">
		  <div class="colll">
           <input class="form-control" name='r_title' id="r_title" value="${review.r_title}" readonly="readonly"> 
	      </div>
	      &emsp;
		  <div class="star-rating space-x-4 mx-auto">
		  	<c:choose>
		  		<c:when test="${review.star eq 5 }">
		  			<label class="5star">★★★★★</label>
		  		</c:when>
		  		<c:when test="${review.star eq 4 }">
		  			<label class="4star">★★★★</label>
		  		</c:when>
		  		<c:when test="${review.star eq 3 }">
		  			<label class="3star">★★★</label>
		  		</c:when>
		  		<c:when test="${review.star eq 2 }">
		  			<label class="2star">★★ </label>
		  		</c:when>
		  		<c:otherwise>
		  			<label class="1star">★</label>
		  		</c:otherwise>
		  	</c:choose>
          </div>
        </div>
          
    	<div class="row">
<!--          <div class="column">
            <input class="writer" name='img' id="img" size="15" placeholder="이미지">
         </div> -->
         
         <div class="col">
            <input class="form-control" name='r_kind' id="r_kind" size="15" value="${review.r_kind }" readonly="readonly">
         </div>
         
         <div class="col">
            <input class="form-control" name='r_weight' id="r_weight" size="15" value="${review.r_weight }" readonly="readonly">
         </div>
         
        <div class="col">
                <select class="form-control" name='r_size' id="r_size" readonly="readonly">
                	<option value="${review.r_size }" ${review.r_size  == '소' ? 'selected="selected"' : ''}>소</option>
                	<option value="${review.r_size }" ${review.r_size  == '중' ? 'selected="selected"' : ''}>중</option>
                	<option value="${review.r_size }" ${review.r_size  == '대' ? 'selected="selected"' : ''}>대</option>
                </select>
      
         </div>
		</div>
		<div style="margin:5px auto 10px auto;">
	         <tr>
	    		<td colspan="2"><textarea class="form-control" readonly="readonly" rows="20" name="r_content" id="r_content">${review.r_content }</textarea></td>
	    	</tr>
    	</div>
  	</div>

</form>
</div>

<%@ include file="../include/footer.jsp" %>