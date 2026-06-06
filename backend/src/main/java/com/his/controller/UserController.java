package com.his.controller;

import com.his.common.Result;
import com.his.entity.User;
import com.his.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginRequest request) {
        String token = userService.login(request.username, request.password);
        if (token != null) {
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<User> getUserInfo(@RequestHeader("Authorization") String token) {
        User user = userService.getUserInfo(token);
        return Result.success(user);
    }

    @GetMapping("/doctors")
    public Result<List<User>> getDoctors() {
        List<User> doctors = userService.getUsersByRole("DOCTOR");
        return Result.success(doctors);
    }

    @GetMapping("/nurses")
    public Result<List<User>> getNurses() {
        List<User> nurses = userService.getUsersByRole("NURSE");
        return Result.success(nurses);
    }

    public static class LoginRequest {
        public String username;
        public String password;
    }
}
