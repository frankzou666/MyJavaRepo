package com.fkssm02.ch03;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NewsMapper {
	
	
	//insert will return 1 
	public int  saveNews(News news);
	
	public void updateNews(News news);
	
	public List<NewA> selectAll();
	
	public News selectById(@Param("strId")String strId);
	
	public List<News> selectByIdByCallable(@Param("strId")String strId);
	
	public News selectBytable(@Param("tableName")String tableName,@Param("strId")String strId);


}
