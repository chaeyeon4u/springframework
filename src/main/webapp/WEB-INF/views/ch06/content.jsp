<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
   <div class="card-header">
      Controller/Forward & Redirect
   </div>
   <div class="card-body">
      <a href="forward" class="btn btn-info btn-sm">JSP 포워드</a>
      <a href="redirect" class="btn btn-info btn-sm">홈으로 리다이렉트</a>
      <hr/>
      
      <p>AJAX 요청은 리다이렉트를 하면 안됨</p>
      <a href="javascript:ajax1()" class="btn btn-info btn-sm">AJAX 요청(HTML 조각 얻기)</a>
      <a href="javascript:ajax2()" class="btn btn-info btn-sm">AJAX 요청(JSON)</a>
      <a href="javascript:ajax3()" class="btn btn-info btn-sm">AJAX 요청(JSON)</a>
      <a href="javascript:ajax4()" class="btn btn-info btn-sm">AJAX 요청(redirect) - 리다이렉트 보내면 안된다</a>
      <div id="content" class="mt-2"></div>
      <script>

  		function ajax1() {
			console.log("ajax1() 실행");
			$.ajax({
				url:"getFragmentHtml"
			})
			.done((data) => {//성공하면 data에 응답 객체(fragment) 들어감
				console.log(data);//응답 body에 있는 객체
				$("#content").html(data);
			});
		}
		
		function ajax2() {
			console.log("ajax2() 실행");
			$.ajax({
				url:"getJson1"
			})
			.done((data) => {
				$("#content").html(
					"<img src='${pageContext.request.contextPath}/resources/images/" + 
					data.fileName + "' width='200px'/>");
			});
		}
         
         function ajax3(){
             console.log("ajax3() 실행");
             $.ajax({
                url:"getJson2"
             }).done((data)=>{
                $("#content").html("<img src='${pageContext.request.contextPath}/resources/images/"+ data.fileName+"' width='200px'/>");
             });
          }
         
         function ajax4(){
             console.log("ajax4() 실행");
             $.ajax({
                url:"getJson3"
             }).done((data)=>{
                $("#content").html("<img src='${pageContext.request.contextPath}/resources/images/"+ data.fileName+"' width='200px'/>");
             });
          }
      </script>
   </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>