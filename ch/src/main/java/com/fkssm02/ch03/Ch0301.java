package com.fkssm02.ch03;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fkssm02.ch03.News;
import com.fkssm02.ch03.NewsMapper;

public class Ch0301 {
	
	
	public static void main(String[] args) throws IOException {
		String FILE = "mybatis-config.xml";
		InputStream resources = Resources.getResourceAsStream(FILE);
		// Properties proerty = new Properties();
		// proerty.setProperty("password", "rootroot");
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(resources);
		sqlsessionFactory.getConfiguration();
		SqlSession sqlSession = sqlsessionFactory.openSession();

		 selectTest(sqlSession);

	}
	
	

	public static void selectTest(SqlSession sqlSession) {
		// interface of news mapper should be with NewsMapper.xml

		// create object of mapper
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		// use mapper to operation
		List<News> listNews = new ArrayList<>();
		
		listNews = newsMapper.selectByIdByCallable("5");
		for(News news:listNews) {
			System.out.println(news);
			
		}

        sqlSession.commit();
		sqlSession.close();
	}

}
