<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오시는 길</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container"> 
   <div class="b_header">
      <div class="col-5 b_menu ">
         <h4><strong>| 학교소개 </strong>| <small> 오시는길 입니다.</small></h4>
      </div>
   </div>
   <div class="b_body">
      <div class="col-sm-6 col-md-10 col-lg-10 ">
         <div class="col-5 text-line">
            <h3>| 위치안내 <small> 네이게이션에 "댕스쿨"로 검색하시면 됩니다</small> </h3>
            <h4>서울시 서대문구  더조은</h4> 
            <h4>010.xxxx.xxxx / 02.xxx.xxxx</h4>
         </div>
         <div id="map" style="width:800px;height:500px;margin:0 auto 10% auto;"></div>   
      </div>
   </div> 
</div>

<%@ include file="../include/footer.jsp" %>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=55cb9b8e008e13848ee80246057584b9"></script>
<script>
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
       mapOption = {
           center: new kakao.maps.LatLng(37.554995269, 126.936002094), // 지도의 중심좌표
           level: 4, // 지도의 확대 레벨
           mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
       }; 
   // 지도를 생성한다 
   var map = new kakao.maps.Map(mapContainer, mapOption); 
   // 지도에 마커를 생성하고 표시한다
   var marker = new kakao.maps.Marker({
       position: new kakao.maps.LatLng(37.554995269, 126.936002094), // 마커의 좌표
       draggable : true, // 마커를 드래그 가능하도록 설정한다
       map: map // 마커를 표시할 지도 객체
   });
   // 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
   kakao.maps.event.addListener(marker, 'click', function() {
       alert('경기도 남양주시 어딘가에 있는 가상의 주소');
   });
   // 커스텀 오버레이를 생성하고 지도에 표시한다
   var customOverlay = new kakao.maps.CustomOverlay({
      map: map,
      content: '<div style="padding:0 5px;background:#fff;"> 댕스쿨 [ DangSchool ]</div>', 
      position: new kakao.maps.LatLng(37.554995269, 126.936002094), // 커스텀 오버레이를 표시할 좌표
      xAnchor: 0.5, // 컨텐츠의 x 위치
      yAnchor: 0 // 컨텐츠의 y 위치
   });
</script>

</body>
</html>