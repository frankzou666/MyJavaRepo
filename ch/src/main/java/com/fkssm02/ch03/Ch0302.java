package com.fkssm02.ch03;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class Ch0302 {
	
	
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
	
	

	public static void selectTest(SqlSession sqlSession)  {
		// interface of news mapper should be with NewsMapper.xml

		// create object of mapper
		PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

		// use mapper to operation
		//listNews = new ArrayList<>();
		Person person =null;
		
		person = personMapper.getPersonById(1);
		/*
		 * for(News news:listNews) { System.out.println(news);
		 * 
		 * }
		 */
        
		System.out.println(person.getName());
		System.out.println(person.getAddress());
        sqlSession.commit();
		sqlSession.close();
	}

}
