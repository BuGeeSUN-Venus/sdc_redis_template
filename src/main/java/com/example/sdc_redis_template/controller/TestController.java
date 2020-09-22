package com.example.sdc_redis_template.controller;

import com.example.sdc_redis_template.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sdc")
public class TestController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @RequestMapping(value = "/mvcTest.do", method = RequestMethod.POST)
    public Object mvcTest(){
        return "ok";
    }



    @RequestMapping(value = "/redisTest.do", method = RequestMethod.POST)
    public Object redisTest(){

        ValueOperations vos = redisTemplate.opsForValue();//操作字符串
        HashOperations hos = redisTemplate.opsForHash();//操作hash
        ListOperations los = redisTemplate.opsForList();//操作list
        SetOperations sos =  redisTemplate.opsForSet();//操作set
        ZSetOperations zos = redisTemplate.opsForZSet();//操作有序set

        vos.append("string-class","孙德超");
        hos.put("map-class","map","唐僧");
        los.leftPush("listLeft-class","张飞");
        los.rightPush("listRight-class","刘备");
        sos.add("set-class","曹操");


        redisTemplate.boundValueOps("string").set("孙德超");

        redisTemplate.boundSetOps("set").add("曹操");

        /**
         * 右压栈：后添加的对象排在后边，相当于队列，相当于先进先出
         */
        redisTemplate.boundListOps("listRight").rightPush("刘备");
        /**
         * 左压栈：后添加的对象排在前边,相当于栈，先进后出
         */
        redisTemplate.boundListOps("listLeft").leftPush("张飞");

        redisTemplate.boundHashOps("map").put("map", "唐僧");

        return "ok";
    }

    @RequestMapping(value = "/readRedisTest.do", method = RequestMethod.POST)
    public Object readRedisTest(){

        ValueOperations vos = redisTemplate.opsForValue();//操作字符串
        HashOperations hos = redisTemplate.opsForHash();//操作hash
        ListOperations los = redisTemplate.opsForList();//操作list
        SetOperations sos =  redisTemplate.opsForSet();//操作set
        ZSetOperations zos = redisTemplate.opsForZSet();//操作有序set

        System.out.println("string-class--"+vos.get("string-class"));
        System.out.println("map-class--"+hos.get("map-class","map").toString());
        System.out.println("listLeft-class--"+los.range("listLeft-class",0,1).toString());
        System.out.println("listRight-class--"+los.range("listRight-class",0,1).toString());
        System.out.println("set-class--"+sos.members("set-class").toString());
        System.out.println("******************************************************");
        System.out.println("string--"+ redisTemplate.boundValueOps("string").get());
        System.out.println("map--"+redisTemplate.boundHashOps("map").get("map").toString());
        System.out.println("listLeft--"+redisTemplate.boundListOps("listLeft").range(0,1).toString());
        System.out.println("listRight--"+redisTemplate.boundListOps("listRight").range(0,1).toString());
        System.out.println("set--"+ redisTemplate.boundSetOps("set").members().toString());

        return "ok";
    }


}
