package tws.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch0402")
public class Ch0401 extends HttpServlet {
	
	ServletConfig config =null;
	Integer initVar =0;
	Integer serviceVar =0;
	Integer destoryVar=0;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		initVar = initVar +1;
		System.out.println("initVar:"+initVar);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		// no cache
		resp.setHeader("Cache-Control", "no-cache");
		Integer counter = (Integer) sc.getAttribute("counter");
		if (counter != null) {
			counter = counter +1;
			sc.setAttribute("counter",counter);
		}
		PrintWriter out = resp.getWriter();
		out.println("<p>"+counter+"</p>");
		out.close();
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		destoryVar = destoryVar +1;
		System.out.println("destoryVar:"+destoryVar);
	}

	
}
