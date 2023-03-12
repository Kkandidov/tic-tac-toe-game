package org.astashonok.userservice.dto;

import lombok.Data;
import org.astashonok.userservice.model.Role;

import java.util.UUID;

@Data
public class UserDto {

    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
