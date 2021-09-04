<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		FileUpload & FileDownload
	</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">
				Form 태그를 이용한 FileUpload
			</div>
			<div class="card-body">
				<form method="post" enctype="multipart/form-data" action="fileupload">
	               <div class="form-group">
	                  <label for="desc">File Title</label> 
	                  <input type="text" class="form-control" id="title" name="desc" placeholder="파일 제목">
	               </div>
	               <div class="form-group">
	                  <label for="desc">File Description</label> 
	                  <input type="text" class="form-control" id="desc" name="desc" placeholder="파일 설명">
	               </div>
	               <div class="form-group">
	                   <label for="attach">Example file input</label>
	                   <input type="file" class="form-control-file" id="attach" name="attach" />
	               </div>
	               <button class="btn btn-info btn-sm">form 파일 업로드</button>
	               <a href="javascript:fileupload()" class="btn btn-info btn-sm">AJAX 파일 업로드</a>
	            </form>
			</div>
			<script>
				function fileupload(){
					//입력된 정보 엳기
					const title = $("#title").val();
					const desc = $("#desc").val();
					//files[0] : 원래는 파일 하나만 선택가능 여러개 못함
					//multiple="multiple" -> 여러개 선택 가능
					// 하나만 선택하도록 [0]
					const attach = document.querySelector("#attach").files[0];//$("#attach")[0];
					console.log(attach);
					
					//Multipart/form-data
					const formData = new FormData();
					formData.append("title", title);
					formData.append("desc", desc);
					formData.append("attach", attach);
					
					//Ajax로 서버로 전송
					$.ajax({
						url: "fileuploadAjax",
						method: "post",//무저건 파일은 post
						data: formData,
						cache: false,
						processData: false,//false이면 fileData는 Binary데이터라 가공처리 하지말고 있는 그대로 전달한다.
						contentType: false//개별적으로 컨텐트 타입을 명시할거라 //true이면 전체의 타입을 정의
					}).done((data) => {
						console.log(data);
						if(data.result ==="success"){
							window.alert("파일 전송이 성공됨!");
						}
					});
				}
			</script>
			
			<div class="card">
				<div class="card-header">
					File Download
				</div>
				<div class="card-body">
					<!-- <a href="filedownload?savedname=1630651045533-photo1.jpg" class="btn btn-sm" > 파일 다운로드 </a> -->
					<a href="filedownload?fileNo=1" class="btn btn-info btn-sm" > 파일 다운로드 </a>
					<hr/>
					<img src="filedownload?fileNo=1" width="200px"/>
				</div>
			</div>
		</div>
	 </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>