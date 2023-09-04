package com.atggweb.ch01;

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ch101 implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		//取得web.xml这个servlet的初始化配置参数
		Enumeration<String> enumeratio = config.getInitParameterNames();
		while(enumeratio.hasMoreElements()) {
			System.out.println(enumeratio.nextElement());
			//System.out.println(config.getInitParameter(enumeratio.nextElement()));
		}
		
		System.out.println(config.getInitParameter("username"));
		
		//get ServletContect object.
	    //ServletContext servletContext = config.getServletContext();
	    //get applicaiton initial parameter ,same as get param from servlet
	   // System.out.println(servletContext.getInitParameter("appname"));
	    
	    //get application name
	    Calendar  calendar  = Calendar.getInstance();
	    
	   // System.out.println(servletContext.getContextPath());
	    

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get querystring hello(get or post)
		
		System.out.println(req.getParameter("hello"));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
		
		requestDispatcher.forward(req, res);
		
	

	}

}
