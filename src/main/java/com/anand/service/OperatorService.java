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

    public String buildResponse(int left,int right,String operator,int result){
        String responseOperator="";
        String equalTo="=";
        StringBuilder sb=new StringBuilder();
        if("plus".equalsIgnoreCase(operator)){
            responseOperator="+";
        }
        if("multiply".equalsIgnoreCase(operator)){
            responseOperator="*";
        }
        if("minus".equalsIgnoreCase(operator)){
            responseOperator="-";
        }
        if("divide".equalsIgnoreCase(operator)){
            responseOperator="/";
        }
        return sb.append(left)
                .append(responseOperator)
                .append(right)
                .append(equalTo)
                .append(result).toString();
    }
}
