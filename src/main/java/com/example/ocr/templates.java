package com.example.ocr;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.baiduAPI.AuthService;
import com.example.templates.template;

public class templates {

    public static String use_templates(String org_json,String template){
        JSONObject jsonObject = JSONObject.parseObject(org_json);
        JSONArray org_words_json= jsonObject.getJSONArray("words_result");
        int num=jsonObject.getIntValue("words_result_num");
        for(int i=0;i<num;++i){
            org_words_json.getJSONObject(i).put("order",i);
        }
        System.out.println(org_words_json);
        template temp=new template();
        JSONArray tempArry=new JSONArray();
        switch (template) {
            case "0":
                tempArry=temp.json0();
                break;
            case "1":
                tempArry=temp.json1();
                break;
            case "2":
                tempArry=temp.json2();
                break;
        }

        for(int i=0;i<tempArry.size();++i){
            for(int j=0;j<org_words_json.size();++j){
            if(tempArry.getJSONObject(i).containsValue(org_words_json.getJSONObject(j).getIntValue("order"))){
                String new_key;
                String new_val;
                new_key=tempArry.getJSONObject(i).keySet().iterator().next();
                new_val=org_words_json.getJSONObject(j).getString("words");
                tempArry.getJSONObject(i).put(new_key,new_val);
                break;
            }
            }
        }
        return tempArry.toString();
    }
}

