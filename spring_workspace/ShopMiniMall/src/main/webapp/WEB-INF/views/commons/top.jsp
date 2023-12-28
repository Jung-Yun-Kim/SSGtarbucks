<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--top.jsp -->
<!-- login 세션 조회 -->
<c:if test="${empty login}">
	<a href="LoginUIServlet">로그인</a>
	<a href="MemberUIServlet">회원가입</a>
</c:if>
<c:if test="${!empty login}">
	<a href="LogoutServlet">로그아웃</a>
	<a href="MypageServlet">mypage</a>
	<a href="CartListServlet">장바구니</a>
</c:if>
