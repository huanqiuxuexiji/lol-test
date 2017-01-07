package com.java2.com.filter;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.java2.web.service.UserService;



public class AuthenticationFilter implements Filter{
	
	WebApplicationContext context;
	
	FilterConfig  fc;
	
	public void init(FilterConfig filterConfig){
		fc = filterConfig;
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(fc.getServletContext());
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String basicCreditial  = httpRequest.getHeader("Authorization");
		
		String[] array = basicCreditial.split(" ");
		String creditial = new String(Base64.getDecoder().decode(array[1]));
		String[] creditialArray = creditial.split(":");
		String userName = creditialArray[0];
		String password = creditialArray[1];
		
		UserService us = (UserService) context.getBean("userServicelmp");
				
		boolean passAuth = us.isUserCreditial(userName, password);
		if(passAuth){
			chain.doFilter(request, response);
		}else{
//			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendError(401, "User is error");
		}
	}

	

}
