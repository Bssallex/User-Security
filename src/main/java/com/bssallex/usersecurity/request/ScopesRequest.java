package com.bssallex.usersecurity.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScopesRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
