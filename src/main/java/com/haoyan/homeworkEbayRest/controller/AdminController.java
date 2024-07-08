package com.haoyan.homeworkEbayRest.controller;

import com.haoyan.homeworkEbayRest.service.UserService;

import com.haoyan.homeworkEbayRest.utility.ResponseEnum;
import jakarta.annotation.Resource;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import static com.haoyan.homeworkEbayRest.utility.Utils.isAdmin;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserService userService;
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUser(@RequestHeader("authInfo") String executorInfo,
                          @RequestBody String targetUser){
        if(!isAdmin(executorInfo)){
            return ResponseEnum.INVALID.getMessage();
        }

        if(userService.addUser(new JSONObject(targetUser))){
            return ResponseEnum.SUCCESS.getMessage();
        }
        return ResponseEnum.FAILURE.getMessage();
    }
}
