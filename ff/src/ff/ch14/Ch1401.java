package ff.ch14;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings(value="unchecked")

public class Ch1401 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List ls = new ArrayList<Integer>();
		ls.add(20);
		List<String> myList = ls;
		System.out.println(myList.get(0));

	}
	
	public void info() {
		System.out.println("i will be removed at next time!!!");
	}

}
