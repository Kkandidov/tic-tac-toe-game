package org.astashonok.userservice.mapper;

import org.astashonok.userservice.dto.UserDto;
import org.astashonok.userservice.entity.User;
import org.astashonok.userservice.rest.request.UserCreatingRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCreatingRequestMapper extends ParameterizedDtoMapper<UserCreatingRequest, User> {
}
