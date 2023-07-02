package ffssm02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.util.*;


public class Ssm02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 配置字符串
		String resource = "mybatis-config.xml";
		// inputstream
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = ssf.openSession();
		try {
		News news1 = new News();
		news1.setNews_title("hahaha");
		news1.setNews_content("content1");
		NewsMapper newsMapper= sqlSession.getMapper(NewsMapper.class);
		//newsMapper.saveNews(news1);
		
		sqlSession.commit();
		News new2 = newsMapper.selectOneNews(1);
		//get all news
		List<News> new3 = newsMapper.selectAllNews1();
		System.out.println("finish");
		} catch(Exception e) {
			;
		} finally {
			sqlSession.close();
		}
		//updateTest(ssqlSession);

	}
	// insert test
	public static void insertTest(SqlSession sqlSession) {
		HashMap hs = new HashMap<String,String>();
		hs.put("title", "我是2");
		hs.put("content", String.valueOf(System.currentTimeMillis()));
		int cnt = sqlSession.insert("NewsMapper.saveNews",hs);
		sqlSession.commit();
		sqlSession.close();
		System.out.println("insert: "+String.valueOf(cnt));
	}
	// update test
	public static void updateTest(SqlSession sqlSession) {
		HashMap hs = new HashMap<String,String>();
		hs.put("id", "1");
		hs.put("title", "我是updat1");
		hs.put("content", String.valueOf(System.currentTimeMillis()));
		int cnt = sqlSession.update("NewsMapper.updateNews",hs);
		sqlSession.commit();
		sqlSession.close();
		System.out.println("update: "+String.valueOf(cnt));
	}
	
	// select one test
	public static void selectOneTest(SqlSession sqlSession) {
			HashMap hs = new HashMap<String,String>();
			hs.put("id", "2");
			News  news = sqlSession.selectOne("NewsMapper.selectOneNews",hs);
			sqlSession.commit();
			sqlSession.close();
			System.out.println(news.to_String());
	}

}
