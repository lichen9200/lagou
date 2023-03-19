package com.lagou.service.impl;

import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lagou.dao.TestMapper;

import java.util.List;
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Override
    public List<Test> findAllTest() {
        System.out.println("到这里调用没有？？？service！！！");
       // testMapper.testHH();
        List<Test> allTest= testMapper.findAllTest();
        return allTest;
    }
}
