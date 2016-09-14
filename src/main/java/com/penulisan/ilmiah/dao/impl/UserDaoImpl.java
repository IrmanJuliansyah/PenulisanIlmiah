package com.penulisan.ilmiah.dao.impl;

import com.penulisan.ilmiah.dao.UserDao;
import com.penulisan.ilmiah.domain.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Irman Juliansyah
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User loginUser(String email) {
        List<User> users = sessionFactory
                .getCurrentSession()
                .createQuery("select u from User u left join fetch u.userRoles pd where u.email = :email")
                .setParameter("email", email).list();

        if (users.get(0) != null) {
            return users.get(0);
        }

        return null;
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updatePasswordUser(User user) {
        sessionFactory
                .getCurrentSession()
                .createQuery("update User set password = :password, where email =:email")
                .setParameter("password", user.getPassword())
                .setParameter("email", user.getEmail())
                .executeUpdate();
    }

}
