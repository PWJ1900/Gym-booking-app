package com.example.serviceuse.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class yzmController {
    private char arr[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private Random random;
    private String useit;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping(value = "/getphonenumber/")
    @ResponseBody
    public String yzm(@RequestParam(name = "phonenumber") String phonenumber) {
        System.out.println("手机号是："+phonenumber);
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            random = new Random();
            int index = random.nextInt(arr.length);
            stb.append(arr[index]);
        }
        useit = stb.toString();
        System.out.println("验证码是："+stb);
        String sql = "insert into admin (Name,Gender,Number,Password,appointedplace,IDcard,phonenumber) values ("+"'"+phonenumber+"'"+",'0','0','"+useit+"','543',"+"'"+phonenumber+"'"+","+"'"+phonenumber+"'"+")";
        jdbcTemplate.update(sql);
        return useit;
    }
}