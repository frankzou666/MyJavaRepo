package ff.ch10;


class MyException extends RuntimeException{
	public MyException() {
		
	}
    public MyException(String msg) {
		super(msg);
	}
	
}

public class Ch1002 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			throw new MyException("my exception");
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("ok");
			throw ex;
		}
		

	}

}
