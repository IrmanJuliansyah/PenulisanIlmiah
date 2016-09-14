package com.penulisan.ilmiah.service.impl;

import com.penulisan.ilmiah.dao.UserDao;
import com.penulisan.ilmiah.domain.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Irman Juliansyah
 */
@Service("userLoginService")
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        com.penulisan.ilmiah.domain.User user = userDao.loginUser(email);

        if (user == null) {
            return null;
        }

        List<GrantedAuthority> grantedAuthoritys = buildUserAuthority(user.getUserRoles());
        return buildUserForAuthentication(user, grantedAuthoritys);

    }

    private User buildUserForAuthentication(com.penulisan.ilmiah.domain.User user, List<GrantedAuthority> grantedAuthorities) {
        return new User(user.getEmail(), user.getPassword(), user.getEnable(), true, true, true, grantedAuthorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> grantedAuthoritys = userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRole())).collect(Collectors.toSet());
        return new ArrayList<>(grantedAuthoritys);
    }

}
