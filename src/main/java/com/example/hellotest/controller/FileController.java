package com.example.hellotest.controller;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
    //private static final String UPLOADED_FOLDER=System.getProperty("user.dir")+"/upload/";

    @PostMapping("/upload")
    public String upload(String name , MultipartFile file , HttpServletRequest request) throws IOException {
        System.out.println(name);
        System.out.println("文件大小："+file.getSize());
        //获取图片类型
        System.out.println(file.getContentType());
        //获取图片原始名称
        System.out.println(file.getOriginalFilename());
        //获取web服务器的运行目录
        String path =request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(file,path);
        return "上传成功";

    }

    public void saveFile(MultipartFile file, String path) throws IOException {
        File upDir=new File(path);
        //判断目录是否存在，不存在则创建
        if (!upDir.exists()){
            upDir.mkdir();
        }
        //
        File file1=new File(path+file.getOriginalFilename());
        file.transferTo(file1);//传入磁盘
    }
}
