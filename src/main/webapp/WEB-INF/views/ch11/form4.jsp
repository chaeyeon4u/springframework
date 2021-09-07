<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		DTO 객체의 필드값을 양식의 드롭다운리스트(RADIO 태그)로 세팅
	</div>
	<div class="card-body">
		<form method="get" action="form3">
			<div>
				<c:forEach var="job" items="${jobList}" varStatus="status">
					<span style="margin:0; padding:0;">
						<input type="radio" class="ml-2" type="radio" 
				  		 id="lang${status.count}" name="mjob" value="${job}"
				  		 	<c:if test="${member.mjob == job}">checked</c:if>
				  		 />
				  		 <label style="margin:0; padding:0;" for="lang${status.count}">${job}</label>
				  	</span>
				</c:forEach>
			</div>
			<button class="btn btn-info btn-sm">제출</button>
		</form> 
		
		<form:form modelAttribute="member" method="post" action="form3">
			<div>
				<form:radiobuttons items="${cityList}" path="mcity" 
								itemValue="code" itemLabel="label" class="ml-2"/>
			</div>
			<button class="btn btn-info btn-sm">제출</button>
		</form:form>
		
		<%-- <form:form modelAttribute="member" method="post" action="form3">
			<div>
				<form:radiobuttons items="${skillList}" path="mskill" 
								class="ml-2" itemValue="code" itemLabel="label"/>
			</div>
		</form:form> --%>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>