package com.haoyan.homeworkEbayRest.controller;

import com.haoyan.homeworkEbayRest.service.UserService;
import com.haoyan.homeworkEbayRest.utility.ResponseEnum;
import jakarta.annotation.Resource;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import static com.haoyan.homeworkEbayRest.utility.Utils.isAdmin;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/{resource}", method = RequestMethod.POST)
    public String resourceCheck(@RequestHeader("authInfo") String executorInfo,
                                @PathVariable String resource,
                                @RequestBody String userInfo){
        if(!isAdmin(executorInfo)){
            return ResponseEnum.INVALID.getMessage();
        }
        JSONObject json = new JSONObject(userInfo);
        if(userService.addResource(json.getInt("userId"), resource)){
            return ResponseEnum.SUCCESS.getMessage();
        }
        return ResponseEnum.FAILURE.getMessage();
    }

}
