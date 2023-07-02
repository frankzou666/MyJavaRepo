package ff.ch13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ch1301 {

	public static void main(String[] args) throws Exception {
		 // TODO Auto-generated method stub
		 
		 
		
		 String MYSQL_JDBC_URL = "jdbc:mysql://192.168.1.41:3307/app?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
		 String MYSQL_USER = "app";
		 String MYSQL_PWD = "app123456";
		 
		 // load mysql driver 8.0
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 //get connection 
		 Connection conn = DriverManager.getConnection(MYSQL_JDBC_URL, MYSQL_USER, MYSQL_PWD);
		 //get 
		 PreparedStatement prepareStatement = conn.prepareStatement("select * from news_inf");
		 //execute 
		 prepareStatement.execute();
		 //get result
		 ResultSet rs = prepareStatement.getResultSet();
		 while(rs.next()) {
			 // row record ,columne from 1 to last.
			 System.out.println(rs.getString(2));
		 }

	}

}
