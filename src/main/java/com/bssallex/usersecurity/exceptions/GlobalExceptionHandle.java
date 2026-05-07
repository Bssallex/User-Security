package com.bssallex.usersecurity.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandle {

    @Getter
    @Setter
    @Builder
    public static class ErroResponse{

        private LocalDateTime timestamp;
        private int status;
        private String message;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Map<String, String> error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErroResponse> handleValidationException(MethodArgumentNotValidException ex){

        Map<String, String> fieldErrors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        }

        ErroResponse erroResponse = ErroResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Validation erro")
                .error(fieldErrors)
                .build();

        return new ResponseEntity<>(erroResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity handleResouceNotFound(UserNotFound ex){

        ErroResponse erroResponse = ErroResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(erroResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistingEmail.class)
    public ResponseEntity handleResouceExistingEmail(ExistingEmail ex){

        ErroResponse erroResponse = ErroResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(erroResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoExistingScope.class)
    public ResponseEntity handleNoExistingScope(NoExistingScope ex){

        ErroResponse erroResponse = ErroResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(erroResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmailOrPassword.class)
    public ResponseEntity handleEmailOrPassword(EmailOrPassword ex){

        ErroResponse erroResponse = ErroResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(erroResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ScopeExisting.class)
    public ResponseEntity handleScopeExisting(ScopeExisting ex){

        ErroResponse erroResponse = ErroResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(erroResponse, HttpStatus.CONFLICT);
    }

}
