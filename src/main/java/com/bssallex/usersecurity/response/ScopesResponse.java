package com.bssallex.usersecurity.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScopesResponse {

    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
