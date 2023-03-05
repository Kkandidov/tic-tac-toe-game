package org.astashonok.userservice.service;

import org.astashonok.userservice.dto.UserDto;
import org.astashonok.userservice.entity.User;

import java.util.UUID;

public interface UserService {

    UserDto create(User user);

    UserDto getById(UUID userId);
}
