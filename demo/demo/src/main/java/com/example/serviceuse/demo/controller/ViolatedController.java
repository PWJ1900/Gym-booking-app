package com.example.serviceuse.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViolatedController {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/violated")
    @ResponseBody
    public Integer violated(@RequestParam(name = "IDcard") String IDcard){
        String sql = "select Number from admin where IDcard="+"'"+IDcard+"'";
        String number = jdbcTemplate.queryForObject(sql,java.lang.String.class);
        System.out.println(number);
        return Integer.parseInt(number);

    }
}
