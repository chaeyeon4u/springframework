<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		DTO 객체의 필드값을 양식의 드롭다운리스트(select 태그)로 세팅
	</div>
	<div class="card-body">
		<!-- 위에꺼 알아야함 -->
		<%-- <form method="post" action="form2">
		  <div class="form-group">
		    <label for="mtype">Type</label>
		    <select class="form-control" id="mtype" name="mtype">
		      <c:forEach var="type" items="${typeList}"><!-- ${member.mtypes}는 List -> 하나씩 mtype에 할당 -->
		      	<option value="${type}" 
		      			<c:if test="${member.mtype == type}">selected</c:if>
		      	>${type}</option>
		      </c:forEach>
		    </select>
		  </div>
		  
		  </div>
		  <button type="submit" class="btn btn-primary">제출</button>
		</form> --%>
		
		<form:form method="post" action="form2" modelAttribute="member">
		  <div class="form-group">
		    <label for="mtype">Type</label>
		    <form:select path="mtype" items="${typeList}" class="form-control"/>
		  </div>
		  
		  </div>
		  <button type="submit" class="btn btn-primary">제출</button>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>