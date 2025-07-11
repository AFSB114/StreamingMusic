package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.RecoveryPassDTO;
import com.sena.basic_crud.DTO.TokenResponse;
import com.sena.basic_crud.DTO.UserLogin;
import com.sena.basic_crud.DTO.UserRegister;
import com.sena.basic_crud.model.RecoveryRequest;
import com.sena.basic_crud.model.Token;
import com.sena.basic_crud.model.User;
import com.sena.basic_crud.repository.IRecoveryRequest;
import com.sena.basic_crud.repository.IToken;
import com.sena.basic_crud.repository.IUser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUser userRepository;
    private final IToken tokenRepository;
    private final IRecoveryRequest recoveryRequestRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TemplateEngine templateEngine;
    private final MailService mailService;
    private final RecoveryRequestService recoveryRequestService;

    public TokenResponse register(UserRegister userRegister){
        User user = convertToModel(userRegister);
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(user, token);
        return new TokenResponse(token, refreshToken);
    }

    public TokenResponse login(UserLogin userLogin){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLogin.getEmail(),
                        userLogin.getPassword()
                )
        );
        Optional<User> optionalUser = userRepository.findByEmail(userLogin.getEmail());
        if(optionalUser.isEmpty()) throw new UsernameNotFoundException("Invalid email or password");
        User user = optionalUser.get();
        String token = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserToken(user);
        saveUserToken(user, token);
        return new TokenResponse(token, refreshToken);
    }

    public void revokeAllUserToken(User  user){
        List<Token> validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());
        if (validUserTokens.isEmpty()) throw new UsernameNotFoundException("Invalid email or password");
        for (Token token : validUserTokens) {
            token.setExpired(true);
            token.setLocked(true);
        }
        tokenRepository.saveAll(validUserTokens);
    }

    public TokenResponse refreshToken(String authHeader){
        if (authHeader == null || !authHeader.startsWith("Bearer ")) throw new IllegalArgumentException("Invalid bearer header");

        String refreshToken = authHeader.substring(7);
        String userEmail = jwtService.extractUserEmail(refreshToken);

        if (userEmail == null) throw new UsernameNotFoundException("Invalid email refresh token");

        Optional<User> optionalUser = userRepository.findByEmail(userEmail);
        if (optionalUser.isEmpty()) throw new UsernameNotFoundException("Invalid email refresh token");
        User user = optionalUser.get();

        if (!jwtService.isTokenValid(refreshToken, user)) throw new IllegalArgumentException("Invalid refresh token");

        String accessToken = jwtService.generateToken(user);
        revokeAllUserToken(user);
        saveUserToken(user, accessToken);
        return new TokenResponse(accessToken, refreshToken);
    }

    private void saveUserToken(User user, String jwtToken){
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .expired(false)
                .locked(false)
                .build();

        tokenRepository.save(token);

    }

    public User convertToModel(UserRegister userRegister){
        return new User(
                userRegister.getName(),
                userRegister.getEmail(),
                passwordEncoder.encode(userRegister.getPassword()),
                userRegister.getCountry(),
                userRegister.getProfileImage()
        );
    }

    public String recoveryPass(RecoveryPassDTO recoveryPass) {
        User user = userRepository.findByEmail(recoveryPass.getEmail()).orElse(null);
        if (user == null) throw new UsernameNotFoundException("Invalid email");

        System.out.println("Recovery Pass Request Get User");

        String token = jwtService.generateRecoveryPassToken(user);

        System.out.println("Recovery Pass Token Get User");

        recoveryRequestService.revokeAllUserToken(user);
        saveRecoveryPassToken(user, token);

        Context context = new Context();
        context.setVariable("userName", user.getName());
        context.setVariable("resetLink", "sadasdasdasdasdqwsdaveewf");
        context.setVariable("token", token);

        String emailHtml = templateEngine.process("RecoveryPassEmail.html", context);
        System.out.println("Begin Send Mail");
        mailService.sendMail(emailHtml, user.getEmail(), "Reset Password");

        return null;
    }

    private void saveRecoveryPassToken(User user, String jwtToken) {
        RecoveryRequest recoveryRequest =  RecoveryRequest.builder()
                .user(user)
                .token(jwtToken)
                .expired(false)
                .locked(false)
                .build();
        recoveryRequestRepository.save(recoveryRequest);
        System.out.println("Recovery request has been saved");
    }
}
