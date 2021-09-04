<%@ page contentType="text/html; charset=UTF-8" %>


<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Login Form
	</div>
	<div class="card-body">
		<form method="post" action="login">
            <div class="input-group">
               <div class="input-group-prepend"><span class="input-group-text">mid</span></div>
               <input type="text" name="mid" class="form-control" value="spring">
            </div>
            <div class="input-group">
               <div class="input-group-prepend"><span class="input-group-text">mpassword</span></div>
               <input type="password" name="mpassword" class="form-control" value="12345">
            </div>
            <div>
            	<input class="btn btn-info" type="submit" value="로그인"/>
            	<input class="btn btn-info" type="reset" value="다시작성"/>
           	 	<a class="btn btn-info" href="">취소</a>
            </div>
         </form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>