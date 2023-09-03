package ff.ch16;



class FirstThread extends Thread {
	
	public void run() {
		
		for(int i=0;i<2;i++) {
			System.out.print('\n'+getName()+':'+i);
		}
	}
	
}



class FirstRunable  implements Runnable{
	
	public void run() {
		
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" priority: "+Thread.currentThread().getPriority());
			System.out.print('\n'+Thread.currentThread().getName()+':'+i);
		}
	}
	
}

public class Ch1601{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.print(Thread.currentThread().getName());
		
		/*
		new FirstThread().start();
		new FirstThread().start();
		*/
		
		
		 FirstRunable fr=new FirstRunable(); 
		 new Thread(fr).start();
		 new Thread(fr).start();
		 new Thread(fr).start();

	}

}
