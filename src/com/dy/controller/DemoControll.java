package com.dy.controller;

import com.dy.pojo.Demo;
import com.dy.pojo.DemoLi;
import com.dy.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoControll {


    @RequestMapping("demo")
    public String demo(){
        System.out.println("执行Demo");
        return "main.jsp";
    }
    @RequestMapping("demo3")
    public String demo3(@RequestParam("username") String name,@RequestParam(defaultValue = "2") int age){
        System.out.println("name="+name+"  "+age);
        return "main.jsp";
    }
    @RequestMapping("demo4")
    public String demo4(@RequestParam("username") String name,@RequestParam(required = true) int age){
        System.out.println("require=true表示必须传入age参数 不能为空  Integer也可以接受null值 int等不行");
        return "main.jsp";
    }
    @RequestMapping("demo5")
    public String demo5(@RequestParam("username") String name,int age,@RequestParam("hover") List<String> hover){
        System.out.println(name+"  "+age+"   "+hover+"1  1");
        return "main.jsp";
    }
    @RequestMapping("demo6")
    public String demo6(Demo demo){
        System.out.println(demo);
        return "main.jsp";
    }
    @RequestMapping("demo7")
    public String demo7(DemoLi demoLi){
        System.out.println(demoLi);
        return "main.jsp";
    }
    @RequestMapping("demo8/{name}/{id}")
    public String demo8(@PathVariable String name,@PathVariable("id") int age){
        System.out.println(name+age);
        return "/main.jsp";
    }
    @RequestMapping("demo9")
    public String demo9(){
        System.out.println("重定向（缺省或者前面加forward:为重定向）");
        return "redirect:/main.jsp";
    }
    @RequestMapping("demo10")
    public String demo10(){
        return "forward:demo11";
    }
    @RequestMapping("demo11")
    public String demo11(){
        System.out.println("利用自定义视图解析器 在前面加forward:或者redirect: 就不是执行自定义视图解析器");
        return "main";
    }
    @RequestMapping("demo12")
    @ResponseBody
    public People demo12(){
        People p=new People();
        p.setAge(23);
        p.setName("超出");
        return p;
    }
    @RequestMapping(value = "demo13",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String demo13(){
        System.out.println("控制器中只要返回值不是void，那么默认return都是跳转 除非加此处RequestMapping备注");
        return "中文";
    }
}
