package tws.ch03;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch03/login")
public class DispatcherServlet extends HttpServlet {
	
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//System.out.println(DispatcherServlet.class.getName());
		ServletContext context = getServletConfig().getServletContext();
		context.getInitParameter(getServletInfo());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String successUrl="/ch03/hello.jsp";
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
	
		req.setAttribute("userName", userName);
		req.setAttribute("password", password);
		
		
		//forward to success.html
		req.getRequestDispatcher(successUrl).forward(req, resp);
		
		
		
	}

}
