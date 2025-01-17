package com.a1st.ecom.user.controller;

import com.a1st.ecom.user.request.UserRequest;
import com.a1st.ecom.user.response.UserResponse;
import com.a1st.ecom.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UserRequest userRequest) {
        userService.updateUser(userRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/exists/{user-id}")
    public ResponseEntity<Boolean> userExists(@PathVariable("user-id") String userId) {
        return ResponseEntity.ok(userService.userExistsById(userId));
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable("user-id") String userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("user-id") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
