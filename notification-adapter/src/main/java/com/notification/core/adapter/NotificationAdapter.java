package com.notification.core.adapter;

import com.notification.core.dto.User;
import com.notification.core.port.NotificationSenderPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class NotificationAdapter implements NotificationSenderPort {
    @Autowired
    private final JavaMailSender javaMailSender;

    public NotificationAdapter(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void sendNotification(User recipient, String subject, String message) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);

            helper.setTo(recipient.getEmail());
            helper.setSubject(subject);
            helper.setText(message, true);

            javaMailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
