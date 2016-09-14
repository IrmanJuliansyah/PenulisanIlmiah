package com.penulisan.ilmiah.controller;

import com.penulisan.ilmiah.domain.User;
import com.penulisan.ilmiah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Irman Juliansyah
 */

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> register(@RequestBody User user) {
        userService.saveUser(user);

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("Success", Boolean.TRUE);
        stringObjectMap.put("Info", "Data Tersimpan");

        return stringObjectMap;
    }

}
