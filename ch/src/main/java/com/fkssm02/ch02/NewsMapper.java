package com.fkssm02.ch02;

import java.util.List;

public interface NewsMapper {
	
	public void saveNews(News news);
	
	public void updateNews(Integer id);
	
	public List<News> selectAll();

}
