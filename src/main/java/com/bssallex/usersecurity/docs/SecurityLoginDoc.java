package com.bssallex.usersecurity.docs;

import com.bssallex.usersecurity.response.UserResponse;
import com.bssallex.usersecurity.security.login.service.LoginRequest;
import com.bssallex.usersecurity.security.login.service.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Login Security", description = "Recurso responsável pelo login de usuários no sistema")
public interface SecurityLoginDoc {

    @Operation(summary = "Usuário Login", description = "O usuário faz login no sistema com seu email e senha")
    @ApiResponse(
            responseCode = "200",
            description = "Usuário autenticado com sucesso",
            content = @Content(schema = @Schema(implementation = UserResponse.class))
    )
    @ApiResponse(
            responseCode = "409",
            description = "Conflito",
            content = @Content()
    )
    LoginResponse loginUser(@RequestBody @Valid LoginRequest request);
}
