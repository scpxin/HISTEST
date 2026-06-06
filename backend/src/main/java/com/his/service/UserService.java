package com.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.his.entity.User;
import java.util.List;

public interface UserService extends IService<User> {
    String login(String username, String password);
    User getUserInfo(String token);
    List<User> getUsersByRole(String role);
}
