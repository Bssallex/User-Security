package com.bssallex.usersecurity.docs;

import com.bssallex.usersecurity.request.ScopesRequest;
import com.bssallex.usersecurity.response.ScopesResponse;
import com.bssallex.usersecurity.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Scope", description = "Recurso responsável pelo gerenciamento de scopes")
public interface ScopeControllerDoc {

    @Operation(summary = "Listar todos os scopes", description = "Retorna todos os scopes existentes no sistema")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de scopes",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserResponse.class)))
    )
    List<ScopesResponse> listAllScopes();

    @Operation(summary = "Criar um novo scope", description = "Permite o ADMIN adicionar um novo scope no sistema")
    @ApiResponse(
            responseCode = "201",
            description = "Scope criado com sucesso",
            content = @Content(schema = @Schema(implementation = UserResponse.class))
    )
    ScopesResponse userScope(@RequestBody @Valid ScopesRequest request);
}
