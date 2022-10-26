package ff.ch07;

import java.util.Map;

public class Ch0703 {
	
	// get all system environments
	public static void main(String[] args) {
		Map<String,String> sysenv = System.getenv();
		for(String key:sysenv.keySet()) {
			System.out.println("key:"+key +", value:"+sysenv.get(key));
		}
		
	}

}
