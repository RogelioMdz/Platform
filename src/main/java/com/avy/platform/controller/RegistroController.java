package com.avy.platform.controller;

import com.avy.platform.entity.User;
import com.avy.platform.exception.SQLIntegrityConstraintViolationExceptionCustom;
import com.avy.platform.service.RegistroService;
import com.avy.platform.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @Autowired
    private Validate validate;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        validate.validateRegExUser(user);
        try {
            registroService.registro(user);
        } catch (DataIntegrityViolationException ex) {
            throw new SQLIntegrityConstraintViolationExceptionCustom("El nombre de usuario ya se encuentra registrado en sistema");
        } catch (Exception ex) {
            throw new RuntimeException("Error interno");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
