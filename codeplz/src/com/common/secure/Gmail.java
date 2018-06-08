package com.common.secure;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	PasswordAuthentication pa;
	
	public Gmail() {
		String id = "khcodeplz@gmail.com";
		String pw = "codeplz1122";
		
		pa = new PasswordAuthentication(id, pw);
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}