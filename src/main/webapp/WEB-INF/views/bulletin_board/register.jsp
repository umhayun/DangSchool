<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록페이지</title>

</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container">
	<div class ="row">
	
		<div class="col-sm-6 col-md-2 col-lg-2 text-center b_menu">
    		<h4><a class="text-green" href="/DangSchool/bulletin_board/list">공지사항</a>&emsp;&emsp;&emsp;&emsp;
    		<a class="text-green" href="/DangSchool/qna_board/list">Q&A</a>
    	</div>
   	
    	<div class="col-sm-6 col-md-10 col-lg-10 ">
    	
    		<div class="b_header">
    			<h4><strong>|공지사항</strong>|<small>공지사항 등록페이지 입니다.</small></h4>
    			
    		</div>
    		<div class="card-header bg-green text-white">게시글 등록</div>
    		<div class="b_body">
    			<form role="form" action="register" method="post" name="regform">
    				<table class="table table-bordered" width="100%" cellspacing="0">
    					<tr>
    						<td>제목</td>
    						<td><input class="form-control" type="text" name="title" id="title" size="23"></td>
    					</tr>
    					<tr>
    						<td>작성자</td>
    						<td><input class="form-control" type="text" name="name" id="name" size="23" value="${member.name }"></td>
    					</tr> 
    					<tr>
    						<td colspan="2"><textarea class="form-control" rows="20" name="content" id="content" ></textarea></td>
    					</tr> 
    					
    				</table>
    				<input type="submit" class="btn btn-green float-right" onclick="check(); return false;" value="등록">
    				<button type="button" class="btn btn-light-green float-right" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count}'">취소</button>  			
    			</form>
    		</div>
    		<!-- end b_body -->
    	</div>
	</div>
	<!-- end row -->
		
</div>

<script type="text/javascript">
	function check(){
		if(document.regform.title.value == ''){
			alert("제목을 입력하세요");	
			return;
		}else if(document.regform.name.value == '' ){
			alert("이름을 입력하세요");
			return;
		}else if(document.regform.content.value == '') {
			alert("내용을 입력하세요");
			return;
		} else if(confirm("공지사항을 등록 하시겠습니까?")){
			document.regform.submit(); 
		}else{
			return;
		}
	}
</script>


<%@ include file="../include/footer.jsp" %>
</body>
</html>