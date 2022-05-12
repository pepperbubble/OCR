package com.example.ocr;

//import com.alibaba.fastjson.JSONArray;
import org.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.baiduAPI.AuthService;
import com.example.templates.template;

public class templates {

    public static JSONArray get_templates(String template){
        JSONArray tempArry =new JSONArray();
        template temp=new template();
        switch (template) {
            case "0":
                tempArry=temp.json0();
                break;
        }
        return tempArry;
    }
}

