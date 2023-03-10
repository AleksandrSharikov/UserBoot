package com.springboot.service;

import com.springboot.dao.UserDao;
import com.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao){this.userDao = userDao;}
    @Override
    @Transactional(readOnly=true)
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional
    public void deletUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void editUser(User user, int id)  {

        userDao.findById(id)
                .ifPresent(u -> {u.setName(user.getName());
                                    u.setSurname(user.getSurname());
                                    u.setAge(user.getAge());});

    }
}
