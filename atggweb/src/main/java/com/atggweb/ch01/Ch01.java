package com.atggweb.ch01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch01
 */

@WebServlet("/ab")
public class Ch01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ch01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FILE_NAME="1.png";
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition","attachement;filename="+"1.png");
		System.out.println(FILE_NAME);
		OutputStream out = response.getOutputStream();
		InputStream is = new FileInputStream(FILE_NAME);
		byte[] buf = new byte[1024];
		int len=0;
        while((len=is.read(buf))!= -1) {
        	out.write(buf,0,len);
        }
        
        is.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("habbit");
		String[] habbits = request.getParameterValues("habbit");
		for(String habbit:habbits) {
			System.out.println(habbit);
		}
				
		
	}

}
