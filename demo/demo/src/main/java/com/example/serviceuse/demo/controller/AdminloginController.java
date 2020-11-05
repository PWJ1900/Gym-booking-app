package com.example.serviceuse.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminloginController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping("/adminlogin")
    public String useadmin(Model model, String account, String password){
       String SQLA = "select password from useadmin where account="+"'"+account+"'";
       String OutS = jdbcTemplate.queryForObject(SQLA,java.lang.String.class);
       if(OutS.equals(password.toString())){
           System.out.println(OutS);
           return "index";

       }
       else{
           model.addAttribute("display","账号或者密码输入错误！");
           return "startget";
       }

    }


}
