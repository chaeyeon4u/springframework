<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		요청 URL 문제
	</div>
	<div class="card-body">
		<p>요청 URL이 잘못 구성되었습니다.</p>
		<div>
			<a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/">홈으로 돌아가기</a>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>