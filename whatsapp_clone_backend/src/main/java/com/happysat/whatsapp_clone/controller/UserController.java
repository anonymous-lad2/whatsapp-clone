package com.happysat.whatsapp_clone.controller;

import com.happysat.whatsapp_clone.exception.UserException;
import com.happysat.whatsapp_clone.modal.User;
import com.happysat.whatsapp_clone.request.UpdateUserRequest;
import com.happysat.whatsapp_clone.response.ApiResponse;
import com.happysat.whatsapp_clone.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization") String token) throws UserException {

        User user = userService.findUserProfile(token);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{query}")
    public ResponseEntity<List<User>> searchUserHandler(@PathVariable("query") String q){
        List<User> users = userService.searchUser(q);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateUserHandler(@RequestBody UpdateUserRequest req, @RequestHeader("Authorization") String token) throws UserException {

        User user = userService.findUserProfile(token);
        userService.updateUser(user.getId(), req);

        ApiResponse res = new ApiResponse("user updated successfully", true);

        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }
}
