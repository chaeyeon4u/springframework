<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
   <div class="card-header">
      DTO 객체의 필드값을 양식의 드롭다운리스트(select 태그)로 세팅
   </div>
   <div class="card-body">
       
       <%-- 복습2 --%>
      <form method="post" action="form2">
       	<div class="from-group">
       		<label for="mtype">Type</label>
       		<select class="form-control" id="mtype" name="mtype"><!-- select : option 메뉴를 지정할 컨트롤 -->
       			<c:forEach var="type" items="${typeList}">
       				<option value="type" 
       					<c:if test="${type == member.mtype}">selected</c:if>
       				></option>
       			</c:forEach>
       		</select>
       	</div>
       	
       	<div class="from-group">
       		<label for="mjob">Job</label>
       		<select class="form-control" id="mjob" name="mjob"><!-- select : option 메뉴를 지정할 컨트롤 -->
       			<c:forEach var="job" items="${jobList}">
       				<option value="job" 
       					<c:if test="${job == member.mjob}">selected</c:if>
       				></option>
       			</c:forEach>
       		</select>
       	</div>
       	
       	<div class="from-group">
       		<label for="mcity">City</label>
       		<select class="form-control" id="mcity" name="mcity"><!-- select : option 메뉴를 지정할 컨트롤 -->
       			<c:forEach var="city" items="${cityList}">
       				<option value="city.label" 
       					<c:if test="${city.code == member.mcity}">selected</c:if>
       				></option>
       			</c:forEach>
       		</select>
       	</div>
       	
       </form>
       
      <%-- <form method="post" action="form2">
        <div class="form-group">
          <label for="mtype">Type</label>
          <select class="form-control" id="mtype" name="mtype">
            <c:forEach var="type" items="${typeList}">
               <option value="${type}"
               <c:if test="${member.mtype == type}">selected</c:if>               
               >${type}</option>
            </c:forEach>
          </select>
        </div>
        
        <div class="form-group">
          <label for="mjob">Job</label>
          <select class="form-control" id="mjob" name="mjob">
            <option value="">---선택하세요---</option>
            <c:forEach var="job" items="${jobList}">
               <option value="${job}"
               <c:if test="${member.mjob == job}">selected</c:if>               
               >${job}</option>
            </c:forEach>
          </select>
        </div>
        
        <div class="form-group">
          <label for="mcity">City</label>
          <select class="form-control" id="mcity" name="mcity">
            <c:forEach var="city" items="${cityList}">
            	<option value="${city.code}"
            		<c:if test="${member.mcity == city.code}">selected</c:if>
            	>${city.label}</option>
            	<!-- 3번을 선택하고 싶다. -->
            </c:forEach>
          </select>
        </div>
        
        <button type="submit" class="btn btn-primary btn-sm">제출</button>
      </form> --%>
       
       
       
    <%--자동으로 post방식으로 현재 요청한 주소의 post방식으로 넘어간다.--%>
      <%-- <form:form method="post" action="form2" modelAttribute="member">
        <div class="form-group">
          <label for="mtype">Type</label>
         <form:select path="mtype" items="${typeList}" class="form-control"/>
        </div>
        
        <div class="form-group">
          <label for="mjob">Job</label>
         <form:select path="mjob" class="form-control">
         	<option value="">----선택하세요----</option>
         	<form:options items="${jobList}"/><!-- member의 mid의 기본값과, mjob에 있는 selected도 붙여준다. -->
         </form:select>
        </div>
        
        <div class="form-group">
          <label for="mcity">City</label><!-- for은 id값 path에 넣으면 아이디 자동생성 -->
          <!-- path="mcity"는 form태그의 modelAttribute = "member"에서 온 값이다. -->
          <form:select path="mcity" items="${cityList}" itemValue="code" itemLabel="label" class="form-control"/>
        </div>
        
        <button type="submit" class="btn btn-primary btn-sm">제출</button>
      </form:form> --%>
      
      
      
   </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>