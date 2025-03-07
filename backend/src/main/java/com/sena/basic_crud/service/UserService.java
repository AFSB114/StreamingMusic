package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.UserDTO;
import com.sena.basic_crud.model.User;
import com.sena.basic_crud.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUser data;

    public void save(UserDTO userDTO){
        User user = convertToModel(userDTO);
        data.save(user);
    }

    public User convertToModel(UserDTO userDTO){
        User user = new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRegistrationDate(),
                userDTO.getCountry(),
                userDTO.getProfileImage()
        );
        return user;
    }

    public UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRegistrationDate(),
                user.getCountry(),
                user.getProfileImage()
        );
        return userDTO;
    }
}
