package com.example.controller;

//import com.alibaba.fastjson.JSONArray;
import org.json.JSONArray;
import com.example.baiduAPI.GeneralBasic;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.ocr.templates;
import com.example.tools.divide;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class UploadController {

    @Value("${file.upload.path}")
    private String path;

    @GetMapping("/")
    public String uploadPage(){
        return "upload";
    }


    public String ocr(String imgPath,String template){
        String ans="";
        JSONArray template_json=templates.get_templates(template);
        for(int i=0;i<template_json.length();++i){
            JSONObject location=new JSONObject(template_json.getJSONObject(i).get("location").toString());
            divide divide = new divide();
            divide.setX(Integer.parseInt(location.get("x").toString()));
            divide.setY(Integer.parseInt(location.get("y").toString()));
            divide.setWidth(Integer.parseInt(location.get("width").toString()));
            divide.setHeight(Integer.parseInt(location.get("height").toString()));
            divide.setSrcpath(imgPath);
            divide.setSubpath("E:\\JavaProject\\OCR\\picture\\temp.jpg");
            try {
                divide.cut();
                String cut_path=divide.getSubpath();
                String key =template_json.getJSONObject(i).keySet().iterator().next();
                template_json.getJSONObject(i).put(key,ocr_partial(cut_path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return template_json.toString();
    }

    public String ocr_partial(String path){
    JSONObject json=new JSONObject(GeneralBasic.generalBasic(path));
    json=json.getJSONArray("words_result").getJSONObject(0);
    return json.get("words").toString();
    }


    @RequestMapping("/upload")
//    @ResponseBody
    public String create(@RequestPart MultipartFile file, HttpServletRequest request, Model model) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = path +'/'+fileName;
        String template=request.getParameter("template");
        String result=ocr(filePath,template);
        model.addAttribute("result",result);

//        return ocr(filePath);
        return "result";
    }


}

