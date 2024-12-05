package com.dhruvdugar.userservice.service;


import com.dhruvdugar.userservice.entity.User;
import com.dhruvdugar.userservice.model.UserModel;
import com.dhruvdugar.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserModel createUser(UserModel userModel) {
        User user = userRepo.save(UserModelToUser(userModel));
        return UserToUserModel(user);
    }

    @Override
    public UserModel getUser(Long userId) {
        User user = userRepo.findById(userId).get();
        return UserToUserModel(user);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(this::UserToUserModel).toList();
    }

    @Override
    public UserModel updateUser(Long userId, UserModel userModel) {
        User user = userRepo.findById(userId).get();

        if(Objects.nonNull(userModel.getUsername()) && !("").equalsIgnoreCase(userModel.getUsername())){
            user.setUsername(userModel.getUsername());
        }

        if(Objects.nonNull(userModel.getEmail()) && !("").equalsIgnoreCase(userModel.getEmail())){
            user.setEmail(userModel.getEmail());
        }

        if(Objects.nonNull(userModel.getPasswordHash()) && !("").equalsIgnoreCase(userModel.getPasswordHash())){
            user.setPasswordHash(userModel.getPasswordHash());
        }

        if(Objects.nonNull(userModel.getFirstName()) && !("").equalsIgnoreCase(userModel.getFirstName())){
            user.setFirstName(userModel.getFirstName());
        }

        if(Objects.nonNull(userModel.getLastName()) && !("").equalsIgnoreCase(userModel.getLastName())){
            user.setLastName(userModel.getLastName());
        }

        if(Objects.nonNull(userModel.getPhone()) && !("").equalsIgnoreCase(userModel.getPhone())){
            user.setPhone(userModel.getPhone());
        }

        if(Objects.nonNull(userModel.getRole()) && !("").equalsIgnoreCase(userModel.getRole())){
            user.setRole(userModel.getRole());
        }

        if(Objects.nonNull(userModel.getProfilePicture()) && !("").equalsIgnoreCase(userModel.getProfilePicture())){
            user.setProfilePicture(userModel.getProfilePicture());
        }

        userRepo.save(user);

        return UserToUserModel(user);

    }

    @Override
    public String deleteUser(Long userId) {
        User user = userRepo.findById(userId).get();
        userRepo.deleteById(userId);
        return "User with id "+userId+" deleted successfully";
    }

    protected User UserModelToUser(UserModel userModel){
        User user = new User();
        user.setUserId(userModel.getUserId());
        user.setUsername(userModel.getUsername());
        user.setEmail(userModel.getEmail());
        user.setPasswordHash(userModel.getPasswordHash());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPhone(userModel.getPhone());
        user.setRole(userModel.getRole());
        user.setProfilePicture(userModel.getProfilePicture());
        return user;
    }

    protected UserModel UserToUserModel(User user){
        UserModel userModel = new UserModel();
        userModel.setUserId(user.getUserId());
        userModel.setUsername(user.getUsername());
        userModel.setEmail(user.getEmail());
        userModel.setPasswordHash(user.getPasswordHash());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setPhone(user.getPhone());
        userModel.setRole(user.getRole());
        userModel.setProfilePicture(user.getProfilePicture());
        return userModel;
    }


}
