package ff.ch06;

import java.util.Locale;

public class Ch0609{

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Locale local = Locale.getDefault();
		System.out.println(local.getISO3Country());
		
		
		String str="hello";
		for(int i=0;i<5;i++) {
			 new Ch0609();
		}
		// 重写了finalize()方法，当对像被回收时，会调用这个方法
		System.gc();

	}
	//
	public void finalize() {
		System.out.println("clean object");
	}

}
