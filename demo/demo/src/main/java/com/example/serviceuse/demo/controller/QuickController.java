package com.example.serviceuse.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class QuickController {
    private Integer Bcount = 0;
    private Integer Scount = 0;
    private Integer Ycount = 0;
    private Integer Qcount = 0;
    private Boolean pd = false;

//    @RequestMapping("/quick")
//    @ResponseBody
//    public String quick(){
//        return "hello springboot";
//    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping(value = "/welcome")
    public String welcome(Model model){
////        String sql = "select * from admin";
//
//        jdbcTemplate.execute(sql);
//
////        String sql2 = "update admin set Name ="+Name.toString()+"where Number = "+id.toString();
////        jdbcTemplate.execute(sql2);
//        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
//        for(Map<String,Object> map:list){
//            Set<Map.Entry<String,Object>> entries = map.entrySet();
//            if(entries != null) {
//                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
//                while(iterator.hasNext( )) {
//                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
//                    String key = entry.getKey( );
//                    Object value = entry.getValue();
//                    model.addAttribute(key,value);
////                    System.out.println(key+":"+value);
//                }
//            }
//        }
        return "welcome";
    }

    @RequestMapping(value = "/demo/")
    @ResponseBody
    public Integer demo(@RequestParam(name = "IDcard")String IDcard,@RequestParam(name = "username") String username ,@RequestParam(name = "arrivetime") String arrivetime,@RequestParam(name = "leavetime") String leavetime){
        System.out.println(username);
        System.out.println(arrivetime);
        System.out.println(leavetime);
        String sqlA = "update admin set appointedplace="+"'"+username+"'"+"where IDcard="+"'"+IDcard+"'";
        String sqlB = "update admin set appointedtime="+"'"+arrivetime+"'"+"where IDcard="+"'"+IDcard+"'";
        String sqlC = "update admin set date="+"'"+leavetime+"'"+"where IDcard="+"'"+IDcard+"'";

        String sqlD = "select Number from admin where IDcard="+"'"+IDcard+"'";
        String Numberusestring = jdbcTemplate.queryForObject(sqlD,java.lang.String.class);
        Integer numberusestring = Integer.parseInt(Numberusestring);
        numberusestring++;
        String sqlE = "update admin set Number=" + "'" + numberusestring + "'"+"where IDcard=" + "'" + IDcard + "'";
        jdbcTemplate.update(sqlE);

        jdbcTemplate.update(sqlA);
        jdbcTemplate.update(sqlB);
        jdbcTemplate.update(sqlC);
        if(username.equals("篮球场") ){
            Bcount++;
            return Bcount;
        }
        if(username.equals("游泳馆")){
            Scount++;
            return Scount;

        }
        if(username.equals("瑜伽房")){
            Ycount++;
            return Ycount;

        }
        if(username.equals("器材室")){
            Qcount++;
            return Qcount;

        }
        else{
            return 0;}
//        return password;
//        abc();

    }
    @RequestMapping(value = "/pagereturn/")
    @ResponseBody
    public Integer pagereturn(@RequestParam(name = "Name") String Name ){

        if(Name.equals("篮球场") ){
            return Bcount;
        }
        if(Name.equals("游泳馆")){
            return Scount;

        }
        if(Name.equals("瑜伽房")){
            return Ycount;

        }
        if(Name.equals("器材室")){
            return Qcount;

        }
        else{
            return 0;}
//        return password;
//        abc();

    }
    
//    public String abc(@RequestParam){
//        return "hello";
//    }
    @RequestMapping(value= "/solution/")
    @ResponseBody//写实况返回
    public Integer use(@RequestParam(name = "thing")String thing){
        if(thing.equals("瑜伽房"))
            return Ycount;
        else if(thing.equals("游泳馆"))
            return Scount;
        else if(thing.equals("篮球场"))
            return Bcount;
        else
            return Qcount;

    }

    @PostMapping(value = "/jsp/register")
    public String hallowed(Model model, String name){
        model.addAttribute("瑜伽房",Ycount);
        model.addAttribute("游泳馆",Scount);
        model.addAttribute("篮球场",Bcount);
        model.addAttribute("器材室",Qcount);
//        System.out.println(name);
        return "index";
    }

    @PostMapping(value = "/jsp/jstdo")
    public String justdo(Model model, String name){
        System.out.println(name);
        String sq2 = "SELECT * from admin where Name="+ "'"+name+"'";
        jdbcTemplate.execute(sq2);
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sq2);
        for(Map<String,Object> map:list){
            Set<Map.Entry<String,Object>> entries = map.entrySet();
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    String key = entry.getKey( );
                    Object value = entry.getValue();
                    model.addAttribute(key,value);
//                    System.out.println(key+":"+value);
                }
            }
        }
        return "welcome";
    }
    @PostMapping(value = "/jsp/updateSQL")
    public String updateSQL(Model model,String id,String Name,String Gender,String Number,String Password,String appointedplace,String appointedtime,String date,String IDcard,String phonenumber){
        System.out.println(id+Name+Gender);
        String sql3 = "update admin set Name="+"'"+Name+"'"+"where Id="+"'"+id+"'";
        String sql4 = "update admin set Gender="+"'"+Gender+"'"+"where Id="+"'"+id+"'";
        String sql5 = "update admin set Password="+"'"+Password+"'"+"where Id="+"'"+id+"'";
        String sql6 = "update admin set phonenumber="+"'"+phonenumber+"'"+"where Id="+"'"+id+"'";
        String sql7 = "update admin set appointedplace="+"'"+appointedplace+"'"+"where Id="+"'"+id+"'";

        jdbcTemplate.execute(sql3);
        jdbcTemplate.execute(sql4);
        jdbcTemplate.execute(sql5);
        jdbcTemplate.execute(sql6);
        jdbcTemplate.execute(sql7);

        return "welcome";
    }

    @PostMapping("/signin")
    public String signin(Model model,String arrive){//此处为打卡获取名
        System.out.println(arrive);

        long timeuse = System.currentTimeMillis();
        if(timeuse>1){
            System.out.println("超时");
        }
        System.out.println(timeuse);

        String sql = "select * from admin where Name =" + "'" + arrive + "'" ;
        String sq2 = "select Number from admin where Name =" + "'" + arrive + "'" ;//把这个改为打卡为更新
        List rows = jdbcTemplate.queryForList(sql);//通过数据库来查找
        Iterator it = rows.iterator();
        while (it.hasNext()){
            Map userMap = (Map) it.next();
            String Name = (String) userMap.get("Name");
            if(Name.equals(arrive)){

                pd = true;
                String numberstring = jdbcTemplate.queryForObject(sq2,java.lang.String.class);
                Integer number = Integer.parseInt(numberstring);
                number--;
                String sql3use = "update admin set Number ="+"'"+number.toString()+"'"+"where Name="+"'"+arrive+"'";
                jdbcTemplate.update(sql3use);

            }
        }
        if(pd){
            model.addAttribute("打卡","打卡成功");
            pd = false;
        }else {
            model.addAttribute("打卡","未预约，打卡失败");
        }




        //        try {
//             a = jdbcTemplate.execute(sql);
//            model.addAttribute("打卡","打卡成功");
//        }catch(Exception e){
//            model.addAttribute("打卡","打卡失败");
//
//        }

      return "index";
    }

}
