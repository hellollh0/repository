package com.example.hellotest.controller;

import com.example.hellotest.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamController {

    @RequestMapping(value = "/getTest1", method = RequestMethod.GET)
    public String getTest1() {
        return "Get请求";
    }

    @RequestMapping(value = "/getTest2", method = RequestMethod.GET)
    //http://127.0.0.1/getTest2?name=zhangsan&phone=13999999999
    public String getTest2(String name, String phone) {
        System.out.println("name" + name);
        System.out.println("phone" + phone);
        return "Get请求" + name + phone;
    }

    @RequestMapping(value = "/getTest3", method = RequestMethod.GET)
    //http://127.0.0.1/getTest3?nikename=zhangsan
    public String getTest3(@RequestParam(value = "name", required = false) String name) {
        /*参数名对应不上(nikename与name)，可加注解@RequestParam(参数映射)，加上该注解后必须要传递参数，否则浏览器将报400错误
        (@RequestParam(value = "name") String name)

        加上required=false,即为可选，及不传递参数也可访问http://127.0.0.1/getTest3,不会报错
        (@RequestParam(value = "name",required = false) String name)

         */
        System.out.println("name" + name);
        return "Get请求";
    }

    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    public String postTest1(){
        return "Post请求";
    }

    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public  String postTest2(String name){
        System.out.println("name:"+name);
        return "Post请求";
    }


    @RequestMapping(value = "/postTest3",method = RequestMethod.POST)
    public  String postTest3(User user){
        //将参数封装在一个对象（user）里面
        System.out.println(user);
        return "Post请求";
    }

    @RequestMapping(value = "/postTest4",method = RequestMethod.POST)
    public  String postTest4(@RequestBody User user){
        //将参数封装在一个对象（user）里面,传递的是json格式，需要注解@RequestBody
        System.out.println(user);
        return "Post请求";
    }

    @GetMapping("/test/**")
    public String test(){
        return "通配符请求";
    }

    @GetMapping("/test1/*")
    public String test1(){
        return "通配符请求";
    }

}
