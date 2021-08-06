package com.anand.orchestration;

import com.anand.annotation.Orchestration;
import com.anand.model.OperatorRequest;
import com.anand.service.OperatorService;
import lombok.AllArgsConstructor;

import static com.anand.constants.WebConstants.*;

@Orchestration
@AllArgsConstructor
public class OperatorOrchestration {
    private OperatorService operatorService;

    public int doOperation(OperatorRequest operatorRequest) {
        int result = 0;
        switch (operatorRequest.getOperator().getOprt()) {
            case PLUS:
                result = operatorService.add(operatorRequest.getLeft(), operatorRequest.getRight());
                break;
            case MINUS:
                result = operatorService.subtract(operatorRequest.getLeft(), operatorRequest.getRight());
                break;
            case MULTIPLY:
                result = operatorService.multiply(operatorRequest.getLeft(), operatorRequest.getRight());
                break;
            case DIVIDE:
                result = operatorService.divide(operatorRequest.getLeft(), operatorRequest.getRight());
                break;
        }
        return result;
    }
}
