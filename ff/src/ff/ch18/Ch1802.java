package ff.ch18;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Student{
	void sayHello(String str);
}

class MyInvocation implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 实际上是sayHello()被当做这个方法来执行了
		if (args!=null) {
			for(Object arg:args) {
				System.out.println(arg);
			}
			
		}
		return null;
	}
	
}

public class Ch1802 {
	
	public  static void main(String[] args) {
		InvocationHandler invocationHandler = new MyInvocation();
		//Student  只是一个接口，但是代理了
		Student student = (Student)Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[] {Student.class}, invocationHandler);
		student.sayHello("hello student");
		
		//studuent只是一接口，在这里输出了null
		System.out.println(student);
		
		
	}

}
