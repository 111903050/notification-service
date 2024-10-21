package com.notification.core;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class LoginEventListener {
    private final NotificationService notificationService;


    public LoginEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "password.created", groupId = "notification-service")
    public void onPasswordGeneratedEvent(@Header(KafkaHeaders.RECEIVED_KEY)String email, String password) {
        notificationService.sendPasswordEmail(email, password);
    }
}
