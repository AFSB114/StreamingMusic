package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.userDTO;
import com.sena.basic_crud.model.user_account;
import com.sena.basic_crud.repository.Iuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private Iuser data;

    public void save(userDTO userDTO){
        user_account user_account = convertToModel(userDTO);
        data.save(user_account);
    }

    public userDTO convertToDTO(user_account user){
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

    public user_account convertToModel(userDTO userDTO){
        user_account user = new user_account(
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
