package com.toluAdesola.myMarketPlace;

import com.toluAdesola.myMarketPlace.model.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(SendMail sendMail, String receiver){
        System.out.println("sending email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sendMail.getEmail().trim());
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(sendMail.getSubject());
        simpleMailMessage.setText("Name: " + sendMail.getName() +"\n"+
                sendMail.getText() + "\n" +
                "Phone Number: " + sendMail.getPhoneNumber());
        javaMailSender.send(simpleMailMessage);
        System.out.println("sent email...");
    }
}
