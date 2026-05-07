package com.bssallex.usersecurity.exceptions;

public class EmailOrPassword extends RuntimeException {
    public EmailOrPassword(String message) {
        super(message);
    }
}
