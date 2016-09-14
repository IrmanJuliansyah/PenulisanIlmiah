package com.penulisan.ilmiah.service.impl;

import com.penulisan.ilmiah.dao.UserDao;
import com.penulisan.ilmiah.domain.User;
import com.penulisan.ilmiah.domain.UserRole;
import com.penulisan.ilmiah.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Irman Juliansyah
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void saveUser(User user) {

        //lakukan enkripsi password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserRole userRole = new UserRole();
        userRole.setUser(user);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);

        user.setUserRoles(userRoles);

        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void updatePasswordUser(User user) {
        User userCheck = userDao.loginUser(user.getEmail());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (user.getPassword().equals(userCheck.getPassword())) {
            user.setEmail(userCheck.getEmail());
            user.setPassword(userCheck.getPassword()); // tidak ganti password
            userDao.updatePasswordUser(user);
        } else if (bCryptPasswordEncoder.matches(user.getPassword(), userCheck.getPassword())) {
            user.setEmail(userCheck.getEmail());
            user.setPassword(userCheck.getPassword()); // tidak ganti password
            userDao.updatePasswordUser(user);
        } else {
            user.setEmail(userCheck.getEmail());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userDao.updatePasswordUser(user); //ganti password
        }
    }

}
