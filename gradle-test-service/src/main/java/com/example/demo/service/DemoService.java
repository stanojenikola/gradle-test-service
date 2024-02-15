package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.exception.ErrorResponse;

import java.util.List;

public interface DemoService {
    List<UserDTO> getUsers();
    UserDTO saveUser(UserRequestDTO userRequestDTO);


}
