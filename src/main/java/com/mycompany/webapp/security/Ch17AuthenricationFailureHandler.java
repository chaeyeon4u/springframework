package com.mycompany.webapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

//@Component //-> dipatcher 가 관리함, 디스패쳐에서 만들면 루트에서 못씀 , 루트에서 bean오르 직접 관리객체로 만든다
public class Ch17AuthenricationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
   private static final Logger logger = LoggerFactory.getLogger(Ch17AuthenricationFailureHandler.class);

   @Override
   public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
         AuthenticationException exception) throws IOException, ServletException {
      logger.info("실행");
      
      super.onAuthenticationFailure(request, response, exception);
      
   }

}