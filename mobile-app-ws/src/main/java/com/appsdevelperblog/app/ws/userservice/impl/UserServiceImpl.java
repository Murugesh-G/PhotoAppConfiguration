package com.appsdevelperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdevelperblog.app.ws.shared.Utils;
import com.appsdevelperblog.app.ws.ui.model.reponse.UserRest;
import com.appsdevelperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdevelperblog.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest userRest = new UserRest();
        userRest.setEmail(userDetails.getEmail());
        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastName(userDetails.getLastName());

        String userId = utils.generatedUserId();
        userRest.setUserId(userId);

        if (users == null) {
            users = new HashMap<>();
        }

        users.put(userId, userRest);
        return userRest;
    }
}
