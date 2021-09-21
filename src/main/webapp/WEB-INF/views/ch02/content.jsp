<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!-- postman -> 프론트앤드/백앤드 테스트시 사용, 
	 TCP/IP Monitor -> Browser-> Server(8080포트)로 요청를 전달할 때 Browser의 요청을 받아 (8090포트에서)출력한 후 Server로 전달, 
	 				   server(8080포트)->Browser로 응답를 전달할 때 Server의 응답을 받아 (8090포트에서)출력한 후 Browser로 전달-->
<div class="card m-2">
	<div class="card-header">
		Controller/RequestMapping
	</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">
				요청 방식별 메소드 매핑
			</div>
			<div class="card-body">
				<button class="btn btn-info btn-sm" onclick="requestGet()">GET 방식</button>
				<button class="btn btn-info btn-sm" onclick="requestPost()">POST 방식</button>
				<button class="btn btn-info btn-sm" onclick="requestPut()">PUT 방식</button>
				<button class="btn btn-info btn-sm" onclick="requestDelete()">DELETE 방식</button>
			</div>
			<script>
				function requestGet(){
					$.ajax({
						url: "${pageContext.request.contextPath}/ch02/method",
						method: "GET"
					})
					.done((data) => {});
				}
				
				function requestPost(){
					$.ajax({
						url: "${pageContext.request.contextPath}/ch02/method",
						method: "POST"
					})
					.done((data) => {});
				}

				function requestPut(){
					$.ajax({
						url: "${pageContext.request.contextPath}/ch02/method",
						method: "PUT"
					})
					.done((data) => {});
				}

				function requestDelete(){
					$.ajax({
						url: "${pageContext.request.contextPath}/ch02/method",
						method: "DELETE"
					})
					.done((data) => {});
				}
				</script>
				
				<!-------------------------------- ModelAndView 객체로 return------------------------------------->
				<div class="card-header">
					ModelAndVIew로 리턴!!
				</div>
				<div class="card-body">
					<!-- a 태그는 GET방식으로만 요청 가능.. form은 GET, POST 방식 둘다 가능 -->
					<a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/ch02/modelandview"> modelandview 요청!! </a>
				</div>
				<!---------------------------------- Redirect 처리 방식 ----------------------------------------------->
				<div class="card-header">
					Redirect
				</div>
				<div class="card-body">
					<!-- form은 GET, POST만 올 수 있다! -->
					<!-- <form method="POST" action="/ch02/login1"> --><!-- %붙이면 jsp주석으로, 클라이언트(브라우저에)에 주석이 안보인다 -->
					<form method="POST" action="${pageContext.request.contextPath}/ch02/login2">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email address</label>
					    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
					    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					    <input type="password" class="form-control" id="exampleInputPassword1">
					  </div>
					  <div class="form-group form-check">
					    <input type="checkbox" class="form-check-input" id="exampleCheck1">
					    <label class="form-check-label" for="exampleCheck1">Check me out</label>
					  </div>
					  <button type="submit" class="btn btn-primary btn-sm">Login</button>
					</form>
					<hr/>
					
					<!-- 상대경로 "/"로 시작하지 않는다.-->
					<a class="btn btn-info btn-sm" href="boardlist">게시물 목록//링크로 요청 : GET방식!</a>
					<a class="btn btn-info btn-sm" href="boardwriteform">게시물 작성</a>
				</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>