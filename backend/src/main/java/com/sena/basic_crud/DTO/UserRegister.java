package com.sena.basic_crud.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegister {
    private String name;
    private String email;
    private String password;
    private String country;
    private String profileImage;
}
