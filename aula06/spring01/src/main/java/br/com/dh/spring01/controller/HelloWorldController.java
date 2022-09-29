package br.com.dh.spring01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@CrossOrigin("*")
public class HelloWorldController {

    @GetMapping
    public String getHello() {
        return "Olá Mundo!";
    }

    @GetMapping("/nome/{nome}")
    public String getHello(@PathVariable String nome) {
        return "Olá " + nome + "!";
    }

}
