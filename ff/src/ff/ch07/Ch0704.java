package ff.ch07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.util.Map;

public class Ch0704 {
	
	// get runtime
	public static void main(String[] args) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.availableProcessors());
		System.out.println(runtime.freeMemory());
		Process process = runtime.exec("ls");
		System.out.println(new OutputStream(process.getOutputStream()));
	}

}
