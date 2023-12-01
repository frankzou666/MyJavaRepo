package tws.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.log.Slf4JLogger;



public class ContextListener implements ServletContextListener {


   
	private ComboPooledDataSource dataSource = null;
	

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 在应用程序正常关闭时，连接池也正常关闭吧

		if (dataSource != null) {
			dataSource.close();
		}

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		// 得到ServletConntext对像
		ServletContext sc = sce.getServletContext();
		BufferedReader bf = null;
		Integer counter = 0;
		try {
			bf = new BufferedReader(new InputStreamReader(sc.getResourceAsStream("counter.txt")));
			counter = Integer.parseInt(bf.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// 放到context
		sc.setAttribute("counter", counter);

		
		//创建c3p0,并且放到servletContext中
		try {
			getDatasource(sc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dataSource != null) {
			sc.setAttribute("dataSource", dataSource);
		}

	}

	public void getDatasource(ServletContext sc) throws IOException {
		// 初始化c3p0数据库连接池
		InputStreamReader is = new InputStreamReader(sc.getResourceAsStream("/WEB-INF/db.config"));
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is!=null) {
				is.close();
			}
		}
		

		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass((String) properties.get("DriverClass"));
			dataSource.setJdbcUrl((String) properties.get("JdbcUrl"));
			dataSource.setUser((String) properties.get("User"));
			dataSource.setPassword((String) properties.get("Password"));
			dataSource.setInitialPoolSize(Integer.parseInt((String) properties.get("InitialPoolSize")));
			dataSource.setMinPoolSize(Integer.parseInt((String) properties.get("MinPoolSize")));
			dataSource.setMaxPoolSize(Integer.parseInt((String) properties.get("MaxPoolSize")));
			Connection connection = dataSource.getConnection();
			connection.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
