<%@ page contentType="text/html; charset=UTF-8"%>

<%
	//rootContext를 동적으로 얻어오는 법
	//System.out.println(request.getContextPath());
	//System.out.println(request.getServletContext().getContextPath());
	//System.out.println(application.getContextPath());
	response.sendRedirect(application.getContextPath() + "/ch01/content");
%>
