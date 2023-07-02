package ff.ch14;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


//注解本身可以使用其他注解
//使用Retnetion，可以让程序在运行时提取到注解信息
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Tests.class)
@interface Test{
	//the variable name be defined as method() without argument
	String name();
	
	//the variable is a "default" variable
	int age() default 33;
	
}


@Retention(RetentionPolicy.RUNTIME)
@interface Tests{
	Test[] value();
	
}

public class Ch1403 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Annotation[] ans = Class.forName("ff.ch14.Ch1403").getMethod("run").getAnnotations(); 
		new Ch1403().run();
		System.out.println(ans.length);
		for (Annotation an: ans) {
			System.out.println("an");
		}
		

	}
	
	@Test(name="this a annotation variable(name)1")
	@Test(name="teis a annotation variable(name)2", age=34)
	public void run() {
		System.out.println("test annotation");
	}

}
