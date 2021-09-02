<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		@ModelAttribute로 전달된 데이터 읽기
	</div>
	<div class="card-body">
		<ul>
			<!-- @ModelView -> request영역에 저장되므로 ${}로 찾을 수 있다. -->
			<c:forEach var="color" items="${colors}">
				<li>${colors}</li>
			</c:forEach>
		</ul>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>