package com.notification.core.port;

import com.notification.core.dto.User;

public interface NotificationSenderPort {
    void sendNotification(User recipient, String subject, String message);
}
