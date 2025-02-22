package com.prog.springboot.dao;



import com.prog.springboot.model.User;

import java.util.List;

public interface UserDao {


    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);

    void update(User user);
}
