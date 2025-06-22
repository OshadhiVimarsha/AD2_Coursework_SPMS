package com.spms.user.service;

import com.spms.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    public Optional<User> getUserById(Long id);

    public Optional<User> getUserByEmail(String email);

    public User createUser(User user);

    public User updateUser(Long id, User user);

    public boolean deleteUser(Long id);

    public boolean validateUser(String email, String password);
}
