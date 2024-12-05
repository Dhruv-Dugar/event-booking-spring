package com.dhruvdugar.userservice.controller;


import com.dhruvdugar.userservice.model.APIResponse;
import com.dhruvdugar.userservice.model.UserModel;
import com.dhruvdugar.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<APIResponse> createUser(@RequestBody UserModel userModel){
        UserModel userModel1 = userService.createUser(userModel);
        return ResponseEntity.ok(new APIResponse(true, "User created successfully", userModel1));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUser(@PathVariable("userId") Long userId){
        UserModel userModel1 = userService.getUser(userId);
        return ResponseEntity.ok(new APIResponse(true, "User fetched successfully", userModel1));
    }


    @GetMapping
    public ResponseEntity<APIResponse> getAllUsers(){
        return ResponseEntity.ok(new APIResponse(true, "All Users fetched successfully", userService.getAllUsers()));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<APIResponse> updateUser(@PathVariable("userId") Long userId, @RequestBody UserModel userModel){
        UserModel updatedUser = userService.updateUser(userId, userModel);
        return ResponseEntity.ok(new APIResponse(true, "User updated successfully", updatedUser));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<APIResponse> deleteUser(@PathVariable("userId") Long userId){
        String result = userService.deleteUser(userId);
        return ResponseEntity.ok(new APIResponse(true, "User deleted successfully", null));
    }

}
