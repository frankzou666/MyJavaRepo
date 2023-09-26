package ff.ch17;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Cat{
	
	String name;
	Integer age;
	public Cat() {
		super();
		System.out.println(this.getClass().getName());
	}
	
	
}


class Dog{
	String name;
	Integer age;
	
	public Dog(){
		System.out.println(this.getClass().getName());
	}
	public void getName() {
		System.out.println(this.getClass().getName());
		
	}
	
}


public class Ch1701 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input:");
	    String str= sc.next();
	    //得到class 对像
	    // 必须要是全类名
	    Class clazz = Class.forName("ff.ch17."+str);
	    Constructor constructor = clazz.getConstructor(null);
	    Object obj = constructor.newInstance();
	    Method[] methods = clazz.getMethods();
	    for(Method method:methods) {
	    	System.out.println(method.getName().equals("getName"));
	    }
	   
	}
}
