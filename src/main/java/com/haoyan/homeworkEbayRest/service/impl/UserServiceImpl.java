package com.haoyan.homeworkEbayRest.service.impl;

import com.haoyan.homeworkEbayRest.service.UserService;
import com.haoyan.homeworkEbayRest.utility.Utils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public boolean addUser(JSONObject userObj) {
        String filePath = Utils.getAccessFile();
        List<Integer> currentUser = Utils.getUserList();
        Integer userId = userObj.getInt("userId");

        if(currentUser.contains(userId)){
            logger.info("targeted user," +  " already in store");
            return false;
        }

        try {
            Files.write(Paths.get(filePath), userObj.toString().getBytes(), StandardOpenOption.APPEND);
            logger.info("write content success");
        } catch (IOException e) {
            logger.error("write content fail:" + e.getMessage());
        }

        return true;
    }

    @Override
    public boolean addResource(int userId, String resource) {
        FileReader accessReader = Utils.getAccessReader();
        try {
            assert accessReader != null;
            try (BufferedReader reader = new BufferedReader(accessReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    JSONObject json = new JSONObject(line);
                    if(json.getInt("userId") == userId){
                       JSONArray jsonArr =  json.getJSONArray("endpoint");
                        for (int i = 0; i < jsonArr.length(); i++) {
                            if(jsonArr.getString(i).equals(resource)){
                                logger.info("find resource success");
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.error("write content fail:" + e.getMessage());
        }
        return false;
    }
}
