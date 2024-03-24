package org.bs.car_rental.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.car_rental.dto.SignupRequest;
import org.bs.car_rental.dto.UserDto;
import org.bs.car_rental.services.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
        if (authService.hasUserWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("User already exixt", HttpStatus.NOT_ACCEPTABLE);
        UserDto createdUserDto = authService.createUser(signupRequest);
        if(createdUserDto == null)
            return new ResponseEntity<>("User not created !", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
    }
}
