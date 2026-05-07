package com.bssallex.usersecurity.service;

import com.bssallex.usersecurity.entity.Scopes;
import com.bssallex.usersecurity.mapper.ScopesMapper;
import com.bssallex.usersecurity.repository.ScopesRepository;
import com.bssallex.usersecurity.request.ScopesRequest;
import com.bssallex.usersecurity.response.ScopesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScopesService {

    private final ScopesRepository scopesRepository;
    private final ScopesMapper mapper;

    public List<ScopesResponse> listScopes(){

        List<Scopes> scopes = scopesRepository.findAll();
        return scopes.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ScopesResponse createScopes(ScopesRequest request){

        Scopes created = scopesRepository.save(mapper.toRequest(request));
        return mapper.toResponse(created);
    }
}
