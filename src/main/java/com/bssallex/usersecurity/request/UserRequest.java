package com.bssallex.usersecurity.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String password;

}
