package com.notification.core.port;
import com.notification.core.dto.User;

public interface UserServicePort {
    User getUserByEmail(String email);
}
