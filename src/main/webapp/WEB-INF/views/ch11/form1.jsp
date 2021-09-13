<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		DTO 객체(Command Object)와 폼 연결
	</div>
	<div class="card-body">
		<!-- form:form은 default가 post -->
		<form:form method="post" modelAttribute="member">
		  <div class="form-group">
		    <label for="mid">ID</label>
		    <form:input type="text" class="form-control"  path="mid"/> <!-- form일때는 name이 있어야 서버로 전송이된다. path가 id와 name으로 들어간다 -->
		  </div>
		  <div class="form-group">
		    <label for="mname">Name</label>
		    <form:input type="text" class="form-control"  path="mname"/>
		  </div>
		  <div class="form-group">
		    <label for="mpassword">Password</label>
		    <form:password class="form-control"  path="mpassword"/>
		  </div>
		  <div class="form-group">
		    <label for="mnation">Nation</label>
		    <form:input type="text" class="form-control" path="mnation"/><!-- 끝태그 있어야함 -->
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>