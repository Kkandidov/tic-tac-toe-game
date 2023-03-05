package org.astashonok.userservice.mapper;

import org.astashonok.userservice.dto.UserDto;
import org.astashonok.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper extends ParameterizedDtoMapper<UserDto, User> {
}
