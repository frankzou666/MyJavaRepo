package fj.ch06;

class Person{
	private String name;
	public Person(String name) {
		this.name=name;
	}
}


public class Ch0602 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 =  "hello";
		String s2 =  "hello";
		String s3 =  new String("hello");
		String s4 =  new String("hello");
		// 返回true;
		System.out.println(s1==s2);
		// 返回false,引用变量不要直接发用 ==
		System.out.println(s3==s4);
		//返true
		System.out.println(s1.equals(s2));
		//返true
		System.out.println(s3.equals(s4));
		//返true
		System.out.println(s3.equals(s1));

	}
	

}
