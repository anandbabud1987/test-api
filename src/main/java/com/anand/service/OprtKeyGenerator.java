package com.anand.service;

import com.anand.model.OperatorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;


@Service
public class OprtKeyGenerator implements KeyGenerator {
    Logger logger= LoggerFactory.getLogger(OprtKeyGenerator.class);
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return this.generateKey((OperatorRequest) objects[0]);
    }

    public String generateKey(OperatorRequest input){
        return new StringBuilder().append(input.getLeft())
                .append(input.getRight())
                .append(input.getOperator()).toString();
    }
}
