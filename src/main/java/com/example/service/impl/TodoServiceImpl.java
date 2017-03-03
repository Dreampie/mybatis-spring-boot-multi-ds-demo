package com.example.service.impl;

import com.example.mapper.TodoMapper;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by wangrenhui on 2017/3/3.
 */
@Service
public class TodoServiceImpl implements TodoService {
    @Lazy
    @Autowired
    private TodoMapper todoMapper;

    public void test() {
    }
}
