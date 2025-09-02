package com.happysat.whatsapp_clone.service;

import com.happysat.whatsapp_clone.exception.UserException;
import com.happysat.whatsapp_clone.modal.User;
import com.happysat.whatsapp_clone.request.UpdateUserRequest;

import java.util.List;

public class UserServiceImplementation implements UserService{
    @Override
    public User findUserById(Integer id) {
        return null;
    }

    @Override
    public User findUserProfile(String jwt) {
        return null;
    }

    @Override
    public User updateUser(Integer userId, UpdateUserRequest req) throws UserException {
        return null;
    }

    @Override
    public List<User> searchUser(String query) {
        return List.of();
    }
}
