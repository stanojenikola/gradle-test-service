package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.DemoService;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/demo")
@AllArgsConstructor
public class DemoController {

    public final DemoService demoService;

    @GetMapping("/{accountId}")
    public ResponseEntity<List<UserDTO>> getUsers(@Pattern(regexp = "\\d+", message = "Please use a number") @PathVariable String accountId) {
        var users = demoService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

        var user = demoService.saveUser(userRequestDTO);
        if (user == null) {
            throw new UserNotFoundException("User already in stored");
        }
        return ResponseEntity.ok(user);
    }
}
