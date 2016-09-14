package com.penulisan.ilmiah.dao;

import com.penulisan.ilmiah.domain.User;

/**
 * @author Irman Juliansyah
 */
public interface UserDao {

    User loginUser(String email);

    void saveUser(User user);

    void updatePasswordUser(User user);

}
