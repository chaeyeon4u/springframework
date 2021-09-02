<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		프로젝트 생성 및 실행
	</div>
	<div class="card-body">
	<!-- resources 경로는 controller 실행하지 않고, 사용자에게 보여준다. -->
	<img src="${pageContext.request.contextPath}/resources/images/logo-spring.png"/>
	<hr/>
		1. STS 설치<br/>
		2. Plug-in 설치<br/>
		3. 프로젝트 생성<br/>
		4. 프로젝트 설정<br/>
	</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>