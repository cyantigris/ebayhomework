package com.haoyan.homeworkEbayRest.utility;

import java.io.*;
import java.util.Base64;

import com.haoyan.homeworkEbayRest.service.impl.UserServiceImpl;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
    private static Logger logger = LoggerFactory.getLogger(Utils.class);
    public static JSONObject base64Decoder(String encoded){
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);

        String decodedString = new String(decodedBytes);
        logger.info("decoded：" + decodedString);
        return new JSONObject(decodedString);
    }

    public static boolean isAdmin(String encoded){
        JSONObject decode = base64Decoder(encoded);

        if(decode.getString("role").equals(RoleEnum.ADMIN.getRoleValue())){
            return true;
        }
        return false;
    }

    public static String GetAccessFile(){
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/src/main/resources/db/userAccess.txt";
        File file = new File(filePath);
        try{
            if (file.createNewFile()) {
                logger.info("file creation success");
            } else {
                logger.info("file exist");
            }
        } catch (IOException e){
            logger.error("write content fail:" + e.getMessage());
            return null;
        }

        return filePath;
    }

    public static FileReader GetAccessReader(){
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/src/main/resources/db/userAccess.txt";
        try{
            return new FileReader(filePath);
        } catch (FileNotFoundException e) {
            logger.error("write content fail:" + e.getMessage());
        }
        return null;
    }
}
