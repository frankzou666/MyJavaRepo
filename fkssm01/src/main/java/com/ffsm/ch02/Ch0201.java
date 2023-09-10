package com.ffsm.ch02;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Ch0201 {
	
	public static void main(String[] args) throws IOException {
		 String FILE = "mybatis-config.xml";
		 String classpath = System. getProperty("java.class.path"); 
		 System.out.println(classpath);
		 System.out.println(new File(FILE).exists());
		 
		//create Inputstream
		  InputStream is = Resources.getResourceAsStream(FILE);
		 
		//create SQLSessionFactory
		  SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 
		// create sqlSession
		
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 
		//invoke test mthod
		 
		 insertTest(sqlSession);
		
		
	}
	
	public static void insertTest(SqlSession sqlSession) {
		
		Map<String,String > map=new HashMap<String,String>();
		//parameter map
		map.put("title", "good");
		map.put("content","china");
		sqlSession.insert("com.ffsm.ch02.NewsMapper.saveNews",map);
		sqlSession.commit();
		
	}

}
