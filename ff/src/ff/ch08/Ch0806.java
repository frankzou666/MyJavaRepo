package ff.ch08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Ch0806 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Properties pop =new Properties();
		pop.put("name", "frank");
		pop.put("age", "10");
		//输出到文件
		pop.store(new FileOutputStream("a.ini"),"comment line");
		System.out.println(pop.getProperty("age"));

		

	}

}
