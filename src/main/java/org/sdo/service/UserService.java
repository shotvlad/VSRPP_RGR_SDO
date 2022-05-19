package org.sdo.service;

import org.sdo.entity.User;

public interface UserService extends Service<User> {
    User readByUsername(String username);
}
