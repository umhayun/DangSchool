<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="../include/header.jsp"%>

<style>
	.mar{
		padding-top: 10px;
		padding-bottom: 10px;
		
	}
	.textmar{
	padding-top: 10px;
		padding-bottom: 10px;
		text-align: center;
	}
</style>


<div class="container mar"  >
	<div class ="col" >
    	<div class="col-sm-6 col-md-10 col-lg-10 mar">
	
    		<div class="card-header bg-green text-white textmar">게시글 등록</div>
    		<div class="b_body">
    			<form role="form" action="regform" method="post" id="regform"  enctype="multipart/form-data">
    				<table class="table table-bordered">
    					<tr>
    						<td>제목</td>
    						<td><input class="form-control" type="text" name="title" id="title" size="23"></td>
    						
    					</tr> 
    					<tr>
							<td>작성자</td>
    						<td><input class="form-control" type="text" name="id" id="id" size="23" value="${sessionScope.user_id}"></td>
    					</tr> 
    					<tr>
    						<td colspan="2"><textarea class="form-control" rows="20" name="content" id="content" ></textarea></td>	
    					</tr> 
    					<tr>
    							<td colspan="2">
    							<div  id="file-list">
    							<input type="file"name="file" >
    							<a href="#" onclick="addFile();">파일추가</a>
    							</div>
    							</td>
    					</tr>
    				</table>
    				<input type="submit" class="btn btn-green float-right"  value="등록">
    				<button type="button" class="btn btn-light green float-right" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count}'">취소</button>  			
    			</form>
    		</div>
    		<!-- end b_body -->
    	</div> 
	</div>
	</div>
	
	<!-- end row -->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>


<%@include file="../include/footer.jsp"%>
<script>
    function addFile() {
        $("#file-list").append("<br><input type='file' name='file'><a href='#' onclick='addFile()'>파일추가</a>");
       
    }
 
</script>