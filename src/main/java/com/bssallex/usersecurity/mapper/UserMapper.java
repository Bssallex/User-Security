package com.bssallex.usersecurity.mapper;

import com.bssallex.usersecurity.entity.Scopes;
import com.bssallex.usersecurity.entity.Users;
import com.bssallex.usersecurity.request.UserRequest;
import com.bssallex.usersecurity.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

      Users toRequest(UserRequest request);

      @Mapping(source = "scopes", target = "scopes")
      UserResponse toResponse(Users users);

      default String map(Scopes scopes){
            return scopes.getName();
      }


}
