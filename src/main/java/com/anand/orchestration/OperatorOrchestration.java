package com.anand.orchestration;

import com.anand.annotation.Orchestration;
import com.anand.model.OperatorRequest;
import com.anand.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;


@Orchestration
public class OperatorOrchestration {
    private OperatorService operatorService;

    @Autowired
    public OperatorOrchestration(OperatorService operatorService) {
        this.operatorService = operatorService;
    }


    public String doOperation(OperatorRequest operatorRequest) {
        return operatorService.doOperation(operatorRequest);
    }
}
