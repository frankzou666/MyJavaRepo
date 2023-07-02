package ff.ch10;

import java.io.FileInputStream;
import java.io.IOException;

public class Ch1001 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//FileInputStream fis = new FileInputStream("b.txt");
		int i;
		i=System.in.read();
		try {
		  if (i==97) {
			throw new RuntimeException("hello");
			
		  }
		  else {
			  System.out.println("input is ok!");
		  }
		} catch(Exception e) {
			System.out.println("i get a runtime exception");
			
		}
	
		
	}

}


class Sub extends Ch1001{
	
	public void testExcept() throws Exception {
		;
		
	}
	
}