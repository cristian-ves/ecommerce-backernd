package com.alejo.controllers.auth.dto;

import com.alejo.entities.auth.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Integer id;
    private Role role;
    private String name;
    private String email;
    private Boolean suspended = false;
}
