package com.vgtstptlk.simaproject.controller;

import com.vgtstptlk.simaproject.dto.Token;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/login")
    Token login(String login, String password) {
        return null;
    }
}
