package com.dhruvdugar.userservice.service;

import com.dhruvdugar.userservice.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel createUser(UserModel userModel);

    UserModel getUser(Long userId);

    List<UserModel> getAllUsers();

    UserModel updateUser(Long userId, UserModel userModel);

    String deleteUser(Long userId);
}
