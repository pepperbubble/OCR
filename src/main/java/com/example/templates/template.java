package com.example.templates;

//import com.alibaba.fastjson.JSONArray;
import org.json.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;


public class template {
    //电流互感器实验报告
    public JSONArray json0(){
        String temp1="[\n" +
                "        {\n" +
                "            \"装置名称\": \"null\",\n" +
                "            \"location\": {\n" +
                "                \"x\": 85,\n" +
                "                \"y\": 120,\n" +
                "                \"width\": 130,\n" +
                "                \"height\": 35\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"项目名称\": \"null\",\n" +
                "            \"location\": {\n" +
                "                \"x\": 540,\n" +
                "                \"y\": 0,\n" +
                "                \"width\": 160,\n" +
                "                \"height\": 35\n" +
                "            }\n" +
                "        }\n" +
                "    ]";
        JSONArray template1_array =new JSONArray(temp1);
        return template1_array;
    }
}
