package com.bssallex.usersecurity.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserResponse {

    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @Email
    private String email;

    private Set<String> scopes;
}
