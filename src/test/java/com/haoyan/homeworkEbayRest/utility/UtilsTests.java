package com.haoyan.homeworkEbayRest.utility;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UtilsTests {
    private String TESTSTRING = "ewogICAgICAgICAgInVzZXJJZCI6MTIzNDU2LAogICAgICAgICAgImFjY291bnROYW1lIjogIlRlc3RVc2VyIiwKICAgICAgICAgICJyb2xlIjogImFkbWluIgogICB9";
    @Test
    void TestBase64Decoder() throws JSONException {
        JSONObject json =  Utils.base64Decoder(TESTSTRING);
        assertEquals("TestUser",json.getString("accountName"));
    }
    @Test
    void TestIsAdmin(){
        JSONObject json =  Utils.base64Decoder(TESTSTRING);
        assertTrue(Utils.isAdmin(TESTSTRING));
    }
    @Test
    void TestGetAccessFile(){
        String filePath = Utils.GetAccessFile();
        assertTrue(filePath.length() > 0);
    }
    @Test
    void TestGetAccessReader(){

        assertTrue(Utils.GetAccessReader() != null);
    }
}
