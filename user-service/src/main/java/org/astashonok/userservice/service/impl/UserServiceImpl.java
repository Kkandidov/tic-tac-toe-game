package org.astashonok.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.astashonok.userservice.dto.UserDto;
import org.astashonok.userservice.entity.User;
import org.astashonok.userservice.mapper.UserDtoMapper;
import org.astashonok.userservice.repository.UserRepository;
import org.astashonok.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    @Override
    public UserDto create(User user) {
        return userDtoMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getById(UUID userId) {
        return userRepository.findById(userId)
                .map(userDtoMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("User not found with user id: " + userId));
    }
}
