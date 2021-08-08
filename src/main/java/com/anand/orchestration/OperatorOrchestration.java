package com.anand.orchestration;

import com.anand.annotation.Orchestration;
import com.anand.model.OperatorRequest;
import com.anand.service.OperatorService;
import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

import static com.anand.constants.WebConstants.*;

@Orchestration
@AllArgsConstructor
public class OperatorOrchestration {
    private OperatorService operatorService;

    public String doOperation(OperatorRequest operatorRequest) {
        String result = null;
        int left=operatorRequest.getLeft();
        int right=operatorRequest.getRight();
        switch (operatorRequest.getOperator().getOprt()) {
            case PLUS:
                result=operatorService.buildResponse(left,right,PLUS,operatorService.add(left, right));
                break;
            case MINUS:
                result=operatorService.buildResponse(left,right,MINUS,operatorService.subtract(left, right));
                break;
            case MULTIPLY:
                result=operatorService.buildResponse(left,right,MULTIPLY,operatorService.multiply(left, right));
                break;
            case DIVIDE:
                result=operatorService.buildResponse(left,right,DIVIDE,operatorService.divide(left, right));
                break;
            default:
                result="";
                break;
        }
        return result;
    }
}
