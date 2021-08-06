package com.anand.controller;

import com.anand.model.OperatorRequest;
import com.anand.orchestration.OperatorOrchestration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/operators")
@RestController
public class OperatorController {
    private final OperatorOrchestration operatorOrchestration;

    public OperatorController(OperatorOrchestration operatorOrchestration) {
        this.operatorOrchestration = operatorOrchestration;
    }

    @PostMapping(consumes = "application/json")
    public Integer operator(OperatorRequest operatorRequest) {
        return operatorOrchestration.doOperation(operatorRequest);
    }
}
