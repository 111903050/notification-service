package com.notification.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.notification.core")
public class NotificationApplication {
    public static void main(String[] args){
        SpringApplication.run(NotificationApplication.class, args);
    }
}
