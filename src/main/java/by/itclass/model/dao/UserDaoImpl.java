package by.itclass.model.dao;

import by.itclass.model.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    private SessionFactory factory;

    @Autowired
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> selectAllUsers() {
        try (var session = factory.openSession()){
            return session.createQuery("from User", User.class).list();
        }
    }
}