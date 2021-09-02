<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		JSTL을 이용해서 List 반복 처리
	</div>
	<div class="card-body">
		
		
		<table class="table table-striped">
			 <thead>
			    <tr>
			      <th scope="col">No</th>
			      <th scope="col">Title</th>
			      <th scope="col">Content</th>
			      <th scope="col">Writer</th>
			      <th scope="col">Date</th>
			    </tr>
			  </thead>
			  
			  
			  <c:forEach var="board" items="${boardList}">
			  	<%-- true면 넣고, false면 뺀다. --%>
			  	<tbody>
						 <tr>
					      <th scope="row">${board.no}</th>
					      <td>${board.no}</td>
					      <td>${board.no}</td>
					      <td>${board.no}</td>
					      <td>${board.no}</td>
					      <td><fmt:formatDate value=""/> ${board.no} pattern="yyyy-MM-dd/>"</td> 
					    </tr>
			 	 </c:forEach>
			  </tbody>
			  
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>