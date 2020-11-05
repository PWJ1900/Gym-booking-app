//package com.example.serviceuse.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//@Controller
//public class SqlController {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostMapping("/welcome")
//    public String getDbType(){
//        String sql = "select * from user";
//        String sql2 = "insert into user values(5,'34','454','56','65','30','54435')";
//        jdbcTemplate.execute(sql);
//        jdbcTemplate.execute(sql2);
//        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
//        for (Map<String, Object> map : list) {
//            Set<Map.Entry<String, Object>> entries = map.entrySet( );
//            if(entries != null) {
//                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
//                while(iterator.hasNext( )) {
//                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
//                    Object key = entry.getKey( );
//                    Object value = entry.getValue();
//                    System.out.println(key+":"+value);
//                }
//            }
//        }
//        System.out.println(list);
//        return "weclome";
//    }
//
////    @RequestMapping("/user/{id}")
////    public Map<String,Object> getUser(@PathVariable String id){
////        Map<String,Object> map = null;
////
////        List<Map<String, Object>> list = getDbType();
////
////        for (Map<String, Object> dbmap : list) {
////
////            Set<String> set = dbmap.keySet();
////
////            for (String key : set) {
////                if(key.equals("id")){
////                    if(dbmap.get(key).equals(id)){
////                        map = dbmap;
////                    }
////                }
////            }
////        }
////
////        if(map==null)
////            map = list.get(0);
////        return map;
////    }
//
//}