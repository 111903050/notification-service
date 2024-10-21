package com.notification.core;

import com.notification.core.dto.User;
import com.notification.core.port.NotificationSenderPort;
import com.notification.core.port.UserServicePort;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationSenderPort notificationSenderPort;
    private final UserServicePort userServicePort;

    public NotificationService(NotificationSenderPort notificationSenderPort, UserServicePort userServicePort) {
        this.notificationSenderPort = notificationSenderPort;
        this.userServicePort = userServicePort;
    }

    public void sendPasswordEmail(String email, String password) {
        String subject = "Welcome! Your New Password";
        String message = String.format("Hello %s,\n\nYour temporary password is: %s\nPlease change it after logging in.", email, password);
        User recipient = new User(1L, email, password);
        notificationSenderPort.sendNotification(recipient, subject, message);
    }
}
