package ffssm02;

import org.apache.ibatis.annotations.Select;
import java.util.*;

public interface NewsMapper {
   int  saveNews(News news);
   News selectOneNews(int id);
   
   @Select("select * from news_inf")
   List<News> selectAllNews1();
   
}
