package com.bssallex.usersecurity.exceptions;

public class ExistingEmail extends RuntimeException {
    public ExistingEmail(String message) {
        super(message);
    }
}
