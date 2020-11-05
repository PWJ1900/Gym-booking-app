package com.example.serviceuse.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
public class AppointmentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping(value = "/6654")
    public String welcome(Model model){
        return "ok";
    }


    @RequestMapping(value = "/appointedplace")
    @ResponseBody
    public String appointedplace(@RequestParam(name = "useid")String useid){
        String sql = "select appointedplace from admin where IDcard="+"'"+useid+"'";

        try {
            String place=(String)jdbcTemplate.queryForObject(sql, java.lang.String.class);
            return "预约场地："+place;
        }catch (Exception e){
            return "预约场地：未预约";
        }

    }

    @RequestMapping(value = "/appointedtime")
    @ResponseBody
    public String appointedtime(@RequestParam(name = "useid")String useid){
        String sql = "select appointedtime from admin where IDcard="+"'"+useid+"'";

        try {
            String place=(String)jdbcTemplate.queryForObject(sql, java.lang.String.class);
            return "预约时间："+place;
        }catch (Exception e){
            return "预约时间：未预约";
        }

    }

    @PostMapping(value = "/jsp/deleteit")
    public String updateSQL(Model model,String id,String Name,String Gender,String Number,String Password,String appointedplace,String appointedtime,String date,String IDcard,String phonenumber){
        System.out.println(id+Name+Gender);
        int number;
        number = Integer.parseInt(Number);
        number--;
        String sql3 = "update admin set Number="+"'"+String.valueOf(number)+"'"+"where Id="+"'"+id+"'";

        jdbcTemplate.execute(sql3);

        return "welcome";
    }
}
