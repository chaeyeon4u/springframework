package com.mycompany.webapp.view;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class Ch12FileDownloadView extends AbstractView{
	private static final Logger logger = LoggerFactory.getLogger(Ch12FileDownloadView.class);

	@Override
	protected void renderMergedOutputModel(
			Map<String, Object> model, //request 범위에 저장되어있는 것을 가져올 수 있다.
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName = (String) model.get("fileName");//request에 값이 있기만 하면 가져올 수 있다.//Controller에서 저장
		String userAgent =  (String) model.get("userAgent");
		
		logger.info("실행");
		String contentType = request.getServletContext().getMimeType(fileName);
		String originalFilename= fileName;
		String savedName = fileName;//db에서 불러왔다 가정
		
		//응답 바디의 데이터의 형식 설정
		response.setContentType(contentType);
		
		// 브라우저별로 파일명 변환
		if(userAgent.contains("Trident") || userAgent.contains("MSIE")){
			//IE11 이하 버전의 경우
			originalFilename = URLEncoder.encode(originalFilename, "UTF-8");
		}else {
			//chrome, edge, safari
			originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		//크롬 브라우저에서 한글 파일명을 변환, 
		originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
		
		//파일 첨부로 다운로드하도록 설정(다운로드 파일에 저장)
		response.setHeader("Content-Disposition", "attachment; filename=\""+ originalFilename +"\"");
		
		//파일로부터 데이터를 읽는 입력스트림 생성
		String filePath = "C:/hyundai_it&e/IDE/upload_files/"+savedName;
		InputStream is = new FileInputStream(filePath);
		
		//응답 바디에 출력하는 출력스트림 열기
		OutputStream os = response.getOutputStream();
		
		//입력스트림 -> 출력스트림//메모리를 적게 사용한다
		//FileCopyUtils.copy(is, os);//저장하는 byte크기 사용불가
		
		byte[] data = new byte[1024];
		int readByteNum = -1;
		while(true) {
			readByteNum = is.read(data);
			if(readByteNum==-1) break;
			os.write(data, 0, readByteNum);
			os.flush();
		}
		
		is.close();
		os.close();
	}

	
}
