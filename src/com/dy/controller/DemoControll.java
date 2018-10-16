package com.dy.controller;

import com.dy.pojo.Demo;
import com.dy.pojo.DemoLi;
import com.dy.pojo.People;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    @RequestMapping("ScopeDemo1")
    public String ScopeDemo1(HttpServletRequest req, HttpSession sessionParam){
        req.setAttribute("request","request的值");
        HttpSession session=req.getSession();
        session.setAttribute("session","session的值");
        sessionParam.setAttribute("sessionParam","sessionParam的值");
        ServletContext application=req.getServletContext();
        application.setAttribute("application","application的值");
        return "index";
    }
    @RequestMapping("ScopeDemo2")
    public String ScopeDemo2(Map<String,Object> map){
        map.put("map","map的值");
        return "index";
    }
    @RequestMapping("ScopeDemo3")
    public String ScopeDemo3(Model model){
        model.addAttribute("model","model的值");
        return "index";
    }
    @RequestMapping("ScopeDemo4")
    public ModelAndView ScopeDemo4(){
        ModelAndView mav=new ModelAndView("/index.jsp");
        mav.addObject("mav","mav的值");
        return mav;
    }
    @RequestMapping("download")
    public void download(String filename,HttpServletRequest req, HttpServletResponse res) throws IOException {
        //设置响应流中文件恒下载
        res.setHeader("Content-Disposition","attachment;filename="+filename);
        //把二进制流加到响应体中
        ServletOutputStream os = res.getOutputStream();
        String path=req.getServletContext().getRealPath("files");
        File file=new File(path,filename);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        os.write(bytes);
        os.flush();
        os.close();
    }
    @RequestMapping("upload")
    public String upload(String name, MultipartFile fileName) throws IOException {
//        获取文件的名称 MultipartFile 的对象名 必须和<input type="file">的name属性名相同
        String file=fileName.getOriginalFilename();
        String suffix = file.substring(file.lastIndexOf("."));
//      if(suffix.equalsIgnoreCase(".png")){}
        String uuid = UUID.randomUUID().toString();
        FileUtils.copyInputStreamToFile(fileName.getInputStream(),new File("user:/"+uuid+suffix));
        System.out.println("name"+name);
        return "index";
    }
}
