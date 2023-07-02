package ff.ch08;

import java.util.*;

public class Ch0801 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List list = new ArrayList();
		list.add(10);
		list.add("hello");
		System.out.println(list);
		
		// forEach方式
		list.forEach(obj->System.out.println(obj));
		
		// use iterator 方式
		Iterator it = list.iterator();
		while(it.hasNext()) {
			if (it.next().equals("hello")) {
				// remove某个素,只是从迭代器删除，容器对像这个元素还是存在的
				it.remove();
			}
			else {
			System.out.println(it.next());
			}
		}
		//使用java 1.5新的for each
		System.out.println("使用java 1.5新的for each:");
		for(Object o:list) {
			System.out.println(o);
		}
		

	}

}
