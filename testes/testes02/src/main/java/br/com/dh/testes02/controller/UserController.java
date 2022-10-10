package br.com.dh.testes02.controller;

import br.com.dh.testes02.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public ResponseEntity<UserDto> newUser(@Valid @RequestBody UserDto userDto) {

        return ResponseEntity.ok(userDto);
    }
 }
