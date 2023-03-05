package org.astashonok.userservice.rest;

import lombok.RequiredArgsConstructor;
import org.astashonok.userservice.dto.UserDto;
import org.astashonok.userservice.mapper.UserCreatingRequestMapper;
import org.astashonok.userservice.rest.request.UserCreatingRequest;
import org.astashonok.userservice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserCreatingRequestMapper userCreatingRequestMapper;

    @PostMapping
    public UserDto create(UserCreatingRequest userCreatingRequest) {
        return userService.create(userCreatingRequestMapper.toEntity(userCreatingRequest));
    }
}
