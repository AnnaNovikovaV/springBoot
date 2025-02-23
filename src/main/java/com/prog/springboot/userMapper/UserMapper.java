package com.prog.springboot.userMapper;

import com.prog.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(User entity, User updatedUser) {
        entity.setName(updatedUser.getName());
        entity.setAge(updatedUser.getAge());
        entity.setEmail(updatedUser.getEmail());
        return entity;
    }
}
