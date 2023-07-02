package ff.ch08;

import java.util.HashSet;
import java.util.TreeSet;



public class Ch0805 {

	public static void main(String[] args) {
		// EnumSet
		
		TreeSet ts = new TreeSet();
		ts.add(1);
		ts.add(10);
		ts.add(9);
		System.out.println(ts.first());
		System.out.println(ts.last());
		System.out.println(ts);
	}

}
