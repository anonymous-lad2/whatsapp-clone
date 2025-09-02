package com.happysat.whatsapp_clone.service;

import com.happysat.whatsapp_clone.exception.UserException;
import com.happysat.whatsapp_clone.modal.User;
import com.happysat.whatsapp_clone.request.UpdateUserRequest;

import java.util.List;

public interface UserService {

    public User findUserById(Integer id) throws UserException;

    public User findUserProfile(String jwt) throws UserException;

    public User updateUser(Integer userId, UpdateUserRequest req) throws UserException;

    public List<User> searchUser(String query);

}
