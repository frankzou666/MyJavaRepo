package com.example.pwdtools;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PwdToolsApplication {
	public BasicTextEncryptor textEncryptor;
	//jasypt password
	public String jaspytpassword = "dGlnZXIyMDIx";
	
	//the string we want to encrypt
	public String textstring = "Bj4QDzb6atQ39VOhpl7z";
	
	//the string we want to dencrypt
	public String pwdstring ="";
	public static void main(String[] args) {
		PwdToolsApplication pwdToolsApplication = new PwdToolsApplication();
		pwdToolsApplication.runPwd();
		pwdToolsApplication.decryptPwd();
		
	}
	
	public void decryptPwd() {
        if  ((pwdstring == null) || (pwdstring.isEmpty()))  {
		    System.out.println("you do not provide encrypt string!");
        } else {
        	System.out.println("password back to plain text : "+ getText(pwdstring));
        }
	}
	public void runPwd() {
		// encrypt , decrypt and println
		String encryptpassword = "";
		String decryptpassword = "";
		encryptpassword = getPassword();
		decryptpassword = getText(encryptpassword);
		System.out.println("plain text : "+ textstring);
		System.out.println("encrypt password : "+ encryptpassword );
		System.out.println("password back to plain text(test) : "+ decryptpassword);
		
	}
	public String  getPassword() {
		// encrypt
        textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(jaspytpassword);
        return textEncryptor.encrypt(textstring);
        
    }
	
	public String  getText(String pwdstring) {
		// decrypt
        textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(jaspytpassword);
        return textEncryptor.decrypt(pwdstring);
        
    }

}
