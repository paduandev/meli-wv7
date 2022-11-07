package br.dh.meli.auth.controller;

import br.dh.meli.auth.jwt.JwtTokenUtil;
import br.dh.meli.auth.model.ApiUser;
import br.dh.meli.auth.model.AuthUser;
import br.dh.meli.auth.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    ApiUserService service;

    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/new")
    public ResponseEntity<Void> insertUser(@RequestBody @Valid AuthUser authUser) {

        ApiUser apiUser = service.saveUser(authUser);
        if (apiUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthUser authUser) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authUser.getUsername(),  authUser.getPassword())
            );

            ApiUser user = (ApiUser) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);

            return ResponseEntity.ok().body(accessToken);

        } catch (Exception ex) {
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }
}
