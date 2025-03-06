package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.userDTO;
import com.sena.basic_crud.model.user;
import com.sena.basic_crud.repository.Iuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private Iuser data;

    public void save(userDTO userDTO){
        user user = convertToModel(userDTO);
        data.save(user);
    }

    public userDTO convertToDTO(user user){
        userDTO userDTO = new userDTO(
                0,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRegistration_date(),
                user.getCountry(),
                user.getProfile_image()
        );
        return userDTO;
    }

    public user convertToModel(userDTO userDTO){
        user user = new user(
                0,
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRegistration_date(),
                userDTO.getCountry(),
                userDTO.getProfile_image()
        );
        return user;
    }
}
