<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>수정&비밀번호 확인</title>
<script>
setTimeout(function() {
    opener.location.reload(); //부모창 리프레쉬
    opener.location.href='modify?num=${num }&pageNum=${cri.pageNum}&count=${cri.count}&keyword=${cri.keyword}'; 
    self.close(); //현재창 닫기
    }, 2000); // 2초후 실행 1000당 1초 
</script>

</head>
<body>
	<h2>비밀번호가 확인 되었습니다.</h2>
	<h3>잠시만 기다리세요...</h3> 
</body>
</html>