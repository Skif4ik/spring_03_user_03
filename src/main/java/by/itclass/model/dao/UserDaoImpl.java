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
            return session.createQuery("from User", User.class).list(); //запрос хибернейта
        }
    }

    @Override
    public void removeById(int userId) {
        try(var session = factory.openSession()) {
            var transaction = session.beginTransaction();
            var user = session.get(User.class, userId); //получаем юзера которого будем удалять
            session.delete(user);
            transaction.commit();
        }
    }

    @Override
    public void insert(User user) {
        try (var session = factory.openSession()) {
            var transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();//сохраняем транзакцию в хибернейте
        }
    }

    @Override
    public void update(User user) {
        try (var session = factory.openSession()){
            var transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }


}