package com.maruf.simplereads.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maruf.simplereads.dto.LoginResponseDto;
import com.maruf.simplereads.dto.LoginUserDto;
import com.maruf.simplereads.dto.RegisterNewUserDto;
import com.maruf.simplereads.dto.ResponseDto;
import com.maruf.simplereads.dto.UserDto;
import com.maruf.simplereads.entity.User;
import com.maruf.simplereads.service.AuthService;
import com.maruf.simplereads.service.JwtService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthController {
    private final JwtService jwtService;
    private final AuthService authervice;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto<UserDto>> register(@RequestBody @Valid RegisterNewUserDto registerUserDto) {
        User registeredUser = authervice.signup(registerUserDto);
        UserDto user = UserDto.builder()
                .id(registeredUser.getId())
                .email(registeredUser.getEmail())
                .fullName(registeredUser.getFullName())
                .bio(registeredUser.getBio())
                .createdAt(registeredUser.getCreatedAt())
                .build();
        return new ResponseEntity<>(new ResponseDto<>(user, "success", HttpStatus.CREATED.value()), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<LoginResponseDto>> authenticate(@RequestBody @Valid LoginUserDto loginUserDto) {
        User authenticatedUser = authervice.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto responseDto = LoginResponseDto.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();

        return new ResponseEntity<>(new ResponseDto<>(responseDto, "success", HttpStatus.OK.value()),
                HttpStatus.OK);
    }
}
