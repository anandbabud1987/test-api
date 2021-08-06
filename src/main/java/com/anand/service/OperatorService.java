package com.anand.service;

import com.anand.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {
    @Cacheable
    public int add(int left, int right) {
        return left + right;
    }

    @Cacheable
    public int subtract(int left, int right) {
        return left - right;
    }

    @Cacheable
    public int multiply(int left, int right) {
        return left * right;
    }

    @Cacheable
    public int divide(int left, int right) {
        return left / right;
    }
}
