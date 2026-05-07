package com.bssallex.usersecurity.mapper;

import com.bssallex.usersecurity.entity.Scopes;
import com.bssallex.usersecurity.request.ScopesRequest;
import com.bssallex.usersecurity.response.ScopesResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScopesMapper {

    Scopes toRequest(ScopesRequest request);

    ScopesResponse toResponse(Scopes scopes);
}
