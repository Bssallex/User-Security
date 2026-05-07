package com.bssallex.usersecurity.exceptions;

public class NoExistingScope extends RuntimeException {
    public NoExistingScope(String message) {
        super(message);
    }
}
