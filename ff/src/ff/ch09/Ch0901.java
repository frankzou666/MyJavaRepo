package ff.ch09;

import java.util.ArrayList;
import java.util.List;

class Apple<T extends Number>{
	public void getInfo(T t) {
		System.out.println(t);
	}
}

public class Ch0901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("6");
		//ar.add("5");
		// 7 will be ClassCastException
		//ar.add(7);
		//ar.forEach(item->System.out.println(Integer.parseInt((item))));
		Apple<Float> apple = new Apple<Float>();
		apple.getInfo(new Float(2));
		new Ch0901().test(ar);
		
		

	}
	public void test(List<?> l) {
		for(int i=0;i<l.size();i++) {
			System.out.print(l.get(i));
		}
		
	}

}
