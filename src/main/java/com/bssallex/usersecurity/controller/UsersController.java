package com.bssallex.usersecurity.controller;

import com.bssallex.usersecurity.docs.UserControllerDoc;
import com.bssallex.usersecurity.request.ScopesRequest;
import com.bssallex.usersecurity.request.UserRequest;
import com.bssallex.usersecurity.response.UserResponse;
import com.bssallex.usersecurity.security.scopes.Admin;
import com.bssallex.usersecurity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UsersController implements UserControllerDoc {

    private final UserService userService;

    @GetMapping("/list")
    @Admin
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> listAllUsers(){
        return userService.listUsers();
    }

    @GetMapping("/find/{id}")
    @Admin
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findUserId(@PathVariable Long id){
        return userService.findUsersById(id);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    @Admin
    public UserResponse findUserEmail(@PathVariable @Valid String email){
        return userService.userEmail(email);
    }

    @PostMapping("/created")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createdUser(@RequestBody @Valid UserRequest request){
        return userService.createdUser(request);
    }

    @PostMapping("/scope/{id}")
    @Admin
    @ResponseStatus(HttpStatus.OK)
    public UserResponse newScopeInUser(@PathVariable Long id, @RequestBody @Valid ScopesRequest request){
        return userService.newScope(id, request);
    }
}
