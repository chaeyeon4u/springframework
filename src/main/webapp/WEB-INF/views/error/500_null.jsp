<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		서버 실행 오류
	</div>
	<div class="card-body">
		<p>데이터가 존재하지 않습니다.</p>
		<p>잘못된 데이터가 넘어왔거나, 일시 서버 오류이므로 잠시후 다시 시도해주세요.</p>
		<div>
			<a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/">홈으로 돌아가기</a>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>