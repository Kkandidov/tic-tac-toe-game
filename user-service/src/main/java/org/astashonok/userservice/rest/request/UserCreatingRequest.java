package org.astashonok.userservice.rest.request;

import lombok.Data;
import org.astashonok.userservice.model.Role;

@Data
public class UserCreatingRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}
