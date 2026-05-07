package com.bssallex.usersecurity.controller;

import com.bssallex.usersecurity.docs.ScopeControllerDoc;
import com.bssallex.usersecurity.request.ScopesRequest;
import com.bssallex.usersecurity.response.ScopesResponse;
import com.bssallex.usersecurity.security.scopes.Admin;
import com.bssallex.usersecurity.service.ScopesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
public class ScopesController implements ScopeControllerDoc {

    private final ScopesService scopesService;

    @GetMapping("/list")
    @Admin
    @ResponseStatus(HttpStatus.OK)
    public List<ScopesResponse> listAllScopes(){
        return scopesService.listScopes();
    }

    @PostMapping("/created")
    @Admin
    @ResponseStatus(HttpStatus.CREATED)
    public ScopesResponse userScope(@RequestBody @Valid ScopesRequest request){
        return scopesService.createScopes(request);
    }

}
