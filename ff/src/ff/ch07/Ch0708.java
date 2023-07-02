package ff.ch07;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Ch0708 {
	public static void displayCountry() {
		// 显示所有国家代码
		Locale[] locale = Locale.getAvailableLocales();
		for(int i=0;i<locale.length;i++) {
			System.out.println(locale[i].getCountry()+"="+locale[i].getLanguage());
		}
		
	}
	public static void main(String[] args){
		// 得到系统当前语言设置
		Locale locale = Locale.getDefault(Locale.Category.FORMAT);
		//加载资源文件
		ResourceBundle rb = ResourceBundle.getBundle("mess", locale);
		rb.getLocale();
		//System.out.println(rb.getLocale());
		
		
		
	}

}
