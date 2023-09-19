package com.fkssm02.ch02;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Ch202 {

	public static void main(String[] args) throws IOException {
		String FILE = "mybatis-config.xml";
		InputStream resources = Resources.getResourceAsStream(FILE);
		// Properties proerty = new Properties();
		// proerty.setProperty("password", "rootroot");
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(resources);
		sqlsessionFactory.getConfiguration();
		SqlSession sqlSession = sqlsessionFactory.openSession();

		 selectTest(sqlSession);

		// insertTest(sqlSession);

		//updateTest(sqlSession);

	}

	public static void insertTest(SqlSession sqlSession) {
		// interface of news mapper should be with NewsMapper.xml

		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);
		News news = new News();
		news.setContent("crecate from mapper2");
		news.setTitle("mapper2");
		newsMapper.saveNews(news);
		System.out.println(news.getId());
		sqlSession.commit();
		sqlSession.close();

	}

	public static void updateTest(SqlSession sqlSession) {
		// interface of news mapper should be with NewsMapper.xml

		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);
		News news = new News();
		news.setContent("update news" + System.currentTimeMillis());
		news.setTitle("mapper2");
		news.setId(20);
		newsMapper.updateNews(news);
		sqlSession.commit();
		sqlSession.close();

	}

	public static void selectTest(SqlSession sqlSession) {
		// interface of news mapper should be with NewsMapper.xml

		// create object of mapper
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		// use mapper to operation
		List<News> listNews = new ArrayList<>();

		// listNews = newsMapper.selectAll();

		// listNews = newsMapper.selectAll();
		
		News news = newsMapper.selectBytable("news_inf","10");

//        for(News news:listNews) {
//        	System.out.println(news);
//        }
		sqlSession.commit();
		sqlSession.close();
	}

}
