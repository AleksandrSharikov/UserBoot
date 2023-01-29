package com.springboot.dao;

import com.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
 /*   List<User> findAll();
    User getById(int id);
    void removeById(int id);
   // void save(User user);
    void editUser(User user, int id);
*/
}
