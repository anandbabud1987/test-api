package com.anand.service;

import org.springframework.stereotype.Service;

@Service
public class OperatorService {
    public int add(int left, int right) {
        return left + right;
    }

    public int subtract(int left, int right) {
        return left - right;
    }

    public int multiply(int left, int right) {
        return left * right;
    }

    public int divide(int left, int right) {
        return left / right;
    }
}
