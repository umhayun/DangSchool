<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <title>댕스쿨</title>
  <!-- 
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
  <link href="/MyWeb/css/business-casual.css" rel="stylesheet">
  -->
 
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dang_home.css" type="text/css">
  <script src="//code.jquery.com/jquery-3.6.0.min.js"></script> 

</head>

<body>
  <div id="wrap">
   
    <header id="header">
      <!--header는 상단영역(#header)을 정의하는 시멘틱 웹 태그-->
      <div id="logo">
        <h1><a href="/DangSchool"><img src="${pageContext.request.contextPath}/resources/img/dang2.png"></a></h1>
      </div>
      <div id="header_right">
        <nav id="gnb">
         	 <c:choose>
                   <c:when test="${sessionScope.user_id == null }">
                  		<li class="first"><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
                   		<li class="last"><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
                   </c:when>
                   <c:otherwise>
          			   <li class="first"><a href="${pageContext.request.contextPath}/member/myPage">마이페이지</a></li>
          			   <li><a href="${pageContext.request.contextPath}/reservation/myreserve">예약현황</a></li>
          			   <li class="last"><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
                    </c:otherwise>
                  </c:choose>
        </nav><br>
        <nav id="gnb">
        	<!-- 아이디가 dangschool -->
       		<c:if test="${sessionScope.user_id eq 'dangschool' }">
        		<li><a href="${pageContext.request.contextPath}/consult_rs/c_list">상담예약 목록</a></li>
        		<li><a href="${pageContext.request.contextPath}/reservation/adminreserve">관리자-예약현황</a></li>
            	<li><a href="${pageContext.request.contextPath}/bulletin_board/register">공지사항-공지사항 작성</a></li>
        	</c:if>
        </nav>
      </div>
    </header>
    
    <section id="display_li">
    
    <nav id="lnb">
      <!--nav는 메뉴(내비게이션바)를 정의하는 시멘틱 웹 태그-->
      <h3 class="hidden">주 메뉴</h3>
      
      <ul>
        <li><a href="/DangSchool">홈</a>

        </li>
        <li><a href="${pageContext.request.contextPath}/guide/intro">학교 소개</a>
        	<ul class="sub">
        		<li><a href="${pageContext.request.contextPath}/guide/intro">댕스쿨 소개</a></li>
            	<li><a href="${pageContext.request.contextPath}/guide/guide">오시는길</a></li>
        	</ul></li>
        <li><a href="${pageContext.request.contextPath}/guide/schedule">수업일정</a>
       		<ul class="sub">
        		<li><a href="${pageContext.request.contextPath}/guide/schedule">시간표</a></li>
            	<li><a href="${pageContext.request.contextPath}/guide/training_guide">교육안내</a></li>
        	</ul></li>

        <li><a href="/DangSchool/activity/active">갤러리</a>
        	<ul class="sub">
        		<li><a href="/DangSchool/activity/active">활동 사진</a></li>
            	<li><a href="/DangSchool/review/list">리뷰</a></li>
        	</ul></li>

        <li><a href="/DangSchool/bulletin_board/list">가정통신문</a>
        	<ul class="sub">
        		<li><a href="/DangSchool/qna_board/list">Q&A</a></li>
            	<li><a href="/DangSchool/bulletin_board/list">공지사항</a></li>
        	</ul>
        </li>

        <li><a href="/DangSchool/consult_rs/c_register">예약하기</a>
       		 <ul class="sub">
        		<li><a href="/DangSchool/reservation/reserve">서비스 예약</a></li>
            	<li><a href="/DangSchool/consult_rs/c_register">상담 예약</a></li>
        	</ul>
       	</li>
      
      </ul>
    </nav>
   </section>
  </div>
</body>

</html>