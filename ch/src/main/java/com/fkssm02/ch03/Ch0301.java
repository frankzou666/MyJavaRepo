package com.fkssm02.ch03;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mchange.v2.codegen.bean.Property;

public class Ch0301 implements Runnable {
	
	
	SqlSession sqlSession;
	
	public Ch0301() {
		
	}
	
    public Ch0301(SqlSession sqlSession) {
    	this.sqlSession=sqlSession;
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String FILE = "mybatis-config.xml";
		InputStream resources = Resources.getResourceAsStream(FILE);
		// Properties proerty = new Properties();
		// proerty.setProperty("password", "rootroot");
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(resources);
		sqlsessionFactory.getConfiguration();
		 //sqlSession = sqlsessionFactory.openSession();
		
		
		  Thread t1 = new Thread(new Ch0301(sqlsessionFactory.openSession()));
		  t1.start();
		  Thread.sleep(1000);
		  Thread t2 = new Thread(new Ch0301(sqlsessionFactory.openSession()));
		  
		  t2.start();
		  Thread t3 = new Thread(new Ch0301(sqlsessionFactory.openSession()));
		  t3.start();
		  t3.join();
		  t1.join();
		  t2.join();
		  
		 
		
		
		

		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	    selectTest(this.sqlSession);
	}
	

	public static void selectTest(SqlSession sqlSession) {
		// interface of news mapper should be with NewsMapper.xml

		// create object of mapper
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		// use mapper to operation
		List<News> listNews = new ArrayList<>();
		
		//listNews = newsMapper.selectByIdByCallable("5");
		//for(News news:listNews) {
		//	System.out.println(news);
			
		//}
		
		String[] ids = new String[5];
		Page page = new Page();
		ids[0]="1";
		ids[1]="2";
		
		//执行两次查询，由于有一级cache,实际上只执行了一次查询
		newsMapper.selectByIds(ids);
		
		//为了不要查到脏数据，手动clearCache(),日志输出了两次查询
		//sqlSession.clearCache();
		//List<News> newsList2 = newsMapper.selectByIds(ids);
		sqlSession.commit(); 
		sqlSession.close();
		

	}
	
	
	public static void saveTest(SqlSession sqlSession) {
		// interface of news mapper should be with NewsMapper.xml

		// create object of mapper
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);
 
        
        
		News news = new News();
		news.setTitle("hello");
		newsMapper.saveNews(news);
		
        sqlSession.commit();
		sqlSession.close();
	}



	

}
