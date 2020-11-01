package com.appsdevelperblog.app.ws.ui.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdevelperblog.app.ws.exceptions.UserServiceException;
import com.appsdevelperblog.app.ws.ui.model.reponse.UserRest;
import com.appsdevelperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdevelperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdevelperblog.app.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "50") int limit, @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get users was called with page=" + page + " and limit=" + limit + " and sort=" + sort;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getUser(@PathVariable String userId) {

        if (true) {
            throw new UserServiceException("My Muru Excpetion");

        }
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest userRest = userService.createUser(userDetails);

        return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {

        UserRest userRest = users.get(userId);
        userRest.setFirstName(updateUserDetailsRequestModel.getFirstName());
        userRest.setLastName(updateUserDetailsRequestModel.getLastName());

        users.put(userId, userRest);

        return userRest;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }


}
