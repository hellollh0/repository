package com.example.hellotest.controller;

        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
//控制器可以接受客户端请求
public class HelloController {

    //http://127.0.0.1:8080/hello
    //http://127.0.0.1/hello?name=zhangsan&phone=123  参数传递
    @GetMapping("/hello")
    //浏览器以get的请求方式访问 hello()
    public  String hello(String name,String phone){
        return "hhh"+name+phone;
    }
}

