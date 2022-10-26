package ff.ch07;

import java.io.File;
import java.util.Scanner;

public class Ch702 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// get Scanner
	    Scanner scanner= new Scanner(new File("Ch0701.java"));
		//while(scanner.hasNext()) {
		//	System.out.println("your input:"+scanner.next());
		//}
	    while(scanner.hasNextLine()) {
	    	
	    	System.out.println("your input:"+scanner.nextLine());
	    }

	}

}
