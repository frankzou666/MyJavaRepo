package ff.ch08;

import java.lang.reflect.Array;
import java.util.*;
import java.util.TreeSet;



public class Ch806 {

	public static void main(String[] args) {
		// EnumSet
		// 正常的list,可以使用add(),remove
		List hs1= new ArrayList();
		hs1.add(new String("a"));
		hs1.add(new String("b"));
		List hs2=Arrays.asList("c");
		// 这个list不能正常的add()操作
		hs2.add(new String("b"));
		hs1.forEach(obj->System.out.println(obj));
		hs2.forEach(obj->System.out.println(obj));

	}

}
