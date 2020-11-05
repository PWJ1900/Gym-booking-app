package com.example.serviceuse.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DistinguishController {
    @RequestMapping("/distinguish")
    public String rt(@RequestParam(name = "phonenumber") String phonenumber){




        return "ok";


    }

}
