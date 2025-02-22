package com.prog.springboot.service;

import com.prog.springboot.dao.UserDao;
import com.prog.springboot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl( UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(int id) {
        return userDao.findById(id);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(User updatedUser) {
        userDao.update(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userDao.deleteById(id);
    }
}
