<%@page import="javax.annotation.Resource"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dangschool.activity.command.ActivityVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
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

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/header.jsp"%>
<div class="container">

	<div class ="col">
	
    	<div class="col-sm-6 col-md-10 col-lg-10 mar">
    	
    		<div class="card-header bg-green text-white textmar">게시글 상세</div>
    		<div class="b_body">
    				<table class="table table-bordered">
    					<tr>
    						<td>제목  </td>
    						<td colspan="3">${content.title }</td>
    					</tr>
    					<tr>
    						<td >작성자</td>
    						<td colspan="3">${content.id }</td>
    					</tr> 
    					<tr>
    						
    						<td>작성일</td>
    						<td>${content.regdate }</td>
    						<td>조회수</td>
    						<td>${content.hit }</td>
    					</tr> 
    					<tr>
    						<td colspan="4">
    						<pre>${content.content }</pre>
    						<br>
		
    							
    						 <c:forEach var="img" items="${img}">
    						 	
    						 	<img alt="" src="/DangSchool/resources/upload/${img.save_file_name }"  ><br><br>
  							</c:forEach> 
    						</td>
    					</tr>
    					
    					
    				</table>
    				<button type="button" class="btn btn-green float-right" onclick="location.href='active?pageNum=${cri.pageNum}&count=${cri.imgcount}'">목록</button>  			
    				 <c:if test="${sessionScope.user_id==content.id }">
    				<button type="button" class="btn btn-light green float-right" onclick="location.href='delete?num=${content.num}'">삭제</button> 			
    				</c:if>
    			<!-- 이전글, 다음글 -->	
    			<div class="my-3 p-3 ng-white rounded shadow-sm">
    				<c:choose>
    					<c:when test="${content.num!=content.last }">
    						<button type="button" class="btn btn-green mr-3 mb-3" onclick="location.href='/DangSchool/activity/content?num=${content.num+1}'">다음글</button>
    					</c:when>
    					
    					<c:when test="${content.num==content.last }">
    						<button type="button" class="btn btn-warning mr-3 mb-3" disabled>다음글이 없습니다.</button>
    					</c:when>
    				</c:choose>
    				<br>
    				<c:choose>
    					<c:when test="${content.num != content.first }">
    						<button type="button" class="btn btn-green mr-3 mb-3" onclick="location.href='/DangSchool/activity/content?num=${content.num-1}'">이전글</button>
   							<a href="/DangSchool/activity/content?num=${move.last}" style="color:black">${move.lasttitle }</a>
    					</c:when>
    					
    					<c:when test="${content.num==content.first }">
    						<button type="button" class="btn btn-warning mr-3 mb-3" disabled>이전글이 없습니다.</button>
    					</c:when>
    				</c:choose>
    			</div>
    			<!-- end 이전글, 다음글  -->
    		</div>
    		<!-- end b_body -->
    	</div>
	</div>
</body>
</html>
<%@ include file="../include/footer.jsp"%>