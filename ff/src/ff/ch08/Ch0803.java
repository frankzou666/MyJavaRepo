package ff.ch08;

import java.util.HashSet;


class A {
	public int hashCode() {
		return 1;
	}
	public boolean equals(Object o) {
		return true;
	}
}

class B {
	public int hashCode() {
		return 1;
	}
	// equals() always return false
	public boolean equals(Object o) {
		return false;
	}
}


class  C {
	public int cnt;
	public int hashCode() {
		return 1;
	}
	// equals() always return false
	public boolean equals(Object o) {
		 //对像是不是自己
		if (o == this) {
			return true;
		}
		//类型是不是一样的
		if ((o!=null) && (o.getClass()==C.class) ){
			C obj =(C)o;
			return this.cnt == obj.cnt;
		}
		return false;
	}
}


public class Ch0803 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet hs = new HashSet();
		hs.add("a");
		hs.add("d");
		A a1= new A();
		A a2= new A();
		hs.add(a1);
		hs.add(a2);
		B b1= new B();
		B b2= new B();
		hs.add(a1);
		hs.add(a2);
		hs.add(b1);
		hs.add(b2);
		hs.forEach(obj->System.out.println(obj));

	}

}
