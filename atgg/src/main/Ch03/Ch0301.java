package main.Ch03;

import java.util.Objects;

/**
 * 
 */

class Circle {

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	@Override
	public int hashCode() {
		// Class.forName("com.abc");
		
		return Objects.hash(radius);
	}

	// 对属性进行保护，类的属性都需要定义为private,通过public方法让外部来改变属性setRadius()
	private int radius;

	// 显示定义了一个构造器,连void都不能有
	// 如果程序员提供了，则系统不提供，必须要在程序员提供的选择
	public Circle() {
		System.out.println("Circle object has been created...");
	}

	public void setRadius(int radius) {
		this.radius = radius;

	}

	public int getRadius() {
		return radius;

	}

	public double getArea() {
		return 3.14 * radius * radius;
	}
}

public class Ch0301 {
   
	
	  
	 

}
