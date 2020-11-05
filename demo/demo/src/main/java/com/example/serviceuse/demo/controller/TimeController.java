package com.example.serviceuse.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void init(){

    }

    @RequestMapping(value = "gettime")
    @ResponseBody
    public String timereturn(@RequestParam(name = "appointedtime") String appointedtime,@RequestParam(name = "date") String date,@RequestParam(name = "phonenumber") String phonenumber){
          String SQL1 = "update admin set appointedtime="+"'"+appointedtime+"'"+"where phonenumber="+"'"+phonenumber+"'";
          String SQL2 = "update admin set date="+"'"+date+"'"+"where phonenumber="+"'"+phonenumber+"'";
          jdbcTemplate.update(SQL1);
          jdbcTemplate.update(SQL2);

        return appointedtime;
    }
}
