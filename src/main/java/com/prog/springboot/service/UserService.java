package com.prog.springboot.service;

import com.prog.springboot.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User findOne(int id);

    void delete(int id);

    void update(User updateUser);


}
