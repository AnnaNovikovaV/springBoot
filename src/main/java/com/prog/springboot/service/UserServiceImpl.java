package com.prog.springboot.service;

import com.prog.springboot.model.User;
import com.prog.springboot.repository.UserRepository;
import com.prog.springboot.userMapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    UserRepository repository;
    UserMapper mapper;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
    }

    @Transactional
    public void update(User updatedUser) {
        User user = findById(updatedUser.getId());
        repository.save(mapper.toUser(user, updatedUser));
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

}
