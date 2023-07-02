package ffssm02;

public class News {
	private int news_info;
	private String news_title;
	private String news_content;
	
	public int getNews_info() {
		return news_info;
	}

	public void setNews_info(int news_info) {
		this.news_info = news_info;
	}

	public String getNews_title() {
		return news_title;
	}

	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}

	public String getNews_content() {
		return news_content;
	}

	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}

	public String to_String() {
		return news_content;
	}

}
