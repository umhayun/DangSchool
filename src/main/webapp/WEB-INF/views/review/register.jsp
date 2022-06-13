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
<form role="form" action="register" method="post" name="regform" id="regform">

		 <div class="right" style="margin-top: 3px;"> 
				<input type="submit" class="btn btn-green" value="등록" onclick="Check()">
				<button type="button" class="btn btn-green" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count }'">취소</button>
		 </div> 
		&emsp;
		
		<div class="left" style="margin-bottom: 10px;">
			<h4>Review | 전체 리뷰</h4>
		</div>	 
		<hr>
	   <div class="b_body" style="margin:5px;">

	  	<div class="row" style="margin-bottom:3px;">
		  	<div style="margin-left: 12px;">
	           <input class="form-control" name='r_title' id="r_title" placeholder="제목">
	        </div>
	        &emsp;
	        <div><input class="form-control" name='id' id="id" value="${sessionScope.user_id }" readonly="readonly"></div>
			&emsp;
			<div class="star-rating space-x-4 mx-auto">
	          <input type="radio" id="5-stars" name="star" value="5" v-model="stars" checked/>
				<label for="5-stars" class="star pr-4">★</label>
			  <input type="radio" id="4-stars" name="star" value="4" v-model="stars" />
				<label for="4-stars" class="star">★</label>
			  <input type="radio" id="3-stars" name="star" value="3" v-model="stars" />
				<label for="3-stars" class="star">★</label>
			  <input type="radio" id="2-stars" name="star" value="2" v-model="stars" />
				<label for="2-stars" class="star">★</label>
			  <input type="radio" id="1-stars" name="star" value="1" v-model="stars" />
				<label for="1-stars" class="star">★</label>
		    </div>
        </div>
          
    	<div class="row">
<!--          <div class="column">
            <input class="writer" name='img' id="img" size="15" placeholder="이미지">
         </div> -->
         
         <div class="col">
            <input class="form-control" name='r_kind' id="r_kind" size="15" placeholder="댕댕이 종류">
         </div>
         
         <div class="col">
            <input class="form-control" name='r_weight' id="r_weight" size="15" placeholder="댕댕이 몸무게(kg)_숫자만 입력">
         </div>
         
        <div class="col">
                <select class="form-control" name='r_size' id="r_size">
                	<option>사이즈를 선택해주세요</option>
                    <option>소</option>
                    <option>중</option>
                    <option>대</option>
                </select>
      
         </div>
		</div>
		<div style="margin:5px auto 10px auto;">
	         <tr>
	    		<td colspan="2"><textarea class="form-control" rows="20" name="r_content" id="r_content" placeholder="내용을 입력해주세요."></textarea></td>
	    	</tr>
    	</div>
  	</div>

</form>
</div>

<script type="text/javascript" src="//code.jquery.com/jquery-3.4.0.min.js"></script>
<script type="text/javascript">

	function Check(){
		if(document.regform.r_title.value == ''){
			alert("제목을 입력하세요");	
			return;
		}else if(document.regform.r_content.value == '') {
			alert("내용을 입력하세요");
			return;
		} else if(confirm("리뷰를 등록 하시겠습니까?")){
			document.regform.submit(); 
		}else{
			return;
		}
	}

	function getCheckboxValue(event) {
	      let result = '';
	      if (even.target.checked) {
	         result = event.target.value;
	      } else {
	         result = '';
	      }
	      
	      document.getElementByld('star').innerText = result;
	   };
</script>

<%@ include file="../include/footer.jsp" %>
