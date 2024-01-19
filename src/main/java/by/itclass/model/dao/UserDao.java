package by.itclass.model.dao;

import by.itclass.model.entities.User;

import java.util.List;

public interface UserDao {
    List<User> selectAllUsers();
    void removeById(int userId);
    void insert(User user);
    void update(User user);
}
