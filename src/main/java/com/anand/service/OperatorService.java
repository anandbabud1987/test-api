package com.anand.service;

import com.anand.model.OperatorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.math.BigInteger;

import static com.anand.config.CacheManagerConfig.USER_CACHE;
import static com.anand.constants.WebConstants.*;

@Service
public class OperatorService {
    Logger LOGGER = LoggerFactory.getLogger(OperatorService.class);


    public String add(BigInteger left, BigInteger right) {
        return buildResponse(left, right, PLUS, left.add(right));
    }

    public String subtract(BigInteger left, BigInteger right) {
        return buildResponse(left, right, MINUS, left.subtract(right));
    }

    public String multiply(BigInteger left, BigInteger right) {
        return buildResponse(left, right, MULTIPLY, left.multiply(right));

    }

    public String divide(BigInteger left, BigInteger right) {
        return buildResponse(left, right, DIVIDE, left.divide(right));

    }

    public String buildResponse(BigInteger left, BigInteger right, String operator, BigInteger result) {
        String responseOperator = "";
        String equalTo = "=";
        StringBuilder sb = new StringBuilder();
        if ("plus".equalsIgnoreCase(operator)) {
            responseOperator = "+";
        }
        if ("multiply".equalsIgnoreCase(operator)) {
            responseOperator = "*";
        }
        if ("minus".equalsIgnoreCase(operator)) {
            responseOperator = "-";
        }
        if ("divide".equalsIgnoreCase(operator)) {
            responseOperator = "/";
        }
        return sb.append(left)
                .append(responseOperator)
                .append(right)
                .append(equalTo)
                .append(result).toString();
    }


    public String doOperation(OperatorRequest operatorRequest) {
        LOGGER.info("value NOT there in cache");
        return doOperationInt(operatorRequest);
    }

    @Cacheable(value = USER_CACHE,keyGenerator = "OprtKeyGenerator")
    public String doOperationInt(OperatorRequest operatorRequest) {
        LOGGER.info("calling real method of doOperationInt");
        BigInteger left = operatorRequest.getLeft();
        BigInteger right = operatorRequest.getRight();
        String result = null;
        switch (operatorRequest.getOperator().getOprt()) {
            case PLUS:
                result = add(left, right);
                break;
            case MINUS:
                result = subtract(left, right);
                break;
            case MULTIPLY:
                result = multiply(left, right);
                break;
            case DIVIDE:
                result = divide(left, right);
                break;
            default:
                result = "";
                break;
        }
        return result;
    }
}
