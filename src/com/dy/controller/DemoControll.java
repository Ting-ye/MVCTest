package com.dy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoControll {


    @RequestMapping("demo")
    public String demo(){
        System.out.println("执行Demo");
        return "main.jsp";
    }
    @RequestMapping("demo3")
    public String demo2(){
        System.out.println("333333");
        return "main.jsp";
    }
}
