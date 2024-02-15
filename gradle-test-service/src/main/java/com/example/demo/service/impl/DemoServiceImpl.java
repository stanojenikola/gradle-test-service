package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoServiceImpl implements DemoService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        var user = new UserDTO(100l, "Tom");
        var user2 = new UserDTO(2l, "Micky");

        return List.of(user, user2);
    }

    @Override
    public UserDTO saveUser(UserRequestDTO userRequestDTO) {
        User newUser = User.builder().name(userRequestDTO.getName()).jobsJson(userRequestDTO.getJobs().toString()).build();

        if (userRepository.findByName(userRequestDTO.getName()) != null) {
            log.info("user error happen");

            return null;
        }

        var savedUser = userRepository.save(newUser);
        var userDTO = new UserDTO(savedUser.getId(), savedUser.getName());

        return userDTO;
    }

}
