package com.lagou.controller;

import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController   //ResponeBody+controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/findAllTest")
    public List<Test> findAllTest(){
        System.out.println("成功没啊。。。。操");
        List<Test> allTest =testService.findAllTest();
        return allTest;
    }
}
