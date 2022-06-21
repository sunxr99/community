package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AphaController {


    @RequestMapping("/hello")
    @ResponseBody
    public String sayhello(){
        return "Hello Web";

    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration= request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("code"));
        //返回相应数据
        response.setContentType("text/html;charset=utf-8");
        try (            PrintWriter writer=response.getWriter();
        )
        {

            writer.write("<h1>牛客网<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //GET请求
    // /student?current=1&limit=20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10")int limit){
        System.out.println("---------------");
        System.out.println(current+"++++"+limit);
        return  "some students";
    }
    @RequestMapping(path = "student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";

    }
//Post请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "scusess";
    }
    //相应html数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("name","张三");
            modelAndView.addObject("age","30");
            modelAndView.setViewName("/demo/view");
            return modelAndView;
    }
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北大");
        model.addAttribute("age","80");
        return "/demo/view";
    }
    //相应json(异步请求)
    //java对象 ->json-> js对象
    @RequestMapping(path = "/emp" ,method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","张三");
        emp.put("age","23");
        emp.put("salary","8000");
        return emp;


    }

    @RequestMapping(path = "/emps" ,method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","张三");
        emp.put("age","23");
        emp.put("salary","8000");
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","张四");
        emp.put("age","23");
        emp.put("salary","1000");
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","张五");
        emp.put("age","93");
        emp.put("salary","7000");
        list.add(emp);
        return list;


    }





}
