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

    public int doOperation(OperatorRequest operatorRequest) {
        AtomicInteger result = new AtomicInteger();
        switch (operatorRequest.getOperator().getOprt()) {
            case PLUS:
                result.set(operatorService.add(operatorRequest.getLeft(), operatorRequest.getRight()));
                break;
            case MINUS:
                result.set(operatorService.subtract(operatorRequest.getLeft(), operatorRequest.getRight()));
                break;
            case MULTIPLY:
                result.set(operatorService.multiply(operatorRequest.getLeft(), operatorRequest.getRight()));
                break;
            case DIVIDE:
                result.set(operatorService.divide(operatorRequest.getLeft(), operatorRequest.getRight()));
                break;
        }
        return result.get();
    }
}
