package com.jsp.user.controller;

import java.io.IOException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.secure.*;
import com.google.gson.Gson;

@WebServlet("/signup_auth_send.cp")
public class User_SignUp_AuthSend_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public User_SignUp_AuthSend_Servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to = (String)request.getParameter("to_email");
		boolean result = false;
		
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		
//		System.out.println("이메일 인증키 전송 서블릿 : " + to);
		Properties p = System.getProperties();
		
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587");
		
		Authenticator gmail = new Gmail();
		
		// 이메일 세션 생성(javax.mail.Session)
		Session mail_Session = Session.getDefaultInstance(p, gmail);
		MimeMessage sendMessage = new MimeMessage(mail_Session);
		
		try {
			String subject = "회원가입 인증 메일입니다.";
			
			EncryptUtil ec = new EncryptUtil();
			
			int rand_Num = new Random().nextInt(Integer.MAX_VALUE) + 1;
			
//			System.out.println(rand_Num);
			String auth_key = ec.encrypt(Integer.toString(rand_Num));
			String text = "codeplz 회원가입 인증키입니다. <br />" + 
							"<input type=\"text\" id=\"auth_key\" value=\"" + auth_key + "\" size=\"64\"readonly>";
			
			sendMessage.setSentDate(new Date()); // 날짜
			
			InternetAddress from_email = new InternetAddress("codeplz<khcodeplz@gmail.com>");
			InternetAddress to_email = new InternetAddress(to);
			
			sendMessage.setFrom(from_email); // 발신자 설정
			sendMessage.setRecipient(Message.RecipientType.TO, to_email); // 수신자 설정 
			
			sendMessage.setSubject(subject, "UTF-8"); // 제목
			sendMessage.setText(text, "UTF-8"); // 내용
			sendMessage.setHeader("content-Type", "text/html"); // html 송신 가능
			
			javax.mail.Transport.send(sendMessage);
			
			// exception 미발생이므로 이메일 성공적으로 송신
			
			HttpSession session = request.getSession();
			
			session.setAttribute("auth_key", auth_key);
			
			result = true;
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			gson.toJson(result, response.getWriter());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
