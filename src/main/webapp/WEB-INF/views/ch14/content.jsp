<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Data Access
	</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">
				연결 테스트
			</div>
			<div class="card-body">
				<a href="testConnecToDB" class="btn btn-info btn-sm">DB 연결</a>
			</div>
		</div>	
		
		<div class="card m-2">
			<div class="card-header">
				JDBC 연습
			</div>
			<div class="card-body">
				<a href="testInsert" class="btn btn-info btn-sm">Insert</a>
				<a href="testSelect" class="btn btn-info btn-sm">Select</a>
				<a href="testUpdate" class="btn btn-info btn-sm">Update</a>
				<a href="testDelete" class="btn btn-info btn-sm">Delete</a>
			</div>
		</div>

		<div class="card m-2">
			<div class="card-header">
				MyBatis를 이용하는 Dao
			</div>
			<div class="card-body">
				<a href="join" class="btn btn-info btn-sm">회원가입</a>
				<a href="login" class="btn btn-info btn-sm">로그인</a>
				<a href="boardList" class="btn btn-info btn-sm">게시판</a>
			</div>
		</div>		
		
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>