<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Spring Tag Library
		
	</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">
				DTO 객체(Command Object)와 폼 연결
			</div>
			<div class="card-body">
				<a href="form1" class="btn btn-info btn-sm">form1</a>
			</div>
		</div>
		
		<div class="card m-2">
			<div class="card-header">
				DTO 객체의 필드값을 양식의 데이터로 세팅
			</div>
			<div class="card-body">
				<a href="form2" class="btn btn-info btn-sm">form2</a>
			</div>
		</div>
		<div class="card m-2">
				<div class="card-header">
					DTO 객체의 필드값을 양식의 드롭다운리스트(checkbox 태그)로 세팅
				</div>
				<div class="card-body">
					<a href="form3" class="btn btn-info btn-sm">form3</a>
				</div>
		</div>
		<div class="card m-2">
				<div class="card-header">
					DTO 객체의 필드값을 양식의 드롭다운리스트(radio 태그)로 세팅
				</div>
				<div class="card-body">
					<a href="form4" class="btn btn-info btn-sm">form4</a>
				</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>