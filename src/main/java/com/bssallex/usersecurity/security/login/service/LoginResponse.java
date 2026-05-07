package com.bssallex.usersecurity.security.login.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginResponse {

    private String accessToken;
    private Long expiresIn;
}
