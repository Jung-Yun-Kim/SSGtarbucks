<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>마이페이지 화면입니다.</h1>
<jsp:include page="commons/top.jsp" flush="true" /> <br>
<jsp:include page="commons/menu.jsp" flush="true" /> <br><hr>
<jsp:include page="member/mypageForm.jsp" flush="true" /> <br><hr>

</body>
</html>