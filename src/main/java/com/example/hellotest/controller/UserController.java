package com.example.hellotest.controller;

import com.example.hellotest.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        //因为要动态显示ID,所以加上注解@PathVariable
        System.out.println(id);
        return "根据用户ID获取信息";
    }
    @PostMapping("/user")
    public String save(User user){
        return "添加用户";
    }
    @PutMapping("/user")
    public String put(User user){
        return "更新用户";
    }
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable int id){
        System.out.println(id);
        return "根据用户ID删除信息";
    }
}
