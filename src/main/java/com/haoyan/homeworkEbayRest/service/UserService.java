package com.haoyan.homeworkEbayRest.service;

import com.haoyan.homeworkEbayRest.entity.User;
import org.json.JSONObject;

import java.io.IOException;

public interface UserService {
    boolean addUser(JSONObject userObj);
    boolean addResource(int userId, String resource);
}
