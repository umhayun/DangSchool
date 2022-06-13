<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A게시판 등록 페이지</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
	<div class ="col">
	
		<div class="col-sm-6 col-md-2 col-lg-2 text-center b_menu">
    		<h4><a class="text-green" href="/DangSchool/bulletin_board/list">공지사항</a>&emsp;&emsp;&emsp;&emsp;
    		<a class="text-green" href="/DangSchool/qna_board/list">Q&A</a></h4>
    	</div>
   	
    	<div class="col-sm-6 col-md-10 col-lg-10 ">
    	
    		<div class="b_header">
    			<h4><strong>|공지사항</strong>|<small>Q&A 등록페이지 입니다.</small></h4>
    			
    		</div>
    		<div class="card-header bg-green text-white">게시글 등록</div>
    		<div class="b_body">
    			<form role="form" action="register" method="post" id="regform">
    				<table class="table table-bordered" width="100%" cellspacing="0">
    					<tr>
    						<td>제목</td>
    						<td><input class="form-control" type="text" name="q_title" id="q_title" size="23"></td>
    						<td>작성자</td>
    						<td><input class="form-control" type="text" name="id" id="id" size="23" value="${sessionScope.user_id}"></td>
    					</tr> 
    					<tr>
    						<td>비밀번호</td>
    						<td>
    							<input class="form-control" type="password" maxlength="4" placeholder="숫자4글자" id="q_pw" name="q_pw" onclick="pwCheck()"
    									 oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
    						</td>
    						<td>게시글</td>
    						<td>
    							<select name="bulletinNo" id="bulletinNo">
    								<option value=0>Q&A</option>
    								<c:if test="${sessionScope.user_id eq 'dangschool' }">
    								<option value=1>공지사항</option>
    								</c:if>
    							</select>
    						</td>
    					</tr> 
    					<tr>
    						<td colspan="4"><textarea class="form-control" rows="20" name="q_content" id="q_content" ></textarea></td>
    					</tr> 
    					
    				</table>
    				<input type="submit" class="btn btn-green float-right" onclick="check(); return false;" value="등록">
    				<button type="button" class="btn btn-light green float-right" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count}'">취소</button>  			
    			</form>
    		</div>
    		<!-- end b_body -->
    	</div> 
	</div>
	<!-- end row -->
		 
</div>


<script type="text/javascript">
	function check(){
		if($("#q_title").val().length < 1){
			alert("제목을 입력하세요");
			$("#q_title").focus();
		}else if($("#id").val().length < 1 ){
			alert("아이디를 입력하세요");
			$("#id").focus();
		}else if($("#q_pw").val().length < 4 || $("#q_pw").val().length > 4){
			alert("비밀번호를 입력하세요, 숫자+4글자 입니다.");
			$("#q_pw").focus();
		}else if($("#q_content").val().length < 1) {
			alert("내용을 입력하세요");
			$("#q_content").focus();
		} else if(confirm("공지사항을 등록 하시겠습니까?")){
			$("#regform").submit();
		}else{
			return;
		}
	}
	
	
	
	
</script>

<%@ include file="../include/footer.jsp" %>
</body>
</html>