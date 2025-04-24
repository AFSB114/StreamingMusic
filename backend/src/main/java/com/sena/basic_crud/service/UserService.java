package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.UserDTO;
import com.sena.basic_crud.model.User;
import com.sena.basic_crud.projection.UserView;
import com.sena.basic_crud.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private IUser data;

    public ResponseDTO save(UserDTO userDTO){
        ResponseDTO res;
        List<String> errors = validateUser(userDTO);
        if (errors != null && !errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            User user = convertToModel(userDTO);
            data.save(user);
            res = ResponseDTO.ok("User saved successfully");
        }
        return res;
    }

    public List<UserView> findAll(){
        return data.findAllBy();
    }

    public ResponseDTO findById(int id){
        ResponseDTO res;
        var user = data.findById(id);
        if (user.isPresent()) {
            res = ResponseDTO.ok("User found successfully", user.get());
        } else {
            res = ResponseDTO.error("User not found");
        }
        return res;
    }

    public ResponseDTO delete(int id){
        ResponseDTO res;
        if (data.findById(id).isPresent()) {
            data.deleteById(id);
            res = ResponseDTO.ok("User deleted successfully");
        } else {
            res = ResponseDTO.error("User not found");
        }
        return res;
    }

    public ResponseDTO update(int id, UserDTO userDTO){
        ResponseDTO res;
        Optional<User> optionalUser = data.findById(id);
        if (!optionalUser.isPresent()) {
            res = ResponseDTO.error("This user don't exist in the database");
        }  else {
            User currentUser = optionalUser.get();

            currentUser.setName((userDTO.getName() != null) ? userDTO.getName() : currentUser.getName());
            currentUser.setEmail((userDTO.getEmail() != null) ? userDTO.getEmail() : currentUser.getEmail());
            currentUser.setPassword((userDTO.getPassword() != null) ? userDTO.getPassword() : currentUser.getPassword());
            currentUser.setCountry((userDTO.getCountry() != null) ? userDTO.getCountry() : currentUser.getCountry());
            currentUser.setProfileImage((userDTO.getProfileImage() != null) ? userDTO.getProfileImage() : currentUser.getProfileImage());

            data.save(currentUser);

            res = ResponseDTO.ok("User updated successfully");
        }

        return res;
    }

    public List<String> validateUser(UserDTO userDTO) {
        List<String> errors = new ArrayList<>();

        // Validar nombre
        if (userDTO.getName() == null || userDTO.getName().trim().isEmpty()) {
            errors.add("El nombre es obligatorio");
        } else if (userDTO.getName().length() > 255) {
            errors.add("El nombre no puede exceder los 255 caracteres");
        }

        // Validar email
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
            errors.add("El email es obligatorio");
        } else if (userDTO.getEmail().length() > 255) {
            errors.add("El email no puede exceder los 255 caracteres");
        } else if (!isValidEmail(userDTO.getEmail())) {
            errors.add("El formato del email no es válido");
        }

        // Validar contraseña
        if (userDTO.getPassword() == null || userDTO.getPassword().trim().isEmpty()) {
            errors.add("La contraseña es obligatoria");
        } else if (userDTO.getPassword().length() > 255) {
            errors.add("La contraseña no puede exceder los 255 caracteres");
        } else if (userDTO.getPassword().length() < 8) {
            errors.add("La contraseña debe tener al menos 8 caracteres");
        }

        // Validar país (opcional)
        if (userDTO.getCountry() != null && userDTO.getCountry().length() > 100) {
            errors.add("El país no puede exceder los 100 caracteres");
        }

        // Validar imagen de perfil (opcional)
        if (userDTO.getProfileImage() != null && userDTO.getProfileImage().length() > 255) {
            errors.add("La ruta de la imagen de perfil no puede exceder los 255 caracteres");
        }

        return errors;
    }

    /**
     * Valida el formato de un email
     * @param email Email a validar
     * @return true si el formato es válido, false en caso contrario
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public User convertToModel(UserDTO userDTO){
        User user = new User(
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getCountry(),
                userDTO.getProfileImage()
        );
        return user;
    }
}
