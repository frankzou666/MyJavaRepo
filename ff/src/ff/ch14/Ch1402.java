package ff.ch14;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings(value="unchecked")

public class Ch1402 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ch1402().info();

	}
	
	//@Deprecated
	public void info() {
		System.out.println("i will be removed at next time!!!");
	}

}

// my annotation TestInter
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
@Target(value=ElementType.METHOD)
@interface TestInter{
	
}