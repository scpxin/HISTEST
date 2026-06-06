package com.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.his.entity.User;
import com.his.mapper.UserMapper;
import com.his.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public String login(String username, String password) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username).eq(User::getPassword, password);
        User user = this.getOne(wrapper);
        if (user != null) {
            return "Bearer " + user.getId();
        }
        return null;
    }

    @Override
    public User getUserInfo(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String userId = token.substring(7);
            return this.getById(Long.parseLong(userId));
        }
        return null;
    }

    @Override
    public List<User> getUsersByRole(String role) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getRole, role).eq(User::getStatus, 1);
        return this.list(wrapper);
    }
}
