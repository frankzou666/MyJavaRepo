package main.Ch03;


class Circle{
	
	//对属性进行保护，类的属性都需要定义为private,通过public方法让外部来改变属性setRadius()
    private int radius;
	
    //显示定义了一个构造器
    public  void Circle() {
    	System.out.println("Circle object has been created...void");
    }
    
    public void setRadius(int radius) {
    	this.radius = radius;
    	
    }
    public int getRadius() {
    	return this.radius;
    	
    }
    
	public double getArea() {
		return 3.14*radius*radius;
	}
	
}



public class Ch0301 {
	 
	public static void main(String [] args) {
		// System.out.print("hello");
		 Circle c = new Circle();
		 c.setRadius(2);
		 System.out.println(c.getRadius());
		 System.out.println(c.getArea());
		
	}

}
