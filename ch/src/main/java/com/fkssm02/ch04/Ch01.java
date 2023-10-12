package com.fkssm02.ch04;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Ch01 {
	
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		MybatisSqlSessionFactory mybatisSqlSessionFactory = (MybatisSqlSessionFactory)ctx.getBean("mybatisSqlSessionFactory");
		SqlSession sqlSession = mybatisSqlSessionFactory.getSqlSession();
		
		PersonMapper personMapper = sqlSession.getMapper(com.fkssm02.ch04.PersonMapper.class);
		Person person = personMapper.getPersonById(3);
		System.out.println(person);
		
		sqlSession.commit();
		sqlSession.close();
		
				
		
	}

}
