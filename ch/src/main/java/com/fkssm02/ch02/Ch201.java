package com.fkssm02.ch02;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Ch201 {

	public static void main(String[] args) throws IOException, InterruptedException {
		String FILE = "mybatis-config.xml";

		// create Inputstream
		InputStream is = Resources.getResourceAsStream(FILE);

		// create SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		// create sqlSession

		SqlSession sqlSession = sqlSessionFactory.openSession();

		// invoke test mthod
		selectOneTest(sqlSession);

	}

	public static void insertTest(SqlSession sqlSession) {

		Map<String, String> map = new HashMap<String, String>();
		// parameter map
		map.put("title", "good1");
		map.put("content", "china2");
		sqlSession.insert("com.ffsm.ch02.NewsMapper.saveNews", map);
		sqlSession.commit();
		sqlSession.close();

	}

	public static void updateTest(SqlSession sqlSession) {

		Map<String, String> map = new HashMap<String, String>();
		// parameter map
		map.put("id", "1");
		map.put("title", "newid");
		map.put("content", "china2");
		sqlSession.insert("com.ffsm.ch02.NewsMapper.updateNews", map);
		sqlSession.commit();
		sqlSession.close();

	}
	
	public static void selectOneTest(SqlSession sqlSession) {

		Map<String, String> map = new HashMap<String, String>();
		// parameter map
		map.put("id", "1");

		List<Map> resultMap = sqlSession.selectList("com.ffsm.ch02.NewsMapper.selectOneNews", map);
		System.out.print(resultMap);
		sqlSession.commit();
		sqlSession.close();

	}

}
