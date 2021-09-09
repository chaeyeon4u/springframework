package com.mycompany.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mycompany.webapp.dto.Ch08InputForm;

@Controller
@RequestMapping("/ch08")
@SessionAttributes({"inputForm"})
public class Ch08Controller {
   
   private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);
   
   @RequestMapping("/content")
   public String content() {
	  logger.info("실행");
      return "ch08/content";
   }
   
   @GetMapping(value="/saveData", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public String saveData(String name, HttpServletRequest request, HttpSession session) {
      logger.info("실행");
      logger.info("name:"+name);
      
      //HttpSession session = request.getSession();
      session.setAttribute("name", name);
      
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("result", "success");
      String json = jsonObject.toString(); //{"result":"success"}
      return json;
   }

   @GetMapping(value="/readData", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public String readData(HttpSession session, @SessionAttribute String name) {
      logger.info("실행");
      //session이 get할때 어떤 타입을 가져올지 모르니까 object로 가져온다.
      
      //방법1
      //String name = (String) session.getAttribute("name");
      
      logger.info("name : "+ name);
      
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("name", name);
      String json = jsonObject.toString(); // {"name":"홍길동"}
      return json;
   }
   
   @GetMapping("/login")
   public String loginForm() {
      logger.info("실행");
      return "ch08/loginForm";
   }
   
   @PostMapping("/login")
   public String login(String mid, String mpassword, HttpSession session) {
      if(mid.equals("spring")&&mpassword.equals("12345")) {
         session.setAttribute("sessionMid", mid);
      }
      return "redirect:/ch08/content";
   }
   
   @GetMapping("/logout")
   public String logout(HttpSession session) {
      logger.info("실행");
      
      //방법1 . 직접 mid를 찾아서 지우기
      session.removeAttribute("sessionMid");
      
      //방법2 . session 객체 지우기(session안에 모든 데이터가 날라간다.)
      //session.invalidate();
      
      return "redirect:/ch08/content";
   }
   
   
   @PostMapping(value="/loginAjax", produces="application/json; charset=UTF-8")
   @ResponseBody
   public String loginAjax(String mid, String mpassword, HttpSession session) {
      logger.info("실행");
      String result = "";
      
      if(!mid.equals("spring")) {
         result = "wrongMid";
      } else if(!mpassword.equals("12345")) {
         result = "wrongMpassword";
      } else {
         result = "success";
         session.setAttribute("sessionMid", mid);
      }
      
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("result", result);
      String json = jsonObject.toString();
      return json;
   }
   
   //
	/* @GetMapping(value="/logoutAjax", produces="application/json; charset=UTF-8")
	 @ResponseBody
	 public String logoutAjax(String mid, String mpassword, HttpSession session) {
	  logger.info("실행");
	  String result = "";
	  
	  //session.invalidate();
	  session.removeAttribute("sessionMid");
	  
	  JSONObject jsonObject = new JSONObject();
	  jsonObject.put("result", "success");
	  String json = jsonObject.toString();
	  return json;
	 }
	 */
   
   	@GetMapping("/logoutAjax")
	 public void logoutAjax(String mid, String mpassword, HttpSession session, HttpServletResponse response) throws IOException{
	  logger.info("실행");
	  String result = "";
	  
	  session.invalidate();//세션 지우고, 새로만든다. 그리고 jsession쿠키 만들어 헤더에 전송 -> 비동기로 처리해서 문제가 된다
	  //session.removeAttribute("sessionMid");
	  
	  response.setContentType("application/json charset=UTF-8");//json의 헤더
	  PrintWriter pw = response.getWriter();
	  
	  JSONObject jsonObject = new JSONObject();
	  jsonObject.put("result", "success");
	  String json = jsonObject.toString();
	  
	  pw.println(json);//응답HTTP의 메모리에있다, body에 들어간다
	  //flush하면 브라우저로 전송//flush하지 않아도 Dispatcher Servlet이 flush, close 해서 브라우저로 전송함
	  //우리가 flush()하면, 문제점 : session이 만들어지기 이전에 브라우저로 보내버려서 오류남
	  //flush안하면 session만들어진 이후 Dispatcher가 알아서 자동 flush, close해줌
	  //아우 어려워
	  //pw.flush();
	  
	  /* pw.println(json);//용량 클때 여러번 나눠서 보내면 효율적
		pw.flush();*/
	  
	  //pw.close();
	}
   
   //@SessionAttributes({"inputForm"})로 등록해놔서 session 단위 저장
   //세션에 inputForm 이름이 존재하지 않을 경우 딱 한번 실행!
   @ModelAttribute("inputForm")
   public Ch08InputForm getInputForm() {//이 메서드는 요청할 때마다 실행된다
	   Ch08InputForm inputForm = new Ch08InputForm();
	   return inputForm;
   }
   
   @GetMapping("/inputStep1")
   public String inputStep1( @ModelAttribute("inputForm") Ch08InputForm inputForm) {
	   logger.info("실행");
	   return "ch08/inputStep1";
   }
   
   @PostMapping("/inputStep2")
   public String inputStep2( @ModelAttribute("inputForm") Ch08InputForm inputForm) {
	   logger.info("실행");
	   logger.info("data1 : "+inputForm.getData1());
	   logger.info("data2 : "+inputForm.getData2());
	   logger.info("data3 : "+inputForm.getData3());
	   logger.info("data4 : "+inputForm.getData4());

	   return "ch08/inputStep2";
   }
   
   @PostMapping("/inputDone")
   public String inputDone( @ModelAttribute("inputForm") Ch08InputForm inputForm, SessionStatus sessionStatus) {
	   logger.info("실행");
	   logger.info("data1 : "+inputForm.getData1());
	   logger.info("data2 : "+inputForm.getData2());
	   logger.info("data3 : "+inputForm.getData3());
	   logger.info("data4 : "+inputForm.getData4());
	   //처리 내용
	   //session에 저장되어 있는 inputForm을 제거
	   sessionStatus.setComplete();//@SessionAttributes({"inputForm"})얘가 사라진다.
	   //session.removeAttribute("")-> 이런식으로 지우면 안된다.
	   
	   return "redirect:/ch08/content";
   }
}