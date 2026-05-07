package com.bssallex.usersecurity.service;

import com.bssallex.usersecurity.entity.Scopes;
import com.bssallex.usersecurity.entity.Users;
import com.bssallex.usersecurity.exceptions.ExistingEmail;
import com.bssallex.usersecurity.exceptions.NoExistingScope;
import com.bssallex.usersecurity.exceptions.ScopeExisting;
import com.bssallex.usersecurity.exceptions.UserNotFound;
import com.bssallex.usersecurity.mapper.UserMapper;
import com.bssallex.usersecurity.repository.ScopesRepository;
import com.bssallex.usersecurity.repository.UsersRepository;
import com.bssallex.usersecurity.request.ScopesRequest;
import com.bssallex.usersecurity.request.UserRequest;
import com.bssallex.usersecurity.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final ScopesRepository scopesRepository;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;

    public List<UserResponse> listUsers(){

        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public UserResponse findUsersById(Long id){
        Users findUsers = usersRepository.findById(id).orElseThrow(() -> new UserNotFound("Usuário não encontrado"));
        return mapper.toResponse(findUsers);
    }

    public UserResponse userEmail(String email){
        Users emailUser = usersRepository.findByEmail(email).orElseThrow(() -> new UserNotFound("Email não encontrado"));
        return mapper.toResponse(emailUser);
    }

    public UserResponse createdUser(UserRequest request){

        Optional<Users> findUser = usersRepository.findByEmail(request.getEmail());

        if(findUser.isPresent()){
            throw new ExistingEmail("Este email " + request.getEmail() + " já existe no sistema");
        }

        Optional<Scopes> defaultScope = scopesRepository.findByName("user:read");

        if(defaultScope.isEmpty()){
            throw new NoExistingScope("Scope não encontrado");
        }

        Scopes defaultUserScopes = defaultScope.get();

        Set<Scopes> scopeDefault = new HashSet<>();
        scopeDefault.add(defaultUserScopes);

        Users createdUser = new Users();
        createdUser.setName(request.getName());
        createdUser.setEmail(request.getEmail());
        createdUser.setPassword(encoder.encode(request.getPassword()));
        createdUser.setScopes(scopeDefault);

        return mapper.toResponse(usersRepository.save(createdUser));
    }

    public UserResponse newScope(Long id, ScopesRequest request){

        Users findUsers = usersRepository.findById(id).orElseThrow(() -> new UserNotFound("Usuário não encontrado"));
        Optional<Scopes> addScope = scopesRepository.findByName(request.getName());

        if(addScope.isEmpty()){
            throw new NoExistingScope("Scope não encontrado");
        }

        Scopes scopesToAdd = addScope.get();

        boolean scopeExistingInUser = findUsers.getScopes().contains(scopesToAdd);

        if(scopeExistingInUser){
            throw new ScopeExisting("Esse scope " + scopesToAdd.getName() + " já pertence a esse usuário");
        }

        findUsers.getScopes().add(scopesToAdd);
        return mapper.toResponse(usersRepository.save(findUsers));
    }
}
