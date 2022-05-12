package com.example.templates;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class template {
    //电流互感器实验报告
    public JSONArray json0(){
        JSONArray template1_array =new JSONArray();
        int i=0;
        for(;i<8;++i){
            JSONObject temp=new JSONObject();
            template1_array.add(temp);
        }
        template1_array.getJSONObject(0).put("项目名称",0);
        template1_array.getJSONObject(1).put("报告名称",1);
        template1_array.getJSONObject(2).put("装置",2);
        template1_array.getJSONObject(3).put("工号",3);
        template1_array.getJSONObject(4).put("装置名称",5);
        template1_array.getJSONObject(5).put("柜号",7);
        template1_array.getJSONObject(6).put("试验日期",9);
        template1_array.getJSONObject(7).put("设备型号",12);
        return template1_array;
    }

    public JSONArray json1(){
        JSONArray template1_array =new JSONArray();
        int i=0;
        for(;i<8;++i){
            JSONObject temp=new JSONObject();
            template1_array.add(temp);
        }
        template1_array.getJSONObject(0).put("装置名称",1);
        template1_array.getJSONObject(1).put("检票口",1);
        template1_array.getJSONObject(2).put("标准代号",5);
        template1_array.getJSONObject(3).put("标准代号",10);
        template1_array.getJSONObject(4).put("产品型号",14);
        template1_array.getJSONObject(5).put("产品代号",18);
        template1_array.getJSONObject(6).put("I_高压_电压",12);
        template1_array.getJSONObject(7).put("II_高压_电流",23);
        return template1_array;
    }
    public JSONArray json2(){
        JSONArray template1_array =new JSONArray();
        int i=0;
        for(;i<4;++i){
            JSONObject temp=new JSONObject();
            template1_array.add(temp);
        }
        template1_array.getJSONObject(0).put("银行名称",1);
        template1_array.getJSONObject(1).put("卡种",2);
        template1_array.getJSONObject(2).put("卡号",5);
        template1_array.getJSONObject(3).put("申请日期",10);
        return template1_array;
    }
}
