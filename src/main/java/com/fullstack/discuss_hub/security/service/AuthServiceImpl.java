package com.fullstack.discuss_hub.security.service;


import com.fullstack.discuss_hub.exception.LoginAttemptException;
import com.fullstack.discuss_hub.security.dto.request.LoginRequest;
import com.fullstack.discuss_hub.security.dto.response.LoginResponse;
import com.fullstack.discuss_hub.feature.user.enums.Role;
import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.user.model.UserModel;
import com.fullstack.discuss_hub.feature.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.fullstack.discuss_hub.security.service.LoginAttemptServiceImpl.expirationTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoginAttemptService loginAttemptService;


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return this.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @Override
    public LoginResponse registerUser(UserModel userModel) {
        User user = User.builder()
                .name(userModel.getName())
                .email(userModel.getEmail())
                .password(passwordEncoder.encode(userModel.getPassword()))
                .dateOfBirth(userModel.getDateOfBirth())
                .gender(userModel.getGender())
                .role(Role.USER)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
        userRepository.save(user);

        return authenticate(userModel.getEmail(), userModel.getPassword());
    }

    private LoginResponse authenticate(String email, String password){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
            loginAttemptService.resetAttempt(email);
            return LoginResponse.builder()
                    .jwtToken(jwtService.generateToken(authentication))
                    .role(authentication.getAuthorities().iterator().next().getAuthority())
                    .build();
        } catch (BadCredentialsException ex) {
            loginAttemptService.handleLoginAttempt(email);
            throw new BadCredentialsException("Invalid username or password! Please try again.");
        } catch (LockedException ex) {
            throw new LoginAttemptException(expirationTime);
        }
    }
}
