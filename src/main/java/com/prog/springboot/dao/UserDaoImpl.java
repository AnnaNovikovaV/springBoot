package com.prog.springboot.dao;

import com.prog.springboot.dao.UserDao;
import com.prog.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
   private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findById(int id) {
        return Optional.ofNullable(entityManager.find(User.class, id)).orElse(null);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void deleteById(int id) {
        User user = findById(id);

        if (user == null) {
            throw new NullPointerException("User not found");
        }

        entityManager.remove(user);
        entityManager.flush();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
