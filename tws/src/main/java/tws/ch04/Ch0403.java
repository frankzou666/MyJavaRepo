package tws.ch04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@WebServlet("/ch0403")
public class Ch0403 extends HttpServlet {
	

	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String exceptionCode;
		  PrintWriter out = resp.getWriter();
		  ComboPooledDataSource dataSource = (ComboPooledDataSource)getServletContext().getAttribute("dataSource");
		  try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement("select user_id from m_user;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				out.println(rs.getString(1));
			}
			connection.close();
			
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  
		  out.close();
	    
		
		  
		  
		  
		  
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
