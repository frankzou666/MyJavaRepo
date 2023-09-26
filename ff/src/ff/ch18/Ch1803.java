package ff.ch18;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Dog {
	String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	
	public Dog() {
		super();

	}
	
	public Dog(String name) {
		super();
		this.name = name;
	}
	
	public Dog(String name,Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
}

public class Ch1803 {

	// 为什么要有反射
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {

		//Class DogClazz = Class.forName("ff.ch18.Dog");
		
		Class<Dog> DogClazz = ff.ch18.Dog.class;
		
		
		Dog dog=null;
		
		//得到构造器，构造对像
		Constructor[] constructors = DogClazz.getConstructors();
		for(Constructor  constructor:constructors) {
            
			//使用无参构器去创建对像
			if (constructor.getParameterCount()==0) {
			    dog = constructor.newInstance();
				System.out.println(dog);
			}
		}	
		
	
		
		
		
		

	}

}
