package com.example.service.impl;

import com.example.mapper.ETLTodoMapper;
import com.example.service.ETLTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by wangrenhui on 2017/3/3.
 */
@Service
public class ETLTodoServiceImpl implements ETLTodoService {
    @Lazy
    @Autowired
    private ETLTodoMapper etlTodoMapper;

    public void test() {
    }
}
