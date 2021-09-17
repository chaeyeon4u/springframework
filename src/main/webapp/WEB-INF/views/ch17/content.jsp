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
				<!-- 인증되지 안은 사용자 -->
				<sec:authorize access="isAnonymous()">
					<a href="loginForm" class="btn btn-info btn-sm">로그인</a>
				</sec:authorize>
			
				<!-- 인증된 사용자 -->
				<sec:authorize access="isAuthenticated()">
						<!--  사이트가 요청 위조 방지가 비활성화 되어있을 경우 -->
<%-- 					<a href="${pageContext.request.contextPath}/logout" class="btn btn-info btn-sm">로그아웃</a>
 --%>					
 						<!--  사이트가 요청 위조 방지가 활성화 되어있을 경우 -->
 						<form method="post" action="${pageContext.request.contextPath}/logout">
 							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 							<button class="btn btn-info btn-sm">로그아웃</button>
 						</form>
				</sec:authorize>
				
			</div>
		</div>
		
		<div class="card m-2">
			<div class="card-header">
				접근 권한
			</div>
			<div class="card-body">
				<a href="adminAction" class="btn btn-info btin-sm">Admin Action</a>
				<a href="managerAction" class="btn btn-info btin-sm">Manager Action</a>
				<a href="userAction" class="btn btn-info btin-sm">User Action</a>
				
				<hr/>
				<ul>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li>Admin Menu</li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_MANAGER')">
						<li>Manager Menu</li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<li>User Menu</li>
					</sec:authorize>
				</ul>
			</div>
		</div>
		
		
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>