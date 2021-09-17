<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
   <div class="card-header">
      로그인 폼
   </div>
   <div class="card-body">
   		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
         <div class="alert alert-danger mb-2" role="alert">
         	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'Bad credentials'}">
         		아이디 또는 비밀번호 불일치
         	</c:if>	
         	<c:if test="${fn:contains(SPRING_SECURITY_LAST_EXCEPTION.message, 'principle exceeded')}">
         		인증 횟수가 초과되었습다.
         	</c:if>	
         </div>
      </c:if>
      <form method="post" action="${pageContext.request.contextPath}/login">
      	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
         <div class="form-group">
             <label for="mid">Member ID</label>
             <input type="text" class="form-control" id="mid" name="mid">
         </div>
         <div class="form-group">
            <label for="mpassword">Member Password</label>
            <input type="password" class="form-control" id="mpassword" name="mpassword">
         </div>
         <button type="submit" class="btn btn-info btn-sm mt-2">로그인</button>
      </form>   
   </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>