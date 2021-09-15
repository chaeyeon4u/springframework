<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		AOP
	</div>
	<div class="card-body">
		<div class="card-header">
			Advice 테스트
		</div>
		<div class="card-body">
			<a href="before" class="btn btn-info btn-sm">@Before 테스트</a>
			<a href="after" class="btn btn-info btn-sm">@After 테스트</a>
			<a href="afterReturning" class="btn btn-info btn-sm">@AfterReturning 테스트</a>
			<a href="afterThrowing" class="btn btn-info btn-sm">@AfterThrowing 테스트</a>
			<a href="around" class="btn btn-info btn-sm">@Around 테스트</a>
		</div>
		
		<div class="card-header">
			AOP 예제
		</div>
		<div class="card-body">
			<a href="runtimeCheck" class="btn btn-info btn-sm">요청 처리 시간 측정</a>
			<a href="authCheck" class="btn btn-info btn-sm">인증 여부 확인</a>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>