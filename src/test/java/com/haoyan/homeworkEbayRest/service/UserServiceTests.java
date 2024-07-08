package com.haoyan.homeworkEbayRest.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;
    @Test
    void TestAddUser() throws JSONException {
        String targetUser = "{\"userId\":1235,\"endpoint\":[\"resource A\"]}\n";
        assertTrue(userService.addUser(new JSONObject(targetUser)));
    }
    @Test
    void TestAddResource(){
        Integer userId = 1235;
        String resource = "resource A";
        assertTrue(userService.addResource(userId, resource));
    }
}
