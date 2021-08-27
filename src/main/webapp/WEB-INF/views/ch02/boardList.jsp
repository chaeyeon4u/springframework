<%@ page contentType="text/html; charset=UTF-8" %>
<%-- <%@ %>안에는 page, include 등.. 작성 --%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		게시물 목록
	</div>
	<div class="card-body">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">번호</th>
		      <th scope="col">제목</th>
		      <th scope="col">내용</th>
		      <th scope="col">글쓴이</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<% for(int i=1;i<=5; i++){ %><%-- <% %>안에는 자바코드 작성 --%>
			    <tr>
			      <th scope="row"><%=i%></th><%-- <%= %>는 출력코드 작성 --%>
			      <td>제목<%=i%></td>
			      <td>내용<%=i%></td>
			      <td>글쓴이<%=i%></td>
			    </tr>
		    <% } %>
		  </tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>