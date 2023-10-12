package tws.ch04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Ch0402 extends HttpServlet {
	
	ServletConfig config =null;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		//把servetConfig给类的config
		this.config = config;
		System.out.println("init method...;");
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		//读取servlet的初始化参数
		PrintWriter out = resp.getWriter();
		ServletContext servletContext = getServletContext();
		/*
		 * out.println("<h1>hello ->"+req.getRemoteAddr()+"</h1>");
		 * out.println("<h1>username ->"+getServletConfig().getInitParameter("username")
		 * +"</h1>");
		 * 
		 * //获取所有的http请求header Enumeration eu = req.getHeaderNames();
		 * while(eu.hasMoreElements()) { String headerName = (String)eu.nextElement();
		 * out.println("<p>"+headerName+":"+req.getHeader(headerName)); }
		 */
		
		out.println("<h1>ContextPath ->"+ servletContext.getContextPath()+"</h1>");

		out.close();
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

}
