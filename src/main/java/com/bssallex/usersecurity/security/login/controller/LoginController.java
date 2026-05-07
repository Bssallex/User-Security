package com.bssallex.usersecurity.security.login.controller;

import com.bssallex.usersecurity.docs.SecurityLoginDoc;
import com.bssallex.usersecurity.security.login.service.LoginRequest;
import com.bssallex.usersecurity.security.login.service.LoginResponse;
import com.bssallex.usersecurity.security.login.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController implements SecurityLoginDoc {

    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse loginUser(@RequestBody @Valid LoginRequest request){
        return loginService.login(request);
    }


}
