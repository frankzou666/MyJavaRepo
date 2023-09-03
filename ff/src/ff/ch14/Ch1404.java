package ff.ch14;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;


class Account{
	private int balance;
	private final ReentrantLock rl = new ReentrantLock();
	public  Account(int balance) {
		this.balance=balance;
	}
	public   void drawBalance(int amount) throws InterruptedException {
		rl.lock();
		this.balance=this.balance-amount;
		Thread.sleep(1000);
		rl.unlock();
		
	}
	
	public int getBalance() {
		return this.balance;
		
	}
}

class JoinThread extends Thread{
	private String name=Integer.toString(0);
	private Account account;
	public JoinThread(String name,Account account) {
		super(name);
		this.account= account;
		
		
	}
	public void run() {
		//System.out.println(Thread.currentThread().getName()+':'+Thread.currentThread().getPriority());
		for(int i=0;i<5;i++) {
			try {
			    
				account.drawBalance(10);
				System.out.println(new Date()+ getName()+':'+account.getBalance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(new Date()+ getName()+':'+i);
		}
		
	}
}

public class Ch1404 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Account account;
		account = new Account(100);
		JoinThread jt1=new JoinThread("新线程11",account);
		jt1.start();
		//Thread.sleep(100);
		JoinThread jt2=new JoinThread("新线程2",account);
		jt2.start();
		jt1.join();
		jt2.join();
		System.out.println(account.getBalance());
		
		//Thread.sleep(1000);
		//jt.setDaemon(true);
		//jt.start();
		//jt.setDaemon(true);
		/*
		for(int i=0;i<50;i++) {
			if (i%10==0) {
				JoinThread jt1=new JoinThread("被join thread");
				jt1.start();
				jt1.join();
			}
			System.out.println(Thread.currentThread().getName()+':'+i);
		}
		*/
		//default 5 in macos
		//System.out.println(Thread.currentThread().getName()+':'+Thread.currentThread().getPriority());
		System.out.println(new Date()+ Thread.currentThread().getName()+ " exit!!");

	}

}
