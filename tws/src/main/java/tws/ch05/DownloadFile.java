package tws.ch05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName;
		InputStream is;
		OutputStream ot;
		fileName=req.getParameter("file");
		//得到本地输入流
		is = getServletContext().getResourceAsStream(fileName);
		//看文件是否存在
		if(is==null) {
			ot = resp.getOutputStream();
			ot.write((fileName + " is not Exist!!!").getBytes());
			ot.close();
			return;
		}
		//得到出输出流
		ot = resp.getOutputStream();
		//设置响应头
		resp.setContentType("application/force-download");
		resp.setHeader("Content-Disposition","attachment; filename="+fileName);
		//读输入和设置输出
		byte[] buf = new byte[512];
		int leng=0;
		while((leng=is.read(buf))!= -1) {
			ot.write(buf,0,leng);

		}
		//关闭响应和输出
		is.close();
		ot.close();

	}


	//upload file
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
