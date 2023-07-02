package ff.ch08;

import java.util.HashSet;
import java.util.TreeSet;




class  D {
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


public class Ch0804 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet ts = new TreeSet();
		ts.add(1);
		ts.add(2);
		ts.add(10);
		ts.add(9);
		System.out.println(ts.first());
		System.out.println(ts.last());
		System.out.println(ts);
	}

}
