package ff.ch07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.util.Map;
import java.util.Random;

public class Ch0705 {
	
	// math objects.
	public static void main(String[] args) throws IOException {
		Random random = new Random(10);
		for (int i=0;i<10;i++) {
			System.out.println(random.nextInt(1, 10));
		}
	}

}
