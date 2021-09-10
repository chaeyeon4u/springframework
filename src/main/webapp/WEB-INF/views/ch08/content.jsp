<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Session Support
	</div>
	<div class="card-body">
		<div class="card">
			<div class="card-header">
				세션 원리 : JESSIONID 쿠키
			</div>
			<div class="card-body">
				<p>서버 : 세션 객체 생성->JESSION 쿠키 발생</p>
				<p>브라우저 : JESSION 쿠키 전송 -> 세션 객체 찾음 -> 세션 객체 이용 </p>
				<a href="javascript:saveData()" class="btn btn-info btn-sm">세션에 데이터 저장</a>
				<a href="javascript:readData()" class="btn btn-info btn-sm">세션에 데이터 읽기</a>
			</div>
		</div>
		<script>
			function saveData(){
				$.ajax({
					url: "saveData", //상대경로
					data: {name: "홍길동"}
				}).done((data) => {
					console.log(data);//객체가 파싱되어 온다.
				});
			}
			
			function readData(){
				$.ajax({
					url: "readData", //상대경로
					data: {name: "홍길동"}
				}).done((data) => {
					console.log(data);//객체가 파싱되어 온다.//name: "홍길동"
					console.log(data.name);
				});
			}
		</script>
		
		<div class="card">
			<div class="card-header">
				form을 통한 login 처리
			</div>
			<div class="card-body">
				<c:if test="${sessionMid == null}">
					<a href="login" class="btn btn-info btn-sm">로그인 폼 요청</a>
				</c:if>
				<c:if test="${sessionMid != null}">
					<a href="logout" class="btn btn-info btn-sm">로그아웃</a>
				</c:if>
			</div>
		</div>
		
		<div class="card">
			<div class="card-header">
				@SessionAttribute를 이용한 다단계 입력 처리
			</div>
			<div class="card-body">
				<a href="inputStep1" class="btn btn-info btn-sm">1단계 입력</a>
			</div>
		</div>
		
		
		<div class="card">
			<div class="card-header">
				ajax을 통한 login 처리
			</div>
			<div class="card-body">
					<form>
			            <div class="input-group">
			               <div class="input-group-prepend"><span class="input-group-text">mid</span></div>
			               <input id="mid" type="text" name="mid" class="form-control" value="spring">
			            	<span id="mid-error" classs="error"></span>
			            </div>
			            <div class="input-group">
			               <div class="input-group-prepend"><span class="input-group-text">mpassword</span></div>
			               <input id="mpassword" type="password" name="mpassword" class="form-control" value="12345">
			               <span id="mpassword-error" classs="error"></span>
			            </div>
		         	</form>
					<div>
					
						<c:if test="${sessionMid == null}">
							<a href="javascript:login()" class="btn btn-info btn-sm">로그인</a>
						</c:if>
						<c:if test="${sessionMid != null}">
							<a href="javascript:logout()" class="btn btn-info btn-sm">로그아웃</a>
						</c:if>
					</div>
			</div>
		</div>
		<script>
					function login() {
						console.log("aa");
						let mid = $("#mid").val();
						let mpassword=$("#mpassword").val();
						$.ajax({
							url: "loginAjax",
							data: {mid, mpassword},//변수명과 데이터가 같으면 생략가능
							method: "post"
						}).done((data) => {
							//data = {result:"success"}
							//data = {result: "wrongMid"}
							//data = {result: "wrongMpassword"}
							
							const midError = $("#mid-error");
							const mpasswordError =  $("#mpassword-error");
							mpasswordError.html("");
							midError.html("");
							
							if(data.result ==="success" ){
								window.location.reload();
							}else if(data.result ==="wrongMid" ){
								midError.html("아이디가 잘못됨");
							}else if(data.result ==="wrongMpassword" ){
								mpasswordError.html("비밀번호가 잘못됨");
							}

						});
					}
					
					function logout() {
						$.ajax({
							url:"logoutAjax"
						}).done((data)=>{
							//data = {result:"success"}
							
							window.location.reload();
						})
					}
		</script>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>