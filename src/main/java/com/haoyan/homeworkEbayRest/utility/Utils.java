package com.haoyan.homeworkEbayRest.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

    public static String getAccessFile(){
        String filePath = getDbpath();
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
    public static List<Integer> getUserList(){
        List<Integer> res = new ArrayList<>();
        FileReader accessReader = getAccessReader();
        try {
            assert accessReader != null;
            try (BufferedReader reader = new BufferedReader(accessReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    JSONObject json = new JSONObject(line);
                     res.add(json.getInt("userId"));
                    }
                }
        } catch (IOException e) {
            logger.error("get user list fail:" + e.getMessage());
        }
        return res;
    }
    public static FileReader getAccessReader(){

        try{
            return new FileReader(getDbpath());
        } catch (FileNotFoundException e) {
            logger.error("write content fail:" + e.getMessage());
        }
        return null;
    }
    private static String getDbpath(){
        String projectPath = System.getProperty("user.dir");
        return  projectPath + "/src/main/resources/db/userAccess.txt";
    }
}
