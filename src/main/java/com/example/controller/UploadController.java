package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.baiduAPI.GeneralBasic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.ocr.templates;


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
        String original_json;
        original_json= GeneralBasic.generalBasic(imgPath);
        String words_json=templates.use_templates(original_json,template);
        return words_json;
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

