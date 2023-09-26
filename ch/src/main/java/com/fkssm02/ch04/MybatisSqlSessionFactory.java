package com.fkssm02.ch04;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	
	public SqlSessionFactory sqlSessionFactory;
	public SqlSession  sqlSession;
	public MybatisSqlSessionFactory(String FILE) throws IOException{
		//String FILE = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(FILE);

		// create SQLSessionFactory
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		this.sqlSession = this.sqlSessionFactory.openSession();

	}
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = this.sqlSessionFactory.openSession();
	}
	
	
	
	

	
	

}
