package com.bssallex.usersecurity.docs;

import com.bssallex.usersecurity.request.ScopesRequest;
import com.bssallex.usersecurity.request.UserRequest;
import com.bssallex.usersecurity.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Usuário", description = "Recurso responsável pelo gerenciamento de usuários")
public interface UserControllerDoc {

    @Operation(summary = "Listar todos os usuários", description = "Retorna todos os usuários que estão cadastrados no sistema")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de usuários",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserResponse.class)))
    )
    List<UserResponse> listAllUsers();

    @Operation(summary = "Buscar usuário por ID", description = "Busca um usuário cadastrado com base no seu id")
    @ApiResponse(
            responseCode = "200",
            description = "Usuário",
            content = @Content(schema = @Schema(implementation = UserResponse.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Usuário não encontrado",
            content = @Content()
    )
    UserResponse findUserId( @PathVariable Long id);

    @Operation(summary = "Buscar usuário por email", description = "Busca um usuário cadastrado com base no seu email")
    @ApiResponse(
            responseCode = "200",
            description = "Email",
            content = @Content(schema = @Schema(implementation = UserResponse.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Email não encontrado",
            content = @Content()
    )
    UserResponse findUserEmail( @PathVariable String email);

    @Operation(summary = "Cadastrar um novo usuário", description = "O usuário cria uma conta no sistema")
    @ApiResponse(
            responseCode = "201",
            description = "Usuário criado com sucesso",
            content = @Content(schema = @Schema(implementation = UserResponse.class))
    )
    UserResponse createdUser(@RequestBody @Valid UserRequest request);

    @Operation(summary = "Adiciona um novo scope", description = "Permite o ADMIN adicionar um novo scope a qualquer usuário")
    @ApiResponse(
            responseCode = "200",
            description = "Scope",
            content = @Content(schema = @Schema(implementation = UserResponse.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Scope ou usuário não encontrado",
            content = @Content()
    )
    UserResponse newScopeInUser(@Valid @PathVariable Long id, @RequestBody ScopesRequest request);
}
