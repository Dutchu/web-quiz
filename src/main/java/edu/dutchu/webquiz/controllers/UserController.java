package edu.dutchu.webquiz.controllers;


import edu.dutchu.webquiz.api.model.RegisterUserDTO;
import edu.dutchu.webquiz.api.model.RegisterUserResponseDTO;
import edu.dutchu.webquiz.services.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/register")
public class UserController {

    private final AppUserService userService;

    public UserController(AppUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<RegisterUserResponseDTO> register(@RequestBody @Valid RegisterUserDTO userToRegister) {
        RegisterUserResponseDTO dto = userService.registerUser(userToRegister);
        return ResponseEntity.ok(dto);
    }
}
