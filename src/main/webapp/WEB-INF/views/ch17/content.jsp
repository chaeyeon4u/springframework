<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Spring Security
	</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">
				로그인/로그아웃
			</div>
			<div class="card-body">
				<a href="loginForm" class="btn btn-info btn-sm">로그인</a>
				<a href="${pageContext.request.contextPath}/logout" class="btn btn-info btn-sm">로그아웃</a>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>