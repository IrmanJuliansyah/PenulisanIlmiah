package com.penulisan.ilmiah.service;

import com.penulisan.ilmiah.domain.User;

/**
 * @author Irman Juliansyah
 */
public interface UserService {

    void saveUser(User user);

    void updatePasswordUser(User user);
}
