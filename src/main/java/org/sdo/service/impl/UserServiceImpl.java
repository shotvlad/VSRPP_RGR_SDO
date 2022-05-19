package org.sdo.service.impl;

import org.sdo.entity.User;
import org.sdo.repository.UserRepository;
import org.sdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User readByUsername(String username) {
        return repository.findByUsername(username).get();
    }

    @Override
    public User read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<User> read() {
        return repository.findAll();
    }

    @Override
    public void save(User entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(User entity) {
        User user = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        user.setAuthority(entity.getAuthority());
        user.setMail(entity.getMail());
        user.setPassword(entity.getPassword());
        user.setUsername(entity.getUsername());
        repository.save(user);
    }
}
