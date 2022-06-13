<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<html lang="ko">
<script language="javascript">

function getCookie(key) {
    var result = null;
    var cookie = document.cookie.split(';');
    cookie.some(function (item) {
        // 공백을 제거
        item = item.replace(' ', '');
 
        var dic = item.split('=');
 
        if (key === dic[0]) {
            result = dic[1];
            return true;    // break;
        }
    });
    return result;
}

var popup = getCookie("layerCookie");

function pop(){ 
	if(popup != "done"){
	window.open("pop","시간표","width=513, height=620, left=0, top=0, toolbar=0, status=yes, menubars=0, scrollbars=0, resizable=0, location=0, directories=0")
	}
}
	
</script>
<%@include file="include/header.jsp"%>


<!-- 팝업창 -->
<body onload="pop()">

        <aside id="main_banner" class="main_banner">
 			<!-- <img src="${pageContext.request.contextPath}/resources/img/slide1.jpg" alt="메인 이미지">  -->
        </aside>
            
	<main class="px-3">
        <h6 class="font_7" style="line-height: normal; font-size: 30px;">
			<span style="font-family: bm-hanna, sans-serif;"><span style="color: #1A4244;"><span style="letter-spacing: normal;">댕스쿨에 오신걸 환영합니다!</span></span></span>
		</h6>
 	</main>


            
    <article id="service_content">
        <h6 class="font_7" style="line-height: normal; font-size: 30px;">
			<span style="font-family: bm-hanna, sans-serif;"><span style="color: #1A4244;"><span style="letter-spacing: normal;">서비스 컨텐츠</span></span></span>
		</h6>
        <ul>
          <li class="m_17">
          	<a href="${pageContext.request.contextPath}/guide/training_guide"><img src="${pageContext.request.contextPath}/resources/img/home_icon.png" alt="best1">					
				<div>
					<h6 class="font_6" style="line-height: normal; font-size: 18px;">
						<span style="font-family: bm-hanna, sans-serif;"><span style="color: #1A4244;"><span style="letter-spacing: normal;">운영 프로그램</span></span></span>
					</h6>
				</div>
			</a>
		  </li>
						
          <li class="m_17">
          	<a href="${pageContext.request.contextPath}/guide/training_guide#part4"><img src="${pageContext.request.contextPath}/resources/img/home_menu_edu.png" alt="홈_메뉴_놀이.png">
              <div>
				<h6 class="font_7" style="line-height: normal; font-size: 18px;">
					<span style="font-family: bm-hanna, sans-serif;"><span style="color: #1A4244;"><span style="letter-spacing: normal;">놀이 프로그램</span></span></span>
				</h6>
			  </div>
            </a>
          </li>

          <li class="m_17">
          	<a href="${pageContext.request.contextPath}/guide/training_guide#part1"><img src="${pageContext.request.contextPath}/resources/img/home_menu_play.png" alt="홈_메뉴_교육.png">
             <div>
				<h6 class="font_6" style="line-height: normal; font-size: 18px;">
					<span style="font-family: bm-hanna, sans-serif;"><span style="color: #1A4244;"><span style="letter-spacing: normal;">교육 프로그램</span></span></span>
				</h6>
			 </div>

            </a>
          </li>
                   
          <li class="m_17">
          	<a href="${pageContext.request.contextPath}/guide/training_guide#part6"><img src="${pageContext.request.contextPath}/resources/img/home_icon2.png" alt="home_icon2.png">
              <div>
			    <h6 class="font_7" style="line-height: normal; font-size: 18px;">
					<span style="font-family: bm-hanna, sans-serif;"><span style="color: #1A4244;"><span style="letter-spacing: normal;">서비스 제공</span></span></span>
						</h6>
			 </div>

            </a>
          </li>
       </ul>
    </article>
            
    <aside id="intro">
        <h6 style="line-height: normal; font-size: 30px;">
			<span style="font-family: bm-hanna, sans-serif;"><span style="color: #1A4244;"><span style="letter-spacing: normal;">　</span></span></span>
		</h6> 
        <ul>
            <li class="m_r_10 m_r_11"><a href="${pageContext.request.contextPath}/guide/intro"><img src="${pageContext.request.contextPath}/resources/img/home_teacher.PNG" alt="선생님소개"></a></li>
            <li class="m_r_10 m_r_11"><a href="/DangSchool/activity/active"><img src="${pageContext.request.contextPath}/resources/img/home_dog.PNG" alt="친구소개"></a></li>
            <li class="m_r_11"><a href="/DangSchool/review/list"><img src="${pageContext.request.contextPath}/resources/img/home_review.PNG" alt="리뷰후기"></a></li>
        </ul>
     </aside>

<%@ include file="include/footer.jsp"%>
</body>
</html>
