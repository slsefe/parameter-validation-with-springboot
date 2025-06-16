package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.converter.UserConvertor;
import org.example.controller.dto.UserDTO;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.validator.CreateGroup;
import org.example.validator.UpdateGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Validated(CreateGroup.class) @RequestBody UserDTO userDTO) {
        User user = UserConvertor.INSTANCE.UserDTOtoUser(userDTO);
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("update")
    public ResponseEntity<User> update(@Validated(UpdateGroup.class) @RequestBody UserDTO userDTO) {
        User user = UserConvertor.INSTANCE.UserDTOtoUser(userDTO);
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }
}
