package ff.ch18;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person {
	String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	
	public Person() {
		super();

	}
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public Person(String name,Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
}

public class Ch1801 {

	// 为什么要有反射
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		// 得到clazz的对像的三种方法，但是第二种方法有异常要处理，

		//Person person = new Person();
		//Class personClazz1 = person.getClass();
		Class personClazz = Class.forName("ff.ch18.Person");
		
		
		Person person=null;
		
		//得到构造器，构造对像
		Constructor[] constructors = personClazz.getConstructors();
		for(Constructor  constructor:constructors) {
            
			//使用无参构器去创建对像
			if (constructor.getParameterCount()==0) {
			    person = (Person)constructor.newInstance();
				System.out.println(person);
			}
		}	
		
		//得到方法名，并调用
		Method method = personClazz.getMethod("setName",String.class);	
		//为什么设置为setName()设置private, setAccessible()不直作用
		method.setAccessible(true);
		method.invoke(person, "hello3 ,frank");
		System.out.println(person);
		
		//获取成员变量,并设置值，如果age为public就可以用getFiled() ,否则只用getDeclaredField(),
		// 如果是private修饰的变量，还需要setAccessible(true)
		//Field field = personClazz.getField("age");
		Field field = personClazz.getDeclaredField("age");
		field.setAccessible(true);
		field.set(person, 10);
		method.invoke(person, "hello3 ,frank");
		System.out.println(person);
		
		
		
		

	}

}
