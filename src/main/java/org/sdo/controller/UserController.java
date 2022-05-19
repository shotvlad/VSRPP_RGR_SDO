package org.sdo.controller;

import org.sdo.entity.User;
import org.sdo.service.Service;
import org.sdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController extends AbstractController<User> {
    @Autowired
    private UserService service;

    @Override
    public UserService getService() {
        return service;
    }
}
