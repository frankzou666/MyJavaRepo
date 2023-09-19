package com.fkssm02.ch02;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NewsMapper {
	
	
	//insert will return 1 
	public int  saveNews(News news);
	
	public void updateNews(News news);
	
	public List<News> selectAll();
	
	public News selectById(@Param("strId")String strId);
	
	public News selectBytable(@Param("tableName")String tableName,@Param("strId")String strId);


}
