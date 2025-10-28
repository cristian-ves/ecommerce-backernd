package com.alejo.controllers.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddEmployeeRequestDTO {
    private String name;
    private String email;
    private String password;
    private int roleId;
}
