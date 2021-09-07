<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		DTO 객체의 필드값을 양식의 드롭다운리스트(checkbox 태그)로 세팅
	</div>
	<div class="card-body">
		<form method="get" action="form3">
			<div>
				<c:forEach var="language" items="${languageList}" varStatus="status">
					<span style="margin:0; padding:0;">
						<input class="ml-2" type="checkbox" 
				  		 id="lang${status.count}" name="mlanguage" value="${language}"
				  		 <c:forEach var="temp" items="${member.mlanguage}">
				  		 	<c:if test="${temp == language}">checked</c:if>
				  		 </c:forEach>/>
				  		 <labe style="margin:0; padding:0;" for="lang1">${language}</label>
				  	</span>
				</c:forEach>
			</div>
		</form> 
		
		<form:form modelAttribute="member" method="post" action="form3">
			<div>
				<form:checkboxes items="${languageList}" path="mlanguage" 
								class="ml-2"/>
			</div>
		</form:form>
		
		<form:form modelAttribute="member" method="post" action="form3">
			<div>
				<form:checkboxes items="${skillList}" path="mskill" 
								class="ml-2" itemValue="code" itemLabel="label"/>
			</div>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>