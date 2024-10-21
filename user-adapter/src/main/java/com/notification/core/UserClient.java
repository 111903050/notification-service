package com.notification.core;

import com.notification.core.dto.User;
import com.notification.core.port.UserServicePort;
import org.springframework.stereotype.Component;

@Component
public class UserClient implements UserServicePort {
    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
