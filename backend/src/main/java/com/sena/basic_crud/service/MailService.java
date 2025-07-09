package com.sena.basic_crud.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender javaMailSender;

    public void sendMail(String html, String mailTo, String subject) {
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(username);
            helper.setTo(mailTo);
            helper.setSubject(subject);
            helper.setText(html, true);

            javaMailSender.send(message);
        }  catch (Exception e) {
            System.out.println("Error al enviar correo: " + e.getMessage());
        }
    }
}
