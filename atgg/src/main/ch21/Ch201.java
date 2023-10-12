package main.ch21;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Ch201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		//DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.MEDIUM);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS",Locale.CANADA);
		//sdf.parse() 把一个字符串转换为日期对像
		System.out.println(sdf.format(System.currentTimeMillis()));
		
		//格式化货币和数字
		NumberFormat nfn = NumberFormat.getNumberInstance(Locale.CHINA);
		System.out.println(nfn.format(123232323));
		
		NumberFormat nfc = NumberFormat.getCurrencyInstance(Locale.UK);		
		System.out.println(nfc.format(123232323));
		
		ResourceBundle rb = ResourceBundle.getBundle("message", Locale.CANADA);
		
		

	}

}
