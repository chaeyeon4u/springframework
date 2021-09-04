package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch09/content";
	}
	
	@PostMapping("/fileupload")
	public String fileUpload(String title, String desc, MultipartFile attach) throws Exception{
		logger.info("실행");
		
		//문자파트 이름 읽기
		logger.info("title : "+title);
		logger.info("desc : "+desc);
		
		//파일 파트 이름 읽기
		logger.info("file originalname : "+attach.getOriginalFilename());
		logger.info("file contenttype : "+attach.getContentType());
		logger.info("file size : "+attach.getSize());
		
		//파일 파트 데이터를 서버의 파일로 저장
		String savedname = new Date().getTime() + "-" +attach.getOriginalFilename();
		File file = new File("C:/hyundai_it&e/IDE/upload_files/"+savedname);
		attach.transferTo(file);
		
		return "redirect:/ch09/content";
	}
	
	@PostMapping(value="/fileuploadAjax", produces="application/json; charset=UTF-8")
	public String fileuploadAjax(String title, String desc, MultipartFile attach) throws Exception{
		logger.info("실행");
		
		//문자파트 이름 읽기
		logger.info("title : "+title);
		logger.info("desc : "+desc);
		
		//파일 파트 이름 읽기
		logger.info("file originalname : "+attach.getOriginalFilename());//저장해야함
		logger.info("file contenttype : "+attach.getContentType());//저장해야함
		logger.info("file size : "+attach.getSize());
		
		//파일 파트 데이터를 서버의 파일로 저장
		String savedname = new Date().getTime() + "-" +attach.getOriginalFilename();
		File file = new File("C:/hyundai_it&e/IDE/upload_files/"+savedname);
		attach.transferTo(file);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("savedname", "savedname");
		String json = jsonObject.toString();
		
		return json;
	}
	
	//파일 크기가 커지면 toByteArray()에서 리턴하는 배열의 길이 문제좋지않다.
	//jpg로 고정되서 좋지 않다.
	/*@GetMapping(value="/filedownload", produces="image/jpeg")
	@ResponseBody
	public byte[] filedownload(String savedname) throws Exception{
		String filePath = "C:/hyundai_it&e/IDE/upload_files/"+savedname;
		InputStream is = new FileInputStream(filePath);
		byte[] data = IOUtils.toByteArray(is);
		
		return data;
	}*/
	
	@GetMapping(value="/filedownload")
	@ResponseBody
	public void filedownload(int fileNo, 
							HttpServletResponse response,  
							@RequestHeader("User-Agent") String userAgent) throws Exception{
		String contentType = "image/jpeg";//기본적으로 다운로드는 그냥 브라우저에서 열림
		String originalFilename="왜 안보여.jpg";
		String savedName = "1630653244970-photo2.jpg";//db에서 불러왔다 가정
		
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
		FileCopyUtils.copy(is, os);
		is.close();
		os.flush();
		os.close();
	}
}
